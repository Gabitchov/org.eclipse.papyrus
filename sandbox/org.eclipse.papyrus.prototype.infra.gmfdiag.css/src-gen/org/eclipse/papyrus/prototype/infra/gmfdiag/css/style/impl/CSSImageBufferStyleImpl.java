package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSImageBufferStyleImpl implements CSSImageBufferStyle{
	
	private ImageBufferStyle imageBufferStyle;

	public CSSImageBufferStyleImpl(ImageBufferStyle imageBufferStyle){
		this.imageBufferStyle = imageBufferStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public java.lang.Boolean getCSSAntiAlias(){
		return imageBufferStyle.getAntiAlias();
	}

	public java.lang.Boolean getCSSMaintainAspectRatio(){
		return imageBufferStyle.getMaintainAspectRatio();
	}
}
