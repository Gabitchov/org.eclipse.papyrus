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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationMoveHelper;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;

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
			if(invalidMoveDurationConstraint(request.getMoveDelta())) {
				return UnexecutableCommand.INSTANCE;
			}
			command = OccurrenceSpecificationMoveHelper.completeMoveTimeRelatedElementCommand(command, request, getHost(), getHostFigure());
		}
		return command;
	}

	/**
	 * Bug description:
	 * When we move down the Duration Constraint which attached to a Execution Specification, the Execution Specification can be moved out it's Parent
	 * Execution Specification. This would not happen when move Execution Specification directly.
	 * 
	 * At present, we just avoid this kind of moving.
	 */
	private boolean invalidMoveDurationConstraint(Point moveDelta) {
		if(!(getHost() instanceof DurationConstraintEditPart) || moveDelta == null || moveDelta.y == 0) {
			return false;
		}
		DurationConstraintEditPart editPart = (DurationConstraintEditPart)getHost();
		DurationConstraint durationConstraint = (DurationConstraint)editPart.resolveSemanticElement();
		EList<Element> constrainedElements = durationConstraint.getConstrainedElements();
		List<ExecutionSpecification> executions = new ArrayList<ExecutionSpecification>();
		for(Element element : constrainedElements) {
			if(!(element instanceof ExecutionOccurrenceSpecification)) {
				continue;
			}
			ExecutionSpecification execution = ((ExecutionOccurrenceSpecification)element).getExecution();
			if(execution != null && !executions.contains(execution)) {
				executions.add(execution);
			}
		}
		if(executions.isEmpty()) {
			return false;
		}
//		LifelineEditPart lifelineEditPart = (LifelineEditPart)getHost().getParent();
//		for(ExecutionSpecification executionSpecification : executions) {
//			Collection<Setting> settings = CacheAdapter.getInstance().getNonNavigableInverseReferences(executionSpecification);
//			for(Setting ref : settings) {
//				if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
//					View view = (View)ref.getEObject();
//					EditPart part = DiagramEditPartsUtil.getEditPartFromView(view, getHost());
//					if(!(part instanceof ShapeNodeEditPart)) {
//						continue;
//					}
//					Rectangle childBounds = ((ShapeNodeEditPart)part).getFigure().getBounds().getCopy();
//					List<ShapeNodeEditPart> toCheckExecutionSpecificationList = new ArrayList<ShapeNodeEditPart>(lifelineEditPart.getChildShapeNodeEditPart());
//					toCheckExecutionSpecificationList.remove(part);
//					ShapeNodeEditPart parent = LifelineXYLayoutEditPolicy.getParent(lifelineEditPart, childBounds, toCheckExecutionSpecificationList);
//					if(parent != null) {
//						Rectangle parentBounds = parent.getFigure().getBounds().getCopy();
//						if(childBounds.y + moveDelta.y >= parentBounds.bottom() - 1) {
//							return true;
//						}
//					}
//				}
//			}
//		}
		return true;
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
