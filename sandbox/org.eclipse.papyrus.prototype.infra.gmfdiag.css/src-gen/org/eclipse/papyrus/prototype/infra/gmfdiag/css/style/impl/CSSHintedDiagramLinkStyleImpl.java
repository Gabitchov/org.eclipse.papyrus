package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSHintedDiagramLinkStyleImpl implements CSSHintedDiagramLinkStyle{
	
	private HintedDiagramLinkStyle hintedDiagramLinkStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSHintedDiagramLinkStyleImpl(HintedDiagramLinkStyle hintedDiagramLinkStyle, CSSStylableElement element, CSSEngine engine){
		this.hintedDiagramLinkStyle = hintedDiagramLinkStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSHint(){
		String cssValue = engine.retrieveCSSProperty(element, "hint", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getHintedDiagramLinkStyle_Hint().getDefaultValue(); 
			return (String)defaultValue;
		}
		return cssValue;
	}
}
