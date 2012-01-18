package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSSingleValueStyleImpl implements CSSSingleValueStyle{
	
	private SingleValueStyle singleValueStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSSingleValueStyleImpl(SingleValueStyle singleValueStyle, CSSStylableElement element, CSSEngine engine){
		this.singleValueStyle = singleValueStyle;
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

	public java.lang.String getCSSRawValue(){
		String cssValue = engine.retrieveCSSProperty(element, "rawValue", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getSingleValueStyle_RawValue().getDefaultValue(); 
			return (String)defaultValue;
		}
		return cssValue;
	}
}
