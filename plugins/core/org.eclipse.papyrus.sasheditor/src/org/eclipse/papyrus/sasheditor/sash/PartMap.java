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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sasheditor.sash;

import java.util.Collection;
import java.util.HashMap;

/**
 * A map of the existing parts (model, part). Used to synchronize models and parts.
 */
@SuppressWarnings("serial")
public class PartMap<T> extends HashMap<Object, ITilePart<T>> {

	/**
	 * Constructor.
	 */
	public PartMap() {

	}

	/**
	 * @param model
	 * @return TilePart
	 */
	public ITilePart<T> findTilePart(Object model) {
		return get(model);
	}

	// /**
	// * @param model
	// * @return TilePart
	// */
	// public ITilePart createTilePart(Object model)
	// {
	// return null;
	// }
	//   
	// /**
	// * @param model
	// * @return TilePart
	// */
	// public ITilePart getTilePart(Object model)
	// {
	// return null;
	// }

	/**
	 * @return Iterator
	 */
	public Collection<ITilePart<T>> getTileParts() {
		return values();
	}
	
	/**
	 * Add all part of the collection to this map.
	 * @param collection
	 */
//	public void addAll(Collection<ITilePart<T>> collection)
//	{
//		for( ITilePart<T> part : collection)
//		{
//			put(part.getModel().getModel(), part);
//		}
//	}
}
