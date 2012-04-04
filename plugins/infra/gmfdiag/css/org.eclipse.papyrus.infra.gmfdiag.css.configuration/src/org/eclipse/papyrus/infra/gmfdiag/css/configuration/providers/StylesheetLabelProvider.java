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

import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.CSSRuntimeModule;
import org.eclipse.papyrus.infra.gmfdiag.css.Ruleset;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.serializer.ISerializer;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

//TODO: Add a context to this LabelProvider (Selected View)
//TODO: When a Ruleset is applied/applicable on the selected View, change its color
public class StylesheetLabelProvider extends EMFLabelProvider {

	@Inject
	private ISerializer serializer;

	public StylesheetLabelProvider() {
		Injector injector = Guice.createInjector(new CSSRuntimeModule());
		injector.injectMembers(this);
	}

	@Override
	public String getText(Object element) {
		if(element instanceof Ruleset) {
			return getText((Ruleset)element);
		}

		if(element instanceof StyleSheetReference) {
			return getText((StyleSheetReference)element);
		}

		if(element instanceof EmbeddedStyleSheet) {
			return getText((EmbeddedStyleSheet)element);
		}

		return super.getText(element);
	}

	public String getText(Ruleset ruleset) {
		//Delegate the label to XText serialization
		String label = "";

		if(!ruleset.getSelectors().isEmpty()) {
			label += serializer.serialize(ruleset.getSelectors().get(0));
			for(int i = 1; i < ruleset.getSelectors().size(); i++) {
				label += ", " + serializer.serialize(ruleset.getSelectors().get(i));
			}
			label = label.trim().replaceAll("\\s+", " ");
		}

		return label;
	}

	public String getText(StyleSheetReference stylesheet) {
		return stylesheet.getPath();
	}

	public String getText(EmbeddedStyleSheet stylesheet) {
		return stylesheet.getLabel();
	}

	@Override
	public Color getForeground(Object element) {
		if(!(element instanceof Ruleset)) {
			return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY);
		}
		return super.getForeground(element);
	}

	@Override
	public Image getImage(Object element) {
		//		if(element instanceof StyleSheetReference) {
		//			return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, "/icons/sourceEditor.gif");
		//		}
		return null;
	}
}
