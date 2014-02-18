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
package org.eclipse.papyrus.infra.gmfdiag.css.theme;

import java.io.IOException;
import java.net.URL;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.preferences.ThemePreferences;
import org.eclipse.swt.graphics.Image;

/**
 * A Singleton to manage CSS Themes. Reads Themes from an extension point,
 * and provides an access to them.
 *
 * @author Camille Letavernier
 *
 */
public class ThemeManager {

	public static String EXTENSION_ID = Activator.PLUGIN_ID + ".theme";

	public static ThemeManager instance = new ThemeManager();

	private Map<String, Theme> allThemes;

	/**
	 * Returns all the Themes, sorted alphabetically
	 *
	 * @return
	 */
	public List<Theme> getThemes() {
		List<Theme> sortedThemes = new LinkedList<Theme>(getAllThemes().values());
		Collections.sort(sortedThemes, ThemeComparator.instance);
		return sortedThemes;
	}

	/**
	 * Returns the list of the workspace stylesheet's URLs.
	 *
	 * @return
	 */
	public List<URL> getWorkspaceStyleSheets() {
		Theme current = findCurrentTheme();
		if(current == null) {
			return Collections.emptyList();
		}
		return current.getStyleSheets();
	}

	/**
	 * Returns the theme associated to the given id, or null if it doesn't
	 * exist
	 *
	 * @param themeId
	 * @return
	 */
	public Theme getTheme(String themeId) {
		return getAllThemes().get(themeId);
	}

	private Map<String, Theme> getAllThemes() {
		if(allThemes == null) {
			allThemes = new LinkedHashMap<String, Theme>(); //Keep the themes ordered, to avoid nondeterministic behavior
			allThemes.put(EmptyTheme.instance.getId(), EmptyTheme.instance);
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

			loadThemeDefinitions(config);
			loadThemeContributions(config);
		}

		return allThemes;
	}

	private void loadThemeDefinitions(IConfigurationElement[] config) {
		for(IConfigurationElement themeConfig : config) {
			if(!themeConfig.getName().equals("themeDefinition")) {
				continue;
			}

			final String themeId = themeConfig.getAttribute("id");
			if(themeId == null) {
				Activator.log.warn("Cannot define a CSS Theme with an empty id (Contributed by " + themeConfig.getContributor() + ")");
				continue;
			}
			Theme theme = new Theme(themeId);

			String themeLabel = themeConfig.getAttribute("label");
			theme.setLabel(themeLabel);

			String themeIcon = themeConfig.getAttribute("icon");
			if(themeIcon != null) {
				//FIXME: Use the Papyrus Image service when it is available
				Image icon = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(themeConfig.getContributor().getName(), themeIcon);
				if(icon != null) {
					theme.setIcon(icon);
				}
			}

			allThemes.put(themeId, theme);
		}
	}

	private void loadThemeContributions(IConfigurationElement[] config) {
		for(IConfigurationElement themeConfig : config) {
			if(!themeConfig.getName().equals("themeContribution")) {
				continue;
			}

			final String themeId = themeConfig.getAttribute("id");
			if(themeId == null || !allThemes.containsKey(themeId)) {
				Activator.log.warn("Cannot contribute to an undefined theme: " + themeId);
				continue;
			}

			Theme theme = allThemes.get(themeId);

			IConfigurationElement[] stylesheets = themeConfig.getChildren("stylesheet");
			for(IConfigurationElement stylesheetConfig : stylesheets) {
				String path = stylesheetConfig.getAttribute("stylesheetPath");
				try {
					URL url = new URL("platform:/plugin/" + themeConfig.getContributor().getName() + "/" + path);
					theme.addStyleSheet(url);
				} catch (IOException ex) {
					Activator.log.error(ex);
				}
			}
		}
	}

	private Theme findCurrentTheme() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		if(store.contains(ThemePreferences.CURRENT_THEME)) {
			String themeId = store.getString(ThemePreferences.CURRENT_THEME);
			Theme theme = getAllThemes().containsKey(themeId) ? getAllThemes().get(themeId) : EmptyTheme.instance;
			return theme;
		}

		//The theme has not been defined: return the first one, and store it
		List<Theme> sortedThemes = new ArrayList<Theme>(getAllThemes().values());
		if(sortedThemes.size() < 2) {
			return EmptyTheme.instance;
		}

		//Index 0 is EmptyTheme ; we return the first non-empty theme
		Theme theme = sortedThemes.get(1);
		store.setValue(ThemePreferences.CURRENT_THEME, theme.getId());
		try {
			((IPersistentPreferenceStore)store).save();
		} catch (IOException e) {
			Activator.log.error(e);
		}
		return theme;
	}

	public static class EmptyTheme extends Theme {

		public static Theme instance = new EmptyTheme();

		private EmptyTheme() {
			super("none"); //$NON-NLS-1$
			setLabel("No theme");
			Image icon = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/Delete_12x12.gif");
			setIcon(icon);
		}
	}

	/**
	 * Sorts the Themes alphabetically (Based on their label). The Empty theme
	 * is always the first element.
	 *
	 * @author Camille Letavernier
	 */
	private static class ThemeComparator implements Comparator<Theme> {

		private ThemeComparator() {
		}

		@Override
		public int compare(Theme o1, Theme o2) {
			if(o1 == EmptyTheme.instance) {
				return -1;
			}
			if(o2 == EmptyTheme.instance) {
				return 1;
			}

			return Collator.getInstance().compare(o1.getLabel(), o2.getLabel());
		}

		public static Comparator<Theme> instance = new ThemeComparator();

	}

	private ThemeManager() {

	}
}
