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
package org.eclipse.papyrus.infra.gmfdiag.css.style.impl;

import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.PageStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSPageStyle;
import org.w3c.dom.css.CSSValue;

public class CSSPageStyleDelegate implements CSSPageStyle {

	private PageStyle pageStyle;

	private ExtendedCSSEngine engine;

	public CSSPageStyleDelegate(PageStyle pageStyle, ExtendedCSSEngine engine) {
		this.pageStyle = pageStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSPageX() {
		CSSValue cssValue = engine.retrievePropertyValue(pageStyle, "pageX");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageX().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}

	public int getCSSPageY() {
		CSSValue cssValue = engine.retrievePropertyValue(pageStyle, "pageY");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageY().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}

	public int getCSSPageWidth() {
		CSSValue cssValue = engine.retrievePropertyValue(pageStyle, "pageWidth");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageWidth().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}

	public int getCSSPageHeight() {
		CSSValue cssValue = engine.retrievePropertyValue(pageStyle, "pageHeight");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageHeight().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}
}
