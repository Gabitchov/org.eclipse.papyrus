/*******************************************************************************
 * Copyright (c) 2006 - 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.cpp.codegen.Activator;

/**
 * Utility class that returns the preference values
 * 
 * @author ansgar
 * 
 */
public class CppCodeGenUtils {

	protected static IPreferenceStore preferenceStore = null;

	public static String getHeaderSuffix() {
		initPreferenceStore();
		return preferenceStore.getString(CppCodeGenConstants.P_HEADER_SUFFIX);
	}

	public static String getBodySuffix() {
		initPreferenceStore();
		return preferenceStore.getString(CppCodeGenConstants.P_IMPLEM_SUFFIX);
	}

	public static String getCommentHeader() {
		initPreferenceStore();
		return preferenceStore.getString(CppCodeGenConstants.P_COMMENT_HEADER);
	}

	public static void initPreferenceStore() {
		if(preferenceStore == null) {
			preferenceStore = Activator.getDefault().getPreferenceStore();
		}
	}

}
