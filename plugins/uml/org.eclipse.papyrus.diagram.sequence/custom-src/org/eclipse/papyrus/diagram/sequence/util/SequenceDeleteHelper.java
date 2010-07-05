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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.DurationObservationHelper;
import org.eclipse.papyrus.diagram.common.helper.TimeConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.TimeObservationHelper;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * An Helper to get deleting command for the sequence diagram elements.
 */

public class SequenceDeleteHelper {
	
	/**
	 *  Destroy  all the relatives elements of an CombinedFragment
	 * @param cf the combined fragment to destroy
	 * @param cmd the composite transactional command where to add the new commands.
	 * @return the list of all elements that will be destroyed
	 */
	public static List<Element> destroyCombinedFragmentRelatives(CombinedFragment cf, CompositeTransactionalCommand cmd){
		List<Element> elements = new LinkedList<Element>();
		
		// Destroy each operand of the combinedFragment
		for(InteractionOperand operand : cf.getOperands()){
			// Destroy interactionOperandRelatives
			elements.addAll(destroyInteractionOperandRelatives(operand, cmd));
			// Destroy the interactionOperand
			cmd.add(createDestroyElementCommand(operand));
			// Add the operand to the list
			elements.add(operand);
		}

		return elements;
	}
	
	/**
	 * Destroy  all the relatives elements of an InteractionOperand
	 * @param interactionOperand the combined fragment to destroy
	 * @param cmd the composite transactional command where to add the new commands.
	 * @return the list of all elements that will be destroyed
	 */
	public static List<Element> destroyInteractionOperandRelatives(InteractionOperand interactionOperand, CompositeTransactionalCommand cmd){
		List<Element> elements = SequenceUtil.getInteractionOperandAssociatedElement(interactionOperand);
		List<Element> childElements = new LinkedList<Element>();
		// Delete InteractionOperand
		for(Element element : elements){
			if(element instanceof CombinedFragment){
				childElements.addAll(destroyCombinedFragmentRelatives((CombinedFragment)element, cmd));
			}else{
				// Complete the destroy command with specific destroy commands. 
				if(element instanceof Message){
					completeDestroyMessageCommand((Message)element, cmd);
				}else if(element instanceof ExecutionSpecification){
					completeDestroyExecutionSpecificationCommand(cmd, (ExecutionSpecification)element);
				}
			}
			// Destroy the element
			cmd.add(createDestroyElementCommand(element));
			childElements.add(element);
		}
		
		return childElements;
	}

	/**
	 * Complete an ICommand which destroys a Message element to also destroy dependent message ends and time/duration constraint/observation linked
	 * with these ends
	 * 
	 * @param cmd
	 *        the command to complete
	 * @param message
	 *        the message on which the request is called
	 * @return the deletion ICommand cmd for convenience
	 */
	public static ICommand completeDestroyMessageCommand(Message message, CompositeTransactionalCommand cmd){

		// Destroy the send event
		destroyMessageEnd(cmd,  message.getSendEvent());

		// Destroy the receive event
		destroyMessageEnd(cmd, message.getReceiveEvent());
		
		return cmd;
	}

	/**
	 * Destroy a messageEnd
	 * @param cmd the composite transactional command where the new commands will be added
	 * @param messageEnd the messageEnd to destroy
	 */
	private static void destroyMessageEnd(CompositeTransactionalCommand cmd, MessageEnd messageEnd) {
			if(messageEnd instanceof MessageOccurrenceSpecification) {
				destroyOccurrenceSpecification(cmd, (MessageOccurrenceSpecification)messageEnd);
			}else if(messageEnd instanceof Gate){
				destroyGate(cmd, (Gate)messageEnd);
			}
	}

	/**
	 * Destroy a Gate - NOT IMPLEMENTED YET
	 * @param cmd the composite transactional command where the new commands will be added
	 * @param gate the gate to destroy
	 */
	private static void destroyGate(CompositeTransactionalCommand cmd, Gate gate) {
		// TODO implements this method
	}

	/**
	 * Complete an ICommand which destroys an ExecutionSpecification element to also destroy dependent finish and start events and time/duration
	 * constraint/observation linked with these ends
	 * 
	 * @param cmd
	 *        the command to complete
	 * @param execution
	 *        the execution specification on which the request is called
	 * @return the deletion ICommand cmd for convenience
	 */
	public static ICommand completeDestroyExecutionSpecificationCommand(CompositeTransactionalCommand cmd, ExecutionSpecification execution) {

		// Destroy start execution occurrence specification
		destroyOccurrenceSpecification(cmd, execution.getStart());
	
		// Destroy end execution occurrence specification
		destroyOccurrenceSpecification(cmd, execution.getFinish());
		
		return cmd;
	}
	
	/**
	 * Destroy the given OccurrenceSpecification, and its linkedTimeElements
	 * @param cmd the composite transactional command where the new commands will be added
	 * @param os the occurrenceSpecification to destroy
	 */
	private static void destroyOccurrenceSpecification(CompositeTransactionalCommand cmd, OccurrenceSpecification os) {
		cmd.add(createDestroyElementCommand(os));
		// delete linked time elements
		List<NamedElement> timeElements = getLinkedTimeElements(os);
		for(NamedElement elt : timeElements) {
			cmd.add(createDestroyElementCommand(elt));
		}
	}

	/**
	 * Get the time elements linked with the given namedElement. 
	 * Time Elements regroups:
	 *  - Time Observation
	 *  - Time Constraint
	 *  - DurationObservation
	 *  - DurationConstraint 
	 * @param namedElement the named element
	 * @return a list of time elements
	 */
	private static List<NamedElement> getLinkedTimeElements(NamedElement namedElement) {
		List<NamedElement> timeElements = new ArrayList<NamedElement>();
		timeElements.addAll(TimeObservationHelper.getTimeObservations(namedElement));
		timeElements.addAll(TimeConstraintHelper.getTimeConstraintsOn(namedElement));
		timeElements.addAll(DurationObservationHelper.getDurationObservationsOn(namedElement));
		timeElements.addAll(DurationConstraintHelper.getDurationConstraintsOn(namedElement));		
		return timeElements;
	}

	/**
	 * Get a destroy element command without confirmation. It creates the request and the command.
	 * @param start
	 * @return
	 */
	private static DestroyElementCommand createDestroyElementCommand(EObject eObject) {
		return new DestroyElementCommand(new DestroyElementRequest(eObject, false));
	}


	/**
	 * Complete an ICommand which destroys a Message element to also destroy dependent message ends and time/duration constraint/observation linked
	 * with these ends
	 * 
	 * @param cmd
	 *        the command to complete
	 * @param messagePart
	 *        the message edit part on which the request is called
	 */
	public static void completeDestroyMessageCommand(CompositeTransactionalCommand cmd, EditPart messagePart) {
		if(messagePart instanceof GraphicalEditPart){
			EObject eObject = ((GraphicalEditPart)messagePart).resolveSemanticElement();
			if(eObject instanceof Message){
				completeDestroyMessageCommand((Message)eObject, cmd);
			}
		}
	}

	/**
	 * Complete an ICommand which destroys an DestructionEvent element to also destroy dependent time/duration constraint/observation linked with
	 * these ends
	 * 
	 * @param deleteViewsCmd
	 *        the command to complete
	 * @param editingDomain
	 *        the editing domain
	 * @param destructionEventPart
	 *        the execution specification edit part on which the request is called
	 * @return the deletion command deleteViewsCmd for convenience
	 */
	public static CompoundCommand completeDeleteDestructionEventViewCommand(CompoundCommand deleteViewsCmd, TransactionalEditingDomain editingDomain, EditPart destructionEventPart) {
		Object model = destructionEventPart.getModel();
		if(model instanceof Node) {
			EObject obj = ((Node)model).getElement();
	
			if(obj instanceof DestructionEvent) {
				LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(destructionEventPart);
				if(lifelinePart != null) {
					for(Object lifelineChild : lifelinePart.getChildren()) {
						if(lifelineChild instanceof IBorderItemEditPart) {
							final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
							//At most one destruction event. Only parts linked to it can not move for now.
							boolean isNotLinked = SequenceUtil.canTimeElementPartBeYMoved(timePart);
							if(!isNotLinked) {
								// time part is linked, delete the view
								Command deleteTimeViewCommand = new ICommandProxy(new DeleteCommand(editingDomain, (View)timePart.getModel()));
								deleteViewsCmd.add(deleteTimeViewCommand);
							}
						}
					}
				}
			}
		}
		return deleteViewsCmd;
	}

	/**
	 * Complete an ICommand which destroys an ExecutionSpecification element to also destroy dependent finish and start events and time/duration
	 * constraint/observation linked with these ends
	 * 
	 * @param deleteViewsCmd
	 *        the command to complete
	 * @param editingDomain
	 *        the editing domain
	 * @param executionPart
	 *        the execution specification edit part on which the request is called
	 * @return the deletion command deleteViewsCmd for convenience
	 */
	public static CompoundCommand completeDeleteMessageViewCommand(CompoundCommand deleteViewsCmd, TransactionalEditingDomain editingDomain, EditPart messagePart) {
		Object model = messagePart.getModel();
		if(messagePart instanceof ConnectionNodeEditPart && model instanceof Edge) {
			EObject obj = ((Edge)model).getElement();
			if(obj instanceof Message) {
				Message message = (Message)obj;
				LifelineEditPart srcLifelinePart = SequenceUtil.getParentLifelinePart(((ConnectionNodeEditPart)messagePart).getSource());
				MessageEnd send = message.getSendEvent();
				a(deleteViewsCmd, editingDomain, srcLifelinePart, send);
				
				LifelineEditPart tgtLifelinePart = SequenceUtil.getParentLifelinePart(((ConnectionNodeEditPart)messagePart).getTarget());
				MessageEnd receive = message.getReceiveEvent();
				a(deleteViewsCmd, editingDomain, tgtLifelinePart, receive);
			}
		}
		return deleteViewsCmd;
	}

	/**
	 * @param deleteViewsCmd
	 * @param editingDomain
	 * @param lifelineEP
	 * @param send
	 */
	private static void a(CompoundCommand deleteViewsCmd, TransactionalEditingDomain editingDomain, LifelineEditPart lifelineEP, MessageEnd send) {
		if(lifelineEP != null && send instanceof OccurrenceSpecification) {
			for(Object lifelineChild : lifelineEP.getChildren()) {
				if(lifelineChild instanceof IBorderItemEditPart) {
					final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
					int positionForEvent = SequenceUtil.positionWhereEventIsLinkedToPart((OccurrenceSpecification)send, timePart);
					if(positionForEvent != PositionConstants.NONE) {
						// time part is linked, delete the view
						Command deleteTimeViewCommand = new ICommandProxy(new DeleteCommand(editingDomain, (View)timePart.getModel()));
						deleteViewsCmd.add(deleteTimeViewCommand);
					}
				}
			}
		}
	}

	

	/**
	 * Complete an ICommand which destroys an ExecutionSpecification element to also destroy dependent finish and start events and time/duration
	 * constraint/observation linked with these ends
	 * 
	 * @param deleteViewsCmd
	 *        the command to complete
	 * @param editingDomain
	 *        the editing domain
	 * @param executionPart
	 *        the execution specification edit part on which the request is called
	 * @return the deletion command deleteViewsCmd for convenience
	 */
	public static CompoundCommand completeDeleteExecutionSpecificationViewCommand(CompoundCommand deleteViewsCmd, TransactionalEditingDomain editingDomain, EditPart executionPart) {
		Object model = executionPart.getModel();
		if(model instanceof Node) {
			EObject obj = ((Node)model).getElement();
	
			if(obj instanceof ExecutionSpecification) {
				ExecutionSpecification execution = (ExecutionSpecification)obj;
				LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(executionPart);
				if(lifelinePart != null) {
					for(Object lifelineChild : lifelinePart.getChildren()) {
						if(lifelineChild instanceof IBorderItemEditPart) {
							final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
							OccurrenceSpecification start = execution.getStart();
							OccurrenceSpecification finish = execution.getStart();
							int positionForStart = SequenceUtil.positionWhereEventIsLinkedToPart(start, timePart);
							int positionForFinish = SequenceUtil.positionWhereEventIsLinkedToPart(finish, timePart);
							if(positionForStart != PositionConstants.NONE || positionForFinish != PositionConstants.NONE) {
								// time part is linked, delete the view
								Command deleteTimeViewCommand = new ICommandProxy(new DeleteCommand(editingDomain, (View)timePart.getModel()));
								deleteViewsCmd.add(deleteTimeViewCommand);
							}
						}
					}
				}
			}
		}
		return deleteViewsCmd;
	}

	/**
	 * Complete an ICommand which destroys an ExecutionSpecification element to also destroy dependent finish and start events and time/duration
	 * constraint/observation linked with these ends
	 * 
	 * @param cmd
	 *        the command to complete
	 * @param executionPart
	 *        the execution specification edit part on which the request is called
	 * @return the deletion ICommand cmd for convenience
	 */
	public static ICommand completeDestroyExecutionSpecificationCommand(CompositeTransactionalCommand cmd, EditPart executionPart) {
		Object model = executionPart.getModel();
		if(model instanceof Node) {
			EObject obj = ((Node)model).getElement();
	
			if(obj instanceof ExecutionSpecification) {
				ExecutionSpecification execution = (ExecutionSpecification)obj;
				return completeDestroyExecutionSpecificationCommand(cmd, execution);
			}
		}
		return cmd;
	}
	
	/**
	 * Delete the views associated with a list of elements. 
	 * @param cmd the CompositeTransactionalCommand
	 * @param element the list of model elements
	 * @param editingDomain the editing domain to use.
	 */
	public static void deleteView(CompositeTransactionalCommand cmd, List<Element> elements, TransactionalEditingDomain editingDomain){
		for(Element element : elements){
			deleteView(cmd, element, editingDomain);
		}
	}

	/**
	 * Delete the views associated with an element. 
	 * @param cmd the CompositeTransactionalCommand
	 * @param element the model element referenced by the views
	 * @param editingDomain the editing domain to use.
	 */
	public static void deleteView(CompositeTransactionalCommand cmd, Element element, TransactionalEditingDomain editingDomain){
		// Destroy its views
		@SuppressWarnings("rawtypes")
		List views = DiagramEditPartsUtil.getEObjectViews(element);
		for(Object object : views){
			if(object instanceof View){
				cmd.add(new DeleteCommand(editingDomain, (View)object));
			}
		}
	}
}
