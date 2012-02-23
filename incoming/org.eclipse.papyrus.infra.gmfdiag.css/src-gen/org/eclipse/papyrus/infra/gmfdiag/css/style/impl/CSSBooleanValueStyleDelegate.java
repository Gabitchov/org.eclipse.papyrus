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

import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSBooleanValueStyle;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSValue;

@SuppressWarnings("restriction")
public class CSSBooleanValueStyleDelegate implements CSSBooleanValueStyle{
	
	private BooleanValueStyle booleanValueStyle;

	private ExtendedCSSEngine engine;

	private Element element;

	public CSSBooleanValueStyleDelegate(BooleanValueStyle booleanValueStyle, ExtendedCSSEngine engine){
		this.booleanValueStyle = booleanValueStyle;
 		this.engine = engine;
		this.element = engine.getElement(this.booleanValueStyle);
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		CSSValue cssValue = engine.retrievePropertyValue(element, "name");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getNamedStyle_Name().getDefaultValue(); 
			return (String)defaultValue;
		}
		return (String)engine.convert(cssValue, String.class, null);
	}

	public boolean isCSSBooleanValue(){
		CSSValue cssValue = engine.retrievePropertyValue(element, "booleanValue");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getBooleanValueStyle_BooleanValue().getDefaultValue(); 
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}
}
