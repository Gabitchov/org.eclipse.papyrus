package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSDrawerStyleImpl implements CSSDrawerStyle{
	
	private DrawerStyle drawerStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSDrawerStyleImpl(DrawerStyle drawerStyle, CSSStylableElement element, CSSEngine engine){
		this.drawerStyle = drawerStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public boolean isCSSCollapsed(){
		String cssValue = engine.retrieveCSSProperty(element, "collapsed", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getDrawerStyle_Collapsed().getDefaultValue(); 
			return (Boolean)defaultValue;
		}
		return (Boolean)Boolean.parseBoolean(cssValue);
	}
}
