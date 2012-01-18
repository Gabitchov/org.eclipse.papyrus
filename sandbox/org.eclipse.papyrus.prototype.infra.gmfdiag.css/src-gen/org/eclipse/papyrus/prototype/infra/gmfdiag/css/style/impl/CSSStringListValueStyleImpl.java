package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSStringListValueStyleImpl implements CSSStringListValueStyle{
	
	private StringListValueStyle stringListValueStyle;

	public CSSStringListValueStyleImpl(StringListValueStyle stringListValueStyle){
		this.stringListValueStyle = stringListValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return stringListValueStyle.getName();
	}

	public EList getCSSStringListValue(){
		return stringListValueStyle.getStringListValue();
	}
}
