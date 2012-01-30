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
public class CSSSortingStyleImpl implements CSSSortingStyle{
	
	private SortingStyle sortingStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSSortingStyleImpl(SortingStyle sortingStyle, CSSStylableElement element, CSSEngine engine){
		this.sortingStyle = sortingStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public Sorting getCSSSorting(){
		String cssValue = engine.retrieveCSSProperty(element, "sorting", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getSortingStyle_Sorting().getDefaultValue(); 
			return (Sorting)defaultValue;
		}
		return Sorting.get(cssValue);
	}

	public java.util.Map getCSSSortingKeys(){
		String cssValue = engine.retrieveCSSProperty(element, "sortingKeys", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getSortingStyle_SortingKeys().getDefaultValue(); 
			return (java.util.Map)defaultValue;
		}
		return null;
	}
}
