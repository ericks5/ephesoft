/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2015 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

//
// JODConverter - Java OpenDocument Converter
// Copyright 2009 Art of Solving Ltd
// Copyright 2004-2009 Mirko Nasato
//
// JODConverter is free software: you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public License
// as published by the Free Software Foundation, either version 3 of
// the License, or (at your option) any later version.
//
// JODConverter is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General
// Public License along with JODConverter.  If not, see
// <http://www.gnu.org/licenses/>.
//
package org.artofsolving.jodconverter.office;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.sun.star.beans.XPropertySet;
import com.sun.star.bridge.XUnoUrlResolver;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.connection.NoConnectException;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;

/**
 * Connection details are managed here
 * 
 * @author Ephesoft
 * 
 */
class OfficeConnection implements OfficeContext {

	// private static AtomicInteger bridgeIndex = new AtomicInteger();

	private final UnoUrl unoUrl;

	// private XComponent bridgeComponent;
	private XMultiComponentFactory serviceManager;
	private volatile XComponentContext componentContext;

	private final List<OfficeConnectionEventListener> connectionEventListeners = new ArrayList<OfficeConnectionEventListener>();

	private volatile boolean connected = false;

	// private XEventListener bridgeListener = new XEventListener() {
	//
	// public void disposing(EventObject event) {
	// if (connected) {
	// connected = false;
	// logger.info(String.format("disconnected: '%s'", unoUrl));
	// OfficeConnectionEvent connectionEvent = new OfficeConnectionEvent(OfficeConnection.this);
	// for (OfficeConnectionEventListener listener : connectionEventListeners) {
	// listener.disconnected(connectionEvent);
	// }
	// }
	// // else we tried to connect to a server that doesn't speak URP
	// }
	// };

	private final Logger logger = Logger.getLogger(getClass().getName());

	public OfficeConnection(UnoUrl unoUrl) {
		this.unoUrl = unoUrl;
	}

	public void addConnectionEventListener(OfficeConnectionEventListener connectionEventListener) {
		connectionEventListeners.add(connectionEventListener);
	}

	public void connect() throws ConnectException {
		logger.fine(String.format("connecting with connectString '%s'", unoUrl));
		try {

			XComponentContext localContext = Bootstrap.createInitialComponentContext(null);
			XMultiComponentFactory localServiceManager = localContext.getServiceManager();

			Object urlResolver = localServiceManager.createInstanceWithContext("com.sun.star.bridge.UnoUrlResolver", localContext);
			XUnoUrlResolver unoUrlResolver = (XUnoUrlResolver) UnoRuntime.queryInterface(XUnoUrlResolver.class, urlResolver);
			Object initialObject = unoUrlResolver.resolve(unoUrl.getConnectString());
			XPropertySet properties = (XPropertySet) UnoRuntime.queryInterface(XPropertySet.class, initialObject);

			componentContext = OfficeUtils.cast(XComponentContext.class, properties.getPropertyValue("DefaultContext"));
			serviceManager = componentContext.getServiceManager();
			connected = true;
			logger.info(String.format("connected: '%s'", unoUrl));
			OfficeConnectionEvent connectionEvent = new OfficeConnectionEvent(this);
			for (OfficeConnectionEventListener listener : connectionEventListeners) {
				listener.connected(connectionEvent);
			}
		} catch (NoConnectException connectException) {
			throw new ConnectException(String.format("connection failed: '%s'; %s", unoUrl, connectException.getMessage()));
		} catch (Exception exception) {
			throw new OfficeException("connection failed: " + unoUrl, exception);
		}
	}

	public boolean isConnected() {
		return connected;
	}

	public synchronized void disconnect() {
		logger.fine(String.format("disconnecting: '%s'", unoUrl));
		((XComponent) componentContext).dispose();
	}

	public Object getService(String serviceName) {

		try {
			return serviceManager.createInstanceWithContext(serviceName, componentContext);
		} catch (Exception exception) {
			// Following new Exception was created to cater the need to uniquely identify open office shut down during mail processing. 
			throw new ServiceManagerFailException(String.format("failed to obtain service '%s'", serviceName), exception);
		}
	}

}
