package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSSingleValueStyleImpl implements CSSSingleValueStyle{
	
	private SingleValueStyle singleValueStyle;

	public CSSSingleValueStyleImpl(SingleValueStyle singleValueStyle){
		this.singleValueStyle = singleValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return singleValueStyle.getName();
	}

	public java.lang.String getCSSRawValue(){
		return singleValueStyle.getRawValue();
	}
}
