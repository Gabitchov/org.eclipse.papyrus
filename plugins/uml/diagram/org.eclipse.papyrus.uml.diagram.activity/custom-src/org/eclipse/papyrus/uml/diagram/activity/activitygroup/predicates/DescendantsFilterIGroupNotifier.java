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
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.predicates;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.editpolicy.notifiers.IGroupNotifier;

import com.google.common.base.Predicate;

/**
 * Same as {@link EcoreUtil#filterDescendants(java.util.Collection)}
 * 
 * @author arthur daussy
 * 
 */
public class DescendantsFilterIGroupNotifier implements Predicate<IGroupNotifier> {

	private Iterable<? extends IGroupNotifier> initialCollection;

	public DescendantsFilterIGroupNotifier(Iterable<? extends IGroupNotifier> initialCollection) {
		super();
		this.initialCollection = initialCollection;
	}

	public boolean apply(IGroupNotifier input) {
		for(IGroupNotifier target : initialCollection) {
			EObject targetEObject = target.getEObject();
			EObject inputEObject = input.getEObject();
			if(targetEObject == inputEObject) {
				continue;
			}
			if(inputEObject == null) {
				return false;
			}
			if(EcoreUtil.isAncestor(inputEObject, targetEObject)) {
				return false;
			}
		}
		return true;
	}
}
