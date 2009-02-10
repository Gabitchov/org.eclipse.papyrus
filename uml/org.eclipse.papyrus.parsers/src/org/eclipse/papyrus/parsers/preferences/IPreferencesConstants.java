/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.parsers.preferences;

import org.eclipse.papyrus.parsers.PapyrusParsersPlugin;
import org.eclipse.papyrus.parsers.texteditor.propertylabel.IPropertyLabelColorConstants;

/**
 * Defines constants which are used to refer to values in the plugin's
 * preference bundle.
 */
public interface IPreferencesConstants {
	
	/**
	 * ui plugin id.
	 */
	String PREFIX = PapyrusParsersPlugin.PLUGIN_ID + ".";

	/**
	 * color prefix.
	 */
	String PREFIX_COLOR = PREFIX + "color.";

	/**
	 * color for basic grammar text.
	 */
	String COLOR_DEFAULT = PREFIX_COLOR + IPropertyLabelColorConstants.DEFAULT;
	
	/**
	 * color for grammar keyword text.
	 */
	String COLOR_KEYWORD = PREFIX_COLOR + IPropertyLabelColorConstants.KEYWORD;
	
	/**
	 * color for grammar string text.
	 */
	String COLOR_STRING = PREFIX_COLOR + IPropertyLabelColorConstants.STRING;
	
	/**
	 * color for grammar symbol text.
	 */
	String COLOR_SYMBOL = PREFIX_COLOR + IPropertyLabelColorConstants.SYMBOL;
}