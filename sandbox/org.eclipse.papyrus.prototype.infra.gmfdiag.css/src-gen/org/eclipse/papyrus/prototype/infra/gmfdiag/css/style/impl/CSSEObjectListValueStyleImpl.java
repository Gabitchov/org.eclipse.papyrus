package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSEObjectListValueStyleImpl implements CSSEObjectListValueStyle{
	
	private EObjectListValueStyle eObjectListValueStyle;

	public CSSEObjectListValueStyleImpl(EObjectListValueStyle eObjectListValueStyle){
		this.eObjectListValueStyle = eObjectListValueStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return eObjectListValueStyle.getName();
	}
}
