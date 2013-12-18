/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.papyrus.infra.extendedtypes.Activator;


/**
 * Extension point interface for {@link MatcherConfiguration} runtime implementations
 */
public interface IElementMatcherExtensionPoint {
	
	/** ID of the extension point */
	public final static String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".elementMatcherConfiguration";
	
	public static final String CONFIGURATION_NAME = "name";

	public static final String MATCHER_CONFIGURATION_CLASS = "configurationClass";
	
	public static final String MATCHER_FACTORY_CLASS = "factoryClass";

	public static final String CONFIGURATION_MODEL_CREATION = "configurationModelCreation";
	
}
