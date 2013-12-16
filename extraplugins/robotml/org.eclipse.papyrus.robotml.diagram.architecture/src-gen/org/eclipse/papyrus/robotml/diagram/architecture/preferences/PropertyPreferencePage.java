/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.robotml.diagram.architecture.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.robotml.diagram.architecture.edit.part.ArchitectureDiagramEditPart;

public class PropertyPreferencePage extends ArchitectureDiagramNodePreferencePage {

	public static String prefKey = ArchitectureDiagramEditPart.DIAGRAM_ID + "_Property";

	/**
	 * the list of the compartments for this node
	 */
	public static final String compartments[] = { "PropertyPartCompartment" };

	public PropertyPreferencePage() {
		super();
		setPreferenceKey(ArchitectureDiagramEditPart.DIAGRAM_ID + "_Property"); //$NON-NLS-1$
	}

	public static void initDefaults(IPreferenceStore store) {
		// set the true value for the compartment visibility
		for(String name : compartments) {
			String preferenceName = PreferencesConstantsHelper.getCompartmentElementConstant(prefKey, name, PreferencesConstantsHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(preferenceName, true);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage#initializeCompartmentsList()
	 * 
	 */
	@Override
	protected void initializeCompartmentsList() {
		for(String name : compartments) {
			this.compartmentsList.add(name);
		}
	}
}
