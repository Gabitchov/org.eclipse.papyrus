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
package org.eclipse.papyrus.infra.gmfdiag.css.configuration.handler;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.gmfdiag.css.Attribute;
import org.eclipse.papyrus.infra.gmfdiag.css.CssFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.Declaration;
import org.eclipse.papyrus.infra.gmfdiag.css.Ruleset;
import org.eclipse.papyrus.infra.gmfdiag.css.Stylesheet;
import org.eclipse.papyrus.infra.gmfdiag.css.configuration.helper.XtextStylesheetHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;


public class CreateStyleHandler extends AbstractStyleHandler {

	@Override
	protected AbstractStyleDialog createStyleDialog(Shell shell, Map<Declaration, Boolean> declarations, Map<Attribute, Boolean> conditions, String selectorName, View context) {
		return new StyleCreationDialog(shell, conditions, declarations, selectorName, context);
	}

	@Override
	protected Ruleset getRuleset(AbstractStyleDialog dialog) {
		return CssFactory.eINSTANCE.createRuleset();
	}

	@Override
	protected Stylesheet getStyleSheet(AbstractStyleDialog dialog, View contextView) {
		StyleSheet styleSheet = ((StyleCreationDialog)dialog).getStyleSheet();

		if(styleSheet == null) {
			MessageDialog.open(MessageDialog.ERROR, dialog.getShell(), "Stylesheet error", "Invalid stylesheet", SWT.NONE);
			return null;
		}

		Resource resource;

		if(styleSheet instanceof StyleSheetReference) {
			resource = XtextStylesheetHelper.loadStylesheet((StyleSheetReference)styleSheet, null, contextView, dialog.getShell());
			if(resource == null) {
				return null;
			}
		} else {
			MessageDialog.open(MessageDialog.ERROR, dialog.getShell(), "Stylesheet error", "Embedded stylesheets are not yet supported", SWT.NONE);
			return null;
		}

		Stylesheet xtextStylesheet;

		if(resource.getContents().isEmpty()) {
			xtextStylesheet = CssFactory.eINSTANCE.createStylesheet();
			xtextStylesheet.setCharset("UTF-8");
			resource.getContents().add(xtextStylesheet);
		} else {
			xtextStylesheet = (Stylesheet)resource.getContents().get(0);
		}

		return xtextStylesheet;
	}

}
