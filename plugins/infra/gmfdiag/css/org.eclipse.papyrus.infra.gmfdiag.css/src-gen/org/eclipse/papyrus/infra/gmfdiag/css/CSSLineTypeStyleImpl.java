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
import org.eclipse.gmf.runtime.notation.LineType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.LineTypeStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSLineTypeStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSLineTypeStyleDelegate;

public class CSSLineTypeStyleImpl extends LineTypeStyleImpl implements CSSLineTypeStyle {

	protected ExtendedCSSEngine engine;

	private CSSLineTypeStyle lineTypeStyle;

	protected CSSLineTypeStyle getLineTypeStyle() {
		if(lineTypeStyle == null) {
			lineTypeStyle = new CSSLineTypeStyleDelegate(this, getEngine());
		}
		return lineTypeStyle;
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


	public LineType getCSSLineType() {
		LineType value = super.getLineType();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getLineTypeStyle_LineType(), value)) {
			return value;
		} else {
			return getLineTypeStyle().getCSSLineType();
		}
	}


	@Override
	public LineType getLineType() {
		//return super.getLineType();
		return getCSSLineType();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setLineType(LineType value) {
		super.setLineType(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getLineTypeStyle_LineType();
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
