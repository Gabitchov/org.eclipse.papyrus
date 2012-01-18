package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSDrawerStyleImpl implements CSSDrawerStyle{
	
	private DrawerStyle drawerStyle;

	public CSSDrawerStyleImpl(DrawerStyle drawerStyle){
		this.drawerStyle = drawerStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public boolean isCSSCollapsed(){
		return drawerStyle.isCollapsed();
	}
}
