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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.wrappers.CommandProxyWithResult;
import org.eclipse.papyrus.uml.diagram.common.commands.DeferredCreateCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.DurationObservationHelper;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateLocatedConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceLinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
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
	public static final String LIFELINE_MISSING = "There is no representation of lifeline {0}";
	
	public static final String DIALOG_TITLE = "Element missing";

	public CustomDiagramDragDropEditPolicy() {
		super(SequenceLinkMappingHelper.getInstance());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> elementsVisualId = new HashSet<Integer>();
		elementsVisualId.add(LifelineEditPart.VISUAL_ID);
 		elementsVisualId.add(ActionExecutionSpecificationEditPart.VISUAL_ID);
		elementsVisualId.add(BehaviorExecutionSpecificationEditPart.VISUAL_ID);
		
		elementsVisualId.add(InteractionUseEditPart.VISUAL_ID);
		elementsVisualId.add(InteractionEditPart.VISUAL_ID);
		elementsVisualId.add(InteractionOperandEditPart.VISUAL_ID);
		
		elementsVisualId.add(CombinedFragmentEditPart.VISUAL_ID);
		
		// CoRegion
		elementsVisualId.add(CombinedFragment2EditPart.VISUAL_ID);
		
		elementsVisualId.add(CommentAnnotatedElementEditPart.VISUAL_ID);
		elementsVisualId.add(ConsiderIgnoreFragmentEditPart.VISUAL_ID);
		
		elementsVisualId.add(ContinuationEditPart.VISUAL_ID);
		elementsVisualId.add(StateInvariantEditPart.VISUAL_ID);
		elementsVisualId.add(CommentEditPart.VISUAL_ID);
		elementsVisualId.add(CommentBodyEditPart.VISUAL_ID);

		elementsVisualId.add(ConstraintEditPart.VISUAL_ID);
		elementsVisualId.add(Constraint2EditPart.VISUAL_ID);
		elementsVisualId.add(ConstraintConstrainedElementEditPart.VISUAL_ID);

		elementsVisualId.add(DurationObservationEditPart.VISUAL_ID);
		elementsVisualId.add(TimeConstraintEditPart.VISUAL_ID);
		elementsVisualId.add(TimeObservationEditPart.VISUAL_ID);
		elementsVisualId.add(DurationConstraintEditPart.VISUAL_ID);
		
		elementsVisualId.add(PackageEditPart.VISUAL_ID);

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
		elementsVisualId.add(DestructionOccurrenceSpecificationEditPart.VISUAL_ID);
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

	
	@Override
	protected IUndoableOperation getDropObjectCommand(
			DropObjectsRequest dropRequest, final EObject
			droppedObject) {
		IUndoableOperation dropObjectCommand = super.getDropObjectCommand(
				dropRequest, droppedObject);
		if (dropObjectCommand != null && dropObjectCommand.canExecute()) {
			return dropObjectCommand;
		}
		// fix bug 364696(https://bugs.eclipse.org/bugs/show_bug.cgi?id=364696)
		if (droppedObject instanceof ConnectableElement) {
			return doDropConnectableElement(dropRequest,
					(ConnectableElement) droppedObject);
		}
	 
		return dropObjectCommand;
	}

	private IUndoableOperation doDropConnectableElement(
			DropObjectsRequest dropRequest,
			final ConnectableElement droppedObject) {
		Point location = dropRequest.getLocation();
		CreateViewRequest createShapeRequest = CreateViewRequestFactory
				.getCreateShapeRequest(UMLElementTypes.Lifeline_3001,
				UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		createShapeRequest.setLocation(location);
		
		ViewDescriptor viewDescriptor =createShapeRequest.getViewDescriptors().get(0);
		CreateElementRequestAdapter elementAdapter =(CreateElementRequestAdapter) viewDescriptor.getElementAdapter();
		CreateElementRequest createElementRequest = (CreateElementRequest)elementAdapter.getAdapter(CreateElementRequest.class);

		// parameter "ConnectableElement" used in LifelineCreateCommand#doConfigure()
		createElementRequest.setParameter(SequenceRequestConstant.CONNECTABLE_ELEMENT,droppedObject);
		EditPart host = getHost();
		Command theRealCmd = ((IGraphicalEditPart) host)
				.getCommand(createShapeRequest);

		if (theRealCmd != null && theRealCmd.canExecute()) {
			return new CommandProxy(theRealCmd);
		}
		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
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
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID, int linkVISUALID) {
		Point location = dropRequest.getLocation().getCopy();

		// handle specifically the case when node is on a message
		Command cmd = handleNodeOnMessage(semanticElement, nodeVISUALID, linkVISUALID);
		if(cmd != null) {
			return cmd;
		}

		if(nodeVISUALID != -1) {
			switch(nodeVISUALID) {
			case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			case ActionExecutionSpecificationEditPart.VISUAL_ID:
				return dropExecutionSpecification((ExecutionSpecification)semanticElement, nodeVISUALID, location);
			case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
				return dropDestructionOccurrence((DestructionOccurrenceSpecification)semanticElement, nodeVISUALID, location);
			case StateInvariantEditPart.VISUAL_ID:
				return dropStateInvariant((StateInvariant)semanticElement, nodeVISUALID, location);
			case TimeConstraintEditPart.VISUAL_ID:
			case DurationConstraintEditPart.VISUAL_ID:
				return dropIntervalConstraintInLifeline((IntervalConstraint)semanticElement, nodeVISUALID);
			case TimeObservationEditPart.VISUAL_ID:
				return dropTimeObservationInLifeline((TimeObservation)semanticElement, nodeVISUALID, location);
			case CombinedFragment2EditPart.VISUAL_ID:
				return dropCoRegion((CombinedFragment)semanticElement, nodeVISUALID, location);
			case CommentEditPart.VISUAL_ID:
			case ConstraintEditPart.VISUAL_ID:
			case Constraint2EditPart.VISUAL_ID:
			case InteractionUseEditPart.VISUAL_ID:
			case LifelineEditPart.VISUAL_ID:
				return dropNodeElement(semanticElement, nodeVISUALID, location);
			case ConsiderIgnoreFragmentEditPart.VISUAL_ID:	
			case CombinedFragmentEditPart.VISUAL_ID:
				return dropCombinedFragment((CombinedFragment)semanticElement, nodeVISUALID, location);
			case ContinuationEditPart.VISUAL_ID:
			case InteractionOperandEditPart.VISUAL_ID:
				return dropCompartmentNodeElement(semanticElement, nodeVISUALID, location);
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
				return dropMessage(dropRequest, semanticElement, linkVISUALID);
			case GeneralOrderingEditPart.VISUAL_ID:
				return dropGeneralOrdering(dropRequest, semanticElement, linkVISUALID);
			default:
				return UnexecutableCommand.INSTANCE;
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get the drop command for the Element
	 * 
	 * @param element
	 *        the Element
	 * @param nodeVISUALID
	 *        the node visual id
	 * @return the drop command if the Element can be dropped
	 */
	private Command dropNodeElement(Element element, int nodeVISUALID, Point location) {
		Element parent = element.getOwner();
		if (getHostObject().equals(parent)) {
			List<View> existingViews = DiagramEditPartsUtil.findViews(parent, getViewer());
			if (!existingViews.isEmpty()) {
				EditPart parentEditPart = lookForEditPart(parent);
				if (parentEditPart != null) {
					return new ICommandProxy(getDefaultDropNodeCommand(parentEditPart, nodeVISUALID, location, element));
				}
			}
 		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get the drop command for the Element
	 * 
	 * @param element
	 *        the Element
	 * @param nodeVISUALID
	 *        the node visual id
	 * @return the drop command if the element can be dropped
	 */
	private Command dropCombinedFragment(CombinedFragment combinedFragment, int nodeVISUALID, Point location) {
		Element parent = combinedFragment.getOwner();
		Element parentContainer = parent.getOwner();
		if (!(parentContainer instanceof CombinedFragment)) {
			parentContainer = parent;
		}
		if (getHostObject().equals(parentContainer)) {
			List<View> existingViews = DiagramEditPartsUtil.findViews(parent, getViewer());
			if (!existingViews.isEmpty()) {
				EditPart parentEditPart = lookForEditPart(parent);
				if (parentEditPart instanceof GraphicalEditPart) {
					// check if all lifelines coversby exist in diagram.
					Rectangle bounds = null; 
					List<Lifeline> lifelines = combinedFragment.getCovereds();
					for (Lifeline lifeline : combinedFragment.getCovereds()) {
						EditPart lifelineEditPart = lookForEditPart(lifeline);
						if (lifelineEditPart == null) {
							Shell shell = Display.getCurrent().getActiveShell();
							MessageDialog.openError(shell, DIALOG_TITLE, NLS.bind(LIFELINE_MISSING, lifeline.getName()));
							return UnexecutableCommand.INSTANCE;							
						}
						if (lifelineEditPart instanceof GraphicalEditPart) {
							GraphicalEditPart graphicalEditPart = (GraphicalEditPart) lifelineEditPart;
							Rectangle rectangle = graphicalEditPart.getFigure().getBounds().getCopy();
							graphicalEditPart.getFigure().translateToAbsolute(rectangle);
							if (bounds == null) {
								bounds = rectangle;
							} else {
								bounds = bounds.union(rectangle);
							}
						}
					}
					if (bounds == null) {
						return new ICommandProxy(getDefaultDropNodeCommand(parentEditPart, nodeVISUALID, location, combinedFragment));
					}
					location.x = bounds.x;
					
					return new ICommandProxy(dropCombinedFragment(getHost(), nodeVISUALID, location, new Dimension(bounds.width, 100), combinedFragment));
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}
	
	
	/*
	 * To extend the method in superclass with an option Dimension size,
	 * 
	 * 
	 * @param hostEP
	 * @param nodeVISUALID
	 * @param absoluteLocation
	 * @param size
	 * @param droppedObject
	 * @return
	 */
	protected ICommand dropCombinedFragment(EditPart hostEP,  int nodeVISUALID, Point absoluteLocation, Dimension size, EObject droppedObject) {
		IHintedType type = ((IHintedType)getUMLElementType(nodeVISUALID));

		String semanticHint = null;
		if (type != null) {
			semanticHint = type.getSemanticHint();
		}

		List<View> existingViews = DiagramEditPartsUtil.findViews(droppedObject, getViewer());

		// only allow one view instance of a single element by diagram
		if(existingViews.isEmpty()) {
			IAdaptable elementAdapter = new EObjectAdapter(droppedObject);

			ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, semanticHint, ViewUtil.APPEND, true, getDiagramPreferencesHint());
			CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
			createViewRequest.setLocation(absoluteLocation);
			createViewRequest.setSize(size);

			// "ask" the host for a command associated with the
			// CreateViewRequest
			Command command = hostEP.getCommand(createViewRequest);
			if(createViewRequest.getNewObject() instanceof List) {
				for(Object object : (List<?>)createViewRequest.getNewObject()) {
					if(object instanceof IAdaptable) {
						DeferredCreateCommand createCommand2 = new DeferredCreateCommand(getEditingDomain(), droppedObject, (IAdaptable)object, getHost().getViewer());
						command.chain(new ICommandProxy(createCommand2));
					}
				}
			}
			// set the viewdescriptor as result
			// it then can be used as an adaptable to retrieve the View
			return new CommandProxyWithResult(command, descriptor);
		}

		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}
	
	/**
	 * Get the drop command in case the element can be handled as an element in a CombinedFragment
	 * 
	 * @param element
	 * @param nodeVISUALID
	 * @param location
	 * @return
	 */
	private Command dropCompartmentNodeElement(Element element, int nodeVISUALID, Point location) {
		Element parent = element.getOwner();
		Element directParent = parent;
		if (parent instanceof InteractionOperand) {
			parent = parent.getOwner();
		}
		if (getHostObject().equals(parent)) {
			List<View> existingViews = DiagramEditPartsUtil.findViews(directParent, getViewer());
			if (!existingViews.isEmpty()) {
				EditPart parentEditPart = lookForEditPart(directParent);
				if (parentEditPart != null) {
					return new ICommandProxy(getDefaultDropNodeCommand(parentEditPart, nodeVISUALID, location, element));
				}
			}
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
	 * @param dropLocation 
	 * @return the command if the lifeline is the correct one or UnexecutableCommand
	 */
	private Command dropTimeObservationInLifeline(TimeObservation observation, int nodeVISUALID, Point dropLocation) {
		CompoundCommand cc = new CompoundCommand("Drop");
		IAdaptable elementAdapter = new EObjectAdapter(observation);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, true, getDiagramPreferencesHint());
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
		
		if(getHost() instanceof InteractionInteractionCompartmentEditPart){
			Rectangle newBounds = new Rectangle(dropLocation, new Dimension(-1, -1));
			((InteractionInteractionCompartmentEditPart)getHost()).getFigure().translateToRelative(newBounds);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", descriptor, newBounds);
			cc.add(new ICommandProxy(setBoundsCommand));
			return cc;
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

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, true, getDiagramPreferencesHint());
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
			return 2;
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
	 * @param destructionOccurence
	 *        the destructionEvent to drop
	 * @param nodeVISUALID
	 *        the node visualID
	 * @return the command to drop the destructionEvent on a lifeline if allowed.
	 */
	private Command dropDestructionOccurrence(DestructionOccurrenceSpecification destructionOccurence, int nodeVISUALID, Point location) {
		// Get all the view of this destructionEvent.
		List<View> existingViews = DiagramEditPartsUtil.findViews(destructionOccurence, getViewer());
		// Get the lifelines containing the graphical destructionEvent
		List<Lifeline> lifelines = getLifelines(existingViews);

		// If the list of lifeline already containing the destructionEvent doesn't contain the lifeline targeted.
		if(!lifelines.contains(getHostObject())) {
			Lifeline lifeline = (Lifeline)getHostObject();
			for(InteractionFragment ift : lifeline.getCoveredBys()) {
				if(ift instanceof DestructionOccurrenceSpecification) {
					DestructionOccurrenceSpecification occurrenceSpecification = (DestructionOccurrenceSpecification)ift;
					// if the event of the occurrenceSpecification is the DestructionEvent, create the command
					if(destructionOccurence.equals(occurrenceSpecification)) {
						return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, destructionOccurence));
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

					ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, semanticHint, ViewUtil.APPEND, true, getDiagramPreferencesHint());
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
	 * Get the command to drop an code region node
	 * 
	 * @param combinedFragment
	 * @param nodeVISUALID
	 * @param location
	 * @return
	 */
	private Command dropCoRegion(CombinedFragment combinedFragment, int nodeVISUALID, Point location) {
		List<View> existingViews = DiagramEditPartsUtil.findViews(combinedFragment, getViewer());
		// only allow one view instance of a single element by diagram
		if(existingViews.isEmpty()) {
			IGraphicalEditPart hostEditpart = (IGraphicalEditPart) getHost();
			EObject element = hostEditpart.getNotationView().getElement();
			if (element instanceof Lifeline) {
				IHintedType type = ((IHintedType)getUMLElementType(nodeVISUALID));

				String semanticHint = null;
				if (type != null) {
					semanticHint = type.getSemanticHint();
				}

				IAdaptable elementAdapter = new EObjectAdapter(combinedFragment);

				ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, semanticHint, ViewUtil.APPEND, true, getDiagramPreferencesHint());
				CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
				createViewRequest.setLocation(location);

				// "ask" the host for a command associated with the CreateViewRequest
				Command command = getHost().getCommand(createViewRequest);
				// set the viewdescriptor as result
				// it then can be used as an adaptable to retrieve the View
				return new ICommandProxy(new CommandProxyWithResult(command, descriptor));
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
