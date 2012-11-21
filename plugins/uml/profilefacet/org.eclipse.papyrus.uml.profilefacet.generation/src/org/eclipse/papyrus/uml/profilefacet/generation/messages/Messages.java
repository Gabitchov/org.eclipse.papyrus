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
package org.eclipse.papyrus.uml.profilefacet.generation.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.profileefacet.generation.messages.messages"; //$NON-NLS-1$

	public static String ProfileEFacetGenericFactory_FacetAttributeDocumentation;

	public static String ProfileEFacetGenericFactory_FacetDocumentation;

	public static String ProfileEFacetGenericFactory_FacetReferenceDocumentation;

	public static String ProfileEFacetGenericFactory_FacetSetDocumentation;

	public static String ProfileEFacetGenericFactory_TypeNotManagedMessage;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
