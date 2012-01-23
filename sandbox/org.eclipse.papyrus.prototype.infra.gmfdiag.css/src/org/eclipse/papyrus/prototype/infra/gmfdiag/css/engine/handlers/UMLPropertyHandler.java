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
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.handlers;

import org.eclipse.e4.ui.css.core.dom.properties.ICSSPropertyHandler;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;

@SuppressWarnings("restriction")
public class UMLPropertyHandler implements ICSSPropertyHandler {

	public boolean applyCSSProperty(Object element, String property, CSSValue value, String pseudo, CSSEngine engine) throws Exception {
		return false;
	}

	public String retrieveCSSProperty(Object element, String property, String pseudo, CSSEngine engine) throws Exception {
		CSSStyleDeclaration style = engine.getViewCSS().getComputedStyle((Element)element, pseudo);
		CSSValue value = style.getPropertyCSSValue(property);
		if(value == null) {
			return null;
		}
		return value.getCssText();
	}

}
