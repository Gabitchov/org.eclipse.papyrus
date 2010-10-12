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
package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Operation3CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ReceptionCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class ClassOperationCompartment2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassOperationCompartment2ItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2008);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Reception_3011 == req.getElementType()) {
			return getGEFWrapper(new ReceptionCreateCommand(req));
		}
		if(UMLElementTypes.Operation_3013 == req.getElementType()) {
			return getGEFWrapper(new Operation3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
