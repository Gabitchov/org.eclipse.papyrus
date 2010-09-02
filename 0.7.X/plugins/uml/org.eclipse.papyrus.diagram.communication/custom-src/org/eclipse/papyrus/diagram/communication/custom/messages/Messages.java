/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.messages;

import org.eclipse.osgi.util.NLS;

// TODO: Auto-generated Javadoc
/**
 * The Class Messages.
 */
public class Messages extends NLS {

	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.diagram.communication.custom.messages.messages"; //$NON-NLS-1$

	/**
	 * 
	 */
	public static String CommandHelper_PropertySelection;

	/**
	 * 
	 */
	public static String CommandHelper_SelectProperty;

	/**
	 * 
	 */
	public static String CommandHelper_SelectSignature;

	/**
	 * 
	 */
	public static String CommandHelper_signatureslection;

	public static String MessageInverseOrientation_setconnectionends;

	public static String MessageInverseOrientation_setconnectionanchors;

	public static String MessageLabelInverseOrientation_setconnectionends;

	public static String MessageLabelInverseOrientation_setconnectionanchors;

	/** The Message parser. */
	public static String MessageParser_undefined;
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
