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
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.GradientHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSShapeStyle;
import org.w3c.dom.css.CSSValue;

public class CSSShapeStyleDelegate implements CSSShapeStyle {

	private ShapeStyle shapeStyle;

	private ExtendedCSSEngine engine;

	public CSSShapeStyleDelegate(ShapeStyle shapeStyle, ExtendedCSSEngine engine) {
		this.shapeStyle = shapeStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSFontColor() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "fontColor");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_FontColor().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, "GMFColor", null);
	}

	public java.lang.String getCSSFontName() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "fontName");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_FontName().getDefaultValue();
			return (String)defaultValue;
		}
		return (String)engine.convert(cssValue, String.class, null);
	}

	public int getCSSFontHeight() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "fontHeight");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_FontHeight().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}

	public boolean isCSSBold() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "bold");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_Bold().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public boolean isCSSItalic() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "italic");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_Italic().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public boolean isCSSUnderline() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "underline");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_Underline().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public boolean isCSSStrikeThrough() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "strikeThrough");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public java.lang.String getCSSDescription() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "description");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getDescriptionStyle_Description().getDefaultValue();
			return (String)defaultValue;
		}
		return (String)engine.convert(cssValue, String.class, null);
	}

	public int getCSSFillColor() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "fillColor");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_FillColor().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, "GMFColor", null);
	}

	public int getCSSTransparency() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "transparency");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_Transparency().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}

	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient() {
		return GradientHelper.computeGradient(engine, shapeStyle);
	}

	public int getCSSLineColor() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "lineColor");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getLineStyle_LineColor().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, "GMFColor", null);
	}

	public int getCSSLineWidth() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "lineWidth");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getLineStyle_LineWidth().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}

	public int getCSSRoundedBendpointsRadius() {
		CSSValue cssValue = engine.retrievePropertyValue(shapeStyle, "roundedBendpointsRadius");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}
}
