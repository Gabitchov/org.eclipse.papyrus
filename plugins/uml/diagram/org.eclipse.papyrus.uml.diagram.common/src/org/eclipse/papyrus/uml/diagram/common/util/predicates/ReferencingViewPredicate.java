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
 *   Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util.predicates;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

import com.google.common.base.Predicate;

/**
 * This predicate return true if the EObject(notation) passed into apply method is a view which:
 *  -> refer to the element (semantic) element passed in argument to the constructor
 * @author arthur daussy
 *
 */
public class ReferencingViewPredicate implements Predicate<EObject> {

	private EObject element;
	/**
	 * 
	 * @param element {@link EObject} representing the semantic elemetn
	 */
	public ReferencingViewPredicate(EObject element) {
		super();
		Assert.isNotNull(element);
		this.element = element;
	}
	
	public boolean apply(EObject input) {
		/* 
		 * Select all the view corresponding to this element and which have the same visual representations
		 */
		if(input instanceof View) {
			return element.equals(((View)input).getElement());
		}
		return false;
	}
	
}
