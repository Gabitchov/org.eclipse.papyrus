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
package org.eclipse.papyrus.infra.gmfdiag.css.preferences;

import java.io.IOException;
import java.net.URL;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.infra.gmfdiag.common.handler.RefreshHandler;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.WorkspaceCSSEngine;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class ThemePreferencesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * The "Current Theme" preference
	 */
	public static String CURRENT_THEME = "currentTheme"; //$NON-NLS-1$

	public static String EXTENSION_ID = Activator.PLUGIN_ID + ".theme";

	private static Map<String, Theme> allThemes;

	public boolean needsRefresh = false;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ThemePreferencesPage() {
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param style
	 */
	public ThemePreferencesPage(int style) {
		super(style);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 * @param style
	 */
	public ThemePreferencesPage(String title, int style) {
		super(title, style);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 * @param image
	 * @param style
	 */
	public ThemePreferencesPage(String title, ImageDescriptor image, int style) {
		super(title, image, style);
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Papyrus Theme preferences");
	}

	@Override
	protected void createFieldEditors() {
		String[][] themes = getFieldThemes();
		ComboFieldEditor editor = new ComboFieldEditor(CURRENT_THEME, "Current theme:", themes, getFieldEditorParent());
		addField(editor);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		if(CURRENT_THEME.equals(event.getProperty())) {
			needsRefresh = true;
		}
		if(FieldEditor.VALUE.equals(event.getProperty())) {
			if(CURRENT_THEME.equals(((FieldEditor)event.getSource()).getPreferenceName())) {
				needsRefresh = true;
			}
		}
	}

	@Override
	public boolean performOk() {
		boolean result = super.performOk();
		if(needsRefresh) {
			WorkspaceCSSEngine.instance.reset();
			try {
				(new RefreshHandler()).execute(null);
			} catch (ExecutionException ex) {
				Activator.log.error(ex);
			}
		}
		return result;
	}

	protected String[][] getFieldThemes() {
		List<Theme> themes = sortThemes();

		String[][] result = new String[themes.size()][2];
		int i = 0;
		for(Theme theme : themes) {
			result[i][0] = theme.label;
			result[i][1] = theme.id;
			i++;
		}
		return result;
	}

	protected static Map<String, Theme> getThemes() {
		if(allThemes == null) {
			allThemes = new HashMap<String, Theme>();
			allThemes.put(EmptyTheme.instance.id, EmptyTheme.instance);
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

			for(IConfigurationElement themeConfig : config) {
				final String themeId = themeConfig.getAttribute("id");
				Theme theme = getTheme(themeId);
				IConfigurationElement[] stylesheets = themeConfig.getChildren("stylesheet");
				for(IConfigurationElement stylesheetConfig : stylesheets) {
					String path = stylesheetConfig.getAttribute("stylesheetPath");
					try {
						URL url = new URL("platform:/plugin/" + themeConfig.getContributor().getName() + "/" + path);
						theme.styleSheets.add(url);
					} catch (IOException ex) {
						Activator.log.error(ex);
					}
				}
			}
		}

		return allThemes;
	}

	public static List<URL> getWorkspaceStyleSheets() {
		Theme current = findCurrentTheme();
		if(current == null) {
			return Collections.emptyList();
		}
		return current.styleSheets;
	}

	protected static Theme findCurrentTheme() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		if(store.contains(CURRENT_THEME)) {
			String themeId = store.getString(CURRENT_THEME);
			Theme theme = getThemes().containsKey(themeId) ? getThemes().get(themeId) : EmptyTheme.instance;
			return theme;
		}

		//The theme has not been defined: return the first one, and store it

		List<Theme> sortedThemes = sortThemes();
		if(sortedThemes.size() < 2) {
			return EmptyTheme.instance;
		}

		//Index 0 is EmptyTheme ; we return the first non-empty theme
		Theme theme = sortedThemes.get(1);
		store.setValue(CURRENT_THEME, theme.id);
		try {
			((IPersistentPreferenceStore)store).save();
		} catch (IOException e) {
			Activator.log.error(e);
		}
		return theme;
	}

	protected static List<Theme> sortThemes() {
		List<Theme> sortedThemes = new LinkedList<Theme>(getThemes().values());
		Collections.sort(sortedThemes, ThemeComparator.instance);
		return sortedThemes;
	}

	protected static Theme getTheme(String id) {
		if(!allThemes.containsKey(id)) {
			Theme theme = new Theme(id, id, new LinkedList<URL>());
			allThemes.put(id, theme);
		}
		return allThemes.get(id);
	}

	private static class Theme {

		public Theme(String id, String label, List<URL> styleSheets) {
			this.id = id;
			this.label = label;
			this.styleSheets = styleSheets;
		}

		public final List<URL> styleSheets;

		public final String id;

		public final String label;
	}

	private static class EmptyTheme extends Theme {

		public static Theme instance = new EmptyTheme();

		private EmptyTheme() {
			super("none", "No theme", Collections.<URL> emptyList());
		}
	}

	private static class ThemeComparator implements Comparator<Theme> {

		private ThemeComparator() {
		}

		public int compare(Theme o1, Theme o2) {
			if(o1 == EmptyTheme.instance) {
				return -1;
			}
			if(o2 == EmptyTheme.instance) {
				return 1;
			}

			return Collator.getInstance().compare(o1.label, o2.label);
		}

		public static Comparator<Theme> instance = new ThemeComparator();

	}

}
