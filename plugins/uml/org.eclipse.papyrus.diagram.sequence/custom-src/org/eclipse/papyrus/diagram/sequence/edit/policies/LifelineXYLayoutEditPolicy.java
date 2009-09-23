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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.PreserveAnchorsPositionCommand;
import org.eclipse.papyrus.diagram.sequence.command.CustomZOrderCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;

/**
 * The customn LayoutEditPolicy for LifelineEditPart.
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
	public Command getCommand(Request request) {
		if (request instanceof ChangeBoundsRequest
				&& (request.getType().equals(REQ_RESIZE) || request.getType().equals(REQ_MOVE))) {
			CompoundCommand compoundCmd = new CompoundCommand();
			compoundCmd.setLabel("Movement or Resize of a Lifeline EditPart");
			compoundCmd.setDebugLabel("Debug: Movement or Resize of a Lifeline EditPart");

			ChangeBoundsRequest cbr = (ChangeBoundsRequest) request;
			List<?> editParts = cbr.getEditParts();

			if (editParts != null && editParts.contains(getHost()) && cbr.getSizeDelta().width != 0) {
				// If the width increases or decreases, ExecutionSpecification elements need to be
				// moved
				for (Object obj : getHost().getChildren()) {
					if (obj instanceof ShapeNodeEditPart) {
						ShapeNodeEditPart executionSpecificationEP = (ShapeNodeEditPart) obj;

						// Lifeline's figure where the child is drawn
						Rectangle rDotLine = executionSpecificationEP.getFigure().getParent().getBounds();

						// The new bounds will be calculated from the current bounds
						Rectangle newBounds = executionSpecificationEP.getFigure().getBounds().getCopy();

						// Apply SizeDelta to the children
						newBounds.x += Math.round((float) cbr.getSizeDelta().width / (float) 2);

						// Convert to relative
						newBounds.x -= rDotLine.x;
						newBounds.y -= rDotLine.y;

						SetBoundsCommand setBoundsCmd = new SetBoundsCommand(executionSpecificationEP
								.getEditingDomain(),
								"Re-location of a ExecutionSpecification due to a Lifeline movement",
								executionSpecificationEP, newBounds);
						compoundCmd.add(new ICommandProxy(setBoundsCmd));
					}
				}

				if (!compoundCmd.isEmpty()) {
					return compoundCmd;
				}
			}
		}

		return super.getCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest cver = (CreateViewAndElementRequest) request;

			LifelineEditPart lifelineEditPart = (LifelineEditPart) getHost();
			TransactionalEditingDomain eDomain = lifelineEditPart.getEditingDomain();
			IAdaptable adapter = cver.getViewAndElementDescriptor();

			// Translate the absolute location to relative
			Point newLocation = cver.getLocation().getCopy();

			if (newLocation.x < 0 || newLocation.y < 0) {
				newLocation.x = newLocation.y = 0;
			}

			lifelineEditPart.getPrimaryShape().getFigureLifelineDotLineFigure().translateToRelative(newLocation);

			int newHeight;
			if (cver.getSize() != null) {
				newHeight = cver.getSize().height;
			} else {
				newHeight = EXECUTION_INIT_HEIGHT;
			}

			Rectangle newBounds = new Rectangle(newLocation.x, newLocation.y, -1, newHeight);
			newBounds = getExecutionSpecificationNewBoundsForMove(lifelineEditPart, newBounds,
					new ArrayList<ShapeNodeEditPart>(0));
			if (newBounds == null) {
				return UnexecutableCommand.INSTANCE;
			}

			SetBoundsCommand setBoundsCmd = new SetBoundsCommand(eDomain, "Creation of an ExecutionSpecification",
					adapter, newBounds);

			return new ICommandProxy(setBoundsCmd);
		}

		return super.getCreateCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
		CompoundCommand compoundCmd = new CompoundCommand();
		compoundCmd.setLabel("Resize of a ExecutionSpecification EditPart");
		compoundCmd.setDebugLabel("Debug: Resize of a ExecutionSpecification EditPart");

		ChangeBoundsRequest cbr = (ChangeBoundsRequest) request;
		List<?> editParts = cbr.getEditParts();

		// This policy is hosted in a LifelineEditPart
		LifelineEditPart lifelineEP = (LifelineEditPart) getHost();

		// We are supposed to work with only one children at a time
		if (editParts != null && editParts.size() == 1
				&& lifelineEP.getExecutionSpecificationList().contains(editParts.get(0))) {
			// The child's EditPart
			ShapeNodeEditPart executionSpecificationEP = (ShapeNodeEditPart) editParts.get(0);

			// Check if height is within the limits of the figure
			Dimension newSizeDelta = adaptSizeDeltaToMaxHeight(executionSpecificationEP.getFigure(), cbr.getSizeDelta());

			// New delta to preserve the position of the last link's
			// anchor
			newSizeDelta = PreserveAnchorsPositionCommand.getSizeDeltaToFitAnchors(executionSpecificationEP,
					newSizeDelta, PreserveAnchorsPositionCommand.PRESERVE_Y);

			// Current bounds of the ExecutionSpecification
			Rectangle newBounds = executionSpecificationEP.getFigure().getBounds().getCopy();

			// According to the parameters, the new bounds would be the following
			newBounds.x += cbr.getMoveDelta().x;
			newBounds.y += cbr.getMoveDelta().y;
			newBounds.height += newSizeDelta.height;

			// Not to check list
			List<ShapeNodeEditPart> notToCheckExecutionSpecificationList = new BasicEList<ShapeNodeEditPart>();
			// Affixed ExecutionSpecification List
			List<ShapeNodeEditPart> affixedExecutionSpecificationEditParts = getAffixedExecutionSpecificationEditParts(executionSpecificationEP);
			notToCheckExecutionSpecificationList.addAll(affixedExecutionSpecificationEditParts);
			// Add also current ExecutionSpecification EditPart
			notToCheckExecutionSpecificationList.add(executionSpecificationEP);

			newBounds = getExecutionSpecificationNewBoundsForResize(lifelineEP, newBounds,
					notToCheckExecutionSpecificationList);
			if (newBounds == null) {
				return null; // UnexecutableCommand.INSTANCE
			}

			for (ShapeNodeEditPart childExecutionSpecificationEP : affixedExecutionSpecificationEditParts) {
				Rectangle childExecutionSpecificationBounds = getRelativeBounds(childExecutionSpecificationEP
						.getFigure());
				// Block resized parent if child is taller
				if (newBounds.height < childExecutionSpecificationBounds.height) {
					return null; // UnexecutableCommand.INSTANCE
				}
			}

			// Create and add the command to the compound command
			SetBoundsCommand setBoundsCmd = new SetBoundsCommand(executionSpecificationEP.getEditingDomain(),
					"Resize of a ExecutionSpecification", executionSpecificationEP, newBounds);
			compoundCmd.add(new ICommandProxy(setBoundsCmd));

			Rectangle realMoveDelta = getRealMoveDelta(getRelativeBounds(executionSpecificationEP.getFigure()),
					newBounds);
			// Move also children
			compoundCmd.add(createMovingAffixedExecutionSpecificationCommand(executionSpecificationEP, realMoveDelta,
					newBounds));
			// Move also parents
			compoundCmd.add(createResizeParentExecutionSpecificationCommand(lifelineEP, newBounds,
					notToCheckExecutionSpecificationList, realMoveDelta));

			// Modify anchors to preserve their positions after the re-size
			compoundCmd.add(new ICommandProxy(new PreserveAnchorsPositionCommand(executionSpecificationEP,
					newSizeDelta, PreserveAnchorsPositionCommand.PRESERVE_Y)));

			if (!compoundCmd.isEmpty()) {
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
	 *            the lifeline ep
	 * @param newBounds
	 *            The new initial bounds
	 * @param notToCheckExecutionSpecificationList
	 *            The ExecutionSpecification EditPart's List that won't be checked
	 * 
	 * @return The new bounds of the executionSpecificationEP figure
	 */
	protected final static Rectangle getExecutionSpecificationNewBoundsForResize(LifelineEditPart lifelineEP,
			Rectangle newBounds, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList) {
		// Lifeline's figure where the child is drawn
		Rectangle dotLineBounds = lifelineEP.getPrimaryShape().getFigureLifelineDotLineFigure().getBounds();

		// if ExecutionSpecification is move before the lifeline
		if (newBounds.y < dotLineBounds.y || newBounds.x < dotLineBounds.x || newBounds.x > dotLineBounds.right()) {
			return null;
		}

		List<ShapeNodeEditPart> toCheckExecutionSpecificationList = lifelineEP.getExecutionSpecificationList();
		toCheckExecutionSpecificationList.removeAll(notToCheckExecutionSpecificationList);

		// Check first if there is contact with any of the existing ExecutionSpecification
		Rectangle parentBounds = null;

		parentBounds = getDirectParent(newBounds, toCheckExecutionSpecificationList);

		// Case there weren't any contact
		if (parentBounds != null) {
			if (parentBounds.x >= newBounds.x) {
				// If the two ExecutionSpecification haven't a relationship
				return null;
			} else if (newBounds.y < parentBounds.y) {
				return null;
			}
		}

		// Change to relative bounds of the LifelineEP
		newBounds.x -= dotLineBounds.x;
		newBounds.y -= dotLineBounds.y;

		return newBounds;
	}

	/**
	 * Create resizing parents ExecutionSpecification command when child wants to finish after its
	 * parents.
	 * 
	 * @param lifelineEP
	 *            the lifeline ep
	 * @param newBounds
	 *            the new bounds
	 * @param notToCheckExecutionSpecificationList
	 *            the not to check ExecutionSpecification list
	 * @param moveDelta
	 *            the move delta
	 * 
	 * @return The resizing command
	 */
	protected final static Command createResizeParentExecutionSpecificationCommand(LifelineEditPart lifelineEP,
			Rectangle newBounds, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList, Rectangle moveDelta) {
		if (moveDelta.height != 0) {
			CompoundCommand compoundCmd = new CompoundCommand();

			List<ShapeNodeEditPart> toCheckExecutionSpecificationList = lifelineEP.getExecutionSpecificationList();
			toCheckExecutionSpecificationList.removeAll(notToCheckExecutionSpecificationList);

			Rectangle externalBounds = newBounds.getCopy();
			for (ShapeNodeEditPart externalExecutionSpecificationEP : toCheckExecutionSpecificationList) {
				Rectangle externalExecutionSpecificationBounds = getRelativeBounds(externalExecutionSpecificationEP
						.getFigure());

				externalBounds.x = externalExecutionSpecificationBounds.x;
				// Check if there is any contact
				if (externalExecutionSpecificationBounds.touches(externalBounds)) {
					// Resize if child finish after parent
					if (externalExecutionSpecificationBounds.bottom() < newBounds.bottom()) {
						externalExecutionSpecificationBounds.height = newBounds.bottom()
								- externalExecutionSpecificationBounds.y;
						SetBoundsCommand childSetBoundsCmd = new SetBoundsCommand(externalExecutionSpecificationEP
								.getEditingDomain(), "Movement of parent ExecutionSpecification",
								externalExecutionSpecificationEP, externalExecutionSpecificationBounds);
						compoundCmd.add(new ICommandProxy(childSetBoundsCmd));
					}
				}
			}

			if (!compoundCmd.isEmpty()) {
				return compoundCmd;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getMoveChildrenCommand(Request request) {
		CompoundCommand compoundCmd = new CompoundCommand();
		compoundCmd.setLabel("Movement of a ExecutionSpecification EditPart");
		compoundCmd.setDebugLabel("Debug: Movement of a ExecutionSpecification EditPart");

		ChangeBoundsRequest cbr = (ChangeBoundsRequest) request;
		List<?> editParts = cbr.getEditParts();

		// This policy is hosted in a LifelineEditPart
		LifelineEditPart lifelineEP = (LifelineEditPart) getHost();

		// We are supposed to work with only one children at a time
		if (editParts != null && editParts.size() == 1
				&& lifelineEP.getExecutionSpecificationList().contains(editParts.get(0))) {
			// The child's EditPart
			ShapeNodeEditPart executionSpecificationEP = (ShapeNodeEditPart) editParts.get(0);

			// Check if height is within the limits of the figure
			Dimension newSizeDelta = adaptSizeDeltaToMaxHeight(executionSpecificationEP.getFigure(), cbr.getSizeDelta());

			// New delta to preserve the position of the last link's
			// anchor
			newSizeDelta = PreserveAnchorsPositionCommand.getSizeDeltaToFitAnchors(executionSpecificationEP,
					newSizeDelta, PreserveAnchorsPositionCommand.PRESERVE_Y);

			// Current bounds of the ExecutionSpecification
			Rectangle newBounds = executionSpecificationEP.getFigure().getBounds().getCopy();

			// According to the parameters, the new bounds would be the following
			newBounds.x += cbr.getMoveDelta().x;
			newBounds.y += cbr.getMoveDelta().y;
			newBounds.height += newSizeDelta.height;

			// Not to check list
			List<ShapeNodeEditPart> notToCheckExecutionSpecificationList = new BasicEList<ShapeNodeEditPart>();
			// Affixed ExecutionSpecification List
			notToCheckExecutionSpecificationList
					.addAll(getAffixedExecutionSpecificationEditParts(executionSpecificationEP));
			// Add also current ExecutionSpecification EditPart
			notToCheckExecutionSpecificationList.add(executionSpecificationEP);

			newBounds = getExecutionSpecificationNewBoundsForMove(lifelineEP, newBounds,
					notToCheckExecutionSpecificationList);
			if (newBounds == null) {
				return null; // UnexecutableCommand.INSTANCE
			}

			// Create and add the command to the compound command
			SetBoundsCommand setBoundsCmd = new SetBoundsCommand(executionSpecificationEP.getEditingDomain(),
					"Resize of a ExecutionSpecification", executionSpecificationEP, newBounds);
			compoundCmd.add(new ICommandProxy(setBoundsCmd));

			Rectangle realMoveDelta = getRealMoveDelta(getRelativeBounds(executionSpecificationEP.getFigure()),
					newBounds);
			// Move also children
			compoundCmd.add(createMovingAffixedExecutionSpecificationCommand(executionSpecificationEP, realMoveDelta,
					newBounds));

			// Modify anchors to preserve their positions after
			// the re-size
			compoundCmd.add(new ICommandProxy(new PreserveAnchorsPositionCommand(executionSpecificationEP,
					newSizeDelta, PreserveAnchorsPositionCommand.PRESERVE_Y)));

			compoundCmd.add(createZOrderCommand(lifelineEP, executionSpecificationEP, newBounds,
					notToCheckExecutionSpecificationList));

			if (!compoundCmd.isEmpty()) {
				return compoundCmd;
			}
		}

		return super.getMoveChildrenCommand(request);
	}

	/**
	 * Command for change ZOrder of ExecutionSpecification ordered from parent to children.
	 * 
	 * @param lifelineEP
	 *            the lifeline ep
	 * @param executionSpecificationEP
	 *            the execution specification ep
	 * @param newBounds
	 *            the new bounds
	 * @param notToCheckExecutionSpecificationList
	 *            the not to check bes list
	 * 
	 * @return the command
	 */
	protected final static Command createZOrderCommand(LifelineEditPart lifelineEP,
			ShapeNodeEditPart executionSpecificationEP, Rectangle newBounds,
			List<ShapeNodeEditPart> notToCheckExecutionSpecificationList) {
		List<ShapeNodeEditPart> toCheckExecutionSpecificationList = lifelineEP.getExecutionSpecificationList();
		toCheckExecutionSpecificationList.removeAll(notToCheckExecutionSpecificationList);
		CompoundCommand cmd = new CompoundCommand();
		for (ShapeNodeEditPart externalExecutionSpecificationEP : toCheckExecutionSpecificationList) {
			Rectangle externalExecutionSpecificationBounds = getRelativeBounds(externalExecutionSpecificationEP
					.getFigure());
			// Check if there is any contact
			if (externalExecutionSpecificationBounds.touches(newBounds)) {
				View containerView = ViewUtil.getContainerView(executionSpecificationEP.getPrimaryView());
				if (containerView != null) {
					int i = 0;
					int parentIndex = -1;
					int childIndex = -1;
					for (Object child : containerView.getChildren()) {
						if (child == externalExecutionSpecificationEP.getPrimaryView()) {
							parentIndex = i;
						} else if (child == executionSpecificationEP.getPrimaryView()) {
							childIndex = i;
						}
						if (parentIndex != -1 && childIndex != -1) {
							if (childIndex > parentIndex) {
								cmd.add(new ICommandProxy(new CustomZOrderCommand(executionSpecificationEP
										.getEditingDomain(), executionSpecificationEP.getPrimaryView(), parentIndex)));
								cmd.add(new ICommandProxy(new CustomZOrderCommand(externalExecutionSpecificationEP
										.getEditingDomain(), externalExecutionSpecificationEP.getPrimaryView(),
										childIndex)));
							} else {
								break;
							}
						}
						i++;
					}
				}
			}
		}

		if (!cmd.isEmpty()) {
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
	 * @param lifelineEP
	 *            the lifeline ep
	 * @param newBounds
	 *            The new initial bounds
	 * @param notToCheckExecutionSpecificationList
	 *            The ExecutionSpecification EditPart's List that won't be checked
	 * 
	 * @return The new bounds of the executionSpecificationEP figure
	 */
	protected final static Rectangle getExecutionSpecificationNewBoundsForMove(LifelineEditPart lifelineEP,
			Rectangle newBounds, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList) {
		// Lifeline's figure where the child is drawn
		Rectangle dotLineBounds = lifelineEP.getPrimaryShape().getFigureLifelineDotLineFigure().getBounds();

		// if ExecutionSpecification is move before the lifeline
		if (newBounds.y < dotLineBounds.y || newBounds.x < dotLineBounds.x || newBounds.x > dotLineBounds.right()) {
			return null;
		}

		List<ShapeNodeEditPart> toCheckExecutionSpecificationList = lifelineEP.getExecutionSpecificationList();
		toCheckExecutionSpecificationList.removeAll(notToCheckExecutionSpecificationList);

		// Check first if there is contact with any of the existing ExecutionSpecification
		Rectangle parentBounds = getDirectParent(newBounds, toCheckExecutionSpecificationList);

		// Case there weren't any contact
		if (parentBounds == null) {
			parentBounds = getParent(newBounds, toCheckExecutionSpecificationList);
		}

		if (parentBounds == null) {
			// No mother, center position
			int width = newBounds.width > 0 ? newBounds.width : EXECUTION_INIT_WIDTH;
			newBounds.x = dotLineBounds.x + dotLineBounds.width / 2 - width / 2;
		} else {
			// Child can't begin before mother
			if (newBounds.y < parentBounds.y) {
				return null;
			} else if (newBounds.bottom() > parentBounds.bottom()) {
				return null;
			}

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
	 *            the child bounds
	 * @param toCheckExecutionSpecificationList
	 *            List of EditPart to check
	 * @return The parent bounds
	 */
	protected final static Rectangle getParent(Rectangle childBounds,
			List<ShapeNodeEditPart> toCheckExecutionSpecificationList) {
		Rectangle parentBounds = null;
		// Loop through the ExecutionSpecification list and try to find the most to the right
		// ExecutionSpecification within the executionSpecificationEP Y-axis bounds
		Rectangle externalBounds = childBounds.getCopy();
		for (ShapeNodeEditPart externalExecutionSpecificationEP : toCheckExecutionSpecificationList) {
			Rectangle externalExecutionSpecificationBounds = externalExecutionSpecificationEP.getFigure().getBounds();
			externalBounds.x = externalExecutionSpecificationBounds.x;
			externalBounds.width = externalExecutionSpecificationBounds.width;
			if (externalExecutionSpecificationBounds.touches(externalBounds)) {
				if (parentBounds == null || externalExecutionSpecificationBounds.x > parentBounds.x) {
					parentBounds = externalExecutionSpecificationBounds;
				}
			}
		}
		return parentBounds;
	}

	/**
	 * Get the parent of a ExecutionSpecification
	 * 
	 * @param childBounds
	 *            the child bounds
	 * @param toCheckExecutionSpecificationList
	 *            List of EditPart to check
	 * @return The parent bounds
	 */
	protected final static Rectangle getDirectParent(Rectangle childBounds,
			List<ShapeNodeEditPart> toCheckExecutionSpecificationList) {
		Rectangle parentBounds = null;

		// Iterate through the toCheckExecutionSpecificationList
		for (ShapeNodeEditPart externalExecutionSpecificationEP : toCheckExecutionSpecificationList) {
			Rectangle externalExecutionSpecificationBounds = externalExecutionSpecificationEP.getFigure().getBounds();

			// Check if there is any contact
			if (childBounds.touches(externalExecutionSpecificationBounds)) {
				if (parentBounds == null || externalExecutionSpecificationBounds.x > parentBounds.x) {
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
	 *            the figure
	 * @param sizeDelta
	 *            the size delta
	 * 
	 * @return a corrected sizeDelta
	 */
	protected final static Dimension adaptSizeDeltaToMaxHeight(IFigure figure, Dimension sizeDelta) {
		Dimension newSizeDelta = new Dimension(sizeDelta);

		int figureHeight = figure.getBounds().height;
		int maximunFigureHeight = figure.getMaximumSize().height;
		int minimunFigureHeight = figure.getMinimumSize().height;

		int height = figureHeight + newSizeDelta.height;
		if (height > maximunFigureHeight) {
			newSizeDelta.height = maximunFigureHeight - figureHeight;
		} else if (height < minimunFigureHeight) {
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
	 *            the execution specification ep
	 * 
	 * @return the list of affixed ExecutionSpecification. If there is no affixed
	 *         ExecutionSpecification, then an empty list will be returned
	 */
	protected final static List<ShapeNodeEditPart> getAffixedExecutionSpecificationEditParts(
			ShapeNodeEditPart executionSpecificationEP) {
		List<ShapeNodeEditPart> notToCheckExecutionSpecificationList = new ArrayList<ShapeNodeEditPart>();
		return getAffixedExecutionSpecificationEditParts(executionSpecificationEP, notToCheckExecutionSpecificationList);

	}

	/**
	 * Operation used by the above operation. It's main goal is to obtain, recursively, all the
	 * affixed ExecutionSpecification. In order to do so, it is needed a ExecutionSpecification
	 * EditPart and the notToCheckList.
	 * 
	 * @param executionSpecificationEP
	 *            the execution specification ep
	 * @param notToCheckExecutionSpecificationList
	 *            the not to check ExecutionSpecification list
	 * 
	 * @return the list of affixed ExecutionSpecification. If there is no affixed
	 *         ExecutionSpecification, then an empty list will be returned
	 */
	protected final static List<ShapeNodeEditPart> getAffixedExecutionSpecificationEditParts(
			ShapeNodeEditPart executionSpecificationEP, List<ShapeNodeEditPart> notToCheckExecutionSpecificationList) {
		// Add itself to the notToCheck list
		List<ShapeNodeEditPart> newNotToCheckExecutionSpecificationList = new ArrayList<ShapeNodeEditPart>(
				notToCheckExecutionSpecificationList);
		newNotToCheckExecutionSpecificationList.add(executionSpecificationEP);

		// LifelineEditPart where the ExecutionSpecification EditPart is contained
		LifelineEditPart lifelineEP = (LifelineEditPart) executionSpecificationEP.getParent();

		// ExecutionSpecification EditParts list
		List<ShapeNodeEditPart> executionSpecificationList = lifelineEP.getExecutionSpecificationList();
		executionSpecificationList.remove(newNotToCheckExecutionSpecificationList);

		// List to store the Affixed ExecutionSpecification
		List<ShapeNodeEditPart> affixedExecutionSpecificationList = new ArrayList<ShapeNodeEditPart>();

		// Loop ExecutionSpecificationough the ExecutionSpecification list
		for (ShapeNodeEditPart childExecutionSpecificationEP : executionSpecificationList) {
			if (isAffixedToRight(executionSpecificationEP.getFigure().getBounds(), childExecutionSpecificationEP
					.getFigure().getBounds())) {
				affixedExecutionSpecificationList.add(childExecutionSpecificationEP);
				// Add also it's affixed ExecutionSpecification
				affixedExecutionSpecificationList.addAll(getAffixedExecutionSpecificationEditParts(
						childExecutionSpecificationEP, newNotToCheckExecutionSpecificationList));
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
	 *            The left rectangle
	 * @param rightFigure
	 *            The right rectangle
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
	 *            The ExecutionSpecification EditPart that is going to be moved
	 * @param moveDelta
	 *            The moveDelta of the previous EditPart
	 * @param newBounds
	 *            the new bounds
	 * 
	 * @return the compound command
	 */
	protected final static CompoundCommand createMovingAffixedExecutionSpecificationCommand(
			ShapeNodeEditPart executionSpecificationEP, Rectangle moveDelta, Rectangle newBounds) {
		if (moveDelta.y != 0 || moveDelta.height != 0) {
			CompoundCommand compoundCmd = new CompoundCommand();
			for (ShapeNodeEditPart childExecutionSpecificationEP : getAffixedExecutionSpecificationEditParts(executionSpecificationEP)) {
				// Get Relative Bounds
				Rectangle childBounds = getRelativeBounds(childExecutionSpecificationEP.getFigure());
				// Apply delta
				if (newBounds.bottom() < childBounds.bottom() + moveDelta.y) {
					childBounds.y = newBounds.bottom() - childBounds.height;
				} else {
					childBounds.y += moveDelta.y;
				}
				childBounds.x += moveDelta.x;
				// Create the child's SetBoundsCommand
				SetBoundsCommand childSetBoundsCmd = new SetBoundsCommand(executionSpecificationEP.getEditingDomain(),
						"Movement of affixed ExecutionSpecification", childExecutionSpecificationEP, childBounds);
				compoundCmd.add(new ICommandProxy(childSetBoundsCmd));
				// Move it's children as well
				if (!getAffixedExecutionSpecificationEditParts(childExecutionSpecificationEP).isEmpty()) {
					compoundCmd.add(createMovingAffixedExecutionSpecificationCommand(childExecutionSpecificationEP,
							moveDelta, childBounds));
				}
			}
			if (!compoundCmd.isEmpty()) {
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
	 *            The old position of the mentioned EditPart
	 * @param newRelativeBounds
	 *            The new position of the mentioned EditPart
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
	 *            The Figure
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
