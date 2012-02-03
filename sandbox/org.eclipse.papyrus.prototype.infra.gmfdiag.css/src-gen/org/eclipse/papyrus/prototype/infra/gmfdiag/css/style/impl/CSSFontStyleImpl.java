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
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.converters.ColorToGMFConverter;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.CSSFontStyle;
import org.w3c.dom.css.CSSValue;

@SuppressWarnings("restriction")
public class CSSFontStyleImpl implements CSSFontStyle {

	private FontStyle fontStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSFontStyleImpl(FontStyle fontStyle, CSSStylableElement element, CSSEngine engine) {
		this.fontStyle = fontStyle;
		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSFontColor() {
		String cssValue = engine.retrieveCSSProperty(element, "fontColor", "");
		try {
			CSSValue value = engine.parsePropertyValue(cssValue);
			return (Integer)engine.convert(value, ColorToGMFConverter.GMFColor, null);
		} catch (Exception ex) {
			Activator.log.error(ex);
		}

		return (Integer)NotationPackage.eINSTANCE.getFontStyle_FontColor().getDefaultValue();
	}

	public java.lang.String getCSSFontName() {
		String cssValue = engine.retrieveCSSProperty(element, "fontName", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_FontName().getDefaultValue();
			return (String)defaultValue;
		}
		return cssValue;
	}

	public int getCSSFontHeight() {
		String cssValue = engine.retrieveCSSProperty(element, "fontHeight", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_FontHeight().getDefaultValue();
			return (Integer)defaultValue;
		}
		return Integer.parseInt(cssValue);
	}

	public boolean isCSSBold() {
		String cssValue = engine.retrieveCSSProperty(element, "bold", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_Bold().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return Boolean.parseBoolean(cssValue);
	}

	public boolean isCSSItalic() {
		String cssValue = engine.retrieveCSSProperty(element, "italic", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_Italic().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return Boolean.parseBoolean(cssValue);
	}

	public boolean isCSSUnderline() {
		String cssValue = engine.retrieveCSSProperty(element, "underline", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_Underline().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return Boolean.parseBoolean(cssValue);
	}

	public boolean isCSSStrikeThrough() {
		String cssValue = engine.retrieveCSSProperty(element, "strikeThrough", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return Boolean.parseBoolean(cssValue);
	}
}
