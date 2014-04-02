/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.communication.custom.commands.CustomDurationObservationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.communication.custom.commands.CustomTimeObservationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.communication.edit.policies.InteractionCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.communication.providers.UMLElementTypes;

/**
 * 
 * 
 * this a specialization to manage creation of TimeObservation and
 * DurationObservation
 * 
 * 
 */
public class CustomInteractionCompartmentSemanticEditPolicy extends InteractionCompartmentItemSemanticEditPolicy {

	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		if(UMLElementTypes.TimeObservation_8006 == req.getElementType()) {
			return getGEFWrapper(new CustomTimeObservationCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.DurationObservation_8007 == req.getElementType()) {
			return getGEFWrapper(new CustomDurationObservationCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}

		return super.getCreateCommand(req);
	}

	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		// TODO Auto-generated method stub
		//System.err.println("getReorientRelationshipCommand VisualID of element to reorient" + getVisualID(req));
		return super.getReorientRelationshipCommand(req);
	}

}
