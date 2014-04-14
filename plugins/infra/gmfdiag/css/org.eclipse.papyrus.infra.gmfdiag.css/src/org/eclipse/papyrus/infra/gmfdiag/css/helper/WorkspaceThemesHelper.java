/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.WorkspaceThemes;



/**
 * Helper to define a theme from CSS style sheet file.
 * 
 * @author gpascual
 *
 */
public class WorkspaceThemesHelper {


	/**
	 * Default constructor.
	 *
	 */
	public WorkspaceThemesHelper() {
	}

	/**
	 * Define a theme from selected files.
	 * <p>
	 * FIXME User could select several CSS files to create a theme
	 * <P>
	 * 
	 * @param file
	 */
	public Theme defineCSSStyleSheetFilesAsTheme(IStructuredSelection selection) {
		List<IFile> selectedCSSFilesList = new ArrayList<IFile>();

		// Extract file from selection
		Iterator<?> selectionIterator = selection.iterator();

		while(selectionIterator.hasNext()) {
			Object next = selectionIterator.next();
			if(next instanceof IFile) {
				selectedCSSFilesList.add((IFile)next);
			}
		}

		// Create a theme from selected CSS file
		Theme theme = createThemeFromSelection(selectedCSSFilesList);
		theme.setId(EcoreUtil.generateUUID());

		return theme;

	}

	/**
	 * Method to persist deleted and edited theme in workspace preference file.
	 * 
	 * @param editedThemesArray
	 *        Array of edited themes to persist
	 * @param deletedThemesArray
	 *        Array of deleted theme to persist
	 */
	public void saveWorkspaceThemesPreferenceResource(Theme[] editedThemesArray, Theme[] deletedThemesArray) {

		// Get current resource of workspace theme preferences
		Resource currentThemefile = findThemeFile();
		WorkspaceThemes workspaceThemes = (WorkspaceThemes)EcoreUtil.getObjectByType(currentThemefile.getContents(), StylesheetsPackage.Literals.WORKSPACE_THEMES);

		// Handle edited  themes
		for(Theme editedTheme : editedThemesArray) {
			boolean updateResult = updateWorkspaceTheme(editedTheme, workspaceThemes);

			// If update haven't done, theme must be added 
			if(!updateResult) {
				workspaceThemes.getThemes().add(editedTheme);
			}
		}

		// Handle deleted themes
		for(Theme deletedTheme : deletedThemesArray) {
			removeWorkspaceTheme(deletedTheme, workspaceThemes);
		}

		// Save edited preference file
		saveResource(currentThemefile);

	}

	/**
	 * Method to delete a theme in workspace theme.
	 * 
	 * @param deletedTheme
	 *        Theme to delete
	 * @param workspaceThemes
	 *        Current workspace themes
	 */
	private void removeWorkspaceTheme(Theme deletedTheme, WorkspaceThemes workspaceThemes) {
		// Search resource value of edited theme
		Iterator<Theme> currentThemesIterator = workspaceThemes.getThemes().iterator();
		Theme themeId = null;
		boolean found = false;

		while(currentThemesIterator.hasNext() && !found) {
			themeId = currentThemesIterator.next();
			found = themeId.getId().equals(deletedTheme.getId());
		}

		if(found) {
			// Replace in resource the current value with the edited one and save resource
			EcoreUtil.remove(workspaceThemes, StylesheetsPackage.eINSTANCE.getWorkspaceThemes_Themes(), themeId);
		}



	}

	/**
	 * Replace in current workspace themes resource theme with the edited value.
	 * 
	 * @param editedTheme
	 *        New theme value
	 */
	public void saveWorkspaceThemesPreferenceResource(Theme editedTheme) {
		// Get current resource of workspace theme preferences
		Resource currentThemefile = findThemeFile();
		WorkspaceThemes workspaceThemes = (WorkspaceThemes)EcoreUtil.getObjectByType(currentThemefile.getContents(), StylesheetsPackage.Literals.WORKSPACE_THEMES);

		updateWorkspaceTheme(editedTheme, workspaceThemes);

		saveResource(currentThemefile);
	}

	/**
	 * 
	 * Update in current workspace themes resource the theme with the edited one.
	 * 
	 * @param editedTheme
	 *        Theme with new value
	 * @param workspaceThemes
	 *        workspace themes
	 */
	private boolean updateWorkspaceTheme(Theme editedTheme, WorkspaceThemes workspaceThemes) {
		// Search resource value of edited theme
		Iterator<Theme> currentThemesIterator = workspaceThemes.getThemes().iterator();
		Theme themeId = null;
		boolean found = false;

		while(currentThemesIterator.hasNext() && !found) {
			themeId = currentThemesIterator.next();
			found = themeId.getId().equals(editedTheme.getId());
		}

		if(found) {
			// Replace in resource the current value with the edited one and save resource
			EcoreUtil.replace(workspaceThemes, StylesheetsPackage.eINSTANCE.getWorkspaceThemes_Themes(), themeId, editedTheme);
		}

		return found;
	}

	/**
	 * Save style sheets EMF Resource.
	 * 
	 * @param styleSheetsResource
	 * 
	 */
	private void saveResource(Resource styleSheetsResource) {
		// Save theme preference file
		if(styleSheetsResource != null) {
			try {
				Map<String, Object> options = new HashMap<String, Object>();
				options.put(XMIResource.XMI_ID, Boolean.TRUE);
				styleSheetsResource.save(options);
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}
	}


	/**
	 * Save theme in workspace preferences.
	 * 
	 * @param theme
	 *        Theme to save
	 */
	public void saveNewThemeWorkspacePreference(Theme theme) {
		Resource themeFile = theme.eResource();

		if(themeFile == null) {
			themeFile = findThemeFile();
		}

		// Get workspace themes
		WorkspaceThemes workspaceThemes = (WorkspaceThemes)EcoreUtil.getObjectByType(themeFile.getContents(), StylesheetsPackage.eINSTANCE.getWorkspaceThemes());

		// Create a workspace themes root 
		if(workspaceThemes == null) {
			workspaceThemes = StylesheetsFactory.eINSTANCE.createWorkspaceThemes();
			themeFile.getContents().add(workspaceThemes);
		}

		// Add created theme 
		workspaceThemes.getThemes().add(theme);

		saveResource(themeFile);

	}

	/**
	 * Created a style sheets theme from project selection.
	 * 
	 * @param selectedCSSFilesList
	 * @return
	 */
	private Theme createThemeFromSelection(List<IFile> selectedCSSFilesList) {

		// Factory to create necessary elements
		StylesheetsFactory styleSheetsFactory = StylesheetsFactory.eINSTANCE;

		// Create new theme
		Theme newTheme = styleSheetsFactory.createTheme();

		for(IFile cssFile : selectedCSSFilesList) {

			//Style sheets to add in theme
			StyleSheetReference styleSheetsReference = styleSheetsFactory.createStyleSheetReference();
			styleSheetsReference.setPath(URI.createFileURI(cssFile.getLocation().toOSString()).toString());
			newTheme.getStylesheets().add(styleSheetsReference);
		}
		return newTheme;
	}

	/**
	 * Look for theme workspace preferences file.
	 * 
	 * @return Created resource if it don't exist, otherwise loaded
	 */
	private Resource findThemeFile() {

		IPath themeFilePath = getThemeWorkspacePreferenceFilePath();

		// Create associated URI
		URI resolvedURI = CommonPlugin.resolve(URI.createFileURI(themeFilePath.toOSString()));

		// Create EMF resource
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = null;

		if(themeFilePath.toFile().exists()) {
			resource = resourceSet.getResource(resolvedURI, true);
		} else {
			resource = resourceSet.createResource(resolvedURI);
		}

		return resource;
	}

	/**
	 * Build path to access preference file.
	 * 
	 * @return Path to theme.xmi file in workspace preference directory
	 */
	public IPath getThemeWorkspacePreferenceFilePath() {
		// Get workspace path
		IPath pluginStatePath = Activator.getDefault().getStateLocation();

		// Build preference file path
		IPath themeFilePath = pluginStatePath.append("theme.xmi");
		return themeFilePath;
	}
}
