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
package org.eclipse.papyrus.infra.gmfdiag.css;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DrawerStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSDrawerStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSDrawerStyleDelegate;

public class CSSDrawerStyleImpl extends DrawerStyleImpl implements CSSDrawerStyle {

	protected ExtendedCSSEngine engine;

	private CSSDrawerStyle drawerStyle;

	protected CSSDrawerStyle getDrawerStyle() {
		if(drawerStyle == null) {
			drawerStyle = new CSSDrawerStyleDelegate(this, getEngine());
		}
		return drawerStyle;
	}

	protected ExtendedCSSEngine getEngine() {
		if(engine == null) {
			engine = ((CSSDiagramImpl)findView().getDiagram()).getEngine();
		}
		return engine;
	}

	protected View findView() {
		EObject parent = eContainer();
		while(!(parent instanceof View) && parent != null) {
			parent = parent.eContainer();
		}

		if(parent != null) {
			return (View)parent;
		}

		return null;
	}


	//////////////////////////////////////////
	//	Forwards accesses to CSS properties	//
	//////////////////////////////////////////


	public boolean isCSSCollapsed() {
		boolean value = super.isCollapsed();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), value)) {
			return value;
		} else {
			return getDrawerStyle().isCSSCollapsed();
		}
	}


	@Override
	public boolean isCollapsed() {
		//return super.isCollapsed();
		return isCSSCollapsed();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setCollapsed(boolean value) {
		super.setCollapsed(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getDrawerStyle_Collapsed();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	//////////////////////////////////
	//	Implements the unset method //
	//////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eClass().getEStructuralFeature(featureId);
		ForceValueHelper.unsetValue(findView(), feature);
	}


}
