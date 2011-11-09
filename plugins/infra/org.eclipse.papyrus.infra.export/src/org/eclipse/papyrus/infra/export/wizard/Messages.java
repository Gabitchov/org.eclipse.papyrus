/*******************************************************************************
 * Copyright (c) 2011 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anass RADOUANI (AtoS) 
 *******************************************************************************/

package org.eclipse.papyrus.infra.export.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.export.wizard.messages"; //$NON-NLS-1$

	public static String ExportAllWizard_0;

	public static String ExportDiagramsErrorPage_0;

	public static String ExportDiagramsErrorPage_2;

	public static String ExportDiagramsErrorPage_3;

	public static String ExportDiagramsPage_0;

	public static String ExportDiagramsPage_2;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
