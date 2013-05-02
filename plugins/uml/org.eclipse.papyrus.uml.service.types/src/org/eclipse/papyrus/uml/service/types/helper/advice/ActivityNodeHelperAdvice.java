/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy - Fit to UML 4.0.0 metamodel
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.HashSet;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.DestroyElementPapyrusCommand;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.Sets;

/**
 * Add the behavior for deletion of an activity node:
 * 1. Delete all activity edges starting/ending from/to a node when this node is deleted
 * 2. When deleting a node remove it from derived feature "node"
 * 
 * @author adaussy
 * 
 */
public class ActivityNodeHelperAdvice extends AbstractEditHelperAdvice {

//	@Override
//	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
//		CompositeCommand cc = new CompositeCommand("Before Command for an Activity Node");////$NON-NLS-1$
//		/*
//		 * Destroy edge
//		 */
//		ICommand destroyEdgeCommand = getDestroyActivityEdgeCommand(request);
//		if(destroyEdgeCommand != null) {
//			cc.compose(destroyEdgeCommand);
//		}
//		if(cc != null && !cc.isEmpty()) {
//			return cc;
//		}
//		return super.getBeforeDestroyDependentsCommand(request);
//	}
//
//	@Override
//	protected ICommand getAfterDestroyDependentsCommand(DestroyDependentsRequest request) {
//		CompositeCommand cc = new CompositeCommand("After Command for an Activity Node");////$NON-NLS-1$
//		/*
//		 * Remove from derived feature ownedNode
//		 * WARNING:
//		 * This should be done in the DestroyElementPapyrusCommand however this command for now prevent removing it from derive feature.
//		 * Waiting for discussion.
//		 * This is a temporary discussion
//		 */
//		ICommand removedFromOwnedNodeCommand = getRemoveFromDerivedFeature(request);
//		if(removedFromOwnedNodeCommand != null) {
//			cc.compose(removedFromOwnedNodeCommand);
//		}
//		if(cc != null && !cc.isEmpty()) {
//			return cc;
//		}
//		return super.getAfterDestroyDependentsCommand(request);
//	}
//
//	/**
//	 * Remove from derived polluting feature
//	 * 
//	 * @param request
//	 * @return
//	 */
//	protected ICommand getRemoveFromDerivedFeature(DestroyDependentsRequest request) {
//		EObject eObject = request.getElementToDestroy();
//		if(eObject instanceof ActivityNode) {
//			/*
//			 * Destroy Activity Edge
//			 */
//			final ActivityNode activityNode = (ActivityNode)eObject;
//			final EStructuralFeature containingFeature = activityNode.eContainingFeature();
//			if(UMLPackage.Literals.ACTIVITY__OWNED_NODE.equals(containingFeature)) {
//				final Activity holder = (Activity)activityNode.eContainer();
//				return new AbstractTransactionalCommand((TransactionalEditingDomain)AdapterFactoryEditingDomain.getEditingDomainFor(activityNode), "test", null) {
//
//					@Override
//					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
//						Object elements = holder.eGet(UMLPackage.Literals.ACTIVITY__NODE);
//						if(elements instanceof EList<?>) {
//							EList<?> collection = (EList<?>)elements;
//							collection.remove(activityNode);
//						}
//						return CommandResult.newOKCommandResult();
//					}
//				};
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * When an activity node is deleted than all activity edge starting/ending from/to it should be deleted
//	 * 
//	 * @param request
//	 * @return
//	 */
//	protected ICommand getDestroyActivityEdgeCommand(DestroyDependentsRequest request) {
//		EObject eObject = request.getElementToDestroy();
//		if(eObject instanceof ActivityNode) {
//			/*
//			 * Destroy Activity Edge
//			 */
//			ActivityNode activityNode = (ActivityNode)eObject;
//			EList<ActivityEdge> incomings = activityNode.getIncomings();
//			EList<ActivityEdge> outgoings = activityNode.getOutgoings();
//			HashSet<ActivityEdge> edges = Sets.newHashSet();
//			if(incomings != null && !incomings.isEmpty()) {
//				edges.addAll(incomings);
//			}
//			if(outgoings != null && !outgoings.isEmpty()) {
//				edges.addAll(outgoings);
//			}
//			if(!edges.isEmpty()) {
//				CompositeCommand cc = new CompositeCommand("Detele Incomings and outgoings edges from activity node");////$NON-NLS-1$
//				for(ActivityEdge e : edges) {
//					DestroyElementRequest destroyRequest = new DestroyElementRequest(e, false);
//					DestroyElementPapyrusCommand destroyCommand = new DestroyElementPapyrusCommand(destroyRequest);
//					if(destroyCommand != null && destroyCommand.canExecute()) {
//						cc.compose(destroyCommand);
//					}
//				}
//				return cc;
//			}
//		}
//		return null;
//	}
}
