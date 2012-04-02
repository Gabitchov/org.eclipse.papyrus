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
package org.eclipse.papyrus.infra.gmfdiag.css.helper;

import java.io.IOException;

import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.gmfdiag.css.converters.ColorToGMFConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.w3c.dom.css.CSSValue;


public class GradientHelper {

	public static final String GRADIENT_VERTICAL = "vertical";

	public static final String GRADIENT_HORIZONTAL = "horizontal";

	//Type 1 :
	//gradientColor:#ABCDEF;
	//gradientStyle:vertical;

	//Type 2 :
	//(gradient:#FEDCBA #ABCDEF horizontal;) //Currently not supported, as diagrams usually seek for #fillColor()
	//gradient:#ABCDEF horizontal;
	//gradient:#ABCDEF
	//gradient:horizontal

	//TODO: The Engine should provide a method to handle complex composite properties.
	//The base CSS Engine provides such a feature. However, it is not powerful enough.
	public static GradientData computeGradient(ExtendedCSSEngine engine, Object node) {
		//Type 1
		CSSValue gradientColor = engine.retrievePropertyValue(node, "gradientColor");
		CSSValue gradientStyle = engine.retrievePropertyValue(node, "gradientStyle");

		if(gradientColor != null || gradientStyle != null) {
			int color1 = (Integer)engine.convert(gradientColor, ColorToGMFConverter.GMFColor, null);
			int color2 = 0; //Unused by Papyrus diagrams
			int style = getGradientStyle(gradientStyle.getCssText());
			GradientData data = new GradientData(color1, color2, style);
			return data;
		}

		//Type 2
		CSSValue gradient = engine.retrievePropertyValue(node, "gradient");

		if(gradient != null) {
			String gradientString = gradient.getCssText();

			if(StringHelper.equals(gradientString, "none")) {
				return null;
			}

			int[] gradientValues = parseGradient(engine, gradientString);
			return new GradientData(gradientValues[0], gradientValues[1], gradientValues[2]);
		}

		//Default
		return (GradientData)NotationPackage.eINSTANCE.getFillStyle_Gradient().getDefaultValue();
	}

	/** [color1, color2, style] */
	private static int[] parseGradient(ExtendedCSSEngine engine, String gradient) {
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

		return parseGradient(engine, color1, color2, style);
	}

	private static int[] parseGradient(ExtendedCSSEngine engine, String sColor1, String sColor2, String sStyle) {
		int color1, color2, style;
		color1 = color2 = style = -1;

		CSSValue cssColor1;
		try {
			cssColor1 = engine.parsePropertyValue(sColor1);
			color1 = (Integer)engine.convert(cssColor1, ColorToGMFConverter.GMFColor, null);
			color2 = 0; //Unused
			style = getGradientStyle(sStyle);
		} catch (IOException ex) {
			engine.handleExceptions(ex);
		}


		return new int[]{ color1, color2, style };
	}

	private static boolean isGradientStyle(String value) {
		return StringHelper.equals(GRADIENT_VERTICAL, value) || StringHelper.equals(GRADIENT_HORIZONTAL, value);
	}

	private static int getGradientStyle(String gradientStyle) {
		if(StringHelper.equals(GRADIENT_VERTICAL, gradientStyle)) {
			return GradientStyle.VERTICAL;
		} else if(StringHelper.equals(GRADIENT_HORIZONTAL, gradientStyle)) {
			return GradientStyle.HORIZONTAL;
		}

		//Default value
		return new GradientData().getGradientStyle();
	}
}
