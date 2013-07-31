/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * This class allows to compare elements on several levels
 * 
 * @author vl222926
 * @param <T>
 * 
 */

public class CompositeComparator<T> implements Comparator<T> {

	/**
	 * the list of the comparator
	 */
	private final List<Comparator<T>> comparators;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param comparators
	 */
	public CompositeComparator(final List<Comparator<T>> comparators) {
		this.comparators = comparators;
	}

	/**
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public int compare(T o1, T o2) {
		int res = 0;
		final Iterator<Comparator<T>> iter = comparators.iterator();
		while(iter.hasNext() && res == 0) {
			final Comparator<T> current = iter.next();
			res = current.compare(o1, o2);
		}
		return res;
	}

}
