/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.diagram.composite.custom.messages.messages"; //$NON-NLS-1$

	public static String CollaborationRoleSelectionDialog_Title;

	public static String CollaborationRoleSelectionDialog_Message;

	public static String ConnectorCreateCommand_INVALID_ARGS_MSG;

	public static String ConnectorCreateCommand_INVALID_SOURCE_MSG;

	public static String ConnectorCreateCommand_INVALID_TARGET_MSG;

	public static String CreateUmlElementDialog_New_Element_Name;

	public static String RoleBindingCreateCommand_INVALID_ARGS_MSG;

	public static String RoleBindingRoleSelectionDialog_Title;

	public static String RoleBindingRoleSelectionDialog_Message;

	public static String InformationFlowSelectionDialog_Title;

	public static String InformationFlowSelectionDialog_Message;

	public static String InformationItemGetNameDialog_Error_Message;

	public static String SelectionValidated;

	public static String ShowHideRelatedContentsAction_Message;

	public static String ShowHideRelatedContentsAction_Title;

	public static String InformationFlowSelectInformationItem_ERROR;

	public static String InterfaceManagerDialog_CreateANewInterface;

	public static String InterfaceManagerDialog_CreateNewInterface;

	public static String InterfaceManagerDialog_SelectedTheProvidedInterfaces;

	public static String InterfaceManagerDialog_SelectionHasToBeAPackageOrAClassifier;

	public static String InterfaceManagerDialog_SelectTheParentOfThisNewInterface;

	public static String InterfaceManagerDialog_SelectTheRequiredInterfaces;

	public static String InterfaceManagerDialog_ThePortIsTypedWithAnInterfaceWarningMessage;

	public static String InterfaceManagerDialog_Title;

	public static String ManageProvidedInterfacesHandler_OK;

	public static String ManageProvidedInterfacesHandler_TheTypeOfThePortIsNotDefined;

	public static String NoSelectionFound;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
