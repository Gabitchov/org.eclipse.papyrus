package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSBooleanListValueStyleImpl implements CSSBooleanListValueStyle{
	
	private BooleanListValueStyle booleanListValueStyle;

	public CSSBooleanListValueStyleImpl(BooleanListValueStyle booleanListValueStyle){
		this.booleanListValueStyle = booleanListValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return booleanListValueStyle.getName();
	}

	public EList getCSSBooleanListValue(){
		return booleanListValueStyle.getBooleanListValue();
	}
}
