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
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.AddCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.DurationObservationHelper;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DestructionEventEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DurationObservationEditPart;
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
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;

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
		elementsVisualId.add(DestructionEventEditPart.VISUAL_ID);
		elementsVisualId.add(StateInvariantEditPart.VISUAL_ID);
		elementsVisualId.add(TimeConstraintEditPart.VISUAL_ID);
		elementsVisualId.add(DurationConstraintEditPart.VISUAL_ID);
		elementsVisualId.add(DurationConstraintInMessageEditPart.VISUAL_ID);
		elementsVisualId.add(TimeObservationEditPart.VISUAL_ID);
		elementsVisualId.add(DurationObservationEditPart.VISUAL_ID);
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
		if(nodeVISUALID == -1 && linkVISUALID == -1) {
			// detect duration observation on a message
			if(semanticLink instanceof DurationObservation) {
				List<NamedElement> events = ((DurationObservation)semanticLink).getEvents();
				if(events.size() >= 2) {
					NamedElement occ1 = events.get(0);
					NamedElement occ2 = events.get(1);
					if(occ1 instanceof MessageOccurrenceSpecification && occ2 instanceof MessageOccurrenceSpecification) {
						if(!occ1.equals(occ2) && DurationObservationHelper.endsOfSameMessage((OccurrenceSpecification)occ1, (OccurrenceSpecification)occ2)) {
							Message message = ((MessageOccurrenceSpecification)occ1).getMessage();
							// search a connection which matches the possessing message
							DiagramEditPart diag = DiagramEditPartsUtil.getDiagramEditPart(getHost());
							for(Object conn : diag.getConnections()) {
								if(conn instanceof ConnectionNodeEditPart) {
									EObject connElt = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
									if(message.equals(connElt)) {
										return dropMessageLabelNode((DurationObservation)semanticLink, (ConnectionNodeEditPart)conn, DurationObservationEditPart.VISUAL_ID);
									}
								}
							}
						}
					}
				}
			}
		}
		if((nodeVISUALID == -1 || nodeVISUALID == ConstraintEditPart.VISUAL_ID || nodeVISUALID == DurationConstraintEditPart.VISUAL_ID || nodeVISUALID == DurationConstraintInMessageEditPart.VISUAL_ID) && linkVISUALID == -1) {
			// detect duration constraint on a message
			if(semanticLink instanceof DurationConstraint) {
				List<Element> events = ((DurationConstraint)semanticLink).getConstrainedElements();
				if(events.size() >= 2) {
					Element occ1 = events.get(0);
					Element occ2 = events.get(1);
					if(occ1 instanceof MessageOccurrenceSpecification && occ2 instanceof MessageOccurrenceSpecification) {
						if(!occ1.equals(occ2) && DurationConstraintHelper.endsOfSameMessage((OccurrenceSpecification)occ1, (OccurrenceSpecification)occ2)) {
							Message message = ((MessageOccurrenceSpecification)occ1).getMessage();
							// search a connection which matches the possessing message
							DiagramEditPart diag = DiagramEditPartsUtil.getDiagramEditPart(getHost());
							for(Object conn : diag.getConnections()) {
								if(conn instanceof ConnectionNodeEditPart) {
									EObject connElt = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
									if(message.equals(connElt)) {
										return dropMessageLabelNode((DurationConstraint)semanticLink, (ConnectionNodeEditPart)conn, DurationConstraintInMessageEditPart.VISUAL_ID);
									}
								}
							}
						}
					}
				}
			}
		}

		if(nodeVISUALID != -1) {
			switch(nodeVISUALID) {
			case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			case ActionExecutionSpecificationEditPart.VISUAL_ID:
				return dropExecutionSpecification((ExecutionSpecification)semanticLink, nodeVISUALID);
			case DestructionEventEditPart.VISUAL_ID:
				return dropDestructionEvent((DestructionEvent)semanticLink, nodeVISUALID);
			case StateInvariantEditPart.VISUAL_ID:
				return dropStateInvariant((StateInvariant)semanticLink, nodeVISUALID);
			case TimeConstraintEditPart.VISUAL_ID:
			case DurationConstraintEditPart.VISUAL_ID:
				return dropIntervalConstraintInLifeline((IntervalConstraint)semanticLink, nodeVISUALID);
			case TimeObservationEditPart.VISUAL_ID:
				return dropTimeObservationInLifeline((TimeObservation)semanticLink, nodeVISUALID);
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
			default:
				return UnexecutableCommand.INSTANCE;
			}
		}
		return UnexecutableCommand.INSTANCE;
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
	private Command dropMessageLabelNode(PackageableElement durationLabelElement, ConnectionNodeEditPart messageEditPart, int nodeVISUALID) {
		CompositeCommand cc = new CompositeCommand("Drop");
		IAdaptable elementAdapter = new EObjectAdapter(durationLabelElement);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());
		CreateCommand createCommand = new CreateCommand(getEditingDomain(), descriptor, ((View)messageEditPart.getModel()));
		cc.compose(createCommand);
		return new ICommandProxy(cc);
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
		CompositeCommand cc = new CompositeCommand("Drop");
		IAdaptable elementAdapter = new EObjectAdapter(observation);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());
		CreateCommand createCommand = new CreateCommand(getEditingDomain(), descriptor, ((View)getHost().getModel()));
		cc.compose(createCommand);

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
					SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)createCommand.getCommandResult().getReturnValue(), newBounds);
					cc.compose(setBoundsCommand);
					return new ICommandProxy(cc);
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
		CompositeCommand cc = new CompositeCommand("Drop");
		IAdaptable elementAdapter = new EObjectAdapter(constraint);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());
		CreateCommand createCommand = new CreateCommand(getEditingDomain(), descriptor, ((View)getHost().getModel()));
		cc.compose(createCommand);

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
					SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)createCommand.getCommandResult().getReturnValue(), newBounds);
					cc.compose(setBoundsCommand);
					return new ICommandProxy(cc);
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
					SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)createCommand.getCommandResult().getReturnValue(), newBounds);
					cc.compose(setBoundsCommand);
					return new ICommandProxy(cc);
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

	private Command dropStateInvariant(StateInvariant stateInvariant, int nodeVISUALID) {
		List<View> existingViews = DiagramEditPartsUtil.findViews(stateInvariant, getViewer());
		if(existingViews.isEmpty()) {

			// an StateInvariant covereds systematically a unique lifeline
			Lifeline lifeline = stateInvariant.getCovereds().get(0);
			// Check that the container view is the view of the lifeline
			if(lifeline.equals(getHostObject())) {
				return getCreateCommand(stateInvariant, nodeVISUALID);
			}
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
	private Command dropDestructionEvent(DestructionEvent destructionEvent, int nodeVISUALID) {
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
						return getCreateCommand(destructionEvent, nodeVISUALID);
					}
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get the create command
	 * 
	 * @param semanticLink
	 *        the element
	 * @param nodeVISUALID
	 *        the visualID
	 * @return the command
	 */
	private Command getCreateCommand(Element semanticLink, int nodeVISUALID) {
		ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(semanticLink), Node.class, String.valueOf(nodeVISUALID), ViewUtil.APPEND, true, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());
		CreateCommand cc = new CreateCommand(getEditingDomain(), viewDescriptor, (View)getHost().getModel());
		return new ICommandProxy(cc);
	}

	private Command dropExecutionSpecification(ExecutionSpecification es, int nodeVISUALID) {
		List<View> existingViews = DiagramEditPartsUtil.findViews(es, getViewer());
		if(existingViews.isEmpty()) {
			// Find the lifeline of the ES

			if(es.getStart() != null) {
				// an Occurrence Specification covereds systematically a unique lifeline
				Lifeline lifeline = es.getStart().getCovereds().get(0);
				// Check that the container view is the view of the lifeline
				if(lifeline.equals(getHostObject())) {
					return getCreateCommand(es, nodeVISUALID);
				}
			}
		} else {

			CompositeCommand cc = new CompositeCommand("Moving an ES");

			// Add the view to the new container
			AddCommand addCommand = new AddCommand(getEditingDomain(), new EObjectAdapter((View)getHost().getModel()), new EObjectAdapter(existingViews.get(0)));
			cc.add(addCommand);


			Lifeline oldCoveredLifeline = (Lifeline)ViewUtil.resolveSemanticElement((View)existingViews.get(0).eContainer());

			// Update the ES covered lifeline
			updateCoveredLifeline(es, cc, oldCoveredLifeline);

			// Update the start and finish occurrence specification covered lifeline
			updateCoveredLifeline(es.getStart(), cc, oldCoveredLifeline);
			updateCoveredLifeline(es.getFinish(), cc, oldCoveredLifeline);

			//TODO  Set the new location of the view. 
			// Actually there is some layout problems, so it is disable. 
			//				SetBoundsCommand boundsCommand = new SetBoundsCommand(getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(existingViews.get(0)), dropRequest.getLocation());
			//				cc.add(boundsCommand);

			return new ICommandProxy(cc);
		}


		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Update the covered feature of the interactionFragment : remove the old lifeline and add the new lifeline.
	 * 
	 * @param interactionFragment
	 *        the interaction fragment impacted
	 * @param cc
	 *        the composite command to add the new commands
	 * @param oldCoveredLifeline
	 *        the old covered lifeline
	 */
	private void updateCoveredLifeline(InteractionFragment interactionFragment, CompositeCommand cc, Lifeline oldCoveredLifeline) {
		// Remove old covered lifeline 
		DestroyReferenceRequest destroyReferenceRequest = new DestroyReferenceRequest(interactionFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), oldCoveredLifeline, false);
		DestroyReferenceCommand destroyReferenceCommand = new DestroyReferenceCommand(destroyReferenceRequest);
		cc.add(destroyReferenceCommand);

		// Add new covered lifeline
		SetRequest setRequest = new SetRequest(interactionFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), ViewUtil.resolveSemanticElement((View)getHost().getModel()));
		SetValueCommand coveredLifelineCommand = new SetValueCommand(setRequest);
		cc.add(coveredLifelineCommand);
	}

	private Command dropMessage(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sources = SequenceLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targets = SequenceLinkMappingHelper.getInstance().getTarget(semanticLink);
		if(!sources.isEmpty() && !targets.isEmpty()) {
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Message"), source, target, linkVISUALID, dropRequest.getLocation(), semanticLink));
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}
}
