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
public class CSSTextStyleImpl implements CSSTextStyle{
	
	private TextStyle textStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSTextStyleImpl(TextStyle textStyle, CSSStylableElement element, CSSEngine engine){
		this.textStyle = textStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public TextAlignment getCSSTextAlignment(){
		String cssValue = engine.retrieveCSSProperty(element, "textAlignment", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getTextStyle_TextAlignment().getDefaultValue(); 
			return (TextAlignment)defaultValue;
		}
		return TextAlignment.get(cssValue);
	}
}
