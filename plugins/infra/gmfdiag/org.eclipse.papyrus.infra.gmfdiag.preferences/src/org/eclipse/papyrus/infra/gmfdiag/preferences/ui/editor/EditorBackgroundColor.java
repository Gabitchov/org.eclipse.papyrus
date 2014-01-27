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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui.editor;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.BackgroundColor;
import org.eclipse.swt.widgets.Composite;

/**
 * The Class EditorBackgroundColor is the back ground group specailized at the papyrus editor level.
 */
public class EditorBackgroundColor extends BackgroundColor {

	/**
	 * Instantiates a new editor background color.
	 * 
	 * @param parent
	 *        the parent composite
	 * @param key
	 *        the key of the preference
	 * @param dialogPage
	 *        the dialog page
	 */
	public EditorBackgroundColor(Composite parent, String key, DialogPage dialogPage) {
		super(parent, key, dialogPage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.preferences.ui.AbstractGroup#getPreferenceConstant(int)
	 */
	protected String getPreferenceConstant(int preferenceType) {
		return PreferencesConstantsHelper.getPapyrusEditorConstant(preferenceType);
	}
}
