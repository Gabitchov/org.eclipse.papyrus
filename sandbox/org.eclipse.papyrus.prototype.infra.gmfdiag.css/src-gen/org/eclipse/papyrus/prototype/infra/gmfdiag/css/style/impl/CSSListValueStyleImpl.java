package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSListValueStyleImpl implements CSSListValueStyle{
	
	private ListValueStyle listValueStyle;

	public CSSListValueStyleImpl(ListValueStyle listValueStyle){
		this.listValueStyle = listValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return listValueStyle.getName();
	}

	public EList getCSSRawValuesList(){
		return listValueStyle.getRawValuesList();
	}
}
