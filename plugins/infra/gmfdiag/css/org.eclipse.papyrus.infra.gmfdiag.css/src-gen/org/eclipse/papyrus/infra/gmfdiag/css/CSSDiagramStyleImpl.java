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
import org.eclipse.gmf.runtime.notation.impl.DiagramStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSDiagramStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSDiagramStyleDelegate;

public class CSSDiagramStyleImpl extends DiagramStyleImpl implements CSSDiagramStyle {

	protected ExtendedCSSEngine engine;

	private CSSDiagramStyle diagramStyle;

	protected CSSDiagramStyle getDiagramStyle() {
		if(diagramStyle == null) {
			diagramStyle = new CSSDiagramStyleDelegate(this, getEngine());
		}
		return diagramStyle;
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
			return getDiagramStyle().getCSSPageX();
		}
	}

	public int getCSSPageY() {
		int value = super.getPageY();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getPageStyle_PageY(), value)) {
			return value;
		} else {
			return getDiagramStyle().getCSSPageY();
		}
	}

	public int getCSSPageWidth() {
		int value = super.getPageWidth();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getPageStyle_PageWidth(), value)) {
			return value;
		} else {
			return getDiagramStyle().getCSSPageWidth();
		}
	}

	public int getCSSPageHeight() {
		int value = super.getPageHeight();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getPageStyle_PageHeight(), value)) {
			return value;
		} else {
			return getDiagramStyle().getCSSPageHeight();
		}
	}

	public java.lang.String getCSSDescription() {
		java.lang.String value = super.getDescription();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getDescriptionStyle_Description(), value)) {
			return value;
		} else {
			return getDiagramStyle().getCSSDescription();
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

	@Override
	public java.lang.String getDescription() {
		//return super.getDescription();
		return getCSSDescription();
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

	@Override
	public void setDescription(java.lang.String value) {
		super.setDescription(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getDescriptionStyle_Description();
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
