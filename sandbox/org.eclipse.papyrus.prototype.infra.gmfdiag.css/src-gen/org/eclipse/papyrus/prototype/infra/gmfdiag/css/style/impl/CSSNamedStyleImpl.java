package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSNamedStyleImpl implements CSSNamedStyle{
	
	private NamedStyle namedStyle;

	public CSSNamedStyleImpl(NamedStyle namedStyle){
		this.namedStyle = namedStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return namedStyle.getName();
	}
}
