/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/INRIA DaRT) amine.el_kouhen@inria.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment.custom.messages;

import org.eclipse.osgi.util.NLS;

// TODO: Auto-generated Javadoc
/**
 * The Class Messages.
 */
public class Messages extends NLS {

	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.diagram.deployment.custom.messages.messages"; //$NON-NLS-1$

	/** The Create uml element dialog_ new_ element_ name. */
	public static String CreateUmlElementDialog_New_Element_Name;

	/** The Selection validated. */
	public static String SelectionValidated;

	/** The Show hide related contents action_ message. */
	public static String ShowHideRelatedContentsAction_Message;

	/** The Show hide related contents action_ title. */
	public static String ShowHideRelatedContentsAction_Title;

	/** The No selection found. */
	public static String NoSelectionFound;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	/**
	 * Instantiates a new messages.
	 */
	private Messages() {
	}
}
