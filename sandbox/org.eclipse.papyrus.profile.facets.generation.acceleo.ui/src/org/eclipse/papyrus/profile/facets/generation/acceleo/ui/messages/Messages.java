/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.profile.facets.generation.acceleo.ui.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.profile.facets.generation.acceleo.ui.messages"; //$NON-NLS-1$

	public static String GenerateFacetsHandler_message_add_nature;

	public static String GenerateFacetsHandler_message_datatype_are_not_handled;

	public static String GenerateFacetsHandler_message_missing_nature;

	public static String GenerateFacetsHandler_message_not_a_java_project;

	public static String GenerateFacetsHandler_Title_Problem_during_facets_generation;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
