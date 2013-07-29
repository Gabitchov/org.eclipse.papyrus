/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Defines the profile application preference page.
 * 
 * @author Gilles Cannenterre
 * @since 27 oct. 06
 */
// @unused
public class ProfileApplicationPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * The Constructor.
	 */
	// @unused
	public ProfileApplicationPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Profile Application Preferences");
	}

	/**
	 * Creates the field editors.
	 */
	@Override
	public void createFieldEditors() {

		addField(new RadioGroupFieldEditor(UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_APPEARANCE, "Stereotype Name Display Preferences :", 1, new String[][]{ { "UML Compatibility (force lower case for first letter - default)", UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM }, { "User Controlled (let name as entered by user)", UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED } }, getFieldEditorParent()));
	}

	/**
	 * Init.
	 * 
	 * @param workbench
	 *        the workbench
	 */
	public void init(IWorkbench workbench) {
	}

}
