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
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSTitleStyle;
import org.w3c.dom.css.CSSValue;

public class CSSTitleStyleDelegate implements CSSTitleStyle {

	private TitleStyle titleStyle;

	private ExtendedCSSEngine engine;

	public CSSTitleStyleDelegate(TitleStyle titleStyle, ExtendedCSSEngine engine) {
		this.titleStyle = titleStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public boolean isCSSShowTitle() {
		CSSValue cssValue = engine.retrievePropertyValue(titleStyle, "showTitle");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getTitleStyle_ShowTitle().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}
}
