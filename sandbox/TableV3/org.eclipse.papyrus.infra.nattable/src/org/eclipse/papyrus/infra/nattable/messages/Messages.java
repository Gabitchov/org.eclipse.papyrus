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
package org.eclipse.papyrus.infra.nattable.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.nattable.messages.messages"; //$NON-NLS-1$

	public static String CompositeAxisManager_DestroyAxisCommand;

	public static String AbstractCreateNattableEditorHandler_EnterTheNameForTheNewTable;

	public static String AbstractCreateNattableEditorHandler_PapyrusTableCreation;

	public static String AbstractTableHandler_CurrentEditorCantBeFound;

	public static String AxisManagerFactory_TheClassCantBeInstanciated;

	public static String CompositeAxisManager_AddAxisCommand;

	public static String CornerDataProvider_InvertAxis;

	public static String DeleteNatTableContextAdvice_DestroyNattableCommand;

	public static String EditConfiguration_ConfigurationFactoryNotFound;

	public static String EditConfiguration_ConfigurationNotFound;

	public static String EditConfiguration_DeclarationNotYetSupported;

	public static String EditConfiguration_FactoryHandlesElementButDoesntProvideEditor;

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

	public static String AbstractUMLTableEFacetEditor_UMLTableCreationErrorMessage;

	public static String ColumnsToShowDialog_AdditionalFeatures;

	public static String ColumnsToShowDialog_AdvancedMode;

	public static String ColumnsToShowDialog_default_columns;

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

	public static String PasteInPapyrusTableCommandProvider_0;

	public static String PasteInPapyrusTableCommandProvider_1;

	public static String PasteInPapyrusTableCommandProvider_2;

	public static String PasteInPapyrusTableCommandProvider_3;

	public static String PasteInPapyrusTableCommandProvider_Pasting;

	public static String PasteInPapyrusTableCommandProvider_PastingInTable;

	public static String PasteInPapyrusTableCommandProvider_ProblemsToSetPropertyValue;

	public static String PasteInPapyrusTableCommandProvider_ProblemToApplyStereotype;

	public static String PasteInPapyrusTableCommandProvider_ProblemToSetStereotypeValue;

	public static String PasteInPapyrusTableCommandProvider_RequiredStereotypeCantBeFound;

	public static String PasteInPapyrusTableCommandProvider_RequiredStereotypeNotApplied;

	public static String PasteInPapyrusTableCommandProvider_StereotypePropertyCantBeResolved;

	public static String PasteInPapyrusTableCommandProvider_TheEnumerationLiteralCantBeFound;

	public static String PasteInPapyrusTableCommandProvider_TheStereotypeCantBeApplied;

	public static String PasteInPapyrusTableCommandProvider_TheTextCantBeMappedOnAnExistingElement;

	public static String PasteInTableHandler_PasteCancelled;

	public static String PasteInTableHandler_PasteCreation;

	public static String PasteInTableHandler_ThePasteCommandCantBeExecuted;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
