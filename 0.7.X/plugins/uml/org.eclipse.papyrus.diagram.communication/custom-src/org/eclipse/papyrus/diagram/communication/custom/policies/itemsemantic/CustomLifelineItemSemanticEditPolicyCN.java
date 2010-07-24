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

package org.eclipse.papyrus.diagram.communication.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.diagram.communication.custom.commands.CustomMessageCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConnectorDurationObservationCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConnectorTimeObservationCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.policies.LifelineItemSemanticEditPolicyCN;
import org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes;

/**
 * this is a specialization to manage creation of Message,
 * CommentAnnotatedElement, ConstraintConstrainedElement,
 * DurationObservationEvent and TimeObservationEvent
 */
public class CustomLifelineItemSemanticEditPolicyCN extends LifelineItemSemanticEditPolicyCN {

	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if(UMLElementTypes.Message_8009 == req.getElementType()) {

			return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}

		if(UMLElementTypes.CommentAnnotatedElement_8010 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ConstraintConstrainedElement_8011 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}

		if(UMLElementTypes.DurationObservationEvent_8012 == req.getElementType()) {
			return getGEFWrapper(new ConnectorDurationObservationCreateCommand(req, req.getSource(), req.getTarget()));
		}

		if(UMLElementTypes.TimeObservationEvent_8013 == req.getElementType()) {
			return getGEFWrapper(new ConnectorTimeObservationCreateCommand(req, req.getSource(), req.getTarget()));
		}

		return null;
	}

	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_8009 == req.getElementType()) {
			return getGEFWrapper(new CustomMessageCreateCommand(req, req.getSource(), req.getTarget()));
		}

		return null;
	}

}
