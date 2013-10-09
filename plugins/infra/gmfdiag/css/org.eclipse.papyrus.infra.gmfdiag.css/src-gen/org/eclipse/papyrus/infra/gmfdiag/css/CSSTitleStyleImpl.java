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
import org.eclipse.gmf.runtime.notation.impl.TitleStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSTitleStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSTitleStyleDelegate;

public class CSSTitleStyleImpl extends TitleStyleImpl implements CSSTitleStyle {

	protected ExtendedCSSEngine engine;

	private CSSTitleStyle titleStyle;

	protected CSSTitleStyle getTitleStyle() {
		if(titleStyle == null) {
			titleStyle = new CSSTitleStyleDelegate(this, getEngine());
		}
		return titleStyle;
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


	public boolean isCSSShowTitle() {
		boolean value = super.isShowTitle();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getTitleStyle_ShowTitle(), value)) {
			return value;
		} else {
			return getTitleStyle().isCSSShowTitle();
		}
	}


	@Override
	public boolean isShowTitle() {
		//return super.isShowTitle();
		return isCSSShowTitle();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setShowTitle(boolean value) {
		super.setShowTitle(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getTitleStyle_ShowTitle();
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
