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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.Filtering;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Sorting;
import org.eclipse.gmf.runtime.notation.impl.SemanticListCompartmentImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSDrawerStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSView;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSDrawerStyleDelegate;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSViewDelegate;

public class CSSSemanticListCompartmentImpl extends SemanticListCompartmentImpl implements CSSDrawerStyle {

	protected ExtendedCSSEngine engine;

	private CSSDrawerStyle drawerStyle;

	private CSSView cssView;

	protected CSSDrawerStyle getDrawerStyle() {
		if(drawerStyle == null) {
			drawerStyle = new CSSDrawerStyleDelegate(this, getEngine());
		}
		return drawerStyle;
	}

	protected ExtendedCSSEngine getEngine() {
		if(engine == null) {
			engine = ((CSSDiagramImpl)getDiagram()).getEngine();
		}
		return engine;
	}

	protected CSSView getCSSView() {
		if(cssView == null) {
			cssView = new CSSViewDelegate(this, getEngine());
		}
		return cssView;
	}


	//////////////////////////////////////////
	//	Forwards accesses to CSS properties	//
	//////////////////////////////////////////


	public boolean isCSSCollapsed() {
		boolean value = super.isCollapsed();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), value)) {
			return value;
		} else {
			return getDrawerStyle().isCSSCollapsed();
		}
	}


	@Override
	public boolean isCollapsed() {
		//return super.isCollapsed();
		return isCSSCollapsed();
	}

	@Override
	public boolean isVisible() {
		return isCSSVisible();
	}

	public boolean isCSSVisible() {
		boolean value = super.isVisible();

		if(ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getView_Visible(), value)) {
			return value;
		} else {
			return getCSSView().isCSSVisible();
		}
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setVisible(boolean value) {
		super.setVisible(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Visible();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setType(java.lang.String value) {
		super.setType(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Type();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setMutable(boolean value) {
		super.setMutable(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Mutable();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setCollapsed(boolean value) {
		super.setCollapsed(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getDrawerStyle_Collapsed();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setSorting(Sorting value) {
		super.setSorting(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getSortingStyle_Sorting();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setSortingKeys(java.util.Map value) {
		super.setSortingKeys(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getSortingStyle_SortingKeys();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setFiltering(Filtering value) {
		super.setFiltering(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFilteringStyle_Filtering();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setFilteringKeys(java.util.List value) {
		super.setFilteringKeys(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getFilteringStyle_FilteringKeys();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setShowTitle(boolean value) {
		super.setShowTitle(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getTitleStyle_ShowTitle();
		ForceValueHelper.setValue(this, feature, value);
	}

	//////////////////////////////////
	//	Implements the unset method //
	//////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eClass().getEStructuralFeature(featureId);
		ForceValueHelper.unsetValue(this, feature);
	}


}
