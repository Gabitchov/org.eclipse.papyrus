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
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.BlockCompartmentViewFactory;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.BlockViewFactory;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.ConstraintViewFactory;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.NameLabelViewFactory;

public class BlockViewProvider extends AbstractViewProvider {

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

		nodeMap.put(BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_CLN.getSemanticHint(), ConstraintViewFactory.class);
	}

	@Override
	protected boolean provides(CreateNodeViewOperation operation) {
		View view = operation.getContainerView();
		if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
			return false;
		}

		// Provides view for BLOCK and its owned Label and Compartment
		String hint = operation.getSemanticHint();

		/** Block */
		if(nodeMap.containsKey(hint)) {
			return true;
		}

		return false;
	}

	@Override
	protected Class<?> getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		return nodeMap.get(semanticHint);
	}
}
