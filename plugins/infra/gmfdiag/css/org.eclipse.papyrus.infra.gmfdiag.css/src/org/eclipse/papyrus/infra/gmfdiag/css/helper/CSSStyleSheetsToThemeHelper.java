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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
public class CSSStyleSheetsToThemeHelper {


	/**
	 * Default constructor.
	 *
	 */
	public CSSStyleSheetsToThemeHelper() {
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

		return theme;

	}

	/**
	 * Svae theme in workspace preferences.
	 * 
	 * @param theme
	 *        Theme to save
	 */
	public void saveThemeWorkspacePreference(Theme theme) {
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

		// Save theme preference file
		if(themeFile != null) {
			try {
				themeFile.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}
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
			styleSheetsReference.setPath(URI.createFileURI(cssFile.getLocation().toOSString()).toFileString());
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

		// Get workspace path
		IPath pluginStatePath = Activator.getDefault().getStateLocation();

		// Build preference file path
		IPath themeFilePath = pluginStatePath.append("theme.xmi");

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
}
