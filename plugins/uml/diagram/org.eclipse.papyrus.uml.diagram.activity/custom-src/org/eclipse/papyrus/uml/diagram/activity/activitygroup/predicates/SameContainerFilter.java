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

import org.eclipse.uml2.uml.Element;

import com.google.common.base.Predicate;

/**
 * filter which return true or element which have the same container
 * 
 * @author arthur
 * 
 */
public class SameContainerFilter implements Predicate<Element> {

	private Element parent;

	private Element container;

	public SameContainerFilter(Element parent) {
		super();
		this.parent = parent;
	}

	public boolean apply(Element arg0) {
		return getContainer() != null && getContainer().equals(arg0.getOwner());
	}

	private Element getContainer() {
		if(container == null) {
			container = parent.getOwner();
		}
		return container;
	}
}
