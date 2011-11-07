/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.groups;

import org.eclipse.osgi.util.NLS;

/**
 * The class handling messages for the group framework
 */
public class Messages extends NLS {


	/**
	 * Initialize from files
	 */
	static {
		NLS.initializeMessages("messages", Messages.class); //$NON-NLS-1$
	}

	/**
	 * Private constructor
	 */
	private Messages() {
	}

	/**
	 * Main message in ChooseElementsCreator
	 */
	public static String ChooseContainedElementsCreator_Message;

	/**
	 * Message to check/uncheck all checkboxes in ChooseElementsCreator
	 */
	public static String ChooseContainedElementsCreator_CheckAll;

	/**
	 * Message to run the action in ChooseContainedElementsCreator
	 */
	public static String ChooseContainedElementsCreator_Run;

	/**
	 * Main message in ChooseContainingGroupCreator
	 */
	public static String ChooseContainingGroupCreator_Message;

	/**
	 * Message to introduce a contained element in ChooseContainingGroupCreator
	 */
	public static String ChooseContainingGroupCreator_Contained;

	/**
	 * Message to run the action in ChooseContainingGroupCreator
	 */
	public static String ChooseContainingGroupCreator_Run;

	/**
	 * Message displayed when the user is asked to choose between graphical parents
	 */
	public static String ChooseParentNotificationCommand_ChooseGraphicalParent;

	/**
	 * Message display on the Choose graphical children notification
	 * e.g "Change graphical parent"
	 */
	public static String ChooseParentNotificationCommand_ChooseGraphicalParentMessage;

	/**
	 * Label of the Choose Children Notification
	 */
	public static String ChooseChildrenICompositeCreator_ChooseChildren;

	/**
	 * Message display to choose graphical children
	 */
	public static String ChooseParentNotificationCommand_ChooseGraphicalChildrenMessage;

	/**
	 * Message displayed when the user is asked to choose between model parents (This message is a warnig)
	 */
	public static String ChooseParentNotificationCommand_ChooseModelParent;

	/**
	 * Command label of HandleGraphicalChildrenMovingOut
	 */
	public static String CommandsUtils_HandleGraphicalChildrenMovingOut_Label;



}
