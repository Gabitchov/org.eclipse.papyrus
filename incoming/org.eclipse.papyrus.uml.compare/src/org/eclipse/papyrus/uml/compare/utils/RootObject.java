/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.utils;



/**
 * 
 * This class allows to recognize easily the root object in the viewer.
 * This class was introduced for comparison from the ModelExplorer
 * 
 */
public class RootObject {

	/**
	 * the key for the left root object
	 */
	public static final String LEFT_OBJECT_KEY = "leftObject";

	/**
	 * the key for the right root object
	 */
	public static final String RIGHT_OBJECT_KEY = "rightObject"; //TODO useful 

	/** The represented object. */
	private Object representedObject = null;

	/**
	 * Instantiates a new root object.
	 * 
	 * @param object
	 *        the object
	 */
	public RootObject(final Object object) {
		this.representedObject = object;
	}

	/**
	 * Gets the represented object.
	 * 
	 * @return the represented object
	 */
	public Object getRepresentedObject() {
		return this.representedObject;
	}
}
