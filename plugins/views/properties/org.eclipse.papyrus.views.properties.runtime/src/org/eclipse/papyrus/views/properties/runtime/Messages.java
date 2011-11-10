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
package org.eclipse.papyrus.views.properties.runtime;

import org.eclipse.osgi.util.NLS;

/**
 * Messages internationalization class
 */
public class Messages extends NLS {

	/** bundle name */
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.views.properties.runtime.messages"; //$NON-NLS-1$

	/** Label for the Menu: CreationOperation */
	public static String EMFTEReferenceController_CreationOperationMenuLabel;

	/** Label for the Operation: Destroy operation */
	public static String EMFTEReferenceController_DeleteElement_OperationLabel;

	public static String ReferenceEMFModelHandler_Select_Values;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	/**
	 * Creates a new Messages.
	 */
	private Messages() {
	}
}
