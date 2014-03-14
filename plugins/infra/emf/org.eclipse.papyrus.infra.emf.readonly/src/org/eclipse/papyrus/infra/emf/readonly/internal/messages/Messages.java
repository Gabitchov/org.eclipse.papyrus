/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.emf.readonly.internal.messages;

import org.eclipse.osgi.util.NLS;

/**
 * This is the Messages type.  Enjoy.
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.emf.readonly.internal.messages.messages"; //$NON-NLS-1$

	public static String ReferencedModelReadOnlyHandler_promptMsg;

	public static String ReferencedModelReadOnlyHandler_promptTitle;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
