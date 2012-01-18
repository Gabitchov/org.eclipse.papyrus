package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSImageStyleImpl implements CSSImageStyle{
	
	private ImageStyle imageStyle;

	public CSSImageStyleImpl(ImageStyle imageStyle){
		this.imageStyle = imageStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.Boolean getCSSAntiAlias(){
		return imageStyle.getAntiAlias();
	}

	public java.lang.Boolean getCSSMaintainAspectRatio(){
		return imageStyle.getMaintainAspectRatio();
	}
}
