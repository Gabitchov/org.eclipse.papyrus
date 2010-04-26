/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.utils;

import org.eclipse.emf.common.util.URI;


/**
 * The Interface ILoadingStrategy that manages several strategies to load the model
 */
public interface ILoadingStrategy {
	
	/**
	 * Check if the resource from the uri need to be loaded accoding to the strategy
	 *
	 * @param uri
	 * @return true if resource must be loaded, return false otherwise
	 */
	boolean loadResource(URI uri);
	
	// AR  : additional resources (types, profiles ...)
	// parents : set of elements containing the current selection
	// currents : the resource opened
	// children : the resources bellow the current selection
	
	// strategy 1: all : AR U parents U currents U children
	// strategy 2: only one : AR U currents
	// strategy 3: bellow : AR U children U currents 
	// strategy 4: ask the user the needed resources he wants to load (need an UI) 
}
