package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSDoubleValueStyleImpl implements CSSDoubleValueStyle{
	
	private DoubleValueStyle doubleValueStyle;

	public CSSDoubleValueStyleImpl(DoubleValueStyle doubleValueStyle){
		this.doubleValueStyle = doubleValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return doubleValueStyle.getName();
	}

	public double getCSSDoubleValue(){
		return doubleValueStyle.getDoubleValue();
	}
}
