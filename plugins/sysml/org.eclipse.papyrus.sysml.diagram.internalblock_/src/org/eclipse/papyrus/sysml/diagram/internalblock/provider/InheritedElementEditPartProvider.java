/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.provider;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.composite.providers.UMLEditPartProvider;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.factory.InheritedElementEditPartFactory;

public class InheritedElementEditPartProvider extends UMLEditPartProvider {

	public InheritedElementEditPartProvider() {
		setFactory(new InheritedElementEditPartFactory());
		setAllowCaching(true);
	}

	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();
			if(!InternalBlockDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}
			IGraphicalEditPart part = createEditPart(view);
			if(part != null) {
				return true;
			}
		}
		return false;
	}
}
