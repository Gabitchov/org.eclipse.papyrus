package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSDescriptionStyleImpl implements CSSDescriptionStyle{
	
	private DescriptionStyle descriptionStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSDescriptionStyleImpl(DescriptionStyle descriptionStyle, CSSStylableElement element, CSSEngine engine){
		this.descriptionStyle = descriptionStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSDescription(){
		String cssValue = engine.retrieveCSSProperty(element, "description", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getDescriptionStyle_Description().getDefaultValue(); 
			return (String)defaultValue;
		}
		return cssValue;
	}
}
