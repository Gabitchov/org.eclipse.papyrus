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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CombinedFragmentCoveredCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;

public class InteractionCompartmentXYLayoutEditPolicy extends XYLayoutEditPolicy {

	@Override
	public Command getCommand(Request request) {

		if (request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest cbr = (ChangeBoundsRequest) request;

			CompoundCommand compoundCmd = new CompoundCommand("Resize of Interaction Compartment Elements");
			// If moving a BES then redirect the getCommand to the LifelineEditPart
			compoundCmd.add(super.getCommand(request));

			for (Iterator<EditPart> it = cbr.getEditParts().iterator(); it.hasNext();) {
				EditPart ep = it.next();

				if (ep instanceof CombinedFragmentEditPart) {

					// CombinedFragment EditPart
					CombinedFragmentEditPart cfragmentEP = (CombinedFragmentEditPart) ep;

					compoundCmd.add(new CombinedFragmentCoveredCommand(cfragmentEP));

				} else if (ep instanceof LifelineEditPart) {
					// If a Lifeline is moved or resized then all the
					// CombinedFragments must be updated
					LifelineEditPart lifelineEP = (LifelineEditPart) ep;
					for (Object obj : lifelineEP.getParent().getChildren()) {
						if (obj instanceof CombinedFragmentEditPart)
							compoundCmd.add(new CombinedFragmentCoveredCommand((CombinedFragmentEditPart) obj));
					}
				} else if (ep instanceof BehaviorExecutionSpecificationEditPart) {
					// Due to the fact that the Lifeline does not have a CompartmentEditPart
					// changebounds requests are always sent to the InteractionCompartmentXYLayoutEditPolicy
					// and need to be redirected to the LifelineXYLayoutEditPolicy by just executing
					// the LifelineEditPart.getCommand(request).
					BehaviorExecutionSpecificationEditPart besEP = (BehaviorExecutionSpecificationEditPart) ep;
					if (besEP.getParent() instanceof LifelineEditPart) {
						LifelineEditPart lifelineEP = (LifelineEditPart) besEP.getParent();
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

			CompoundCommand compoundCmd = new CompoundCommand("Creation of a CombinedFragment");
			compoundCmd.add(super.getCommand(request));

			if (cver.getViewAndElementDescriptor().getSemanticHint().compareTo(Integer.toString(CombinedFragmentEditPart.VISUAL_ID)) == 0) {

				compoundCmd.add(new CombinedFragmentCoveredCommand(getHost().getViewer(), cver.getViewAndElementDescriptor()));
			}

			if (compoundCmd.size() == 0)
				return super.getCommand(request);
			else
				return compoundCmd;
		}

		return super.getCommand(request);
	}

}
