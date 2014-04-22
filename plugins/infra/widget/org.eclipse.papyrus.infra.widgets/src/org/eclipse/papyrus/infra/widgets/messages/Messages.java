/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.messages;

import org.eclipse.osgi.util.NLS;

/**
 * The Class Messages.
 */
public class Messages extends NLS {

	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.widgets.messages.messages"; //$NON-NLS-1$

	public static String BooleanInputValidator_NotABoolean;
	
	public static String IntegerInputValidator_NotAnIntegerMessage;

	public static String RealInputValidator_NotaRealMessage;

	public static String UnlimitedNaturalInputValidator_NotAnUnlimitedNaturalMessage;

	public static String MultipleStringFileEditor_0;

	public static String MultipleStringFileEditor_1;

	public static String MultipleStringFileEditor_2;

	/** The Multiple value editor_ add elements. */
	public static String MultipleValueEditor_AddElements;

	public static String MultipleValueEditor_addOperation;

	public static String MultipleValueEditor_editOperation;

	/** The Multiple value editor_ edit selected value */
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

	/** The Multiple value selector dialog_ create new element */
	public static String MultipleValueSelectorDialog_CreateNewElement;

	/** The Multiple value selector dialog_ delete new element */
	public static String MultipleValueSelectorDialog_DeleteNewElement;

	/** The Multiple value selector dialog_ remove all elements. */
	public static String MultipleValueSelectorDialog_RemoveAllElements;

	public static String ReferenceDialog_0;

	public static String ReferenceDialog_1;

	public static String ReferenceDialog_CreateANewObject;

	public static String ReferenceDialog_editOperation;

	public static String ReferenceDialog_EditTheCurrentValue;

	/** The Reference dialog_ edit value */
	public static String ReferenceDialog_EditValue;

	/** The Reference dialog_ select value */
	public static String ReferenceDialog_SelectValue;

	public static String ReferenceDialog_setOperation;

	/** The Reference dialog_ unset */
	public static String ReferenceDialog_Unset;

	/** The Reference dialog_ edit unset value */
	public static String ReferenceDialog_UnsetValue;

	/** Indicates that a list of elements have different values for the given property (Multi-selection) */
	public static String ReferenceDialogObservable_Unchanged;

	/** the Enum radio_ no value */
	public static String EnumRadio_NoValue;

	public static String FlattenableRestrictedFilteredContentProvider_AllPossibleContentsMessage;

	public static String FlattenableRestrictedFilteredContentProvider_FlatViewMessage;

	public static String IntegerMask_ErrorTooManyValues;

	public static String ProviderBasedBrowseStrategy_0;

	public static String StringEditionFactory_EnterANewValue;

	public static String StringFileSelector_0;

	public static String StringFileSelector_Browse;

	public static String StringFileSelector_BrowseWorkspace;

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
