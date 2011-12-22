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
package org.eclipse.papyrus.views.properties.runtime.view.constraints;

import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;

/**
 * Descriptor for constraints on the sections
 */
public interface IConstraintDescriptor extends IConfigurableDescriptor {

	/**
	 * Returns <code>true</code> if the constraint is valid for the given object
	 * 
	 * @param objectToTest
	 *        the object to test
	 * @return <code>true</code> if the constraint is valid
	 */
	public boolean select(Object objectToTest);

	/**
	 * {@inheritDoc}
	 */
	public ConstraintDescriptorState createState(boolean readOnly);

}
