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

package com.ephesoft.gxt.admin.client.presenter.document.testclassification;

import com.ephesoft.gxt.admin.client.controller.BatchClassManagementController;
import com.ephesoft.gxt.admin.client.controller.BatchClassManagementController.BatchClassManagementEventBus;
import com.ephesoft.gxt.admin.client.event.ClearTestClassificationGridEvent;
import com.ephesoft.gxt.admin.client.event.OnTestClassificationEvent;
import com.ephesoft.gxt.admin.client.event.TestClassificationClearMenuItemEnableEvent;
import com.ephesoft.gxt.admin.client.event.TestClassificationDownloadEnableEvent;
import com.ephesoft.gxt.admin.client.i18n.BatchClassConstants;
import com.ephesoft.gxt.admin.client.i18n.BatchClassMessages;
import com.ephesoft.gxt.admin.client.presenter.BatchClassInlinePresenter;
import com.ephesoft.gxt.admin.client.view.document.testclassification.TestClassificationMenuView;
import com.ephesoft.gxt.core.client.i18n.LocaleDictionary;
import com.ephesoft.gxt.core.client.ui.widget.listener.DialogAdapter;
import com.ephesoft.gxt.core.client.ui.widget.window.ConfirmationDialog;
import com.ephesoft.gxt.core.client.ui.widget.window.DialogIcon;
import com.ephesoft.gxt.core.client.util.DialogUtil;
import com.ephesoft.gxt.core.shared.util.StringUtil;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.EventHandler;

public class TestClassificationMenuPresenter extends BatchClassInlinePresenter<TestClassificationMenuView> {

	public TestClassificationMenuPresenter(BatchClassManagementController controller, TestClassificationMenuView view) {
		super(controller, view);
		// testClassificationFolderEmptyCheck();
		// enableDownload(false);
	}

	interface CustomEventBinder extends EventBinder<TestClassificationMenuPresenter> {
	}

	private static final CustomEventBinder eventBinder = GWT.create(CustomEventBinder.class);

	@EventHandler
	public void enableOrDisbaleClear(TestClassificationClearMenuItemEnableEvent enableEvent) {
		testClassificationFolderEmptyCheck();
	}

	@EventHandler
	public void enableOrDisbaleDownload(TestClassificationDownloadEnableEvent enableEvent) {
		enableDownload(enableEvent.isEnable());
	}

	private void enableDownload(boolean isEnable) {
		view.enableDownloadMenuItem(isEnable);
	}

	private void testClassificationFolderEmptyCheck() {
		String batchClassID = controller.getSelectedBatchClass().getIdentifier();
		controller.getRpcService().isClassificationFolderEmpty(batchClassID, new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean isEmpty) {
				if (isEmpty) {
					view.enableClearMenuItem(false);

				} else {
					view.enableClearMenuItem(true);
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				view.enableClearMenuItem(false);
			}
		});
	}

	public void onClassify() {
		BatchClassManagementEventBus.fireEvent(new OnTestClassificationEvent());
	}

	@Override
	public void bind() {

	}

	@Override
	public void injectEvents(EventBus eventBus) {
		eventBinder.bindEventHandlers(this, eventBus);
	}

	public void onClear() {
		final ConfirmationDialog confirmationDialog = DialogUtil.showConfirmationDialog(
				LocaleDictionary.getConstantValue(BatchClassConstants.CONFIRMATION),
				LocaleDictionary.getMessageValue(BatchClassMessages.CLEAR_CONFIRMATION_MESSAGE), false, DialogIcon.QUESTION_MARK);
		confirmationDialog.setDialogListener(new DialogAdapter() {

			@Override
			public void onOkClick() {
				confirmationDialog.hide();
				BatchClassManagementEventBus.fireEvent(new ClearTestClassificationGridEvent());
				String batchClassID = controller.getSelectedBatchClass().getIdentifier();

				controller.getRpcService().clearClassificationFolder(batchClassID, new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {
						testClassificationFolderEmptyCheck();
						enableDownload(false);
					}

					@Override
					public void onFailure(Throwable error) {
						String localizedMessage = error.getLocalizedMessage();
						if (null != localizedMessage) {
							DialogUtil.showMessageDialog(LocaleDictionary.getConstantValue(BatchClassConstants.ERROR_TITLE),
									localizedMessage, DialogIcon.ERROR);
						} else {
							DialogUtil.showMessageDialog(LocaleDictionary.getConstantValue(BatchClassConstants.ERROR_TITLE),
									LocaleDictionary.getMessageValue(BatchClassMessages.UNABLE_TO_CLEAR_FOLDER), DialogIcon.ERROR);
						}
						testClassificationFolderEmptyCheck();
						view.enableDownloadMenuItem(false);
					}
				});
			}

			@Override
			public void onCancelClick() {
				confirmationDialog.hide();

			}

			@Override
			public void onCloseClick() {
				confirmationDialog.hide();

			}

		});

	}

	public void onDownload() {
		view.submitExportFormPanel();
	}

	public String getDownloadUrl(String downloadAction) {
		String downloadFormAction = "batchClassIdentifier=" + controller.getSelectedBatchClass().getIdentifier();
		downloadFormAction = StringUtil.concatenate(downloadAction, downloadFormAction);
		return downloadFormAction;
	}
}
