package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSBooleanValueStyleImpl implements CSSBooleanValueStyle{
	
	private BooleanValueStyle booleanValueStyle;

	public CSSBooleanValueStyleImpl(BooleanValueStyle booleanValueStyle){
		this.booleanValueStyle = booleanValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return booleanValueStyle.getName();
	}

	public boolean isCSSBooleanValue(){
		return booleanValueStyle.isBooleanValue();
	}
}
