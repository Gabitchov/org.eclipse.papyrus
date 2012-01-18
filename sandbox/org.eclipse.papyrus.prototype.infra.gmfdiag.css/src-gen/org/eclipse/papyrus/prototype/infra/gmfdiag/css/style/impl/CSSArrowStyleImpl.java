package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSArrowStyleImpl implements CSSArrowStyle{
	
	private ArrowStyle arrowStyle;

	public CSSArrowStyleImpl(ArrowStyle arrowStyle){
		this.arrowStyle = arrowStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public ArrowType getCSSArrowSource(){
		return arrowStyle.getArrowSource();
	}

	public ArrowType getCSSArrowTarget(){
		return arrowStyle.getArrowTarget();
	}
}
