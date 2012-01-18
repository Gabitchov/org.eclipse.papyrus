package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSPageStyleImpl implements CSSPageStyle{
	
	private PageStyle pageStyle;

	public CSSPageStyleImpl(PageStyle pageStyle){
		this.pageStyle = pageStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSPageX(){
		return pageStyle.getPageX();
	}

	public int getCSSPageY(){
		return pageStyle.getPageY();
	}

	public int getCSSPageWidth(){
		return pageStyle.getPageWidth();
	}

	public int getCSSPageHeight(){
		return pageStyle.getPageHeight();
	}
}
