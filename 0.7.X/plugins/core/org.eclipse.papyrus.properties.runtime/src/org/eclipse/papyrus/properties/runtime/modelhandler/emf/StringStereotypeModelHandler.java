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
package org.eclipse.papyrus.properties.runtime.modelhandler.emf;


/**
 * Model Handler for String-typed stereotypes properties
 */
public class StringStereotypeModelHandler extends EMFStereotypeFeatureModelHandler {

	/** identifier for this model handler */
	public final static String ID = "StringStereotype";

	/**
	 * Creates a new StringStereotypeModelHandler.
	 * 
	 * @param stereotypeName
	 *        the name of the stereotype that holds the feature to modify
	 * @param featureName
	 *        the name of the feature to modify
	 */
	public StringStereotypeModelHandler(String stereotypeName, String featureName) {
		super(stereotypeName, featureName);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return ID;
	}

}
