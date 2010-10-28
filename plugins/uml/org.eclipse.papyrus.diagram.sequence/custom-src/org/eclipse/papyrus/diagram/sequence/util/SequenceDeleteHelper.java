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

import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * An Helper to get deleting command for the sequence diagram elements.
 */

public class SequenceDeleteHelper {

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
							boolean isNotLinked = OccurenceSpecificationMoveHelper.canTimeElementPartBeYMoved(timePart);
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
