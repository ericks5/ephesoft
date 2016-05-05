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

package com.ephesoft.gxt.admin.client.view.batchclassfield;

import com.ephesoft.gxt.admin.client.presenter.batchclassfield.BatchClassFieldPresenter;
import com.ephesoft.gxt.admin.client.view.BatchClassCompositeView;
import com.ephesoft.gxt.admin.client.view.BatchClassInlineView;

/**
 * This View deals with Batch Class Fields.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.gxt.admin.client.view.batchclassfield.BatchClassFieldView
 */
public class BatchClassFieldView extends BatchClassCompositeView<BatchClassFieldPresenter> {

	/** The batch class field grid view. */
	private final BatchClassFieldGridView bcFieldGridView;

	/** The batch class field menu view. */
	public BatchClassFieldMenuView bcFieldMenuView;

	/**
	 * Instantiates a new batch class field view.
	 */
	public BatchClassFieldView() {
		bcFieldGridView = new BatchClassFieldGridView();
		bcFieldMenuView = new BatchClassFieldMenuView();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ephesoft.gxt.admin.client.view.BatchClassCompositeView#getOptionsPanelView()
	 */
	@Override
	public BatchClassInlineView<?> getOptionsPanelView() {
		return bcFieldMenuView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ephesoft.gxt.admin.client.view.BatchClassCompositeView#getBottomPanelView()
	 */
	@Override
	public BatchClassInlineView<?> getBottomPanelView() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ephesoft.gxt.admin.client.view.BatchClassCompositeView#getListPanelView()
	 */
	@Override
	public BatchClassInlineView<?> getListPanelView() {
		return bcFieldGridView;
	}

	/**
	 * Gets the batch class field grid view.
	 * 
	 * @return the batch class field grid view
	 */
	public BatchClassFieldGridView getBCFieldGridView() {
		return bcFieldGridView;
	}

	/**
	 * Gets the batch class field menu view.
	 * 
	 * @return the batch class field menu view
	 */
	public BatchClassFieldMenuView getBCFieldMenuView() {
		return bcFieldMenuView;
	}
	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}
}