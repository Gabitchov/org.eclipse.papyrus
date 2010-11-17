/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.preferences;


import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockConstraintCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockOperationCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockPartCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockPropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockReferenceCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockValueCompartmentEditPart;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

public class BlockPreferencePage extends BlockDefinitionDiagramNodePreferencePage {

	/**
	 * the list of the compartments for this node
	 */
	public static final String compartments[] = { 
		BlockPropertyCompartmentEditPart.COMPARTMENT_NAME, 
		BlockOperationCompartmentEditPart.COMPARTMENT_NAME, 
		BlockConstraintCompartmentEditPart.COMPARTMENT_NAME, 
		BlockPartCompartmentEditPart.COMPARTMENT_NAME, 
		BlockReferenceCompartmentEditPart.COMPARTMENT_NAME, 
		BlockValueCompartmentEditPart.COMPARTMENT_NAME 
		};

	public static final String default_compartments[] = { 
		//BlockPropertyCompartmentEditPart.COMPARTMENT_NAME, 
		//Messages.ClassOperationCompartment2EditPart_title, 
		//BlockConstraintCompartmentEditPart.COMPARTMENT_NAME, 
		BlockPartCompartmentEditPart.COMPARTMENT_NAME, 
		BlockReferenceCompartmentEditPart.COMPARTMENT_NAME, 
		//BlockValueCompartmentEditPart.COMPARTMENT_NAME 
		};

	public BlockPreferencePage() {
		super();
		setPreferenceKey(BlockDefinitionDiagramEditPart.DIAGRAM_ID + "_" + SysMLElementTypes.BLOCK.getSemanticHint()); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param store
	 */
	public static void initDefaults(IPreferenceStore store) {

		String key = BlockDefinitionDiagramEditPart.DIAGRAM_ID + "_" + SysMLElementTypes.BLOCK.getSemanticHint();
		for(String name : compartments) {
			String preferenceName = PreferenceConstantHelper.getCompartmentElementConstant(key, name, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(preferenceName, false);
		}
		// set the true value for the compartment visibility
		for(String name : default_compartments) {
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
