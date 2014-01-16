/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.preferences;


/**
 * 
 * @author VL222926
 * 
 */
public class TablePreferencesConstantsHelper {

	private TablePreferencesConstantsHelper() {
		//to prevent instanciation
	}

	/**
	 * Prefix for preference for Papyrus nattable Level editor
	 */
	public static String PAPYRUS_TABLE_EDITOR_PREFERENCE_PREFIX = "PAPYRUS_TABLE_EDITOR"; //$NON-NLS-1$

	/**
	 * Prefix for preference for Diagram Level
	 */
	public static String TABLE_PREFERENCE_PREFIX = "NATTABLE_"; //$NON-NLS-1$

	/**
	 * Prefix for preference for element Level
	 */
	public static String TABLE_ELEMENT = "TABLE_ELEMENT_"; //$NON-NLS-1$


	/**
	 * Get the preference constant used to store the preference of an element.
	 * 
	 * @param elementName
	 *        the name of the element
	 * @param preferenceType
	 *        the type of preference to store. It must be a value defined in {@link TablePreferencesConstantsHelper}
	 * @return the constant used.
	 */
	public static String getConstant(String elementName, int preferenceType) {
		throw new UnsupportedOperationException("Not yet implemented");//$NON-NLS-1$
		//		StringBuffer sb = new StringBuffer();
		//		sb.append(elementName);
		//		sb.append("."); //$NON-NLS-1$
		//		switch(preferenceType) {
		//
		//		default:
		//			break;
		//		}
		//		return sb.toString();
	}

	/**
	 * 
	 * @param preferenceType
	 *        the type of preference to store. It must be a value defined in {@link TablePreferencesConstantsHelper}
	 * @return get the preference key at the papyrus editor level
	 */
	public static String getPapyrusEditorConstant(int preferenceType) {
		return getConstant(PAPYRUS_TABLE_EDITOR_PREFERENCE_PREFIX, preferenceType);
	}

	/**
	 * 
	 * @param diagramKind
	 *        the kind of diagram.
	 * @param preferenceType
	 *        the type of preference to store. It must be a value defined in {@link PreferenceConstantHelper}
	 * @return the preference key at the diagram level
	 */
	public static String getNatTableConstant(String tableKind, int preferenceType) {
		return TABLE_PREFERENCE_PREFIX + getConstant(tableKind, preferenceType);
	}
}
