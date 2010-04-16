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
package org.eclipse.papyrus.properties.runtime.controller.descriptor;

import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;


/**
 * interface for all property editor controllers
 */
public interface IPropertyEditorControllerDescriptor {

	/**
	 * Indicates if the controller accepts multi selection
	 * 
	 * @return <code>true</code> if the controller accepts multi-selection
	 */
	public boolean acceptMultiSelection();

	/**
	 * Returns the unique identifier of the controller described by this element
	 * 
	 * @return the unique identifier of the controller described by this element
	 */
	public String getControllerID();

	/**
	 * Returns the editor descriptor for this controller
	 * 
	 * @return the editor descriptor for this controller
	 */
	public IPropertyEditorDescriptor getEditorDescriptor();
}
