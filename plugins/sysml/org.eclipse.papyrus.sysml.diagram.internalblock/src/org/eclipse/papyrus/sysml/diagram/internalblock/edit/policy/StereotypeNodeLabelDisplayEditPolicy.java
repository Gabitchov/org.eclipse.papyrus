package org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy;

import java.util.List;

import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Stereotype;


public class StereotypeNodeLabelDisplayEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	// Always show icon
	public Image stereotypeIconToDisplay() {

		// retrieve the first stereotype in the list of displayed stereotype
		List<Stereotype> appliedSt = getUMLElement().getAppliedStereotypes();
		if(!appliedSt.isEmpty()) {
			return Activator.getIconElement(getUMLElement(), appliedSt.get(0), false);
		}

		return null;
	}
}
