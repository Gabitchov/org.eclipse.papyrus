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
public class CSSPageStyleImpl implements CSSPageStyle{
	
	private PageStyle pageStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSPageStyleImpl(PageStyle pageStyle, CSSStylableElement element, CSSEngine engine){
		this.pageStyle = pageStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSPageX(){
		String cssValue = engine.retrieveCSSProperty(element, "pageX", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageX().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public int getCSSPageY(){
		String cssValue = engine.retrieveCSSProperty(element, "pageY", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageY().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public int getCSSPageWidth(){
		String cssValue = engine.retrieveCSSProperty(element, "pageWidth", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageWidth().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public int getCSSPageHeight(){
		String cssValue = engine.retrieveCSSProperty(element, "pageHeight", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getPageStyle_PageHeight().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}
}
