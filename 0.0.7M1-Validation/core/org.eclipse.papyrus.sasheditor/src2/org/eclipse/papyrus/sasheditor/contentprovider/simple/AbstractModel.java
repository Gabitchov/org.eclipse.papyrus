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


/**
 * @author dumoulin
 */
public abstract class AbstractModel {

	
	/**
	 * Return the parent of the model. Can be null in the case of rootModel.
	 * @return the parent
	 */
	abstract public AbstractModel getParent() ;

	
	/**
	 * @param parent the parent to set
	 */
	abstract public void setParent(AbstractModel parent);

	/**
	 * Replace the oldChild by the newChild
	 * 
	 * @param oldChild
	 * @param newChild
	 */
	abstract public void replaceChild(AbstractPanelModel oldChild, AbstractPanelModel newChild) ;

}
