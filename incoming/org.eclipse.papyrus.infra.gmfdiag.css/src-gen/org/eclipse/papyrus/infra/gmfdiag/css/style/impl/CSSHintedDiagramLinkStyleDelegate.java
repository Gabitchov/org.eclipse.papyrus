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

import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSHintedDiagramLinkStyle;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSValue;

@SuppressWarnings("restriction")
public class CSSHintedDiagramLinkStyleDelegate implements CSSHintedDiagramLinkStyle{
	
	private HintedDiagramLinkStyle hintedDiagramLinkStyle;

	private ExtendedCSSEngine engine;

	private Element element;

	public CSSHintedDiagramLinkStyleDelegate(HintedDiagramLinkStyle hintedDiagramLinkStyle, ExtendedCSSEngine engine){
		this.hintedDiagramLinkStyle = hintedDiagramLinkStyle;
 		this.engine = engine;
		this.element = engine.getElement(this.hintedDiagramLinkStyle);
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSHint(){
		CSSValue cssValue = engine.retrievePropertyValue(element, "hint");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getHintedDiagramLinkStyle_Hint().getDefaultValue(); 
			return (String)defaultValue;
		}
		return (String)engine.convert(cssValue, String.class, null);
	}
}
