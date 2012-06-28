/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.diff.internal.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.infra.emf.compare.diff.Activator;

/**
 * This map log an error when a wanted element is unknown in the map
 * 
 * @author VL222926
 * 
 * @param <K>
 * @param <V>
 */
public class PapyrusCompareMap<K, V> extends HashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an empty <tt>HashMap</tt> with the specified initial
	 * capacity and load factor.
	 * 
	 * @param initialCapacity
	 *        The initial capacity.
	 * @param loadFactor
	 *        The load factor.
	 * @throws IllegalArgumentException
	 *         if the initial capacity is negative
	 *         or the load factor is nonpositive.
	 */
	public PapyrusCompareMap(final int initialCapacity, final float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	/**
	 * Constructs an empty <tt>HashMap</tt> with the specified initial
	 * capacity and the default load factor (0.75).
	 * 
	 * @param initialCapacity
	 *        the initial capacity.
	 * @throws IllegalArgumentException
	 *         if the initial capacity is negative.
	 */
	public PapyrusCompareMap(final int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * Constructs an empty <tt>HashMap</tt> with the default initial capacity
	 * (16) and the default load factor (0.75).
	 */
	public PapyrusCompareMap() {
		super();
	}

	/**
	 * Constructs a new <tt>HashMap</tt> with the same mappings as the
	 * specified <tt>Map</tt>. The <tt>HashMap</tt> is created with
	 * default load factor (0.75) and an initial capacity sufficient to
	 * hold the mappings in the specified <tt>Map</tt>.
	 * 
	 * @param m
	 *        the map whose mappings are to be placed in this map.
	 * @throws NullPointerException
	 *         if the specified map is null.
	 */
	public PapyrusCompareMap(final Map<? extends K, ? extends V> m) {
		super(m);
	}

	/**
	 * We display an error when a wanted element is not included in the Map
	 * 
	 * @see java.util.HashMap#get(java.lang.Object)
	 * 
	 * @param key
	 * @return
	 */
	@Override
	public V get(final Object key) {
		V obj = super.get(key);
		if(obj == null) {
			Activator.log.error("The following element is unknown in the map : " + key, new NullPointerException()); //$NON-NLS-1$
		}
		return obj;
	}
}
