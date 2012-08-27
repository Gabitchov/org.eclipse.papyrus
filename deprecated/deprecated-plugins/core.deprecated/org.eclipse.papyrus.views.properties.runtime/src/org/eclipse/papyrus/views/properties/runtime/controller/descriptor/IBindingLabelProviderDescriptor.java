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
package org.eclipse.papyrus.views.properties.runtime.controller.descriptor;



/**
 * Descriptors for controllers that provides message binding facilities
 */
public interface IBindingLabelProviderDescriptor {

	/**
	 * returns the message to bind
	 * 
	 * @return the message to bind
	 */
	public String getMessage();

	/**
	 * Returns the ordered list of feature names that are binded
	 * 
	 * @return the ordered list of feature names that are binded
	 */
	public String[] getFeaturesNameToBind();

	/**
	 * Computes the result of the binding for the given set of objects
	 * 
	 * @param objectToEdit
	 *        the object to edit
	 * @return the string result of the binding
	 */
	public String computeBindings(Object objectToEdit);

}
