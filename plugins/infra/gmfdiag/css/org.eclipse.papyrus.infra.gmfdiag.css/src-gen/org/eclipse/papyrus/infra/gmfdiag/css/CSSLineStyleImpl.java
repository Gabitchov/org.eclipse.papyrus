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
import org.eclipse.gmf.runtime.notation.impl.LineStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSLineStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSLineStyleDelegate;

public class CSSLineStyleImpl extends LineStyleImpl implements CSSLineStyle {

	protected ExtendedCSSEngine engine;

	private CSSLineStyle lineStyle;

	protected CSSLineStyle getLineStyle() {
		if(lineStyle == null) {
			lineStyle = new CSSLineStyleDelegate(this, getEngine());
		}
		return lineStyle;
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


	public int getCSSLineColor() {
		int value = super.getLineColor();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getLineStyle_LineColor(), value)) {
			return value;
		} else {
			return getLineStyle().getCSSLineColor();
		}
	}

	public int getCSSLineWidth() {
		int value = super.getLineWidth();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getLineStyle_LineWidth(), value)) {
			return value;
		} else {
			return getLineStyle().getCSSLineWidth();
		}
	}


	@Override
	public int getLineColor() {
		//return super.getLineColor();
		return getCSSLineColor();
	}

	@Override
	public int getLineWidth() {
		//return super.getLineWidth();
		return getCSSLineWidth();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setLineColor(int value) {
		super.setLineColor(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getLineStyle_LineColor();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setLineWidth(int value) {
		super.setLineWidth(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getLineStyle_LineWidth();
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
