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

package com.ephesoft.gxt.systemconfig.client.view.application.regexbuilder;

import com.ephesoft.gxt.core.client.i18n.LocaleDictionary;
import com.ephesoft.gxt.core.client.ui.widget.CustomMenuBar;
import com.ephesoft.gxt.core.client.ui.widget.CustomMenuItem;
import com.ephesoft.gxt.core.client.util.WidgetUtil;
import com.ephesoft.gxt.systemconfig.client.i18n.SystemConfigConstants;
import com.ephesoft.gxt.systemconfig.client.presenter.application.regexbuilder.RegexBuilderToolBarPresenter;
import com.ephesoft.gxt.systemconfig.client.regexbuilder.RegexBuilderConstants;
import com.ephesoft.gxt.systemconfig.client.view.SystemConfigInlineView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * RegexPatternToolBar is the view that shows various buttons for different functionality(like addition and deletion of Regex Patterns
 * on Regex Pattern Grid
 * 
 * @author Ephesoft
 * 
 *         <b>created on</b> 30-Dec-2014 <br/>
 * @version 1.0 $LastChangedDate:$ <br/>
 *          $LastChangedRevision:$ <br/>
 */
public class RegexBuilderToolBar extends SystemConfigInlineView<RegexBuilderToolBarPresenter> {

	/**
	 * 
	 * Interface for the Binder.
	 * 
	 * @author Ephesoft
	 * 
	 *         <b>created on</b> 30-Dec-2014 <br/>
	 * @version $LastChangedDate:$ <br/>
	 *          $LastChangedRevision:$ <br/>
	 */
	interface Binder extends UiBinder<Widget, RegexBuilderToolBar> {
	}

	/**
	 * BINDER {@link Binder}.
	 */
	private static final Binder binder = GWT.create(Binder.class);

	/**
	 * regexPatternToolMenuBarPanel {@link VerticalPanel} instance of VerticalPanel
	 */
	@UiField
	protected VerticalPanel regexBuilderToolMenuBarPanel;

	/**
	 * regexPatternToolMenuBar {@link CustomMenuBar} contains different CustomMenuItems
	 */
	@UiField
	protected CustomMenuBar regexBuilderToolMenuBar;

	/**
	 * addMenuItem {@link CustomMenuItem} used for adding Regex Patterns
	 */
	protected CustomMenuItem addMenuItem;

	/**
	 * removeMenuItem {@link CustomMenuItem} used for deleting Regex Patterns
	 */
	protected CustomMenuItem removeMenuItem;

	/**
	 * resetMenuItem {@link CustomMenuItem} used for deleting Regex Patterns
	 */
	protected CustomMenuItem resetMenuItem;

	protected CustomMenuItem findAllMatchesButton;

	protected CustomMenuItem selectRegexButton;

	/**
	 * instantiate RegexPatternToolBar
	 */
	public RegexBuilderToolBar() {
		super();

		initWidget(binder.createAndBindUi(this));
		intializeMenuItems();
		regexBuilderToolMenuBar.addItem(addMenuItem);
		regexBuilderToolMenuBar.addItem(removeMenuItem);
		regexBuilderToolMenuBar.addItem(resetMenuItem);
		regexBuilderToolMenuBar.addItem(findAllMatchesButton);
		// regexBuilderToolMenuBar.addItem(selectRegexButton);
		intializeSelectionHandlers();
		regexBuilderToolMenuBarPanel.addStyleName("menubarPanelRegexPool");
		setWidgetIds();
		regexBuilderToolMenuBar.addStyleName("menuBarRegexPool");
		regexBuilderToolMenuBar.setFocusOnHoverEnabled(false);
		removeMenuItem.setEnabled(false);
		findAllMatchesButton.setEnabled(false);
	}

	/**
	 * intializeMenuItems is used for initialising the custom menu items and adding the display name to the custom menu items
	 */
	private void intializeMenuItems() {

		removeMenuItem = new CustomMenuItem(new SafeHtml() {

			@Override
			public String asString() {

				return LocaleDictionary.getConstantValue(SystemConfigConstants.REMOVE_REGEX_BUTTON);
			}
		});

		resetMenuItem = new CustomMenuItem(new SafeHtml() {

			@Override
			public String asString() {

				return LocaleDictionary.getConstantValue(SystemConfigConstants.RESET_REGEX_BUTTON);
			}
		});

		addMenuItem = new CustomMenuItem(new SafeHtml() {

			@Override
			public String asString() {

				return LocaleDictionary.getConstantValue(SystemConfigConstants.ADD_REGEX_BUTTON);
			}
		});

		findAllMatchesButton = new CustomMenuItem(new SafeHtml() {

			@Override
			public String asString() {
				return LocaleDictionary.getConstantValue(RegexBuilderConstants.FIND_ALL_MATCHES);
			}
		});

		selectRegexButton = new CustomMenuItem(new SafeHtml() {

			@Override
			public String asString() {
				return LocaleDictionary.getConstantValue(RegexBuilderConstants.SELECT_REGEX);
			}
		});

	}

	/**
	 * intializeSelectionHandlers method used for adding functionality to the custom menu items which in invoked on the click of that
	 * custom menu item
	 */
	private void intializeSelectionHandlers() {

		addMenuItem.setScheduledCommand(new ScheduledCommand() {

			@Override
			public void execute() {
				presenter.addRegexBuilderForm();

			}
		});

		removeMenuItem.setScheduledCommand(new ScheduledCommand() {

			@Override
			public void execute() {
				presenter.removeRegexBuilderForm();
			}
		});

		resetMenuItem.setScheduledCommand(new ScheduledCommand() {

			@Override
			public void execute() {
				presenter.resetRegexBuilderForm();
			}
		});

		findAllMatchesButton.setScheduledCommand(new ScheduledCommand() {

			@Override
			public void execute() {
				presenter.onFindAllMatchesClicked();
			}
		});

		selectRegexButton.setScheduledCommand(new ScheduledCommand() {

			@Override
			public void execute() {
				presenter.onSelectRegexButtonClicked();
			}
		});

	}

	private void setWidgetIds() {
		WidgetUtil.setID(regexBuilderToolMenuBarPanel, "RPTOV_verticalPanel");
		WidgetUtil.setID(regexBuilderToolMenuBar, "RBTOV_menuBar");
	}

	/**
	 * @return the removeButton
	 */
	public CustomMenuItem getRemoveButton() {
		return removeMenuItem;
	}

	/**
	 * Toggle the visibility of select regex button.
	 * 
	 * @param enableSelectRegexButton boolean
	 */
	public void toggleSelectRegexButton(final boolean enableSelectRegexButton) {
		selectRegexButton.setEnabled(enableSelectRegexButton);
	}

	public void toggleFindAllMatchesButton(final boolean enableFindAllMatchesButton) {
		findAllMatchesButton.setEnabled(enableFindAllMatchesButton);
	}

}
