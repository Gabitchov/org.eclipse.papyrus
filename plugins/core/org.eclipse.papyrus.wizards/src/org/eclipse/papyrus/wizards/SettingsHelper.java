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
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.jface.dialogs.IDialogSettings;


/**
 * The Class SettingsUtils.
 */
public class SettingsHelper {

	private static final String DIAGRAM_KIND_SEPARATOR = ",";

	private static final String TEMPLATE_SEPARATOR = ",";

	private static final String SETTINGS_KEY_REMEMBER_CURRENT_SELECTION = "RememberCurrentSelection";

	private static final String SETTINGS_KEY_DIAGRAM_KINDS = "DiagramKindsFor_";

	private static final String SETTINGS_KEY_DIAGRAM_TEMPLATES = "DiagramTemplatesFor_";

	private static final String LAST_SELECTED_CATEGORY = "diagramCategory";

	private final IDialogSettings mySettings;

	/**
	 * Instantiates a new settings utils.
	 * 
	 * @param settings
	 *        the settings
	 */
	public SettingsHelper(IDialogSettings settings) {
		mySettings = settings;
	}

	/**
	 * Gets the default diagram category.
	 * 
	 * @return the default diagram category
	 */
	public String getDefaultDiagramCategory() {
		return mySettings.get(LAST_SELECTED_CATEGORY);
	}

	/**
	 * Save default diagram category.
	 * 
	 * @param category
	 *        the category
	 */
	public void saveDefaultDiagramCategory(String category) {
		mySettings.put(LAST_SELECTED_CATEGORY, category);
	}

	/**
	 * Gets the default diagram kinds.
	 * 
	 * @param category
	 *        the category
	 * @return the default diagram kinds
	 */
	public List<String> getDefaultDiagramKinds(String category) {
		String csl = mySettings.get(getKeyForDiagramKind(category));
		if(csl == null || csl == "") {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(csl, DIAGRAM_KIND_SEPARATOR);
		while(tokenizer.hasMoreTokens()) {
			result.add(tokenizer.nextToken().trim());
		}
		return result;
	}

	/**
	 * Save default diagram kinds.
	 * 
	 * @param category
	 *        the category
	 * @param kinds
	 *        the kinds
	 */
	public void saveDefaultDiagramKinds(String category, List<String> kinds) {
		String value = "";
		for(String kind : kinds) {
			value += kind;
			value += DIAGRAM_KIND_SEPARATOR;
		}
		mySettings.put(getKeyForDiagramKind(category), value);
	}

	/**
	 * Gets the default templates.
	 * 
	 * @param category
	 *        the category
	 * @return the default templates
	 */
	public List<String> getDefaultTemplates(String category) {
		String csl = mySettings.get(getKeyForTemplate(category));
		if(csl == null || csl == "") {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(csl, TEMPLATE_SEPARATOR);
		while(tokenizer.hasMoreTokens()) {
			result.add(tokenizer.nextToken().trim());
		}
		return result;
	}

	/**
	 * Save default templates.
	 * 
	 * @param category
	 *        the category
	 * @param templates
	 *        the templates
	 */
	public void saveDefaultTemplates(String category, List<String> templates) {
		String value = "";
		for(String template : templates) {
			value += template;
			value += TEMPLATE_SEPARATOR;
		}
		mySettings.put(getKeyForTemplate(category), value);
	}

	/**
	 * Save remember current selection.
	 * 
	 * @param remember
	 *        the remember
	 */
	public void saveRememberCurrentSelection(boolean remember) {
		mySettings.put(SETTINGS_KEY_REMEMBER_CURRENT_SELECTION, remember);
	}

	/**
	 * Remember current selection.
	 * 
	 * @param settings
	 *        the settings
	 * @return true, if successful
	 */
	public boolean rememberCurrentSelection(IDialogSettings settings) {
		return mySettings.getBoolean(SETTINGS_KEY_REMEMBER_CURRENT_SELECTION);
	}

	private String getKeyForDiagramKind(String category) {
		return SETTINGS_KEY_DIAGRAM_KINDS + category;
	}

	private String getKeyForTemplate(String category) {
		return SETTINGS_KEY_DIAGRAM_TEMPLATES + category;
	}

}
