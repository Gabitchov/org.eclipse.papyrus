package org.eclipse.papyrus.uml.compare.merger.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.uml.compare.merger.Activator;

/**
 * This map log an error when a wanted element is unknown in the map
 * 
 * @author VL222926
 * 
 * @param <K>
 * @param <V>
 */
public class PapyrusMap<K, V> extends HashMap<K, V> {

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
	public PapyrusMap(int initialCapacity, float loadFactor) {
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
	public PapyrusMap(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * Constructs an empty <tt>HashMap</tt> with the default initial capacity
	 * (16) and the default load factor (0.75).
	 */
	public PapyrusMap() {
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
	public PapyrusMap(Map<? extends K, ? extends V> m) {
		super(m);
	}

	@Override
	public V get(Object key) {
		V obj = super.get(key);
		if(obj == null) {
			Activator.log.error("The following element is unknown in the map : " + key, new NullPointerException());
		}
		return obj;
	}
}
