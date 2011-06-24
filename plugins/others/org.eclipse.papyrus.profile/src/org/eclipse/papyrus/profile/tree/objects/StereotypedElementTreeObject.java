/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.tree.objects;

import java.util.Iterator;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The root (no parent) of the tree: a stereotyped element, i.e. a tree
 * object referencing the UML model element that has a stereotype. 
 * Its children are appliedStereotypeTreeObjects.
 */
public class StereotypedElementTreeObject extends ParentTreeObject {

	/**
	 * The Constructor.
	 * 
	 * @param element the UML element that should be stereotyped
	 */
	public StereotypedElementTreeObject(Element element) {
		super(null);
		this.element = element;
	}

	/**
	 * Creates the children.
	 */
	@Override
	protected void createChildren() {
		Iterator<Stereotype> stIt = element.getAppliedStereotypes().iterator();

		while (stIt.hasNext()) {
			final Stereotype currentSt = stIt.next();
			addChild(new AppliedStereotypeTreeObject(this, currentSt));
		}
	}

	protected Element element;
	
   /**
     * Gets the element.
     * 
     * @return the element
     */
    public Element getElement() {
        return element;
    }
}
