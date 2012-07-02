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
package org.eclipse.papyrus.infra.gmfdiag.css.configuration.providers;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.gmfdiag.css.Content;
import org.eclipse.papyrus.infra.gmfdiag.css.Ruleset;
import org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet;
import org.eclipse.papyrus.infra.gmfdiag.css.configuration.helper.XtextStylesheetHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;


public class ExistingStyleContentProvider implements IHierarchicContentProvider {

	protected Map<StyleSheet, Stylesheet> stylesheets;

	protected final View context;

	public ExistingStyleContentProvider(View context) {
		this.context = context;
	}

	public Object[] getElements(Object inputElement) {
		Collection<StyleSheet> stylesheets = getStyleSheets();
		if(stylesheets.isEmpty()) {
			//Display a message to let the user know why he cannot edit a stylesheet
			return new Object[]{ "No stylesheet available" };
		}
		return stylesheets.toArray();
	}

	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof StyleSheet) {
			Stylesheet xtextStylesheet = stylesheets.get(parentElement);

			List<Ruleset> result = new LinkedList<Ruleset>();

			for(Content stylesheetElement : xtextStylesheet.getContents()) {
				if(stylesheetElement instanceof Ruleset) {
					result.add((Ruleset)stylesheetElement);
				}
			}

			return result.toArray();
		} else {
			return new Object[0];
		}
	}

	public Object getParent(Object element) {
		if(element instanceof Stylesheet) {
			return null;
		}

		if(element instanceof Ruleset) {
			return ((Ruleset)element).eContainer();
		}

		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	public boolean isValidValue(Object element) {
		return element instanceof Ruleset;
	}

	protected Collection<StyleSheet> getStyleSheets() {
		if(stylesheets == null) {
			stylesheets = new LinkedHashMap<StyleSheet, Stylesheet>();
			if(context.getDiagram() instanceof CSSDiagram) {
				CSSDiagram diagram = (CSSDiagram)context.getDiagram();
				parseStyleSheets(diagram.getStyleSheets());
			}
		}
		return stylesheets.keySet();
	}

	protected void parseStyleSheets(List<StyleSheet> appliedStylesheets) {
		for(StyleSheet stylesheet : appliedStylesheets) {
			if(stylesheet instanceof StyleSheetReference) {
				parseStyleSheet((StyleSheetReference)stylesheet);
			} else if(stylesheet instanceof EmbeddedStyleSheet) {
				//Unsupported yet
			}
		}
	}

	protected void parseStyleSheet(StyleSheetReference stylesheet) {
		Resource resource = XtextStylesheetHelper.loadStylesheet(stylesheet, null, context, null);
		if(resource.getContents().isEmpty()) {
			return;
		}

		for(EObject rootElement : resource.getContents()) {
			if(rootElement instanceof Stylesheet) {
				stylesheets.put(stylesheet, (Stylesheet)rootElement);
			}
		}
	}

}
