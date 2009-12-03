/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.edit.policies;

import java.util.Collection;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.composite.custom.helper.CompositeLinkMappingHelper;
import org.eclipse.papyrus.diagram.composite.custom.helper.ConnectorHelper;
import org.eclipse.papyrus.diagram.composite.custom.helper.DurationObservationHelper;
import org.eclipse.papyrus.diagram.composite.custom.helper.TimeObservationHelper;
import org.eclipse.papyrus.diagram.composite.edit.parts.ConnectorEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.PortEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.PropertyPartEditPartCN;
import org.eclipse.papyrus.diagram.composite.edit.parts.RoleBindingEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Type;

/**
 * This class provides an implementation for specific behavior of Drag and Drop in the Composite
 * Diagram.
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** List of VISUAL_ID for which a specific Drop behavior is provided */
	public int[] secificDropNode = { DependencyEditPart.VISUAL_ID, RoleBindingEditPart.VISUAL_ID,
			ConnectorEditPart.VISUAL_ID, PortEditPart.VISUAL_ID, PropertyPartEditPartCN.VISUAL_ID,
			TimeObservationEditPart.VISUAL_ID, DurationObservationEditPart.VISUAL_ID };

	/**
	 * Default constructor
	 */
	public CustomDiagramDragDropEditPolicy() {
		super(CompositeLinkMappingHelper.getInstance());
		init(secificDropNode);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID,
			int linkVISUALID) {

		// Retrieve drop location
		Point location = dropRequest.getLocation().getCopy();
		((GraphicalEditPart) getHost()).getContentPane().translateToRelative(location);
		((GraphicalEditPart) getHost()).getContentPane().translateFromParent(location);
		location.translate(((GraphicalEditPart) getHost()).getContentPane().getClientArea().getLocation().getNegated());

		// Switch test over linkVisualID
		switch (linkVISUALID) {
		case DependencyEditPart.VISUAL_ID:
			return dropDependency(dropRequest, semanticElement, linkVISUALID);
		case RoleBindingEditPart.VISUAL_ID:
			return dropRoleBinding(dropRequest, semanticElement, linkVISUALID);
		case ConnectorEditPart.VISUAL_ID:
			return dropConnector(dropRequest, semanticElement, linkVISUALID);
		default:
			// Switch test over nodeVISUALID
			switch (nodeVISUALID) {
			case PortEditPart.VISUAL_ID:
				return dropPort(dropRequest, location, (Port) semanticElement, nodeVISUALID);
			case PropertyPartEditPartCN.VISUAL_ID:
				return dropProperty(dropRequest, location, (Property) semanticElement, nodeVISUALID);
			case TimeObservationEditPart.VISUAL_ID:
				return dropTimeObservation(dropRequest, location, (TimeObservation) semanticElement, nodeVISUALID);
			case DurationObservationEditPart.VISUAL_ID:
				return dropDurationObservation(dropRequest, location, (DurationObservation) semanticElement,
						nodeVISUALID);
			default:
				return super.getSpecificDropCommand(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);
			}
		}
	}

	/**
	 * Returns the drop command for Dependency links.
	 * 
	 * @param dropRequest
	 *            the drop request
	 * @param semanticLink
	 *            the element to drop
	 * @param linkVISUALID
	 *            the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropDependency(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sourceEnds = CompositeLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targetEnds = CompositeLinkMappingHelper.getInstance().getTarget(semanticLink);

		// Dependency with Unary ends
		if ((sourceEnds != null) && (targetEnds != null) && (sourceEnds.size() == 1) && (targetEnds.size() == 1)) {

			Element source = (Element) sourceEnds.toArray()[0];
			Element target = (Element) targetEnds.toArray()[0];
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
	 *            the drop request
	 * @param semanticLink
	 *            the element to drop
	 * @param linkVISUALID
	 *            the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropRoleBinding(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sourceEnds = CompositeLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targetEnds = CompositeLinkMappingHelper.getInstance().getTarget(semanticLink);

		// Dependency with Unary ends
		if ((sourceEnds != null) && (targetEnds != null) && (sourceEnds.size() == 1) && (targetEnds.size() == 1)) {

			Element source = (Element) semanticLink.getOwner();
			Element target = (Element) targetEnds.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop RoleBinding"), source, target, //$NON-NLS-1$
					linkVISUALID, dropRequest.getLocation(), semanticLink));
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * Returns the drop command for Connector links.
	 * 
	 * @param dropRequest
	 *            the drop request
	 * @param semanticLink
	 *            the element to drop
	 * @param linkVISUALID
	 *            the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropConnector(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> connectorEnds = CompositeLinkMappingHelper.getInstance().getSource(semanticLink);

		if ((connectorEnds != null) && (connectorEnds.size() == 2)) {

			ConnectorHelper helper = new ConnectorHelper(getEditingDomain());
			return new ICommandProxy(helper.dropConnector((Connector) semanticLink, linkVISUALID, getViewer(),
					getHost(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart) getHost())
							.getNotationView()));
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * Returns the drop command for Property nodes.
	 * 
	 * @param dropRequest
	 *            the drop request
	 * @param location
	 *            the location to drop the element
	 * @param droppedElement
	 *            the element to drop
	 * @param nodeVISUALID
	 *            the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropProperty(DropObjectsRequest dropRequest, Point location, Property droppedElement,
			int nodeVISUALID) {

		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart) getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();

		// Port inherits from Property this case should be excluded and treated separately
		if (!(droppedElement instanceof Port)) {

			if ((graphicalParentObject instanceof Classifier)
					&& (((Classifier) graphicalParentObject).getAttributes().contains(droppedElement))) {
				// The graphical parent is the real owner of the dropped property.
				return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, droppedElement));

			} else if (graphicalParentObject instanceof ConnectableElement) {
				Type type = ((ConnectableElement) graphicalParentObject).getType();
				if ((type != null) && (type instanceof Classifier)
						&& (((Classifier) type).getAttributes().contains(droppedElement))) {
					// The graphical parent is a Property typed by a Classifier that owns of the
					// dropped property.
					return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, droppedElement));
				}
			}
		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Returns the drop command for Port nodes.
	 * 
	 * @param dropRequest
	 *            the drop request
	 * @param location
	 *            the location to drop the element
	 * @param droppedElement
	 *            the element to drop
	 * @param nodeVISUALID
	 *            the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropPort(DropObjectsRequest dropRequest, Point location, Port droppedElement, int nodeVISUALID) {

		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart) getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();

		if ((graphicalParentObject instanceof EncapsulatedClassifier)
				&& (((EncapsulatedClassifier) graphicalParentObject).getOwnedPorts().contains(droppedElement))) {
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, droppedElement));

		} else if (graphicalParentObject instanceof ConnectableElement) {
			Type type = ((ConnectableElement) graphicalParentObject).getType();

			if ((type != null) && (type instanceof EncapsulatedClassifier)
					&& (((EncapsulatedClassifier) type).getOwnedPorts().contains(droppedElement))) {
				return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, location, droppedElement));
			}
		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Returns the drop command for DurationObservation nodes.
	 * 
	 * @param dropRequest
	 *            the drop request
	 * @param location
	 *            the location to drop the element
	 * @param droppedElement
	 *            the element to drop
	 * @param nodeVISUALID
	 *            the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 * 
	 */
	protected Command dropDurationObservation(DropObjectsRequest dropRequest, Point location,
			DurationObservation droppedElement, int nodeVISUALID) {

		DurationObservationHelper durationObservationHelper = new DurationObservationHelper(getEditingDomain());
		return durationObservationHelper.dropDurationObservation((DurationObservation) droppedElement, getViewer(),
				getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart) getHost())
						.getNotationView());

	}

	/**
	 * Returns the drop command for TimeObservation nodes.
	 * 
	 * @param dropRequest
	 *            the drop request
	 * @param location
	 *            the location to drop the element
	 * @param droppedElement
	 *            the element to drop
	 * @param nodeVISUALID
	 *            the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 * 
	 */
	protected Command dropTimeObservation(DropObjectsRequest dropRequest, Point location,
			TimeObservation droppedElement, int nodeVISUALID) {

		TimeObservationHelper timeObservationHelper = new TimeObservationHelper(getEditingDomain());
		return timeObservationHelper.dropTimeObservation((TimeObservation) droppedElement, getViewer(),
				getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart) getHost())
						.getNotationView());
	}

}
