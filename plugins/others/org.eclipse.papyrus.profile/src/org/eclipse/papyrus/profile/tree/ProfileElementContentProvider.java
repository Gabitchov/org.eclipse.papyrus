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
package org.eclipse.papyrus.profile.tree;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.profile.tree.objects.ParentTreeObject;
import org.eclipse.papyrus.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.profile.tree.objects.TreeObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileElementContentProvider.
 */
public class ProfileElementContentProvider implements IStructuredContentProvider, IContentProvider, ITreeContentProvider {

	/**
	 * The root.
	 */
	private StereotypedElementTreeObject root;

	/**
	 * Input changed.
	 * 
	 * @param newInput
	 *        the new input
	 * @param oldInput
	 *        the old input
	 * @param v
	 *        the v
	 */
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	/**
	 * Dispose.
	 */
	public void dispose() {
	}

	/**
	 * Gets the elements.
	 * 
	 * @param parent
	 *        the parent
	 * 
	 * @return the elements
	 */
	public TreeObject[] getElements(Object parent) {
		if((root == null) && (parent instanceof StereotypedElementTreeObject)) {
			root = (StereotypedElementTreeObject)parent;
			return getChildren(root);
		}
		return getChildren(parent);
	}

	/**
	 * Gets the parent.
	 * 
	 * @param child
	 *        the child
	 * 
	 * @return the parent
	 */
	public TreeObject getParent(Object child) {
		if(child instanceof TreeObject) {
			return ((TreeObject)child).getParent();
		}
		return null;
	}

	/**
	 * Gets the root tree element object.
	 * 
	 * @return the root tree element object
	 */
	public StereotypedElementTreeObject getRootTreeElementObject() {
		return root;
	}

	/**
	 * Gets the children.
	 * 
	 * @param parent
	 *        the parent
	 * 
	 * @return the children
	 */
	public TreeObject[] getChildren(Object parent) {
		if(parent instanceof ParentTreeObject) {
			return ((ParentTreeObject)parent).getChildren();
		}
		return new TreeObject[0];
	}

	/**
	 * Checks for children.
	 * 
	 * @param parent
	 *        the parent
	 * 
	 * @return true, if has children
	 */
	public boolean hasChildren(Object parent) {
		if(parent instanceof ParentTreeObject) {
			return ((ParentTreeObject)parent).getChildren().length > 0;
		}

		return false;
	}
}
