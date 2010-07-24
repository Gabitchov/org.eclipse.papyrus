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

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;

import org.eclipse.papyrus.diagram.common.commands.PreserveAnchorsPositionCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CombinedFragmentCoveredCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;

public class InteractionCompartmentXYLayoutEditPolicy extends
		XYLayoutEditPolicy {

	@Override
	public Command getCommand(Request request) {

		if (request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest cbr = (ChangeBoundsRequest) request;

			CompoundCommand compoundCmd = new CompoundCommand(
					"Resize of Interaction Compartment Elements");

			for (Iterator<EditPart> it = cbr.getEditParts().iterator(); it
					.hasNext();) {
				EditPart ep = it.next();

				if (ep instanceof CombinedFragmentEditPart) {
					// CombinedFragment EditPart
					CombinedFragmentEditPart cfragmentEP = (CombinedFragmentEditPart) ep;

					// SetBounds command
					compoundCmd.add(getSetBoundsCommand(cfragmentEP, cbr));

					// Covered command
					compoundCmd.add(new CombinedFragmentCoveredCommand(
							cfragmentEP));

				} else if (ep instanceof LifelineEditPart) {
					// Lifeline EditPart
					LifelineEditPart lifelineEP = (LifelineEditPart) ep;

					int preserveY = PreserveAnchorsPositionCommand.PRESERVE_Y;
					Dimension newSizeDelta = PreserveAnchorsPositionCommand
							.getSizeDeltaToFitAnchors(lifelineEP, cbr
									.getSizeDelta(), preserveY);

					// SetBounds command modifying the sizeDelta
					compoundCmd.add(getSetBoundsCommand(lifelineEP, cbr,
							newSizeDelta));

					// PreserveAnchors command
					compoundCmd.add(new ICommandProxy(
							new PreserveAnchorsPositionCommand(lifelineEP,
									newSizeDelta, preserveY)));

					// If a Lifeline is moved or resized then all the
					// CombinedFragments must be updated
					for (Object obj : lifelineEP.getParent().getChildren()) {
						if (obj instanceof CombinedFragmentEditPart)
							compoundCmd.add(new CombinedFragmentCoveredCommand(
									(CombinedFragmentEditPart) obj));
					}
				} else if (ep instanceof BehaviorExecutionSpecificationEditPart) {
					// Due to the fact that the Lifeline does not have a
					// CompartmentEditPart
					// changebounds requests are always sent to the
					// InteractionCompartmentXYLayoutEditPolicy
					// and need to be redirected to the
					// LifelineXYLayoutEditPolicy by just executing
					// the LifelineEditPart.getCommand(request).
					BehaviorExecutionSpecificationEditPart besEP = (BehaviorExecutionSpecificationEditPart) ep;
					if (besEP.getParent() instanceof LifelineEditPart) {
						LifelineEditPart lifelineEP = (LifelineEditPart) besEP
								.getParent();
						compoundCmd.add(lifelineEP.getCommand(cbr));
					}
				}
			}

			if (compoundCmd.size() == 0)
				return super.getCommand(request);
			else
				return compoundCmd;
		}

		if (request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest cver = (CreateViewAndElementRequest) request;

			CompoundCommand compoundCmd = new CompoundCommand(
					"Creation of a CombinedFragment");
			compoundCmd.add(super.getCommand(request));

			if (cver.getViewAndElementDescriptor().getSemanticHint().compareTo(
					Integer.toString(CombinedFragmentEditPart.VISUAL_ID)) == 0) {

				compoundCmd.add(new CombinedFragmentCoveredCommand(getHost()
						.getViewer(), cver.getViewAndElementDescriptor()));
			}

			if (compoundCmd.size() == 0)
				return super.getCommand(request);
			else
				return compoundCmd;
		}

		return super.getCommand(request);
	}

	/**
	 * It obtains an appropriate SetBoundsCommand for a CombinedFragmentEditPart
	 * 
	 * @param combinedFragmentEP
	 *            The CombinedFragment that will be moved or resized
	 * @param cbr
	 *            The ChangeBoundsRequest for moving or resizing the
	 *            combinedFragmentEP
	 * @return The SetBoundsCommand
	 */
	protected Command getSetBoundsCommand(
			CombinedFragmentEditPart combinedFragmentEP, ChangeBoundsRequest cbr) {
		// Modify request
		List epList = cbr.getEditParts();
		cbr.setEditParts(combinedFragmentEP);
		// Obtain the command with the modified request
		Command cmd = super.getCommand(cbr);
		// Restore the request
		cbr.setEditParts(epList);
		// Return the SetBoundsCommand only for the CombinedFragmentEditPart
		return cmd;
	}

	/**
	 * It obtains an appropriate SetBoundsCommand for a LifelineEditPart. The
	 * newSizeDelta provided should be equal o less than the one contained in
	 * the request. The goal of this newDelta is to preserve the anchors'
	 * positions after the resize. It is recommended to obtain this newSizeDelta
	 * by means of calling
	 * PreserveAnchorsPositionCommand.getSizeDeltaToFitAnchors() operation
	 * 
	 * @param lifelineEP
	 *            The Lifeline that will be moved or resized
	 * @param cbr
	 *            The ChangeBoundsRequest for moving or resized the lifelineEP
	 * @param newSizeDelta
	 *            The sizeDelta to used instead of the one contained in the
	 *            request
	 * @return The SetBoundsCommand
	 */
	protected Command getSetBoundsCommand(LifelineEditPart lifelineEP,
			ChangeBoundsRequest cbr, Dimension newSizeDelta) {
		// Modify request
		List epList = cbr.getEditParts();
		Dimension oldSizeDelta = cbr.getSizeDelta();
		cbr.setEditParts(lifelineEP);
		cbr.setSizeDelta(newSizeDelta);

		// Obtain the command with the modified request
		Command cmd = super.getCommand(cbr);

		// Restore the request
		cbr.setEditParts(epList);
		cbr.setSizeDelta(oldSizeDelta);

		// Return the SetBoundsCommand only for the Lifeline and with the
		// sizeDelta modified in order to preserve the links' anchors positions
		return cmd;
	}

	/**
	 * It obtains an appropriate SetBoundsCommand for a LifelineEditPart. In
	 * comparison with the the other getSetBoundsCommand, no newSizeDelta needs
	 * to be provided as it already calculates the appropriate newSizeDelta.
	 * PreserveAnchorsPositionCommand.getSizeDeltaToFitAnchors() operation
	 * 
	 * @param lifelineEP
	 *            The Lifeline that will be moved or resized
	 * @param cbr
	 *            The ChangeBoundsRequest for moving or resized the lifelineEP
	 * @return The SetBoundsCommand
	 */
	protected Command getSetBoundsCommand(LifelineEditPart lifelineEP,
			ChangeBoundsRequest cbr) {
		int preserveY = PreserveAnchorsPositionCommand.PRESERVE_Y;
		Dimension newSizeDelta = PreserveAnchorsPositionCommand
				.getSizeDeltaToFitAnchors(lifelineEP, cbr.getSizeDelta(),
						preserveY);
		return getSetBoundsCommand(lifelineEP, cbr, newSizeDelta);
	}

}
