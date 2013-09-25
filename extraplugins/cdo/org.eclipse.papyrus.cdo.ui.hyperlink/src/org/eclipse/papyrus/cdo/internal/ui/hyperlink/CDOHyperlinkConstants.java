/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.hyperlink;

import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;


/**
 * This is the CDOHyperlinkConstants type. Enjoy.
 */
public final class CDOHyperlinkConstants {

	public static final String HYPERLINK_ANNOTATION_SOURCE = HyperLinkConstants.PAPYRUS_HYPERLINK_PREFIX + "CDO_resource"; //$NON-NLS-1$

	public static final String HYPERLINK_DETAIL_URI = "uri"; //$NON-NLS-1$

	/**
	 * Not instantiable by clients.
	 */
	private CDOHyperlinkConstants() {
		super();
	}

}
