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
package org.eclipse.papyrus.infra.gmfdiag.css.configuration.helper;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * A helper for XText stylesheets
 *
 * @author Camille Letavernier
 *
 */
public class XtextStylesheetHelper {

	/**
	 * Loads and returns a Resource containing an XText Stylesheet
	 *
	 * @param stylesheet
	 *        The object representing the Stylesheet's path or contents
	 * @param resourceSet
	 *        The resourceSet in which the resource will be loaded. May be null.
	 * @param contextView
	 *        The context view. If the stylesheet's path is relative, it will be resolved against this view's URI.
	 * @param parentShell
	 *        The shell used to open error dialogs. May be null
	 * @return
	 *         A resource containing the loaded stylesheet, or null if the stylesheet could not be resolved or is invalid
	 */
	public static Resource loadStylesheet(StyleSheet stylesheet, ResourceSet resourceSet, View contextView, Shell parentShell) {
		if(stylesheet instanceof StyleSheetReference) {
			return loadStylesheet((StyleSheetReference)stylesheet, resourceSet, contextView, parentShell);
		} else if(stylesheet instanceof EmbeddedStyleSheet) {
			//TODO: Edit EmbeddedStyleSheets with XText
			throw new UnsupportedOperationException();
		}
		return null;
	}

	/**
	 * Loads and returns a Resource containing an XText Stylesheet
	 *
	 * @param stylesheet
	 *        The object representing the Stylesheet's path
	 * @param resourceSet
	 *        The resourceSet in which the resource will be loaded. May be null.
	 * @param contextView
	 *        The context view. If the stylesheet's path is relative, it will be resolved against this view's URI.
	 * @param parentShell
	 *        The shell used to open error dialogs. May be null
	 * @return
	 *         A resource containing the loaded stylesheet, or null if the stylesheet could not be resolved or is invalid
	 */
	public static Resource loadStylesheet(StyleSheetReference stylesheet, ResourceSet resourceSet, View contextView, Shell parentShell) {
		if(resourceSet == null) {
			resourceSet = new XtextResourceSet();
		}

		//Supported pathes:
		// /<plugin>/path/file.css (Workspace, platform:/resource/)
		// relative/path/file.css (Relative)
		String path = stylesheet.getPath();
		if(!path.endsWith(".css")) {
			//FIXME: The X-Text editor supports CSS Content Types, but it is not yet configured
			//to automatically accept other extensions than *.css
			//The parser should rely on the file's content type instead of the file extension
			//Attemps to serialize to a custom extension (even an extension compatible with CSS Content Type)
			//would result in xmi serialization. We'd better stop here.
			if(parentShell != null) {
				MessageDialog.open(MessageDialog.ERROR, parentShell, "Stylesheet error", "The stylesheet must have the *.css extension", SWT.NONE);
			}
			return null;
		}

		URI uri;
		if(path.startsWith("/")) {
			uri = URI.createPlatformResourceURI(path, true);
		} else {
			uri = URI.createURI(path);
			uri = uri.resolve(contextView.eResource().getURI());
		}

		Resource resource;

		try {
			resource = resourceSet.getResource(uri, true);
		} catch (Exception ex) {
			resource = resourceSet.createResource(uri, "org.eclipse.wst.css.core.csssource"); //$NON-NLS-1$
		}

		return resource;
	}
}
