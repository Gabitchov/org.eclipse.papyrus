package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSTextStyleImpl implements CSSTextStyle{
	
	private TextStyle textStyle;

	public CSSTextStyleImpl(TextStyle textStyle){
		this.textStyle = textStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public TextAlignment getCSSTextAlignment(){
		return textStyle.getTextAlignment();
	}
}
