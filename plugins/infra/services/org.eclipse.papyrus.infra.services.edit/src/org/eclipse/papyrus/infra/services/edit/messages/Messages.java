/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.edit.messages;

import org.eclipse.osgi.util.NLS;

/**
 * Internationalization messages class.
 */
public class Messages extends NLS {

	public static String ElementTypeValidator_NoSelection;
	public static String ElementTypeValidator_ValidSelection;
	public static String ElementTypeValidator_InvalidSelection;
	
	public static String TypeContext_ContextNotFound;
	
	public static String ElementEditServiceProvider_UnexpectedParameterType;
	public static String ElementEditServiceProvider_NoIElementTypeFound;
	
	public static String ElementEditServiceUtils_UnableToFindElementType;
	public static String ElementEditServiceUtils_UnableToFindServiceProvider;
	
	static {
		NLS.initializeMessages("messages", Messages.class); //$NON-NLS-1$
	}

	private Messages() {
	}
}
