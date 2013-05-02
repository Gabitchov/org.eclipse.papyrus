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
 * Preference group to define whether the specific keyword of the descendant of
 * structured activity node has to be displayed of not
 * 
 * @author adaussy
 * 
 */
public class SpecificKeywordStructuredActivityNodeVisibility extends AbstractGroup {

	public enum ElementType {
		LOOP_NODE, CONDITIONAL_NODE, SEQUENCE_NODE
	}

	/**
	 * if true then display the specific label
	 */
	private BooleanFieldEditor specificKeywordVisibility;

	/**
	 * Type of the element
	 */
	private ElementType type;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param key
	 * @param dialogPage
	 */
	public SpecificKeywordStructuredActivityNodeVisibility(Composite parent, String key, DialogPage dialogPage, ElementType type) {
		super(parent, key, dialogPage);
		this.type = type;
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
		visibilityGroup.setText(CustomMessages.SpecificKeywordStructuredActivityNodeVisibility_visibility);
		String preferenceName;
		switch(this.type) {
		case LOOP_NODE:
			preferenceName = IActivityPreferenceConstants.PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_LOOP_NODE;
			break;
		case CONDITIONAL_NODE:
			preferenceName = IActivityPreferenceConstants.PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_CONDITIONAL_NODE;
			break;
		case SEQUENCE_NODE:
			preferenceName = IActivityPreferenceConstants.PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_SEQUENCE_NODE;
			break;
		default:
			preferenceName = "";
			break;
		}
		specificKeywordVisibility = new BooleanFieldEditor(preferenceName, CustomMessages.StructuredActivityNodePreferencePage_showSpecificKeyword, visibilityGroup);
		specificKeywordVisibility.setPage(dialogPage);
		addFieldEditor(specificKeywordVisibility);
	}
}
