package org.eclipse.papyrus.wizards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.jface.dialogs.IDialogSettings;


public class SettingsUtils {
	
	private static final String DIAGRAM_KIND_SEPARATOR = ",";

	private static final String TEMPLATE_SEPARATOR = ",";
	
	private static final String SETTINGS_KEY_REMEMBER_CURRENT_SELECTION = "RememberCurrentSelection";

	private static final String SETTINGS_KEY_DIAGRAM_KINDS = "DiagramKindsFor_";
	
	private static final String SETTINGS_KEY_DIAGRAM_TEMPLATES = "DiagramTemplatesFor_";
	
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
	
	public static void saveDefaultDiagramKinds(IDialogSettings settings, String category, List<String> kinds) {
		String value = "";
		for (String kind: kinds) {
			value += kind ;
			value += DIAGRAM_KIND_SEPARATOR;
		}
		settings.put(getKeyForDiagramKind(category), value);
	}

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
	
	public static void saveDefaultTemplates(IDialogSettings settings, String category, List<String> templates) {
		String value = "";
		for (String template: templates) {
			value += template ;
			value += TEMPLATE_SEPARATOR;
		}
		settings.put(getKeyForTemplate(category), value);
	}

	public static void saveRememberCurrentSelection(IDialogSettings settings, boolean remember) {
		settings.put(SETTINGS_KEY_REMEMBER_CURRENT_SELECTION, remember);
	}

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
