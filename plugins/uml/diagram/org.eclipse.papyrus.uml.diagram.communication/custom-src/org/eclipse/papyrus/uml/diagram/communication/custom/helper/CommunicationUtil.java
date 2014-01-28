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
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - adapted from sequence diagram
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * 
 * @author This is for special commands for communication diagram
 * 
 */
public class CommunicationUtil {

	/**
	 * Find the container interaction fragment at the given location. The
	 * elements are drawn under the lifeline, but their model container is an
	 * interaction fragment. It can be of type Interaction or InteractionOperand
	 * 
	 * @param location
	 *        the location
	 * @param host
	 *        the host edit part
	 * @return the interaction fragment or null
	 */
	public static InteractionFragment findInteractionFragmentAt(Point location, EditPart host) {

		if(host == null) {
			return null;
		}

		List<IFigure> exclusionSet = new ArrayList<IFigure>();

		InteractionFragment interactionFragment = null;
		EditPart ep = host.getRoot().getViewer().findObjectAtExcluding(location, exclusionSet);
		while(ep instanceof LifelineEditPartCN) {
			exclusionSet.add(((GraphicalEditPart)ep).getFigure());
			ep = host.getRoot().getViewer().findObjectAtExcluding(location, exclusionSet);
		}
		// Get the rootEditpart Content
		if(ep != null && ep.getModel() instanceof View) {
			EObject eObject = ViewUtil.resolveSemanticElement((View)ep.getModel());
			if(eObject instanceof InteractionOperand || eObject instanceof Interaction) {
				interactionFragment = (InteractionFragment)eObject;
			}
		}

		return interactionFragment;
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

			if(obj instanceof DestructionOccurrenceSpecification) {
				LifelineEditPartCN lifelinePart = getParentLifelinePart(destructionEventPart);
				if(lifelinePart != null) {
					for(Object lifelineChild : lifelinePart.getChildren()) {
						if(lifelineChild instanceof IBorderItemEditPart) {
							final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
							//At most one destruction event. Only parts linked to it can not move for now.
							boolean isNotLinked = CommunicationUtil.canTimeElementPartBeYMoved(timePart);
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
	 * Know whether this time element part can be moved within the lifeline or not.
	 * Parts linked with a destruction event can not be moved since the destruction event is always at the end.
	 * 
	 * @param timeElementPart
	 *        the part representing a time/duration constraint/observation
	 * @return true if the part can be moved
	 */
	public static boolean canTimeElementPartBeYMoved(IBorderItemEditPart timeElementPart) {
		EObject timeElement = timeElementPart.resolveSemanticElement();
		List<? extends Element> occurrences = Collections.emptyList();
		if(timeElement instanceof TimeObservation) {
			NamedElement occurence = ((TimeObservation)timeElement).getEvent();
			occurrences = Collections.singletonList(occurence);
		} else if(timeElement instanceof TimeConstraint || timeElement instanceof DurationConstraint) {
			occurrences = ((IntervalConstraint)timeElement).getConstrainedElements();
		}
		// check whether one of the time occurrences correspond to a DestructionEvent
		for(Element occurrence : occurrences) {
			if(occurrence instanceof DestructionOccurrenceSpecification) {
					return false;
			}
		}
		return true;
	}

	/**
	 * Return the lifeline edit part containing this part (directly or indirectly)
	 * 
	 * @param nodeEditPart
	 *        the contained edit part or itself
	 * @return lifeline edit part or null
	 */
	public static LifelineEditPartCN getParentLifelinePart(EditPart nodeEditPart) {
		EditPart parent = nodeEditPart;
		while(parent != null) {
			if(parent instanceof LifelineEditPartCN) {
				return (LifelineEditPartCN)parent;
			} else {
				parent = parent.getParent();
			}
		}
		return null;
	}

	/**
	 * Get the edit part which starts or finishes with the event on the given lifeline part
	 * 
	 * @param lifelinePart
	 *        the lifeline edit part on which the event is located
	 * @param event
	 *        the event
	 * @return the edit part of which an end is defined by event on the lifelinePart edit part
	 */
	public static EditPart getLinkedEditPart(EditPart lifelinePart, OccurrenceSpecification event) {
		if(event instanceof MessageOccurrenceSpecification) {
			// get parts representing the message linked with the event
			Message message = ((MessageOccurrenceSpecification)event).getMessage();
			if(message == null) {
				return null;
			}
			Collection<Setting> settings = CacheAdapter.getInstance().getNonNavigableInverseReferences(message);
			for(Setting ref : settings) {
				if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
					View view = (View)ref.getEObject();
					EditPart part = DiagramEditPartsUtil.getEditPartFromView(view, lifelinePart);
					// the message part must start or finish on the lifeline (with the event)
					if(part instanceof ConnectionEditPart) {
						EditPart lifelineChild = null;
						if(event.equals(message.getSendEvent())) {
							lifelineChild = ((ConnectionEditPart)part).getSource();
						} else if(event.equals(message.getReceiveEvent())) {
							lifelineChild = ((ConnectionEditPart)part).getTarget();
						}
						LifelineEditPartCN parentLifeline = CommunicationUtil.getParentLifelinePart(lifelineChild);
						if(lifelinePart.equals(parentLifeline)) {
							return part;
						}
					}
				}
			}
		} else if(event instanceof ExecutionOccurrenceSpecification) {
			// get parts representing the execution linked with the event
			ExecutionSpecification execution = ((ExecutionOccurrenceSpecification)event).getExecution();
			if(execution == null) {
				return null;
			}
			Collection<Setting> settings = CacheAdapter.getInstance().getNonNavigableInverseReferences(execution);
			for(Setting ref : settings) {
				if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
					View view = (View)ref.getEObject();
					EditPart part = DiagramEditPartsUtil.getEditPartFromView(view, lifelinePart);
					// the execution part must be on the lifeline
					EditPart lifelineChild = part;
					LifelineEditPartCN parentLifeline = CommunicationUtil.getParentLifelinePart(lifelineChild);
					if(lifelinePart.equals(parentLifeline)) {
						return part;
					}
				}
			}
		}
		return null;
	}

	/**
	 * This methods verifies if two UML Lifelines are already connected
	 * 
	 * @return
	 *         the list of messages between the two lifelines if Lifelines are connected
	 *         else it returns null
	 */

	public static Set<Message> verifyUMLLifelinesConnected(Lifeline lifeline1, Lifeline lifeline2) {
		EList<InteractionFragment> lifeline1Events = lifeline1.getCoveredBys();
		EList<InteractionFragment> lifeline2Events = lifeline2.getCoveredBys();
		Set<Message> messages = null;
		for(InteractionFragment current1 : lifeline1Events) {
			MessageEnd me1 = (MessageEnd)current1;
			if(!(me1.getMessage() == null)) {
				for(InteractionFragment current2 : lifeline2Events) {
					MessageEnd me2 = (MessageEnd)current2;
					if(!(me2.getMessage() == null)) {
						if(me1.getMessage().equals(me2.getMessage())) {
							if(messages == null) {
								messages = new HashSet<Message>();
								messages.add(me1.getMessage());
							} else {
								messages.add(me1.getMessage());
							}

						}
					}
				}
			}
		}
		return messages;
	}

	/**
	 * Verify if lifelines Ediparts are connected.
	 * 
	 * @param lifeline1EditPart
	 *        the first lifeline edit part
	 * @param lifeline2EditPart
	 *        the second lifeline edit part
	 * @return the connection edit part if lifelines are connected, else it returns null
	 */
	@SuppressWarnings({ "rawtypes" })
	public static ConnectionEditPart verifyIfLifelinesEPConnected(EditPart lifeline1EditPart, EditPart lifeline2EditPart) {
		List sourceConnectionslifeline1 = ((GraphicalEditPart)lifeline1EditPart).getSourceConnections();
		List targetConnectionslifeline2 = ((GraphicalEditPart)lifeline2EditPart).getTargetConnections();
		List sourceConnectionslifeline2 = ((GraphicalEditPart)lifeline2EditPart).getSourceConnections();
		List targetConnectionslifeline1 = ((GraphicalEditPart)lifeline1EditPart).getTargetConnections();
		if((!sourceConnectionslifeline1.isEmpty()) && (!targetConnectionslifeline2.isEmpty())) {

			for(int i = 0; i < sourceConnectionslifeline1.size(); i++) {
				for(int j = 0; j < targetConnectionslifeline2.size(); j++) {
					ConnectionEditPart link1 = (ConnectionEditPart)sourceConnectionslifeline1.get(i);
					ConnectionEditPart link2 = (ConnectionEditPart)targetConnectionslifeline2.get(j);
					//System.err.println("+-> ConnectionEditPart link1:" + link1);
					if(link1.equals(link2)) {
						//System.out.println("Source and target have existent same connection");
						return link1;
					}

				}
			}

		} else if((!sourceConnectionslifeline2.isEmpty()) && (!targetConnectionslifeline1.isEmpty())) {

			for(int i = 0; i < sourceConnectionslifeline2.size(); i++) {
				for(int j = 0; j < targetConnectionslifeline1.size(); j++) {
					ConnectionEditPart link1 = (ConnectionEditPart)sourceConnectionslifeline2.get(i);
					ConnectionEditPart link2 = (ConnectionEditPart)targetConnectionslifeline1.get(j);
					//System.err.println("+-> ConnectionEditPart link1:" + link1);
					if(link1.equals(link2)) {
						//System.out.println("Source and target have existent same connection");
						return link1;
					}

				}
			}

		}
		return null;
	}
}
