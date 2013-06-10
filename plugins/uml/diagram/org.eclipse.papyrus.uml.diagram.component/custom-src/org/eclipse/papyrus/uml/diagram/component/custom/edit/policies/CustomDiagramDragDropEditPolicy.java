/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/INRIA DaRT) amine.el_kouhen@inria.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.OldCommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.command.CreateViewCommand;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.helpers.ComponentLinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.helpers.MultiDependencyHelper;
import org.eclipse.papyrus.uml.diagram.component.custom.locators.PortPositionLocator;
import org.eclipse.papyrus.uml.diagram.component.custom.log.Log;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.Dependency;

// TODO: Auto-generated Javadoc
/**
 * This class provides an implementation for specific behavior of Drag and Drop
 * in the Composite Diagram.
 */
public class CustomDiagramDragDropEditPolicy extends OldCommonDiagramDragDropEditPolicy {

	/**
	 * Default constructor.
	 */
	public CustomDiagramDragDropEditPolicy() {
		super(ComponentLinkMappingHelper.getInstance());
	}

	/**
	 * Gets the droppable element visual id.
	 *
	 * @return the droppable element visual id
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		// TopLevelNodes
		Set<Integer> droppableElementsVisualId = new HashSet<Integer>();
		droppableElementsVisualId.add(DependencyNodeEditPart.VISUAL_ID);
		droppableElementsVisualId.add(ModelEditPart.VISUAL_ID);
		droppableElementsVisualId.add(PackageEditPart.VISUAL_ID);
		droppableElementsVisualId.add(ComponentEditPart.VISUAL_ID);
		droppableElementsVisualId.add(InterfaceEditPart.VISUAL_ID);
		droppableElementsVisualId.add(CommentEditPart.VISUAL_ID);
		droppableElementsVisualId.add(ConstraintEditPart.VISUAL_ID);
		droppableElementsVisualId.add(PortEditPart.VISUAL_ID);

		// Class CN
		droppableElementsVisualId.add(ModelEditPartCN.VISUAL_ID);
		droppableElementsVisualId.add(PackageEditPartCN.VISUAL_ID);
		droppableElementsVisualId.add(ComponentEditPartCN.VISUAL_ID);
		droppableElementsVisualId.add(ComponentEditPartPCN.VISUAL_ID);
		droppableElementsVisualId.add(InterfaceEditPartPCN.VISUAL_ID);
		droppableElementsVisualId.add(CommentEditPartPCN.VISUAL_ID);
		droppableElementsVisualId.add(ConstraintEditPartPCN.VISUAL_ID);

		return droppableElementsVisualId;
	}

	/**
	 * Gets the uML element type.
	 *
	 * @param elementID the element id
	 * @return the uML element type
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	/**
	 * Gets the node visual id.
	 *
	 * @param containerView the container view
	 * @param domainElement the domain element
	 * @return the node visual id
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * Gets the link with class visual id.
	 *
	 * @param domainElement the domain element
	 * @return the link with class visual id
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	/**
	 * Gets the specific drop command.
	 *
	 * @param dropRequest the drop request
	 * @param semanticElement the semantic element
	 * @param nodeVISUALID the node visualid
	 * @param linkVISUALID the link visualid
	 * @return the specific drop command
	 * {@inheritDoc}
	 */
	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID, int linkVISUALID) {

		// Switch test over linkVisualID
		switch(linkVISUALID) {
		case DependencyEditPart.VISUAL_ID:
			return dropDependency(dropRequest, semanticElement, linkVISUALID);
		default:
			// Switch test over nodeVISUALID
			switch(nodeVISUALID) {
			// Test TopLevelNode... Start
			case DependencyNodeEditPart.VISUAL_ID:
				return dropDependencyNode(dropRequest, semanticElement, nodeVISUALID);
			case PackageEditPart.VISUAL_ID:
			case ComponentEditPart.VISUAL_ID:
			case InterfaceEditPart.VISUAL_ID:

				return dropTopLevelNode(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);
				// Test TopLevelNode... End
			case PortEditPart.VISUAL_ID:
				return dropAffixedNode(dropRequest, semanticElement, nodeVISUALID);
			case CommentEditPart.VISUAL_ID:
			case CommentEditPartPCN.VISUAL_ID:
				return dropComment(dropRequest, semanticElement, nodeVISUALID);

			case ConstraintEditPart.VISUAL_ID:
			case ConstraintEditPartPCN.VISUAL_ID:
				return dropConstraint(dropRequest, semanticElement, nodeVISUALID);
			default:
				return super.getSpecificDropCommand(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);
			}
		}
	}

	private Command dropDependencyNode(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID) {
		Collection sources = ComponentLinkMappingHelper.getInstance().getSource(semanticElement);
		Collection targets = ComponentLinkMappingHelper.getInstance().getTarget(semanticElement);
		if(sources.size() == 1 && targets.size() == 1) {
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, 4008, dropRequest.getLocation(), semanticElement));
		}
		if(sources.size() > 1 || targets.size() > 1) {
			MultiDependencyHelper dependencyHelper = new MultiDependencyHelper(getEditingDomain());
			return dependencyHelper.dropMutliDependency((Dependency)semanticElement, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
		}
		return UnexecutableCommand.INSTANCE;
	}
	
	/**
	 * Returns the command to drop the Comment + the link to attach it to its annotated elements.
	 *
	 * @param dropRequest the drop request
	 * @param semanticLink the semantic link
	 * @param nodeVISUALID the node visual id
	 * @return the command
	 */
	protected Command dropComment(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		//		if(!(graphicalParentObject instanceof Package) && !(graphicalParentObject instanceof Class) && !(graphicalParentObject instanceof Property) && !(graphicalParentObject instanceof Interaction) && !(graphicalParentObject instanceof StateMachine) && !(graphicalParentObject instanceof Collaboration) && !(graphicalParentObject instanceof FunctionBehavior) && !(graphicalParentObject instanceof ProtocolStateMachine) && !(graphicalParentObject instanceof ExecutionEnvironment) && !(graphicalParentObject instanceof Device)) {
		//			return UnexecutableCommand.INSTANCE;
		//		}
		if(nodeVISUALID == CommentEditPart.VISUAL_ID) {
			return getDropCommentCommand((Comment)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView(), (IHintedType)UMLElementTypes.Comment_3201, (IHintedType)UMLElementTypes.CommentAnnotatedElement_4015);
		} else if(nodeVISUALID == CommentEditPartPCN.VISUAL_ID) {
			return getDropCommentCommand((Comment)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView(), (IHintedType)UMLElementTypes.Comment_3074, (IHintedType)UMLElementTypes.CommentAnnotatedElement_4015);
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Returns the command to drop the Constraint + the link to attach it to its contrainted elements.
	 *
	 * @param dropRequest the drop request
	 * @param semanticLink the semantic link
	 * @param nodeVISUALID the node visual id
	 * @return the command
	 */
	protected Command dropConstraint(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		//		if(!(graphicalParentObject instanceof Package) && !(graphicalParentObject instanceof Class) && !(graphicalParentObject instanceof Interaction) && !(graphicalParentObject instanceof StateMachine) && !(graphicalParentObject instanceof Collaboration) && !(graphicalParentObject instanceof FunctionBehavior) && !(graphicalParentObject instanceof ProtocolStateMachine) && !(graphicalParentObject instanceof ExecutionEnvironment) && !(graphicalParentObject instanceof Device)) {
		//			return UnexecutableCommand.INSTANCE;
		//		}

		if(nodeVISUALID == ConstraintEditPart.VISUAL_ID) {
			return getDropConstraintCommand((Constraint)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView(), (IHintedType)UMLElementTypes.Constraint_3199, (IHintedType)UMLElementTypes.ConstraintConstrainedElement_4009);
		} else if(nodeVISUALID == ConstraintEditPartPCN.VISUAL_ID) {
			return getDropConstraintCommand((Constraint)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView(), (IHintedType)UMLElementTypes.Constraint_3075, (IHintedType)UMLElementTypes.ConstraintConstrainedElement_4009);
		}
		return UnexecutableCommand.INSTANCE;
	}


	/**
	 * Returns the drop command for Dependency links.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the element to drop
	 * @param linkVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropDependency(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sourceEnds = ComponentLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targetEnds = ComponentLinkMappingHelper.getInstance().getTarget(semanticLink);

		// Dependency with Unary ends
		if((sourceEnds != null) && (targetEnds != null) && (sourceEnds.size() == 1) && (targetEnds.size() == 1)) {

			Element source = (Element)sourceEnds.toArray()[0];
			Element target = (Element)targetEnds.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Dependency"), source, target, //$NON-NLS-1$
				linkVISUALID, dropRequest.getLocation(), semanticLink));
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * Returns the drop command for RoleBinding links.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the element to drop
	 * @param linkVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropRoleBinding(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sourceEnds = ComponentLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targetEnds = ComponentLinkMappingHelper.getInstance().getTarget(semanticLink);

		// Dependency with Unary ends
		if((sourceEnds != null) && (targetEnds != null) && (sourceEnds.size() == 1) && (targetEnds.size() == 1)) {

			Element source = semanticLink.getOwner();
			Element target = (Element)targetEnds.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop RoleBinding"), source, target, //$NON-NLS-1$
				linkVISUALID, dropRequest.getLocation(), semanticLink));
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}


	/**
	 * Returns the drop command for Property nodes.
	 *
	 * @param dropRequest the drop request
	 * @param droppedElement the element to drop
	 * @param nodeVISUALID the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropProperty(DropObjectsRequest dropRequest, Property droppedElement, int nodeVISUALID) {

		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();

		// Default drop location
		Point location = dropRequest.getLocation().getCopy();

		// Port inherits from Property this case should be excluded and treated
		// separately
		if(!(droppedElement instanceof Port)) {

			if((graphicalParentObject instanceof Classifier) && (((Classifier)graphicalParentObject).getAllAttributes().contains(droppedElement))) {
				// The graphical parent is the real owner of the dropped
				// property.
				// The dropped property may also be an inherited attribute of
				// the graphical parent.
				return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, droppedElement));

			} else if(graphicalParentObject instanceof ConnectableElement) {
				Type type = ((ConnectableElement)graphicalParentObject).getType();
				if((type != null) && (type instanceof Classifier) && (((Classifier)type).getAllAttributes().contains(droppedElement))) {
					// The graphical parent is a Property typed by a Classifier
					// that owns or inherits the
					// dropped property.
					return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, droppedElement));
				}
			}
		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * <pre>
	 * Returns the drop command for Affixed nodes (Parameter, Port).
	 * This method uses PortPositionLocator used by both Port and Parameter.
	 * If the dropped element is a Port, the graphical parent can be :
	 * - a Class that owns or inherits the Port
	 * - a Property which type owns or inherits the Port
	 * </pre>
	 *
	 * @param dropRequest the drop request
	 * @param droppedElement the element to drop
	 * @param nodeVISUALID the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropAffixedNode(DropObjectsRequest dropRequest, Element droppedElement, int nodeVISUALID) {

		// The dropped element must be a Port or Parameter
		if(!((droppedElement instanceof Port) || (droppedElement instanceof Parameter))) {
			Log.getInstance().error(new Exception("Incorrect parameter type (droppedElement should be a Port or Parameter)"));
			return UnexecutableCommand.INSTANCE;
		}

		// Manage Element drop in compartment
		Boolean isCompartmentTarget = false; // True if the target is a
												// ShapeCompartmentEditPart
		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();

		// Default drop location
		Point dropLocation = dropRequest.getLocation().getCopy();

		// Detect if the drop target is a compartment
		if(graphicalParentEditPart instanceof ShapeCompartmentEditPart) {
			isCompartmentTarget = true;

			// Replace compartment edit part by its parent EditPart
			graphicalParentEditPart = (GraphicalEditPart)graphicalParentEditPart.getParent();

			// Translate Port expected location according to the compartment
			// location
			Point targetLocation = graphicalParentEditPart.getContentPane().getBounds().getLocation();
			ShapeCompartmentFigure compartmentFigure = (ShapeCompartmentFigure)getHostFigure();

			// Retrieve ViewPort location = the area where compartment children
			// are located
			// Retrieve ViewPort view location = the relative location of the
			// viewed compartment
			// depending on the current scroll bar state
			Viewport compartmentViewPort = compartmentFigure.getScrollPane().getViewport();
			Point compartmentViewPortLocation = compartmentViewPort.getLocation();
			Point compartmentViewPortViewLocation = compartmentViewPort.getViewLocation();

			// Calculate the delta between the targeted element position for
			// drop (the Composite figure)
			// and the View location with eventual scroll bar.
			Point delta = compartmentViewPortLocation.translate(targetLocation.negate());
			delta = delta.translate(compartmentViewPortViewLocation.negate());

			// Translate the requested drop location (relative to parent)
			dropLocation = dropRequest.getLocation().getTranslated(delta);
		}
		// Manage Element drop in compartment

		// Create proposed creation bounds and use the locator to find the
		// expected position
		Point parentLoc = graphicalParentEditPart.getFigure().getBounds().getLocation().getCopy();
		PortPositionLocator locator = new PortPositionLocator(graphicalParentEditPart.getFigure(), PositionConstants.NONE);

		Rectangle proposedBounds = new Rectangle(dropLocation, new Dimension(20, 20));
		proposedBounds = proposedBounds.getTranslated(parentLoc);
		Rectangle preferredBounds = locator.getPreferredLocation(proposedBounds);

		// Convert the calculated preferred bounds as relative to parent
		// location
		Rectangle creationBounds = preferredBounds.getTranslated(parentLoc.getNegated());
		dropLocation = creationBounds.getLocation();

		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();

		if((graphicalParentObject instanceof EncapsulatedClassifier) && (((EncapsulatedClassifier)graphicalParentObject).getAllAttributes().contains(droppedElement))) {
			// Drop Port on StructuredClassifier
			if(isCompartmentTarget) {
				return getDropAffixedNodeInCompartmentCommand(nodeVISUALID, dropLocation, droppedElement);
			}
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropLocation, droppedElement));

		} else if(graphicalParentObject instanceof ConnectableElement) {
			// Drop Port on Part
			Type type = ((ConnectableElement)graphicalParentObject).getType();

			if((type != null) && (type instanceof EncapsulatedClassifier) && (((EncapsulatedClassifier)type).getAllAttributes().contains(droppedElement))) {
				if(isCompartmentTarget) {
					return getDropAffixedNodeInCompartmentCommand(nodeVISUALID, dropLocation, droppedElement);
				}
				return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropLocation, droppedElement));
			}

		} else if((graphicalParentObject instanceof Behavior) && (((Behavior)graphicalParentObject).getOwnedParameters().contains(droppedElement))) {
			// Drop Parameter on Behavior
			if(isCompartmentTarget) {
				return getDropAffixedNodeInCompartmentCommand(nodeVISUALID, dropLocation, droppedElement);
			}
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropLocation, droppedElement));
		}

		return UnexecutableCommand.INSTANCE;
	}


	/**
	 * <pre>
	 * This method return a drop command for TopLevelNode. 
	 * It returns an {@link org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand} in
	 * case the element is dropped on a canvas referencing a domain element that is not a Package.
	 * </pre>
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticElement
	 *        the semantic element
	 * @param nodeVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @param linkVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropTopLevelNode(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID, int linkVISUALID) {

		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		if(graphicalParentObject instanceof org.eclipse.uml2.uml.Package) {
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), semanticElement));
		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * <pre>
	 * This method returns the drop command for AffixedNode (Port, Parameter) 
	 * in case the node is dropped on a ShapeCompartmentEditPart.
	 * </pre>
	 * 
	 * @param nodeVISUALID
	 *        the node visual identifier
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @return a CompositeCommand for Drop
	 */
	protected CompoundCommand getDropAffixedNodeInCompartmentCommand(int nodeVISUALID, Point location, EObject droppedObject) {
		CompoundCommand cc = new CompoundCommand("Drop");
		IAdaptable elementAdapter = new EObjectAdapter(droppedObject);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, true, getDiagramPreferencesHint());
		// Create the command targeting host parent (owner of the
		// ShapeCompartmentEditPart)
		CreateViewCommand createCommand = new CreateViewCommand(getEditingDomain(), descriptor, ((View)(getHost().getParent().getModel())));
		cc.add(new ICommandProxy(createCommand));

		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)createCommand.getCommandResult().getReturnValue(), location);
		cc.add(new ICommandProxy(setBoundsCommand));

		return cc;
	}


	/**
	 * Avoid dropped element to get orphaned for DND action resulting in a
	 * specific action (not a move).
	 *
	 * @param request the request
	 * @return the drag command
	 */
	@Override
	protected Command getDragCommand(ChangeBoundsRequest request) {

		Boolean isSpecificDrag = false;

		Iterator<?> iter = request.getEditParts().iterator();
		EObject graphicalParentObject = ((GraphicalEditPart)getHost()).resolveSemanticElement();
		while((graphicalParentObject != null) && (iter.hasNext())) {

			EObject droppedObject = null;
			EditPart droppedEditPart = (EditPart)iter.next();
			if(droppedEditPart instanceof GraphicalEditPart) {
				droppedObject = ((GraphicalEditPart)droppedEditPart).resolveSemanticElement();
			}

			isSpecificDrag = isSpecificDropActionExpected((GraphicalEditPart)getHost(), droppedObject);
		}

		if(isSpecificDrag) {
			return null;
		}

		return super.getDragCommand(request);
	}

	/**
	 * Gets the drop command.
	 *
	 * @param request the request
	 * @return the drop command
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy#getDropCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 */
	
	@Override
	protected Command getDropCommand(ChangeBoundsRequest request) {
		Boolean isSpecificDrop = false;

		Iterator<?> iter = request.getEditParts().iterator();
		EObject graphicalParentObject = ((GraphicalEditPart)getHost()).resolveSemanticElement();
		while((graphicalParentObject != null) && (iter.hasNext())) {
			EObject droppedObject = null;
			EditPart droppedEditPart = (EditPart)iter.next();
			if(droppedEditPart instanceof GraphicalEditPart) {
				droppedObject = ((GraphicalEditPart)droppedEditPart).resolveSemanticElement();
			}

			isSpecificDrop = isSpecificDropActionExpected((GraphicalEditPart)getHost(), droppedObject);
		}

		if(isSpecificDrop) {
			return getDropObjectsCommand(castToDropObjectsRequest(request));
		}

		return super.getDropCommand(request);
	}

	/**
	 * Test if a specific drop action shall is expected.
	 *
	 * @param graphicalParent the graphical parent
	 * @param droppedObject the dropped object
	 * @return true, if is specific drop action expected
	 */
	protected boolean isSpecificDropActionExpected(GraphicalEditPart graphicalParent, EObject droppedObject) {
		boolean isSpecificDropActionExpected = false;

		EObject graphicalParentObject = graphicalParent.resolveSemanticElement();
		if(graphicalParentObject != null) {

			if(graphicalParentObject instanceof Collaboration) {

				if((droppedObject instanceof Collaboration) || (droppedObject instanceof Class)) {
					isSpecificDropActionExpected = true;
				}

			} else if(graphicalParentObject instanceof StructuredClassifier) {

				if((droppedObject instanceof Collaboration) || (droppedObject instanceof Class)) {
					isSpecificDropActionExpected = true;
				}

			} else if(graphicalParentObject instanceof TypedElement) {

				if(droppedObject instanceof Type) {
					isSpecificDropActionExpected = true;
				}

			} else if(graphicalParentObject instanceof CollaborationUse) {

				if(droppedObject instanceof Collaboration) {
					isSpecificDropActionExpected = true;
				}
			}
		}

		return isSpecificDropActionExpected;
	}
}
