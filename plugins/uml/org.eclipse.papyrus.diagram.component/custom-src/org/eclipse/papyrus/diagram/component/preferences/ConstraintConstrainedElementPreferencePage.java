/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.diagram.component.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

// TODO: Auto-generated Javadoc
/**
 * The Class ConstraintConstrainedElementPreferencePage.
 *
 * @generated
 */
public class ConstraintConstrainedElementPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * Instantiates a new constraint constrained element preference page.
	 *
	 * @generated
	 */
	public ConstraintConstrainedElementPreferencePage() {
		super();
		setPreferenceKey(ComponentDiagramEditPart.MODEL_ID + "_ConstraintConstrainedElement");
	}

	/**
	 * Gets the bundle id.
	 *
	 * @return the bundle id
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	/**
	 * Inits the defaults.
	 *
	 * @param store the store
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {

	}

}
