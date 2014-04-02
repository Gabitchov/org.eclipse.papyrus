/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions;

import org.eclipse.osgi.util.NLS;

public class DiagramUIActionsMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.diagram.menu.actions.messages"; //$NON-NLS-1$

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DiagramUIActionsMessages.class);
	}

	private DiagramUIActionsMessages() {
	}

	public static String PropertyDescriptorFactory_Font;
}
