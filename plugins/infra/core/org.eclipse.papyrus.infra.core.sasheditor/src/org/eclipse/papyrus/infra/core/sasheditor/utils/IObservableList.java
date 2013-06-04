/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.sasheditor.utils;

import java.util.List;


/**
 * A generic list that can be observed.
 * 
 * @author cedric dumoulin
 *
 */
public interface IObservableList<E> extends List<E> {

	/**
	 * Add a listener to the list. This listener will be called each time an event arise to the list.
	 * 
	 * @param listener
	 */
	public void addListener( IObservableListListener<E> listener);
	
	/**
	 * Remove the listener from the list.
	 * @param listener
	 */
	public void removeListener( IObservableListListener<E> listener);
}
