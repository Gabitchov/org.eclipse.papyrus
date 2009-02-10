/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.preferences.pages.internal;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.gmf.runtime.emf.ui.preferences.PathmapsPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.Activator;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * The Papyrus Pathmaps preference page
 * 
 * @author tlandre
 */
public class PapyrusPathmapsPreferencePage extends PathmapsPreferencePage implements IWorkbenchPropertyPage {

	private IProject project;

	/**
	 * Default constructor
	 */
	public PapyrusPathmapsPreferencePage() {
		setPreferenceStore(null);
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
		project = (IProject) element.getAdapter(IResource.class);
	}

	/**
	 * @see org.eclipse.jface.preference.PreferencePage#doGetPreferenceStore()
	 */
	protected IPreferenceStore doGetPreferenceStore() {
		IPreferenceStore store;
		if (project != null) {
			store = new ScopedPreferenceStore(new ProjectScope(project), getBundleId());
		} else {
			store = new ScopedPreferenceStore(new InstanceScope(), getBundleId());
		}
		return store;
	}

	private String getBundleId() {
		return Activator.PLUGIN_ID;
	}

}
