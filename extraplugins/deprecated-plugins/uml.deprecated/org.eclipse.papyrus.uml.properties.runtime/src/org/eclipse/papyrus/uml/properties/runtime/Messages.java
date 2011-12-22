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
package org.eclipse.papyrus.uml.properties.runtime;

import org.eclipse.osgi.util.NLS;

/**
 * Internationalization class.
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.properties.runtime.messages"; //$NON-NLS-1$

	/** feature of AssociationEndOwnerModelHandler_ComboValue_Association */
	public static String AssociationEndOwnerModelHandler_ComboValue_Association;

	/** feature of AssociationEndOwnerModelHandler_ComboValue_Class */
	public static String AssociationEndOwnerModelHandler_ComboValue_Class;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
