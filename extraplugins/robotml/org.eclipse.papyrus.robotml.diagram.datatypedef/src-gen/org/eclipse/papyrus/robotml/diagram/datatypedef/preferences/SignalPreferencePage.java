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
package org.eclipse.papyrus.robotml.diagram.datatypedef.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.robotml.diagram.datatypedef.edit.part.DatatypeDefEditPart;

public class SignalPreferencePage extends DatatypeDefNodePreferencePage {

	public static String prefKey = DatatypeDefEditPart.DIAGRAM_ID + "_Signal";

	/**
	 * the list of the compartments for this node
	 */
	public static final String compartments[] = { "AttributeCompartment" };

	public SignalPreferencePage() {
		super();
		setPreferenceKey(DatatypeDefEditPart.DIAGRAM_ID + "_Signal"); //$NON-NLS-1$
	}

	public static void initDefaults(IPreferenceStore store) {
		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.WIDTH), 100);
		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.HEIGHT), 100);
		// set the true value for the compartment visibility
		for(String name : compartments) {
			String preferenceName = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, name, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
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
