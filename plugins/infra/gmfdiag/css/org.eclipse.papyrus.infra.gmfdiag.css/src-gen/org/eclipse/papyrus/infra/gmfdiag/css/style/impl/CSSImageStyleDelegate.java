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

import org.eclipse.gmf.runtime.notation.ImageStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSImageStyle;
import org.w3c.dom.css.CSSValue;

public class CSSImageStyleDelegate implements CSSImageStyle {

	private ImageStyle imageStyle;

	private ExtendedCSSEngine engine;

	public CSSImageStyleDelegate(ImageStyle imageStyle, ExtendedCSSEngine engine) {
		this.imageStyle = imageStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.Boolean getCSSAntiAlias() {
		CSSValue cssValue = engine.retrievePropertyValue(imageStyle, "antiAlias");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getImageStyle_AntiAlias().getDefaultValue();
			return (java.lang.Boolean)defaultValue;
		}
		return null;
	}

	public java.lang.Boolean getCSSMaintainAspectRatio() {
		CSSValue cssValue = engine.retrievePropertyValue(imageStyle, "maintainAspectRatio");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getImageStyle_MaintainAspectRatio().getDefaultValue();
			return (java.lang.Boolean)defaultValue;
		}
		return null;
	}
}
