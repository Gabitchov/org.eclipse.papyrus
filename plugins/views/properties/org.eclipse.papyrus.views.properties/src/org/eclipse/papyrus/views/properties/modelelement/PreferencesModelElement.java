/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.observable.PreferencesObservableValue;
import org.eclipse.ui.preferences.ScopedPreferenceStore;


public class PreferencesModelElement extends AbstractModelElement {

	protected DataContextElement context;

	protected IPreferenceStore store;

	public PreferencesModelElement(DataContextElement context) {
		this.context = context;
		store = new ScopedPreferenceStore(InstanceScope.INSTANCE, context.getName());
	}

	@Override
	protected IObservable doGetObservable(String propertyPath) {
		return new PreferencesObservableValue(propertyPath, store);
	}
}
