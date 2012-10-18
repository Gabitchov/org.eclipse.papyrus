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
 *   Vincent LORENZO (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.OldCommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.util.ViewServiceUtil;
import org.eclipse.papyrus.uml.diagram.communication.custom.commands.CommunicationDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.communication.custom.commands.CustomMessageViewCreateCommand;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.CommunicationLinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.CommunicationUtil;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.DiagramShortCutHelper;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.DurationObservationHelper;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.TimeObservationHelper;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.TimeObservationEditPartCN;
import org.eclipse.papyrus.uml.diagram.communication.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.communication.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.TimeObservation;


/**
 * A policy to support dNd from the Model Explorer in the communication diagram.
 */
public class CustomDiagramDragDropEditPolicy extends OldCommonDiagramDragDropEditPolicy {

	/**
	 * Instantiates a new custom diagram drag drop edit policy.
	 */
	public CustomDiagramDragDropEditPolicy() {
		super(CommunicationLinkMappingHelper.getInstance());

	}

	/**
	 * Gets the UML element type.
	 * 
	 * @param elementID
	 *        the element id
	 * @return the UML element type {@inheritDoc}
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
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy#getSpecificDropCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest,
	 *      org.eclipse.uml2.uml.Element, int, int)
	 * 
	 * @param dropRequest
	 * @param semanticElement
	 * @param nodeVISUALID
	 * @param linkVISUALID
	 * @return
	 */

	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID, int linkVISUALID) {


		switch(linkVISUALID) {
		case MessageEditPart.VISUAL_ID:

			return dropMessage(dropRequest, semanticElement, linkVISUALID);

		default:
			// Switch test over nodeVISUALID
			switch(nodeVISUALID) {
			case LifelineEditPartCN.VISUAL_ID:
				return dropChildNode(dropRequest, semanticElement, nodeVISUALID);
				//			case CommentEditPartCN.VISUAL_ID:
				//				return dropChildNode(dropRequest, semanticElement, nodeVISUALID);
				//			case ConstraintEditPartCN.VISUAL_ID:
				//				return dropChildNode(dropRequest, semanticElement, nodeVISUALID);
			case TimeObservationEditPartCN.VISUAL_ID:
				return dropTimeObservation(dropRequest, (TimeObservation)semanticElement, nodeVISUALID);
			case DurationObservationEditPartCN.VISUAL_ID:
				return dropDurationObservation(dropRequest, (DurationObservation)semanticElement, nodeVISUALID);
			case CommentEditPartCN.VISUAL_ID:
				return dropComment(dropRequest, semanticElement, nodeVISUALID);
			case ConstraintEditPartCN.VISUAL_ID:
				return dropConstraint(dropRequest, semanticElement, nodeVISUALID);
			default:
				return super.getSpecificDropCommand(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);

			}
		}
	}

	/**
	 * Returns the command to drop the Comment + the link to attach it to its annotated elements
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visual id
	 * 
	 * @return the command
	 */
	protected Command dropComment(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		if(!(graphicalParentObject instanceof Interaction)) {
			return UnexecutableCommand.INSTANCE;
		}
		return getDropCommentCommand((Comment)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView(), (IHintedType)UMLElementTypes.Comment_8005, (IHintedType)UMLElementTypes.CommentAnnotatedElement_8010);

	}

	/**
	 * Returns the command to drop the Constraint + the link to attach it to its contrainted elements
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visual id
	 * 
	 * @return the command
	 */
	protected Command dropConstraint(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		if(!(graphicalParentObject instanceof Interaction)) {
			return UnexecutableCommand.INSTANCE;
		}
		return getDropConstraintCommand((Constraint)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView(), (IHintedType)UMLElementTypes.Constraint_8004, (IHintedType)UMLElementTypes.ConstraintConstrainedElement_8011);
	}

	/**
	 * Returns the drop command for TimeObservation nodes.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param droppedElement
	 *        the element to drop
	 * @param nodeVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
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
	 * Returns the drop command for ShortCutDiagram nodes.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param droppedElement
	 *        the element to drop
	 * @param nodeVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropShortCutDiagram(DropObjectsRequest dropRequest, Diagram droppedElement, int nodeVISUALID) {

		// Test canvas element
		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		if(!(graphicalParentObject instanceof org.eclipse.uml2.uml.Interaction)) {
			return UnexecutableCommand.INSTANCE;
		}

		DiagramShortCutHelper diagramShortCutHelper = new DiagramShortCutHelper(getEditingDomain());

		return diagramShortCutHelper.dropDiagramShortCut(droppedElement, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
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
	 * @param droppedElement
	 *        the element to drop
	 * @param nodeVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
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

	public Command dropMessage(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {

		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();
		if(!(graphicalParentObject instanceof org.eclipse.uml2.uml.Interaction)) {
			return UnexecutableCommand.INSTANCE;
		}
		if(semanticLink instanceof Message) {//if the drop request concerns a UML message
			//1. verify if source and target of the message are already connected 
			Collection<?> sources = CommunicationLinkMappingHelper.getInstance().getSource(semanticLink);
			Collection<?> targets = CommunicationLinkMappingHelper.getInstance().getTarget(semanticLink);
			if(!sources.isEmpty() && !targets.isEmpty()) {
				Element source = (Element)sources.toArray()[0];
				Element target = (Element)targets.toArray()[0];
				if((source instanceof Lifeline) && (target instanceof Lifeline)) {
					Set<Message> messages = CommunicationUtil.verifyUMLLifelinesConnected((Lifeline)source, (Lifeline)target);
					if(!(messages == null) && (messages.size() >= 1)) {//the UML lifelines are already connected by one or more than one more message

						//1. search for the edit parts of the messages
						List<EditPart> messagesEP = null;
						for(Message current : messages) {
							EditPart messageEP = lookForEditPart(current);
							if(!(messageEP == null)) {
								if(messagesEP == null) {
									messagesEP = new ArrayList<EditPart>();
									messagesEP.add(messageEP);
								} else {
									messagesEP.add(messageEP);
								}

							}
						}
						//System.err.println("Messages edit parts on the link :" + messagesEP);
						//System.err.println("Semantic messages  on the link :" + messages);

						//2. Create the drop commands
						if(messagesEP == null) {//There is no graphical connection between the two lifelines (in  this diagram)
							//create a dropMessageAsConnector Command
							return new ICommandProxy(dropMessageAsConnector(new CompositeCommand("drop Message"), source, target, linkVISUALID, dropRequest.getLocation(), semanticLink)); //$NON-NLS-1$
						} else {//add the message as a label of the graphical connector
							ConnectionEditPart conEP = (ConnectionEditPart)messagesEP.get(0).getParent();
							IAdaptable linkAdapter = new SemanticAdapter(semanticLink, null);
							//location where the label will be dropped
							Point loc = new Point(1, -23);
							//reuse of the CustomMessageViewCreateCommand
							return new ICommandProxy(new CustomMessageViewCreateCommand(((IGraphicalEditPart)getHost()).getEditingDomain(), conEP.getViewer(), ((IGraphicalEditPart)conEP).getDiagramPreferencesHint(), loc, linkAdapter, conEP));

						}
					}
				}
			}

		}


		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * the method provides command to drop the messages into the diagram.
	 * If the source and the target views do not exist, these views will be created.
	 * 
	 * @param cc
	 *        the composite command that will contain the set of command to create the message
	 * @param source
	 *        the source the element source of the link
	 * @param target
	 *        the target the element target of the link
	 * @param linkVISUALID
	 *        the link VISUALID used to create the view
	 * @param location
	 *        the location the location where the view will be be created
	 * @param semanticLink
	 *        the semantic link that will be attached to the view
	 * 
	 * @return the composite command
	 */
	public CompositeCommand dropMessageAsConnector(CompositeCommand cc, Element source, Element target, int linkVISUALID, Point location, Element semanticLink) {
		// look for editpart
		GraphicalEditPart sourceEditPart = (GraphicalEditPart)lookForEditPart(source);
		GraphicalEditPart targetEditPart = (GraphicalEditPart)lookForEditPart(target);

		// descriptor of the link
		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(getUMLElementType(linkVISUALID), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), getDiagramPreferencesHint());

		IAdaptable sourceAdapter = null;
		IAdaptable targetAdapter = null;
		if(sourceEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(source), Node.class, null, ViewUtil.APPEND, true, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart)getHost()).getEditingDomain(), descriptor, ((View)getHost().getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y + 100)); //$NON-NLS-1$
			cc.compose(setBoundsCommand);

			sourceAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();
		} else {
			sourceAdapter = new SemanticAdapter(null, sourceEditPart.getModel());
		}
		if(targetEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(target), Node.class, null, ViewUtil.APPEND, true, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart)getHost()).getEditingDomain(), descriptor, ((View)getHost().getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y - 100)); //$NON-NLS-1$
			cc.compose(setBoundsCommand);
			targetAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();

		} else {
			targetAdapter = new SemanticAdapter(null, targetEditPart.getModel());
		}

		CommunicationDeferredCreateConnectionViewCommand aLinkCommand = new CommunicationDeferredCreateConnectionViewCommand(((IGraphicalEditPart)getHost()).getEditingDomain(), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), sourceAdapter, targetAdapter, getViewer(), getDiagramPreferencesHint(), linkdescriptor, null, semanticLink);

		cc.compose(aLinkCommand);

		return cc;

	}



	/**
	 * Gets the droppable element visual id.
	 * 
	 * @return the droppable element visual id
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy#getDroppableElementVisualId()
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
		elementsVisualId.add(ShortCutDiagramEditPart.VISUAL_ID);
		// handle nodes on messages (no visual ID detected for them)
		elementsVisualId.add(-1);
		return elementsVisualId;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy#getDropObjectsCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest)
	 * 
	 * @param dropRequest
	 * @return the drop command
	 */

	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		ViewServiceUtil.forceLoad();

		// Create a view request from the drop request and then forward getting
		// the command for that.
		CompositeCommand cc = new CompositeCommand("Drop"); //$NON-NLS-1$
		Iterator<?> iter = dropRequest.getObjects().iterator();
		if(dropRequest.getObjects().size() > 0 && dropRequest.getObjects().get(0) instanceof String) {
			return getDropFileCommand(dropRequest);
		}
		Point location = dropRequest.getLocation().getCopy();
		((GraphicalEditPart)getHost()).getContentPane().translateToRelative(location);
		((GraphicalEditPart)getHost()).getContentPane().translateFromParent(location);
		location.translate(((GraphicalEditPart)getHost()).getContentPane().getClientArea().getLocation().getNegated());
		while(iter.hasNext()) {
			EObject droppedObject = (EObject)iter.next();
			int nodeVISUALID = getNodeVisualID(((IGraphicalEditPart)getHost()).getNotationView(), droppedObject);
			int linkVISUALID = getLinkWithClassVisualID(droppedObject);
			if(getDroppableElementVisualId().contains(nodeVISUALID) || getDroppableElementVisualId().contains(linkVISUALID)) {
				dropRequest.setLocation(location);
				// TODO: add to composite command ?
				if(nodeVISUALID == -1 && linkVISUALID == -1 && (droppedObject instanceof Diagram)) {//if the dropped element is the diagram short cut
					cc.add(new CommandProxy(dropShortCutDiagram(dropRequest, (Diagram)droppedObject, nodeVISUALID)));
				} else {
					cc.add(new CommandProxy(getSpecificDropCommand(dropRequest, (Element)droppedObject, nodeVISUALID, linkVISUALID)));
				}
				continue;
			}

			if(linkVISUALID == -1 && nodeVISUALID != -1) {
				// The element to drop is a node
				// Retrieve it's expected graphical parent
				EObject graphicalParent = ((GraphicalEditPart)getHost()).resolveSemanticElement();

				// Restrict the default node creation to the following cases:
				// . Take the containment relationship into consideration
				// . Release the constraint when GraphicalParent is a Package (Canvas for most
				// diagrams)
				if(graphicalParent instanceof Package) {
					cc.add(getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject));

				} else {
					if((graphicalParent instanceof Element) && ((Element)graphicalParent).getOwnedElements().contains(droppedObject)) {
						cc.add(getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject));

					} else {
						return UnexecutableCommand.INSTANCE;
					}
				}

			} else {
				if(linkVISUALID != -1) {
					Collection<?> sources = linkmappingHelper.getSource((Element)droppedObject);
					Collection<?> targets = linkmappingHelper.getTarget((Element)droppedObject);
					if(sources.size() == 0 || targets.size() == 0) {
						return UnexecutableCommand.INSTANCE;
					}
					// binary association
					Element source = (Element)sources.toArray()[0];
					Element target = (Element)targets.toArray()[0];
					dropBinaryLink(cc, source, target, linkVISUALID, dropRequest.getLocation(), (Element)droppedObject);
				}
			}
		}

		return new ICommandProxy(cc);

	}
}
