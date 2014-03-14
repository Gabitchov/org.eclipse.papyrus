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
public class ModelQueryNotFoundException extends RuntimeException {

	/** serial version UID */
	private static final long serialVersionUID = 7224687861468142052L;
	
	/** name of the model query to find */
	private final String modelQueryName;

	/**
	 * Creates a new {@link ModelQueryNotFoundException}.
	 * @param modelQueryName the name of the query to find
	 */
	public ModelQueryNotFoundException(String modelQueryName) {
		this.modelQueryName = modelQueryName;
	}

	/**
	 * Returns the name of the model query to find
	 * @return the name of the model query to find
	 */
	public String getModelQueryName() {
		return modelQueryName;
	}
}
