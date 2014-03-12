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
package org.eclipse.papyrus.infra.nattable.preferences;

import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.papyrus.infra.tools.preferences.AbstractPapyrusPreferenceStore;
import org.eclipse.papyrus.infra.tools.preferences.ui.dialog.AbstractApplyValueOnPreferenceKeyDialog;

/**
 * this class is a specific store that is used to look for value of element
 * by taking account the structure of preferences : papyrus editor-> Diagram -> Elements of Diagram
 * 
 */
public class PapyrusTablePreferenceStore extends AbstractPapyrusPreferenceStore {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param context
	 * @param qualifier
	 * @param defaultQualifierPath
	 */
	public PapyrusTablePreferenceStore(IScopeContext context, String qualifier, String defaultQualifierPath) {
		super(context, qualifier, defaultQualifierPath, TablePreferencesConstantsHelper.PAPYRUS_TABLE_EDITOR_PREFERENCE_PREFIX, TablePreferencesConstantsHelper.TABLE_PREFERENCE_PREFIX, TablePreferencesConstantsHelper.TABLE_ELEMENT);
	}


	/**
	 * 
	 * Constructor.
	 * 
	 * @param context
	 * @param qualifier
	 */
	public PapyrusTablePreferenceStore(IScopeContext context, String qualifier) {
		super(context, qualifier, TablePreferencesConstantsHelper.PAPYRUS_TABLE_EDITOR_PREFERENCE_PREFIX, TablePreferencesConstantsHelper.TABLE_PREFERENCE_PREFIX, TablePreferencesConstantsHelper.TABLE_ELEMENT);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.tools.preferences.AbstractPapyrusPreferenceStore#createPreferenceKeyDialog(java.lang.String[])
	 * 
	 * @param keys
	 * @return
	 */
	@Override
	protected AbstractApplyValueOnPreferenceKeyDialog createPreferenceKeyDialog(String[] keys) {
		throw new UnsupportedOperationException("not yet implemented"); //$NON-NLS-1$
	}





}
