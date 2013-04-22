/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

/**
 * The customn LayoutEditPolicy for InteractionOperandEditPart.
 */
public class InteractionOperandLayoutEditPolicy extends XYLayoutEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		EditPolicy result = super.createChildEditPolicy(child);
		if(result == null) {
			return new ResizableShapeEditPolicy();
		}
		return result;
	}

	/**
	 * Handle create InteractionOperand hover InteractionOperand {@inheritDoc}
	 */
	@Override
	public Command getCommand(Request request) {
		EditPart combinedFragmentCompartment = getHost().getParent();
		EditPart combinedFragment = combinedFragmentCompartment.getParent();
		EditPart interactionCompartment = combinedFragment.getParent();
		if(REQ_CREATE.equals(request.getType()) && request instanceof CreateUnspecifiedTypeRequest) {
			if(UMLElementTypes.InteractionOperand_3005.equals(((CreateUnspecifiedTypeRequest)request).getElementTypes().get(0))) {
				return combinedFragmentCompartment.getCommand(request);
			} else if(UMLElementTypes.CombinedFragment_3004.equals(((CreateUnspecifiedTypeRequest)request).getElementTypes().get(0))) {
				//Fixed bug about creating on InteractionOperand. (executed Twice).
				//return interactionCompartment.getCommand(request);
			} else if(UMLElementTypes.Lifeline_3001.equals(((CreateUnspecifiedTypeRequest)request).getElementTypes().get(0))) {
				return interactionCompartment.getCommand(request);
			}
		} else if(request instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionRequest createConnectionRequest = (CreateConnectionRequest)request;
			if(getHost().equals(createConnectionRequest.getSourceEditPart())) {
				createConnectionRequest.setSourceEditPart(combinedFragment);
			}
			if(getHost().equals(createConnectionRequest.getTargetEditPart())) {
				createConnectionRequest.setTargetEditPart(combinedFragment);
			}
			return combinedFragment.getCommand(request);
		} else if(request instanceof CreateViewAndElementRequest) {
			//FIXME If necessary
			//Update Bounds and Guides.
			return getCreateCommand((CreateViewAndElementRequest)request);
		} else if(REQ_RESIZE_CHILDREN.equals(request.getType())) {
			return interactionCompartment.getCommand(request);
		}
		return super.getCommand(request);
	}
	//	/**
	//	 * Handle combined fragment resize
	//	 */
	//	@Override
	//	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
	//		CompoundCommand compoundCmd = new CompoundCommand();
	//		compoundCmd.setLabel("Move or Resize");
	//
	//		for(Object o : request.getEditParts()) {
	//			GraphicalEditPart child = (GraphicalEditPart)o;
	//			Object constraintFor = getConstraintFor(request, child);
	//			if(constraintFor != null) {
	//				if(child instanceof CombinedFragmentEditPart) {
	//					Command resizeChildrenCommand = InteractionCompartmentXYLayoutEditPolicy.getCombinedFragmentResizeChildrenCommand(request, (CombinedFragmentEditPart)child);
	//					if(resizeChildrenCommand != null && resizeChildrenCommand.canExecute()) {
	//						compoundCmd.add(resizeChildrenCommand);
	//					}
	//				}
	//
	//				Command changeConstraintCommand = createChangeConstraintCommand(request, child, translateToModelConstraint(constraintFor));
	//				compoundCmd.add(changeConstraintCommand);
	//			}
	//		}
	//		if(compoundCmd.isEmpty()) {
	//			return null;
	//		}
	//		return compoundCmd.unwrap();
	//	}
}
