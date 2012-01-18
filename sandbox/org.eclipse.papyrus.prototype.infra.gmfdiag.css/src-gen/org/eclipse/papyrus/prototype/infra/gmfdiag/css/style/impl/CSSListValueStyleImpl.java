package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSListValueStyleImpl implements CSSListValueStyle{
	
	private ListValueStyle listValueStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSListValueStyleImpl(ListValueStyle listValueStyle, CSSStylableElement element, CSSEngine engine){
		this.listValueStyle = listValueStyle;
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

	public EList getCSSRawValuesList(){
		String cssValue = engine.retrieveCSSProperty(element, "rawValuesList", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getListValueStyle_RawValuesList().getDefaultValue(); 
			return (EList)defaultValue;
		}
		return null;
	}
}
