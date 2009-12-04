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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.composite.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.PropertyPartCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class PropertyPartCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PropertyPartCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Property_3070);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Property_3070 == req.getElementType()) {
			return getGEFWrapper(new PropertyPartCreateCommandCN(req));
		}
		if(UMLElementTypes.Comment_3097 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
