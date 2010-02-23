/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.profile.custom.commands.CustomAssociationReorientCommand;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.policies.AssociationNodeItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;

/**
 * this a specialization to manage creation of association and associationClass
 */
public class CustomAssociationNodeItemSemanticEditPolicy extends AssociationNodeItemSemanticEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.diagram.profile.custom.commands.CustomAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomAssociationReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getStartCreateRelationshipCommand(req);
	}
}
