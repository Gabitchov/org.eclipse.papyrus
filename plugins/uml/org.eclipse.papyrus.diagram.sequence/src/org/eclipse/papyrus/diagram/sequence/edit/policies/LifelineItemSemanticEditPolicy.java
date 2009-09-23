/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.CreateElementAndInitializeFeatureCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.ActionExecutionSpecificationCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.BehaviorExecutionSpecificationCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageCreateCommand;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

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
	 * For BES
	 * 
	 * @generated NOT
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.BehaviorExecutionSpecification_3003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getInteraction_Fragment());
			}

			// Added to initialize the property "Covered" of the new
			// BehaviourExecutionSpecification
			CreateElementCommand behaviourCmd = new BehaviorExecutionSpecificationCreateCommand(req);
			EReference feature = UMLPackage.eINSTANCE.getInteractionFragment_Covered();
			Object value = req.getContainer();
			return new CreateElementAndInitializeFeatureCommand(behaviourCmd, feature, value);

			/*
			 * return getGEFWrapper(new BehaviorExecutionSpecificationCreateCommand( req));
			 */
		} else if (UMLElementTypes.ActionExecutionSpecification_3006 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getInteraction_Fragment());
			}

			// Added to initialize the property "Covered" of the new
			// ActionExecutionSpecification
			CreateElementCommand actionCmd = new ActionExecutionSpecificationCreateCommand(req);
			EReference feature = UMLPackage.eINSTANCE.getInteractionFragment_Covered();
			Object value = req.getContainer();
			return new CreateElementAndInitializeFeatureCommand(actionCmd, feature, value);

			/*
			 * return getGEFWrapper(new ActionExecutionSpecificationCreateCommand( req));
			 */
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (UMLVisualIDRegistry.getVisualID(incomingLink) == MessageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (UMLVisualIDRegistry.getVisualID(outgoingLink) == MessageEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: true
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (UMLVisualIDRegistry.getVisualID(node)) {
			case ActionExecutionSpecificationEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(),
						false))); // directlyOwned: false
				// don't need explicit deletion of node as parent's view deletion would clean child
				// views as well
				// cmd.add(new
				// org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
				// node));
				break;
			case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
				for (Iterator it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(incomingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				for (Iterator it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (UMLVisualIDRegistry.getVisualID(outgoingLink) == MessageEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(),
						false))); // directlyOwned: false
				// don't need explicit deletion of node as parent's view deletion would clean child
				// views as well
				// cmd.add(new
				// org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(),
				// node));
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Message_4003 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Message_4003 == req.getElementType()) {
			return getGEFWrapper(new MessageCreateCommand(req, req.getSource(), req.getTarget()));
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
		switch (getVisualID(req)) {
		case MessageEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
