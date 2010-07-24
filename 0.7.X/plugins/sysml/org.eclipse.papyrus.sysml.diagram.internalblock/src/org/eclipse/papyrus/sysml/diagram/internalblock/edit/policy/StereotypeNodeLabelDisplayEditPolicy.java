/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy;

import java.util.List;

import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypeNodeLabelDisplayEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	// Always show the stereotype as icon
	public Image stereotypeIconToDisplay() {

		// retrieve the first stereotype in the list of displayed stereotype
		List<Stereotype> appliedSt = getUMLElement().getAppliedStereotypes();
		if(!appliedSt.isEmpty()) {
			return Activator.getIconElement(getUMLElement(), appliedSt.get(0), false);
		}

		return null;
	}
}
