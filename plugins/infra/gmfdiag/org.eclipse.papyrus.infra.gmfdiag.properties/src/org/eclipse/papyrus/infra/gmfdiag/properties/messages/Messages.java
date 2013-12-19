/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.properties.messages.messages"; //$NON-NLS-1$

	public static String DecoratedModelElement_CENTER;

	public static String DecoratedModelElement_EAST;

	public static String DecoratedModelElement_NORTH;

	public static String DecoratedModelElement_NORTH_EAST;

	public static String DecoratedModelElement_NORTH_WEST;

	public static String DecoratedModelElement_SOUTH;

	public static String DecoratedModelElement_SOUTH_EAST;

	public static String DecoratedModelElement_SOUTH_WEST;

	public static String DecoratedModelElement_WEST;

	public static String DiagramPreferencesDefaultButton_ResetDefault;

	public static String GradientDataModelElement_Horizontal;

	public static String GradientDataModelElement_Vertical;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
