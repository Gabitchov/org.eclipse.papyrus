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
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;

/**
 * Constants for the extension point aspectActionConfiguration (registering models containing definition of {@link ActionConfiguration}).
 */
public interface IAspectTypeExtensionPoint {

	/** ID of the extension point */
	public final static String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".aspectActionConfiguration";

	/** attribute: name of the configuration */
	public static final String NAME = "name";

	/** attribute: icon of the configuration */
	public static final String ICON = "icon";

	/** attribute: description of the configuration */
	public static final String DESCRIPTION = "description";

	public static final String CONTAINER_DESCRIPTOR_CLASS = "semanticTypeDescriptor";

	public static final String EDIT_HELPER_ADVICE_CLASS = "editHelperAdvice";
	
	public static final String CONFIGURATION_CLASS = "configurationClass";

	public static final String CONFIGURATION_MODEL_CREATION = "configurationModelCreation";

	public static final String CREATION_ELEMENT_VALIDATOR_CLASS = "creationElementValidator"; 
}
