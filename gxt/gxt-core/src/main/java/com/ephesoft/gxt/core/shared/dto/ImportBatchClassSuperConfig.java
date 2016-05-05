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

package com.ephesoft.gxt.core.shared.dto;

import java.util.ArrayList;
import java.util.List;

import com.ephesoft.gxt.core.shared.importTree.Node;
import com.google.gwt.user.client.rpc.IsSerializable;

public class ImportBatchClassSuperConfig implements IsSerializable {

	private Node uiConfigRoot;
	private List<UNCFolderConfig> uncFolderConfigList;

	public ImportBatchClassSuperConfig() {
		super();
		this.uncFolderConfigList = new ArrayList<UNCFolderConfig>();
		this.uiConfigRoot = new Node();
	}

	public ImportBatchClassSuperConfig(List<UNCFolderConfig> uncFolderConfig, Node uiConfigList) {
		super();
		this.uncFolderConfigList = uncFolderConfig;
		this.uiConfigRoot = uiConfigList;
	}

	public List<UNCFolderConfig> getUncFolderConfigList() {
		return uncFolderConfigList;
	}

	public void setUncFolderConfigList(List<UNCFolderConfig> uncFolderConfig) {
		this.uncFolderConfigList = uncFolderConfig;
	}

	public Node getUiConfigRoot() {
		return uiConfigRoot;
	}

	public void setUiConfigRoot(Node uiConfigRoot) {
		this.uiConfigRoot = uiConfigRoot;
	}

	public void addUncFolderConfig(final String identifier, final String batchClassName, final String uncFolder) {
		if (uncFolderConfigList == null) {
			uncFolderConfigList = new ArrayList<UNCFolderConfig>();
		}
		UNCFolderConfig uncFolderConfig = new UNCFolderConfig();
		uncFolderConfigList.add(uncFolderConfig);
		uncFolderConfig.setBatchClassId(identifier);
		uncFolderConfig.setBatchClassName(batchClassName);
		uncFolderConfig.setUncFolder(uncFolder);
	}

	public void addUncFolderConfig(final String batchCLassIdentifier, final String batchClassName, final String batchClassUNCFolder,
			final String batchClassDescription, final int batchClassPriority) {
		if (uncFolderConfigList == null) {
			uncFolderConfigList = new ArrayList<UNCFolderConfig>();
		}
		UNCFolderConfig uncFolderConfig = new UNCFolderConfig();
		uncFolderConfigList.add(uncFolderConfig);
		uncFolderConfig.setBatchClassId(batchCLassIdentifier);
		uncFolderConfig.setBatchClassName(batchClassName);
		uncFolderConfig.setUncFolder(batchClassUNCFolder);
		uncFolderConfig.setBatchClassDescription(batchClassDescription);
		uncFolderConfig.setBatchClassPriority("" + batchClassPriority);
	}

}
