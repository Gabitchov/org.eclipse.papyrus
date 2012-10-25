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
package org.eclipse.papyrus.infra.services.resourceloading.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.infra.services.resourceloading.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class LoadingStrategyPreferencePage extends AbstractPapyrusNodePreferencePage {

	private LoadinStrategyGroup groupComposite;

	private IProject project;

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
		LoadedAuthorizedResourceGroup loadedAuthorizedResourceGroup = new LoadedAuthorizedResourceGroup(parent, getTitle(), this);
		addAbstractGroup(loadedAuthorizedResourceGroup);
		// TODO : if no value is set for the radio buttons (loading strategy) on
		// a project, use the workspace loading strategy.
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performOk() {
		boolean result = super.performOk();
		StrategyChooser.setCurrentStrategy(doGetPreferenceStore().getInt(ICorePreferenceConstants.PREF_CORE_DEFINE_LOADING_STRATEGY));
		IPreferenceStore modifiedPrefStore = doGetPreferenceStore();
		try {
			if(modifiedPrefStore instanceof ScopedPreferenceStore) {
				((ScopedPreferenceStore)modifiedPrefStore).save();
			}
		} catch (Exception e) {
			Activator.logError(e);
		}

		return result;
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPropertyPage#getElement()
	 */
	public IAdaptable getElement() {
		return project;
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPropertyPage#setElement(org.eclipse.core.runtime.IAdaptable)
	 */
	public void setElement(IAdaptable element) {
		project = (IProject)element.getAdapter(IResource.class);
	}

	@Override
	public IPreferenceStore getPreferenceStore() {
		return doGetPreferenceStore();
	}

	/**
	 * @see org.eclipse.jface.preference.PreferencePage#doGetPreferenceStore()
	 */
	protected IPreferenceStore doGetPreferenceStore() {
		IPreferenceStore store;
		if(project != null) {
			store = new ScopedPreferenceStore(new ProjectScope(project), getBundleId());
		} else {
			store = new ScopedPreferenceStore(new InstanceScope(), getBundleId());
		}
		return store;
	}
}
