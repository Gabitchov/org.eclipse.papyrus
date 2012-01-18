package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSFilteringStyleImpl implements CSSFilteringStyle{
	
	private FilteringStyle filteringStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSFilteringStyleImpl(FilteringStyle filteringStyle, CSSStylableElement element, CSSEngine engine){
		this.filteringStyle = filteringStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public Filtering getCSSFiltering(){
		String cssValue = engine.retrieveCSSProperty(element, "filtering", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getFilteringStyle_Filtering().getDefaultValue(); 
			return (Filtering)defaultValue;
		}
		return Filtering.get(cssValue);
	}

	public java.util.List getCSSFilteringKeys(){
		String cssValue = engine.retrieveCSSProperty(element, "filteringKeys", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getFilteringStyle_FilteringKeys().getDefaultValue(); 
			return (java.util.List)defaultValue;
		}
		return null;
	}
}
