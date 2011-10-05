/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.diagram.component.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.component.edit.commands.ComponentCreateCommandCN;
import org.eclipse.papyrus.diagram.component.providers.UMLElementTypes;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponentCompositeCompartmentItemSemanticEditPolicyPCN.
 *
 * @generated
 */
public class ComponentCompositeCompartmentItemSemanticEditPolicyPCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * Instantiates a new component composite compartment item semantic edit policy pcn.
	 *
	 * @generated
	 */
	public ComponentCompositeCompartmentItemSemanticEditPolicyPCN() {
		super(UMLElementTypes.Component_3071);
	}


	/**
	 * Gets the creates the command.
	 *
	 * @param req the req
	 * @return the creates the command
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.Component_3070 == req.getElementType()) {
			return getGEFWrapper(new ComponentCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
