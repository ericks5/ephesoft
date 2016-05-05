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

package com.ephesoft.gxt.admin.client.view.mapping;

import com.ephesoft.gxt.admin.client.controller.BatchClassManagementController.BatchClassManagementEventBus;
import com.ephesoft.gxt.admin.client.event.AddDBExportMappingEvent;
import com.ephesoft.gxt.admin.client.event.DeleteDBExportMappingEvent;
import com.ephesoft.gxt.admin.client.event.ResetDBExportMappingEvent;
import com.ephesoft.gxt.admin.client.event.TableMappingOpenEvent;
import com.ephesoft.gxt.admin.client.i18n.BatchClassConstants;
import com.ephesoft.gxt.admin.client.presenter.mapping.DatabaseExportMenuPresenter;
import com.ephesoft.gxt.admin.client.view.BatchClassInlineView;
import com.ephesoft.gxt.admin.client.view.BatchClassManagementMenuBar;
import com.ephesoft.gxt.core.client.ui.widget.CustomMenuItem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.ephesoft.gxt.core.client.i18n.LocaleDictionary;

public class DatabaseExportMenuView extends BatchClassInlineView<DatabaseExportMenuPresenter> {

	@UiField
	protected BatchClassManagementMenuBar dbExportMenuBar;

	interface Binder extends UiBinder<Widget, DatabaseExportMenuView> {
	}

	private static final Binder binder = GWT.create(Binder.class);

	private CustomMenuItem dlfViewMenuItem, tablesViewMenuItem;

	public DatabaseExportMenuView() {
		initWidget(binder.createAndBindUi(this));
		dlfViewMenuItem = new CustomMenuItem(LocaleDictionary.getConstantValue(BatchClassConstants.DLF_MAPPINGS), getDLFViewOpenCommand());
		tablesViewMenuItem = new CustomMenuItem(LocaleDictionary.getConstantValue(BatchClassConstants.TABLE_MAPPINGS), getTableMappingOpenCommand());
		CustomMenuItem addMenuItem = new CustomMenuItem(LocaleDictionary.getConstantValue(BatchClassConstants.ADD_BUTTON), getAddCommand());
		CustomMenuItem deleteMenuItem = new CustomMenuItem(LocaleDictionary.getConstantValue(BatchClassConstants.DELETE), getDeleteCommand());
		CustomMenuItem resetMenuItem = new CustomMenuItem(LocaleDictionary.getConstantValue(BatchClassConstants.RESET), getResetCommand());
		dbExportMenuBar.removeOpenMenuItem();
		dbExportMenuBar.addItem(addMenuItem);
		dbExportMenuBar.addItem(deleteMenuItem);
		dbExportMenuBar.addItem(resetMenuItem);
		dbExportMenuBar.addItem(dlfViewMenuItem);
		dbExportMenuBar.addItem(tablesViewMenuItem);
		dbExportMenuBar.setFocusOnHoverEnabled(false);
	}

	public void setDefaultSelection() {
		tablesViewMenuItem.removeStyleName("selected-Menu");
		dlfViewMenuItem.addStyleName("selected-Menu");
	}

	private ScheduledCommand getAddCommand() {
		ScheduledCommand command = new ScheduledCommand() {

			@Override
			public void execute() {
				BatchClassManagementEventBus.fireEvent(new AddDBExportMappingEvent());
			}
		};
		return command;
	}

	private ScheduledCommand getTableMappingOpenCommand() {
		return new ScheduledCommand() {

			@Override
			public void execute() {
				dlfViewMenuItem.removeStyleName("selected-Menu");
				tablesViewMenuItem.addStyleName("selected-Menu");
				BatchClassManagementEventBus.fireEvent(new TableMappingOpenEvent(true));
			}
		};
	}

	private ScheduledCommand getDLFViewOpenCommand() {
		return new ScheduledCommand() {

			@Override
			public void execute() {
				tablesViewMenuItem.removeStyleName("selected-Menu");
				dlfViewMenuItem.addStyleName("selected-Menu");
				BatchClassManagementEventBus.fireEvent(new TableMappingOpenEvent(false));
			}
		};
	}

	private ScheduledCommand getResetCommand() {
		return new ScheduledCommand() {

			@Override
			public void execute() {
				BatchClassManagementEventBus.fireEvent(new ResetDBExportMappingEvent());
			}
		};
	}

	private ScheduledCommand getDeleteCommand() {
		ScheduledCommand command = new ScheduledCommand() {

			@Override
			public void execute() {
				BatchClassManagementEventBus.fireEvent(new DeleteDBExportMappingEvent());
			}
		};
		return command;
	}

}
