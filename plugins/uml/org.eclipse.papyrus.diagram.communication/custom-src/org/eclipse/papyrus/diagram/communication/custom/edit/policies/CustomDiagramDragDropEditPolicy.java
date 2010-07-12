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

 *   Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
import org.eclipse.papyrus.diagram.communication.custom.util.CommunicationLinkMappingHelper;
import org.eclipse.papyrus.diagram.communication.custom.util.DurationObservationHelper;
import org.eclipse.papyrus.diagram.communication.custom.util.TimeObservationHelper;
import org.eclipse.papyrus.diagram.communication.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.TimeObservationEditPartCN;
import org.eclipse.papyrus.diagram.communication.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * A policy to support dNd from the Model Explorer in the communication diagram
 * 
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** The specific drop node. */
	// public int[] specificDropNode = { MessageEditPart.VISUAL_ID };

	public CustomDiagramDragDropEditPolicy() {
		super(CommunicationLinkMappingHelper.getInstance());

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

		int i = 0;
		switch(linkVISUALID) {
		case MessageEditPart.VISUAL_ID:

			return dropMessage(dropRequest, semanticElement, linkVISUALID);

		default:
			// Switch test over nodeVISUALID
			switch(nodeVISUALID) {
			case LifelineEditPartCN.VISUAL_ID:
				return dropChildNode(dropRequest, semanticElement, nodeVISUALID);
			case CommentEditPartCN.VISUAL_ID:
				return dropChildNode(dropRequest, semanticElement, nodeVISUALID);
			case ConstraintEditPartCN.VISUAL_ID:
				return dropChildNode(dropRequest, semanticElement, nodeVISUALID);
			case TimeObservationEditPartCN.VISUAL_ID:
				return dropTimeObservation(dropRequest, (TimeObservation)semanticElement, nodeVISUALID);
			case DurationObservationEditPartCN.VISUAL_ID:
				return dropDurationObservation(dropRequest, (DurationObservation)semanticElement, nodeVISUALID);

			default:
				return super.getSpecificDropCommand(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);

			}
		}


	}

	/**
	 * Returns the drop command for TimeObservation nodes.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param location
	 *        the location to drop the element
	 * @param droppedElement
	 *        the element to drop
	 * @param nodeVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 * 
	 */
	protected Command dropTimeObservation(DropObjectsRequest dropRequest, TimeObservation droppedElement, int nodeVISUALID) {

		// Test canvas element
		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		if(!(graphicalParentObject instanceof org.eclipse.uml2.uml.Interaction)) {
			return UnexecutableCommand.INSTANCE;
		}

		TimeObservationHelper timeObservationHelper = new TimeObservationHelper(getEditingDomain());
		return timeObservationHelper.dropTimeObservation(droppedElement, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
	}




	/**
	 * <pre>
	 * This method return a drop command for a childnode (comment or constraint). 
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
	 * 
	 * @return the drop command
	 */
	protected Command dropChildNode(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID) {

		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		if(graphicalParentObject instanceof org.eclipse.uml2.uml.Interaction) {
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), semanticElement));
		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Returns the drop command for DurationObservation nodes.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param location
	 *        the location to drop the element
	 * @param droppedElement
	 *        the element to drop
	 * @param nodeVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 * 
	 */
	protected Command dropDurationObservation(DropObjectsRequest dropRequest, DurationObservation droppedElement, int nodeVISUALID) {

		// Test canvas element
		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		if(!(graphicalParentObject instanceof org.eclipse.uml2.uml.Interaction)) {
			return UnexecutableCommand.INSTANCE;
		}

		DurationObservationHelper durationObservationHelper = new DurationObservationHelper(getEditingDomain());
		return durationObservationHelper.dropDurationObservation(droppedElement, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());

	}

	/**
	 * Returns the drop command for Message links.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * 
	 * @param semanticLink
	 *        the link to drop
	 * @param linkVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 * 
	 */

	private Command dropMessage(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		// Test canvas element
		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		if(!(graphicalParentObject instanceof org.eclipse.uml2.uml.Interaction)) {
			return UnexecutableCommand.INSTANCE;
		}

		Collection<?> sources = CommunicationLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targets = CommunicationLinkMappingHelper.getInstance().getTarget(semanticLink);
		if(!sources.isEmpty() && !targets.isEmpty()) {
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Message"), source, target, linkVISUALID, dropRequest.getLocation(), semanticLink)); //$NON-NLS-1$
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy#getDroppableElementVisualId()
	 * 
	 * @return
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		// TODO Auto-generated method stub
		Set<Integer> elementsVisualId = new HashSet<Integer>();
		elementsVisualId.add(MessageEditPart.VISUAL_ID);
		elementsVisualId.add(CommentEditPartCN.VISUAL_ID);
		elementsVisualId.add(ConstraintEditPartCN.VISUAL_ID);
		elementsVisualId.add(LifelineEditPartCN.VISUAL_ID);
		elementsVisualId.add(TimeObservationEditPartCN.VISUAL_ID);
		elementsVisualId.add(DurationObservationEditPartCN.VISUAL_ID);
		// handle nodes on messages (no visual ID detected for them)
		elementsVisualId.add(-1);
		return elementsVisualId;
	}
}
