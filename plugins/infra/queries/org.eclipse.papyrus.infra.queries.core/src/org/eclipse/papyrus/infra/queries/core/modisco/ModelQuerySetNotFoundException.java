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
package org.eclipse.papyrus.infra.queries.core.modisco;

/**
 * Exception thrown when the query set can not be found
 */
public class ModelQuerySetNotFoundException extends RuntimeException {

	/** serial version UID */
	private static final long serialVersionUID = -3189129139020152378L;
	
	/** name of the model query set to find */
	private final String modelQuerySetName;

	/**
	 * Creates a new {@link ModelQuerySetNotFoundException}.
	 * @param modelQuerySetName the name of the model query set not found
	 */
	public ModelQuerySetNotFoundException(String modelQuerySetName) {
		this.modelQuerySetName = modelQuerySetName;
	}

	/**
	 * Returns the name of the model query set to find
	 * @return the name of the model query set to find
	 */
	public String getModelQuerySetName() {
		return modelQuerySetName;
	}
}
