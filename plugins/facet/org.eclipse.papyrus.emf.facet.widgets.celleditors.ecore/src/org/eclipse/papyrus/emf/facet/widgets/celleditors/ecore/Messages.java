/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.ecore;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.emf.facet.widgets.celleditors.ecore.messages"; //$NON-NLS-1$
	public static String MultiLineDialog_enterAValue;
	static {
		// initialize resource bundle
		NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
