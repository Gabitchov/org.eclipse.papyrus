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
package org.eclipse.papyrus.infra.export.actions;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.export.actions.messages"; //$NON-NLS-1$

	public static String ExportAllDiagramsDialog_0;

	public static String ExportAllDiagramsDialog_1;

	public static String ExportAllDiagramsDialog_2;

	public static String ExportAllDiagramsDialog_3;

	public static String ExportAllDiagramsDialog_btnCheckButton_text;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
