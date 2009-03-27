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

import java.util.ArrayList;

import org.eclipse.uml2.uml.Element;

// TODO: Auto-generated Javadoc
/**
 * The Class ParentTreeObject.
 */
public abstract class ParentTreeObject extends TreeObject {
	
	/**
	 * The children.
	 */
	private ArrayList children;

	/**
	 * The Constructor.
	 * 
	 * @param element the element
	 * @param parent the parent
	 */
	public ParentTreeObject(ParentTreeObject parent, Element element) {
		super(parent, element);
	}

	/**
	 * Adds the child.
	 * 
	 * @param child the child
	 */
	public void addChild(TreeObject child) {
		children.add(child);
	}
	
	/**
	 * Removes the child.
	 * 
	 * @param child the child
	 */
	public void removeChild(TreeObject child) {
		children.remove(child);
	}
	
	/**
	 * Move child up.
	 * 
	 * @param child the child
	 */
	public void moveChildUp(TreeObject child) {
		if (children == null) {
			return;
		}
		
		int index = children.indexOf(child);
		if (index < 1) {
			// do nothing
			return;
		}
		
		TreeObject tmp = (TreeObject) children.get(index - 1);
		children.set(index - 1, child);
		children.set(index, tmp);
	}
	
	/**
	 * Move child down.
	 * 
	 * @param child the child
	 */
	public void moveChildDown(TreeObject child) {
		if (children == null) {
			return;
		}
		
		int index = children.indexOf(child);
		if ((index == -1) || (index >= children.size() - 1)) {
			// do nothing
			return;
		}
		
		TreeObject tmp = (TreeObject) children.get(index + 1);
		children.set(index + 1, child);
		children.set(index, tmp);
	}
	
	/**
	 * Gets the children.
	 * 
	 * @return the children
	 */
	public TreeObject [] getChildren() {
		if (children == null) {
			children = new ArrayList();
			createChildren();
		}	
		return (TreeObject []) children.toArray(new TreeObject[children.size()]);
	}


	
	/* subclasses should override this method and add the child nodes */
	/**
	 * Creates the children.
	 */
	protected abstract void createChildren();
}
