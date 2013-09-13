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
import org.eclipse.gmf.runtime.notation.impl.FillStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSFillStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSFillStyleDelegate;

public class CSSFillStyleImpl extends FillStyleImpl implements CSSFillStyle {

	protected ExtendedCSSEngine engine;

	private CSSFillStyle fillStyle;

	protected CSSFillStyle getFillStyle() {
		if(fillStyle == null) {
			fillStyle = new CSSFillStyleDelegate(this, getEngine());
		}
		return fillStyle;
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


	public int getCSSFillColor() {
		int value = super.getFillColor();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFillStyle_FillColor(), value)) {
			return value;
		} else {
			return getFillStyle().getCSSFillColor();
		}
	}

	public int getCSSTransparency() {
		int value = super.getTransparency();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFillStyle_Transparency(), value)) {
			return value;
		} else {
			return getFillStyle().getCSSTransparency();
		}
	}

	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient() {
		org.eclipse.gmf.runtime.notation.datatype.GradientData value = super.getGradient();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFillStyle_Gradient(), value)) {
			return value;
		} else {
			return getFillStyle().getCSSGradient();
		}
	}


	@Override
	public int getFillColor() {
		//return super.getFillColor();
		return getCSSFillColor();
	}

	@Override
	public int getTransparency() {
		//return super.getTransparency();
		return getCSSTransparency();
	}

	@Override
	public org.eclipse.gmf.runtime.notation.datatype.GradientData getGradient() {
		//return super.getGradient();
		return getCSSGradient();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setFillColor(int value) {
		super.setFillColor(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFillStyle_FillColor();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setTransparency(int value) {
		super.setTransparency(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFillStyle_Transparency();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setGradient(org.eclipse.gmf.runtime.notation.datatype.GradientData value) {
		super.setGradient(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFillStyle_Gradient();
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
