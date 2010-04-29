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

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockConstraintCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockEditPart;

public class BlockEditPartProvider extends AbstractEditPartProvider {

	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();
			if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			if(BlockDefinitionDiagramElementTypes.BLOCK.getSemanticHint().equals(view.getType())) {
				return true;
			}

			if(BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT.equals(view.getType())) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected Class getNodeEditPartClass(View view) {

		if(BlockDefinitionDiagramElementTypes.BLOCK.getSemanticHint().equals(view.getType())) {
			return BlockEditPart.class;
		}

		if(BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT.equals(view.getType())) {
			return BlockConstraintCompartmentEditPart.class;
		}

		System.err.println("WAR : BlockEditPartProvider::getNodeEditPartClass - not edit part for type : " + view.getType());
		return null;
	}
}
