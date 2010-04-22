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
	
	boolean loadResource(URI uri);
	
	// strategies:
	// 1: ask the user which resource is loaded
	// 2: load the model and all the controlled resources below
	// 3: load the model and all the controlled resources below and the profiles
	// 4: load the model and all the controlled resources below and the pathmaps and profiles defined in the preferences -- default
	// 5: load the model and the pathmaps and profiles not the controlled resources below
	// 6: load all

}
