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
package org.eclipse.papyrus.infra.gmfdiag.css.configuration.handler;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.gmfdiag.css.CssFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.Expression;
import org.eclipse.papyrus.infra.gmfdiag.css.HexColor;
import org.eclipse.papyrus.infra.gmfdiag.css.Name;
import org.eclipse.papyrus.infra.gmfdiag.css.Number;
import org.eclipse.papyrus.infra.gmfdiag.css.StringValue;
import org.eclipse.papyrus.infra.gmfdiag.css.Subterm;
import org.eclipse.papyrus.infra.gmfdiag.css.Term;
import org.eclipse.papyrus.infra.gmfdiag.css.UNARY;
import org.eclipse.papyrus.infra.gmfdiag.css.UnaryOperator;
import org.eclipse.swt.graphics.Color;


public class GMFToCSSConverter {

	public static final GMFToCSSConverter instance = new GMFToCSSConverter();

	private GMFToCSSConverter() {

	}

	public Expression convert(Color color) {
		HexColor hexColor = getColor(color);
		return getExpression(hexColor);
	}

	private HexColor getColor(Color color) {
		HexColor hexColor = CssFactory.eINSTANCE.createHexColor();

		String hexString = twoDigitsHexString(color.getRed()) + twoDigitsHexString(color.getGreen()) + twoDigitsHexString(color.getBlue());
		hexColor.setValue(hexString.toUpperCase());
		return hexColor;
	}

	private HexColor getColor(int color) {
		Color swtColor = FigureUtilities.integerToColor(color);
		HexColor result = getColor(swtColor);
		swtColor.dispose();
		return result;
	}

	private String twoDigitsHexString(int color) {
		String hexString = Integer.toHexString(color);
		if(hexString.length() < 2) {
			hexString = "0" + hexString;
		}
		return hexString;
	}

	public Expression convert(GradientData gradient) {
		if(gradient == null) {
			Name noGradient = CssFactory.eINSTANCE.createName();
			noGradient.setValue("none");
			return getExpression(noGradient);
		}

		HexColor gradientColor = getColor(gradient.getGradientColor1());

		Name gradientStyle = CssFactory.eINSTANCE.createName();
		int style = gradient.getGradientStyle();

		if(style == GradientStyle.HORIZONTAL) {
			gradientStyle.setValue("horizontal");
		} else {
			gradientStyle.setValue("vertical");
		}

		return getExpression(gradientColor, gradientStyle);
	}

	public Expression convert(String string) {
		StringValue stringValue = CssFactory.eINSTANCE.createStringValue();
		stringValue.setValue(string);
		return getExpression(stringValue);
	}

	public Expression convert(Integer intValue) {
		Number numberValue = CssFactory.eINSTANCE.createNumber();
		numberValue.setValue(Integer.toString(Math.abs(intValue)));
		if(intValue < 0) {
			UnaryOperator operator = CssFactory.eINSTANCE.createUnaryOperator();
			operator.setOperator(UNARY.NEG);
			numberValue.setOp(operator);
		}

		return getExpression(numberValue);
	}

	public Expression convert(Enumerator enumerated) {
		Name literalValue = CssFactory.eINSTANCE.createName();

		literalValue.setValue(enumerated.getName());

		return getExpression(literalValue);
	}

	private Expression getExpression(Term... values) {
		if(values.length == 0) {
			throw new IllegalArgumentException("An expression must contain at least one value");
		}

		Expression result = CssFactory.eINSTANCE.createExpression();
		result.setTerms(values[0]);

		for(int i = 1; i < values.length; i++) {
			Subterm subterm = CssFactory.eINSTANCE.createSubterm();
			subterm.setTerm(values[i]);
			result.getSubterms().add(subterm);
		}

		return result;
	}

	public Expression convert(boolean booleanValue) {
		Name nameValue = CssFactory.eINSTANCE.createName();
		nameValue.setValue(booleanValue ? "true" : "false");
		return getExpression(nameValue);
	}
}
