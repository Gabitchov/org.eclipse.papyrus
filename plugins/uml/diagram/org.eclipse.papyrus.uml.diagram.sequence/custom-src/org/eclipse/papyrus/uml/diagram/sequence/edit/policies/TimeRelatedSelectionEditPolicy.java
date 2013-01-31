/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationMoveHelper;

/**
 * Edit policy to restrict border item movement. This edit policy moves the related events when a Time/Duration Observation/Constraint is moved.
 */
public class TimeRelatedSelectionEditPolicy extends BorderItemSelectionEditPolicy {

	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		updateRequest(request);
		// Prepare request
		if(getHost() instanceof IBorderItemEditPart) {
			OccurrenceSpecificationMoveHelper.prepareTimeRelatedElementMoveRequest(request, (IBorderItemEditPart)getHost());
		}
		//In fact, BorderItem can not be moved out of parent bounds, so the moveDelta if not correctly when move out parent.
		Command command = super.getMoveCommand(request);
		if(command != null) {
			command = OccurrenceSpecificationMoveHelper.completeMoveTimeRelatedElementCommand(command, request, getHost(), getHostFigure());
		}
		return command;
	}

	/**
	 * By default, the IBorderItemEditPart can not be moved out of the parent.
	 * 
	 * @param request
	 */
	private void updateRequest(ChangeBoundsRequest request) {
		IBorderItemEditPart borderItemEP = (IBorderItemEditPart)getHost();
		IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();

		if(borderItemLocator != null) {
			Rectangle initialFeedbackBounds = getInitialFeedbackBounds();
			PrecisionRectangle rect = new PrecisionRectangle(initialFeedbackBounds.getCopy());
			getHostFigure().translateToAbsolute(rect);
			rect.translate(request.getMoveDelta());
			rect.resize(request.getSizeDelta());

			getHostFigure().translateToRelative(rect);
			Rectangle realLocation = borderItemLocator.getValidLocation(rect.getCopy(), borderItemEP.getFigure());

			Point parentOrigin = borderItemEP.getFigure().getParent().getBounds().getTopLeft();
			Dimension d = realLocation.getTopLeft().getDifference(parentOrigin);
			Point newLocation = new Point(d.width, d.height);
			if(getHost().getModel() instanceof Node && ((Node)getHost().getModel()).getLayoutConstraint() instanceof Bounds) {
				Bounds bounds = (Bounds)((Node)getHost().getModel()).getLayoutConstraint();
				Point moveDelta = request.getMoveDelta();
				moveDelta.x = newLocation.x - bounds.getX();
				moveDelta.y = newLocation.y - bounds.getY();
			}
		}
	}

	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		if(getHost() instanceof IBorderItemEditPart) {
			OccurrenceSpecificationMoveHelper.prepareTimeRelatedElementMoveRequest(request, (IBorderItemEditPart)getHost());
		}
		super.showChangeBoundsFeedback(request);
	}
}
