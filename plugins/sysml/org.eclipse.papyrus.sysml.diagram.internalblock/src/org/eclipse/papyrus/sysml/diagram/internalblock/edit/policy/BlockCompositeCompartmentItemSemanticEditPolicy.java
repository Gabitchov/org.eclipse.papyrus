/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.composite.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.PortCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.PropertyPartCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class BlockCompositeCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public BlockCompositeCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Class_2073);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Port_3069 == req.getElementType()) {
			return getGEFWrapper(new PortCreateCommand(req));
		}
		if(UMLElementTypes.Property_3070 == req.getElementType()) {
			return getGEFWrapper(new PropertyPartCreateCommandCN(req));
		}
		if(UMLElementTypes.Comment_3097 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommandCN(req));
		}
		if(UMLElementTypes.Constraint_3120 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommandCN(req));
		}

		return super.getCreateCommand(req);
	}

}
