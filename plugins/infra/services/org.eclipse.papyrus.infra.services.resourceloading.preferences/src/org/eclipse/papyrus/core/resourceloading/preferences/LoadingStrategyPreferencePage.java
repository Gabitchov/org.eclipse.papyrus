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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.swt.widgets.Composite;

public class LoadingStrategyPreferencePage extends AbstractPapyrusNodePreferencePage {

	private LoadinStrategyGroup groupComposite;

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return CorePlugin.PLUGIN_ID;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createPageContents(Composite parent) {
		groupComposite = new LoadinStrategyGroup(parent, getTitle(), this);
		addAbstractGroup(groupComposite);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performOk() {
		boolean result = super.performOk();
		StrategyChooser.setCurrentStrategy(getPreferenceStore().getInt(ICorePreferenceConstants.PREF_CORE_DEFINE_LOADING_STRATEGY));
		return result;
	}

}
