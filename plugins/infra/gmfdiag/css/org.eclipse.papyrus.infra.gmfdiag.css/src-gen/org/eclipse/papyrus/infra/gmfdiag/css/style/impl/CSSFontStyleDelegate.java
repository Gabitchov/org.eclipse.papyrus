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

import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSFontStyle;
import org.w3c.dom.css.CSSValue;

public class CSSFontStyleDelegate implements CSSFontStyle {

	private FontStyle fontStyle;

	private ExtendedCSSEngine engine;

	public CSSFontStyleDelegate(FontStyle fontStyle, ExtendedCSSEngine engine) {
		this.fontStyle = fontStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSFontColor() {
		CSSValue cssValue = engine.retrievePropertyValue(fontStyle, "fontColor");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_FontColor().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, "GMFColor", null);
	}

	public java.lang.String getCSSFontName() {
		CSSValue cssValue = engine.retrievePropertyValue(fontStyle, "fontName");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_FontName().getDefaultValue();
			return (String)defaultValue;
		}
		return (String)engine.convert(cssValue, String.class, null);
	}

	public int getCSSFontHeight() {
		CSSValue cssValue = engine.retrievePropertyValue(fontStyle, "fontHeight");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_FontHeight().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}

	public boolean isCSSBold() {
		CSSValue cssValue = engine.retrievePropertyValue(fontStyle, "bold");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_Bold().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public boolean isCSSItalic() {
		CSSValue cssValue = engine.retrievePropertyValue(fontStyle, "italic");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_Italic().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public boolean isCSSUnderline() {
		CSSValue cssValue = engine.retrievePropertyValue(fontStyle, "underline");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_Underline().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public boolean isCSSStrikeThrough() {
		CSSValue cssValue = engine.retrievePropertyValue(fontStyle, "strikeThrough");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}
}
