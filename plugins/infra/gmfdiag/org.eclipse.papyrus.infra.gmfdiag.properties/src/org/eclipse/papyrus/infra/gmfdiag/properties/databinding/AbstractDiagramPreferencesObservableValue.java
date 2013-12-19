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

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

/**
 * 
 * This observable value listen the preference store to send event and refresh itself when a preferences has changed
 * 
 */
public abstract class AbstractDiagramPreferencesObservableValue extends AbstractObservableValue {

	/**
	 * the name of the edited preference
	 */
	private String preferenceName;

	/**
	 * the edited preference store
	 */
	private IPreferenceStore editedPreferenceStore;

	/**
	 * the listener on the preference store used to force refresh
	 */
	private IPropertyChangeListener listener;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param diagram
	 *        the diagram for which we re editing a preference
	 * @param preferenceName
	 *        the name of edited the preference
	 */
	public AbstractDiagramPreferencesObservableValue(final Diagram diagram, final String preferenceName, final IPreferenceStore editedPreferenceStore) {
		this.preferenceName = preferenceName;
		this.editedPreferenceStore = editedPreferenceStore;
		this.editedPreferenceStore.addPropertyChangeListener(this.listener = new IPropertyChangeListener() {

			public void propertyChange(final PropertyChangeEvent event) {
				if(getEditedPreference().equals(event.getProperty())) {
					ValueDiff diff = new ValueDiff() {

						@Override
						public Object getOldValue() {
							return event.getOldValue();
						}

						@Override
						public Object getNewValue() {
							return event.getNewValue();
						}
					};
					fireValueChange(diff);
				}
			}
		});
	}


	@Override
	public synchronized void dispose() {
		super.dispose();
		this.editedPreferenceStore.removePropertyChangeListener(this.listener);
	}

	/**
	 * 
	 * @return
	 *         the edited preferences
	 */
	public final String getEditedPreference() {
		return this.preferenceName;
	}

	/**
	 * 
	 * @return
	 *         the edited preference store
	 */
	public final IPreferenceStore getEditedPreferenceStore() {
		return this.editedPreferenceStore;
	}
}
