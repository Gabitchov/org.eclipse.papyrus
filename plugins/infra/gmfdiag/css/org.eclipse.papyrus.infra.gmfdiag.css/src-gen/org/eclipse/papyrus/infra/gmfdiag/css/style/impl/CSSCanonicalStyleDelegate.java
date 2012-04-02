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

import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSCanonicalStyle;
import org.w3c.dom.css.CSSValue;

public class CSSCanonicalStyleDelegate implements CSSCanonicalStyle {

	private CanonicalStyle canonicalStyle;

	private ExtendedCSSEngine engine;

	public CSSCanonicalStyleDelegate(CanonicalStyle canonicalStyle, ExtendedCSSEngine engine) {
		this.canonicalStyle = canonicalStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public boolean isCSSCanonical() {
		CSSValue cssValue = engine.retrievePropertyValue(canonicalStyle, "canonical");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getCanonicalStyle_Canonical().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}
}
