/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.profile.custom.commands.CustomContextLinkCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.edit.policies.ConstraintItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;

/**
 * Custom Semantic Edit Policy to manage custom context link
 */
public class CustomConstraintContextLinkSemanticEditPolicy extends ConstraintItemSemanticEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.ConstraintContext_8500 == req.getElementType()) {
			return getGEFWrapper(new CustomContextLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getStartCreateRelationshipCommand(req);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.ConstraintContext_8500 == req.getElementType()) {
			return getGEFWrapper(new CustomContextLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

}
