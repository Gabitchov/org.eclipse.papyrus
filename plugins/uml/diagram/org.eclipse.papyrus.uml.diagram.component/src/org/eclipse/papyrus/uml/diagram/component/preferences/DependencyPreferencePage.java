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
package org.eclipse.papyrus.uml.diagram.component.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;

// TODO: Auto-generated Javadoc
/**
 * The Class DependencyPreferencePage.
 * 
 * @generated
 */
public class DependencyPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * Instantiates a new dependency preference page.
	 * 
	 * @generated
	 */
	public DependencyPreferencePage() {
		super();
		setPreferenceKey(ComponentDiagramEditPart.MODEL_ID + "_Dependency");
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
	 * @param store
	 *        the store
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {
	}
}
