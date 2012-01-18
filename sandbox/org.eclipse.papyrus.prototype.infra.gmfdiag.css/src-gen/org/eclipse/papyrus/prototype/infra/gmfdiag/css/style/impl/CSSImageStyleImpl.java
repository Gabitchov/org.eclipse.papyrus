package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSImageStyleImpl implements CSSImageStyle{
	
	private ImageStyle imageStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSImageStyleImpl(ImageStyle imageStyle, CSSStylableElement element, CSSEngine engine){
		this.imageStyle = imageStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.Boolean getCSSAntiAlias(){
		String cssValue = engine.retrieveCSSProperty(element, "antiAlias", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getImageStyle_AntiAlias().getDefaultValue(); 
			return (java.lang.Boolean)defaultValue;
		}
		return null;
	}

	public java.lang.Boolean getCSSMaintainAspectRatio(){
		String cssValue = engine.retrieveCSSProperty(element, "maintainAspectRatio", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getImageStyle_MaintainAspectRatio().getDefaultValue(); 
			return (java.lang.Boolean)defaultValue;
		}
		return null;
	}
}
