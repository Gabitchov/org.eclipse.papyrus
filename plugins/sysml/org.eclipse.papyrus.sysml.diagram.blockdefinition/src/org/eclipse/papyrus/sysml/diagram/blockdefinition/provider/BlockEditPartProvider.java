/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassOperationCompartment2EditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockConstraintCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockConstraintEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockPartCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockPartEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockPropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockPropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockReferenceCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockValueCompartmentEditPart;

public class BlockEditPartProvider extends AbstractEditPartProvider {

	private Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();
	{
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK.getSemanticHint(), BlockEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_PROPERTY_COMPARTMENT_HINT, BlockPropertyCompartmentEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_OPERATION_COMPARTMENT_HINT, ClassOperationCompartment2EditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT, BlockConstraintCompartmentEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_PART_COMPARTMENT_HINT, BlockPartCompartmentEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_REFERENCE_COMPARTMENT_HINT, BlockReferenceCompartmentEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_VALUE_COMPARTMENT_HINT, BlockValueCompartmentEditPart.class);

		nodeMap.put(BlockDefinitionDiagramElementTypes.CLASS_PROPERTY_CLN.getSemanticHint(), BlockPropertyEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_CLN.getSemanticHint(), BlockConstraintEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_PART_CLN.getSemanticHint(), BlockPartEditPart.class);
	}

	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();
			if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Provides view for BLOCK and its owned Label and Compartment
			String hint = view.getType();

			/** Block */
			if(nodeMap.containsKey(hint)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected Class<?> getNodeEditPartClass(View view) {
		return nodeMap.get(view.getType());
	}
}
