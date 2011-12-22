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
package org.eclipse.papyrus.views.properties.runtime.controller.predefined;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;


/**
 * Operation that retrieves a predefined property editor controller
 */
public class CreatePredefinedPropertyControllerProviderOperation implements IOperation {

	/** identifier of the controller to retrieve */
	private final String predefinedID;

	/**
	 * Creates a new CreatePredefinedPropertyControllerProviderOperation.
	 * 
	 * @param predefinedID
	 *        id of the controller to retrieve
	 * 
	 */
	public CreatePredefinedPropertyControllerProviderOperation(String predefinedID) {
		this.predefinedID = predefinedID;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(IProvider provider) {
		if(provider instanceof PredefinedPropertyControllerProvider) {
			return ((PredefinedPropertyControllerProvider)provider).retrievePropertyEditorControllerDescriptor(getPredefinedID());
		}
		return null;
	}

	/**
	 * Returns the identifier of the controller to create
	 * 
	 * @return the identifier of the controller to create
	 */
	public String getPredefinedID() {
		return predefinedID;
	}

}
