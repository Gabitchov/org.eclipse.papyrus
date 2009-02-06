/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.tree.objects;

import java.util.Iterator;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

// TODO: Auto-generated Javadoc
/**
 * The Class RootElementTreeObject.
 */
public class RootElementTreeObject extends ParentTreeObject {
	
	/**
	 * The Constructor.
	 * 
	 * @param parent the parent
	 */
	public RootElementTreeObject(Element parent) {
		super(null, parent);
	}
	
	/**
	 * Creates the children.
	 */
	@Override
	protected void createChildren() {
		Iterator<Stereotype> stIt = element.getAppliedStereotypes().iterator();
		
		while (stIt.hasNext()) {
			final Stereotype currentSt = stIt.next();		
			addChild(new StereotypeTreeObject(this, currentSt));				
		}
	}

	
}
