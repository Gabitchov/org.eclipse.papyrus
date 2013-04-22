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
 *  Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.command.PromptCreateElementAndNodeCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;

/**
 * Edit Policy to create an element on a lifeline associated with the creation of a message.
 * For example it can be used to create a Destruction Event with a Message Delete
 * or the target Execution Specification with a Message Sync.
 * 
 * @author Mathieu Velten
 * 
 */
public class ElementCreationWithMessageEditPolicy extends LifelineChildGraphicalNodeEditPolicy {

	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		//		CompoundCommand compound = new CompoundCommand();
		Command command = super.getConnectionCompleteCommand(request);
		if(command != null && command.canExecute()) {
			//			compound.add(command);
			if(request instanceof CreateConnectionViewAndElementRequest) {
				CreateConnectionViewAndElementRequest viewRequest = (CreateConnectionViewAndElementRequest)request;
				EditPart targetEP = getTargetEditPart(viewRequest);
				EObject target = ViewUtil.resolveSemanticElement((View)targetEP.getModel());
				EditPart sourceEP = viewRequest.getSourceEditPart();
				EObject source = ViewUtil.resolveSemanticElement((View)sourceEP.getModel());
				if(getSyncMessageHint().equals(viewRequest.getConnectionViewDescriptor().getSemanticHint()) || getReplyMessageHint().equals(viewRequest.getConnectionViewDescriptor().getSemanticHint())) {
					if(target instanceof Lifeline ||
					// handle reflexive synch message by creating a new ES
					(target instanceof ExecutionSpecification && target.equals(source))) {
						InteractionFragment ift = SequenceUtil.findInteractionFragmentContainerAt(viewRequest.getLocation(), getHost());
						// retrieve the good execution specification type using the source of the message
						if(target instanceof ExecutionSpecification) {
							// retrieve its associated lifeline
							targetEP = targetEP.getParent();
							target = ViewUtil.resolveSemanticElement((View)targetEP.getModel());
						}
						EditPart sourceEditPart = request.getSourceEditPart();
						if(sourceEditPart instanceof ActionExecutionSpecificationEditPart || sourceEditPart instanceof BehaviorExecutionSpecificationEditPart) {
							return new ICommandProxy(new PromptCreateElementAndNodeCommand(command, getEditingDomain(), viewRequest.getConnectionViewDescriptor(), (ShapeNodeEditPart)targetEP, target, sourceEP, request, ift));
						}
						//						IHintedType elementType = null;
						//						if(sourceEditPart instanceof ActionExecutionSpecificationEditPart) {
						//							elementType = (IHintedType)UMLElementTypes.ActionExecutionSpecification_3006;
						//						} else if(request.getSourceEditPart() instanceof BehaviorExecutionSpecificationEditPart) {
						//							elementType = (IHintedType)UMLElementTypes.BehaviorExecutionSpecification_3003;
						//						}
						//
						//
						//						if(elementType != null) {
						//							CreateElementAndNodeCommand createExecutionSpecificationCommand = new CreateElementAndNodeCommand(getEditingDomain(), (ShapeNodeEditPart)targetEP, target, elementType, request.getLocation());
						//							createExecutionSpecificationCommand.putCreateElementRequestParameter(SequenceRequestConstant.INTERACTIONFRAGMENT_CONTAINER, ift);
						//							compound.add(createExecutionSpecificationCommand);
						//
						//							// put the anchor at the top of the figure
						//							ChangeEdgeTargetCommand changeTargetCommand = new ChangeEdgeTargetCommand(getEditingDomain(), createExecutionSpecificationCommand, viewRequest.getConnectionViewDescriptor(), "(0.5, 0.0)");
						//							compound.add(new ICommandProxy(changeTargetCommand));
						//						}
					}
				}
			}
		}
		return command;
	}

	private static String getSyncMessageHint() {
		IHintedType message = (IHintedType)UMLElementTypes.Message_4003;
		return message.getSemanticHint();
	}

	private static String getReplyMessageHint() {
		IHintedType message = (IHintedType)UMLElementTypes.Message_4005;
		return message.getSemanticHint();
	}

	private TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}
}
