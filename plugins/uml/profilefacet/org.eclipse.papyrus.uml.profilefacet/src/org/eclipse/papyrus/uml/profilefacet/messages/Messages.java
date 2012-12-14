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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.profilefacet.messages.messages"; //$NON-NLS-1$

	public static String AdditionalContentsUtils_ProfileEFacetDescription;

	public static String FacetOperationRegistry_RequiredFacetNotFound;

	public static String FacetOperationRegistry_RequiredFacetOperationNotFound;

	public static String ProfileFacetSetDestroyer_DestroyProfileFacetSetCommand;

	public static String ProfileFacetSetDestroyer_ErrorMessageOnDeleteProfileFacetSet;
	public static String ProfileFacetSetDestroyer_RemoveColumns;

	public static String ProfileFacetSetDestroyer_RemoveFacetSetAppliedOnTheTable;

	public static String ProfileFacetSetDestroyer_RemoveProfileFacetSetForReappliedProfile;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
