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
import org.eclipse.gmf.runtime.notation.impl.ImageBufferStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSImageBufferStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSImageBufferStyleDelegate;

public class CSSImageBufferStyleImpl extends ImageBufferStyleImpl implements CSSImageBufferStyle {

	protected ExtendedCSSEngine engine;

	private CSSImageBufferStyle imageBufferStyle;

	protected CSSImageBufferStyle getImageBufferStyle() {
		if(imageBufferStyle == null) {
			imageBufferStyle = new CSSImageBufferStyleDelegate(this, getEngine());
		}
		return imageBufferStyle;
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


	public java.lang.Boolean getCSSAntiAlias() {
		java.lang.Boolean value = super.getAntiAlias();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getImageStyle_AntiAlias(), value)) {
			return value;
		} else {
			return getImageBufferStyle().getCSSAntiAlias();
		}
	}

	public java.lang.Boolean getCSSMaintainAspectRatio() {
		java.lang.Boolean value = super.getMaintainAspectRatio();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getImageStyle_MaintainAspectRatio(), value)) {
			return value;
		} else {
			return getImageBufferStyle().getCSSMaintainAspectRatio();
		}
	}


	@Override
	public java.lang.Boolean getAntiAlias() {
		//return super.getAntiAlias();
		return getCSSAntiAlias();
	}

	@Override
	public java.lang.Boolean getMaintainAspectRatio() {
		//return super.getMaintainAspectRatio();
		return getCSSMaintainAspectRatio();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setAntiAlias(java.lang.Boolean value) {
		super.setAntiAlias(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getImageStyle_AntiAlias();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setMaintainAspectRatio(java.lang.Boolean value) {
		super.setMaintainAspectRatio(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getImageStyle_MaintainAspectRatio();
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
