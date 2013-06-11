/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 * Emilien Perico (Atos Origin) - add tags for links with keywords
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

	public static String ElementImportParser_undefined_value;

	public static String IconStylePreferencePage_cheerful_style;

	public static String IconStylePreferencePage_eclipse_style;

	public static String IconStylePreferencePage_icon_style_group;

	public static String ModelElementSelectionPageMessage;

	public static String UMLNewDiagramFileWizard_RootSelectionPageSelectionTitle;

	public static String UMLNewDiagramFileWizard_RootSelectionPageNoSelectionMessage;

	public static String UMLNewDiagramFileWizard_RootSelectionPageInvalidSelectionMessage;

	public static String UMLNewDiagramFileWizard_CreationPageName;

	public static String UMLNewDiagramFileWizard_CreationPageTitle;

	public static String UMLNewDiagramFileWizard_CreationPageDescription;

	public static String UMLNewDiagramFileWizard_RootSelectionPageName;

	public static String UMLNewDiagramFileWizard_RootSelectionPageTitle;

	public static String UMLNewDiagramFileWizard_RootSelectionPageDescription;

	public static String UMLDiagramEditorUtil_CreateDiagramProgressTask;

	public static String UMLDiagramEditorUtil_CreateDiagramCommandLabel;

	public static String UMLInitDiagramFileAction_InitDiagramFileResourceErrorDialogTitle;

	public static String UMLInitDiagramFileAction_InitDiagramFileResourceErrorDialogMessage;

	public static String UMLInitDiagramFileAction_InitDiagramFileWizardTitle;

	public static String UMLNewDiagramFileWizard_DiagramKindTitle;

	public static String UMLNewDiagramFileWizard_DiagramKindDescription;

	public static String RotateAction_rotate_command;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

	/** Label to be displayed on {@link org.eclipse.uml2.uml.Abstraction} links */
	public static String AppliedStereotypeLabel_AbstractionTag;

	/**
	 * Label to be displayed on {@link org.eclipse.uml2.uml.PackageImport} links
	 */
	public static String AppliedStereotypeLabel_PackageImportTag;

	/**
	 * Label to be displayed on {@link org.eclipse.uml2.uml.PackageImport} links
	 * with reduced visibility
	 */
	public static String AppliedStereotypeLabel_PackageImportAccessTag;

	/** Label to be displayed on {@link org.eclipse.uml2.uml.PackageMerge} links */
	public static String AppliedStereotypeLabel_PackageMergeTag;

	/** Label to be displayed on {@link org.eclipse.uml2.uml.Usage} links */
	public static String AppliedStereotypeLabel_UsageTag;

	// ///////////////////////// Palette Customisation
	// /////////////////////////////////////
	/** Tooltip for the add button */
	public static String PapyrusPaletteCustomizerDialog_AddButtonTooltip;

	/** Tooltip for the remove button */
	public static String PapyrusPaletteCustomizerDialog_RemoveButtonTooltip;

	/** LAbel for the standard group */
	public static String StandardGroup_Label;

	/** label for the palette action in the palette viewer menu */
	public static String Palette_Action_Label;

	/** tooltip for the palette action in the palette viewer menu */
	public static String Palette_Action_Tooltip;

	/** label for the available palettes viewer */
	public static String Available_Palettes;

	/** label for the palette tree viewer */
	public static String Palette_Viewer;

	/** label for the palette name in the wizard */
	public static String Local_Palette_Name;

	/** label for the palette id in the wizard */
	public static String Local_Palette_Id;

	/** label for the editor id in the palette wizard */
	public static String Local_Palette_Editor_Id;

	/** tooltip for the palette name in the palette wizard */
	public static String Local_Palette_Name_Tooltip;

	/** tooltip for the palette id in the palette wizard */
	public static String Local_Palette_Id_Tooltip;

	/** tooltip for the editor id in the palette wizard */
	public static String Local_Palette_Editor_Id_Tooltip;

	/** label for the provider priority in the palette wizard */
	public static String Local_Palette_Priority;

	/** tooltip for the provider priority in the palette wizard */
	public static String Local_Palette_Priority_Tooltip;

	/** label for the advanced button, when advanced are not shown */
	public static String Dialog_Advanced_Button_Closed;

	/** label for the advanced button, when advanced are shown */
	public static String Dialog_Advanced_Button_Opened;

	/** Error message for the wizard page, when priority is not correctly filled */
	public static String Local_Palette_Error_Priority;

	/**
	 * Error message for the wizard page, when palette ID is not correctly
	 * filled
	 */
	public static String Local_Palette_Error_PaletteId;

	/** Error message for the wizard page, when name is not correctly filled */
	public static String Local_Palette_Error_Name;

	/**
	 * Error message for the wizard page, when Editor ID is not correctly filled
	 */
	public static String Local_Palette_Error_EditorId;

	/** Name of the information page */
	public static String Local_Palette_InfoPage_Name;

	/** Title of the information page */
	public static String Local_Palette_InfoPage_Title;

	/** Name of the content page */
	public static String Local_Palette_ContentPage_Name;

	/** Title of the content page */
	public static String Local_Palette_ContentPage_Title;

	/** name of the available tools group */
	public static String Local_Palette_Available_Tools;

	/** tooltip for the show/hide drawer button */
	public static String Local_Palette_ShowDrawers_Tooltip;

	/** tooltip for the show/hide drawer button */
	public static String Local_Palette_ShowTools_Tooltip;

	/** palette preview label */
	public static String Local_Palette_Palette_Preview;

	/** Title for dialog box when palette to delete is not a local palette */
	public static String Dialog_Not_Local_Palette_Title;

	/** Message for dialog box when palette to delete is not a local palette */
	public static String Dialog_Not_Local_Palette_Message;

	/** tooltip for the delete palette button */
	public static String Dialog_Delete_Palette_Tooltip;

	/** tooltip for the create palette button */
	public static String Dialog_Create_Palette_Tooltip;

	/** tooltip for the edit palette button */
	public static String Dialog_Edit_Palette_Tooltip;

	/** Message for horizontal distribution */
	public static String DistributionConstants_Distribute_Horizontally;

	/** Message for horizontal distribution between nodes */
	public static String DistributionConstants_Distribute_Horizontally_Between_Nodes;

	/** Message for vertical distribution */
	public static String DistributionConstants_Distribute_Vertically;

	/** Message for vertical distribution between nodes */
	public static String DistributionConstants_Distribute_Vertically_Between_Nodes;

	/** Title for the distribution menu */
	public static String DistributionConstants_DistributionTitle;

	/** tooltip for the create drawer button */
	public static String Local_Palette_Create_Drawer_Tooltip;

	/** tooltip for the create separator button */
	public static String Local_Palette_Create_Separator_Tooltip;

	/** tooltip for the create stack button */
	public static String Local_Palette_Create_Stack_Tooltip;

	/** name of the drawer wizard page */
	public static String Wizard_Drawer_Page_Name;

	/** title of the drawer wizard page */
	public static String Wizard_Drawer_Page_Title;

	/** error on the name in the drawer wizard */
	public static String Wizard_Drawer_Error_Name;

	/** error on the id in the drawer wizard */
	public static String Wizard_Drawer_Error_Id;

	/** error on the icon in the drawer wizard */
	public static String Wizard_Drawer_Error_Icon;

	/** label for the id field */
	public static String Wizard_Drawer_Id;

	/** tooltip for the id field */
	public static String Wizard_Drawer_Id_Tooltip;

	/** label for the name field */
	public static String Wizard_Drawer_Name;

	/** tooltip for the name field */
	public static String Wizard_Drawer_Name_Tooltip;

	/** tooltip for the icon field */
	public static String Wizard_Drawer_Icon_Tooltip;

	/** name for the icon field */
	public static String Wizard_Drawer_Icon;

	/** tooltip for the tool item */
	public static String Local_Palette_SwitchToolsContentProvider_Tooltip;

	/** tooltip for the disabled action because of missing profiles */
	public static String PaletteContextMenu_MissingProfile;

	/**
	 * tooltip for the edit local palette action disabled because of bad
	 * selection
	 */
	public static String PapyrusPaletteCustomizerDialog_EditButtonTooltip_LocalPaletteNotSelected;

	/** tooltip for the edit local palette action */
	public static String PapyrusPaletteCustomizerDialog_EditButtonTooltip_LocalPaletteSelected;

	/**
	 * tooltip for the edit local palette action disabled because of missing
	 * profiles
	 */
	public static String PapyrusPaletteCustomizerDialog_EditButtonTooltip_MissingProfile;

	/** label for the name text editor for a given proxy */
	public static String Local_Palette_Entry_Name;

	/** label for the description editor for a given proxy */
	public static String Local_Palette_Entry_Description;

	/** label for the group information about entry */
	public static String Local_Palette_Entry_Information;

	/** label for the icon information about entry */
	public static String Local_Palette_Entry_Icon;

	/** label for the referenced entry information about entry */
	public static String Local_Palette_Entry_Reference;

	/** label for the composite displaying the lis of aspect actions */
	public static String Aspect_Action_Information_List_Label;

	/** label for the tooltip of the edit drawer icon */
	public static String PapyrusPaletteCustomizerDialog_EditButtonTooltip;

	/** message when many resources have changed (including main) */
	public static String PartActivationListener_ChangedMainMsg_many;

	/** message when main resource has changed */
	public static String PartActivationListener_ChangedMainMsg_single;

	/** message when main resource is conflicting */
	public static String PartActivationListener_ChangedMainWarning;

	/** message when many resources have changed */
	public static String PartActivationListener_ChangedMsg_many;

	/** message when single resource has changed */
	public static String PartActivationListener_ChangedMsg_single;

	/** title when resources have changed */
	public static String PartActivationListener_ChangedTitle;

	/** message when resource is conflicting */
	public static String PartActivationListener_ChangedWarning;

	/** message when many resources have been removed */
	public static String PartActivationListener_RemovedMsg_many;

	/** message when single resource has been removed */
	public static String PartActivationListener_RemovedMsg_single;

	/** title when resources have been removed */
	public static String PartActivationListener_RemovedTitle;

	/** Message for dialog to edit the runtime properties */
	public static String StereotypePostAction_EditRuntimePropertiesMessage;

	/** Title for dialog to edit the runtime properties */
	public static String StereotypePostAction_EditRuntimePropertiesTitle;

	/** Message for the add Stereotype Window */
	public static String StereotypePostAction_StereotypeSelectionMessage;

	/** Title for the add Stereotype Window */
	public static String StereotypePostAction_StereotypeSelectionTitle;

	/** BooleanEditor Title */
	public static String PropertyEditors_BooleanTitle;

	/** the "Choice" String */
	public static String PropertyEditors_Choice;

	/** DataTypeEditor Title */
	public static String PropertyEditors_DataTypeTitle;

	/** EnumerationEditor Title */
	public static String PropertyEditors_EnumerationLiteralTitle;

	/** IntegerEditor Title */
	public static String PropertyEditors_IntegerTitle;
	
	/** RealEditor Title */
	public static String PropertyEditors_RealTitle;

	/** MetaclassEditor Title */
	public static String PropertyEditors_MetaclassTitle;

	/** warning message for metaclass editor */
	public static String PropertyEditors_NoFoundElementMetaclass;

	/** warning message for stereotype editor */
	public static String PropertyEditors_NoFoundElementStereotype;

	/** StereotypeEditor Title */
	public static String PropertyEditors_StereotypeTitle;

	/** StringEditor Title */
	public static String PropertyEditors_StringTitle;

	/** UnlimitedNaturalEditor Title */
	public static String PropertyEditors_UnlimitedNaturalTitle;

	/** the "Value" String */
	public static String PropertyEditors_Value;

	/** message for the runtime dialog */
	public static String SetDynamicValueCommand_DialogMessage;

	/** title for the runtime dialog */
	public static String SetDynamicValueCommand_DialogTile;

	/** Message for horizontal routing by bottom action */
	public static String RoutingConstants_Bottom;

	/** Message for horizontal routing by left */
	public static String RoutingConstants_HorizontalByLeft;

	/** Message for horizontal routing by right */
	public static String RoutingConstants_HorizontalByRight;

	/** Message for horizontal routing by left action */
	public static String RoutingConstants_Left;

	/** Menu title for the routing action */
	public static String RoutingConstants_MenuTitle;

	/** Menu ToolTip for the routing action */
	public static String RoutingConstants_MenuToolTip;

	/** Message for horizontal routing by right action */
	public static String RoutingConstants_Right;

	/** Message for horizontal routing by top action */
	public static String RoutingConstants_Top;

	/** Message for horizontal routing by bottom */
	public static String RoutingConstants_VerticalByBottom;

	/** Message for horizontal routing by top */
	public static String RoutingConstants_VerticalByTop;

	/** Message for Diagram Not Found */
	public static String DiagramNotFound;

	/** Message Set Name Diagram */
	public static String SetNameDiagram;

	/** The string No Name for the ShowHideCompartment Action */
	public static String EditorLabelProvider_No_name;

	public static String ShowHideContentsAction_Message;

	public static String ShowHideContentsAction_Title;

	public static String CommonDeferredCreateConnectionViewCommand_NullConnectionCommand;
}
