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
package org.eclipse.papyrus.uml.diagram.wizards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.jface.dialogs.IDialogSettings;

/**
 * The Class SettingsUtils allows the Wizard to remember last selected diagram kinds and categories.
 */
public class SettingsHelper {

	/** The Constant DIAGRAM_KIND_SEPARATOR. */
	private static final String DIAGRAM_KIND_SEPARATOR = ","; //$NON-NLS-1$

	/** The Constant TEMPLATE_SEPARATOR. */
	private static final String TEMPLATE_SEPARATOR = ","; //$NON-NLS-1$

	/** The Constant SETTINGS_KEY_REMEMBER_CURRENT_SELECTION. */
	private static final String SETTINGS_KEY_REMEMBER_CURRENT_SELECTION = "RememberCurrentSelection"; //$NON-NLS-1$

	/** The Constant SETTINGS_KEY_DIAGRAM_KINDS. */
	private static final String SETTINGS_KEY_DIAGRAM_KINDS = "DiagramKindsFor_"; //$NON-NLS-1$

	/** The Constant SETTINGS_KEY_DIAGRAM_TEMPLATES. */
	private static final String SETTINGS_KEY_DIAGRAM_TEMPLATES = "DiagramTemplatesFor_"; //$NON-NLS-1$

	/** The Constant LAST_SELECTED_CATEGORY. */
	private static final String LAST_SELECTED_CATEGORY = "diagramCategory"; //$NON-NLS-1$

	/** The my settings. */
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
	public String[] getDefaultDiagramCategories() {
		return mySettings.getArray(LAST_SELECTED_CATEGORY);
	}

	/**
	 * Save default diagram category.
	 *
	 * @param categories the categories
	 */
	public void saveDefaultDiagramCategory(String[] categories) {
		mySettings.put(LAST_SELECTED_CATEGORY, categories);
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
		if(csl == null || csl == "") { //$NON-NLS-1$
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
		String value = ""; //$NON-NLS-1$
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
		if(csl == null || csl == "") { //$NON-NLS-1$
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
		String value = ""; //$NON-NLS-1$
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

	/**
	 * Gets the key for diagram kind.
	 *
	 * @param category the category
	 * @return the key for diagram kind
	 */
	private String getKeyForDiagramKind(String category) {
		return SETTINGS_KEY_DIAGRAM_KINDS + category;
	}

	/**
	 * Gets the key for template.
	 *
	 * @param category the category
	 * @return the key for template
	 */
	private String getKeyForTemplate(String category) {
		return SETTINGS_KEY_DIAGRAM_TEMPLATES + category;
	}

}
