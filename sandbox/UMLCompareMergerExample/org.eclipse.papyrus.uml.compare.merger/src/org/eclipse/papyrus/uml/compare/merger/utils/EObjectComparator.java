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
package org.eclipse.papyrus.uml.compare.merger.utils;

import java.util.Comparator;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;

/**
 * 
 * This class allows to compare EObject using the PositionAdapter.
 * 
 * 
 */
public class EObjectComparator<T> implements Comparator<T> {

	/**
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public int compare(final T o1, final T o2) {
		if(o1 instanceof EObject && o2 instanceof EObject) {
			final int position1 = getWantedPosition((EObject)o1);
			final int position2 = getWantedPosition((EObject)o2);
			if(position1 != -1 && position2 != -1) {
				return position1 - position2;
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param obj1
	 *        an EObject
	 * @return
	 *         the wanted position for this object
	 */
	private int getWantedPosition(final EObject obj1) {
		final Iterator<Adapter> adapters = obj1.eAdapters().iterator();
		int expectedIndex = -1;
		while(expectedIndex == -1 && adapters.hasNext()) {
			final Adapter adapter = adapters.next();
			if(adapter instanceof PositionAdapter) {
				expectedIndex = ((PositionAdapter)adapter).getExpectedIndex();
			}
		}
		return expectedIndex;
	}

}
