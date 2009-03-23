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
package com.cea.papyrus.profile.tree.objects;

import org.eclipse.core.runtime.IAdaptable;
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
	 * The Constructor.
	 * 
	 * @param element the element
	 * @param parent the parent
	 */
	public TreeObject(ParentTreeObject parent, Element element) {
		this.parent = parent;
		this.element= element;
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
	 * @param key the key
	 * 
	 * @return the adapter
	 */
	public Object getAdapter(Class key) {
		if (key == Element.class) {
			return getElement();
		}
		
		return getElement();
		//return null;
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
