/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.preferences;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.ScaleFieldEditor;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.AbstractGroup;
import org.eclipse.papyrus.uml.diagram.common.ui.helper.HelpComponentFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Group use to set the opacity of a compartment of a group
 * 
 * @author adaussy
 * 
 */
public class OpacityGroup extends AbstractGroup {

	/**
	 * Name of the preferance to set
	 */
	protected String preferenceName;

	public OpacityGroup(Composite parent, String key, DialogPage dialogPage, String preferenceName) {
		super(parent, key, dialogPage);
		this.preferenceName = preferenceName;
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
		/*
		 * TODO Refactor layout (help component at the end of the line)
		 */
		visibilityGroup.setLayout(new GridLayout());
		visibilityGroup.setText("Opacity of the compartment");
		ScaleFieldEditor alphaEditor = new ScaleFieldEditor(preferenceName, "Opacity", visibilityGroup, 0, 255, 5, 20);
		alphaEditor.setPage(dialogPage);
		addFieldEditor(alphaEditor);
		HelpComponentFactory.createHelpComponent(visibilityGroup, new FormToolkit(parent.getDisplay()), "Set to min to make the compartment totally transparent");
	}
}
