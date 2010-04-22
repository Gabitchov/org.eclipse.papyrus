/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.core.view;

import java.util.List;


/**
 * Feature descriptor for sub features of an element
 */
public abstract class SubFeatureDescriptor {

	/**
	 * Returns the list of sub elements for a given set of objects
	 * 
	 * @param editedObjects
	 *        the list of selected objects
	 * @return the list of sub elements for a given set of objects or an empty list
	 */
	public abstract List<Object> getSubElementsToEdit(List<Object> editedObjects);
}
