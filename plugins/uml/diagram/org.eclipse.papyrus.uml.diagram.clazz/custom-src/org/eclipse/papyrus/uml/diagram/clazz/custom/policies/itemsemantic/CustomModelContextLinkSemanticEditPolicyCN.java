/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CustomContextLinkCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * This class is used to manage the the creation of a contextLink
 */
public class CustomModelContextLinkSemanticEditPolicyCN extends CustomModelItemSemanticEditPolicyCN {

	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.ConstraintContext_8500 == req.getElementType()) {
			return getGEFWrapper(new CustomContextLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}
}
