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
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ObservationLinkEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineXYLayoutEditPolicy;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeObservation;

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
	public static CompoundCommand completeDeleteDestructionOccurenceViewCommand(CompoundCommand deleteViewsCmd, TransactionalEditingDomain editingDomain, EditPart destructionEventPart) {
		if(destructionEventPart instanceof IGraphicalEditPart) {
			EObject obj = ((IGraphicalEditPart)destructionEventPart).resolveSemanticElement();

			if(obj instanceof DestructionOccurrenceSpecification) {
				LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(destructionEventPart);
				if(lifelinePart != null) {
					for(Object lifelineChild : lifelinePart.getChildren()) {
						if(lifelineChild instanceof IBorderItemEditPart) {
							final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
							//At most one destruction event. Only parts linked to it can not move for now.
							boolean isNotLinked = OccurrenceSpecificationMoveHelper.canTimeElementPartBeYMoved(timePart);
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
				
				// also delete time observation links which are related to message end
				if (send instanceof OccurrenceSpecification) {
					addDeleteRelatedTimeObservationLinkCommand(deleteViewsCmd, editingDomain,(OccurrenceSpecification) send, srcLifelinePart,false);
				}
				if (receive instanceof OccurrenceSpecification) {
					addDeleteRelatedTimeObservationLinkCommand(deleteViewsCmd, editingDomain,(OccurrenceSpecification) receive, tgtLifelinePart,false);
				}
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
					
					// delete each observation linked time element
					for(Object targetConnection : lifelinePart.getTargetConnections()){
						if(targetConnection instanceof ObservationLinkEditPart){
							ObservationLinkEditPart observationLinkEditPart = (ObservationLinkEditPart)targetConnection;
							TimeObservationLabelEditPart source = (TimeObservationLabelEditPart)observationLinkEditPart.getSource();
							OccurrenceSpecification start = execution.getStart();
							OccurrenceSpecification finish = execution.getFinish();
							int positionForStart = SequenceUtil.positionWhereEventIsLinkedToPart(start, source);
							int positionForFinish = SequenceUtil.positionWhereEventIsLinkedToPart(finish, source);
							if(positionForStart != PositionConstants.NONE) {
								// time part is linked, delete the view
								//Command deleteTimeViewCommand = new ICommandProxy(new DeleteCommand(editingDomain, (View)source.getModel()));
								//deleteViewsCmd.add(deleteTimeViewCommand);
								addDeleteRelatedTimeObservationLinkCommand(deleteViewsCmd,
										editingDomain, start, lifelinePart,false);
							}
							if(positionForFinish != PositionConstants.NONE) {
								addDeleteRelatedTimeObservationLinkCommand(deleteViewsCmd,
										editingDomain, finish, lifelinePart,false);
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
	
	/**
	 * Add complete delete message command
	 * @param req
	 * @param editPart
	 * @return Command
	 */
	public static Command completeDeleteMessageCommand(DestroyElementRequest req,EditPart editPart) {
		EObject selectedEObject = req.getElementToDestroy();
		IElementEditService provider = ElementEditServiceUtils
				.getCommandProvider(selectedEObject);
		if (provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(req);
			if (deleteCommand != null) {
				CompositeCommand command = new CompositeCommand(
						deleteCommand.getLabel());
				command.add(deleteCommand);
				Message message = (Message) selectedEObject;
				
				MessageEnd receiveEvent = message.getReceiveEvent();
				if (receiveEvent != null) {
					DestroyElementRequest myReq = new DestroyElementRequest(
							req.getEditingDomain(), receiveEvent, false);
					command.add(new DestroyElementCommand(myReq));
				}
				MessageEnd sendEvent = message.getSendEvent();
				if (sendEvent != null) {
					DestroyElementRequest myReq = new DestroyElementRequest(
							req.getEditingDomain(), sendEvent, false);
					command.add(new DestroyElementCommand(myReq));
				}
				
				CompoundCommand compoundCommand = new CompoundCommand();
				compoundCommand.add(new ICommandProxy(command));
				
				addDeleteMessageRelatedTimeObservationLinkCommand(req.getEditingDomain(), editPart, compoundCommand,
						receiveEvent,true);
				addDeleteMessageRelatedTimeObservationLinkCommand(req.getEditingDomain(), editPart, compoundCommand,
						sendEvent,true);

				return compoundCommand;
			}
		}

		return UnexecutableCommand.INSTANCE;
	}
	
	public static void destroyExecutionOccurrenceSpecification(
			DestroyElementRequest req, CompoundCommand deleteElementsCommand, ShapeNodeEditPart host,
			ExecutionSpecification es) {
		DestroyElementRequest delStart = new DestroyElementRequest(req.getEditingDomain(), es.getStart(), false);
		deleteElementsCommand.add(new ICommandProxy(new DestroyElementCommand(delStart)));
		
		DestroyElementRequest delEnd = new DestroyElementRequest(req.getEditingDomain(), es.getFinish(), false);
		deleteElementsCommand.add(new ICommandProxy(new DestroyElementCommand(delEnd)));
		
		destroyMessageEvents(deleteElementsCommand, host, req.getEditingDomain());
		
		if (host.getParent() instanceof LifelineEditPart){
			List<OccurrenceSpecification> oss = new ArrayList<OccurrenceSpecification>();
			oss.add(es.getStart());
			oss.add(es.getFinish());
			SequenceDeleteHelper.addDeleteRelatedTimeObservationLinkCommand(
					deleteElementsCommand, req.getEditingDomain(),
					(LifelineEditPart) host.getParent(), oss,true);
		}
		
		SequenceDeleteHelper.addDestroyExecutionSpecificationChildrenCommand(deleteElementsCommand, req.getEditingDomain(), host);
	}
	
	public static void destroyMessageEvents(
			CompoundCommand deleteElementsCommand, ShapeNodeEditPart host, TransactionalEditingDomain transactionalEditingDomain) {
		destroyMessageEvents(deleteElementsCommand, host.getSourceConnections(), transactionalEditingDomain);
		destroyMessageEvents(deleteElementsCommand, host.getTargetConnections(), transactionalEditingDomain);
	}
	
	static void destroyMessageEvents(
			CompoundCommand deleteElementsCommand, List list, TransactionalEditingDomain transactionalEditingDomain) {
		for(Object o : list)
			if(o instanceof ConnectionEditPart){
				EObject model = ((ConnectionEditPart) o).resolveSemanticElement();
				if(model instanceof Message){
					Message message = (Message) model;
					MessageEnd receiveEvent = message.getReceiveEvent();
					if (receiveEvent != null) {
						DestroyElementRequest myReq = new DestroyElementRequest(
								transactionalEditingDomain, receiveEvent, false);
						deleteElementsCommand.add(new ICommandProxy(new DestroyElementCommand(myReq)));
					}
					MessageEnd sendEvent = message.getSendEvent();
					if (sendEvent != null) {
						DestroyElementRequest myReq = new DestroyElementRequest(
								transactionalEditingDomain, sendEvent, false);
						deleteElementsCommand.add(new ICommandProxy(new DestroyElementCommand(myReq)));
					}
				}
			}
	}

	static void addDestroyExecutionSpecificationChildrenCommand(CompoundCommand deleteElementsCommand, TransactionalEditingDomain editingDomain, ShapeNodeEditPart part) {
		List<ShapeNodeEditPart> list = LifelineXYLayoutEditPolicy.getAffixedExecutionSpecificationEditParts(part);
		for(ShapeNodeEditPart p : list){
			Request request = new EditCommandRequestWrapper(new DestroyElementRequest(p.resolveSemanticElement(), false));
			deleteElementsCommand.add(p.getCommand(request));
			
			destroyMessageEvents(deleteElementsCommand, p.getSourceConnections(), editingDomain);
			destroyMessageEvents(deleteElementsCommand, p.getTargetConnections(), editingDomain);
		}
	}

	
	/**
	 * Add delete message related time observation link command
	 * @param editingDomain
	 * @param editPart
	 * @param command
	 * @param messageEnd
	 * @param deleteRelatedEvent
	 */
	static void addDeleteMessageRelatedTimeObservationLinkCommand(
			TransactionalEditingDomain editingDomain, EditPart editPart,
			CompoundCommand compoundCommand, MessageEnd messageEnd,boolean deleteRelatedEvent) {
		//Bug fix: messageEnd maybe a Gate instance.
		if(messageEnd != null && messageEnd instanceof OccurrenceSpecification){
			OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification) messageEnd;
			EList<Lifeline> receiveCovereds = occurrenceSpecification.getCovereds();
			if(receiveCovereds.size() >0 ){
				LifelineEditPart srcLifelinePart = (LifelineEditPart) SequenceUtil.getEditPart(editPart,receiveCovereds.get(0), LifelineEditPart.class);
				addDeleteRelatedTimeObservationLinkCommand(compoundCommand, editingDomain, occurrenceSpecification, srcLifelinePart,deleteRelatedEvent);
			}
		}
	}

	/**
	 * Add command for deleting time observation link which related to occurence specification
	 * @param deleteViewsCmd
	 * @param editingDomain
	 * @param os
	 * @param srcLifelinePart
	 * @param deleteRelatedEvent
	 */
	private static void addDeleteRelatedTimeObservationLinkCommand(
			CompoundCommand deleteViewsCmd,
			TransactionalEditingDomain editingDomain, OccurrenceSpecification os,
			LifelineEditPart srcLifelinePart, boolean deleteRelatedEvent) {
		List<OccurrenceSpecification> oss = new ArrayList<OccurrenceSpecification>();
		oss.add(os);
		addDeleteRelatedTimeObservationLinkCommand(deleteViewsCmd, editingDomain,srcLifelinePart, oss,deleteRelatedEvent);
	}
	
	/**
	 * Add command for deleting time observation link which related to occurence specification
	 * @param deleteViewsCmd
	 * @param editingDomain
	 * @param srcLifelinePart
	 * @param oss
	 * @param deleteRelatedEvent
	 */
	public static void addDeleteRelatedTimeObservationLinkCommand(
			CompoundCommand deleteViewsCmd,
			TransactionalEditingDomain editingDomain,LifelineEditPart srcLifelinePart,List<OccurrenceSpecification> oss,boolean deleteRelatedEvent) {
		List<TimeObservationLabelEditPart> timeObservationEditParts = SequenceUtil.findOccurenceSpecificationRelatedTimeObservationPart(srcLifelinePart,oss);
		for (final TimeObservationLabelEditPart timeObservationEditPart : timeObservationEditParts) {
			View view = (View) timeObservationEditPart.getModel();
			EList sourceEdges = view.getSourceEdges();
			for (Object sourceEdge : sourceEdges) {
				Command deleteTimeViewCommand = new ICommandProxy(
						new DeleteCommand(editingDomain, (View) sourceEdge));
				deleteViewsCmd.add(deleteTimeViewCommand);
			}
			if(deleteRelatedEvent){
				deleteViewsCmd.add(new ICommandProxy(new AbstractTransactionalCommand(editingDomain,"Remove TimeObservation related event",null){
					@Override
					protected CommandResult doExecuteWithResult(
							IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {
						TimeObservation timeObservation = (TimeObservation)(timeObservationEditPart.resolveSemanticElement());
						timeObservation.setEvent(null);
						return CommandResult.newOKCommandResult();
					}
				}));
			}
		}
	}
	
}
