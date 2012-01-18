package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSLineTypeStyleImpl implements CSSLineTypeStyle{
	
	private LineTypeStyle lineTypeStyle;

	public CSSLineTypeStyleImpl(LineTypeStyle lineTypeStyle){
		this.lineTypeStyle = lineTypeStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public LineType getCSSLineType(){
		return lineTypeStyle.getLineType();
	}
}
