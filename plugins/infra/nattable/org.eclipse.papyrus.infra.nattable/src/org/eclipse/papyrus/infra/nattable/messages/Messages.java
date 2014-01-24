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

	public static String CellManagerFactory_CellManagerNotFound;

	public static String CompositeAxisManager_DestroyAxisCommand;

	public static String AbstractAxisManager_InputDialogMessage;

	public static String AbstractAxisManager_InputDialogTitle;

	public static String AbstractCreateNattableEditorHandler_EnterTheNameForTheNewTable;

	public static String AbstractCreateNattableEditorHandler_PapyrusTableCreation;

	public static String AbstractPasteImportInNattableManager_column;

	public static String AbstractPasteImportInNattableManager_EnablementStatusForPasteInTheTable;

	public static String AbstractPasteImportInNattableManager_INVERTED_MESSAGE;

	public static String AbstractPasteImportInNattableManager_NoPasteConfiguration;

	public static String AbstractPasteImportInNattableManager_NoPasteConfiguration2;

	public static String AbstractPasteImportInNattableManager_NumberOfColumnsAreEquals;

	public static String AbstractPasteImportInNattableManager_NumberOfColumnsAreNotEquals;

	public static String AbstractPasteImportInNattableManager_PasteColumnsError;

	public static String AbstractPasteImportInNattableManager_PasteRowsError;

	public static String AbstractPasteImportInNattableManager_row;

	public static String AbstractPasteImportInNattableManager_TheContextOfTheTableHasNotTheContainmentFeatureDefinedForThePaste;

	public static String AbstractPasteImportInNattableManager_TheContextOfTheTableHasTheContainmentFeatureDefinedForThePaste;

	public static String AbstractPasteImportInNattableManager_TheTableCanCreateElement;

	public static String AbstractPasteImportInNattableManager_TheTableCantCreateElement;

	public static String AbstractPasteImportInNattableManager_TheTableHasAConfigurationToPaste;

	public static String AbstractPasteImportInNattableManager_TheUserChosesToPasteColumns;

	public static String AbstractPasteImportInNattableManager_TheUserChosesToPasteRows;

	public static String AbstractPasteImportInNattableManager_WhatAreYouPasting;

	public static String AbstractSaveCurrentAxisProvidersHandler_0;

	public static String AbstractSaveCurrentAxisProvidersHandler_1;

	public static String AbstractSaveCurrentAxisProvidersHandler_2;

	public static String AbstractSaveCurrentAxisProvidersHandler_4;

	public static String AbstractSaveCurrentAxisProvidersHandler_5;

	public static String AbstractTableHandler_CurrentEditorCantBeFound;

	public static String AxisManagerFactory_AxisManagerClassCantBeLoaded;

	public static String AxisManagerFactory_TheClassCantBeInstanciated;

	public static String CompositeAxisManager_AddAxisCommand;

	public static String DeleteNatTableContextAdvice_DestroyNattableCommand;

	public static String EditConfiguration_ConfigurationFactoryNotFound;

	public static String EditConfiguration_ConfigurationNotFound;

	public static String EditConfiguration_DeclarationNotYetSupported;

	public static String EditConfiguration_FactoryHandlesElementButDoesntProvideEditor;

	public static String EObjectManager_AddAxisElement;

	public static String NattableConfigurationRegistry_ConfigurationNotFound;

	public static String NattableConfigurationRegistry_NoTesterForThisConfiguration;

	public static String NattableConfigurationRegistry_NoTypeForAConfiguration;

	public static String NattableConfigurationRegistry_ResourceEmpty;

	public static String NattableConfigurationRegistry_SeveralConfigurationsWithTheSameType;

	public static String NattableConfigurationRegistry_TableConfigurationNotFound;

	public static String NattableConfigurationRegistry_TesterNotFound;

	public static String NattableConfigurationRegistry_TesterNotManager;

	public static String NattableModelManager_ActionNotYetSupported;

	public static String NattableModelManager_AddColumnCommand;

	public static String NattableModelManager_AddRowCommand;

	public static String NattableModelManager_AtLeastOfOneTheAxisManagerMustBeAMaster;

	public static String NattableModelManager_CreateDestroyAxis;

	public static String NattableModelManager_DisableTheAutomaticAdditionOfColumnsWhenARowIsAdded;

	public static String NattableModelManager_DisableTheAutomaticAdditionOfRowsWhenAColumnIsAdded;

	public static String NattableModelManager_DisconnectAxisManagerCheckBoxMessage;

	public static String NattableModelManager_DisconnectAxisManagerCheckBoxTooltip;

	public static String NattableModelManager_DisconnectAxisManagerInformationDialogMessage;

	public static String NattableModelManager_DisconnectAxisManagerInformationDialogTitle;

	public static String NattableModelManager_DisconnectColumnAxisManager;

	public static String NattableModelManager_DisconnectColumnAxisManagerMessageInInformationDialog;

	public static String NattableModelManager_DisconnectThisAxisManager;

	public static String NattableModelManager_EditingDomainNotFound;

	public static String NattableModelManager_SelectColumns;

	public static String NattableModelManager_SelectRows;

	public static String NattableModelManager_ServiceRegistryNotFound;

	public static String NattableModelManager_SwitchLinesAndColumns;

	public static String NattableModelManager_TheCheckBoxHasNotBeenCheckedToAvoidAutomaticColumnAddition;

	public static String NattableModelManager_TheCheckBoxHasNotBeenCheckedToAvoidAutomaticRowAddition;

	public static String PrintTableHandler_PrintCantBeDone;

	public static String PrintTableHandler_TablePrint;

	public static String ProblemLabelProvider_StringsValuesCanBeResolved;

	public static String TableLabelProvider_ErrorGettingIconForTable;

	public static String TableTesterRegistry_SeveralTesterAreRegisteredWithTheSameId;

	public static String TableTesterRegistry_TheClassCantBeLoaded;

	public static String TextDelimiter_DoubleQuote;

	public static String TextDelimiter_Quote;

	public static String ICellManager_NotAvailable;

	public static String ImportCSVConfigurationPage_SelectTheTextDelimiter;

	public static String ImportCSVConfigurationPage_Separators;

	public static String ImportCSVConfigurationPage_TheCellSeparatorIsNotDefined;

	public static String ImportCSVConfigurationPage_TheCellSeparatorMustBeExcatlyOneChar;

	public static String ImportFilePage_BeSureThatYourImportFileHasTheSameNumberOfColumns;

	public static String ImportFilePage_SelectTheFileToImport;

	public static String ImportFilePage_TheImportedElementWillBeAddedTo;

	public static String ImportFilePage_YourFileWillBeImported;

	public static String ImportTableErrorPage_PleaseOpenAPapyrusEditor;

	public static String ImportTableWizard_ConfigureImport;

	public static String ImportTableWizard_ImportTable;

	public static String ImportTableWizard_ImportTableError;

	public static String ImportTableWizard_ImportTableFromFileInPapyrusModel;

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

	public static String LoadCurrentAxisProvidersDialog_0;

	public static String LoadCurrentAxisProvidersDialog_1;

	public static String LoadCurrentAxisProvidersDialog_2;

	public static String LoadCurrentAxisProvidersDialog_3;

	public static String PasteConfigurationUtils_ContainementFeatureIsNotAReference;

	public static String PasteConfigurationUtils_ContainmentFeatureIsNotAReferenceContainment;

	public static String PasteConfigurationUtils_ContainmentFeatureIsNull;

	public static String PasteConfigurationUtils_CreatesElementsAreNotCompatibleWithContainmentFeature;

	public static String PasteConfigurationUtils_ElementIdNotDefined;

	public static String PasteConfigurationUtils_ElementTypeCantBeFound;

	public static String PasteConfigurationUtils_PasteConfigurationIsConsistent;

	public static String PasteEObjectAxisInTableCommandProvider_AddingElementToTheTable;

	public static String PasteEObjectAxisInTableCommandProvider_CommandCreationHasBeenCancelled;

	public static String PasteEObjectAxisInTableCommandProvider_CreatingAnumberXonY;

	public static String PasteEObjectAxisInTableCommandProvider_DoingAdditionalActions;

	public static String PasteEObjectAxisInTableCommandProvider_FinishingThePaste;

	public static String PasteEObjectAxisInTableCommandProvider_LinkingReferencesToTheModel;

	public static String PasteEObjectAxisInTableCommandProvider_PasteAction;

	public static String PasteEObjectAxisInTableCommandProvider_PasteColumns;

	public static String PasteEObjectAxisInTableCommandProvider_PasteFromStringCommand;

	public static String PasteEObjectAxisInTableCommandProvider_PasteRows;

	public static String PasteImportStatusDialog_ImportPasteDialogTitle;

	public static String PasteImportStatusDialog_PasteConfigurationMessage;

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
	public static String PasteSeparator_Comma;

	public static String PasteSeparator_Other;

	public static String PasteSeparator_Semicolon;

	public static String PasteSeparator_Space;

	public static String PasteSeparator_Tabulation;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
