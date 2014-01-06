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

package org.eclipse.papyrus.layers.stackmodel.util;

import java.util.ArrayList;
import java.util.Collection;

import com.google.common.collect.Collections2;

/**
 * Set of utility methods for Collections.
 * @see Collections2
 * 
 * @author cedric dumoulin
 *
 */
public class Collections3 {

	/**
	 * Reset the toChange list to the content of the newContent list.
	 * Minimize the change calls on the toChange list.
	 * This method ensure that there is at most 2 writing calls to the list to modify: one 
	 * removeAll(toBeRemoved) and one addAll(toBeAdded).
	 * 
	 * @param toChange
	 * @param newContent
	 */
	public static <E> void resetListTo(Collection<E> toChange, Collection<E> newContent)		{

		// Compute removed and added
		Collection<E> elementsToRemove = new ArrayList<E>();
		Collection<E> elementsToAdd = new ArrayList<E>();

		// Compute added and removed elements. Walk both list 2 times. 
		// This could certainly be improved.
		// TODO improve the algorithm

		// Compute added elements
		for( E o : newContent ) {
			if( !toChange.contains(o)) {
				elementsToAdd.add(o);
				continue;
			}
		}

		// Compute removed elements
		for( E o : toChange ) {
			if( !newContent.contains(o)) {
				elementsToRemove.add(o);
				continue;
			}
		}

		// Change the list
		if( ! elementsToRemove.isEmpty()) {
			toChange.removeAll(elementsToRemove);
		}
		if( !elementsToAdd.isEmpty()) {
			toChange.addAll(elementsToAdd);
		}
	}

}
