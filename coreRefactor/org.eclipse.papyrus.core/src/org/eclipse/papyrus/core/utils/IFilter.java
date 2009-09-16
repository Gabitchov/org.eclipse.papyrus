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
package org.eclipse.papyrus.core.utils;

/**
 * A filter.
 */
public interface IFilter {

	/**
	 * Is the specified object allowed ? Return true if the filter allow this object. Return false if the filter doesn't allows the object.
	 * 
	 * @param object
	 * 
	 * @return boolean
	 */
	public boolean isAllowed(Object object);
}
