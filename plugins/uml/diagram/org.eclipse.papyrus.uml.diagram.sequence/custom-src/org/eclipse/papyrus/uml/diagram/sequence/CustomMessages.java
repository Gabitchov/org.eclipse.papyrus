/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence;

import org.eclipse.osgi.util.NLS;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessages extends NLS {

	static {
		NLS.initializeMessages("custom-messages", CustomMessages.class); //$NON-NLS-1$
	}

	private CustomMessages() {
	}

	public static String MoveMessageCommand_Label;

	public static String SelectOrCreateDialog_CreateLabel;

	public static String SelectOrCreateDialog_NameLabel;

	public static String SelectOrCreateDialog_OwnerLabel;

	public static String SelectOrCreateDialog_SelectLabel;

	public static String SelectOrCreateDialog_NothingLabel;

	public static String SelectOrCreateDialog_TypeLabel;

	public static String CommandHelper_CreateMessage;

	/**
	 * Error message for when an error occurs in FragmentOrderingKeeper evaluation.
	 */
	public static String FragmentOrderingKeeper_error;

	/**
	 * Error notification title when a link can not be dropped
	 * 
	 */
	public static String DropError_DefaultTitle;

	/**
	 * Error notification message when a link can not be dropped
	 * 
	 */
	public static String DropError_DefaultTxt;

	/**
	 * Error notification title when a message can not be dropped because it goes uphill
	 * 
	 */
	public static String DropError_UphillMessageTitle;

	/**
	 * Error notification message when a message can not be dropped because it goes uphill
	 * 
	 */
	public static String DropError_UphillMessageTxt;

	/**
	 * Warning notification title when the resize of an interaction operand may have an erratic behavior
	 * 
	 */
	public static String Warning_ResizeInteractionOperandTitle;

	/**
	 * Warning notification message when the resize of an interaction operand may have an erratic behavior
	 * 
	 */
	public static String Warning_ResizeInteractionOperandTxt;
}
