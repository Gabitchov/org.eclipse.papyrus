/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.composite.part.Messages;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;

public class BlockPreferencePage extends InternalBlockDiagramNodePreferencePage {

	/**
	 * the list of the compartments for this node
	 */
	public static final String compartments[] = { Messages.ClassCompositeCompartmentEditPart_title };;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public BlockPreferencePage() {
		super();
		setPreferenceKey(InternalBlockDiagramEditPart.DIAGRAM_ID + "_Class"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param store
	 */
	public static void initDefaults(IPreferenceStore store) {

		String key = InternalBlockDiagramEditPart.DIAGRAM_ID + "_Class";
		// set the true value for the compartment visibility
		for(String name : compartments) {
			String preferenceName = PreferenceConstantHelper.getCompartmentElementConstant(key, name, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
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
