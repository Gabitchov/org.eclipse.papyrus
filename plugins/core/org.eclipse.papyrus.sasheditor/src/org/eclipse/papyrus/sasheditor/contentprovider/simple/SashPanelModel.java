/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sasheditor.contentprovider.simple;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashPanelModel;


/**
 * Simple implementation of the {@link ISashPanelModel}.
 * 
 * @author dumoulin
 */
public class SashPanelModel extends AbstractPanelModel implements ISashPanelModel {

	/** Ordered set of childs (a left and right child, or upper and lower) */
	protected AbstractPanelModel[] children = new AbstractPanelModel[2];

	// The children array as a list
	protected List<AbstractPanelModel> childrenList = Arrays.asList(children);

	protected int sashDirection;



	/**
	 * @param children
	 * @param sashDirection
	 */
	public SashPanelModel(AbstractModel parent, AbstractPanelModel leftChild, AbstractPanelModel rightChild, int sashDirection) {
		super(parent);
		this.children[0] = leftChild;
		this.children[1] = rightChild;

		this.sashDirection = sashDirection;
	}


	/**
	 * Set the left child.
	 * 
	 * @param child
	 */
	public void setLeftChild(AbstractPanelModel child) {
		this.children[0] = child;
	}

	/**
	 * Get the left child
	 * 
	 * @return
	 */
	private AbstractPanelModel getLeftChild() {
		return children[0];
	}

	/**
	 * Set the left child.
	 * 
	 * @param child
	 */
	public void setRightChild(AbstractPanelModel child) {
		this.children[1] = child;
	}

	/**
	 * Get the right child
	 * 
	 * @return
	 */
	private AbstractPanelModel getRightChild() {
		return children[1];
	}



	/**
	 * Create the SashPanelModel from the raw model.
	 * In this implementation, the rawModel is the SashPanelModel.
	 * This default implementation return directly the child which is already of the appropriate type.
	 */
	public IAbstractPanelModel createChildSashModel(Object rawModel) {
		return (IAbstractPanelModel)rawModel;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<?> getChildren() {
		return childrenList;
	}

	/**
	 * Return the direction of the sash:
	 * 
	 */
	public int getSashDirection() {
		return sashDirection;
	}

	/**
	 * Replace specified child with the new child. {@inheritDoc}
	 */
	public void replaceChild(AbstractPanelModel oldChild, AbstractPanelModel newChild) {


		if(getLeftChild() == oldChild)
			setLeftChild(newChild);
		else if(getRightChild() == oldChild)
			setRightChild(newChild);

	}


	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected TabFolderModel lookupTabFolder(IPageModel tabItem) {
		TabFolderModel parent = getLeftChild().lookupTabFolder(tabItem);
		if(parent != null)
			return parent;

		return getRightChild().lookupTabFolder(tabItem);
	}


	/**
	 * Delete the sashModel.
	 * The childToDelete is removed from the tree, bypass the sashnode : the other child parent is set to sashnode parent.
	 * 
	 * @param tabFolder
	 */
	protected void delete(AbstractPanelModel childToDelete) {

		// Get the other child
		AbstractPanelModel otherChild = (childToDelete == getLeftChild() ? getRightChild() : getLeftChild());

		AbstractModel parent = getParent();
		// Change parent
		otherChild.setParent(parent);
		parent.replaceChild(this, otherChild);


	}


}
