package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import java.io.IOException;

import org.eclipse.e4.ui.css.core.css2.CSS2ColorHelper;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.helper.ConversionHelper;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.CSSShapeStyle;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.RGBColor;

@SuppressWarnings("restriction")
public class CSSShapeStyleImpl implements CSSShapeStyle {

	private ShapeStyle shapeStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSShapeStyleImpl(ShapeStyle shapeStyle, CSSStylableElement element, CSSEngine engine) {
		this.shapeStyle = shapeStyle;
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

	public java.lang.String getCSSDescription() {
		String cssValue = engine.retrieveCSSProperty(element, "description", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getDescriptionStyle_Description().getDefaultValue();
			return (String)defaultValue;
		}
		return cssValue;
	}

	public int getCSSFillColor() {
		String cssValue = engine.retrieveCSSProperty(element, "fillColor", "");

		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_FillColor().getDefaultValue();
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

	public int getCSSTransparency() {
		String cssValue = engine.retrieveCSSProperty(element, "transparency", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_Transparency().getDefaultValue();
			return (Integer)defaultValue;
		}
		return Integer.parseInt(cssValue);
	}

	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient() {
		String cssValue = engine.retrieveCSSProperty(element, "gradient", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_Gradient().getDefaultValue();
			return (org.eclipse.gmf.runtime.notation.datatype.GradientData)defaultValue;
		}
		return null;
	}

	public int getCSSLineColor() {
		String cssValue = engine.retrieveCSSProperty(element, "lineColor", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getLineStyle_LineColor().getDefaultValue();
			return (Integer)defaultValue;
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

	public int getCSSRoundedBendpointsRadius() {
		String cssValue = engine.retrieveCSSProperty(element, "roundedBendpointsRadius", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius().getDefaultValue();
			return (Integer)defaultValue;
		}
		return Integer.parseInt(cssValue);
	}
}
