/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.architecture.provider;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.robotml.diagram.architecture.Activator;
import org.eclipse.papyrus.robotml.diagram.architecture.edit.part.ArchitectureDiagramEditPart;

public class ArchitectureDiagramEditPartProvider extends AbstractEditPartProvider {

	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is Architecture Diagram
			if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(view.getType())) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected Class<?> getDiagramEditPartClass(View view) {
		if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(view.getType())) {
			return ArchitectureDiagramEditPart.class;
		}

		Activator.log.error(new Exception("Could not create EditPart."));
		return null;
	}

}
