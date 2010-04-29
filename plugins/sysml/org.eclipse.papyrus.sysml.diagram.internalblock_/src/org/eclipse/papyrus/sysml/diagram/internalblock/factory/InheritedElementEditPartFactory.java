package org.eclipse.papyrus.sysml.diagram.internalblock.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.composite.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry;


public class InheritedElementEditPartFactory extends UMLEditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {

		if(model instanceof View) {
			View view = (View)model;
			String viewType = view.getType();
			// UMLVisualIDRegistry.getVisualID(String type) is a basic parseInt
			// Assume the viewType is an int, else it should be managed separately (cf. Block).
			return createEditPart(context, view, UMLVisualIDRegistry.getVisualID(viewType));
		}

		return null;
	}
}
