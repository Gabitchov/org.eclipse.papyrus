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

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.sequence.edit.commands.ActionExecutionSpecificationCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.BehaviorExecutionSpecificationCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CombinedFragment2CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CommentAnnotatedElementCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.CommentAnnotatedElementReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.DestructionEventCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.DurationConstraintCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.DurationObservationCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.LifelineCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message2CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message2ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message3CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message3ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message4CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message4ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message5CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message5ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message6CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message6ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message7CreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.Message7ReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.StateInvariantCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.TimeConstraintCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.TimeObservationCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DestructionEventEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.DurationConstraintEditPart;
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
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * @generated
 */
public class LifelineItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public LifelineItemSemanticEditPolicy() {
		super(UMLElementTypes.Lifeline_3001);
	}

	/**
	 * Generated not for add lifelines on lifeline
	 * 
	 * @generated NOT (update at each lifeline modification) add lifelines, add DurationObservation/Constraint
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.ActionExecutionSpecification_3006 == req.getElementType()) {
			return getGEFWrapper(new ActionExecutionSpecificationCreateCommand(req));
		}
		if(UMLElementTypes.BehaviorExecutionSpecification_3003 == req.getElementType()) {
			return getGEFWrapper(new BehaviorExecutionSpecificationCreateCommand(req));
		}
		if(UMLElementTypes.StateInvariant_3017 == req.getElementType()) {
			return getGEFWrapper(new StateInvariantCreateCommand(req));
		}
		if(UMLElementTypes.CombinedFragment_3018 == req.getElementType()) {
			return getGEFWrapper(new CombinedFragment2CreateCommand(req));
		}
		if(UMLElementTypes.TimeConstraint_3019 == req.getElementType()) {
			return getGEFWrapper(new TimeConstraintCreateCommand(req));
		}
		if(UMLElementTypes.TimeObservation_3020 == req.getElementType()) {
			return getGEFWrapper(new TimeObservationCreateCommand(req));
		}
		if(UMLElementTypes.DurationConstraint_3021 == req.getElementType()) {
			return getGEFWrapper(new DurationConstraintCreateCommand(req));
		}
		if(UMLElementTypes.DestructionEvent_3022 == req.getElementType()) {
			return getGEFWrapper(new DestructionEventCreateCommand(req));
		}
		//add lifelines
		if(UMLElementTypes.Lifeline_3001 == req.getElementType()) {
			LifelineEditPart lifelineEditPart = (LifelineEditPart)getHost();
			if(lifelineEditPart.isInlineCapability()) {
				LifelineCreateCommand cmd = new LifelineCreateCommand(req);
				cmd.setAvailableProperties(lifelineEditPart.getAvailableProperties());
				return getGEFWrapper(cmd);
			}
		}
		//add DurationObservation/Constraint
		if(UMLElementTypes.DurationConstraint_3023 == req.getElementType()) {
			return getGEFWrapper(new DurationConstraintCreateCommand(req));
		}
		if(UMLElementTypes.DurationObservation_3024 == req.getElementType()) {
			return getGEFWrapper(new DurationObservationCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * Also delete occurrence specification linked with the lifeline
	 * 
	 * @generated NOT (update at each lifeline modification) Destroy all the OccurenceSpecification linked with this lifeline
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View)getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for(Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge)it.next();
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == MessageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == Message2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == Message3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == Message4EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == Message5EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == Message6EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == Message7EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == CommentAnnotatedElementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(incomingLink) == ConstraintConstrainedElementEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for(Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge)it.next();
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == MessageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == Message2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == Message3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == Message4EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == Message5EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == Message6EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if(UMLVisualIDRegistry.getVisualID(outgoingLink) == Message7EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if(annotation == null) {
			// there are indirectly referenced children, need extra commands: true
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}

		// Destroy all the OccurenceSpecification linked with this lifeline
		EObject eObject = ViewUtil.resolveSemanticElement(view);
		if(eObject instanceof Lifeline) {
			Lifeline lifeline = (Lifeline)eObject;
			for(InteractionFragment ift : lifeline.getCoveredBys()) {
				if(ift instanceof OccurrenceSpecification) {
					DestroyElementRequest r = new DestroyElementRequest(ift, false);
					cmd.add(new DestroyElementCommand(r));
				}
			}
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
			case ActionExecutionSpecificationEditPart.VISUAL_ID:


				for(Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
					case CommentAnnotatedElementEditPart.VISUAL_ID:
					case ConstraintConstrainedElementEditPart.VISUAL_ID:
						DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(destroyRefReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					}
				}

				for(Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: false
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case BehaviorExecutionSpecificationEditPart.VISUAL_ID:


				for(Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
					case CommentAnnotatedElementEditPart.VISUAL_ID:
					case ConstraintConstrainedElementEditPart.VISUAL_ID:
						DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(destroyRefReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					}
				}

				for(Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: false
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case StateInvariantEditPart.VISUAL_ID:


				for(Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
					case CommentAnnotatedElementEditPart.VISUAL_ID:
					case ConstraintConstrainedElementEditPart.VISUAL_ID:
						DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(destroyRefReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					}
				}

				for(Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: false
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case CombinedFragment2EditPart.VISUAL_ID:


				for(Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
					case CommentAnnotatedElementEditPart.VISUAL_ID:
					case ConstraintConstrainedElementEditPart.VISUAL_ID:
						DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(destroyRefReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					}
				}

				for(Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: false
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case TimeConstraintEditPart.VISUAL_ID:


				for(Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
					case CommentAnnotatedElementEditPart.VISUAL_ID:
					case ConstraintConstrainedElementEditPart.VISUAL_ID:
						DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(destroyRefReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					}
				}

				for(Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
					case ConstraintConstrainedElementEditPart.VISUAL_ID:
						DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(destroyRefReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: false
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case TimeObservationEditPart.VISUAL_ID:


				for(Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
					case CommentAnnotatedElementEditPart.VISUAL_ID:
					case ConstraintConstrainedElementEditPart.VISUAL_ID:
						DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(destroyRefReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					}
				}

				for(Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: false
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case DurationConstraintEditPart.VISUAL_ID:


				for(Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
					case CommentAnnotatedElementEditPart.VISUAL_ID:
					case ConstraintConstrainedElementEditPart.VISUAL_ID:
						DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(destroyRefReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					}
				}

				for(Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
					case ConstraintConstrainedElementEditPart.VISUAL_ID:
						DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(destroyRefReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: false
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case DestructionEventEditPart.VISUAL_ID:


				for(Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
					case CommentAnnotatedElementEditPart.VISUAL_ID:
					case ConstraintConstrainedElementEditPart.VISUAL_ID:
						DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
						cmd.add(new DestroyReferenceCommand(destroyRefReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					}
				}

				for(Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
					case MessageEditPart.VISUAL_ID:
					case Message2EditPart.VISUAL_ID:
					case Message3EditPart.VISUAL_ID:
					case Message4EditPart.VISUAL_ID:
					case Message5EditPart.VISUAL_ID:
					case Message6EditPart.VISUAL_ID:
					case Message7EditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: false
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			}
		}
	}

	/**
	 * Create destroy command for sub lifelines
	 * 
	 * @param cmd
	 *        The command
	 */
	private void addDestroyChildLifelineNodesCommand(CompositeTransactionalCommand cmd) {
		if(getHost() instanceof LifelineEditPart) {
			LifelineEditPart lifelineEditPart = (LifelineEditPart)getHost();
			for(LifelineEditPart childLifelineEditPart : lifelineEditPart.getInnerConnectableElementList()) {
				DestroyElementRequest destroyRequest = new DestroyElementRequest(childLifelineEditPart.getEditingDomain(), lifelineEditPart.resolveSemanticElement(), false);
				cmd.add(new CommandProxy(childLifelineEditPart.getCommand(new EditCommandRequestWrapper(destroyRequest))));
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
		if(UMLElementTypes.Message_4003 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4004 == req.getElementType()) {
			return getGEFWrapper(new Message2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4005 == req.getElementType()) {
			return getGEFWrapper(new Message3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4006 == req.getElementType()) {
			return getGEFWrapper(new Message4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4007 == req.getElementType()) {
			return getGEFWrapper(new Message5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4008 == req.getElementType()) {
			return getGEFWrapper(new Message6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4009 == req.getElementType()) {
			return getGEFWrapper(new Message7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_4010 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ConstraintConstrainedElement_4011 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Message_4003 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4004 == req.getElementType()) {
			return getGEFWrapper(new Message2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4005 == req.getElementType()) {
			return getGEFWrapper(new Message3CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4006 == req.getElementType()) {
			return getGEFWrapper(new Message4CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4007 == req.getElementType()) {
			return getGEFWrapper(new Message5CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4008 == req.getElementType()) {
			return getGEFWrapper(new Message6CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Message_4009 == req.getElementType()) {
			return getGEFWrapper(new Message7CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.CommentAnnotatedElement_4010 == req.getElementType()) {
			return getGEFWrapper(new CommentAnnotatedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ConstraintConstrainedElement_4011 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source should be the domain
	 * model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case MessageEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageReorientCommand(req));
		case Message2EditPart.VISUAL_ID:
			return getGEFWrapper(new Message2ReorientCommand(req));
		case Message3EditPart.VISUAL_ID:
			return getGEFWrapper(new Message3ReorientCommand(req));
		case Message4EditPart.VISUAL_ID:
			return getGEFWrapper(new Message4ReorientCommand(req));
		case Message5EditPart.VISUAL_ID:
			return getGEFWrapper(new Message5ReorientCommand(req));
		case Message6EditPart.VISUAL_ID:
			return getGEFWrapper(new Message6ReorientCommand(req));
		case Message7EditPart.VISUAL_ID:
			return getGEFWrapper(new Message7ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch(getVisualID(req)) {
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new CommentAnnotatedElementReorientCommand(req));
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
