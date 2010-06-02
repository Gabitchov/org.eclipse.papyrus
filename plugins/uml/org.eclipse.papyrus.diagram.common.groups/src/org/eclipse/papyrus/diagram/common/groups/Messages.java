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
package org.eclipse.papyrus.diagram.common.groups;

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
}
