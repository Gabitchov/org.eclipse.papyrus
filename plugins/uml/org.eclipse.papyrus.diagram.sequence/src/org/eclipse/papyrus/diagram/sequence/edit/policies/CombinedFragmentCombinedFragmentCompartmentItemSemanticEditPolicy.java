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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.sequence.edit.commands.InteractionOperandCreateCommand;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;

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
	 * Generated not for limit InteractionOperand number. {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.InteractionOperand_3005 == req.getElementType()) {

			CombinedFragment combinedFragment = getAssociatedCombinedFragment(req.getContainer());
			if(combinedFragment == null) {
				return UnexecutableCommand.INSTANCE;
			}
			// Set the container of the request to the combinedFragment.
			req.setContainer(combinedFragment);
			InteractionOperatorKind interactionOperator = combinedFragment.getInteractionOperator();
			EList<InteractionOperand> operands = combinedFragment.getOperands();
			if(interactionOperator != null && !operands.isEmpty() && (InteractionOperatorKind.OPT_LITERAL.equals(interactionOperator) || InteractionOperatorKind.LOOP_LITERAL.equals(interactionOperator) || InteractionOperatorKind.BREAK_LITERAL.equals(interactionOperator) || InteractionOperatorKind.NEG_LITERAL.equals(interactionOperator))) {
				return UnexecutableCommand.INSTANCE;
			}
			return getGEFWrapper(new InteractionOperandCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * Retrieve the combined fragment associated with the request.
	 */
	private CombinedFragment getAssociatedCombinedFragment(EObject eObject) {
		CombinedFragment combinedFragment = null;
		if(eObject instanceof CombinedFragment) {
			return (CombinedFragment)eObject;
		} else if(eObject != null) {
			combinedFragment = getAssociatedCombinedFragment(eObject.eContainer());
		}

		return combinedFragment;
	}

}
