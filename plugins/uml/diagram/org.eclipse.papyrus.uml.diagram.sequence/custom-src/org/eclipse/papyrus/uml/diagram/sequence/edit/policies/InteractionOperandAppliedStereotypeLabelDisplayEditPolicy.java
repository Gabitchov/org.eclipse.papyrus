/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomInteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandGuardEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandGuardEditPart.GuardFigure;
import org.eclipse.swt.graphics.Image;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class InteractionOperandAppliedStereotypeLabelDisplayEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	@Override
	protected void refreshStereotypeDisplay() {
		EditPart host = getHost();
		if(!(host instanceof CustomInteractionOperandEditPart)) {
			return;
		}
		IGraphicalEditPart guard = ((CustomInteractionOperandEditPart)host).getChildBySemanticHint(InteractionOperandGuardEditPart.GUARD_TYPE);
		if(!(guard instanceof InteractionOperandGuardEditPart)) {
			return;
		}
		GuardFigure figure = ((InteractionOperandGuardEditPart)guard).getPrimaryFigure();
		// calculate text and icon to display
		final String stereotypesToDisplay = stereotypesOnlyToDisplay();
		// computes the icon to be displayed
		final Image imageToDisplay = stereotypeIconToDisplay();

		// if the string is not empty, then, the figure has to display it.
		// Else, it displays
		// nothing
		// if (stereotypesToDisplay != "" || imageToDisplay != null) {
		if(figure instanceof IPapyrusNodeUMLElementFigure) {
			((IPapyrusNodeUMLElementFigure)figure).setStereotypeDisplay(tag + (stereotypesOnlyToDisplay().equals("") ? stereotypesToDisplay : stereotypesToDisplay), imageToDisplay);
			refreshAppliedStereotypesProperties(((IPapyrusNodeUMLElementFigure)figure));
		}
	}
}
