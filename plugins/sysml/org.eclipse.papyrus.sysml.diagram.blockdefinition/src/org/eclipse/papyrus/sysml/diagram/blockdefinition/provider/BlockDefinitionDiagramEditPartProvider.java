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

import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassOperationCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property4EditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockConstraintCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockConstraintEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockPartCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockPropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockPropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockReferenceCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockValueCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.ConnectorEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.FlowPortEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.PortEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.PortNameEditPart;

public class BlockDefinitionDiagramEditPartProvider extends AbstractEditPartProvider {
	
	private Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();
	{		
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK.getSemanticHint(), BlockEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_PROPERTY_COMPARTMENT_HINT, BlockPropertyCompartmentEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_OPERATION_COMPARTMENT_HINT, ClassOperationCompartment2EditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT, BlockConstraintCompartmentEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_PART_COMPARTMENT_HINT, BlockPartCompartmentEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_REFERENCE_COMPARTMENT_HINT, BlockReferenceCompartmentEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_VALUE_COMPARTMENT_HINT, BlockValueCompartmentEditPart.class);
		
		nodeMap.put(UMLVisualIDRegistry.getType(Property4EditPart.VISUAL_ID), BlockPropertyEditPart.class);
		
		nodeMap.put(BlockDefinitionDiagramElementTypes.CONSTRAINT.getSemanticHint(), BlockConstraintEditPart.class);
		
		nodeMap.put(BlockDefinitionDiagramElementTypes.PORT_NAME_LABEL_HINT, PortNameEditPart.class);
		
		nodeMap.put(BlockDefinitionDiagramElementTypes.FLOW_PORT.getSemanticHint(), FlowPortEditPart.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.PORT.getSemanticHint(), PortEditPart.class);
	}
	
	private Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();
	{		
		edgeMap.put(BlockDefinitionDiagramElementTypes.CONNECTOR.getSemanticHint(), ConnectorEditPart.class);
	}

	@Override
	protected Class<?> getDiagramEditPartClass(View view) {	
		if(BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
			return BlockDefinitionDiagramEditPart.class;
		}
		return null;
	}
	
	@Override
	protected Class<?> getNodeEditPartClass(View view) {
		return nodeMap.get(view.getType());
	}
	
	@Override
	protected Class<?> getEdgeEditPartClass(View view) {
		return edgeMap.get(view.getType());
	}

}
