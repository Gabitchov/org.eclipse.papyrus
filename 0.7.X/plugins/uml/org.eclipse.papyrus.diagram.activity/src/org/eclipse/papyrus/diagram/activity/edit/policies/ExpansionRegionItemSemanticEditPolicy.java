/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
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
import org.eclipse.papyrus.diagram.activity.edit.commands.ActionLocalPostconditionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActionLocalPostconditionReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActionLocalPreconditionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActionLocalPreconditionReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ControlFlowCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ControlFlowReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ExceptionHandlerCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ExceptionHandlerReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ExpansionNodeAsInCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ExpansionNodeAsOutCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ObjectFlowCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ObjectFlowReorientCommand;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPostconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPreconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConditionalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExceptionHandlerEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionNodeAsInEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionNodeAsOutEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionRegionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionRegionStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.LoopNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SequenceNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.StructuredActivityNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValueSpecificationActionEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.command.wrappers.EMFtoGMFCommandWrapper;

/**
 * @generated
 */
public class ExpansionRegionItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ExpansionRegionItemSemanticEditPolicy() {
		super(UMLElementTypes.ExpansionRegion_3070);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.ExpansionNode_3074 == req.getElementType()) {
			return getGEFWrapper(new ExpansionNodeAsInCreateCommand(req));
		}
		if(UMLElementTypes.ExpansionNode_3075 == req.getElementType()) {
			return getGEFWrapper(new ExpansionNodeAsOutCreateCommand(req));
		}
		return super.getCreateCommand(req);
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
			case ExpansionNodeAsInEditPart.VISUAL_ID:

				for(Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
					case ObjectFlowEditPart.VISUAL_ID:
					case ControlFlowEditPart.VISUAL_ID:
					case ExceptionHandlerEditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					}
				}

				for(Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
					case ObjectFlowEditPart.VISUAL_ID:
					case ControlFlowEditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case ExpansionNodeAsOutEditPart.VISUAL_ID:

				for(Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
					case ObjectFlowEditPart.VISUAL_ID:
					case ControlFlowEditPart.VISUAL_ID:
					case ExceptionHandlerEditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						break;
					}
				}

				for(Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge)it.next();
					switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
					case ObjectFlowEditPart.VISUAL_ID:
					case ControlFlowEditPart.VISUAL_ID:
						DestroyElementRequest destroyEltReq = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(destroyEltReq));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						break;
					}
				}
				cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				for(Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node)cit.next();
					switch(UMLVisualIDRegistry.getVisualID(cnode)) {
					case InitialNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
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
					case ActivityFinalNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
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
					case FlowFinalNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
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
					case OpaqueActionEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case CallBehaviorActionEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case CallOperationActionEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case ConstraintAsLocalPrecondEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case ConstraintAsLocalPostcondEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case DecisionNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
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
					case MergeNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
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
					case ForkNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
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
					case JoinNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
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
					case DataStoreNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
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
					case SendObjectActionEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case SendSignalActionEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case AcceptEventActionEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case ValueSpecificationActionEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case ConditionalNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case ExpansionRegionEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case LoopNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case SequenceNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
					case StructuredActivityNodeEditPart.VISUAL_ID:

						for(Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(incomingLink)) {
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
								DestroyElementRequest destroyEltReq = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(destroyEltReq));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								break;
							}
						}

						for(Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge)it.next();
							switch(UMLVisualIDRegistry.getVisualID(outgoingLink)) {
							case ActionLocalPreconditionEditPart.VISUAL_ID:
							case ActionLocalPostconditionEditPart.VISUAL_ID:
								DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
								cmd.add(new DestroyReferenceCommand(destroyRefReq));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								break;
							case ObjectFlowEditPart.VISUAL_ID:
							case ControlFlowEditPart.VISUAL_ID:
							case ExceptionHandlerEditPart.VISUAL_ID:
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
		if(UMLElementTypes.ActionLocalPrecondition_4001 == req.getElementType()) {
			return getGEFWrapper(new ActionLocalPreconditionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ActionLocalPostcondition_4002 == req.getElementType()) {
			return getGEFWrapper(new ActionLocalPostconditionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ObjectFlow_4003 == req.getElementType()) {
			return getGEFWrapper(new ObjectFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ControlFlow_4004 == req.getElementType()) {
			return getGEFWrapper(new ControlFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ExceptionHandler_4005 == req.getElementType()) {
			return getGEFWrapper(new ExceptionHandlerCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.ActionLocalPrecondition_4001 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ActionLocalPostcondition_4002 == req.getElementType()) {
			return null;
		}
		if(UMLElementTypes.ObjectFlow_4003 == req.getElementType()) {
			return getGEFWrapper(new ObjectFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ControlFlow_4004 == req.getElementType()) {
			return getGEFWrapper(new ControlFlowCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.ExceptionHandler_4005 == req.getElementType()) {
			return null;
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
		case ObjectFlowEditPart.VISUAL_ID:
			return getGEFWrapper(new ObjectFlowReorientCommand(req));
		case ControlFlowEditPart.VISUAL_ID:
			return getGEFWrapper(new ControlFlowReorientCommand(req));
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getGEFWrapper(new ExceptionHandlerReorientCommand(req));
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
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return getGEFWrapper(new ActionLocalPreconditionReorientCommand(req));
		case ActionLocalPostconditionEditPart.VISUAL_ID:
			return getGEFWrapper(new ActionLocalPostconditionReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
