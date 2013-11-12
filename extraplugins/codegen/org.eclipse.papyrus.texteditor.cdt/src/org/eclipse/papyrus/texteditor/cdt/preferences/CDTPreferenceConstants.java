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
package org.eclipse.papyrus.texteditor.cdt.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class CDTPreferenceConstants {

	/**
	 * Default option for opening the editor at a specified location. Store uses directly the SWT constants
	 */
	public static final String P_OPEN_LOCATION = "openLocation"; //$NON-NLS-1$

	/**
	 * For attributes, the default "aggregation kind" value is "none". When this option is set
	 * it will be treated as composite
	 */
	public static final String P_SYNC_PERMANENTLY = "syncPermanently"; //$NON-NLS-1$

	public static final String P_SYNC_ALL_FILES = "syncAllFiles"; //$NON-NLS-1$
}
