/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;

/**
 * The customn XYLayoutEditPolicy for InteractionCompartmentEditPart.
 */
public class InteractionCompartmentXYLayoutEditPolicy extends XYLayoutEditPolicy {

	/**
	 * Handle lifeline resize
	 */
	@Override
	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
		CompoundCommand compoundCmd = new CompoundCommand();
		compoundCmd.setLabel("Movement or Resize of a Lifeline EditPart");
		compoundCmd.setDebugLabel("Debug: Movement or Resize of a Lifeline EditPart");

		for(Object o : request.getEditParts()) {
			GraphicalEditPart child = (GraphicalEditPart)o;
			Object constraintFor = getConstraintFor(request, child);
			if(constraintFor != null) {
				int width = request.getSizeDelta().width;
				if(child instanceof LifelineEditPart && width != 0) {
					compoundCmd = getResizeChildrenCommand(compoundCmd, width, (LifelineEditPart)child, 1);
				}
				Command changeConstraintCommand = createChangeConstraintCommand(request, child, translateToModelConstraint(constraintFor));
				compoundCmd.add(changeConstraintCommand);
			}
		}
		return compoundCmd.unwrap();

	}

	/**
	 * Resize children of LifelineEditPart (Execution specification and lifeline)
	 * 
	 * @param compoundCmd
	 *        The command
	 * @param width
	 *        The new width
	 * @param lifelineEditPart
	 *        The lifelineEditPart to resize
	 * @param number
	 *        The number of brother of the LifelineEditPart
	 * @return The command
	 */
	private CompoundCommand getResizeChildrenCommand(CompoundCommand compoundCmd, int width, LifelineEditPart lifelineEditPart, int number) {
		// If the width increases or decreases, ExecutionSpecification elements need to
		// be moved
		for(ShapeNodeEditPart executionSpecificationEP : lifelineEditPart.getExecutionSpecificationList()) {
			// Lifeline's figure where the child is drawn
			Rectangle rDotLine = lifelineEditPart.getContentPane().getBounds();

			// The new bounds will be calculated from the current bounds
			Rectangle newBounds = executionSpecificationEP.getFigure().getBounds().getCopy();

			if(rDotLine.getSize().width + width < newBounds.width * 2) {
				compoundCmd.add(UnexecutableCommand.INSTANCE);
			}

			// Apply SizeDelta to the children
			newBounds.x += Math.round((float)width / ((float)2 * number));

			// Convert to relative
			newBounds.x -= rDotLine.x;
			newBounds.y -= rDotLine.y;

			SetBoundsCommand setBoundsCmd = new SetBoundsCommand(executionSpecificationEP.getEditingDomain(), "Re-location of a ExecutionSpecification due to a Lifeline movement", executionSpecificationEP, newBounds);
			compoundCmd.add(new ICommandProxy(setBoundsCmd));
		}

		List<LifelineEditPart> innerConnectableElementList = lifelineEditPart.getInnerConnectableElementList();
		for(LifelineEditPart lifelineEP : innerConnectableElementList) {
			getResizeChildrenCommand(compoundCmd, width, lifelineEP, number * innerConnectableElementList.size());
		}

		return compoundCmd;
	}

	/**
	 * Change constraint for comportment by return null if the resize is lower than the minimun
	 * size.
	 */
	@Override
	protected Object getConstraintFor(ChangeBoundsRequest request, GraphicalEditPart child) {
		Rectangle rect = new PrecisionRectangle(child.getFigure().getBounds());
		child.getFigure().translateToAbsolute(rect);
		rect = request.getTransformedRectangle(rect);
		child.getFigure().translateToRelative(rect);
		rect.translate(getLayoutOrigin().getNegated());

		if(request.getSizeDelta().width == 0 && request.getSizeDelta().height == 0) {
			Rectangle cons = getCurrentConstraintFor(child);
			if(cons != null) // Bug 86473 allows for unintended use of this method
				rect.setSize(cons.width, cons.height);
		} else { // resize
			Dimension minSize = getMinimumSizeFor(child);
			if(rect.width < minSize.width) {
				return null;
			}
			if(rect.height < minSize.height) {
				return null;
			}
		}
		rect = (Rectangle)getConstraintFor(rect);

		Rectangle cons = getCurrentConstraintFor(child);
		if(request.getSizeDelta().width == 0)
			rect.width = cons.width;
		if(request.getSizeDelta().height == 0)
			rect.height = cons.height;

		return rect;
	}

	/**
	 * Handle mininum size for lifeline
	 */
	@Override
	protected Dimension getMinimumSizeFor(GraphicalEditPart child) {
		Dimension minimunSize;
		if(child instanceof LifelineEditPart) {
			minimunSize = getMinimumSizeFor((LifelineEditPart)child);
		} else {
			minimunSize = super.getMinimumSizeFor(child);
		}
		return minimunSize;
	}

	/**
	 * Get minimun for a lifeline
	 * 
	 * @param child
	 *        The lifeline
	 * @return The minimun size
	 */
	private Dimension getMinimumSizeFor(LifelineEditPart child) {
		LifelineEditPart lifelineEditPart = (LifelineEditPart)child;
		Dimension minimunSize = lifelineEditPart.getFigure().getMinimumSize();
		for(LifelineEditPart lifelineEP : lifelineEditPart.getInnerConnectableElementList()) {
			minimunSize.union(getMinimumSizeFor(lifelineEP));
		}
		for(ShapeNodeEditPart executionSpecificationEP : lifelineEditPart.getExecutionSpecificationList()) {
			int minimunHeight = executionSpecificationEP.getFigure().getBounds().bottom();
			minimunSize.setSize(new Dimension(minimunSize.width, Math.max(minimunSize.height, minimunHeight)));
		}
		return minimunSize;
	}

	/**
	 * Block adding element by movement on Interaction
	 */
	@Override
	public Command getAddCommand(Request request) {
		if(request instanceof ChangeBoundsRequest) {
			return UnexecutableCommand.INSTANCE;
		}

		return super.getAddCommand(request);
	}

}
