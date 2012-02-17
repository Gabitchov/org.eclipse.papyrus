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

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSStringListValueStyleImpl implements CSSStringListValueStyle{
	
	private StringListValueStyle stringListValueStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSStringListValueStyleImpl(StringListValueStyle stringListValueStyle, CSSStylableElement element, CSSEngine engine){
		this.stringListValueStyle = stringListValueStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		String cssValue = engine.retrieveCSSProperty(element, "name", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getNamedStyle_Name().getDefaultValue(); 
			return (String)defaultValue;
		}
		return cssValue;
	}

	public EList getCSSStringListValue(){
		String cssValue = engine.retrieveCSSProperty(element, "stringListValue", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getStringListValueStyle_StringListValue().getDefaultValue(); 
			return (EList)defaultValue;
		}
		return null;
	}
}