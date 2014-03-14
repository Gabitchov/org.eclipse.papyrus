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
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
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
	 * @param file
	 */
	public void defineCSSStyleSheetFileAsTheme(IFile file) {

		Resource themeFile = findThemeFile();

		WorkspaceThemes workspaceThemes = (WorkspaceThemes)EcoreUtil.getObjectByType(themeFile.getContents(), StylesheetsPackage.eINSTANCE.getWorkspaceThemes());

		if(workspaceThemes == null) {
			workspaceThemes = StylesheetsFactory.eINSTANCE.createWorkspaceThemes();
			themeFile.getContents().add(workspaceThemes);
		}

		try {
			themeFile.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			Activator.log.error(e);
		}

	}

	/**
	 * @param workspacePath
	 * @return
	 */
	private Resource findThemeFile() {

		IPath pluginStatePath = Activator.getDefault().getStateLocation();
		IPath themeFilePath = pluginStatePath.append("theme.xmi");

		URI resolvedURI = CommonPlugin.resolve(URI.createFileURI(themeFilePath.toOSString()));

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
