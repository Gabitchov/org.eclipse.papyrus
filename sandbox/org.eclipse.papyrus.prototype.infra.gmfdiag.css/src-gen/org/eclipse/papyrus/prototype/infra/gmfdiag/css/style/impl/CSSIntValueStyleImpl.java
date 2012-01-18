package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSIntValueStyleImpl implements CSSIntValueStyle{
	
	private IntValueStyle intValueStyle;

	public CSSIntValueStyleImpl(IntValueStyle intValueStyle){
		this.intValueStyle = intValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return intValueStyle.getName();
	}

	public int getCSSIntValue(){
		return intValueStyle.getIntValue();
	}
}
