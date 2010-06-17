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
import org.eclipse.papyrus.diagram.profile.edit.commands.ClassPropertyCreateCommand;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;

/**
 * @generated
 */
public class StereotypeAttributeCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StereotypeAttributeCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Stereotype_1023);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Property_3002 == req.getElementType()) {
			return getGEFWrapper(new ClassPropertyCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
