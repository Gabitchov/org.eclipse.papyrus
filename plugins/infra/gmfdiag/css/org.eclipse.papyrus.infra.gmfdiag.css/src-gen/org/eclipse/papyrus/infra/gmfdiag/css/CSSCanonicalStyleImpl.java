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
import org.eclipse.gmf.runtime.notation.impl.CanonicalStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSCanonicalStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSCanonicalStyleDelegate;

public class CSSCanonicalStyleImpl extends CanonicalStyleImpl implements CSSCanonicalStyle {

	protected ExtendedCSSEngine engine;

	private CSSCanonicalStyle canonicalStyle;

	protected CSSCanonicalStyle getCanonicalStyle() {
		if(canonicalStyle == null) {
			canonicalStyle = new CSSCanonicalStyleDelegate(this, getEngine());
		}
		return canonicalStyle;
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


	public boolean isCSSCanonical() {
		boolean value = super.isCanonical();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getCanonicalStyle_Canonical(), value)) {
			return value;
		} else {
			return getCanonicalStyle().isCSSCanonical();
		}
	}


	@Override
	public boolean isCanonical() {
		//return super.isCanonical();
		return isCSSCanonical();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setCanonical(boolean value) {
		super.setCanonical(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getCanonicalStyle_Canonical();
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
