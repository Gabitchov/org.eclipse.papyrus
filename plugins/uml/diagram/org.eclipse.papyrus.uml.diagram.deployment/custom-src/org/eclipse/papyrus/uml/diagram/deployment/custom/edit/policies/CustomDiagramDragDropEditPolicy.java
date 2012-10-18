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
package org.eclipse.papyrus.uml.diagram.deployment.custom.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
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
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.OldCommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.deployment.custom.edit.command.CreateViewCommand;
import org.eclipse.papyrus.uml.diagram.deployment.custom.edit.helpers.DeploymentLinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;

// TODO: Auto-generated Javadoc
/**
 * This class provides an implementation for specific behavior of Drag and Drop in the Composite Diagram.
 */
public class CustomDiagramDragDropEditPolicy extends OldCommonDiagramDragDropEditPolicy {

	/**
	 * Default constructor.
	 */
	public CustomDiagramDragDropEditPolicy() {
		super(DeploymentLinkMappingHelper.getInstance());
	}

	/**
	 * Gets the droppable element visual id.
	 * 
	 * @return the droppable element visual id {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		// TopLevelNodes
		Set<Integer> droppableElementsVisualId = new HashSet<Integer>();
		droppableElementsVisualId.add(NodeEditPart.VISUAL_ID);
		droppableElementsVisualId.add(DeviceEditPart.VISUAL_ID);
		droppableElementsVisualId.add(ExecutionEnvironmentEditPart.VISUAL_ID);
		droppableElementsVisualId.add(ArtifactEditPart.VISUAL_ID);
		droppableElementsVisualId.add(CommentEditPart.VISUAL_ID);
		droppableElementsVisualId.add(ConstraintEditPart.VISUAL_ID);

		// Class CN
		droppableElementsVisualId.add(ArtifactEditPartCN.VISUAL_ID);
		droppableElementsVisualId.add(ArtifactEditPartACN.VISUAL_ID);
		droppableElementsVisualId.add(NodeEditPartCN.VISUAL_ID);
		droppableElementsVisualId.add(DeviceEditPartCN.VISUAL_ID);
		droppableElementsVisualId.add(ExecutionEnvironmentEditPartCN.VISUAL_ID);

		return droppableElementsVisualId;
	}

	/**
	 * Gets the uML element type.
	 * 
	 * @param elementID
	 *        the element id
	 * @return the uML element type {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	/**
	 * Gets the node visual id.
	 * 
	 * @param containerView
	 *        the container view
	 * @param domainElement
	 *        the domain element
	 * @return the node visual id {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * Gets the link with class visual id.
	 * 
	 * @param domainElement
	 *        the domain element
	 * @return the link with class visual id {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	/**
	 * Gets the specific drop command.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticElement
	 *        the semantic element
	 * @param nodeVISUALID
	 *        the node visualid
	 * @param linkVISUALID
	 *        the link visualid
	 * @return the specific drop command {@inheritDoc}
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
			case NodeEditPart.VISUAL_ID:
			case DeviceEditPart.VISUAL_ID:
			case ExecutionEnvironmentEditPart.VISUAL_ID:
			case ArtifactEditPart.VISUAL_ID:
				return dropTopLevelNode(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);
				// Test TopLevelNode... End
			case CommentEditPart.VISUAL_ID:
			case ConstraintEditPart.VISUAL_ID:

			default:
				return super.getSpecificDropCommand(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);
			}
		}
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
		Collection<?> sourceEnds = DeploymentLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targetEnds = DeploymentLinkMappingHelper.getInstance().getTarget(semanticLink);

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
	 * Returns the drop command for Property nodes.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param droppedElement
	 *        the element to drop
	 * @param nodeVISUALID
	 *        the visual identifier of the EditPart of the dropped element
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
	 * Avoid dropped element to get orphaned for DND action resulting in a specific action (not a move).
	 * 
	 * @param request
	 *        the request
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
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy#getDropCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 * @param request
	 * @return
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
	 * @param graphicalParent
	 *        the graphical parent
	 * @param droppedObject
	 *        the dropped object
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
