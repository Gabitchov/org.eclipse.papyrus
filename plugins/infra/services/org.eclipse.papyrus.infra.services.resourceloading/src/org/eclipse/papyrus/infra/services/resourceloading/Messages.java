/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos) vincent.hemery@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.resourceloading;

import org.eclipse.osgi.util.NLS;

/**
 * This class handles messages internationalization
 * 
 * @author vhemery
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.services.resourceloading.messages"; //$NON-NLS-1$

	/** Error message */
	public static String LoadingUtils_ErrorMessage;

	/** Error popup title */
	public static String LoadingUtils_ErrorTitle;

	/** Load models task name */
	public static String LoadingUtils_LoadModelsTask;

	/** Resfresh pages task name */
	public static String LoadingUtils_RefreshPagesTask;

	/** Unload models task name */
	public static String LoadingUtils_UnloadModelsTask;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
