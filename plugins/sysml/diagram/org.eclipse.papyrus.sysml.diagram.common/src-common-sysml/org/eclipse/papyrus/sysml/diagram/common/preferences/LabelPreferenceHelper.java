/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.preferences;

/**
 * Utility class for building label preference constants.
 */
public class LabelPreferenceHelper {

	/**
	 * Create the preference constant for a label view.
	 * 
	 * @param diagramType
	 *        the type of diagram
	 * @param viewType
	 *        the type of the view
	 * @param constantPreferenceKey
	 *        the constant key of the preference to retrieve
	 * @return the complete preference key
	 * @deprecated see https://bugs.eclipse.org/bugs/show_bug.cgi?id=353193 
	 */
	@Deprecated
	public static String getPreferenceConstant(String diagramType, String viewType, String constantPreferenceKey) {
		return diagramType + '_' + viewType + '.' + constantPreferenceKey;
	}

	/**
	 * Create the preference constant for a label view.
	 * 
	 * @param elementkey
	 *        the element key (including diagram hint)
	 * @param constantPreferenceKey
	 *        the constant key of the preference to retrieve
	 * @return the complete preference key
	 */
	public static String getPreferenceConstant(String elementkey, String constantPreferenceKey) {
		return elementkey + '.' + constantPreferenceKey;
	}
}
