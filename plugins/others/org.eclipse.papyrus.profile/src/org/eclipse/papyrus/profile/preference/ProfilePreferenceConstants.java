/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.preference;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Interface for constants for profile preferences
 */
public class ProfilePreferenceConstants {

	/** Constant for the expand stereotype tree preference */
	public final static String EXPAND_STEREOTYPES_TREE = "StereotypesTree.expandAll";

	/** Constant for the use of Stereotype icons in Outline */
	public final static String USE_STEREOTYPE_ICON_IN_OUTLINE = "StereotypesIcon.useInOutline";

	/**
	 * this method is used to store default preference of stereotype display.
	 * default is expanded
	 * 
	 * @param store
	 *        the preference store used to manage persistent properties
	 */
	public static void setDefaultPreferences(IPreferenceStore store) {
		store.setDefault(EXPAND_STEREOTYPES_TREE, true);
		store.setDefault(USE_STEREOTYPE_ICON_IN_OUTLINE, true);
	}
}
