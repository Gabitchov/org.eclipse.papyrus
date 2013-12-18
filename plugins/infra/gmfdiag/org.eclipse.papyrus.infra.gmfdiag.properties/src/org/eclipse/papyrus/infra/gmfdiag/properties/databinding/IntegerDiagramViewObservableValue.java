/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.databinding;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * 
 * Class used to edit integer preferences
 * 
 */
public class IntegerDiagramViewObservableValue extends AbstractDiagramPreferencesObservableValue {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param diagram
	 *        the edited diagram
	 * @param preferenceName
	 *        the name of the edited preference
	 * @param store
	 *        the edited preference store
	 */
	public IntegerDiagramViewObservableValue(final Diagram diagram, final String preferenceName, final IPreferenceStore store) {
		super(diagram, preferenceName, store);
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 * 
	 * @return
	 */
	public final Object getValueType() {
		return EcorePackage.eINSTANCE.getEInt();
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doGetValue()
	 * 
	 * @return
	 */
	@Override
	protected final Object doGetValue() {
		final IPreferenceStore wsPreferenceStore = getEditedPreferenceStore();
		return wsPreferenceStore.getInt(getEditedPreference());
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doSetValue(java.lang.Object)
	 * 
	 * @param value
	 */
	@Override
	protected void doSetValue(Object value) {
		if(value instanceof Integer) {
			final IPreferenceStore wsPreferenceStore = getEditedPreferenceStore();
			wsPreferenceStore.setValue(getEditedPreference(), ((Integer)value).intValue());
		}
	}


}
