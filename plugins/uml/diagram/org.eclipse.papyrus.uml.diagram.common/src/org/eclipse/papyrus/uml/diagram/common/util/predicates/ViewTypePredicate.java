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
import org.eclipse.gmf.runtime.notation.View;

import com.google.common.base.Predicate;

/**
 * Predicate used to filter views by ID
 * @author arthur daussy
 */
public class ViewTypePredicate implements Predicate<View>{
	/**
	 * Visual Id
	 */
	private String id;

	/**
	 * Visual Id your are looking for
	 * @param id
	 */
	public ViewTypePredicate(String id) {
		super();
		Assert.isNotNull(id);
		this.id = id;
	}

	public boolean apply(View input) {	
		return id.equals(input.getType());
	}
	
	
}