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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DestructionEventEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.CombinedFragment;
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
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;


public class SequenceUtil {

	private static final double MAXIMAL_DISTANCE_FROM_EVENT = 10;

	/**
	 * Title for dialog of block message sort modification error
	 */
	private static final String BLOCK_SORT_MODIFICATION_TITLE = "Forbidden action"; //$NON-NLS-1$

	/**
	 * Message for dialog of block message sort modification error
	 */
	private static final String BLOCK_SORT_MODIFICATION_MSG = "It's impossible to change the message sort."; //$NON-NLS-1$

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

		HashSet<IFigure> exclusionSet = new HashSet<IFigure>();

		InteractionFragment interactionFragment = null;

		EditPart ep = host.getRoot().getViewer().findObjectAtExcluding(location, exclusionSet);

		while(interactionFragment == null && ep != null) {
			if(ep.getModel() instanceof View) {
				EObject eObject = ViewUtil.resolveSemanticElement((View)ep.getModel());
				if(eObject instanceof Interaction || eObject instanceof InteractionOperand) {
					interactionFragment = (InteractionFragment)eObject;
				}
			}

			if(ep instanceof org.eclipse.gef.GraphicalEditPart) {
				exclusionSet.add(((org.eclipse.gef.GraphicalEditPart)ep).getFigure());
				ep = host.getRoot().getViewer().findObjectAtExcluding(location, exclusionSet);
			} else {
				// we can't add the figure to the exclusion set so stop the while to avoid an infinite loop
				ep = null;
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
		IFigure lifelineFigure = lifelinePart.getFigure();
		lifelineFigure.translateToRelative(referencePoint);
		referencePoint.translate(lifelineFigure.getBounds().getLocation().getCopy().negate());
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
						oldY = timePart.getFigure().getBounds().getLocation().y - lifelineFigure.getBounds().getLocation().y;
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
					} else {
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
							newBounds = new Rectangle(referencePoint.x, referencePoint.y, -1, Math.abs(bottom - referencePoint.y));
						} else {
							newBounds = new Rectangle(referencePoint.x, top, -1, Math.abs(referencePoint.y - top));
						}

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

		// refresh layout commands :
		// one before the commands for the undo and one after for classic execution
		if(!command.isEmpty() && lifelineFigure instanceof BorderedNodeFigure) {
			Command relayout = getReLayoutCmd((BorderedNodeFigure)lifelineFigure, false);
			Command relayoutUndo = getReLayoutCmd((BorderedNodeFigure)lifelineFigure, true);
			if(relayout != null && relayoutUndo != null) {
				CompoundCommand commandWithRelayout = new CompoundCommand();
				commandWithRelayout.add(relayoutUndo);
				commandWithRelayout.add(command);
				commandWithRelayout.add(relayout);
				return commandWithRelayout;
			}
		}
		return null;
	}

	/**
	 * Get a command which refreshes the bordered layout of the node.
	 * 
	 * @param node
	 *        the node figure with bordered items
	 * @param onUndo
	 *        if true the relayout will be done on undo only, if false it will be done on classic execute only
	 * @return the refresh command
	 */
	public static Command getReLayoutCmd(BorderedNodeFigure node, boolean onUndo) {
		// relayout the border container figure so that time elements are refreshed
		final IFigure container = node.getBorderItemContainer();

		if(onUndo) {
			return new Command() {

				@Override
				public void undo() {
					container.getLayoutManager().layout(container);
				}
			};
		} else {
			return new Command() {

				@Override
				public void execute() {
					container.getLayoutManager().layout(container);
				}
			};
		}
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
						LifelineEditPart parentLifeline = getParentLifelinePart(lifelineChild);
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
					LifelineEditPart parentLifeline = getParentLifelinePart(lifelineChild);
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

	public static List<Element> getCombinedFragmentAssociatedElement(CombinedFragment cf) {
		List<Element> elements = new LinkedList<Element>();

		for(InteractionOperand operand : cf.getOperands()) {
			// Add all elements related to this operand
			elements.addAll(getInteractionOperandAssociatedElement(operand));
			// Add this operand
			elements.add(operand);
		}
		return elements;

	}

	public static List<Element> getInteractionOperandAssociatedElement(InteractionOperand interactionOperand) {
		List<Element> elements = new LinkedList<Element>();
		for(InteractionFragment itf : interactionOperand.getFragments()) {
			if(itf instanceof CombinedFragment) {
				// add the combinedFragment
				elements.addAll(getCombinedFragmentAssociatedElement((CombinedFragment)itf));
			}
			elements.add(itf);
			if(itf instanceof MessageOccurrenceSpecification) {
				MessageOccurrenceSpecification mos = (MessageOccurrenceSpecification)itf;
				if(mos.getMessage() != null) {
					elements.add(mos.getMessage());
				}
			}
		}
		return elements;
	}

	public static void handleMessageSortChange(EditingDomain editingDomain, Notification notification, Message message, MessageSort expectedMessageSort) {
		Object feature = notification.getFeature();

		if(UMLPackage.eINSTANCE.getMessage_MessageSort().equals(feature) && !expectedMessageSort.equals(notification.getNewValue())) {
			Object oldValue = notification.getOldValue();
			if(oldValue instanceof MessageSort) {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), BLOCK_SORT_MODIFICATION_TITLE, BLOCK_SORT_MODIFICATION_MSG);
				CommandHelper.executeCommandWithoutHistory(editingDomain, SetCommand.create(editingDomain, message, feature, notification.getOldValue()));
				return;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static Set<Lifeline> getCoveredLifelines(Rectangle selectionRect, EditPart hostEditPart) {
		Set<Lifeline> coveredLifelines = new HashSet<Lifeline>();

		// retrieve all the edit parts in the registry
		Set<Entry<Object, EditPart>> allEditPartEntries = hostEditPart.getViewer().getEditPartRegistry().entrySet();
		for(Entry<Object, EditPart> epEntry : allEditPartEntries) {
			EditPart ep = epEntry.getValue();

			if(ep instanceof ShapeEditPart) {
				ShapeEditPart sep = (ShapeEditPart)ep;
				EObject elem = sep.getNotationView().getElement();

				if(elem instanceof Lifeline) {
					IFigure figure = sep.getFigure();

					Rectangle figureBounds = figure.getBounds().getCopy();
					figure.getParent().translateToAbsolute(figureBounds);

					if(selectionRect.intersects(figureBounds)) {
						coveredLifelines.add((Lifeline)elem);
					}
				}
			}
		}
		return coveredLifelines;
	}

	/**
	 * retrieve all the interaction fragments and their related ift at least partially covered by the rectangle, including sub ift like
	 * interaction operands in combined fragment.
	 * 
	 * @param selectionRect
	 *        the rectangle where to look for ift.
	 * @param hostEditPart
	 *        the host edit part used to retrieve all the edit parts in the registry.
	 * @param coveredRatio
	 *        the minimum covering ratio of a figure to be included in the set.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Set<InteractionFragment> getCoveredInteractionFragments(Rectangle selectionRect, EditPart hostEditPart) {
		Set<InteractionFragment> coveredInteractionFragments = new HashSet<InteractionFragment>();

		// retrieve all the edit parts in the registry
		Set<Entry<Object, EditPart>> allEditPartEntries = hostEditPart.getViewer().getEditPartRegistry().entrySet();
		for(Entry<Object, EditPart> epEntry : allEditPartEntries) {
			EditPart ep = epEntry.getValue();

			if(ep instanceof ShapeEditPart) {
				ShapeEditPart sep = (ShapeEditPart)ep;
				EObject elem = sep.getNotationView().getElement();

				if(elem instanceof InteractionFragment) {
					IFigure figure = sep.getFigure();

					Rectangle figureBounds = figure.getBounds().getCopy();
					figure.getParent().translateToAbsolute(figureBounds);

					if(selectionRect.contains(figureBounds)) {
						addInteractionFragmentAndRelatedToSet((InteractionFragment)elem, coveredInteractionFragments);
					}
				}

			} else if(ep instanceof ConnectionEditPart) {
				ConnectionEditPart cep = (ConnectionEditPart)ep;
				EObject elem = cep.getNotationView().getElement();

				// for connections, messages have ends that are ift but don't have theirs own edit parts
				// => use anchors to determine if they should be included in the set
				if(elem instanceof Message) {
					Message msg = (Message)elem;
					Connection msgFigure = cep.getConnectionFigure();

					Point sourcePoint = msgFigure.getSourceAnchor().getReferencePoint();
					sourcePoint = msgFigure.getSourceAnchor().getLocation(sourcePoint);
					Point targetPoint = msgFigure.getTargetAnchor().getReferencePoint();
					targetPoint = msgFigure.getTargetAnchor().getLocation(targetPoint);

					if(selectionRect.contains(sourcePoint)) {
						MessageEnd msgSendEnd = msg.getSendEvent();
						if(msgSendEnd instanceof InteractionFragment) {
							addInteractionFragmentAndRelatedToSet((InteractionFragment)msgSendEnd, coveredInteractionFragments);
						}
					}
					if(selectionRect.contains(targetPoint)) {
						MessageEnd msgReceiveEnd = msg.getReceiveEvent();
						if(msgReceiveEnd instanceof InteractionFragment) {
							addInteractionFragmentAndRelatedToSet((InteractionFragment)msgReceiveEnd, coveredInteractionFragments);
						}
					}
				}
			}
		}
		return coveredInteractionFragments;
	}

	/**
	 * add the interaction fragment and its related ifts to the set.
	 * 
	 * @param ift
	 * @param iftSet
	 */
	public static void addInteractionFragmentAndRelatedToSet(InteractionFragment ift, Set<InteractionFragment> iftSet) {
		boolean result = iftSet.add(ift);
		// don't process again if it is already inside the set to avoid infinite loop
		// between cross referenced objects
		if(result) {
			if(ift instanceof ExecutionSpecification) {
				// include both ends of an execution specification in the set
				ExecutionSpecification es = ((ExecutionSpecification)ift);
				addInteractionFragmentAndRelatedToSet(es.getStart(), iftSet);
				addInteractionFragmentAndRelatedToSet(es.getFinish(), iftSet);
			} else if(ift instanceof ExecutionOccurrenceSpecification) {
				// include the execution specification associated with the occurence
				ExecutionOccurrenceSpecification eos = (ExecutionOccurrenceSpecification)ift;
				addInteractionFragmentAndRelatedToSet(eos.getExecution(), iftSet);
			}
		}
	}

	/**
	 * return a command to set the enclosing operand of an interaction fragment.
	 * 
	 * @param ed
	 *        The transactional editing domain.
	 * @param ift
	 *        The interaction fragment.
	 * @param io
	 *        the new enclosing interaction operand.
	 * @return The command.
	 */
	public static ICommand getSetEnclosingOperandCommand(final TransactionalEditingDomain ed, final InteractionFragment ift, final InteractionOperand io) {
		return new AbstractTransactionalCommand(ed, "Set enclosing operand command", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				ift.setEnclosingInteraction(null);
				ift.setEnclosingOperand(io);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/**
	 * return a command to set the enclosing interaction of an interaction fragment.
	 * 
	 * @param ed
	 *        The transactional editing domain.
	 * @param ift
	 *        The interaction fragment.
	 * @param io
	 *        the new enclosing interaction.
	 * @return The command.
	 */
	public static ICommand getSetEnclosingInteractionCommand(final TransactionalEditingDomain ed, final InteractionFragment ift, final Interaction i) {
		return new AbstractTransactionalCommand(ed, "Set enclosing interaction command", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				ift.setEnclosingOperand(null);
				ift.setEnclosingInteraction(i);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/**
	 * return a command to add a covered lifeline to an interaction fragment.
	 * 
	 * @param ed
	 *        The transactional editing domain.
	 * @param ift
	 *        The interaction fragment.
	 * @param lifeline
	 *        the lifeline.
	 * @return The command.
	 */
	public static ICommand getAddCoveredLifelineCommand(final TransactionalEditingDomain ed, final InteractionFragment ift, final Lifeline lifeline) {
		return new AbstractTransactionalCommand(ed, "Add covered lifeline command", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				ift.getCovereds().add(lifeline);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/**
	 * return a command to remove a previously covered lifeline of an interaction fragment.
	 * 
	 * @param ed
	 *        The transactional editing domain.
	 * @param ift
	 *        The interaction fragment.
	 * @param lifeline
	 *        the lifeline.
	 * @return The command.
	 */
	public static ICommand getRemoveCoveredLifelineCommand(final TransactionalEditingDomain ed, final InteractionFragment ift, final Lifeline lifeline) {
		return new AbstractTransactionalCommand(ed, "Add covered lifeline command", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				ift.getCovereds().remove(lifeline);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/**
	 * Create a command to update the enclosing interaction of an interaction fragment according to its new bounds.
	 * 
	 * @param interactionFragmentEP
	 *        the edit part of the interaction fragment
	 * @param absoluteNewBounds
	 *        the new absolute bounds
	 * @return the command or null if nothing changes
	 */
	@SuppressWarnings("unchecked")
	public static Command createUpdateEnclosingInteractionCommand(ShapeNodeEditPart interactionFragmentEP, Rectangle absoluteNewBounds) {

		EObject interaction = null;
		int area = Integer.MAX_VALUE;

		// retrieve all the edit parts in the registry
		Set<Entry<Object, EditPart>> allEditPartEntries = interactionFragmentEP.getViewer().getEditPartRegistry().entrySet();
		for(Entry<Object, EditPart> epEntry : allEditPartEntries) {
			EditPart ep = epEntry.getValue();

			if(ep instanceof ShapeEditPart) {
				ShapeEditPart sep = (ShapeEditPart)ep;
				EObject elem = sep.getNotationView().getElement();

				if(elem instanceof InteractionOperand || elem instanceof Interaction) {
					Rectangle interactionBounds = new Rectangle(sep.getLocation(), sep.getSize());
					sep.getFigure().getParent().translateToAbsolute(interactionBounds);

					if(interactionBounds.contains(absoluteNewBounds)) {
						int interactionArea = interactionBounds.height * interactionBounds.width;
						// keep the covered interaction if it is smaller than the previous
						if(interactionArea < area) {
							area = interactionArea;
							interaction = elem;
						}
					}
				}
			}
		}

		Set<InteractionFragment> iftAndRelated = new HashSet<InteractionFragment>();

		// add related ift like start and end of an execution specification
		addInteractionFragmentAndRelatedToSet((InteractionFragment)interactionFragmentEP.resolveSemanticElement(), iftAndRelated);

		CompoundCommand cmd = new CompoundCommand();

		if(interaction instanceof Interaction) {
			for(InteractionFragment ift : iftAndRelated) {
				cmd.add(new ICommandProxy(SequenceUtil.getSetEnclosingInteractionCommand(interactionFragmentEP.getEditingDomain(), ift, (Interaction)interaction)));
			}
		} else if(interaction instanceof InteractionOperand) {
			for(InteractionFragment ift : iftAndRelated) {
				cmd.add(new ICommandProxy(SequenceUtil.getSetEnclosingOperandCommand(interactionFragmentEP.getEditingDomain(), ift, (InteractionOperand)interaction)));
			}
		}

		if(!cmd.isEmpty()) {
			return cmd;
		} else {
			return null;
		}
	}
}
