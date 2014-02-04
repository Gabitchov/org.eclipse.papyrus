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
import org.eclipse.gmf.runtime.notation.impl.DescriptionStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSDescriptionStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSDescriptionStyleDelegate;

public class CSSDescriptionStyleImpl extends DescriptionStyleImpl implements CSSDescriptionStyle {

	protected ExtendedCSSEngine engine;

	private CSSDescriptionStyle descriptionStyle;

	protected CSSDescriptionStyle getDescriptionStyle() {
		if(descriptionStyle == null) {
			descriptionStyle = new CSSDescriptionStyleDelegate(this, getEngine());
		}
		return descriptionStyle;
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


	public java.lang.String getCSSDescription() {
		java.lang.String value = super.getDescription();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getDescriptionStyle_Description(), value)) {
			return value;
		} else {
			return getDescriptionStyle().getCSSDescription();
		}
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
