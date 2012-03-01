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

import org.eclipse.gmf.runtime.notation.LineType;
import org.eclipse.gmf.runtime.notation.LineTypeStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSLineTypeStyle;
import org.w3c.dom.css.CSSValue;

public class CSSLineTypeStyleDelegate implements CSSLineTypeStyle {

	private LineTypeStyle lineTypeStyle;

	private ExtendedCSSEngine engine;

	public CSSLineTypeStyleDelegate(LineTypeStyle lineTypeStyle, ExtendedCSSEngine engine) {
		this.lineTypeStyle = lineTypeStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public LineType getCSSLineType() {
		CSSValue cssValue = engine.retrievePropertyValue(lineTypeStyle, "lineType");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getLineTypeStyle_LineType().getDefaultValue();
			return (LineType)defaultValue;
		}
		return LineType.get(cssValue.getCssText());
	}
}
