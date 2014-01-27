/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.codegen;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.facade.codegen.messages"; //$NON-NLS-1$

	public static String GenerateCodeAction_0;

	public static String GenerateFacadeAction_0;

	public static String GenerateFacadeAction_1;

	public static String GenerateFacadeAction_3;

	public static String GenerateFacadeAction_5;

	public static String GenerateFacadeAction_6;

	public static String FacadeCodegenUtils_48;

	public static String FacadeCodegenUtils_49;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
