/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.state;

import java.beans.PropertyChangeListener;
import java.util.List;


/**
 * Interface for element which can be visited to add or remove property listeners
 */
public interface ITraversableModelElement {

	/**
	 * Returns the list of children for this element
	 * 
	 * @return the list of children for this element
	 */
	public List<? extends ITraversableModelElement> getChildren();

	/**
	 * Adds the given listener to the list of listeners listening for property change on the element
	 * 
	 * @param listener
	 *        the listener to add
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener);

	/**
	 * Removes the given listener from the list of listeners listening for property change on the element
	 * 
	 * @param listener
	 *        the listener to remove
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener);
}
