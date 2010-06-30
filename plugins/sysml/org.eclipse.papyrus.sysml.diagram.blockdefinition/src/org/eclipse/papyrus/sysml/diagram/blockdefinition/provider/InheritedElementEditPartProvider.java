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
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
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
		}
		
		// This hack avoids to repeat the inherited elements from the parent diagram
		String oldValue = ModelEditPart.MODEL_ID;
		ModelEditPart.MODEL_ID = BlockDefinitionDiagramEditPart.DIAGRAM_ID;
		boolean result =  super.provides(operation);
		ModelEditPart.MODEL_ID = oldValue;
		
		return result;
	}
}
