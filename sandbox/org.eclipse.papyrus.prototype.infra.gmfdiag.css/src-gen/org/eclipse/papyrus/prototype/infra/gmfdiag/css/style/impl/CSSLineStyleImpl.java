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
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.converters.ColorToGMFConverter;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.CSSLineStyle;
import org.w3c.dom.css.CSSValue;

@SuppressWarnings("restriction")
public class CSSLineStyleImpl implements CSSLineStyle {

	private LineStyle lineStyle;

	private ExtendedCSSEngine engine;

	private CSSStylableElement element;

	public CSSLineStyleImpl(LineStyle lineStyle, CSSStylableElement element, ExtendedCSSEngine engine) {
		this.lineStyle = lineStyle;
		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSLineColor() {
		CSSValue value = engine.retrievePropertyValue(element, "lineColor");

		try {
			return (Integer)engine.convert(value, ColorToGMFConverter.GMFColor, null);
		} catch (Exception ex) {
			Activator.log.error(ex);
		}

		return (Integer)NotationPackage.eINSTANCE.getLineStyle_LineColor().getDefaultValue();
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
