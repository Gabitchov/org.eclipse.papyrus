package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSArrowStyleImpl implements CSSArrowStyle{
	
	private ArrowStyle arrowStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSArrowStyleImpl(ArrowStyle arrowStyle, CSSStylableElement element, CSSEngine engine){
		this.arrowStyle = arrowStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public ArrowType getCSSArrowSource(){
		String cssValue = engine.retrieveCSSProperty(element, "arrowSource", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getArrowStyle_ArrowSource().getDefaultValue(); 
			return (ArrowType)defaultValue;
		}
		return ArrowType.get(cssValue);
	}

	public ArrowType getCSSArrowTarget(){
		String cssValue = engine.retrieveCSSProperty(element, "arrowTarget", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getArrowStyle_ArrowTarget().getDefaultValue(); 
			return (ArrowType)defaultValue;
		}
		return ArrowType.get(cssValue);
	}
}
