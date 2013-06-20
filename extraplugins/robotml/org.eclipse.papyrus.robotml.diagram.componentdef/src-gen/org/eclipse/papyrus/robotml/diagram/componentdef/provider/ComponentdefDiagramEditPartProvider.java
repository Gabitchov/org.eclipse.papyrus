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
package org.eclipse.papyrus.robotml.diagram.componentdef.provider;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.robotml.diagram.componentdef.Activator;
import org.eclipse.papyrus.robotml.diagram.componentdef.edit.part.ComponentdefDiagramEditPart;

public class ComponentdefDiagramEditPartProvider extends AbstractEditPartProvider {

	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is Componentdef Diagram
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(view.getType())) {
				return true;
			}

			//			nodeMap.put(AppliedStereotypeConpartmentEditPart.ID, AppliedStereotypeConpartmentEditPart.class);
			//		    nodeMap.put(AppliedStereotypePropertyEditPart.ID, AppliedStereotypeMultilinePropertyEditPart.class);

		}

		return false;
	}

	@Override
	protected Class<?> getDiagramEditPartClass(View view) {
		if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(view.getType())) {
			return ComponentdefDiagramEditPart.class;
		}

		Activator.log.error(new Exception("Could not create EditPart."));
		return null;
	}

}
