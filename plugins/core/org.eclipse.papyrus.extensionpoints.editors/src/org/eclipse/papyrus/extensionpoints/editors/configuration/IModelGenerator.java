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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.configuration;

import org.eclipse.core.runtime.IStatus;

/**
 * Standard interface for classes in charge of model validation and modification from a text
 * representation of a UML element
 */
public interface IModelGenerator {

	/**
	 * validates the element, given its textual representation
	 * 
	 * @param label
	 *            the label to validate
	 * @return the {@link IStatus} corresponding to the validation
	 */
	public IStatus validate(String label);

	/**
	 * modifies the element, given its textual representation
	 * 
	 * @param label
	 *            the label to validate
	 * @return the {@link IStatus} corresponding to the validation
	 */
	// @unused
	public IStatus modify(String label);
}
