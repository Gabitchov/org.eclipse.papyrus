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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.profile.edit.commands.EnumerationLiteralCreateCommand;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;

/**
 * @generated
 */
public class EnumerationEnumerationLiteralCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EnumerationEnumerationLiteralCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Enumeration_2006);
	}


	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.EnumerationLiteral_1037 == req.getElementType()) {
			return getGEFWrapper(new EnumerationLiteralCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
