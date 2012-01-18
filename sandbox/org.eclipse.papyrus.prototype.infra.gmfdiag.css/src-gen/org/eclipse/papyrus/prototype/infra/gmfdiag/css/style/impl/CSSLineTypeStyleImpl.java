package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSLineTypeStyleImpl implements CSSLineTypeStyle{
	
	private LineTypeStyle lineTypeStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSLineTypeStyleImpl(LineTypeStyle lineTypeStyle, CSSStylableElement element, CSSEngine engine){
		this.lineTypeStyle = lineTypeStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public LineType getCSSLineType(){
		String cssValue = engine.retrieveCSSProperty(element, "lineType", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getLineTypeStyle_LineType().getDefaultValue(); 
			return (LineType)defaultValue;
		}
		return LineType.get(cssValue);
	}
}
