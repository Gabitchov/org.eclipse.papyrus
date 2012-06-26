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
package org.eclipse.papyrus.sysml.diagram.internalblock.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	public static String CreateUmlElementDialog_New_Element_Name;

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

	public static String SelectionValidated;

	public static String NoSelectionFound;

	public static String Notification_Drop_Title;

	public static String Notification_Drop_UMLAssociationWarning;

	public static String ShowHideRelatedContentsAction_Title;

	public static String ShowHideRelatedContentsAction_Message;

	static {
		NLS.initializeMessages("messages", Messages.class); //$NON-NLS-1$
	}

	private Messages() {
	}
}
