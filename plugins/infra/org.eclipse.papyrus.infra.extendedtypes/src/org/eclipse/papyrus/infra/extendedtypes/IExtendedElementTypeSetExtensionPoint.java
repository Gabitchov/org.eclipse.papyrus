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


/**
 * Constants for the extension point ExtendedTypesSet (registering models containing definition of {@link ExtendedElementTypeSet}).
 */
public interface IExtendedElementTypeSetExtensionPoint {

	/** ID of the extension point */
	public final static String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".extendedElementTypeSet";

	/** attribute: path to the model file in the bundle */
	public static final String PATH = "path";

	/** attribute: identifier of the contribution */
	public static final String ID = "id";

	/** attribute: name of the configuration */
	public static final String NAME = "name";

	/** attribute: icon of the configuration */
	public static final String ICON = "icon";

	/** attribute: description of the configuration */
	public static final String DESCRIPTION = "description";

	/** element: element for the configuration element */
	public static final String CONFIGURATION = "configuration";
}
