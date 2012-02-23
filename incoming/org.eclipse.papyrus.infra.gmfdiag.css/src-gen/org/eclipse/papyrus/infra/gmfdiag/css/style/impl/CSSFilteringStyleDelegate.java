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

import org.eclipse.gmf.runtime.notation.Filtering;
import org.eclipse.gmf.runtime.notation.FilteringStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSFilteringStyle;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSValue;

@SuppressWarnings("restriction")
public class CSSFilteringStyleDelegate implements CSSFilteringStyle{
	
	private FilteringStyle filteringStyle;

	private ExtendedCSSEngine engine;

	private Element element;

	public CSSFilteringStyleDelegate(FilteringStyle filteringStyle, ExtendedCSSEngine engine){
		this.filteringStyle = filteringStyle;
 		this.engine = engine;
		this.element = engine.getElement(this.filteringStyle);
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public Filtering getCSSFiltering(){
		CSSValue cssValue = engine.retrievePropertyValue(element, "filtering");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFilteringStyle_Filtering().getDefaultValue(); 
			return (Filtering)defaultValue;
		}
		return Filtering.get(cssValue.getCssText());
	}

	public java.util.List getCSSFilteringKeys(){
		CSSValue cssValue = engine.retrievePropertyValue(element, "filteringKeys");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getFilteringStyle_FilteringKeys().getDefaultValue(); 
			return (java.util.List)defaultValue;
		}
		return null;
	}
}
