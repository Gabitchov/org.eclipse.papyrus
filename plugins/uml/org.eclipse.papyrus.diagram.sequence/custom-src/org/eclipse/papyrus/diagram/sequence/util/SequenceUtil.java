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
package org.eclipse.papyrus.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DestructionEventEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;


public class SequenceUtil {

	private static final double MAXIMAL_DISTANCE_FROM_EVENT = 10;

	/**
	 * Find the container interaction fragment at the given location.
	 * The elements are drawn under the lifeline, but their model container is an interaction fragment.
	 * It can be of type Interaction or InteractionOperand
	 * 
	 * @param location
	 *        the location
	 * @return the interaction fragment or null
	 */
	public static InteractionFragment findInteractionFragmentAt(Point location, EditPart host) {

		if(host == null) {
			return null;
		}

		List<IFigure> exclusionSet = new ArrayList<IFigure>();

		InteractionFragment interactionFragment = null;
		EditPart ep = host.getRoot().getViewer().findObjectAtExcluding(location, exclusionSet);
		while(ep instanceof LifelineEditPart || ep instanceof BehaviorExecutionSpecificationEditPart || ep instanceof ActionExecutionSpecificationEditPart) {
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
	 * Find the location on the lifeline of an occurrence specification
	 * 
	 * @param lifelineEditPart
	 *        the lifeline edit part
	 * @param event
	 *        the occurrence specification
	 * @return the absolute location or null
	 */
	public static Point findLocationOfEvent(LifelineEditPart lifelineEditPart, OccurrenceSpecification event) {
		if(lifelineEditPart == null) {
			return null;
		}
		// search on graphical children of the lifeline
		List<?> children = lifelineEditPart.getChildren();
		for(Object child : children) {
			// check destruction event
			if(child instanceof DestructionEventEditPart) {
				EObject destructionEvent = ((GraphicalEditPart)child).resolveSemanticElement();
				EObject lifeline = lifelineEditPart.resolveSemanticElement();
				if(destructionEvent instanceof DestructionEvent && lifeline instanceof Lifeline) {
					if(event.equals(destructionEvent)) {
						Rectangle bounds = ((GraphicalEditPart)child).getFigure().getBounds().getCopy();
						lifelineEditPart.getFigure().translateToAbsolute(bounds);
						return bounds.getCenter();
					}
				}
			}
			// check in children executions
			if(child instanceof ActionExecutionSpecificationEditPart || child instanceof BehaviorExecutionSpecificationEditPart) {
				if(event instanceof ExecutionOccurrenceSpecification) {
					// check start and finish events of the execution
					EObject element = ((GraphicalEditPart)child).resolveSemanticElement();
					if(element instanceof ExecutionSpecification) {
						if(event.equals(((ExecutionSpecification)element).getStart())) {
							Rectangle bounds = ((GraphicalEditPart)child).getFigure().getBounds().getCopy();
							lifelineEditPart.getFigure().translateToAbsolute(bounds);
							return bounds.getTop();
						} else if(event.equals(((ExecutionSpecification)element).getFinish())) {
							Rectangle bounds = ((GraphicalEditPart)child).getFigure().getBounds().getCopy();
							lifelineEditPart.getFigure().translateToAbsolute(bounds);
							return bounds.getBottom();
						}
					}
				} else if(event instanceof MessageOccurrenceSpecification) {
					// check messages to and from the execution
					Point loc = findLocationOfMessageOccurrence((GraphicalEditPart)child, (MessageOccurrenceSpecification)event);
					if(loc != null) {
						return loc;
					}
				}
			}
		}
		if(event instanceof MessageOccurrenceSpecification) {
			// check messages to and from the lifeline
			Point loc = findLocationOfMessageOccurrence(lifelineEditPart, (MessageOccurrenceSpecification)event);
			if(loc != null) {
				return loc;
			}
		}
		return null;
	}

	/**
	 * Find the location on a node of a message occurrence specification
	 * 
	 * @param nodeEditPart
	 *        the node edit part which to check incoming and outgoing messages
	 * @param event
	 *        the message occurrence specification
	 * @return the absolute location or null
	 */
	private static Point findLocationOfMessageOccurrence(GraphicalEditPart nodeEditPart, MessageOccurrenceSpecification event) {
		// messages to the node
		List<?> targetConnections = nodeEditPart.getTargetConnections();
		for(Object conn : targetConnections) {
			if(conn instanceof ConnectionNodeEditPart) {
				EObject element = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
				if(element instanceof Message && event.equals(((Message)element).getReceiveEvent())) {
					// finish event of the message
					IFigure figure = ((ConnectionNodeEditPart)conn).getFigure();
					if(figure instanceof AbstractPointListShape) {
						Point end = ((AbstractPointListShape)figure).getEnd().getCopy();
						((AbstractPointListShape)figure).getParent().translateToAbsolute(end);
						return end;
					}
				}
			}
		}
		// messages from the node
		List<?> sourceConnections = nodeEditPart.getSourceConnections();
		for(Object conn : sourceConnections) {
			if(conn instanceof ConnectionNodeEditPart) {
				EObject element = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
				if(element instanceof Message && event.equals(((Message)element).getSendEvent())) {
					// start event of the message
					IFigure figure = ((ConnectionNodeEditPart)conn).getFigure();
					if(figure instanceof AbstractPointListShape) {
						Point start = ((AbstractPointListShape)figure).getStart().getCopy();
						((AbstractPointListShape)figure).getParent().translateToAbsolute(start);
						return start;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Find the occurrence specification covering the lifeline near the given location.
	 * If none is close enough, null is returned.
	 * 
	 * @param location
	 *        the location
	 * @param lifelineEditPart
	 *        the Lifeline edit part
	 * @return an entry with the nearest OccurrenceSpecification and its corresponding location or null if none is close enough
	 */
	public static Entry<OccurrenceSpecification, Point> findNearestEvent(Point location, LifelineEditPart lifelineEditPart) {
		if(lifelineEditPart == null) {
			return null;
		}
		// Map referencing children occurrences by their location on the lifeline.
		Map<OccurrenceSpecification, Point> occurrences = new HashMap<OccurrenceSpecification, Point>();
		// graphical children of the lifeline
		List<?> children = lifelineEditPart.getChildren();
		for(Object child : children) {
			// children executions
			if(child instanceof ActionExecutionSpecificationEditPart || child instanceof BehaviorExecutionSpecificationEditPart) {
				EObject element = ((GraphicalEditPart)child).resolveSemanticElement();
				if(element instanceof ExecutionSpecification) {
					// find start and finish events of the execution
					Rectangle bounds = ((GraphicalEditPart)child).getFigure().getBounds().getCopy();
					lifelineEditPart.getFigure().translateToAbsolute(bounds);
					occurrences.put(((ExecutionSpecification)element).getStart(), bounds.getTop());
					occurrences.put(((ExecutionSpecification)element).getFinish(), bounds.getBottom());
					// messages to and from the execution
					completeOccurrencesMapWithMessages((GraphicalEditPart)child, occurrences);
				}
			}
			// destruction event
			if(child instanceof DestructionEventEditPart) {
				EObject destructionEvent = ((GraphicalEditPart)child).resolveSemanticElement();
				EObject lifeline = lifelineEditPart.resolveSemanticElement();
				if(destructionEvent instanceof DestructionEvent && lifeline instanceof Lifeline) {
					for(InteractionFragment occurence : ((Lifeline)lifeline).getCoveredBys()) {
						if(occurence instanceof OccurrenceSpecification) {
							Event event = ((OccurrenceSpecification)occurence).getEvent();
							if(destructionEvent.equals(event)) {
								Rectangle bounds = ((GraphicalEditPart)child).getFigure().getBounds().getCopy();
								lifelineEditPart.getFigure().translateToAbsolute(bounds);
								occurrences.put((OccurrenceSpecification)occurence, bounds.getCenter());
								break;
							}
						}
					}
				}
			}
		}
		// messages to and from the lifeline
		completeOccurrencesMapWithMessages(lifelineEditPart, occurrences);

		// Find the nearest object within acceptable distance
		double smallerDistance = MAXIMAL_DISTANCE_FROM_EVENT;
		Entry<OccurrenceSpecification, Point> nearestObject = null;
		for(Entry<OccurrenceSpecification, Point> entry : occurrences.entrySet()) {
			double distance = location.getDistance(entry.getValue());
			if(distance < smallerDistance) {
				smallerDistance = distance;
				nearestObject = entry;
			} else if(distance == smallerDistance) {
				// two events at the exact same position. Should not be a coincidence
				// take the message occurrence for being able to create a duration constraint on a message
				if(entry.getKey() instanceof MessageOccurrenceSpecification) {
					nearestObject = entry;
				}
			}
		}

		return nearestObject;
	}

	/**
	 * Complete the map of occurrences and their location, by taking in account messages from and to the node edit part
	 * 
	 * @param nodeEditPart
	 *        part to consider message around
	 * @param occurrencesMap
	 *        the map to complete
	 */
	private static void completeOccurrencesMapWithMessages(GraphicalEditPart nodeEditPart, Map<OccurrenceSpecification, Point> occurrencesMap) {
		// messages to the node
		List<?> targetConnections = nodeEditPart.getTargetConnections();
		for(Object conn : targetConnections) {
			if(conn instanceof ConnectionNodeEditPart) {
				EObject element = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
				if(element instanceof Message && ((Message)element).getReceiveEvent() instanceof MessageOccurrenceSpecification) {
					// finish events of the message
					IFigure figure = ((ConnectionNodeEditPart)conn).getFigure();
					if(figure instanceof AbstractPointListShape) {
						Point end = ((AbstractPointListShape)figure).getEnd().getCopy();
						((AbstractPointListShape)figure).getParent().translateToAbsolute(end);
						occurrencesMap.put((MessageOccurrenceSpecification)((Message)element).getReceiveEvent(), end);
					}
				}
			}
		}
		// messages from the node
		List<?> sourceConnections = nodeEditPart.getSourceConnections();
		for(Object conn : sourceConnections) {
			if(conn instanceof ConnectionNodeEditPart) {
				EObject element = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
				if(element instanceof Message && ((Message)element).getSendEvent() instanceof MessageOccurrenceSpecification) {
					// start events of the message
					IFigure figure = ((ConnectionNodeEditPart)conn).getFigure();
					if(figure instanceof AbstractPointListShape) {
						Point start = ((AbstractPointListShape)figure).getStart().getCopy();
						((AbstractPointListShape)figure).getParent().translateToAbsolute(start);
						occurrencesMap.put((MessageOccurrenceSpecification)((Message)element).getSendEvent(), start);
					}
				}
			}
		}
	}

	/**
	 * The position of the part where the event is linked
	 * 
	 * @param event
	 *        the occurrence specification
	 * @param timeElementPart
	 *        the part representing time element (duration/time constraint/observation)
	 * @return one of {@link PositionConstants#TOP}, {@link PositionConstants#CENTER}, {@link PositionConstants#BOTTOM},
	 *         {@link PositionConstants#NONE}
	 */
	public static int positionWhereEventIsLinkedToPart(OccurrenceSpecification event, IBorderItemEditPart timeElementPart) {
		EObject timeElement = timeElementPart.resolveSemanticElement();
		if(timeElement instanceof TimeObservation) {
			if(event.equals(((TimeObservation)timeElement).getEvent())) {
				return PositionConstants.CENTER;
			} else {
				return PositionConstants.NONE;
			}
		} else if(timeElement instanceof TimeConstraint) {
			if(((TimeConstraint)timeElement).getConstrainedElements().contains(event)) {
				return PositionConstants.CENTER;
			} else {
				return PositionConstants.NONE;
			}
		} else if(timeElement instanceof DurationConstraint) {
			if(((DurationConstraint)timeElement).getConstrainedElements().contains(event)) {
				// TODO find a good way to distinguish top from bottom
				if(event.equals(((DurationConstraint)timeElement).getConstrainedElements().get(0))) {
					return PositionConstants.TOP;
				} else {
					return PositionConstants.BOTTOM;
				}
			} else {
				return PositionConstants.NONE;
			}
		}
		return PositionConstants.NONE;
	}

	/**
	 * Return the lifeline edit part containing this part (directly or indirectly)
	 * 
	 * @param nodeEditPart
	 *        the contained edit part or itself
	 * @return lifeline edit part or null
	 */
	public static LifelineEditPart getParentLifelinePart(EditPart nodeEditPart) {
		EditPart parent = nodeEditPart;
		while(parent != null) {
			if(parent instanceof LifelineEditPart) {
				return (LifelineEditPart)parent;
			} else {
				parent = parent.getParent();
			}
		}
		return null;
	}

	/**
	 * Get commands to move time/duration constraints/observation associated to a given element.
	 * 
	 * @param lifelinePart
	 *        the edit part of the covered lifeline graphically containing time elements
	 * @param event
	 *        the occurrence specification which has moved
	 * @param referencePoint
	 *        the point where the event is moved (in absolute)
	 * @param editPartsNotToMove
	 *        the list of time elements edit parts which must not be moved
	 * @return the command or null
	 */
	public static Command getTimeRelatedElementsMoveCommands(LifelineEditPart lifelinePart, OccurrenceSpecification event, Point referencePoint, List<IBorderItemEditPart> editPartsNotToMove) {
		CompoundCommand command = new CompoundCommand();
		referencePoint = referencePoint.getCopy();
		IFigure parentFigure = lifelinePart.getFigure();
		parentFigure.translateToRelative(referencePoint);
		referencePoint.translate(parentFigure.getBounds().getLocation().getCopy().negate());
		// relocate each linked time element contained within the lifeline part
		for(Object lifelineChild : lifelinePart.getChildren()) {
			if(lifelineChild instanceof IBorderItemEditPart && !editPartsNotToMove.contains(lifelineChild)) {
				final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
				int position = positionWhereEventIsLinkedToPart(event, timePart);
				if(position != PositionConstants.NONE) {
					referencePoint.x = timePart.getFigure().getBounds().getLocation().x;
					// Get old bounds information
					int oldY = timePart.getFigure().getBounds().getLocation().y - parentFigure.getBounds().getLocation().y;
					int oldHeight = timePart.getFigure().getSize().height;
					// Compute new bounds of the time element
					Rectangle newBounds = null;
					if(position == PositionConstants.CENTER) {
						newBounds = new Rectangle(referencePoint.x, referencePoint.y - oldHeight / 2, -1, oldHeight);
					} else if(position == PositionConstants.TOP) {
						int newHeight = oldHeight + oldY - referencePoint.y;
						if(newHeight > 0) {
							newBounds = new Rectangle(referencePoint.x, referencePoint.y, -1, newHeight);
						} else {
							newBounds = new Rectangle(referencePoint.x, referencePoint.y + newHeight, -1, -newHeight);
						}
					} else if(position == PositionConstants.BOTTOM) {
						int newHeight = referencePoint.y - oldY;
						if(newHeight > 0) {
							newBounds = new Rectangle(referencePoint.x, oldY, -1, newHeight);
						} else {
							newBounds = new Rectangle(referencePoint.x, oldY + newHeight, -1, -newHeight);
						}
					}
					if(newBounds != null) {
						TransactionalEditingDomain editingDomain = timePart.getEditingDomain();
						// chain the resize command
						ICommandProxy resize = new ICommandProxy(new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter((View)timePart.getModel()), newBounds));
						command.add(resize);
					}
				}
			}
		}
		// refresh layout
		if(!command.isEmpty()) {
			Command relayout = getReLayoutCmd(lifelinePart);
			if(relayout != null) {
				command.add(relayout);
				return command;
			}
		}
		return null;
	}

	/**
	 * Get a command which refreshes the bordered layout of the node.
	 * 
	 * @param node
	 *        the node with bordered items
	 * @return the refresh command or null
	 */
	public static Command getReLayoutCmd(INodeEditPart node) {
		// relayout the border container figure so that time elements are refreshed
		IFigure fig = node.getFigure();
		if(fig instanceof BorderedNodeFigure) {
			final IFigure container = ((BorderedNodeFigure)fig).getBorderItemContainer();
			Command cmd = new Command() {

				@Override
				public void execute() {
					container.getLayoutManager().layout(container);
				}
			};
			return cmd;
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
			Collection<Setting> settings = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(message);
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
						LifelineEditPart parentLifeline = SequenceUtil.getParentLifelinePart(lifelineChild);
						if(lifelinePart.equals(parentLifeline)) {
							return part;
						}
					}
				}
			}
		} else if(event instanceof ExecutionOccurrenceSpecification) {
			// get parts representing the execution linked with the event
			ExecutionSpecification execution = ((ExecutionOccurrenceSpecification)event).getExecution();
			Collection<Setting> settings = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(execution);
			for(Setting ref : settings) {
				if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
					View view = (View)ref.getEObject();
					EditPart part = DiagramEditPartsUtil.getEditPartFromView(view, lifelinePart);
					// the execution part must be on the lifeline
					EditPart lifelineChild = part;
					LifelineEditPart parentLifeline = SequenceUtil.getParentLifelinePart(lifelineChild);
					if(lifelinePart.equals(parentLifeline)) {
						return part;
					}
				}
			}
		}
		return null;
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
			if(occurrence instanceof OccurrenceSpecification) {
				Event event = ((OccurrenceSpecification)occurrence).getEvent();
				if(event instanceof DestructionEvent) {
					return false;
				}
			}
		}
		return true;
	}
}
