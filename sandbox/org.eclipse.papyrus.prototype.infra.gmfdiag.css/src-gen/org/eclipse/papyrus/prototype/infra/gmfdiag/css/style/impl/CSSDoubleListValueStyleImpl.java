package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSDoubleListValueStyleImpl implements CSSDoubleListValueStyle{
	
	private DoubleListValueStyle doubleListValueStyle;

	public CSSDoubleListValueStyleImpl(DoubleListValueStyle doubleListValueStyle){
		this.doubleListValueStyle = doubleListValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return doubleListValueStyle.getName();
	}

	public EList getCSSDoubleListValue(){
		return doubleListValueStyle.getDoubleListValue();
	}
}
