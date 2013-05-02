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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.preferences;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.AbstractGroup;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * The Class ActivityEdgeLabelVisibilityGroup contains editor to edit
 * preferences concerning the visibility of labels of an ActivityEdge
 */
public class ActivityEdgeLabelVisibilityGroup extends AbstractGroup {

	/** Editor for deciding to show the name label */
	private BooleanFieldEditor showNameLabelBooleanFieldEditor;

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
	public ActivityEdgeLabelVisibilityGroup(Composite parent, String title, DialogPage dialogPage) {
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
		visibilityGroup.setText(CustomMessages.ActivityEdgePreferencePage_visibilityGroup);
		// field for name label visibility
		showNameLabelBooleanFieldEditor = new BooleanFieldEditor(IActivityPreferenceConstants.PREF_ACTIVITY_EDGE_SHOW_NAME_LABEL, CustomMessages.ActivityEdgePreferencePage_showName, visibilityGroup);
		showNameLabelBooleanFieldEditor.setPage(dialogPage);
		addFieldEditor(showNameLabelBooleanFieldEditor);
	}
}
