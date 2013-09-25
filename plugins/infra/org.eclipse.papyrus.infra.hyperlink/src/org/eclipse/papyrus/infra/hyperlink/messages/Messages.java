/*****************************************************************************
 * Copyright (c) 2011, 2013 CEA LIST and others.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Consolidate all hyperlink helper contributions into one tab
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.hyperlink.messages.messages"; //$NON-NLS-1$

	public static String EditorHyperLinkEditorShell_ICanFindTheHyperLinkEditorObject;

	public static String EditorHyperLinkEditorShell_View;

	public static String EditorHyperLinkHelper_Editor;

	public static String HyperLinkEditorHelpersRegistrationUtil_ICantCreateTheClassForAnHelper;

	public static String HyperLinkEditorHelpersRegistrationUtil_NotAnInstanceOf;

	public static String HyperLinkHelpersRegistrationUtil_ICantCreateTheClassForAnHelper;

	public static String HyperLinkHelpersRegistrationUtil_TheHelperWillBeIgnored;

	public static String HyperLinkTabRegistrationUtil_ICantCreateTheTab;

	public static String HyperLinkTabRegistrationUtil_tabWillBeIgnored;
	
	public static String HyperLinkTabRegistrationUtil_NotAnInstanceOf;
	
	public static String AbstractEditHyperlinkDocumentShell_Cancel;

	public static String AbstractEditHyperlinkDocumentShell_Diagram;

	public static String AbstractEditHyperlinkDocumentShell_Document;

	public static String AbstractEditHyperlinkDocumentShell_EditHyperlink;

	public static String AbstractEditHyperlinkDocumentShell_EditionOfAHyperLink;

	public static String AbstractEditHyperlinkDocumentShell_OK;

	public static String AbstractEditHyperlinkDocumentShell_TooltipText;

	public static String AbstractEditHyperlinkDocumentShell_ToolTipText;

	public static String AbstractEditHyperlinkDocumentShell_UseDefault;

	public static String AbstractEditHyperlinkShell_Cancel;

	public static String AbstractEditHyperlinkShell_EditHyperLink;

	public static String AbstractEditHyperlinkShell_EditionOfAHyperLink;

	public static String AbstractEditHyperlinkShell_object;

	public static String AbstractEditHyperlinkShell_OK;

	public static String AbstractEditHyperlinkShell_ToolTipText;

	public static String AbstractEditHyperlinkShell_ToolTipText_;

	public static String AbstractEditHyperlinkShell_UseDefault;

	public static String AbstractHyperLinkManagerShell_Cancel;

	public static String AbstractHyperLinkManagerShell_HyperLink;

	public static String AbstractHyperLinkManagerShell_OK;

	public static String AbstractLookForEditorShell_Cancel;

	public static String AbstractLookForEditorShell_EditorsList;

	public static String AbstractLookForEditorShell_New;

	public static String AbstractLookForEditorShell_OK;

	public static String AbstractLookForEditorShell_Remove;

	public static String AbstractLookForEditorShell_TreeView;

	public static String DefaultHyperLinkTab_DefaultHyperlinks;

	public static String DefaultHyperLinkTab_DefaultHyperLinks;

	public static String DefaultHyperLinkTab_HyperLinks;

	public static String DiagramNavigationDialog_ChooseHyperLinks;

	public static String DiagramNavigationDialog_WhichHyperLinksWouldYouToNavigateTo;

	public static String EditorHyperlinkDocumentShell_Open;

	public static String EditorHyperLinkWebShell_Hyperlinks;

	public static String HyperLinkManagerShell_HyperLinksCommands;
	public static String HyperLinkManagerShell_ImpossibleToReadPreferences;

	public static String HyperLinkManagerShell_InputOutputException;
	public static String HyperLinkTab_addTooltip;

	public static String HyperLinkTab_Hyperlink;

	public static String HyperLinkTab_Hyperlinks;

	public static String HyperLinkTab_hyperLinks;

	public static String HyperLinkTab_title;

	public static String HyperLinkTab_Listof;

	public static String HyperLinkTab_SetOf;
	
	public static String DocumentHyperLinkHelper_Document;

	public static String HyperLinkHelperFactory_addHyperLinksCommand;

	public static String HyperLinkHelperFactory_ImpossibleToFindACommandToSerialize;

	public static String WebHyperLinkHelper_Web;
	public static String HyperLinkDocument_ExternalFiles;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
