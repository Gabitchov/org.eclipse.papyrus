/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier patrick.tessier@cea.fr - initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.ui.dialog;

import java.util.Comparator;
import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.papyrus.profile.ui.dialogs.ElementList;

/**
 * Creates a new ElementList with a special comparator. This comparator is used to modify the
 * contains() method.
 */
public class ElementListWithComparator extends ElementList {

	/** Comparator used by this list for the contains() method */
	protected Comparator comparator;

	/**
	 * Defaut constructor
	 * 
	 * @param comparator
	 *        the comparator used by this list
	 */
	public ElementListWithComparator(Comparator comparator) {
		Assert.isNotNull(comparator, "Comparator should not be null"); //$NON-NLS-1$
		this.comparator = comparator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.core.ui.dialogs.ElementList#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object element) {
		// for each element of the list, tries to find if the element already exists

		Iterator it = getElements().iterator();
		while(it.hasNext()) {
			if(0 == comparator.compare(element, it.next())) {
				return true;
			}
		}
		return false;
	}
}
