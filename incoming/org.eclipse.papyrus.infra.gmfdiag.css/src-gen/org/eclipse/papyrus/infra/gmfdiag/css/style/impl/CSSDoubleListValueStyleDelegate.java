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

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.DoubleListValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSDoubleListValueStyle;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSValue;

@SuppressWarnings("restriction")
public class CSSDoubleListValueStyleDelegate implements CSSDoubleListValueStyle{
	
	private DoubleListValueStyle doubleListValueStyle;

	private ExtendedCSSEngine engine;

	private Element element;

	public CSSDoubleListValueStyleDelegate(DoubleListValueStyle doubleListValueStyle, ExtendedCSSEngine engine){
		this.doubleListValueStyle = doubleListValueStyle;
 		this.engine = engine;
		this.element = engine.getElement(this.doubleListValueStyle);
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

	public EList getCSSDoubleListValue(){
		CSSValue cssValue = engine.retrievePropertyValue(element, "doubleListValue");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getDoubleListValueStyle_DoubleListValue().getDefaultValue(); 
			return (EList)defaultValue;
		}
		return null;
	}
}
