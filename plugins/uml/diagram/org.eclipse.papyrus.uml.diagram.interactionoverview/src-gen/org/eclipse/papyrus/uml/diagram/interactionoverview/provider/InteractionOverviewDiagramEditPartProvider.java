/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.provider;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.interactionoverview.Activator;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.InteractionOverviewDiagramEditPart;

public class InteractionOverviewDiagramEditPartProvider extends AbstractEditPartProvider {

	@Override
	public boolean provides(final IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			final View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is InteractionOverviewDiagram Diagram
			if(ElementTypes.DIAGRAM_ID.equals(view.getType())) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected Class<?> getDiagramEditPartClass(final View view) {
		if(ElementTypes.DIAGRAM_ID.equals(view.getType())) {
			return InteractionOverviewDiagramEditPart.class;
		}

		Activator.log.error(new Exception("Could not create EditPart."));
		return null;
	}

}
