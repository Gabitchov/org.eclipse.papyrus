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

import org.eclipse.papyrus.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;


/**
 * @author dumoulin
 */
public abstract class AbstractPanelModel extends AbstractModel implements IAbstractPanelModel {

	/**
	 * Parent of the model. Can be null in the case of rootModel.
	 */
	protected AbstractModel parent;

	/**
	 * Constructor.
	 * @param parent2
	 */
	public AbstractPanelModel(AbstractModel parent) {
		this.parent = parent;
	}


	/**
	 * Return the parent of the model. Can be null in the case of rootModel.
	 * @return the parent
	 */
	public AbstractModel getParent() {
		return parent;
	}

	
	/**
	 * @param parent the parent to set
	 */
	public void setParent(AbstractModel parent) {
		this.parent = parent;
	}


	/**
	 * Lookup the folder containing the specified tabItem.
	 * @param tabItem
	 * @return
	 */
	abstract protected TabFolderModel lookupTabFolder(IPageModel tabItem);


}
