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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.draw2d.LifelineDotLineFigure;
import org.eclipse.papyrus.diagram.sequence.command.CustomZOrderCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;

/**
 * The custom LayoutEditPolicy for LifelineEditPart.
 */
public class LifelineXYLayoutEditPolicy extends XYLayoutEditPolicy {

	/** Initialisation width of Execution Specification. */
	private final static int EXECUTION_INIT_WIDTH = 16;

	/** Initialisation height of Execution Specification. */
	private final static int EXECUTION_INIT_HEIGHT = 30;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		if(request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest cver = (CreateViewAndElementRequest)request;
			ViewAndElementDescriptor viewAndElementDescriptor = cver.getViewAndElementDescriptor();
			String semanticHint = viewAndElementDescriptor.getSemanticHint();
			if(String.valueOf(ActionExecutionSpecificationEditPart.VISUAL_ID).equals(semanticHint) || String.valueOf(BehaviorExecutionSpecificationEditPart.VISUAL_ID).equals(semanticHint)) {

				// Translate the absolute location to relative
				Point newLocation = cver.getLocation().getCopy();

				if(newLocation.x < 0 || newLocation.y < 0) {
					newLocation.x = newLocation.y = 0;
				}

				LifelineEditPart editPart = (LifelineEditPart)getHost();
				LifelineDotLineFigure figureLifelineDotLineFigure = null;
				List<ShapeNodeEditPart> executionSpecificationList = new ArrayList<ShapeNodeEditPart>();
				figureLifelineDotLineFigure = editPart.getPrimaryShape().getFigureLifelineDotLineFigure();
				executionSpecificationList = editPart.getExecutionSpecificationList();

				figureLifelineDotLineFigure.translateToRelative(newLocation);

				int newHeight;
				if(cver.getSize() != null) {
					newHeight = cver.getSize().height;
				} else {
					newHeight = EXECUTION_INIT_HEIGHT;
				}

				Rectangle newBounds = new Rectangle(newLocation.x, newLocation.y, -1, newHeight);
				newBounds = getExecutionSpecificationNewBoundsForMove(figureLifelineDotLineFigure, newBounds, executionSpecificationList, new ArrayList<ShapeNodeEditPart>(0));
				if(newBounds == null) {
					return UnexecutableCommand.INSTANCE;
				}

				return new ICommandProxy(new SetBoundsCommand(editPart.getEditingDomain(), "Creation of an ExecutionSpecification", viewAndElementDescriptor, newBounds));
			}
		}

		return super.getCreateCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
		List<?> editParts = request.getEditParts();

		// This policy is hosted in a LifelineEditPart
		LifelineEditPart lifelineEP = (LifelineEditPart)getHost();

		// We are supposed to work with only one children at a time
		if(editParts != null && editParts.size() == 1 && lifelineEP.getExecutionSpecificationList().contains(editParts.get(0))) {
			// The child's EditPart
			ShapeNodeEditPart executionSpecificationEP = (ShapeNodeEditPart)editParts.get(0);

			// Check if height is within the limits of the figure
			Dimension newSizeDelta = adaptSizeDeltaToMaxHeight(executionSpecificationEP.getFigure(), request.getSizeDelta());

			// Current bounds of the ExecutionSpecification
			Rectangle newBounds = executionSpecificationEP.getFigure().getBounds().getCopy();

			// According to the parameters, the new bounds would be the following
			newBounds.x += request.getMoveDelta().x;
			newBounds.y += request.getMoveDelta().y;
			newBounds.height += newSizeDelta.height;

			// Not to check list
			List<ShapeNodeEditPart> notToCheckExecutionSpecificationList = new BasicEList<ShapeNodeEditPart>();
			// Affixed ExecutionSpecification List
			List<ShapeNodeEditPart> affixedExecutionSpecificationEditParts = getAffixedExecutionSpecificationEditParts(executionSpecificationEP);
			notToCheckExecutionSpecificationList.addAll(affixedExecutionSpecificationEditParts);
			// Add also current ExecutionSpecification EditPart
			notToCheckExecutionSpecificationList.add(executionSpecificationEP);

			newBounds = getExecutionSpecificationNewBoundsForResize(lifelineEP, newBounds, notToCheckExecutionSpecificationList);
			if(newBounds == null) {
				return null; // UnexecutableCommand.INSTANCE
			}

			CompoundCommand compoundCmd = new CompoundCommand();
			compoundCmd.setLabel("Resize of a ExecutionSpecification EditPart");
			compoundCmd.setDebugLabel("Debug: Resize of a ExecutionSpecification EditPart");

			// Create and add the command to the compound command
			SetBoundsCommand setBoundsCmd = new SetBoundsCommand(executionSpecificationEP.getEditingDomain(), "Resize of a ExecutionSpecification", executionSpecificationEP, newBounds);
			compoundCmd.add(new ICommandProxy(setBoundsCmd));

			Rectangle realMoveDelta = getRealMoveDelta(getRelativeBounds(executionSpecificationEP.getFigure()), newBounds);
			// Move also children
			compoundCmd.add(createMovingAffixedExecutionSpecificationCommand(executionSpecificationEP, realMoveDelta, newBounds));

			if(!compoundCmd.isEmpty()) {
				return compoundCmd;
			}
		}

		return super.getResizeChildrenCommand(request);
	}

	/**
	 * Useful operation to know where the figure of a ExecutionSpecification EditPart should be
	 * positioned within a Lifeline EditPart. The notToCheckList is needed to avoid checking those
	 * ExecutionSpecification EditParts. The returned bounds are relative to the Lifeline figure so
	 * they can be used, directly, within a SetBoundsCommand.
	 * 
	 * @param lifelineEP
	 *        the lifeline ep
	 * @param newBounds
	 *        The new initial bounds
	 * @param notToCheckExecutionSpecificationList
	 *        The ExecutionSpecification EditPart's List that won't be checked
	 * 
	 * @return The new bounds of the executionSpecificationEP figure
	 */
	protected final static Rectangle getExecutionSpecificationNewBoundsForResize(LifelineEditPart lifelineEP, Rectangle newBounds, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList) {
		// Lifeline's figure where the child is drawn
		Rectangle dotLineBounds = lifelineEP.getPrimaryShape().getFigureLifelineDotLineFigure().getBounds();

		// if ExecutionSpecification is move before the lifeline
		if(newBounds.y < dotLineBounds.y || newBounds.x < dotLineBounds.x || newBounds.x > dotLineBounds.right()) {
			return null;
		}

		List<ShapeNodeEditPart> toCheckExecutionSpecificationList = lifelineEP.getExecutionSpecificationList();
		toCheckExecutionSpecificationList.removeAll(notToCheckExecutionSpecificationList);

		// Change to relative bounds of the LifelineEP
		newBounds.x -= dotLineBounds.x;
		newBounds.y -= dotLineBounds.y;

		return newBounds;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getMoveChildrenCommand(Request request) {
		ChangeBoundsRequest cbr = (ChangeBoundsRequest)request;
		List<?> editParts = cbr.getEditParts();

		// This policy is hosted in a LifelineEditPart
		LifelineEditPart lifelineEP = (LifelineEditPart)getHost();

		// We are supposed to work with only one children at a time
		if(editParts != null && editParts.size() == 1 && lifelineEP.getExecutionSpecificationList().contains(editParts.get(0))) {
			// The child's EditPart
			ShapeNodeEditPart executionSpecificationEP = (ShapeNodeEditPart)editParts.get(0);

			// Check if height is within the limits of the figure
			Dimension newSizeDelta = adaptSizeDeltaToMaxHeight(executionSpecificationEP.getFigure(), cbr.getSizeDelta());

			// Current bounds of the ExecutionSpecification
			Rectangle newBounds = executionSpecificationEP.getFigure().getBounds().getCopy();

			// According to the parameters, the new bounds would be the following
			newBounds.x += cbr.getMoveDelta().x;
			newBounds.y += cbr.getMoveDelta().y;
			newBounds.height += newSizeDelta.height;

			// Not to check list
			List<ShapeNodeEditPart> notToCheckExecutionSpecificationList = new BasicEList<ShapeNodeEditPart>();
			// Affixed ExecutionSpecification List
			notToCheckExecutionSpecificationList.addAll(getAffixedExecutionSpecificationEditParts(executionSpecificationEP));
			// Add also current ExecutionSpecification EditPart
			notToCheckExecutionSpecificationList.add(executionSpecificationEP);

			newBounds = getExecutionSpecificationNewBoundsForMove(lifelineEP.getPrimaryShape().getFigureLifelineDotLineFigure(), newBounds, lifelineEP.getExecutionSpecificationList(), notToCheckExecutionSpecificationList);
			if(newBounds == null) {
				return null; // UnexecutableCommand.INSTANCE
			}

			CompoundCommand compoundCmd = new CompoundCommand();
			compoundCmd.setLabel("Movement of a ExecutionSpecification EditPart");
			compoundCmd.setDebugLabel("Debug: Movement of a ExecutionSpecification EditPart");

			// Create and add the command to the compound command
			SetBoundsCommand setBoundsCmd = new SetBoundsCommand(executionSpecificationEP.getEditingDomain(), "Resize of a ExecutionSpecification", executionSpecificationEP, newBounds);
			compoundCmd.add(new ICommandProxy(setBoundsCmd));

			Rectangle realMoveDelta = getRealMoveDelta(getRelativeBounds(executionSpecificationEP.getFigure()), newBounds);
			// Move also children
			compoundCmd.add(createMovingAffixedExecutionSpecificationCommand(executionSpecificationEP, realMoveDelta, newBounds));

			compoundCmd.add(createZOrderCommand(lifelineEP, executionSpecificationEP, newBounds, notToCheckExecutionSpecificationList));

			if(!compoundCmd.isEmpty()) {
				return compoundCmd;
			}
		}

		return super.getMoveChildrenCommand(request);
	}

	/**
	 * Command for change ZOrder of ExecutionSpecification ordered from parent to children.
	 * 
	 * @param lifelineEP
	 *        the lifeline ep
	 * @param executionSpecificationEP
	 *        the execution specification ep
	 * @param newBounds
	 *        the new bounds
	 * @param notToCheckExecutionSpecificationList
	 *        the not to check bes list
	 * 
	 * @return the command
	 */
	protected final static Command createZOrderCommand(LifelineEditPart lifelineEP, ShapeNodeEditPart executionSpecificationEP, Rectangle newBounds, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList) {
		List<ShapeNodeEditPart> toCheckExecutionSpecificationList = lifelineEP.getExecutionSpecificationList();
		toCheckExecutionSpecificationList.removeAll(notToCheckExecutionSpecificationList);
		CompoundCommand cmd = new CompoundCommand();
		for(ShapeNodeEditPart externalExecutionSpecificationEP : toCheckExecutionSpecificationList) {
			Rectangle externalExecutionSpecificationBounds = getRelativeBounds(externalExecutionSpecificationEP.getFigure());
			// Check if there is any contact
			if(externalExecutionSpecificationBounds.touches(newBounds)) {
				View containerView = ViewUtil.getContainerView(executionSpecificationEP.getPrimaryView());
				if(containerView != null) {
					int i = 0;
					int parentIndex = -1;
					int childIndex = -1;
					for(Object child : containerView.getChildren()) {
						if(child == externalExecutionSpecificationEP.getPrimaryView()) {
							parentIndex = i;
						} else if(child == executionSpecificationEP.getPrimaryView()) {
							childIndex = i;
						}
						if(parentIndex != -1 && childIndex != -1) {
							if(childIndex > parentIndex) {
								cmd.add(new ICommandProxy(new CustomZOrderCommand(executionSpecificationEP.getEditingDomain(), executionSpecificationEP.getPrimaryView(), parentIndex)));
								cmd.add(new ICommandProxy(new CustomZOrderCommand(externalExecutionSpecificationEP.getEditingDomain(), externalExecutionSpecificationEP.getPrimaryView(), childIndex)));
							} else {
								break;
							}
						}
						i++;
					}
				}
			}
		}

		if(!cmd.isEmpty()) {
			return cmd;
		}
		return null;
	}

	/**
	 * Useful operation to know where the figure of a ExecutionSpecification EditPart should be
	 * positioned within a Lifeline EditPart. The notToCheckList is needed to avoid checking those
	 * ExecutionSpecification EditParts. The returned bounds are relative to the Lifeline figure so
	 * they can be used, directly, within a SetBoundsCommand.
	 * 
	 * @param lifelineDotLineFigure
	 *        TODO
	 * @param newBounds
	 *        The new initial bounds
	 * @param executionSpecifactionEditPart
	 *        TODO
	 * @param notToCheckExecutionSpecificationList
	 *        The ExecutionSpecification EditPart's List that won't be checked
	 * 
	 * @return The new bounds of the executionSpecificationEP figure
	 */
	protected final static Rectangle getExecutionSpecificationNewBoundsForMove(Figure lifelineDotLineFigure, Rectangle newBounds, List<ShapeNodeEditPart> toCheckExecutionSpecificationList, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList) {
		// Lifeline's figure where the child is drawn
		Rectangle dotLineBounds = lifelineDotLineFigure.getBounds();

		// if ExecutionSpecification is move before the lifeline
		if(newBounds.y < dotLineBounds.y || newBounds.x < dotLineBounds.x || newBounds.x > dotLineBounds.right()) {
			return null;
		}

		toCheckExecutionSpecificationList.removeAll(notToCheckExecutionSpecificationList);

		// Check first if there is contact with any of the existing ExecutionSpecification
		Rectangle parentBounds = getParent(newBounds, toCheckExecutionSpecificationList);

		if(parentBounds == null) {
			// No mother, center position
			int width = newBounds.width > 0 ? newBounds.width : EXECUTION_INIT_WIDTH;
			newBounds.x = dotLineBounds.x + dotLineBounds.width / 2 - width / 2;
		} else {

			int width = parentBounds.width > 0 ? parentBounds.width : EXECUTION_INIT_WIDTH;
			newBounds.x = parentBounds.x + width / 2 + 1;
		}

		// Change to relative bounds of the LifelineEP
		newBounds.x -= dotLineBounds.x;
		newBounds.y -= dotLineBounds.y;

		return newBounds;
	}

	/**
	 * Get the (futur) parent of a ExecutionSpecification
	 * 
	 * @param childBounds
	 *        the child bounds
	 * @param toCheckExecutionSpecificationList
	 *        List of EditPart to check
	 * @return The parent bounds
	 */
	protected final static Rectangle getParent(Rectangle childBounds, List<ShapeNodeEditPart> toCheckExecutionSpecificationList) {
		Rectangle parentBounds = null;
		// Loop through the ExecutionSpecification list and try to find the most to the right
		// ExecutionSpecification within the executionSpecificationEP Y-axis bounds
		Rectangle externalBounds = childBounds.getCopy();
		for(ShapeNodeEditPart externalExecutionSpecificationEP : toCheckExecutionSpecificationList) {
			Rectangle externalExecutionSpecificationBounds = externalExecutionSpecificationEP.getFigure().getBounds();
			externalBounds.x = externalExecutionSpecificationBounds.x;
			externalBounds.width = externalExecutionSpecificationBounds.width;
			if(externalExecutionSpecificationBounds.touches(externalBounds)) {
				if(parentBounds == null || externalExecutionSpecificationBounds.x > parentBounds.x) {
					parentBounds = externalExecutionSpecificationBounds;
				}
			}
		}
		return parentBounds;
	}

	/**
	 * Used to modify the sizeDelta if the given value is higher/lower than the highest/lowest
	 * allowed values of the figure.
	 * 
	 * @param figure
	 *        the figure
	 * @param sizeDelta
	 *        the size delta
	 * 
	 * @return a corrected sizeDelta
	 */
	protected final static Dimension adaptSizeDeltaToMaxHeight(IFigure figure, Dimension sizeDelta) {
		Dimension newSizeDelta = new Dimension(sizeDelta);

		int figureHeight = figure.getBounds().height;
		int maximunFigureHeight = figure.getMaximumSize().height;
		int minimunFigureHeight = figure.getMinimumSize().height;

		int height = figureHeight + newSizeDelta.height;
		if(height > maximunFigureHeight) {
			newSizeDelta.height = maximunFigureHeight - figureHeight;
		} else if(height < minimunFigureHeight) {
			newSizeDelta.height = minimunFigureHeight - figureHeight;
		}

		return newSizeDelta;
	}

	/**
	 * Returns all the ExecutionSpecification EditParts that are affixed to the right side of the
	 * given ExecutionSpecification EditPart. Not only the ones directly affixed to the
	 * executionSpecificationEP are returned, but the ones that are indirectly affixed as well (this
	 * is done recursively)
	 * 
	 * @param executionSpecificationEP
	 *        the execution specification ep
	 * 
	 * @return the list of affixed ExecutionSpecification. If there is no affixed
	 *         ExecutionSpecification, then an empty list will be returned
	 */
	protected final static List<ShapeNodeEditPart> getAffixedExecutionSpecificationEditParts(ShapeNodeEditPart executionSpecificationEP) {
		List<ShapeNodeEditPart> notToCheckExecutionSpecificationList = new ArrayList<ShapeNodeEditPart>();
		return getAffixedExecutionSpecificationEditParts(executionSpecificationEP, notToCheckExecutionSpecificationList);

	}

	/**
	 * Operation used by the above operation. It's main goal is to obtain, recursively, all the
	 * affixed ExecutionSpecification. In order to do so, it is needed a ExecutionSpecification
	 * EditPart and the notToCheckList.
	 * 
	 * @param executionSpecificationEP
	 *        the execution specification ep
	 * @param notToCheckExecutionSpecificationList
	 *        the not to check ExecutionSpecification list
	 * 
	 * @return the list of affixed ExecutionSpecification. If there is no affixed
	 *         ExecutionSpecification, then an empty list will be returned
	 */
	protected final static List<ShapeNodeEditPart> getAffixedExecutionSpecificationEditParts(ShapeNodeEditPart executionSpecificationEP, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList) {
		// Add itself to the notToCheck list
		List<ShapeNodeEditPart> newNotToCheckExecutionSpecificationList = new ArrayList<ShapeNodeEditPart>(notToCheckExecutionSpecificationList);
		newNotToCheckExecutionSpecificationList.add(executionSpecificationEP);

		// LifelineEditPart where the ExecutionSpecification EditPart is contained
		LifelineEditPart lifelineEP = (LifelineEditPart)executionSpecificationEP.getParent();

		// ExecutionSpecification EditParts list
		List<ShapeNodeEditPart> executionSpecificationList = lifelineEP.getExecutionSpecificationList();
		executionSpecificationList.remove(newNotToCheckExecutionSpecificationList);

		// List to store the Affixed ExecutionSpecification
		List<ShapeNodeEditPart> affixedExecutionSpecificationList = new ArrayList<ShapeNodeEditPart>();

		// Loop ExecutionSpecificationough the ExecutionSpecification list
		for(ShapeNodeEditPart childExecutionSpecificationEP : executionSpecificationList) {
			if(isAffixedToRight(executionSpecificationEP.getFigure().getBounds(), childExecutionSpecificationEP.getFigure().getBounds())) {
				affixedExecutionSpecificationList.add(childExecutionSpecificationEP);
				// Add also it's affixed ExecutionSpecification
				affixedExecutionSpecificationList.addAll(getAffixedExecutionSpecificationEditParts(childExecutionSpecificationEP, newNotToCheckExecutionSpecificationList));
			}
		}

		// To the ExecutionSpecification list
		return affixedExecutionSpecificationList;
	}

	/**
	 * Checks whether the right EditPart is affixed to the left EditPart. In order to do so, the
	 * operation checks if the right figure is really on the right and, if so, it just returns true
	 * if figures touch each other.
	 * 
	 * @param leftFigure
	 *        The left rectangle
	 * @param rightFigure
	 *        The right rectangle
	 * 
	 * @return true if the rectangles of both figures touch and the right figure is really on the
	 *         right. False otherwise
	 */
	protected final static boolean isAffixedToRight(Rectangle leftFigure, Rectangle rightFigure) {
		return leftFigure.touches(rightFigure) && leftFigure.x < rightFigure.x;
	}

	/**
	 * If a ExecutionSpecification EditPart is going to be moved according to a moveDelta, this
	 * operation returns a compoundCommand that also moves the affixed ExecutionSpecification
	 * according to that delta.
	 * 
	 * @param executionSpecificationEP
	 *        The ExecutionSpecification EditPart that is going to be moved
	 * @param moveDelta
	 *        The moveDelta of the previous EditPart
	 * @param newBounds
	 *        the new bounds
	 * 
	 * @return the compound command
	 */
	protected final static CompoundCommand createMovingAffixedExecutionSpecificationCommand(ShapeNodeEditPart executionSpecificationEP, Rectangle moveDelta, Rectangle newBounds) {
		if(moveDelta.y != 0 || moveDelta.height != 0) {
			CompoundCommand compoundCmd = new CompoundCommand();
			for(ShapeNodeEditPart childExecutionSpecificationEP : getAffixedExecutionSpecificationEditParts(executionSpecificationEP)) {
				// Get Relative Bounds
				Rectangle childBounds = getRelativeBounds(childExecutionSpecificationEP.getFigure());
				// Apply delta
				childBounds.y += moveDelta.y;
				childBounds.x += moveDelta.x;

				// Create the child's SetBoundsCommand
				SetBoundsCommand childSetBoundsCmd = new SetBoundsCommand(executionSpecificationEP.getEditingDomain(), "Movement of affixed ExecutionSpecification", childExecutionSpecificationEP, childBounds);
				compoundCmd.add(new ICommandProxy(childSetBoundsCmd));
				// Move it's children as well
				if(!getAffixedExecutionSpecificationEditParts(childExecutionSpecificationEP).isEmpty()) {
					compoundCmd.add(createMovingAffixedExecutionSpecificationCommand(childExecutionSpecificationEP, moveDelta, childBounds));
				}
			}
			if(!compoundCmd.isEmpty()) {
				return compoundCmd;
			}
		}
		return null;
	}

	/**
	 * Given an AbstractGraphialEditPart and the new relative bounds that the EditPart will have, it
	 * returns the real delta applied to the movement.
	 * 
	 * @param oldRelativeBounds
	 *        The old position of the mentioned EditPart
	 * @param newRelativeBounds
	 *        The new position of the mentioned EditPart
	 * 
	 * @return The real MoveDelta applied
	 */
	protected final static Rectangle getRealMoveDelta(Rectangle oldRelativeBounds, Rectangle newRelativeBounds) {
		Rectangle realMoveDelta = new Rectangle();
		realMoveDelta.x = newRelativeBounds.x - oldRelativeBounds.x;
		realMoveDelta.y = newRelativeBounds.y - oldRelativeBounds.y;
		realMoveDelta.height = newRelativeBounds.height - oldRelativeBounds.height;
		realMoveDelta.width = newRelativeBounds.width - oldRelativeBounds.width;
		return realMoveDelta;
	}

	/**
	 * It returns the relative bounds of an Figure.
	 * 
	 * @param figure
	 *        The Figure
	 * 
	 * @return The relative bounds regarding it's parent figure
	 */
	protected final static Rectangle getRelativeBounds(IFigure figure) {
		Rectangle relBounds = figure.getBounds().getCopy();
		Rectangle parentRectangle = figure.getParent().getBounds();
		relBounds.x -= parentRectangle.x;
		relBounds.y -= parentRectangle.y;
		return relBounds;
	}

}
