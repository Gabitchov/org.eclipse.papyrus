/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.messages;

import org.eclipse.osgi.util.NLS;

/**
 * The Class Messages.
 */
public class Messages extends NLS {

	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.widgets.messages.messages"; //$NON-NLS-1$

	/** The Multiple value editor_ add elements. */
	public static String MultipleValueEditor_AddElements;

	public static String MultipleValueEditor_EditSelectedValue;

	/** The Multiple value editor_ move selected elements down. */
	public static String MultipleValueEditor_MoveSelectedElementsDown;

	/** The Multiple value editor_ move selected elements up. */
	public static String MultipleValueEditor_MoveSelectedElementsUp;

	/** The Multiple value editor_ remove selected elements. */
	public static String MultipleValueEditor_RemoveSelectedElements;

	/** The Multiple value selector dialog_ add all elements. */
	public static String MultipleValueSelectorDialog_AddAllElements;

	/** The Multiple value selector dialog_ add selected elements. */
	public static String MultipleValueSelectorDialog_AddSelectedElements;

	public static String MultipleValueSelectorDialog_CreateNewElement;

	public static String MultipleValueSelectorDialog_DeleteNewElement;

	/** The Multiple value selector dialog_ remove all elements. */
	public static String MultipleValueSelectorDialog_RemoveAllElements;

	public static String ReferenceDialog_EditValue;

	public static String ReferenceDialog_SelectValue;

	public static String ReferenceDialog_Unset;

	public static String ReferenceDialog_UnsetValue;
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
