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
package org.eclipse.papyrus.infra.nattable.common.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.nattable.common.messages.messages"; //$NON-NLS-1$

	public static String AbstractCreateNattableEditorHandler_EnterTheNameForTheNewTable;

	public static String AbstractCreateNattableEditorHandler_PapyrusTableCreation;

	public static String AbstractTableHandler_CurrentEditorCantBeFound;

	public static String AxisManagerFactory_TheClassCantBeInstanciated;

	public static String CompositeAxisManager_AddAxisCommand;

	public static String CornerDataProvider_InvertAxis;

	public static String EObjectManager_AddAxisElement;

	public static String NattableModelManager_AddColumnCommand;

	public static String NattableModelManager_AddRowCommand;

	public static String NattableModelManager_EditingDomainNotFound;

	public static String NattableModelManager_ServiceRegistryNotFound;

	public static String NattableModelManager_SwitchLinesAndColumns;

	public static String PrintTableHandler_PrintCantBeDone;

	public static String PrintTableHandler_TablePrint;

	public static String TableLabelProvider_ErrorGettingIconForTable;
	
	public static String ICellManager_NotAvailable;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
