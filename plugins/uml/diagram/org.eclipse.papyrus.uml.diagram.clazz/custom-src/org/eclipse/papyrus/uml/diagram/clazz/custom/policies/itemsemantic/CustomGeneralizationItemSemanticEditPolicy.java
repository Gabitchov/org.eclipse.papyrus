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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CGeneralizationSetCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.GeneralizationItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * this a specialization to manage creation of GeneralizationSet
 */
public class CustomGeneralizationItemSemanticEditPolicy extends GeneralizationItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.GeneralizationSet_4020 == req.getElementType()) {
			return getGEFWrapper(new CGeneralizationSetCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.GeneralizationSet_4020 == req.getElementType()) {
			return getGEFWrapper(new CGeneralizationSetCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getStartCreateRelationshipCommand(req);
	}
}
