package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSLineStyleImpl implements CSSLineStyle{
	
	private LineStyle lineStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSLineStyleImpl(LineStyle lineStyle, CSSStylableElement element, CSSEngine engine){
		this.lineStyle = lineStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSLineColor(){
		String cssValue = engine.retrieveCSSProperty(element, "lineColor", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getLineStyle_LineColor().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public int getCSSLineWidth(){
		String cssValue = engine.retrieveCSSProperty(element, "lineWidth", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getLineStyle_LineWidth().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}
}
