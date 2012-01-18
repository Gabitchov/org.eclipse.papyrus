package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSLineStyleImpl implements CSSLineStyle{
	
	private LineStyle lineStyle;

	public CSSLineStyleImpl(LineStyle lineStyle){
		this.lineStyle = lineStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSLineColor(){
		return lineStyle.getLineColor();
	}

	public int getCSSLineWidth(){
		return lineStyle.getLineWidth();
	}
}
