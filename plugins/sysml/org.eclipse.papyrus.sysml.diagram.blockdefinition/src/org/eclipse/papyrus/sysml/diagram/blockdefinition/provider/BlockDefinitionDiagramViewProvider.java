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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.BlockCompartmentViewFactory;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.BlockDefinitionDiagramViewFactory;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.BlockViewFactory;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.ConstraintViewFactory;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.NameLabelViewFactory;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.PortNameLabelViewFactory;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.PortViewFactory;

public class BlockDefinitionDiagramViewProvider extends AbstractViewProvider {
	
	private Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();
	{
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK.getSemanticHint(), BlockViewFactory.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_NAME_LABEL_HINT, NameLabelViewFactory.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_PROPERTY_COMPARTMENT_HINT, BlockCompartmentViewFactory.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_OPERATION_COMPARTMENT_HINT, BlockCompartmentViewFactory.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_NESTEDCLASSIFIER_COMPARTMENT_HINT, BlockCompartmentViewFactory.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT, BlockCompartmentViewFactory.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_PART_COMPARTMENT_HINT, BlockCompartmentViewFactory.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_REFERENCE_COMPARTMENT_HINT, BlockCompartmentViewFactory.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_VALUE_COMPARTMENT_HINT, BlockCompartmentViewFactory.class);
		
		nodeMap.put(BlockDefinitionDiagramElementTypes.CONSTRAINT.getSemanticHint(), ConstraintViewFactory.class);
		
		nodeMap.put(BlockDefinitionDiagramElementTypes.FLOW_PORT.getSemanticHint(), PortViewFactory.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.PORT.getSemanticHint(), PortViewFactory.class);
		nodeMap.put(BlockDefinitionDiagramElementTypes.PORT_NAME_LABEL_HINT, PortNameLabelViewFactory.class);
	}
	
	private Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();
	{		
		edgeMap.put(BlockDefinitionDiagramElementTypes.CONNECTOR.getSemanticHint(), ConnectionViewFactory.class);
	}

	@Override
	protected Class<?> getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		if(BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(diagramKind)) {
			return BlockDefinitionDiagramViewFactory.class;
		}
		return null;
	}

	@Override
	protected Class<?> getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		return nodeMap.get(semanticHint);
	}
	
	@Override
	protected Class<?> getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		return edgeMap.get(semanticHint);
	}
}
