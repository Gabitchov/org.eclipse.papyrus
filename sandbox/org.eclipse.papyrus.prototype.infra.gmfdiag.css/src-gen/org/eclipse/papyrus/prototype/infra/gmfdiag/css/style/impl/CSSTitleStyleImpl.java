package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSTitleStyleImpl implements CSSTitleStyle{
	
	private TitleStyle titleStyle;

	public CSSTitleStyleImpl(TitleStyle titleStyle){
		this.titleStyle = titleStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public boolean isCSSShowTitle(){
		return titleStyle.isShowTitle();
	}
}
