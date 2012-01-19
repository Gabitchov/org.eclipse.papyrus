package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import java.io.IOException;

import org.eclipse.e4.ui.css.core.css2.CSS2ColorHelper;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.helper.ConversionHelper;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.CSSFontStyle;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.RGBColor;

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
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_FontColor().getDefaultValue();
			return (Integer)defaultValue;
		} else {
			try {
				CSSValue value = engine.parsePropertyValue(cssValue);
				RGBColor color;
				if(value instanceof RGBColor) {
					color = (RGBColor)value;
				} else {
					color = CSS2ColorHelper.getRGBColor(cssValue);
				}

				return ConversionHelper.getIntColor(color);
			} catch (IOException ex) {
				Activator.log.error(ex);
			}
		}

		return Integer.parseInt(cssValue);
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
