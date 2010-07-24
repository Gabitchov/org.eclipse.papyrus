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
 *****************************************************************************/package org.eclipse.papyrus.wizards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.jface.dialogs.IDialogSettings;


/**
 * The Class SettingsUtils.
 */
public class SettingsUtils {
	
	private static final String DIAGRAM_KIND_SEPARATOR = ",";

	private static final String TEMPLATE_SEPARATOR = ",";
	
	private static final String SETTINGS_KEY_REMEMBER_CURRENT_SELECTION = "RememberCurrentSelection";

	private static final String SETTINGS_KEY_DIAGRAM_KINDS = "DiagramKindsFor_";
	
	private static final String SETTINGS_KEY_DIAGRAM_TEMPLATES = "DiagramTemplatesFor_";
	
	/**
	 * Gets the default diagram kinds.
	 *
	 * @param settings the settings
	 * @param category the category
	 * @return the default diagram kinds
	 */
	public static List<String> getDefaultDiagramKinds(IDialogSettings settings, String category) {
		String csl = settings.get(getKeyForDiagramKind(category));
		if (csl == null || csl == "") {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(csl, DIAGRAM_KIND_SEPARATOR);
		while (tokenizer.hasMoreTokens()) {
			result.add(tokenizer.nextToken().trim());
		}
		return result;
	}
	
	/**
	 * Save default diagram kinds.
	 *
	 * @param settings the settings
	 * @param category the category
	 * @param kinds the kinds
	 */
	public static void saveDefaultDiagramKinds(IDialogSettings settings, String category, List<String> kinds) {
		String value = "";
		for (String kind: kinds) {
			value += kind ;
			value += DIAGRAM_KIND_SEPARATOR;
		}
		settings.put(getKeyForDiagramKind(category), value);
	}

	/**
	 * Gets the default templates.
	 *
	 * @param settings the settings
	 * @param category the category
	 * @return the default templates
	 */
	public static List<String> getDefaultTemplates(IDialogSettings settings, String category) {
		String csl = settings.get(getKeyForTemplate(category));
		if (csl == null || csl == "") {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(csl, TEMPLATE_SEPARATOR);
		while (tokenizer.hasMoreTokens()) {
			result.add(tokenizer.nextToken().trim());
		}
		return result;
	}
	
	/**
	 * Save default templates.
	 *
	 * @param settings the settings
	 * @param category the category
	 * @param templates the templates
	 */
	public static void saveDefaultTemplates(IDialogSettings settings, String category, List<String> templates) {
		String value = "";
		for (String template: templates) {
			value += template ;
			value += TEMPLATE_SEPARATOR;
		}
		settings.put(getKeyForTemplate(category), value);
	}

	/**
	 * Save remember current selection.
	 *
	 * @param settings the settings
	 * @param remember the remember
	 */
	public static void saveRememberCurrentSelection(IDialogSettings settings, boolean remember) {
		settings.put(SETTINGS_KEY_REMEMBER_CURRENT_SELECTION, remember);
	}

	/**
	 * Remember current selection.
	 *
	 * @param settings the settings
	 * @return true, if successful
	 */
	public static boolean rememberCurrentSelection(IDialogSettings settings) {
		return settings.getBoolean(SETTINGS_KEY_REMEMBER_CURRENT_SELECTION);
	}

	private static String getKeyForDiagramKind(String category) {
		return SETTINGS_KEY_DIAGRAM_KINDS + category;
	}
	
	private static String getKeyForTemplate(String category) {
		return SETTINGS_KEY_DIAGRAM_TEMPLATES + category;
	}

}
