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
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.DurationObservationHelper;
import org.eclipse.papyrus.diagram.common.helper.TimeConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.TimeObservationHelper;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DestructionEventEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
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
		while(ep instanceof LifelineEditPart || ep instanceof BehaviorExecutionSpecificationEditPart || ep instanceof ActionExecutionSpecificationEditPart || ep instanceof StateInvariantEditPart || ep instanceof DestructionEventEditPart || ep instanceof CombinedFragment2EditPart) {
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
					Event destEvent = ((OccurrenceSpecification)event).getEvent();
					if(destEvent != null && destEvent.equals(destructionEvent)) {
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
	 * @return an entry with the nearest OccurrenceSpecification(s) and its corresponding location or null if none is close enough
	 */
	public static Entry<Point, List<OccurrenceSpecification>> findNearestEvent(Point location, LifelineEditPart lifelineEditPart) {
		if(lifelineEditPart == null) {
			return null;
		}
		// Map referencing children occurrences by their location on the lifeline.
		Map<Point, List<OccurrenceSpecification>> occurrences = new HashMap<Point, List<OccurrenceSpecification>>();
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
					if(!occurrences.containsKey(bounds.getTop())) {
						// there should be at most 2 occurrences (with starting message)
						occurrences.put(bounds.getTop(), new ArrayList<OccurrenceSpecification>(2));
					}
					occurrences.get(bounds.getTop()).add(((ExecutionSpecification)element).getStart());
					if(!occurrences.containsKey(bounds.getBottom())) {
						occurrences.put(bounds.getBottom(), new ArrayList<OccurrenceSpecification>(1));
					}
					occurrences.get(bounds.getBottom()).add(((ExecutionSpecification)element).getFinish());
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
								if(!occurrences.containsKey(bounds.getCenter())) {
									occurrences.put(bounds.getCenter(), new ArrayList<OccurrenceSpecification>(2));
								}
								occurrences.get(bounds.getCenter()).add((OccurrenceSpecification)occurence);
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
		Entry<Point, List<OccurrenceSpecification>> nearestObject = null;
		for(Entry<Point, List<OccurrenceSpecification>> entry : occurrences.entrySet()) {
			double distance = location.getDistance(entry.getKey());
			if(distance < smallerDistance) {
				smallerDistance = distance;
				nearestObject = entry;
			} else if(distance == smallerDistance && nearestObject != null) {
				// two events at the exact same distance.
				// Keep both so the best one can be used
				if(entry.getValue() instanceof MessageOccurrenceSpecification) {
					nearestObject.getValue().addAll(entry.getValue());
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
	private static void completeOccurrencesMapWithMessages(GraphicalEditPart nodeEditPart, Map<Point, List<OccurrenceSpecification>> occurrencesMap) {
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
						if(!occurrencesMap.containsKey(end)) {
							occurrencesMap.put(end, new ArrayList<OccurrenceSpecification>(1));
						}
						occurrencesMap.get(end).add((MessageOccurrenceSpecification)((Message)element).getReceiveEvent());
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
						if(!occurrencesMap.containsKey(start)) {
							occurrencesMap.put(start, new ArrayList<OccurrenceSpecification>(1));
						}
						occurrencesMap.get(start).add((MessageOccurrenceSpecification)((Message)element).getSendEvent());
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
				List<Element> events = ((DurationConstraint)timeElement).getConstrainedElements();
				LifelineEditPart lifelinePart = getParentLifelinePart(timeElementPart);
				if(lifelinePart != null && events.size() >= 2) {
					OccurrenceSpecification otherEvent = null;
					if(!event.equals(events.get(0)) && events.get(0) instanceof OccurrenceSpecification) {
						otherEvent = (OccurrenceSpecification)events.get(0);
					} else if(!event.equals(events.get(1)) && events.get(1) instanceof OccurrenceSpecification) {
						otherEvent = (OccurrenceSpecification)events.get(1);
					}
					if(otherEvent != null) {
						Point otherLoc = findLocationOfEvent(lifelinePart, otherEvent);
						Point thisLoc = findLocationOfEvent(lifelinePart, event);
						if(otherLoc != null && thisLoc != null) {
							if(otherLoc.y > thisLoc.y) {
								return PositionConstants.TOP;
							} else {
								return PositionConstants.BOTTOM;
							}
						}
					}
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
	 * The updatedBounds attribute enable to avoid erasing a previous set bounds command. Resizes on a same node are combined.
	 * 
	 * @param lifelinePart
	 *        the edit part of the covered lifeline graphically containing time elements
	 * @param event
	 *        the occurrence specification which has moved
	 * @param referencePoint
	 *        the point where the event is moved (in absolute)
	 * @param editPartsNotToMove
	 *        the list of time elements edit parts which must not be moved
	 * @param updatedBounds
	 *        the map containing the new bounds for the nodes which bounds are to be changed
	 * @return the command or null
	 */
	public static Command getTimeRelatedElementsMoveCommands(LifelineEditPart lifelinePart, OccurrenceSpecification event, Point referencePoint, List<IBorderItemEditPart> editPartsNotToMove, Map<IBorderItemEditPart, Rectangle> updatedBounds) {
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
					int oldY = 0;
					int oldHeight = 0;
					if(!updatedBounds.containsKey(timePart) || updatedBounds.get(timePart) == null) {
						// consult old figure
						oldY = timePart.getFigure().getBounds().getLocation().y - parentFigure.getBounds().getLocation().y;
						oldHeight = timePart.getFigure().getSize().height;
					} else {
						// take updated bounds rather than obsolete information
						oldY = updatedBounds.get(timePart).y;
						oldHeight = updatedBounds.get(timePart).height;
					}
					// Compute new bounds of the time element
					Rectangle newBounds = null;
					if(position == PositionConstants.CENTER) {
						newBounds = new Rectangle(referencePoint.x, referencePoint.y - oldHeight / 2, -1, oldHeight);
					} else if(position == PositionConstants.TOP || position == PositionConstants.BOTTOM) {
						int top = oldY;
						int bottom = oldY + oldHeight;
						EObject timeElement = timePart.resolveSemanticElement();
						if(!updatedBounds.containsKey(timePart) || updatedBounds.get(timePart) == null) {
							// bound is complex as it is based on two events. Recompute it in a better way
							if(timeElement instanceof DurationConstraint) {
								List<Element> contraineds = ((DurationConstraint)timeElement).getConstrainedElements();
								IFigure parentFig = lifelinePart.getFigure();
								if(contraineds.size() >= 2 && contraineds.get(0) instanceof OccurrenceSpecification && contraineds.get(1) instanceof OccurrenceSpecification) {
									OccurrenceSpecification event1 = (OccurrenceSpecification)contraineds.get(0);
									OccurrenceSpecification event2 = (OccurrenceSpecification)contraineds.get(1);
									Point loc1 = findLocationOfEvent(lifelinePart, event1);
									parentFig.translateToRelative(loc1);
									loc1.translate(parentFig.getBounds().getLocation().getNegated());
									Point loc2 = findLocationOfEvent(lifelinePart, event2);
									parentFig.translateToRelative(loc2);
									loc2.translate(parentFig.getBounds().getLocation().getNegated());
									top = Math.min(loc1.y, loc2.y);
									bottom = Math.max(loc1.y, loc2.y);
								}
							}
						}
						if(position == PositionConstants.TOP) {
							top = referencePoint.y;
						} else {
							bottom = referencePoint.y;
						}
						newBounds = new Rectangle(referencePoint.x, Math.min(top, bottom), -1, Math.abs(bottom - top));
					}
					if(newBounds != null) {
						updatedBounds.put(timePart, newBounds);
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
			if(message == null) {
				return null;
			}
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
			if(execution == null) {
				return null;
			}
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
		} else {
			// get parts representing the destruction event linked with the event
			for(Object lifelineChild : lifelinePart.getChildren()) {
				if(lifelineChild instanceof DestructionEventEditPart) {
					EObject destr = ((DestructionEventEditPart)lifelineChild).resolveSemanticElement();
					if(destr instanceof DestructionEvent && destr.equals(event.getEvent())) {
						return (EditPart)lifelineChild;
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
		MessageEnd messageStart = message.getSendEvent();
		if(messageStart != null){
			if(!(messageStart instanceof Gate && messageStart.eContainer() instanceof InteractionUse)) {
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(messageStart, false)));
				// delete linked time elements
				List<TimeObservation> timeObs = TimeObservationHelper.getTimeObservations(messageStart);
				List<TimeConstraint> timeCst = TimeConstraintHelper.getTimeConstraintsOn(messageStart);
				List<DurationObservation> durObs = DurationObservationHelper.getDurationObservationsOn(messageStart);
				List<DurationConstraint> durCst = DurationConstraintHelper.getDurationConstraintsOn(messageStart);
				List<NamedElement> timeElements = new ArrayList<NamedElement>(timeObs.size() + durObs.size() + timeCst.size() + durCst.size());
				timeElements.addAll(timeObs);
				timeElements.addAll(timeCst);
				timeElements.addAll(durObs);
				timeElements.addAll(durCst);
				for(NamedElement elt : timeElements) {
					cmd.add(new DestroyElementCommand(new DestroyElementRequest(elt, false)));
				}
			}
		}

		MessageEnd messageEnd = message.getReceiveEvent();
		if(messageEnd != null){
			if(!(messageEnd instanceof Gate && messageEnd.eContainer() instanceof InteractionUse)) {
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(messageEnd, false)));
				// delete linked time elements
				List<TimeObservation> timeObs = TimeObservationHelper.getTimeObservations(messageEnd);
				List<TimeConstraint> timeCst = TimeConstraintHelper.getTimeConstraintsOn(messageEnd);
				List<DurationObservation> durObs = DurationObservationHelper.getDurationObservationsOn(messageEnd);
				List<DurationConstraint> durCst = DurationConstraintHelper.getDurationConstraintsOn(messageEnd);
				List<NamedElement> timeElements = new ArrayList<NamedElement>(timeObs.size() + durObs.size() + timeCst.size() + durCst.size());
				timeElements.addAll(timeObs);
				timeElements.addAll(timeCst);
				timeElements.addAll(durObs);
				timeElements.addAll(durCst);
				for(NamedElement elt : timeElements) {
					cmd.add(new DestroyElementCommand(new DestroyElementRequest(elt, false)));
				}
			}
		}
		return cmd;
	}

	/**
	 * Complete an ICommand which destroys a Message element to also destroy dependent message ends and time/duration constraint/observation linked
	 * with these ends
	 * 
	 * @param cmd
	 *        the command to complete
	 * @param messagePart
	 *        the message edit part on which the request is called
	 * @return the deletion ICommand cmd for convenience
	 */
	public static ICommand completeDestroyMessageCommand(CompositeTransactionalCommand cmd, EditPart messagePart) {
		Object model = messagePart.getModel();
		if(model instanceof Edge) {
			EObject obj = ((Edge)model).getElement();

			if(obj instanceof Message) {
				Message message = (Message)obj;
				return completeDestroyMessageCommand(message, cmd);
			}
		}
		return cmd;
	}

	/**
	 * Complete an ICommand which destroys an ExecutionSpecification element to also destroy dependent finish and start events and time/duration
	 * constraint/observation linked with these ends
	 * 
	 * @param cmd
	 *        the command to complete
	 * @param req
	 *        the request to destroy the element
	 * @param editingDomain
	 *        the editing domain
	 * @param executionPart
	 *        the execution specification edit part on which the request is called
	 * @return the deletion ICommand cmd for convenience
	 */
	public static ICommand completeDestroyExecutionSpecificationCommand(CompositeTransactionalCommand cmd, DestroyElementRequest req, TransactionalEditingDomain editingDomain, EditPart executionPart) {
		Object model = executionPart.getModel();
		if(model instanceof Node) {
			EObject obj = ((Node)model).getElement();

			if(obj instanceof ExecutionSpecification) {
				ExecutionSpecification execution = (ExecutionSpecification)obj;

				OccurrenceSpecification start = execution.getStart();
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(start, false)));
				// delete linked time elements
				List<TimeObservation> timeObs = TimeObservationHelper.getTimeObservations(start);
				List<TimeConstraint> timeCst = TimeConstraintHelper.getTimeConstraintsOn(start);
				List<DurationObservation> durObs = DurationObservationHelper.getDurationObservationsOn(start);
				List<DurationConstraint> durCst = DurationConstraintHelper.getDurationConstraintsOn(start);
				List<NamedElement> timeElements = new ArrayList<NamedElement>(timeObs.size() + durObs.size() + timeCst.size() + durCst.size());
				timeElements.addAll(timeObs);
				timeElements.addAll(timeCst);
				timeElements.addAll(durObs);
				timeElements.addAll(durCst);
				for(NamedElement elt : timeElements) {
					cmd.add(new DestroyElementCommand(new DestroyElementRequest(elt, false)));
				}

				OccurrenceSpecification finish = execution.getFinish();
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(finish, false)));
				// delete linked time elements
				timeObs = TimeObservationHelper.getTimeObservations(finish);
				timeCst = TimeConstraintHelper.getTimeConstraintsOn(finish);
				durObs = DurationObservationHelper.getDurationObservationsOn(finish);
				durCst = DurationConstraintHelper.getDurationConstraintsOn(finish);
				timeElements = new ArrayList<NamedElement>(timeObs.size() + durObs.size() + timeCst.size() + durCst.size());
				timeElements.addAll(timeObs);
				timeElements.addAll(timeCst);
				timeElements.addAll(durObs);
				timeElements.addAll(durCst);
				for(NamedElement elt : timeElements) {
					cmd.add(new DestroyElementCommand(new DestroyElementRequest(elt, false)));
				}
			}
		}
		return cmd;
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
				LifelineEditPart lifelinePart = getParentLifelinePart(executionPart);
				if(lifelinePart != null) {
					for(Object lifelineChild : lifelinePart.getChildren()) {
						if(lifelineChild instanceof IBorderItemEditPart) {
							final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
							OccurrenceSpecification start = execution.getStart();
							OccurrenceSpecification finish = execution.getStart();
							int positionForStart = positionWhereEventIsLinkedToPart(start, timePart);
							int positionForFinish = positionWhereEventIsLinkedToPart(finish, timePart);
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
				LifelineEditPart srcLifelinePart = getParentLifelinePart(((ConnectionNodeEditPart)messagePart).getSource());
				LifelineEditPart tgtLifelinePart = getParentLifelinePart(((ConnectionNodeEditPart)messagePart).getTarget());
				MessageEnd send = message.getSendEvent();
				MessageEnd receive = message.getReceiveEvent();
				if(srcLifelinePart != null && send instanceof OccurrenceSpecification) {
					for(Object lifelineChild : srcLifelinePart.getChildren()) {
						if(lifelineChild instanceof IBorderItemEditPart) {
							final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
							int positionForEvent = positionWhereEventIsLinkedToPart((OccurrenceSpecification)send, timePart);
							if(positionForEvent != PositionConstants.NONE) {
								// time part is linked, delete the view
								Command deleteTimeViewCommand = new ICommandProxy(new DeleteCommand(editingDomain, (View)timePart.getModel()));
								deleteViewsCmd.add(deleteTimeViewCommand);
							}
						}
					}
				}
				if(tgtLifelinePart != null && receive instanceof OccurrenceSpecification) {
					for(Object lifelineChild : tgtLifelinePart.getChildren()) {
						if(lifelineChild instanceof IBorderItemEditPart) {
							final IBorderItemEditPart timePart = (IBorderItemEditPart)lifelineChild;
							int positionForEvent = positionWhereEventIsLinkedToPart((OccurrenceSpecification)receive, timePart);
							if(positionForEvent != PositionConstants.NONE) {
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
				LifelineEditPart lifelinePart = getParentLifelinePart(destructionEventPart);
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
	 * Get the object safely casted as a list of OccurrenceSpecification
	 * 
	 * @param occurrenceSpecificationList
	 *        the object which is supposed to be a list of OccurrenceSpecification
	 */
	public static List<OccurrenceSpecification> getAsOccSpecList(Object occurrenceSpecificationList) {
		if(occurrenceSpecificationList instanceof List<?>) {
			List<?> list = (List<?>)occurrenceSpecificationList;
			if(!list.isEmpty()) {
				List<OccurrenceSpecification> newList = new ArrayList<OccurrenceSpecification>(list.size());
				for(Object elt : list) {
					if(elt instanceof OccurrenceSpecification) {
						newList.add((OccurrenceSpecification)elt);
					}
				}
				return newList;
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Get the pair of OccurrenceSpecification which a duration constraint or observation should be created between
	 * 
	 * @param occ1List
	 *        the list of occurrences at the same time, among which the first one must be chosen
	 * @param occ2List
	 *        the list of occurrences at the same time, among which the second one must be chosen
	 * @return size two array of OccurrenceSpecification which can be linked or null
	 */
	public static OccurrenceSpecification[] getPairOfCorrespondingOccSpec(List<OccurrenceSpecification> occ1List, List<OccurrenceSpecification> occ2List) {
		// check for occurrences linked by a message
		for(OccurrenceSpecification occ1 : occ1List) {
			for(OccurrenceSpecification occ2 : occ2List) {
				if(DurationConstraintHelper.endsOfSameMessage(occ1, occ2)) {
					// we must link occurrences of a message
					return new OccurrenceSpecification[]{ occ1, occ2 };
				}
			}
		}
		// check for occurrences on a same lifeline
		for(OccurrenceSpecification occ1 : occ1List) {
			if(occ1 instanceof MessageOccurrenceSpecification) {
				Message mess = ((MessageOccurrenceSpecification)occ1).getMessage();
				if(mess.getReceiveEvent().equals(occ1) && MessageSort.SYNCH_CALL_LITERAL.equals(mess.getMessageSort())) {
					// filter receive event, we prefer the corresponding start event at the same location
					continue;
				}
			}
			for(OccurrenceSpecification occ2 : occ2List) {
				if(occ2 instanceof MessageOccurrenceSpecification) {
					Message mess = ((MessageOccurrenceSpecification)occ2).getMessage();
					if(mess.getReceiveEvent().equals(occ2) && MessageSort.SYNCH_CALL_LITERAL.equals(mess.getMessageSort())) {
						// filter receive event, we prefer the corresponding start event at the same location
						continue;
					}
				}
				if(DurationConstraintHelper.coversSameLifeline(occ1, occ2)) {
					// we must link occurrences on a same lifeline
					return new OccurrenceSpecification[]{ occ1, occ2 };
				}
			}
		}
		return null;
	}
}
