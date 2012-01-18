package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSStringValueStyleImpl implements CSSStringValueStyle{
	
	private StringValueStyle stringValueStyle;

	public CSSStringValueStyleImpl(StringValueStyle stringValueStyle){
		this.stringValueStyle = stringValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return stringValueStyle.getName();
	}

	public java.lang.String getCSSStringValue(){
		return stringValueStyle.getStringValue();
	}
}
