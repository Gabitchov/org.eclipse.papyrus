/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.sequence.edit.commands.InteractionOperandCreateCommand;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class CombinedFragmentCombinedFragmentCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public CombinedFragmentCombinedFragmentCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.CombinedFragment_3004);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.InteractionOperand_3005 == req.getElementType()) {
			return getGEFWrapper(new InteractionOperandCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
