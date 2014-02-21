/*******************************************************************************
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software)
 *     Gregoire Dupe (Mia-Software) - Bug 366804 - [Restructuring] Table widget upgrade
 *     Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *******************************************************************************/
package org.eclipse.emf.facet.util.core.internal;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
	private static String BUNDLE_NAME = "org.eclipse.emf.facet.util.core.internal.messages"; //$NON-NLS-1$
	public static String AbstractRegistry_id;
	public static String AbstractRegistry_colon;
	public static String AbstractRegistry_requiredAttributeNotDefined;
	public static String AbstractRegistry_unknownExtensionTag;
	public static String AbstractRegistry_pluginExtension;
	public static String StringUtils_ellipsis;

	static {
		// initialize resource bundle
		NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		// Nothing
	}
}
