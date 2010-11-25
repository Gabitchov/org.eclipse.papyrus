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

import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;

/**
 * @author dumoulin
 */
public class RootModel extends AbstractModel {

	/**
	 * Child of this root model.
	 */
	private AbstractPanelModel child;

	/**
	 * Constructor.
	 * 
	 * @param child
	 */
	public RootModel(AbstractPanelModel child) {
		this.child = child;
		child.setParent(this);
	}

	/**
	 * Return the parent of the model. Can be null in the case of rootModel.
	 * 
	 * @return the parent
	 */
	public AbstractModel getParent() {
		return null;
	}

	/**
	 * @param parent
	 *        the parent to set
	 */
	public void setParent(AbstractModel parent) {
	}

	/**
	 * Replace the actual child by the new child.
	 * 
	 */
	public void replaceChild(AbstractPanelModel oldChild, AbstractPanelModel newChild) {

		assert (child == oldChild);
		child = newChild;

	}

	/**
	 * Lookup the folder containing the specified tabItem.
	 * 
	 * @param tabItem
	 * @return
	 */
	protected TabFolderModel lookupTabFolder(IPageModel tabItem) {
		return child.lookupTabFolder(tabItem);
	}

	protected AbstractPanelModel getChild() {
		return child;
	}

}
