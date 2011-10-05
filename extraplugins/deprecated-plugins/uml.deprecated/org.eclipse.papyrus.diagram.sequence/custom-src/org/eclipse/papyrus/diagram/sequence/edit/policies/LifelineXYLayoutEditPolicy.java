/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram Implementation
 *				 Francisco Javier Cano Muñoz - Expanded functionality
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;

import org.eclipse.papyrus.diagram.common.commands.PreserveAnchorsPositionCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageOrderCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;

public class LifelineXYLayoutEditPolicy extends XYLayoutEditPolicy {

	private final static int EXECUTION_INIT_WIDTH = 16;
	private final static int EXECUTION_INIT_HEIGHT = 60;

	@Override
	public Command getCommand(Request request) {
		if (request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest cbr = (ChangeBoundsRequest) request;

			// This policy is hosted in a LifelineEditPart
			LifelineEditPart lifelineEP = (LifelineEditPart) getHost();

			// Compound Command
			CompoundCommand compoundCmd = new CompoundCommand();
			compoundCmd.setLabel("Movement or Resize of a BES EditPart");
			compoundCmd
					.setDebugLabel("Debug: Movement or Resize of a BES EditPart");

			
			// CASE 1: Resize of the own Lifeline
			if (cbr.getEditParts() != null && cbr.getEditParts().contains(getHost()) && cbr.getSizeDelta().width != 0) {
				// If the width increases or decreases, BES elements need to be moved
				for (Object obj: getHost().getChildren()) {
					if (obj instanceof BehaviorExecutionSpecificationEditPart) {
						BehaviorExecutionSpecificationEditPart besEP = (BehaviorExecutionSpecificationEditPart) obj;

						// Lifeline's figure where the child is drawn
						Rectangle rDotLine = besEP.getFigure().getParent().getBounds()
								.getCopy();
						
						// The new bounds will be calculated from the current
						// bounds
						Rectangle newBounds = besEP.getFigure().getBounds().getCopy();

						// Apply SizeDelta to the children
						newBounds.x += Math
								.round((float) cbr.getSizeDelta().width
										/ (float) 2);

						// Convert to relative
						newBounds.x -= rDotLine.x;
						newBounds.y -= rDotLine.y;
						
						SetBoundsCommand setBoundsCmd = new SetBoundsCommand(besEP.getEditingDomain(),
								"Re-location of a BES due to a Lifeline movement", besEP, newBounds);
						compoundCmd.add(new ICommandProxy(setBoundsCmd));
					}
				}
			}
			
			// CASE 2: Resize or movement of one child
			// We are supposed to work with only one children at a time
			else if (cbr.getEditParts() != null
					&& cbr.getEditParts().size() == 1
					&& lifelineEP.getBESList().contains(
							cbr.getEditParts().get(0))) {

				// The child's EditPart
				BehaviorExecutionSpecificationEditPart besEP = (BehaviorExecutionSpecificationEditPart) cbr
						.getEditParts().get(0);

				// The SetBounds command need an adapter. Nothing to worry, the
				// child itself implements the IAdaptable interface
				IAdaptable adapter = besEP;

				// Obtain the editing domain from the child's EditPart
				TransactionalEditingDomain eDomain = besEP.getEditingDomain();

				// Check if height is within the limits of the figure
				Dimension newSizeDelta = adaptSizeDeltaToMaxHeight(besEP
						.getFigure(), cbr.getSizeDelta());
				
				// New delta to preserve the position of the last link's
				// anchor
				newSizeDelta = PreserveAnchorsPositionCommand
						.getSizeDeltaToFitAnchors(besEP, newSizeDelta,
								PreserveAnchorsPositionCommand.PRESERVE_Y);
				
				// Get the new BES bounds.
				Rectangle newBounds = getBESNewBounds(lifelineEP, besEP, cbr
						.getMoveDelta(), newSizeDelta);

				// Create and add the command to the compound command
				SetBoundsCommand setBoundsCmd = new SetBoundsCommand(eDomain,
						"Resize of a BES", adapter, newBounds);
				compoundCmd.add(new ICommandProxy(setBoundsCmd));
				
				// Apart from moving the selected BES, it's affixed BES should
				// also be moved
				Point realMoveDelta = getRealMoveDelta(besEP, newBounds);
				if (realMoveDelta.y != 0) {
					CompoundCommand auxCmd = getMoveAffixedBESCommand(besEP,
							realMoveDelta);
					if (auxCmd != null && auxCmd.size() > 0)
						compoundCmd.add(auxCmd);
				}

				// Modify anchors to preserve their positions after
				// the re-size
				compoundCmd.add(new ICommandProxy(
						new PreserveAnchorsPositionCommand(besEP, newSizeDelta,
								PreserveAnchorsPositionCommand.PRESERVE_Y)));

				// Ordering should be updated
				// parent
				compoundCmd.add(new MessageOrderCommand(besEP));
				// affixed BES
				CompoundCommand affixedBesOrderCmd = getAffixedBESMessageOrderCommand(besEP);
				if (affixedBesOrderCmd.size() > 0)
					compoundCmd.add(affixedBesOrderCmd);
				
			}

			// return the compoundCmd
			if (compoundCmd.size() == 0)
				return super.getCommand(request);
			else
				return compoundCmd;
		}

		if (request instanceof CreateViewAndElementRequest) {

			CreateViewAndElementRequest cver = (CreateViewAndElementRequest) request;
			LifelineEditPart lifelineEditPart = (LifelineEditPart) getHost();

			TransactionalEditingDomain eDomain = lifelineEditPart
					.getEditingDomain();
			IAdaptable adapter = cver.getViewAndElementDescriptor();

			// Translate the absolute location to relative
			Point newLocation = cver.getLocation().getCopy();
			
			if (newLocation.x < 0 || newLocation.y < 0) {
				newLocation.x = newLocation.y = 0;
			}
			
			lifelineEditPart.getPrimaryShape().getFigureDotLineFigure()
					.translateToRelative(newLocation);

			int newHeight;
			if (cver.getSize() != null)
				newHeight = cver.getSize().height;
			else
				newHeight = EXECUTION_INIT_HEIGHT;

			Rectangle newInitBounds = new Rectangle(
					newLocation.x,
					newLocation.y,
					EXECUTION_INIT_WIDTH, newHeight);
			
			Rectangle newBounds = getBESNewBounds(lifelineEditPart,
					newInitBounds, Collections.EMPTY_LIST);
			
			// to avoid creation of the new figure in a non visible area
			newBounds.y = newBounds.y <= 0 ? 1 : newBounds.y;

			SetBoundsCommand setBoundsCmd = new SetBoundsCommand(eDomain,
					"Creation of an ExecutionBehaviourSpecification", adapter,
					newBounds);

			return new ICommandProxy(setBoundsCmd);
		}

		return super.getCommand(request);
	}

	/**
	 * Useful operation to know where a BES EditPart should be positioned within
	 * a Lifeline EditPart. It is needed both the moveDelta and the sizeDelta.
	 * With these two values, and the child EditParts of the Lifeline, the new
	 * position is worked out. The returned bounds are relative to the Lifeline
	 * figure so they can be used, directly, within a SetBoundsCommand.
	 * 
	 * @param lifelineEP
	 * @param besEP
	 * @param moveDelta
	 * @param sizeDelta
	 * @return The new bounds of the besEP
	 */
	public static Rectangle getBESNewBounds(LifelineEditPart lifelineEP,
			BehaviorExecutionSpecificationEditPart besEP, Point moveDelta,
			Dimension sizeDelta) {
		
		// Current bounds of the BES
		Rectangle newBounds = besEP.getPrimaryShape().getBounds().getCopy();
		
		// According to the parameters, the new bounds would be the following
		newBounds.x += moveDelta.x;
		newBounds.y += moveDelta.y;
		newBounds.height += sizeDelta.height;
		
		// Not to check list
		List<BehaviorExecutionSpecificationEditPart> notToCheckBesList = new BasicEList<BehaviorExecutionSpecificationEditPart>();
		// Affixed BES List
		notToCheckBesList.addAll(getAffixedBESEditParts(besEP));
		// Add also current BES EditPart
		notToCheckBesList.add(besEP);
		
		return getBESNewBounds(lifelineEP, newBounds, notToCheckBesList);
	}

	/**
	 * Useful operation to know where the figure of a BES EditPart should be
	 * positioned within a Lifeline EditPart. The notToCheckList is needed to
	 * avoid checking those BES EditParts. The returned bounds are relative to
	 * the Lifeline figure so they can be used, directly, within a
	 * SetBoundsCommand.
	 * 
	 * @param lifelineEP
	 * @param newInitBounds
	 *            The new initial bounds
	 * @param notToCheckBesList
	 *            The BES EditPart's List that won't be checked
	 * @return The new bounds of the besEP figure
	 */
	public static Rectangle getBESNewBounds(LifelineEditPart lifelineEP,
			Rectangle newInitBounds,
			List<BehaviorExecutionSpecificationEditPart> notToCheckBesList) {
		// Lifeline's figure where the child is drawn
		Rectangle rDotLine = lifelineEP.getPrimaryShape()
				.getFigureDotLineFigure().getBounds().getCopy();

		// To store the newBounds
		Rectangle newBounds = newInitBounds.getCopy();

		// Check first if there is contact with any of the existing BES
		Rectangle childBounds = null;

		List<BehaviorExecutionSpecificationEditPart> toCheckBesList = lifelineEP
				.getBESList();
		toCheckBesList.removeAll(notToCheckBesList);

		// Iterate through the toCheckBesList
		for (BehaviorExecutionSpecificationEditPart auxBesEP : toCheckBesList) {
			Rectangle auxBounds = auxBesEP.getPrimaryShape().getBounds()
					.getCopy();

			// Check if there is any contact
			if (newInitBounds.touches(auxBounds)) {
				childBounds = auxBounds;
				break; // break the for
			}
		}

		// Case there wasn't any contact
		if (childBounds == null) {
			// Loop through the BES list and try to find the most to the right
			// BES within the besEP Y-axis bounds
			Rectangle mostToRightBesBounds = null;
			for (BehaviorExecutionSpecificationEditPart auxBesEP : toCheckBesList) {
					Rectangle auxBesBounds = auxBesEP.getFigure().getBounds();
					Rectangle auxBounds = newInitBounds.getCopy();
					auxBounds.x = auxBesBounds.x;
					if (auxBesBounds.touches(auxBounds)) {
						if (mostToRightBesBounds == null)
							mostToRightBesBounds = auxBesBounds;
						else if (auxBesBounds.x > mostToRightBesBounds.x)
							mostToRightBesBounds = auxBesBounds;
					}
			}

			// If there was no luck, set it's position to the center
			if (mostToRightBesBounds == null) {
				newBounds.x = rDotLine.x + rDotLine.width / 2
						- EXECUTION_INIT_WIDTH / 2;
			} else {
				newBounds.x = mostToRightBesBounds.x + EXECUTION_INIT_WIDTH / 2
						+ 1;
			}
		} else
			newBounds.x = childBounds.x + EXECUTION_INIT_WIDTH / 2 + 1;
		// Note: The last + 1 is just an extra delta

		// to avoid none visible positioning
		newBounds.y = newBounds.y <= 0 ? 1 : newBounds.y;

		// Change to relative bounds of the LifelineEP
		newBounds.x -= rDotLine.x;
		newBounds.y -= rDotLine.y;

		return newBounds;
	}

	/**
	 * Used to modify the sizeDelta if the given value is higher/lower than the
	 * highest/lowest allowed values of the figure.
	 * 
	 * @param figure
	 * @param sizeDelta
	 * @return a corrected sizeDelta
	 */
	public static Dimension adaptSizeDeltaToMaxHeight(IFigure figure,
			Dimension sizeDelta) {
		Dimension newSizeDelta = new Dimension(sizeDelta);

		int y = figure.getBounds().height + sizeDelta.height;

		if (y > figure.getMaximumSize().height) {
			newSizeDelta.height = figure.getMaximumSize().height
					- figure.getBounds().height;
		} else if (y < figure.getMinimumSize().height) {
			newSizeDelta.height = figure.getMinimumSize().height
					- figure.getBounds().height;
		}

		return newSizeDelta;
	}

	/**
	 * Returns all the BES EditParts that are affixed to the right side of the
	 * given BES EditPart. Not only the ones directly affixed to the besEP are
	 * returned, but the ones that are indirectly affixed as well (this is done
	 * recursively)
	 * 
	 * @param besEP
	 * @return the list of affixed BES. If there is no affixed BES, then an
	 *         empty list will be returned
	 */
	public static List<BehaviorExecutionSpecificationEditPart> getAffixedBESEditParts(
			BehaviorExecutionSpecificationEditPart besEP) {
		List<BehaviorExecutionSpecificationEditPart> notToCheckBesList = new ArrayList<BehaviorExecutionSpecificationEditPart>();
		return getAffixedBESEditParts(besEP, notToCheckBesList);

	}

	/**
	 * Operation used by the above operation. It's main goal is to obtain,
	 * recursively, all the affixed BES. In order to do so, it is needed a BES
	 * EditPart and the notToCheckList.
	 * 
	 * @param besEP
	 * @param notToCheckBesList
	 * @return the list of affixed BES. If there is no affixed BES, then an
	 *         empty list will be returned
	 */
	private static List<BehaviorExecutionSpecificationEditPart> getAffixedBESEditParts(
			BehaviorExecutionSpecificationEditPart besEP,
			List<BehaviorExecutionSpecificationEditPart> notToCheckBesList) {
		// Add itself to the notToCheck list
		List<BehaviorExecutionSpecificationEditPart> newNotToCheckBesList = new ArrayList<BehaviorExecutionSpecificationEditPart>(
				notToCheckBesList);
		newNotToCheckBesList.add(besEP);
		
		// LifelineEditPart where the BES EditPart is contained
		LifelineEditPart lifelineEP = (LifelineEditPart) besEP.getParent();
		
		// BES EditParts list
		List<BehaviorExecutionSpecificationEditPart> besList = lifelineEP
				.getBESList();
		besList.remove(newNotToCheckBesList);

		// List to store the Affixed BES
		ArrayList<BehaviorExecutionSpecificationEditPart> affixedBesList = new ArrayList<BehaviorExecutionSpecificationEditPart>();

		// Loop through the BES list
		for (BehaviorExecutionSpecificationEditPart childBesEP : besList) {
			if (isAffixedToRight(besEP, childBesEP)) {
				affixedBesList.add(childBesEP);
				// Add also it's affixed BES
				affixedBesList.addAll(getAffixedBESEditParts(childBesEP,
						newNotToCheckBesList));
			}
		}
		
		// To the BES list
		return affixedBesList;
	}

	/**
	 * Checks whether the right EditPart is affixed to the left EditPart. In
	 * order to do so, the operation checks if the right figure is really on the
	 * right and, if so, it just returns true if figures touch each other.
	 * 
	 * @param leftEP
	 *            The left AbstractGraphicalEditPart
	 * @param rightEP
	 *            The right AbstractGraphicalEditPart
	 * @return true if the rectangles of both figures touch and the right figure
	 *         is really on the right. False otherwise
	 */
	public static boolean isAffixedToRight(AbstractGraphicalEditPart leftEP,
			AbstractGraphicalEditPart rightEP) {
		Rectangle leftFig = leftEP.getFigure().getBounds();
		Rectangle rightFig = rightEP.getFigure().getBounds();
		if (leftFig.touches(rightFig) && leftFig.x < rightFig.x)
			return true;
		else
			return false;
	}

	/**
	 * If a BES EditPart is going to be moved according to a moveDelta, this
	 * operation returns a compoundCommand that also moves the affixed BES
	 * according to that delta.
	 * 
	 * @param besEP
	 *            The BES EditPart that is going to be moved
	 * @param moveDelta
	 *            The moveDelta of the previous EditPart
	 * @return
	 */
	public static CompoundCommand getMoveAffixedBESCommand(
			BehaviorExecutionSpecificationEditPart besEP, Point moveDelta) {
		CompoundCommand compoundCmd = new CompoundCommand();
		if (moveDelta.y != 0) {
			for (BehaviorExecutionSpecificationEditPart childBesEP : getAffixedBESEditParts(besEP)) {
				// Get Relative Bounds
				Rectangle childBounds = getRelativeBounds(childBesEP);
				// Apply delta
				childBounds.y += moveDelta.y;
				childBounds.x += moveDelta.x;
				// Create the child's SetBoundsCommand
				SetBoundsCommand childSetBoundsCmd = new SetBoundsCommand(besEP
						.getEditingDomain(), "Movement of affixed BES",
						childBesEP, childBounds);
				compoundCmd.add(new ICommandProxy(childSetBoundsCmd));
				// Move it's children as well
				if (getAffixedBESEditParts(childBesEP).size() > 0)
					compoundCmd.add(getMoveAffixedBESCommand(childBesEP,
							moveDelta));
			}
		}
		if (compoundCmd.size() == 0)
			return null;
		else
			return compoundCmd;
	}

	/**
	 * Given an AbstractGraphialEditPart and the new relative bounds that the
	 * EditPart will have, it returns the real delta applied to the movement
	 * 
	 * @param ep
	 *            The EditPart that will be moved
	 * @param newRelativeBounds
	 *            The new position of the mentioned EditPart
	 * @return The real MoveDelta applied
	 */
	public static Point getRealMoveDelta(AbstractGraphicalEditPart ep,
			Rectangle newRelativeBounds) {
		Rectangle oldRelativeBounds = getRelativeBounds(ep);
		Point realMoveDelta = new Point();
		realMoveDelta.x = newRelativeBounds.x - oldRelativeBounds.x;
		realMoveDelta.y = newRelativeBounds.y - oldRelativeBounds.y;
		return realMoveDelta;
	}

	/**
	 * It returns the relative bounds of an AbstractGraphicalEditPart.
	 * 
	 * @param ep
	 *            The EditPart
	 * @return The relative bounds regarding it's parent figure
	 */
	public static Rectangle getRelativeBounds(AbstractGraphicalEditPart ep) {
		IFigure parentFigure = ep.getFigure().getParent();
		IFigure epFigure = ep.getFigure();
		Rectangle relBounds = epFigure.getBounds().getCopy();
		relBounds.x -= parentFigure.getBounds().x;
		relBounds.y -= parentFigure.getBounds().y;
		return relBounds;
	}

	/**
	 * It returns a compound command to order the messages of it's affixed BES
	 * 
	 * @param besEP
	 *            BES whose affixed BES will be re-ordered
	 * @return The CompoundCommand to order the Messages of the affixed BES
	 */
	public CompoundCommand getAffixedBESMessageOrderCommand(
			BehaviorExecutionSpecificationEditPart besEP) {
		CompoundCommand cCommand = new CompoundCommand();
		for (BehaviorExecutionSpecificationEditPart affixedBesEP : getAffixedBESEditParts(besEP)) {
			cCommand.add(new MessageOrderCommand(affixedBesEP));
		}
		return cCommand;
	}
}
