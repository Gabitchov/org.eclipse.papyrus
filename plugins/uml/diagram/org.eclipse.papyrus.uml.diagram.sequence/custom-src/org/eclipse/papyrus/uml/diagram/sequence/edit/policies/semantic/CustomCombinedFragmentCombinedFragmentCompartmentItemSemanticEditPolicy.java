/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.sequence.command.CustomInteractionOperandCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CombinedFragmentCombinedFragmentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomCombinedFragmentCombinedFragmentCompartmentItemSemanticEditPolicy extends CombinedFragmentCombinedFragmentCompartmentItemSemanticEditPolicy {

	/**
	 * Generated not for limit InteractionOperand number. {@inheritDoc}
	 * 
	 * @Override
	 */
	@Override
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
			// make compound command
			CompoundCommand result = new CompoundCommand();
			Command cmd = getGEFWrapper(new CustomInteractionOperandCreateCommand(req));
			result.add(cmd);
			// append a command which notifies
			// Fixed bug: remove the notify dialog, see: https://bugs.eclipse.org/bugs/show_bug.cgi?id=402977
			//			Command notifyCmd = new Command() {
			//
			//				@Override
			//				public void execute() {
			//					NotificationBuilder warning = NotificationBuilder.createAsyncPopup(CustomMessages.Warning_ResizeInteractionOperandTitle, NLS.bind(CustomMessages.Warning_ResizeInteractionOperandTxt, System.getProperty("line.separator")));
			//					warning.run();
			//				}
			//
			//				@Override
			//				public void undo() {
			//					execute();
			//				}
			//			};
			//			if(notifyCmd.canExecute()) {
			//				result.add(notifyCmd);
			//			}
			return result;
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
