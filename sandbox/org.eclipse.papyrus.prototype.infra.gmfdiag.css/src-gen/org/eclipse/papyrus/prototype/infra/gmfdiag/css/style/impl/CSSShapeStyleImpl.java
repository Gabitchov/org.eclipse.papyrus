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

import java.io.IOException;

import org.eclipse.e4.ui.css.core.css2.CSS2ColorHelper;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.helper.ConversionHelper;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.helper.ParserHelper;
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

		if(cssValue != null) {
			try {
				CSSValue value = engine.parsePropertyValue(cssValue);
				return ConversionHelper.getIntColor(cssValue, value);
			} catch (IOException ex) {
				Activator.log.error(ex);
			}
		}

		return (Integer)NotationPackage.eINSTANCE.getFillStyle_FillColor().getDefaultValue();
	}

	public int getCSSTransparency() {
		String cssValue = engine.retrieveCSSProperty(element, "transparency", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_Transparency().getDefaultValue();
			return (Integer)defaultValue;
		}
		return Integer.parseInt(cssValue);
	}

	//Type 1 :
	//gradientColor:#ABCDEF;
	//gradientStyle:vertical;

	//Type 2 :
	//(gradient:#FEDCBA #ABCDEF horizontal;) //Currently not supported, as diagrams usually seek for #fillColor()
	//gradient:#ABCDEF horizontal;
	//gradient:#ABCDEF
	//gradient:horizontal
	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient() {
		//Type 1
		String gradientColor = engine.retrieveCSSProperty(element, "gradientColor", "");
		String gradientStyle = engine.retrieveCSSProperty(element, "gradientStyle", "");

		if(gradientColor != null || gradientStyle != null) {
			int color1 = getGradientColor(gradientColor);
			int color2 = 0; //Unused by Papyrus diagrams
			int style = getGradientStyle(gradientStyle);
			GradientData data = new GradientData(color1, color2, style);
			return data;
		}

		//Type 2
		String gradient = engine.retrieveCSSProperty(element, "gradient", "");

		if(gradient != null) {
			if(gradient.equals("none")) {
				return null;
			}
			int[] gradientValues = parseGradient(gradient);
			return new GradientData(gradientValues[0], gradientValues[1], gradientValues[2]);
		}

		//Default
		return getDefaultGradient();
	}

	/** [color1, color2, style] */
	private int[] parseGradient(String gradient) {
		String color1, color2, style;
		color1 = color2 = style = null;

		String[] values = ParserHelper.parseValues(engine, gradient);

		if(values.length == 3) {
			color1 = values[0];
			color2 = values[1];
			style = values[2];
		} else if(values.length == 2) {
			color1 = values[0];
			String value = values[1];
			if(isGradientStyle(value)) {
				style = value;
			} else {
				color2 = value;
			}
		} else if(values.length == 1) {
			String value = values[0];
			if(isGradientStyle(value)) {
				style = value;
			} else {
				color1 = value;
			}
		}

		return parseGradient(color1, color2, style);
	}

	private int[] parseGradient(String sColor1, String sColor2, String sStyle) {
		int color1, color2, style;
		color1 = color2 = style = -1;

		color1 = getGradientColor(sColor1);
		color2 = 0; //Unused
		style = getGradientStyle(sStyle);

		return new int[]{ color1, color2, style };
	}

	private boolean isGradientStyle(String value) {
		return GRADIENT_VERTICAL.equals(value) || GRADIENT_HORIZONTAL.equals(value);
	}

	private int getGradientColor(String gradientColor) {
		if(gradientColor != null) {
			CSSValue cssValue;
			try {
				cssValue = engine.parsePropertyValue(gradientColor);
				return ConversionHelper.getIntColor(gradientColor, cssValue);
			} catch (IOException ex) {
				Activator.log.error(ex);
			}
		}

		//Default value
		return new GradientData().getGradientColor1();
	}

	private int getGradientStyle(String gradientStyle) {
		if(GRADIENT_VERTICAL.equals(gradientStyle)) {
			return GradientStyle.VERTICAL;
		} else if(GRADIENT_HORIZONTAL.equals(gradientStyle)) {
			return GradientStyle.HORIZONTAL;
		}

		//Default value
		return new GradientData().getGradientStyle();
	}

	private GradientData getDefaultGradient() {
		Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_Gradient().getDefaultValue();
		return (GradientData)defaultValue;
	}

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

	public int getCSSRoundedBendpointsRadius() {
		String cssValue = engine.retrieveCSSProperty(element, "roundedBendpointsRadius", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius().getDefaultValue();
			return (Integer)defaultValue;
		}
		return Integer.parseInt(cssValue);
	}

	public boolean getCSSElementIcon() {
		String cssValue = engine.retrieveCSSProperty(element, "elementIcon", "");
		if(cssValue == null) {
			return false;
		}
		return Boolean.parseBoolean(cssValue);
	}

	public boolean getCSSShadow() {
		String cssValue = engine.retrieveCSSProperty(element, "shadow", "");
		if(cssValue == null) {
			return false;
		}
		return Boolean.parseBoolean(cssValue);
	}

	public int getCSSQualifiedNameDepth() {
		String cssValue = engine.retrieveCSSProperty(element, "qualifiedNameDepth", "");
		if(cssValue == null) {
			return 1000;
		}

		if("full".equals(cssValue.toLowerCase())) {
			return 0;
		}

		if("none".equals(cssValue.toLowerCase())) {
			return 1000;
		}

		int value = Integer.parseInt(cssValue);
		return value > 0 ? -value : value;
	}

	public String getCSSStereotypeDisplay() {
		String cssValue = engine.retrieveCSSProperty(element, "stereotypeDisplay", "");
		if(cssValue == null) {
			return "Text";
		}

		return cssValue;
	}

	public String getCSSTextAlignment() {
		String cssValue = engine.retrieveCSSProperty(element, "textAlignment", "");
		if(cssValue == null) {
			return "Horizontal";
		}
		return cssValue;
	}

	public String getCSSDisplayPlace() {
		String cssValue = engine.retrieveCSSProperty(element, "displayPlace", "");
		if(cssValue == null) {
			return "Compartment";
		}
		return cssValue;
	}

}
