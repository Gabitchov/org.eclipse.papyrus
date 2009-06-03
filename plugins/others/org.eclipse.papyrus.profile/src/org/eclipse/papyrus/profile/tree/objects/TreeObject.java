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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Element;

// TODO: Auto-generated Javadoc
/**
 * The Class TreeObject.
 */
public class TreeObject implements IAdaptable {

	/**
	 * The parent.
	 */
	protected ParentTreeObject parent;

	/**
	 * The element.
	 */
	protected Element element;

	/**
	 * 
	 */
	protected boolean isDisplay = false;

	/**
	 * Editing domain used to modify the editing domain
	 */
	protected TransactionalEditingDomain domain;

	/**
	 * Editing domain used to modify the given property
	 */

	/**
	 * The Constructor.
	 * 
	 * @param element
	 *            the element
	 * @param parent
	 *            the parent
	 */
	public TreeObject(ParentTreeObject parent, Element element, TransactionalEditingDomain domain) {
		this.parent = parent;
		this.element = element;
		this.domain = domain;
	}

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public ParentTreeObject getParent() {
		return parent;
	}

	/**
	 * Gets the adapter.
	 * 
	 * @param key
	 *            the key
	 * 
	 * @return the adapter
	 */
	public Object getAdapter(Class key) {
		if (key == Element.class) {
			return getElement();
		}

		return getElement();
		// return null;
	}

	/**
	 * Gets the element.
	 * 
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public boolean isDisplay() {
		return isDisplay;
	}

	/**
	 * 
	 * 
	 * @param isDisplay
	 */
	public void setDisplay(boolean isDisplay) {
		this.isDisplay = isDisplay;
	}

}
