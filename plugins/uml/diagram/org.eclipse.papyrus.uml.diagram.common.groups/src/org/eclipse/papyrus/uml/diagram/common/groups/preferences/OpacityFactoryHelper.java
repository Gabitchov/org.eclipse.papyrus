/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.groups.preferences;

import org.eclipse.draw2d.Shape;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;

/**
 * Factory Helper used to set the opacity setting on groups ( setAlpha , listenner, preferences etc...)
 * 
 * @author adaussy
 * 
 */
public class OpacityFactoryHelper {

	/**
	 * Get the preference group to set the opqcity
	 * 
	 * @param parent
	 * @param key
	 * @param dialogPage
	 * @param preferenceName
	 * @return
	 */
	static public OpacityGroup getOpacityGroup(Composite parent, String key, DialogPage dialogPage, String preferenceName) {
		return new OpacityGroup(parent, key, dialogPage, preferenceName);
	}

	/**
	 * Init the opacity preferences of a figure
	 * 
	 * @param preferenceName
	 *        Name of the preferences which point to the alpha preference
	 * @param store
	 *        Preference Store
	 * @param figure
	 *        Figure on which the alpha setting has to be made
	 */
	static public void initOpacityPreferences(final String preferenceName, final IPreferenceStore store, final Shape figure) {
		Integer defaultAlpha = getStoredValueOfOpacity(preferenceName, store);
		figure.setAlpha(defaultAlpha);
		store.addPropertyChangeListener(new IPropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent event) {
				if(preferenceName.equals(event.getProperty())) {
					if(figure != null) {
						figure.setAlpha(store.getInt(preferenceName));
					}
				}
			}
		});
	}

	/**
	 * Get the store value of the alpha setting
	 * 
	 * @param preferenceName
	 *        name of the preference
	 * @param store
	 *        Preference store
	 * @return
	 */
	static public Integer getStoredValueOfOpacity(String preferenceName, IPreferenceStore store) {
		return new Integer(store.getInt(preferenceName));
	}



}
