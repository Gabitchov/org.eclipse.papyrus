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

import com.google.common.base.Predicate;

/**
 * Filter all ancestors
 * 
 * @author arthur daussy
 * 
 */
public class AncestorFilter implements Predicate<EObject> {

	private Iterable<? extends EObject> initialCollection;

	public AncestorFilter(Iterable<? extends EObject> initialCollection) {
		super();
		this.initialCollection = initialCollection;
	}

	public boolean apply(EObject input) {
		for(EObject target : initialCollection) {
			if(target == input) {
				continue;
			}
			if(EcoreUtil.isAncestor(target, input)) {
				return false;
			}
		}
		return true;
	}
}
