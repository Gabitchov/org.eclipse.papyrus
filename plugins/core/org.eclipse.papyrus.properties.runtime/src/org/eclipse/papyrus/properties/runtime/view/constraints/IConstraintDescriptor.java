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
package org.eclipse.papyrus.properties.runtime.view.constraints;



/**
 * Descriptor for constraints on the sections
 */
public interface IConstraintDescriptor {

	/**
	 * Returns <code>true</code> if the constraint is valid for the given object
	 * 
	 * @param objectToTest
	 *        the object to test
	 * @return <code>true</code> if the constraint is valid
	 */
	public boolean select(Object objectToTest);

}
