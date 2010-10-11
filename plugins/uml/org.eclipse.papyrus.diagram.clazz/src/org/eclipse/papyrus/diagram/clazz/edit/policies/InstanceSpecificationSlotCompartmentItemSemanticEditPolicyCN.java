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
import org.eclipse.papyrus.diagram.clazz.edit.commands.SlotCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class InstanceSpecificationSlotCompartmentItemSemanticEditPolicyCN
		extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InstanceSpecificationSlotCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.InstanceSpecification_3020);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Slot_3030 == req.getElementType()) {
			return getGEFWrapper(new SlotCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
