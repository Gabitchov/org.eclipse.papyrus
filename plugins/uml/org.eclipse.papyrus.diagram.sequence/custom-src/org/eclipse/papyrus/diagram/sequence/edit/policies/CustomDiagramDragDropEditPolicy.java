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
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.command.wrappers.CommandProxyWithResult;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.DurationObservationHelper;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.sequence.command.CreateLocatedConnectionViewCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DestructionEventEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.SequenceLinkMappingHelper;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * A policy to support dNd from the Model Explorer in the sequence diagram
 * 
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	public CustomDiagramDragDropEditPolicy() {
		super(SequenceLinkMappingHelper.getInstance());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> elementsVisualId = new HashSet<Integer>();
		elementsVisualId.add(BehaviorExecutionSpecificationEditPart.VISUAL_ID);
		elementsVisualId.add(ActionExecutionSpecificationEditPart.VISUAL_ID);
		elementsVisualId.add(MessageEditPart.VISUAL_ID);
		elementsVisualId.add(Message2EditPart.VISUAL_ID);
		elementsVisualId.add(Message3EditPart.VISUAL_ID);
		elementsVisualId.add(Message4EditPart.VISUAL_ID);
		elementsVisualId.add(Message4EditPart.VISUAL_ID);
		elementsVisualId.add(Message5EditPart.VISUAL_ID);
		elementsVisualId.add(Message6EditPart.VISUAL_ID);
		elementsVisualId.add(Message7EditPart.VISUAL_ID);
		elementsVisualId.add(Message6EditPart.VISUAL_ID);
		elementsVisualId.add(GeneralOrderingEditPart.VISUAL_ID);
		elementsVisualId.add(DestructionEventEditPart.VISUAL_ID);
		elementsVisualId.add(StateInvariantEditPart.VISUAL_ID);
		elementsVisualId.add(TimeConstraintEditPart.VISUAL_ID);
		elementsVisualId.add(DurationConstraintEditPart.VISUAL_ID);
		elementsVisualId.add(DurationConstraintInMessageEditPart.VISUAL_ID);
		elementsVisualId.add(TimeObservationEditPart.VISUAL_ID);
		elementsVisualId.add(DurationObservationEditPart.VISUAL_ID);
		elementsVisualId.add(LifelineEditPart.VISUAL_ID);
		// handle nodes on messages (no visual ID detected for them)
		elementsVisualId.add(-1);
		return elementsVisualId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		Point location = dropRequest.getLocation().getCopy();

		// handle specifically the case when node is on a message
		Command cmd = handleNodeOnMessage(semanticLink, nodeVISUALID, linkVISUALID);
		if(cmd != null) {
			return cmd;
		}

		if(nodeVISUALID != -1) {
			switch(nodeVISUALID) {
			case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			case ActionExecutionSpecificationEditPart.VISUAL_ID:
				return dropExecutionSpecification((ExecutionSpecification)semanticLink, nodeVISUALID, location);
			case DestructionEventEditPart.VISUAL_ID:
				return dropDestructionEvent((DestructionEvent)semanticLink, nodeVISUALID, location);
			case StateInvariantEditPart.VISUAL_ID:
				return dropStateInvariant((StateInvariant)semanticLink, nodeVISUALID, location);
			case TimeConstraintEditPart.VISUAL_ID:
			case DurationConstraintEditPart.VISUAL_ID:
				return dropIntervalConstraintInLifeline((IntervalConstraint)semanticLink, nodeVISUALID);
			case TimeObservationEditPart.VISUAL_ID:
				return dropTimeObservationInLifeline((TimeObservation)semanticLink, nodeVISUALID);
			case LifelineEditPart.VISUAL_ID:
				return dropLifeline((Lifeline)semanticLink, nodeVISUALID, location);
			default:
				return UnexecutableCommand.INSTANCE;
			}
		}

		if(linkVISUALID != -1) {
			switch(linkVISUALID) {
			case MessageEditPart.VISUAL_ID:
			case Message2EditPart.VISUAL_ID:
			case Message3EditPart.VISUAL_ID:
			case Message4EditPart.VISUAL_ID:
			case Message5EditPart.VISUAL_ID:
			case Message6EditPart.VISUAL_ID:
			case Message7EditPart.VISUAL_ID:
				return dropMessage(dropRequest, semanticLink, linkVISUALID);
			case GeneralOrderingEditPart.VISUAL_ID:
				return dropGeneralOrdering(dropRequest, semanticLink, linkVISUALID);
			default:
				return UnexecutableCommand.INSTANCE;
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get the drop command for the lifeline
	 * 
	 * @param lifeline
	 *        the lifeline
	 * @param nodeVISUALID
	 *        the node visual id
	 * @return the drop command if the lifeline can be dropped
	 */
	private Command dropLifeline(Lifeline lifeline, int nodeVISUALID, Point location) {
		if(getHostObject().equals(lifeline.getOwner())) {
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, lifeline));
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get the drop command in case the element can be handled as a node on a message
	 * 
	 * @param semanticElement
	 *        the element being dropped from the model
	 * @param nodeVISUALID
	 *        node visual id or -1
	 * @param linkVISUALID
	 *        link visual id or -1
	 * @return the drop command if the element can be dropped as a message label node, or null otherwise
	 */
	private Command handleNodeOnMessage(Element semanticElement, int nodeVISUALID, int linkVISUALID) {

		if(nodeVISUALID == -1 && linkVISUALID == -1) {
			// detect duration observation on a message
			if(semanticElement instanceof DurationObservation) {
				List<NamedElement> events = ((DurationObservation)semanticElement).getEvents();
				if(events.size() >= 2) {
					return dropMessageNodeBetweenEvents(semanticElement, events.get(0), events.get(1));
				}
			}
		}
		if(isDurationConstraintHint(nodeVISUALID, linkVISUALID)) {
			// detect duration constraint on a message
			if(semanticElement instanceof DurationConstraint) {
				List<Element> events = ((DurationConstraint)semanticElement).getConstrainedElements();
				if(events.size() >= 2) {
					return dropMessageNodeBetweenEvents(semanticElement, events.get(0), events.get(1));
				}
			}
		}
		return null;
	}

	/**
	 * Get the command to drop an element between two events in order to create a message label
	 * 
	 * @param droppedElement
	 *        the dropped element
	 * @param event1
	 *        first event (of type MessageOccurrenceSpecification)
	 * @param event2
	 *        second event (of type MessageOccurrenceSpecification)
	 * @param element
	 * @return the command or false if the elements can not be dropped as message label
	 */
	private Command dropMessageNodeBetweenEvents(Element droppedElement, Element event1, Element event2) {
		if(event1 instanceof MessageOccurrenceSpecification && event2 instanceof MessageOccurrenceSpecification) {
			if(!event1.equals(event2)) {
				boolean endsOfSameMessage = false;
				int visualId = -1;
				if(droppedElement instanceof DurationConstraint) {
					visualId = DurationConstraintInMessageEditPart.VISUAL_ID;
					endsOfSameMessage = DurationConstraintHelper.endsOfSameMessage((OccurrenceSpecification)event1, (OccurrenceSpecification)event2);
				} else if(droppedElement instanceof DurationObservation) {
					visualId = DurationObservationEditPart.VISUAL_ID;
					endsOfSameMessage = DurationObservationHelper.endsOfSameMessage((OccurrenceSpecification)event1, (OccurrenceSpecification)event2);
				}
				if(endsOfSameMessage) {
					Message message = ((MessageOccurrenceSpecification)event1).getMessage();
					// search a connection which matches the possessing message
					DiagramEditPart diag = DiagramEditPartsUtil.getDiagramEditPart(getHost());
					for(Object conn : diag.getConnections()) {
						if(conn instanceof ConnectionNodeEditPart) {
							EObject connElt = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
							if(message.equals(connElt)) {
								// check that node isn't already represented, or dropping is impossible
								for(Object child : ((ConnectionNodeEditPart)conn).getChildren()) {
									if(child instanceof GraphicalEditPart) {
										EObject childElt = ((GraphicalEditPart)child).resolveSemanticElement();
										if(droppedElement.equals(childElt)) {
											return null;
										}
									}
								}
								return dropNodeOnMessage((PackageableElement)droppedElement, (ConnectionNodeEditPart)conn, visualId);
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Test whether visual ids are compatible with a duration constraint element
	 * 
	 * @param nodeVISUALID
	 *        the detected node visual id
	 * @param linkVISUALID
	 *        the detected link visual id
	 * @return true if element may be a duration constraint
	 */
	private boolean isDurationConstraintHint(int nodeVISUALID, int linkVISUALID) {
		if(linkVISUALID != -1) {
			return false;
		} else {
			return nodeVISUALID == -1 || nodeVISUALID == ConstraintEditPart.VISUAL_ID || nodeVISUALID == DurationConstraintEditPart.VISUAL_ID || nodeVISUALID == DurationConstraintInMessageEditPart.VISUAL_ID;
		}
	}

	/**
	 * Drop a duration observation or a duration constraint on a message edit part
	 * 
	 * @param durationLabelElement
	 *        the duration observation or duration constraint to display as message label
	 * @param messageEditPart
	 *        the containing message edit part
	 * @param nodeVISUALID
	 *        the label node visual id
	 * @return the command or UnexecutableCommand
	 */
	private Command dropNodeOnMessage(PackageableElement durationLabelElement, ConnectionNodeEditPart messageEditPart, int nodeVISUALID) {
		IAdaptable elementAdapter = new EObjectAdapter(durationLabelElement);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());
		return messageEditPart.getCommand(new CreateViewRequest(descriptor));
	}

	/**
	 * Drop a time observation on a lifeline.
	 * 
	 * @param observation
	 *        the time constraint
	 * @param nodeVISUALID
	 *        the node visual id
	 * @return the command if the lifeline is the correct one or UnexecutableCommand
	 */
	private Command dropTimeObservationInLifeline(TimeObservation observation, int nodeVISUALID) {
		CompoundCommand cc = new CompoundCommand("Drop");
		IAdaptable elementAdapter = new EObjectAdapter(observation);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());
		cc.add(getHost().getCommand(new CreateViewRequest(descriptor)));

		LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(getHost());
		if(lifelinePart != null) {
			NamedElement occ1 = observation.getEvent();
			if(occ1 instanceof OccurrenceSpecification) {
				Point middlePoint = SequenceUtil.findLocationOfEvent(lifelinePart, (OccurrenceSpecification)occ1);
				if(middlePoint != null) {
					int height = getDefaultDropHeight(nodeVISUALID);
					Point startPoint = middlePoint.getCopy();
					if(height > 0) {
						startPoint.translate(0, -height / 2);
					}
					Rectangle newBounds = new Rectangle(startPoint, new Dimension(-1, height));
					lifelinePart.getFigure().translateToRelative(newBounds);
					Point parentLoc = lifelinePart.getLocation();
					newBounds.translate(parentLoc.getNegated());
					SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", descriptor, newBounds);
					cc.add(new ICommandProxy(setBoundsCommand));
					return cc;
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Drop an interval constraint (duration or time) on a lifeline.
	 * 
	 * @param constraint
	 *        the interval constraint
	 * @param nodeVISUALID
	 *        the node visual id
	 * @return the command if the lifeline is the correct one or UnexecutableCommand
	 */
	private Command dropIntervalConstraintInLifeline(IntervalConstraint constraint, int nodeVISUALID) {
		CompoundCommand cc = new CompoundCommand("Drop");
		IAdaptable elementAdapter = new EObjectAdapter(constraint);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());
		cc.add(getHost().getCommand(new CreateViewRequest(descriptor)));

		LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(getHost());
		if(lifelinePart != null && constraint.getConstrainedElements().size() >= 2) {
			Element occ1 = constraint.getConstrainedElements().get(0);
			Element occ2 = constraint.getConstrainedElements().get(1);
			if(occ1 instanceof OccurrenceSpecification && occ2 instanceof OccurrenceSpecification) {
				Point startPoint = SequenceUtil.findLocationOfEvent(lifelinePart, (OccurrenceSpecification)occ1);
				Point endPoint = SequenceUtil.findLocationOfEvent(lifelinePart, (OccurrenceSpecification)occ2);
				if(startPoint != null && endPoint != null) {
					int height = endPoint.y - startPoint.y;
					Rectangle newBounds = null;
					if(height < 0) {
						newBounds = new Rectangle(endPoint, new Dimension(-1, -height));
					} else {
						newBounds = new Rectangle(startPoint, new Dimension(-1, height));
					}
					lifelinePart.getFigure().translateToRelative(newBounds);
					Point parentLoc = lifelinePart.getLocation();
					newBounds.translate(parentLoc.getNegated());
					SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", descriptor, newBounds);
					cc.add(new ICommandProxy(setBoundsCommand));
					return cc;
				}
			}
		} else if(lifelinePart != null && constraint.getConstrainedElements().size() == 1) {
			Element occ1 = constraint.getConstrainedElements().get(0);
			if(occ1 instanceof OccurrenceSpecification) {
				Point middlePoint = SequenceUtil.findLocationOfEvent(lifelinePart, (OccurrenceSpecification)occ1);
				if(middlePoint != null) {
					int height = getDefaultDropHeight(nodeVISUALID);
					Point startPoint = middlePoint.getCopy();
					if(height > 0) {
						startPoint.translate(0, -height / 2);
					}
					Rectangle newBounds = new Rectangle(startPoint, new Dimension(-1, height));
					lifelinePart.getFigure().translateToRelative(newBounds);
					Point parentLoc = lifelinePart.getLocation();
					newBounds.translate(parentLoc.getNegated());
					SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", descriptor, newBounds);
					cc.add(new ICommandProxy(setBoundsCommand));
					return cc;
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get the default height to set to a drop object. This method is useful for dropped objects which must be positioned relatively to their center.
	 * 
	 * @param nodeVISUALID
	 *        the node visual id
	 * @return arbitrary default height for the node visual id (eventually -1)
	 */
	private int getDefaultDropHeight(int nodeVISUALID) {
		if(TimeConstraintEditPart.VISUAL_ID == nodeVISUALID || TimeObservationEditPart.VISUAL_ID == nodeVISUALID) {
			return 40;
		}
		return -1;
	}

	private Command dropStateInvariant(StateInvariant stateInvariant, int nodeVISUALID, Point location) {

		// an StateInvariant covereds systematically a unique lifeline
		Lifeline lifeline = stateInvariant.getCovereds().get(0);
		// Check that the container view is the view of the lifeline
		if(lifeline.equals(getHostObject())) {
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, stateInvariant));
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get lifelines element which contains these existingViews
	 * 
	 * @param existingViews
	 *        the existing views.
	 * @return the list of lifeline.
	 */
	private List<Lifeline> getLifelines(List<View> existingViews) {
		List<Lifeline> lifelines = new ArrayList<Lifeline>();
		for(View view : existingViews) {
			EObject eObject = ViewUtil.resolveSemanticElement((View)view.eContainer());
			if(eObject instanceof Lifeline) {
				lifelines.add((Lifeline)eObject);
			}
		}
		return lifelines;
	}

	/**
	 * Drop a destructionEvent on a lifeline
	 * 
	 * @param destructionEvent
	 *        the destructionEvent to drop
	 * @param nodeVISUALID
	 *        the node visualID
	 * @return the command to drop the destructionEvent on a lifeline if allowed.
	 */
	private Command dropDestructionEvent(DestructionEvent destructionEvent, int nodeVISUALID, Point location) {
		// Get all the view of this destructionEvent.
		List<View> existingViews = DiagramEditPartsUtil.findViews(destructionEvent, getViewer());
		// Get the lifelines containing the graphical destructionEvent
		List<Lifeline> lifelines = getLifelines(existingViews);

		// If the list of lifeline already containing the destructionEvent doesn't contain the lifeline targeted.
		if(!lifelines.contains(getHostObject())) {
			Lifeline lifeline = (Lifeline)getHostObject();
			for(InteractionFragment ift : lifeline.getCoveredBys()) {
				if(ift instanceof OccurrenceSpecification) {
					OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification)ift;
					// if the event of the occurrenceSpecification is the DestructionEvent, create the command
					if(destructionEvent.equals(occurrenceSpecification.getEvent())) {
						return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, destructionEvent));
					}
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get the command to drop an execution specification node
	 * 
	 * @param es
	 *        execution specification
	 * @param nodeVISUALID
	 *        the execution specification's visual id
	 * @param location
	 *        the location of the drop request
	 * @return the drop command
	 */
	private Command dropExecutionSpecification(ExecutionSpecification es, int nodeVISUALID, Point location) {
		List<View> existingViews = DiagramEditPartsUtil.findViews(es, getViewer());
		// only allow one view instance of a single element by diagram
		if(existingViews.isEmpty()) {
			// Find the lifeline of the ES
			if(es.getStart() != null && !es.getStart().getCovereds().isEmpty()) {
				// an Occurrence Specification covers systematically a unique lifeline
				Lifeline lifeline = es.getStart().getCovereds().get(0);
				// Check that the container view is the view of the lifeline
				if(lifeline.equals(getHostObject())) {
					//return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, es));


					IHintedType type = ((IHintedType)getUMLElementType(nodeVISUALID));

					String semanticHint = null;
					if(type != null) {
						semanticHint = type.getSemanticHint();
					}

					IAdaptable elementAdapter = new EObjectAdapter(es);

					ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, semanticHint, ViewUtil.APPEND, false, getDiagramPreferencesHint());
					CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
					// find best bounds
					Rectangle bounds = getExecutionSpecificationBounds(es);
					if(bounds != null) {
						createViewRequest.setLocation(bounds.getLocation());
						createViewRequest.setSize(bounds.getSize());
					} else {
						createViewRequest.setLocation(location);
					}

					// "ask" the host for a command associated with the CreateViewRequest
					Command command = getHost().getCommand(createViewRequest);
					// set the viewdescriptor as result
					// it then can be used as an adaptable to retrieve the View
					return new ICommandProxy(new CommandProxyWithResult(command, descriptor));
				}
			}
		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get the advised bounds to drop an execution specification
	 * 
	 * @param es
	 *        the dropped execution specification
	 * @return bounds of the es in absolute coordinates or null
	 */
	private Rectangle getExecutionSpecificationBounds(ExecutionSpecification es) {
		Point startLocation = null;
		Point finishLocation = null;
		Rectangle possibleStartLocations = null;
		Rectangle possibleFinishLocations = null;
		// end events of the link
		OccurrenceSpecification startEvent = es.getStart();
		OccurrenceSpecification finishEvent = es.getFinish();
		if(startEvent != null && finishEvent != null && getHost() instanceof LifelineEditPart) {
			LifelineEditPart hostLifeline = (LifelineEditPart)getHost();
			// find location constraints for source
			startLocation = SequenceUtil.findLocationOfEvent((LifelineEditPart)getHost(), startEvent);
			if(startLocation == null) {
				possibleStartLocations = SequenceUtil.findPossibleLocationsForEvent(hostLifeline, startEvent);
			}
			// find location constraints for target
			finishLocation = SequenceUtil.findLocationOfEvent(hostLifeline, finishEvent);
			if(finishLocation == null) {
				possibleFinishLocations = SequenceUtil.findPossibleLocationsForEvent(hostLifeline, finishEvent);
			}
			// find start and finish locations with correct y (start.y < finish.y) and proportions
			if(startLocation == null) {
				if(finishLocation != null) {
					int top = possibleStartLocations.x;
					int bottom = possibleStartLocations.bottom();
					if(top > finishLocation.y) {
						return null;
					} else {
						startLocation = possibleStartLocations.getTop();
						startLocation.y = (top + Math.min(bottom, finishLocation.y)) / 2;
					}
				} else {
					int topS = possibleStartLocations.y;
					int bottomS = possibleStartLocations.bottom();
					int topF = possibleFinishLocations.y;
					int bottomF = possibleFinishLocations.bottom();
					if(topS > bottomF) {
						return null;
					} else {
						startLocation = possibleStartLocations.getTop();
						finishLocation = possibleFinishLocations.getBottom();
						if(bottomS<topF){
							startLocation.y = (topS + bottomS) / 2;
							finishLocation.y = (topF + bottomF) / 2;
						} else {
							startLocation.y = (topS + bottomS + topS + topF) / 4;
							finishLocation.y = (bottomF + topF + bottomF + bottomS) / 4;
						}
					}
				}
			}
			if(finishLocation == null) {
				// startLocation != null
				int top = possibleFinishLocations.y;
				int bottom = possibleFinishLocations.bottom();
				if(bottom < startLocation.y) {
					return null;
				} else {
					finishLocation = possibleFinishLocations.getBottom();
					finishLocation.y = (bottom + Math.max(top, startLocation.y)) / 2;
				}
			}
			// deduce bounds
			Rectangle result = new Rectangle(startLocation, finishLocation);
			result.width = LifelineXYLayoutEditPolicy.EXECUTION_INIT_WIDTH;
			return result;
		}
		return null;
	}

	/**
	 * Get the command to drop a message link
	 * 
	 * @param dropRequest
	 *        request to drop
	 * @param semanticLink
	 *        message link
	 * @param linkVISUALID
	 *        the message's visual id
	 * @return the drop command
	 */
	private Command dropMessage(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sources = SequenceLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targets = SequenceLinkMappingHelper.getInstance().getTarget(semanticLink);
		if(!sources.isEmpty() && !targets.isEmpty()) {
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			return getDropLocatedLinkCommand(dropRequest, source, target, linkVISUALID, semanticLink);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * The method provides command to create the binary link into the diagram. If the source and the
	 * target views do not exist, these views will be created.
	 * 
	 * This implementation is very similar to
	 * {@link CommonDiagramDragDropEditPolicy#dropBinaryLink(CompositeCommand, Element, Element, int, Point, Element)}.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param cc
	 *        the composite command that will contain the set of command to create the binary
	 *        link
	 * @param source
	 *        the element source of the link
	 * @param target
	 *        the element target of the link
	 * @param linkVISUALID
	 *        the link VISUALID used to create the view
	 * @param location
	 *        the location the location where the view will be be created
	 * @param semanticLink
	 *        the semantic link that will be attached to the view
	 * 
	 * @return the composite command
	 */
	protected Command getDropLocatedLinkCommand(DropObjectsRequest dropRequest, Element source, Element target, int linkVISUALID, Element semanticLink) {
		// look for editpart
		GraphicalEditPart sourceEditPart = (GraphicalEditPart)lookForEditPart(source);
		GraphicalEditPart targetEditPart = (GraphicalEditPart)lookForEditPart(target);

		CompositeCommand cc = new CompositeCommand("Drop");

		// descriptor of the link
		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(getUMLElementType(linkVISUALID), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), getDiagramPreferencesHint());

		// get source and target adapters, creating the add commands if necessary
		IAdaptable sourceAdapter = null;
		IAdaptable targetAdapter = null;
		if(sourceEditPart == null) {
			ICommand createCommand = getDefaultDropNodeCommand(getLinkSourceDropLocation(dropRequest.getLocation(), source, target), source);
			cc.add(createCommand);

			sourceAdapter = (IAdaptable)createCommand.getCommandResult().getReturnValue();
		} else {
			sourceAdapter = new SemanticAdapter(null, sourceEditPart.getModel());
		}
		if(targetEditPart == null) {
			ICommand createCommand = getDefaultDropNodeCommand(getLinkTargetDropLocation(dropRequest.getLocation(), source, target), target);
			cc.add(createCommand);

			targetAdapter = (IAdaptable)createCommand.getCommandResult().getReturnValue();
		} else {
			targetAdapter = new SemanticAdapter(null, targetEditPart.getModel());
		}

		CreateLocatedConnectionViewCommand aLinkCommand = new CreateLocatedConnectionViewCommand(getEditingDomain(), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), sourceAdapter, targetAdapter, getViewer(), getDiagramPreferencesHint(), linkdescriptor, null);
		aLinkCommand.setElement(semanticLink);
		Point[] sourceAndTarget = getLinkSourceAndTargetLocations(semanticLink, sourceEditPart, targetEditPart);
		aLinkCommand.setLocations(sourceAndTarget[0], sourceAndTarget[1]);
		cc.compose(aLinkCommand);
		return new ICommandProxy(cc);
	}

	/**
	 * Get the source and target recommended points for creating the link
	 * 
	 * @param semanticLink
	 *        link to create
	 * @param sourceEditPart
	 *        edit part source of the link
	 * @param targetEditPart
	 *        edit part target of the link
	 * @return a point array of size 2, with eventually null values (when no point constraint). Index 0 : source location, 1 : target location
	 */
	private Point[] getLinkSourceAndTargetLocations(Element semanticLink, GraphicalEditPart sourceEditPart, GraphicalEditPart targetEditPart) {
		// index 0 : source location, 1 : target location
		Point[] sourceAndTarget = new Point[]{ null, null };
		// end events of the link
		OccurrenceSpecification sourceEvent = null;
		OccurrenceSpecification targetEvent = null;
		if(semanticLink instanceof Message) {
			MessageEnd sendEvent = ((Message)semanticLink).getSendEvent();
			if(sendEvent instanceof OccurrenceSpecification) {
				sourceEvent = (OccurrenceSpecification)sendEvent;
			}
			MessageEnd rcvEvent = ((Message)semanticLink).getReceiveEvent();
			if(rcvEvent instanceof OccurrenceSpecification) {
				targetEvent = (OccurrenceSpecification)rcvEvent;
			}
		} else if(semanticLink instanceof GeneralOrdering) {
			sourceEvent = ((GeneralOrdering)semanticLink).getBefore();
			targetEvent = ((GeneralOrdering)semanticLink).getAfter();
		}
		if(sourceEvent != null || targetEvent != null) {
			Rectangle possibleSourceLocations = null;
			Rectangle possibleTargetLocations = null;
			// find location constraints for source
			if(sourceEvent != null && sourceEditPart instanceof LifelineEditPart) {
				sourceAndTarget[0] = SequenceUtil.findLocationOfEvent((LifelineEditPart)sourceEditPart, sourceEvent);
				if(sourceAndTarget[0] == null) {
					possibleSourceLocations = SequenceUtil.findPossibleLocationsForEvent((LifelineEditPart)sourceEditPart, sourceEvent);
				}
			}
			// find location constraints for target
			if(targetEvent != null && targetEditPart instanceof LifelineEditPart) {
				sourceAndTarget[1] = SequenceUtil.findLocationOfEvent((LifelineEditPart)targetEditPart, targetEvent);
				if(sourceAndTarget[1] == null) {
					possibleTargetLocations = SequenceUtil.findPossibleLocationsForEvent((LifelineEditPart)targetEditPart, targetEvent);
				}
			}
			// deduce a possibility
			if(sourceAndTarget[0] == null && possibleSourceLocations != null) {
				// we must fix the source
				if(sourceAndTarget[1] == null && possibleTargetLocations == null) {
					// no target constraint, take center for source
					sourceAndTarget[0] = possibleSourceLocations.getCenter();
				} else if(sourceAndTarget[1] != null) {
					// target is fixed, find arranging source
					int topSource = possibleSourceLocations.y;
					int centerSource = possibleSourceLocations.getCenter().y;
					if(sourceAndTarget[1].y < topSource) {
						// we would draw an uphill message (forbidden).
						// return best locations (command will not execute correctly and handle error report)
						sourceAndTarget[0] = possibleSourceLocations.getTop();
					} else if(centerSource <= sourceAndTarget[1].y) {
						// simply fix to the center of constraint
						sourceAndTarget[0] = possibleSourceLocations.getCenter();
					} else {
						// horizontal message makes source as near as possible to the center
						sourceAndTarget[0] = possibleSourceLocations.getCenter();
						sourceAndTarget[0].y = sourceAndTarget[1].y;
					}
				} else {
					// possibleTargetLocations !=null
					// find arranging target and source
					int centerTarget = possibleTargetLocations.getCenter().y;
					int bottomTarget = possibleTargetLocations.bottom();
					int topSource = possibleSourceLocations.y;
					int centerSource = possibleSourceLocations.getCenter().y;
					if(bottomTarget < topSource) {
						// we would draw an uphill message (forbidden).
						// return best locations (command will not execute correctly and handle error report)
						sourceAndTarget[0] = possibleSourceLocations.getTop();
						sourceAndTarget[1] = possibleTargetLocations.getBottom();
					} else if(centerSource <= centerTarget) {
						// simply fix to centers
						sourceAndTarget[0] = possibleSourceLocations.getCenter();
						sourceAndTarget[1] = possibleTargetLocations.getCenter();
					} else {
						// horizontal message makes source and target as near as possible to the centers
						sourceAndTarget[0] = possibleSourceLocations.getCenter();
						sourceAndTarget[0].y = (topSource + bottomTarget) / 2;
						sourceAndTarget[1] = possibleTargetLocations.getCenter();
						sourceAndTarget[1].y = (topSource + bottomTarget) / 2;
					}
				}
			}
			if(sourceAndTarget[1] == null && possibleTargetLocations != null) {
				// we must fix the target
				// fixedSourceLocation == null => possibleSourceLocations == null
				// source is fixed, find arranging target
				int centerTarget = possibleTargetLocations.getCenter().y;
				int bottomTarget = possibleTargetLocations.bottom();
				if(sourceAndTarget[0] == null) {
					// simply fix to the center of constraint
					sourceAndTarget[1] = possibleTargetLocations.getCenter();
				} else if(bottomTarget < sourceAndTarget[0].y) {
					// we would draw an uphill message (forbidden).
					// return best locations (command will not execute correctly and handle error report)
					sourceAndTarget[1] = possibleTargetLocations.getBottom();
				} else if(sourceAndTarget[0].y <= centerTarget) {
					// simply fix to the center of constraint
					sourceAndTarget[1] = possibleTargetLocations.getCenter();
				} else {
					// horizontal message makes target as near as possible to the center
					sourceAndTarget[1] = possibleTargetLocations.getCenter();
					sourceAndTarget[1].y = sourceAndTarget[0].y;
				}
			}
		}
		return sourceAndTarget;
	}

	/**
	 * Get the command to drop a general ordering link
	 * 
	 * @param dropRequest
	 *        request to drop
	 * @param semanticLink
	 *        general ordering link
	 * @param linkVISUALID
	 *        the link's visual id
	 * @return the drop command
	 */
	private Command dropGeneralOrdering(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sources = SequenceLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targets = SequenceLinkMappingHelper.getInstance().getTarget(semanticLink);
		if(!sources.isEmpty() && !targets.isEmpty()) {
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			return getDropLocatedLinkCommand(dropRequest, source, target, linkVISUALID, semanticLink);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}
}
