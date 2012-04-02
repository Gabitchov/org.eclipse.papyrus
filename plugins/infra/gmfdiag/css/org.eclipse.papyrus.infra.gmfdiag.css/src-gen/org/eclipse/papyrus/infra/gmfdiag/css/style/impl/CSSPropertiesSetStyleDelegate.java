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
import org.eclipse.gmf.runtime.notation.PropertiesSetStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSPropertiesSetStyle;
import org.w3c.dom.css.CSSValue;

public class CSSPropertiesSetStyleDelegate implements CSSPropertiesSetStyle {

	private PropertiesSetStyle propertiesSetStyle;

	private ExtendedCSSEngine engine;

	public CSSPropertiesSetStyleDelegate(PropertiesSetStyle propertiesSetStyle, ExtendedCSSEngine engine) {
		this.propertiesSetStyle = propertiesSetStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName() {
		CSSValue cssValue = engine.retrievePropertyValue(propertiesSetStyle, "name");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getNamedStyle_Name().getDefaultValue();
			return (String)defaultValue;
		}
		return (String)engine.convert(cssValue, String.class, null);
	}
}
