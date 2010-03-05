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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for Parameter
 *
 *****************************************************************************/

package org.eclipse.papyrus.parsers.texteditor.parameterlabel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.parsers.PapyrusParsersPlugin;
import org.eclipse.papyrus.parsers.preferences.IPreferencesConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * Color provider to syntax highlight.
 */
public class ParameterLabelColorProvider implements IParameterLabelColorConstants {

	/** Default instance */
	private static ParameterLabelColorProvider instance;

	/** Default constructor */
	private ParameterLabelColorProvider() {
	}

	/**
	 * Get singleton instance
	 * 
	 * @return the default instance
	 */
	public static ParameterLabelColorProvider getDefault() {
		if(instance == null) {
			instance = new ParameterLabelColorProvider();
		}
		return instance;
	}

	/** Used color table */
	protected Map<String, Color> fColorTable = new HashMap<String, Color>(10);

	/**
	 * Set default colors in given preference store.
	 * 
	 * @param aStore
	 *        the preference store
	 */
	public static void initializeDefaults(IPreferenceStore aStore) {
		PreferenceConverter.setDefault(aStore, IPreferencesConstants.COLOR_DEFAULT, IParameterLabelColorConstants.RGB_DEFAULT);
		PreferenceConverter.setDefault(aStore, IPreferencesConstants.COLOR_KEYWORD, IParameterLabelColorConstants.RGB_KEYWORD);
		PreferenceConverter.setDefault(aStore, IPreferencesConstants.COLOR_STRING, IParameterLabelColorConstants.RGB_STRING);
		PreferenceConverter.setDefault(aStore, IPreferencesConstants.COLOR_SYMBOL, IParameterLabelColorConstants.RGB_SYMBOL);
	}

	/**
	 * Returns specified color that is stored in the color table. If color not found in color table
	 * then a new instance is created from according preferences value and stored in color table.
	 * 
	 * @param aName
	 *        the name of the color
	 * 
	 * @return the color instance
	 */
	public Color getColor(String aName) {

		Color color = fColorTable.get(aName);
		if(color == null) {
			IPreferenceStore store = PapyrusParsersPlugin.getDefault().getPreferenceStore();

			PreferenceConverter.setValue(store, IPreferencesConstants.COLOR_SYMBOL, IParameterLabelColorConstants.RGB_SYMBOL);

			RGB rgb = PreferenceConverter.getColor(store, IPreferencesConstants.PREFIX_COLOR + aName);
			if(rgb != null) {
				color = new Color(Display.getCurrent(), rgb);
			} else {
				color = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_FOREGROUND);
				PapyrusParsersPlugin.logError("Undefined color '" + aName + "'");
			}
			fColorTable.put(aName, color);
		}
		return color;
	}

	/**
	 * Release all of the color resources held onto by the color provider.
	 */
	public void dispose() {
		Iterator<Color> colors = fColorTable.values().iterator();
		while(colors.hasNext()) {
			colors.next().dispose();
		}
	}
}
