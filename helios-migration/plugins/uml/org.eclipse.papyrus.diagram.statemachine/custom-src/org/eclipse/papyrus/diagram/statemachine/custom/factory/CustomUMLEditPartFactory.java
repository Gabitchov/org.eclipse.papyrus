package org.eclipse.papyrus.diagram.statemachine.custom.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.custom.edit.part.CustomRegionCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.custom.edit.part.CustomRegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.custom.edit.part.CustomStateMachineCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.custom.edit.part.CustomStateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.custom.edit.part.CustomStateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;

public class CustomUMLEditPartFactory extends UMLEditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (UMLVisualIDRegistry.getVisualID(view)) {
			// redefined classes to modify the method createNodePlate
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
			}
		}
		return super.createEditPart(context, model);
	}

}
