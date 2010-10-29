/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr  - Adapted from Composite Structure Diagram
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DecorationNodeImpl;
import org.eclipse.papyrus.diagram.communication.custom.helper.CommunicationUtil;
import org.eclipse.papyrus.diagram.communication.custom.helper.MessageInfo;
import org.eclipse.papyrus.diagram.communication.custom.helper.ReconnectMessageHelper;
import org.eclipse.papyrus.diagram.communication.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.diagram.communication.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;


// TODO: Auto-generated Javadoc
/**
 * The Class CustomMessageReorientCommand is intended to reorient the messages on a connector between two lifelines
 * This command is used when a connector is reoriented
 */
public class CustomMessagesReorientCommand extends MessageReorientCommand {

	/** the new end. */
	protected EObject newEnd;

	/** the old end. */
	protected EObject oldEnd;

	/** the end to reconnect. */
	protected int reorientDirection;

	/** The messages to edit */
	protected List<MessageInfo> elementsToEdit;


	/** the Lifeline source of the graphical connector */
	Lifeline srcLifeline = null;

	/** the Lifeline target of the graphical connector */
	Lifeline targetLifeline = null;

	/** the graphical edge (or connector) that is reconnected */
	Object graphicalRconnectedEdge = null;



	/**
	 * Constructor.
	 * 
	 * @param req
	 *        the req
	 */
	public CustomMessagesReorientCommand(ReorientRelationshipRequest req) {
		super(req);


		this.reorientDirection = req.getDirection();
		this.oldEnd = req.getOldRelationshipEnd();
		this.newEnd = req.getNewRelationshipEnd();
		this.graphicalRconnectedEdge = req.getParameter(UMLBaseItemSemanticEditPolicy.GRAPHICAL_RECONNECTED_EDGE);

		this.elementsToEdit = getElementstoEdit();
		this.srcLifeline = getsrcLifeline();
		this.targetLifeline = gettargetLifeline();

	}

	/**
	 * Returns Lifeline source of the graphical connector
	 * 
	 * @return
	 *         Lifeline source of the graphical connector
	 */
	protected Lifeline getsrcLifeline() {
		if(this.graphicalRconnectedEdge instanceof Connector) {
			View src = ((Connector)graphicalRconnectedEdge).getSource();
			if(src.getElement() instanceof Lifeline) {
				return (Lifeline)src.getElement();
			}
		}
		return null;

	}

	/**
	 * Returns Lifeline target of the graphical connector
	 * 
	 * @return
	 *         Lifeline target of the graphical connector
	 */
	protected Lifeline gettargetLifeline() {
		if(this.graphicalRconnectedEdge instanceof Connector) {
			View target = ((Connector)graphicalRconnectedEdge).getTarget();
			if(target.getElement() instanceof Lifeline) {
				return (Lifeline)target.getElement();
			}
		}
		return null;

	}



	/**
	 * Returns the list of messages that will be reoriented
	 * 
	 * @return
	 *         the list of messages that will be reoriented
	 */
	protected List<MessageInfo> getElementstoEdit() {
		//the list of events covering the old Lifeline which was at the end of the connection
		List<InteractionFragment> listEventsOldLifeline = null;
		//the list of messages on the connection
		List<MessageInfo> listMessagesOnConnection = new ArrayList<MessageInfo>();

		//Verify if the oldEnd is a Lifeline
		if(oldEnd instanceof Lifeline) {
			listEventsOldLifeline = ((Lifeline)oldEnd).getCoveredBys();

			//Verify if the graphicalRconnectedEdge is a Connector
			if(this.graphicalRconnectedEdge instanceof Connector) {

				@SuppressWarnings("rawtypes")
				List children = ((Connector)graphicalRconnectedEdge).getChildren();
				for(int j = 0; j < children.size(); j++) {
					//get the child of the connector,
					if(children.get(j) instanceof DecorationNodeImpl) {
						DecorationNodeImpl label = (DecorationNodeImpl)children.get(j);
						if(label.getElement() instanceof Message) {// if the child of the graphicalRconnectedEdge corresponds to a message on the connector
							//Collect the MessageInfo (UML message, source lifeline of the message, target lifeline of the message)
							Message mess = (Message)label.getElement();

							MessageEnd sendEvent = mess.getSendEvent();

							MessageEnd rcvEvent = mess.getReceiveEvent();

							//							Collection<?> sources = CommunicationLinkMappingHelper.getInstance().getSource(mess);
							//							Collection<?> targets = CommunicationLinkMappingHelper.getInstance().getTarget(mess);
							//							if(!sources.isEmpty() && !targets.isEmpty()) {
							//								Element source = (Element)sources.toArray()[0];
							//								Element target = (Element)targets.toArray()[0];
							//								if((source instanceof Lifeline) && (target instanceof Lifeline)) {
							//									MessageInfo messInfo = new MessageInfo(mess, (Lifeline)source, (Lifeline)target);
							//									listMessagesOnConnection.add(messInfo);
							//								}
							//
							//							}
							for(int i = 0; i < listEventsOldLifeline.size(); i++) {//find the source and target of the message represented by a label
								if(listEventsOldLifeline.get(i).equals(rcvEvent)) {//the host lifeline is the target of the connection, 
									//it's not important to set the source of the message, we dont need it because we are going to update one end of the message
									MessageInfo messInfo = new MessageInfo(mess, null, (Lifeline)oldEnd);
									listMessagesOnConnection.add(messInfo);

									break;
								} else if(listEventsOldLifeline.get(i).equals(sendEvent)) {//the host lifeline is the source of the connection
									//it's not important to set the target of the message,  we dont need it because we are going to update one end of the message
									MessageInfo messInfo = new MessageInfo(mess, (Lifeline)oldEnd, null);
									listMessagesOnConnection.add(messInfo);

									break;
								}
							}
						}
					}
				}
			}
		}


		return listMessagesOnConnection;
	}



	/**
	 * @see org.eclipse.papyrus.diagram.communication.edit.commands.MessageReorientCommand#canExecute()
	 * 
	 * @return true if can execute, false else
	 */
	public boolean canExecute() {
		return !areConnected();
		//return true;
	}





	protected boolean canReorient() {
		if(!(oldEnd instanceof Element && newEnd instanceof Element)) {
			return false;
		}
		return true;
	}

	/**
	 * areConnected
	 * 
	 * @return
	 *         true if the newEnd Lifeline is already connected to the Lifeline which is at the other end (not the oldEnd) of the graphical connector
	 */
	protected boolean areConnected() {
		if((oldEnd.equals(targetLifeline)) && (newEnd instanceof Lifeline)) {
			if(!(CommunicationUtil.verifyUMLLifelinesConnected(srcLifeline, (Lifeline)newEnd) == null)) {
				return true;
			}
		}
		if((oldEnd.equals(srcLifeline)) && (newEnd instanceof Lifeline)) {
			if(!(CommunicationUtil.verifyUMLLifelinesConnected(targetLifeline, (Lifeline)newEnd) == null)) {
				return true;
			}
		}
		return false;
	}


	protected CommandResult reorient() throws ExecutionException {


		if(!elementsToEdit.isEmpty()) {
			for(int k = 0; k < elementsToEdit.size(); k++) {//reorient all the elementsToEdit
				Message mess = elementsToEdit.get(k).getMessage();
				if(!(elementsToEdit.get(k).getTarget() == null)) {
					if(elementsToEdit.get(k).getTarget().equals(oldEnd)) {
						ReconnectMessageHelper.updateMessageEnd(mess.getReceiveEvent(), (Element)oldEnd, (Element)newEnd);
					}
				} else {
					if(!(elementsToEdit.get(k).getSource() == null)) {
						if(elementsToEdit.get(k).getSource().equals(oldEnd)) {
							ReconnectMessageHelper.updateMessageEnd(mess.getSendEvent(), (Element)oldEnd, (Element)newEnd);
						}
					}
				}
			}
			return CommandResult.newOKCommandResult(elementsToEdit.get(0).getMessage());
		}
		throw new IllegalStateException();

		//throw new UnsupportedOperationException();


	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canReorient()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		return reorient();

	}





}
