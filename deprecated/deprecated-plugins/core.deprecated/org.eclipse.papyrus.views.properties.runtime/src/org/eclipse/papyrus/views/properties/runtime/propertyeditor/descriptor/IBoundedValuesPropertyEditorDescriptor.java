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
package org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor;

import java.util.List;


/**
 * Interface for property editors that accept a bounded list of values (enumeration, boolean, etc)
 */
public interface IBoundedValuesPropertyEditorDescriptor {

	/**
	 * Sets the list of available values
	 * 
	 * @param values
	 *        the list of available values
	 */
	public void setAvailableValues(List<?> values);

	/**
	 * Returns the list of available values
	 * 
	 * @return the list of available values
	 */
	public List<?> getAvailableValues();
}
