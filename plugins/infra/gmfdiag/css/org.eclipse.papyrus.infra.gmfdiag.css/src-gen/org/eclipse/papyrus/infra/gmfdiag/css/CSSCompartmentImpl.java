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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.impl.CompartmentImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSDrawerStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSDrawerStyleDelegate;

public class CSSCompartmentImpl extends CompartmentImpl implements CSSDrawerStyle {

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
			engine = ((CSSDiagramImpl)getDiagram()).getEngine();
		}
		return engine;
	}


	//////////////////////////////////////////
	//	Forwards accesses to CSS properties	//
	//////////////////////////////////////////


	public boolean isCSSCollapsed() {
		boolean value = super.isCollapsed();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), value)) {
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
	public void setVisible(boolean value) {
		super.setVisible(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Visible();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setType(java.lang.String value) {
		super.setType(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Type();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setMutable(boolean value) {
		super.setMutable(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Mutable();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setCollapsed(boolean value) {
		super.setCollapsed(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getDrawerStyle_Collapsed();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setCanonical(boolean value) {
		super.setCanonical(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getCanonicalStyle_Canonical();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setShowTitle(boolean value) {
		super.setShowTitle(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getTitleStyle_ShowTitle();
		ForceValueHelper.setValue(this, feature, value);
	}

	//////////////////////////////////
	//	Implements the unset method //
	//////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eClass().getEStructuralFeature(featureId);
		ForceValueHelper.unsetValue(this, feature);
	}


}
