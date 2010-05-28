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
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.providers.CUMLEditPartProvider;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;


public class InheritedElementEditPartProvider extends CUMLEditPartProvider {

	@Override
	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is BlockDefinitionDiagram
			if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Test supported inherited types
			String hint = view.getType();

			// Block (Class) : related labels and compartments
			if(BlockDefinitionDiagramElementTypes.BLOCK_NAME_LABEL_HINT.equals(hint) || BlockDefinitionDiagramElementTypes.BLOCK_PROPERTY_COMPARTMENT_HINT.equals(hint) || BlockDefinitionDiagramElementTypes.BLOCK_OPERATION_COMPARTMENT_HINT.equals(hint) || BlockDefinitionDiagramElementTypes.BLOCK_NESTEDCLASSIFIER_COMPARTMENT_HINT.equals(hint)) {
				return true;
			}

			// Package and related labels and compartments
			if(BlockDefinitionDiagramElementTypes.Package_2007.getSemanticHint().equals(hint) || BlockDefinitionDiagramElementTypes.PACKAGE_NAME_LABEL_HINT.equals(hint) || BlockDefinitionDiagramElementTypes.PACKAGE_COMPARTMENT_HINT.equals(hint)) {
				return true;
			}

			if(BlockDefinitionDiagramElementTypes.Property_3012.getSemanticHint().equals(hint)) {
				return true;
			}

			if(BlockDefinitionDiagramElementTypes.Usage_4007.getSemanticHint().equals(hint)) {
				return true;
			}

		}
		return false;
	}
}
