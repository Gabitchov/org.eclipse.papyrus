/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.efacet.common.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.table.efacet.common.messages.messages"; //$NON-NLS-1$

	public static String AbstractUMLTableEFacetEditor_UMLTableCreationErrorMessage;

	public static String ColumnsToShowDialog_AdditionalFeatures;

	public static String ColumnsToShowDialog_AdvancedMode;

	public static String ColumnsToShowDialog_DeselectAll;

	public static String ColumnsToShowDialog_DeselectAllAvailableAdditionalFeatures;

	public static String ColumnsToShowDialog_DeselecteAllAvailableFeatures;

	public static String ColumnsToShowDialog_DeselectedAll;

	public static String ColumnsToShowDialog_DirectFeatures;

	public static String ColumnsToShowDialog_SelecColumnsToShow;

	public static String ColumnsToShowDialog_SelectAll;

	public static String ColumnsToShowDialog_SelectAllAvailableAdditionalFeatures;

	public static String ColumnsToShowDialog_SelectAllAvailablesFeatures;

	public static String ColumnsToShowDialog_ShowAllPossibilities;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
