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
import org.eclipse.gmf.runtime.notation.impl.PageStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSPageStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSPageStyleDelegate;

public class CSSPageStyleImpl extends PageStyleImpl implements CSSPageStyle {

	protected ExtendedCSSEngine engine;

	private CSSPageStyle pageStyle;

	protected CSSPageStyle getPageStyle() {
		if(pageStyle == null) {
			pageStyle = new CSSPageStyleDelegate(this, getEngine());
		}
		return pageStyle;
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


	public int getCSSPageX() {
		int value = super.getPageX();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getPageStyle_PageX(), value)) {
			return value;
		} else {
			return getPageStyle().getCSSPageX();
		}
	}

	public int getCSSPageY() {
		int value = super.getPageY();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getPageStyle_PageY(), value)) {
			return value;
		} else {
			return getPageStyle().getCSSPageY();
		}
	}

	public int getCSSPageWidth() {
		int value = super.getPageWidth();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getPageStyle_PageWidth(), value)) {
			return value;
		} else {
			return getPageStyle().getCSSPageWidth();
		}
	}

	public int getCSSPageHeight() {
		int value = super.getPageHeight();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getPageStyle_PageHeight(), value)) {
			return value;
		} else {
			return getPageStyle().getCSSPageHeight();
		}
	}


	@Override
	public int getPageX() {
		//return super.getPageX();
		return getCSSPageX();
	}

	@Override
	public int getPageY() {
		//return super.getPageY();
		return getCSSPageY();
	}

	@Override
	public int getPageWidth() {
		//return super.getPageWidth();
		return getCSSPageWidth();
	}

	@Override
	public int getPageHeight() {
		//return super.getPageHeight();
		return getCSSPageHeight();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setPageX(int value) {
		super.setPageX(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getPageStyle_PageX();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setPageY(int value) {
		super.setPageY(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getPageStyle_PageY();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setPageWidth(int value) {
		super.setPageWidth(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getPageStyle_PageWidth();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setPageHeight(int value) {
		super.setPageHeight(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getPageStyle_PageHeight();
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
