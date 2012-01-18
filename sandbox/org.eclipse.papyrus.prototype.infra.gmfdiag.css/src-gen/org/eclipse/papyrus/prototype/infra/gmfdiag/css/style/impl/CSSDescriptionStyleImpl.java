package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSDescriptionStyleImpl implements CSSDescriptionStyle{
	
	private DescriptionStyle descriptionStyle;

	public CSSDescriptionStyleImpl(DescriptionStyle descriptionStyle){
		this.descriptionStyle = descriptionStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.String getCSSDescription(){
		return descriptionStyle.getDescription();
	}
}
