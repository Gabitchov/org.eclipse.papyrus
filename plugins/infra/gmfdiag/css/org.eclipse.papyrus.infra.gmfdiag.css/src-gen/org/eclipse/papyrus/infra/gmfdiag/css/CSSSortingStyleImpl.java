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
import org.eclipse.gmf.runtime.notation.Sorting;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.SortingStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSSortingStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSSortingStyleDelegate;

public class CSSSortingStyleImpl extends SortingStyleImpl implements CSSSortingStyle {

	protected ExtendedCSSEngine engine;

	private CSSSortingStyle sortingStyle;

	protected CSSSortingStyle getSortingStyle() {
		if(sortingStyle == null) {
			sortingStyle = new CSSSortingStyleDelegate(this, getEngine());
		}
		return sortingStyle;
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


	public Sorting getCSSSorting() {
		Sorting value = super.getSorting();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getSortingStyle_Sorting(), value)) {
			return value;
		} else {
			return getSortingStyle().getCSSSorting();
		}
	}

	public java.util.Map getCSSSortingKeys() {
		java.util.Map value = super.getSortingKeys();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getSortingStyle_SortingKeys(), value)) {
			return value;
		} else {
			return getSortingStyle().getCSSSortingKeys();
		}
	}


	@Override
	public Sorting getSorting() {
		//return super.getSorting();
		return getCSSSorting();
	}

	@Override
	public java.util.Map getSortingKeys() {
		//return super.getSortingKeys();
		return getCSSSortingKeys();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setSorting(Sorting value) {
		super.setSorting(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getSortingStyle_Sorting();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setSortingKeys(java.util.Map value) {
		super.setSortingKeys(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getSortingStyle_SortingKeys();
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
