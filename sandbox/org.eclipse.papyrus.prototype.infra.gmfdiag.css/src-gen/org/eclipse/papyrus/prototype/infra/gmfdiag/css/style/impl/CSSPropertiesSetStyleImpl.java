package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSPropertiesSetStyleImpl implements CSSPropertiesSetStyle{
	
	private PropertiesSetStyle propertiesSetStyle;

	public CSSPropertiesSetStyleImpl(PropertiesSetStyle propertiesSetStyle){
		this.propertiesSetStyle = propertiesSetStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSName(){
		return propertiesSetStyle.getName();
	}
}
