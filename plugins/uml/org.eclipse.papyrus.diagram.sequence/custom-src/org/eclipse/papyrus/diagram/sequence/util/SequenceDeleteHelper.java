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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.DurationObservationHelper;
import org.eclipse.papyrus.diagram.common.helper.TimeConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.TimeObservationHelper;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.Util;
import org.eclipse.papyrus.diagram.sequence.edit.commands.DurationConstraintInMessageCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * An Helper to get deleting command for the sequence diagram elements.
 */

public class SequenceDeleteHelper {

	/**
	 * Destroy all the relatives elements of an CombinedFragment
	 * 
	 * @param cf
	 *        the combined fragment to destroy
	 * @param cmd
	 *        the composite transactional command where to add the new commands.
	 * @return the list of all elements that will be destroyed
	 */
	public static List<Element> destroyCombinedFragmentRelatives(CombinedFragment cf, CompositeTransactionalCommand cmd) {
		List<Element> elements = new LinkedList<Element>();

		// Destroy each operand of the combinedFragment
		for(InteractionOperand operand : cf.getOperands()) {
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
	 * Destroy all the relatives elements of an InteractionOperand
	 * 
	 * @param interactionOperand
	 *        the combined fragment to destroy
	 * @param cmd
	 *        the composite transactional command where to add the new commands.
	 * @return the list of all elements that will be destroyed
	 */
	public static List<Element> destroyInteractionOperandRelatives(InteractionOperand interactionOperand, CompositeTransactionalCommand cmd) {
		List<Element> elements = SequenceUtil.getInteractionOperandAssociatedElement(interactionOperand);
		List<Element> childElements = new LinkedList<Element>();
		// Delete InteractionOperand
		for(Element element : elements) {
			if(element instanceof CombinedFragment) {
				childElements.addAll(destroyCombinedFragmentRelatives((CombinedFragment)element, cmd));
			} else {
				// Complete the destroy command with specific destroy commands. 
				if(element instanceof Message) {
					completeDestroyMessageCommand((Message)element, cmd);
				} else if(element instanceof ExecutionSpecification) {
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
	public static ICommand completeDestroyMessageCommand(Message message, CompositeTransactionalCommand cmd) {

		// Destroy the send event
		destroyMessageEnd(cmd, message.getSendEvent(), false);

		// Destroy the receive event
		destroyMessageEnd(cmd, message.getReceiveEvent(), false);

		return cmd;
	}

	/**
	 * Destroy a messageEnd
	 * 
	 * @param cmd
	 *        the composite transactional command where the new commands will be added
	 * @param messageEnd
	 *        the messageEnd to destroy
	 * @param deleteStartedOrEndedMessage
	 *        true if we must destroy the started or ended message as chain effect, false if this deletion is provoked by the deletion of the message
	 *        itself.
	 */
	private static void destroyMessageEnd(CompositeTransactionalCommand cmd, MessageEnd messageEnd, boolean deleteStartedOrEndedMessage) {
		if(messageEnd instanceof MessageOccurrenceSpecification) {
			destroyOccurrenceSpecification(cmd, (MessageOccurrenceSpecification)messageEnd, deleteStartedOrEndedMessage);
		} else if(messageEnd instanceof Gate) {
			destroyGate(cmd, (Gate)messageEnd);
		}
	}

	/**
	 * Destroy a Gate - NOT IMPLEMENTED YET
	 * 
	 * @param cmd
	 *        the composite transactional command where the new commands will be added
	 * @param gate
	 *        the gate to destroy
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
		destroyOccurrenceSpecification(cmd, execution.getStart(), false);

		// Destroy end execution occurrence specification
		destroyOccurrenceSpecification(cmd, execution.getFinish(), false);

		return cmd;
	}

	/**
	 * Destroy the given OccurrenceSpecification with side effects :<br/>
	 * <li>
	 * <ul>
	 * destroy related elements (started or ended by) if deleteStartedOrEndedElement,
	 * </ul>
	 * <ul>
	 * destroy linkedTimeElements,
	 * </ul>
	 * <ul>
	 * rearrange or delete linked GeneralOrdering.
	 * </ul>
	 * </li>
	 * 
	 * @param cmd
	 *        the composite transactional command where the new commands will be added
	 * @param os
	 *        the occurrenceSpecification to destroy
	 * @param deleteStartedOrEndedElement
	 *        true if we must destroy the started or ended element as chain effect, false if this deletion is provoked by the deletion of the linked
	 *        element itself.
	 */
	private static void destroyOccurrenceSpecification(CompositeTransactionalCommand cmd, OccurrenceSpecification os, boolean deleteStartedOrEndedElement) {
		cmd.add(createDestroyElementCommand(os));
		if(deleteStartedOrEndedElement) {
			// TODO delete started or ended execution and messages
		}
		// delete linked time elements
		List<NamedElement> timeElements = getLinkedTimeElements(os);
		for(NamedElement elt : timeElements) {
			cmd.add(createDestroyElementCommand(elt));
		}
		// rearrange linked general ordering
		replaceGeneralOrderings(cmd, os);
	}

	/**
	 * Rearrange General Orderings linked to the deleted occurrence specification so that order is conserved.
	 * 
	 * @param cmd
	 *        the composite transactional command where the new commands will be added
	 * @param deletedOccurrenceSpecification
	 *        occurrence specification to be deleted
	 */
	private static void replaceGeneralOrderings(CompositeTransactionalCommand cmd, OccurrenceSpecification deletedOccurrenceSpecification) {
		/*
		 * Illustrating example :
		 * A ->- D ->- E
		 * B ->- D
		 * C ->- D ->- F
		 * When D is deleted, general orderings are replaced by new ones, such as each beginning occurrence specification is linked to an ending
		 * occurrence specification.
		 * Hence, we get :
		 * A ->- E
		 * B ->- E
		 * C ->- E
		 * A ->- F
		 * B ->- F
		 * C ->- F
		 * 
		 * 1. Count B (=3) occurrence specifications before incoming GeneralOrderings and A (=2) occurrence specifications after outgoing
		 * GeneralOrderings.
		 * 2. Destroy all of old GeneralOrderings.
		 * 3. Replace by B*A (=6) new GeneralOrderings linking occurrence specifications.
		 */
		EList<GeneralOrdering> beforeGOs = deletedOccurrenceSpecification.getToBefores();
		EList<GeneralOrdering> afterGOs = deletedOccurrenceSpecification.getToAfters();
		// 1. count B and A
		List<OccurrenceSpecification> befores = new ArrayList<OccurrenceSpecification>(beforeGOs.size());
		List<OccurrenceSpecification> afters = new ArrayList<OccurrenceSpecification>(afterGOs.size());
		// if B or A = 0, B*A = 0 no new GeneralOrdering, no need to count either
		if(beforeGOs.size() > 0 && afterGOs.size() > 0) {
			// count B
			for(GeneralOrdering go : beforeGOs) {
				if(go.getBefore() != null) {
					befores.add(go.getBefore());
				}
			}
			// count A
			for(GeneralOrdering go : afterGOs) {
				if(go.getAfter() != null) {
					afters.add(go.getAfter());
				}
			}
		}
		// 2. Delete GeneralOrderings.
		for(GeneralOrdering go : beforeGOs) {
			cmd.add(createDestroyElementCommand(go));
		}
		for(GeneralOrdering go : afterGOs) {
			cmd.add(createDestroyElementCommand(go));
		}
		// 3. Create new GeneralOrderings.
		for(OccurrenceSpecification before : befores) {
			for(OccurrenceSpecification after : afters) {
				InteractionFragment parent = Util.getCommonParent(before, after, InteractionFragment.class);
				if(parent != null) {
					//TODO create GeneralOrdering under parent, from before to after
				}
			}
		}
	}

	/**
	 * Get the time elements linked with the given namedElement.
	 * Time Elements regroups:
	 * - Time Observation
	 * - Time Constraint
	 * - DurationObservation
	 * - DurationConstraint
	 * 
	 * @param namedElement
	 *        the named element
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
	 * 
	 * @param eObject
	 *        element to destroy
	 * @return destroy element command
	 */
	private static ICommand createDestroyElementCommand(EObject eObject) {
		return new DestroyElementPapyrusCommand(new DestroyElementRequest(eObject, false));
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
		if(messagePart instanceof IGraphicalEditPart) {
			EObject eObject = ((IGraphicalEditPart)messagePart).resolveSemanticElement();
			if(eObject instanceof Message) {
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
		if(destructionEventPart instanceof IGraphicalEditPart) {
			EObject obj = ((IGraphicalEditPart)destructionEventPart).resolveSemanticElement();

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
		if(messagePart instanceof IGraphicalEditPart) {
			EObject obj = ((IGraphicalEditPart)messagePart).resolveSemanticElement();
			if(obj instanceof Message) {
				Message message = (Message)obj;
				LifelineEditPart srcLifelinePart = SequenceUtil.getParentLifelinePart(((ConnectionNodeEditPart)messagePart).getSource());
				MessageEnd send = message.getSendEvent();
				addDeleteRelatedTimePartsToCommand(deleteViewsCmd, editingDomain, srcLifelinePart, send);

				LifelineEditPart tgtLifelinePart = SequenceUtil.getParentLifelinePart(((ConnectionNodeEditPart)messagePart).getTarget());
				MessageEnd receive = message.getReceiveEvent();
				addDeleteRelatedTimePartsToCommand(deleteViewsCmd, editingDomain, tgtLifelinePart, receive);
			}
		}
		return deleteViewsCmd;
	}

	private static void addDeleteRelatedTimePartsToCommand(CompoundCommand deleteViewsCmd, TransactionalEditingDomain editingDomain, LifelineEditPart lifelineEP, MessageEnd messageEnd) {
		if(lifelineEP != null && messageEnd instanceof OccurrenceSpecification) {
			for(Object lifelineChild : lifelineEP.getChildren()) {
				if(lifelineChild instanceof IBorderItemEditPart) {
					final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
					int positionForEvent = SequenceUtil.positionWhereEventIsLinkedToPart((OccurrenceSpecification)messageEnd, timePart);
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
		if(executionPart instanceof IGraphicalEditPart) {
			EObject obj = ((IGraphicalEditPart)executionPart).resolveSemanticElement();

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
		if(executionPart instanceof IGraphicalEditPart) {
			EObject obj = ((IGraphicalEditPart)executionPart).resolveSemanticElement();

			if(obj instanceof ExecutionSpecification) {
				ExecutionSpecification execution = (ExecutionSpecification)obj;
				return completeDestroyExecutionSpecificationCommand(cmd, execution);
			}
		}
		return cmd;
	}

	/**
	 * Delete the views associated with a list of elements.
	 * 
	 * @param cmd
	 *        the CompositeTransactionalCommand
	 * @param element
	 *        the list of model elements
	 * @param editingDomain
	 *        the editing domain to use.
	 */
	public static void deleteView(CompositeTransactionalCommand cmd, List<Element> elements, TransactionalEditingDomain editingDomain) {
		for(Element element : elements) {
			deleteView(cmd, element, editingDomain);
		}
	}

	/**
	 * Delete the views associated with an element.
	 * 
	 * @param cmd
	 *        the CompositeTransactionalCommand
	 * @param element
	 *        the model element referenced by the views
	 * @param editingDomain
	 *        the editing domain to use.
	 */
	public static void deleteView(CompositeTransactionalCommand cmd, Element element, TransactionalEditingDomain editingDomain) {
		// Destroy its views
		@SuppressWarnings("rawtypes")
		List views = DiagramEditPartsUtil.getEObjectViews(element);
		for(Object object : views) {
			if(object instanceof View) {
				cmd.add(new DeleteCommand(editingDomain, (View)object));
			}
		}
	}
}
