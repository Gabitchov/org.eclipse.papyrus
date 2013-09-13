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
import org.eclipse.gmf.runtime.notation.impl.HintedDiagramLinkStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSHintedDiagramLinkStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSHintedDiagramLinkStyleDelegate;

public class CSSHintedDiagramLinkStyleImpl extends HintedDiagramLinkStyleImpl implements CSSHintedDiagramLinkStyle {

	protected ExtendedCSSEngine engine;

	private CSSHintedDiagramLinkStyle hintedDiagramLinkStyle;

	protected CSSHintedDiagramLinkStyle getHintedDiagramLinkStyle() {
		if(hintedDiagramLinkStyle == null) {
			hintedDiagramLinkStyle = new CSSHintedDiagramLinkStyleDelegate(this, getEngine());
		}
		return hintedDiagramLinkStyle;
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


	public java.lang.String getCSSHint() {
		java.lang.String value = super.getHint();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getHintedDiagramLinkStyle_Hint(), value)) {
			return value;
		} else {
			return getHintedDiagramLinkStyle().getCSSHint();
		}
	}


	@Override
	public java.lang.String getHint() {
		//return super.getHint();
		return getCSSHint();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setHint(java.lang.String value) {
		super.setHint(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getHintedDiagramLinkStyle_Hint();
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
