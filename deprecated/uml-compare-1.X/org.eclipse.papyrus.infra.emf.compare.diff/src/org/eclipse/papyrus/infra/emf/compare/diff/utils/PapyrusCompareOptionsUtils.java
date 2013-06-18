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
package org.eclipse.papyrus.infra.emf.compare.diff.utils;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;

/**
 * 
 * Utils class for Papyrus Compare Options
 * 
 */
public class PapyrusCompareOptionsUtils {

	private PapyrusCompareOptionsUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param el
	 *        a DiffElement
	 * @return
	 *         the PapyrusCompareOptions instances attached to the DiffElement if it exists, or <code>null</code> if not found
	 */
	public static final PapyrusOptionsAdapter getPapyrusOptionsAdapter(final DiffElement el) {
		for(final Adapter current : el.eAdapters()) {
			if(current instanceof PapyrusOptionsAdapter) {
				return (PapyrusOptionsAdapter)current;
			}
		}
		return null;
	}
}
