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
public class CSSTitleStyleImpl implements CSSTitleStyle{
	
	private TitleStyle titleStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSTitleStyleImpl(TitleStyle titleStyle, CSSStylableElement element, CSSEngine engine){
		this.titleStyle = titleStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public boolean isCSSShowTitle(){
		String cssValue = engine.retrieveCSSProperty(element, "showTitle", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getTitleStyle_ShowTitle().getDefaultValue(); 
			return (Boolean)defaultValue;
		}
		return (Boolean)Boolean.parseBoolean(cssValue);
	}
}
