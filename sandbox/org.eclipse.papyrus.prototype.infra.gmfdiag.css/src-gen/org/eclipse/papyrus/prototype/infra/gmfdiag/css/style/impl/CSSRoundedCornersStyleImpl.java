package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSRoundedCornersStyleImpl implements CSSRoundedCornersStyle{
	
	private RoundedCornersStyle roundedCornersStyle;

	public CSSRoundedCornersStyleImpl(RoundedCornersStyle roundedCornersStyle){
		this.roundedCornersStyle = roundedCornersStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSRoundedBendpointsRadius(){
		return roundedCornersStyle.getRoundedBendpointsRadius();
	}
}
