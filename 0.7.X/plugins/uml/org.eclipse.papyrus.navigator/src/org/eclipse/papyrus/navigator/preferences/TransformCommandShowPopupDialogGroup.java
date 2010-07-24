/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigator.preferences;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.papyrus.preferences.ui.AbstractGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;


public class TransformCommandShowPopupDialogGroup extends AbstractGroup {

	private static final String SHOW_POPUP_DIALOG_GROUP_TITLE = "Transform into Action";

	private static final String SHOW_POPUP_DIALOG_GROUP_MESSAGE = "Do not show popup dialog when transform command is performed";

	/** Editor for deciding to show the warning popup */
	private BooleanFieldEditor showPopupDialogBooleanFieldEditor;

	/**
	 * Creation of an ActivityEdgeLabelVisibilityGroup Composite.
	 * 
	 * @param parent
	 *        the parent of the composite
	 * @param dialogPage
	 *        to set the page in field editor
	 * @param title
	 *        the title
	 */
	public TransformCommandShowPopupDialogGroup(Composite parent, String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
		createContent(parent);
	}

	/**
	 * Creates the content.
	 * 
	 * @param parent
	 *        the parent
	 */
	public void createContent(Composite parent) {
		Group visibilityGroup = new Group(parent, SWT.SCROLL_PAGE);
		visibilityGroup.setLayout(new GridLayout());
		visibilityGroup.setText(SHOW_POPUP_DIALOG_GROUP_TITLE);

		// field for name label visibility
		showPopupDialogBooleanFieldEditor = new BooleanFieldEditor(INavigatorPreferenceConstants.PREF_NAVIGATOR_TRANSFORM_INTO_SHOW_POPUP, SHOW_POPUP_DIALOG_GROUP_MESSAGE, visibilityGroup);
		showPopupDialogBooleanFieldEditor.setPage(dialogPage);

		addFieldEditor(showPopupDialogBooleanFieldEditor);

	}
}
