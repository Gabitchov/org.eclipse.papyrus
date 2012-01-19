package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import java.io.IOException;

import org.eclipse.e4.ui.css.core.css2.CSS2ColorHelper;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.helper.ConversionHelper;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.CSSLineStyle;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.RGBColor;

@SuppressWarnings("restriction")
public class CSSLineStyleImpl implements CSSLineStyle {

	private LineStyle lineStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSLineStyleImpl(LineStyle lineStyle, CSSStylableElement element, CSSEngine engine) {
		this.lineStyle = lineStyle;
		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSLineColor() {
		String cssValue = engine.retrieveCSSProperty(element, "lineColor", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getLineStyle_LineColor().getDefaultValue();
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

	public int getCSSLineWidth() {
		String cssValue = engine.retrieveCSSProperty(element, "lineWidth", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getLineStyle_LineWidth().getDefaultValue();
			return (Integer)defaultValue;
		}
		return Integer.parseInt(cssValue);
	}
}
