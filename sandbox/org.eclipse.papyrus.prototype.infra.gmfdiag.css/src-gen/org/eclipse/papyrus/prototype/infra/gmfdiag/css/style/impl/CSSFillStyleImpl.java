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
public class CSSFillStyleImpl implements CSSFillStyle{
	
	private FillStyle fillStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSFillStyleImpl(FillStyle fillStyle, CSSStylableElement element, CSSEngine engine){
		this.fillStyle = fillStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSFillColor(){
		String cssValue = engine.retrieveCSSProperty(element, "fillColor", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_FillColor().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public int getCSSTransparency(){
		String cssValue = engine.retrieveCSSProperty(element, "transparency", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_Transparency().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient(){
		String cssValue = engine.retrieveCSSProperty(element, "gradient", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getFillStyle_Gradient().getDefaultValue(); 
			return (org.eclipse.gmf.runtime.notation.datatype.GradientData)defaultValue;
		}
		return null;
	}
}
