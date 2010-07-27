/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.command.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.diagram.communication.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConnectorDurationObservationCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConnectorDurationObservationReorientCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConnectorTimeObservationCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConnectorTimeObservationReorientCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.MessageCreateCommand;
import org.eclipse.papyrus.diagram.communication.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.diagram.communication.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConnectorDurationObservationEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConnectorTimeObservationEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.InteractionCompartmentEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.TimeObservationEditPartCN;
import org.eclipse.papyrus.diagram.communication.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes;

/**
 * @generated
 */
public class InteractionItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InteractionItemSemanticEditPolicy() {
		super(UMLElementTypes.Interaction_8002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View)getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(true);

		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if(annotation == null) {
			// there are indirectly referenced children, need extra commands: true
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			List<EObject> todestroy = new ArrayList<EObject>();
			todestroy.add(req.getElementToDestroy());
			//cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));
			cmd.add(new EMFtoGMFCommandWrapper(new org.eclipse.emf.edit.command.DeleteCommand(getEditingDomain(), todestroy)));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View)getHost().getModel();
		for(Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node)nit.next();
			switch(UMLVisualIDRegistry.getVisualID(node)) {
			case InteractionCompartmentEditPart.VISUAL_ID:
				for(Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node)cit.next();
					switch(UMLVisualIDRegistry.getVisualID(cnode)) {
					case LifelineEditPartCN.VISUAL_ID:


						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case CommentAnnotatedElementEditPart.VISUAL_ID:
							case ConstraintConstrainedElementEditPart.VISUAL_ID:
							case ConnectorDurationObservationEditPart.VISUAL_ID:
							case ConnectorTimeObservationEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							case MessageEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case MessageEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							}
						}
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case CommentEditPartCN.VISUAL_ID:


						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case CommentAnnotatedElementEditPart.VISUAL_ID:
							case ConstraintConstrainedElementEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							case MessageEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case CommentAnnotatedElementEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case MessageEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							}
						}
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case ConstraintEditPartCN.VISUAL_ID:


						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case CommentAnnotatedElementEditPart.VISUAL_ID:
							case ConstraintConstrainedElementEditPart.VISUAL_ID:
							case ConnectorDurationObservationEditPart.VISUAL_ID:
							case ConnectorTimeObservationEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							case MessageEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ConstraintConstrainedElementEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case MessageEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							}
						}
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case TimeObservationEditPartCN.VISUAL_ID:


						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case CommentAnnotatedElementEditPart.VISUAL_ID:
							case ConstraintConstrainedElementEditPart.VISUAL_ID:
							case ConnectorDurationObservationEditPart.VISUAL_ID:
							case ConnectorTimeObservationEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							case MessageEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ConnectorTimeObservationEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case MessageEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							}
						}
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: false
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case DurationObservationEditPartCN.VISUAL_ID:


						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case CommentAnnotatedElementEditPart.VISUAL_ID:
							case ConstraintConstrainedElementEditPart.VISUAL_ID:
							case ConnectorDurationObservationEditPart.VISUAL_ID:
							case ConnectorTimeObservationEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							case MessageEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ConnectorDurationObservationEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case MessageEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							}
						}
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: false
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_8009 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_8010 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ConstraintConstrainedElement_8011 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.DurationObservationEvent_8012 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.TimeObservationEvent_8013 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_8009 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_8010 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ConstraintConstrainedElement_8011 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.DurationObservationEvent_8012 == req.getElementType()) {
			return getGEFWrapper(new ConnectorDurationObservationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.TimeObservationEvent_8013 == req.getElementType()) {
			return getGEFWrapper(new ConnectorTimeObservationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case MessageEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or
	 * source should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		case ConnectorDurationObservationEditPart.VISUAL_ID:
			return getGEFWrapper(new ConnectorDurationObservationReorientCommand(req));
		case ConnectorTimeObservationEditPart.VISUAL_ID:
			return getGEFWrapper(new ConnectorTimeObservationReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
