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
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Add the behavior for deletion of an activity group:
 * 1 Remove a group when delete from the "group" feature
 * 
 * @author adaussy
 * 
 */
public class ActivityGroupEditHelperAdvice extends AbstractEditHelperAdvice {

	
	
	@Override
	protected ICommand getAfterDestroyDependentsCommand(DestroyDependentsRequest request) {
		CompositeCommand cc = new CompositeCommand("After Command for an Activity Node");////$NON-NLS-1$
		/*
		 * Remove from derived feature ownedNode
		 * WARNING:
		 * This should be done in the DestroyElementPapyrusCommand however this command for now prevent removing it from derive feature.
		 * Waiting for discussion.
		 * This is a temporary discussion
		 */
		ICommand removedFromOwnedNodeCommand = getRemoveFromDerivedFeature(request);
		if(removedFromOwnedNodeCommand != null) {
			cc.compose(removedFromOwnedNodeCommand);
		}
		if(cc != null && !cc.isEmpty()) {
			return cc;
		}
		return super.getAfterDestroyDependentsCommand(request);
	}

	/**
	 * Remove from derived polluting feature
	 * 
	 * @param request
	 * @return
	 */
	protected ICommand getRemoveFromDerivedFeature(DestroyDependentsRequest request) {
		EObject eObject = request.getElementToDestroy();
		if(eObject instanceof ActivityGroup) {
			/*
			 * Destroy Activity Edge
			 */
			final ActivityGroup activityNode = (ActivityGroup)eObject;
			final EStructuralFeature containingFeature = activityNode.eContainingFeature();
			if(UMLPackage.Literals.ACTIVITY__OWNED_GROUP.equals(containingFeature)) {
				final Activity holder = (Activity)activityNode.eContainer();
				return new AbstractTransactionalCommand((TransactionalEditingDomain)AdapterFactoryEditingDomain.getEditingDomainFor(activityNode), "Remove a group from the group feature", null) {////$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						Object elements = holder.eGet(UMLPackage.Literals.ACTIVITY__GROUP);
						if(elements instanceof EList<?>) {
							EList<?> collection = (EList<?>)elements;
							collection.remove(activityNode);
						}
						return CommandResult.newOKCommandResult();
					}
				};
			}
		}
		return null;
	}
}
