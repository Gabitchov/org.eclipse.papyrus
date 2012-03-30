/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial API and implementation
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial API and implementation
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Idea of the java generator project & help for the conception 
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.ui.preference;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.java.generator.ui.Activator;


/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		store.setDefault(PreferenceConstants.P_IMPLEMENT_METHODS_OF_INTERFACES_AND_ABSTRACT_CLASS, true);
		store.setDefault(PreferenceConstants.P_GENERATE_GETTERS, true);
		store.setDefault(PreferenceConstants.P_GENERATE_SETTERS, true);
		store.setDefault(PreferenceConstants.P_FILTER_OF_PACKAGE_NOT_TO_GENERATE, "java.*;javax.*");
		store.setDefault(PreferenceConstants.P_GENERIC_CLASS_FOR_MULTIVALUE, "java.util.List");
		store.setDefault(PreferenceConstants.P_STOP_ON_FIRST_ERROR, true);
	}

}
