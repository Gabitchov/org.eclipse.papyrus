/*****************************************************************************
 * Copyright (c) 2010-2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		David Servat
 *		Ansgar Radermacher (bug 369305)
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.statemachine.custom.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomConnectionPointReferenceNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomFinalStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomPackageEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomRegionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomRegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomStateCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomStateMachineCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomStateMachineEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomStateMachineNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomStateNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomTransitionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part.CustomTransitionGuardEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.ConnectionPointReferenceNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.TransitionGuardEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry;

public class CustomUMLEditPartFactory extends UMLEditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof View) {
			View view = (View)model;
			switch(UMLVisualIDRegistry.getVisualID(view)) {
			// redefined classes to modify the method createNodePlate
			case PackageEditPart.VISUAL_ID:
				return new CustomPackageEditPart(view);
			case StateMachineEditPart.VISUAL_ID:
				return new CustomStateMachineEditPart(view);
			case StateMachineNameEditPart.VISUAL_ID:
				return new CustomStateMachineNameEditPart(view);
			case StateMachineCompartmentEditPart.VISUAL_ID:
				return new CustomStateMachineCompartmentEditPart(view);
			case RegionCompartmentEditPart.VISUAL_ID:
				return new CustomRegionCompartmentEditPart(view);
			case RegionEditPart.VISUAL_ID:
				return new CustomRegionEditPart(view);
			case FinalStateEditPart.VISUAL_ID:
				return new CustomFinalStateEditPart(view);
			case StateEditPart.VISUAL_ID:
				return new CustomStateEditPart(view);
			case StateNameEditPart.VISUAL_ID:
				return new CustomStateNameEditPart(view);
			case StateCompartmentEditPart.VISUAL_ID:
				return new CustomStateCompartmentEditPart(view);
			case TransitionGuardEditPart.VISUAL_ID:
				return new CustomTransitionGuardEditPart(view);
			case ConnectionPointReferenceNameEditPart.VISUAL_ID:
				return new CustomConnectionPointReferenceNameEditPart(view);
			case TransitionEditPart.VISUAL_ID:
				return new CustomTransitionEditPart(view);
			}
		}
		return super.createEditPart(context, model);
	}

}
