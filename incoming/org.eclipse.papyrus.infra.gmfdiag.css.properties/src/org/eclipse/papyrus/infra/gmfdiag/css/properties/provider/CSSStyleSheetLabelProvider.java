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
package org.eclipse.papyrus.infra.gmfdiag.css.properties.provider;

import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;


public class CSSStyleSheetLabelProvider extends EMFLabelProvider {

	@Override
	public String getText(Object element) {
		if(element instanceof StyleSheetReference) {
			return ((StyleSheetReference)element).getPath();
		} else if(element instanceof EmbeddedStyleSheet) {
			EmbeddedStyleSheet styleSheet = (EmbeddedStyleSheet)element;
			if(styleSheet.getLabel() == null || "".equals(styleSheet.getLabel())) {
				return "EmbeddedStyleSheet";
			}
			return styleSheet.getLabel();
		}
		return super.getText(element);
	}
}
