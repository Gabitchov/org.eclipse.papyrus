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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

// TODO: Auto-generated Javadoc
/**
 * The Class RootElementTreeObject.
 */
public class StereotypedElementTreeObject extends ParentTreeObject {

	/**
	 * The Constructor.
	 * 
	 * @param parent
	 *        the parent
	 */
	public StereotypedElementTreeObject(Element parent, TransactionalEditingDomain domain) {
		super(null, parent, domain);
	}

	/**
	 * Creates the children.
	 */
	@Override
	protected void createChildren() {
		Iterator<Stereotype> stIt = element.getAppliedStereotypes().iterator();
		EList stereolist = element.getAppliedStereotypes();

		while(stIt.hasNext()) {
			final Stereotype currentSt = stIt.next();
			addChild(new AppliedStereotypeTreeObject(this, currentSt, domain));
		}
	}

}
