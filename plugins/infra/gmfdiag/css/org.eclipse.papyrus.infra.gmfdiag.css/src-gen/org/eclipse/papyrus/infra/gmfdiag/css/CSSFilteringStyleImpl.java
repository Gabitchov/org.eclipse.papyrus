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
import org.eclipse.gmf.runtime.notation.Filtering;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.FilteringStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSFilteringStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSFilteringStyleDelegate;

public class CSSFilteringStyleImpl extends FilteringStyleImpl implements CSSFilteringStyle {

	protected ExtendedCSSEngine engine;

	private CSSFilteringStyle filteringStyle;

	protected CSSFilteringStyle getFilteringStyle() {
		if(filteringStyle == null) {
			filteringStyle = new CSSFilteringStyleDelegate(this, getEngine());
		}
		return filteringStyle;
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


	public Filtering getCSSFiltering() {
		Filtering value = super.getFiltering();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFilteringStyle_Filtering(), value)) {
			return value;
		} else {
			return getFilteringStyle().getCSSFiltering();
		}
	}

	public java.util.List getCSSFilteringKeys() {
		java.util.List value = super.getFilteringKeys();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getFilteringStyle_FilteringKeys(), value)) {
			return value;
		} else {
			return getFilteringStyle().getCSSFilteringKeys();
		}
	}


	@Override
	public Filtering getFiltering() {
		//return super.getFiltering();
		return getCSSFiltering();
	}

	@Override
	public java.util.List getFilteringKeys() {
		//return super.getFilteringKeys();
		return getCSSFilteringKeys();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setFiltering(Filtering value) {
		super.setFiltering(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFilteringStyle_Filtering();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setFilteringKeys(java.util.List value) {
		super.setFilteringKeys(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFilteringStyle_FilteringKeys();
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
