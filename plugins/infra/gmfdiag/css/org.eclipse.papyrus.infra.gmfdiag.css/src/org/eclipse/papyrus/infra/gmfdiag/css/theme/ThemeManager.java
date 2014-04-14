/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.theme;

import java.io.IOException;
import java.net.URL;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.WorkspaceThemesHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.preferences.ThemePreferences;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.WorkspaceThemes;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.ThemeImpl;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

/**
 * A Singleton to manage CSS Themes. Reads Themes from an extension point
 * and provides an access to them.
 *
 * @author Camille Letavernier
 *
 */
public class ThemeManager {

	/** Extension point ID. */
	public static String EXTENSION_ID = Activator.PLUGIN_ID + ".theme";

	/** Unique instance of manager. */
	public static ThemeManager instance = new ThemeManager();

	/** All found themes in application. */
	private Map<String, Theme> allThemes = null;

	/** Unsaved themes. */
	private List<Theme> temporaryThemesList = new ArrayList<Theme>();

	/** Themes to delete. */
	private List<Theme> deletedThemesList = new ArrayList<Theme>();

	/** Workspace themes helper. */
	private WorkspaceThemesHelper workspaceThemesHelper = new WorkspaceThemesHelper();

	/**
	 * Default constructor.
	 */
	private ThemeManager() {

	}

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
	public List<StyleSheet> getWorkspaceStyleSheets() {
		Theme current = findCurrentTheme();
		if(current == null) {
			return Collections.emptyList();
		}
		return current.getStylesheets();
	}

	/**
	 * Returns the theme associated to the given id, or <code>null</code> if it doesn't
	 * exist
	 *
	 * @param themeId
	 * @return
	 */
	public Theme getTheme(String themeId) {
		return getAllThemes().get(themeId);
	}

	/**
	 * Permit to reload known themes list.
	 */
	public void reloadThemes() {
		allThemes = null;
	}

	/**
	 * Refresh known themes list by merging states of themes.
	 */
	public void refreshThemes() {

		// Handle added themes
		for(Theme addedTheme : temporaryThemesList) {

			String key = addedTheme.getId();
			if(!allThemes.containsKey(key)) {
				allThemes.put(key, addedTheme);
			}
		}

		// Handle deleted themes
		for(Theme deletedTheme : deletedThemesList) {
			String key = deletedTheme.getId();
			if(allThemes.containsKey(key)) {
				allThemes.remove(key);
			}
		}

	}


	/**
	 * Clean temporary list of themes.
	 */
	public void clearTemporaryThemes() {
		temporaryThemesList.clear();
	}

	/**
	 * Clean deleted theme list.
	 */
	public void clearDeletedThemes() {
		deletedThemesList.clear();
	}

	/**
	 * Add a temporary theme.
	 * 
	 * @param temporaryTheme
	 *        Theme to add in workspace themes preference
	 * 
	 */
	public void addTemporaryTheme(Theme temporaryTheme) {
		temporaryThemesList.add(temporaryTheme);
	}

	/**
	 * Delete theme from preferences.
	 * 
	 * @param theme
	 *        Theme to delete
	 */
	public void delete(Theme theme) {

		// If theme is temporary don't maintain in associated list
		if(temporaryThemesList.contains(theme)) {
			temporaryThemesList.remove(theme);
		} else {
			// Else store in a list to be able to cancel
			deletedThemesList.add(theme);
		}
	}

	/**
	 * Get icon from a theme. Icon can register with plugin URI or file URI.
	 * 
	 * @param theme
	 *        Theme which can have an icon
	 * @return Loaded image, otherwise <code>null</code>
	 */
	public Image getThemeIcon(Theme theme) {
		Image icon = null;


		String iconPath = theme.getIcon();
		if(iconPath != null) {

			// First : looking for theme in contribution
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
			icon = handleThemeDefinition(theme, config);

			// Second : Try to load image from its path 
			if(icon == null) {

				// Test path to icon 
				IPath path = new Path(iconPath);
				if(path.toFile().exists()) {
					icon = new Image(PlatformUI.getWorkbench().getDisplay(), iconPath);
				}

			}
		}

		return icon;
	}

	/**
	 * Return only workspace themes preference.
	 * 
	 * @return Workspace themes preference (instance of {@link WorkspaceThemes}) if it exist, otherwise <code>null</code>
	 */
	public WorkspaceThemes getWorkspaceThemesPreferences() {
		WorkspaceThemes workspaceThemes = null;


		// Get path of preference file
		IPath path = workspaceThemesHelper.getThemeWorkspacePreferenceFilePath();

		// If file exist, themes can load
		if(path.toFile().exists()) {
			// Resolve URI
			URI fileURI = CommonPlugin.resolve(URI.createFileURI(path.toOSString()));

			// Create associated resource
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(fileURI, true);

			// Get workspace theme
			workspaceThemes = (WorkspaceThemes)EcoreUtil.getObjectByType(resource.getContents(), StylesheetsPackage.eINSTANCE.getWorkspaceThemes());
		}

		return workspaceThemes;

	}

	/**
	 * Know if theme is editable. Only themes of workspace or temporary can be edited.
	 * 
	 * @param id
	 *        Id of theme to check
	 * @return <code>true</code> if theme can be edited, otherwise <code>false<code>
	 */
	public boolean isEditable(String id) {
		boolean isEditable = false;

		WorkspaceThemes workspacePreference = getWorkspaceThemesPreferences();
		if(workspacePreference != null) {

			// Check if theme existing in temporary
			isEditable = temporaryThemesList.contains(allThemes.get(id));

			//Check if theme comes from workspace preferences
			Iterator<Theme> themesIterator = workspacePreference.getThemes().iterator();
			while(themesIterator.hasNext() && !isEditable) {
				isEditable = id.equals(themesIterator.next().getId());
			}


		}

		return isEditable;
	}

	/**
	 * Persist state of the manager.
	 */
	public void persist() {
		Theme[] editableThemes = getEditableThemes();
		workspaceThemesHelper.saveWorkspaceThemesPreferenceResource(editableThemes, deletedThemesList.toArray(new Theme[deletedThemesList.size()]));

		// Reset manager
		allThemes = null;
		deletedThemesList.clear();
		temporaryThemesList.clear();
	}

	/**
	 * @return
	 */
	private Theme[] getEditableThemes() {
		List<Theme> editableThemeList = new ArrayList<Theme>();

		for(Theme theme : allThemes.values()) {
			if(isEditable(theme.getId())) {
				editableThemeList.add(theme);
			}
		}
		return editableThemeList.toArray(new Theme[editableThemeList.size()]);
	}

	/**
	 * Look for corresponding theme in theme definition contribution and load its image.
	 * 
	 * @param theme
	 *        Theme to find in all contribution
	 * @param config
	 *        Configuration of all theme contribution
	 * @return Loaded image if theme is came from contribution, otherwise <code>null</code>
	 */
	private Image handleThemeDefinition(Theme theme, IConfigurationElement[] config) {
		Image icon = null;

		for(IConfigurationElement themeContribution : config) {

			// Verify that contribution is a theme definition
			if(!themeContribution.getName().equals("themeDefinition")) {
				continue;
			}

			// Get label and Id of definition to compare to parameter 
			String themeId = themeContribution.getAttribute("id");
			String themeLabel = themeContribution.getAttribute("label");

			if(themeId != null && themeId.equals(theme.getId()) && themeLabel != null && themeLabel.equals(theme.getLabel())) {
				//FIXME: Use the Papyrus Image service when it is available
				icon = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(themeContribution.getContributor().getName(), theme.getIcon());
			}
		}

		return icon;
	}

	private Map<String, Theme> getAllThemes() {
		if(allThemes == null) {
			allThemes = new LinkedHashMap<String, Theme>(); //Keep the themes ordered, to avoid nondeterministic behavior
			allThemes.put(EmptyTheme.instance.getId(), EmptyTheme.instance);
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

			loadThemeDefinitions(config);
			loadThemeContributions(config);
			loadThemePreferenceWorkspace();
			loadTemporaryThemes();

			// Remove deleted themes
			for(Theme theme : deletedThemesList) {
				String themeId = theme.getId();
				if(allThemes.containsKey(themeId)) {
					allThemes.remove(themeId);
				}
			}
		}

		return allThemes;
	}

	/**
	 * Load theme definitions.
	 *
	 * @param config
	 *        configuration of all contribution definition
	 */
	private void loadThemeDefinitions(IConfigurationElement[] config) {

		// For all theme definitions
		for(IConfigurationElement themeConfig : config) {

			if(!themeConfig.getName().equals("themeDefinition")) {
				continue;
			}

			final String themeId = themeConfig.getAttribute("id");
			if(themeId == null) {
				Activator.log.warn("Cannot define a CSS Theme with an empty id (Contributed by " + themeConfig.getContributor() + ")");
				continue;
			}

			//Create theme 
			Theme theme = StylesheetsFactory.eINSTANCE.createTheme();
			theme.setId(themeId);

			String themeLabel = themeConfig.getAttribute("label");
			theme.setLabel(themeLabel);

			String themeIcon = themeConfig.getAttribute("icon");
			if(themeIcon != null) {

				theme.setIcon(themeIcon);

			}

			allThemes.put(themeId, theme);
		}
	}

	/**
	 * Load theme contributions.
	 *
	 * @param config
	 *        configuration of all contribution definition
	 */
	private void loadThemeContributions(IConfigurationElement[] config) {
		for(IConfigurationElement themeConfig : config) {

			// Verify that 
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
					StyleSheetReference styleSheet = StylesheetsFactory.eINSTANCE.createStyleSheetReference();
					styleSheet.setPath(url.toString());
					theme.getStylesheets().add(styleSheet);
				} catch (IOException ex) {
					Activator.log.error(ex);
				}
			}
		}
	}

	/**
	 * Load themes of workspace preference.
	 */
	private void loadThemePreferenceWorkspace() {

		WorkspaceThemes workspaceThemes = getWorkspaceThemesPreferences();

		// If file exist, themes can load
		if(workspaceThemes != null) {


			// Add each themme to current list
			for(Theme theme : workspaceThemes.getThemes()) {
				allThemes.put(theme.getId(), theme);
			}

		}
	}

	/**
	 * Add temporary themes in current themes list.
	 */
	private void loadTemporaryThemes() {
		for(Theme theme : temporaryThemesList) {
			allThemes.put(theme.getId(), theme);
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

	public static class EmptyTheme extends ThemeImpl {

		public static Theme instance = new EmptyTheme();

		private EmptyTheme() {
			setId("none");
			setLabel("No theme");
			setIcon("icons/Delete_12x12.gif");
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
}
