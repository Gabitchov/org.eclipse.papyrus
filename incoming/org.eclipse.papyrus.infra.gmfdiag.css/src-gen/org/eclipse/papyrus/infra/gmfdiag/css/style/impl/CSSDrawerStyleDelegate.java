/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.style.impl;

import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSDrawerStyle;
import org.w3c.dom.css.CSSValue;

public class CSSDrawerStyleDelegate implements CSSDrawerStyle {

	private DrawerStyle drawerStyle;

	private ExtendedCSSEngine engine;

	public CSSDrawerStyleDelegate(DrawerStyle drawerStyle, ExtendedCSSEngine engine) {
		this.drawerStyle = drawerStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public boolean isCSSCollapsed() {
		CSSValue cssValue = engine.retrievePropertyValue(drawerStyle, "collapsed");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getDrawerStyle_Collapsed().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}
}
