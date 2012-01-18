package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSFillStyleImpl implements CSSFillStyle{
	
	private FillStyle fillStyle;

	public CSSFillStyleImpl(FillStyle fillStyle){
		this.fillStyle = fillStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSFillColor(){
		return fillStyle.getFillColor();
	}

	public int getCSSTransparency(){
		return fillStyle.getTransparency();
	}

	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient(){
		return fillStyle.getGradient();
	}
}
