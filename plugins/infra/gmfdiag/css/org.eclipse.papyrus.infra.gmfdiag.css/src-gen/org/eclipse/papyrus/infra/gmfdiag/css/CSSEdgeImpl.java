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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.provider.CSSCustomStyleDelegate;
import org.eclipse.papyrus.infra.gmfdiag.css.provider.CustomStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSView;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSViewDelegate;

public class CSSEdgeImpl extends EdgeImpl implements CSSView, CustomStyle {

	protected ExtendedCSSEngine engine;

	private CSSView cssView;

	private CustomStyle customStyle;

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

	protected CustomStyle getCustomStyle() {
		if(customStyle == null) {
			customStyle = new CSSCustomStyleDelegate(this, getEngine());
		}
		return customStyle;
	}

	@Override
	public boolean isVisible() {
		return isCSSVisible();
	}

	@Override
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

	//////////////////////////////////
	//	Implements the unset method //
	//////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eClass().getEStructuralFeature(featureId);
		ForceValueHelper.unsetValue(this, feature);
	}

	//////////////////////////////////
	//	Implements the getNamedStyle //
	//////////////////////////////////

	@Override
	public NamedStyle getNamedStyle(EClass eClass, String name) {
		return getCSSNamedStyle(eClass, name);
	}

	@Override
	public NamedStyle getCSSNamedStyle(EClass eClass, String name) {
		NamedStyle userStyle = super.getNamedStyle(eClass, name);
		if(userStyle != null) {
			return userStyle;
		}

		return getCSSView().getCSSNamedStyle(eClass, name);
	}

	///////////////////////////////////
	//	Implements the custom styles //
	///////////////////////////////////

	@Override
	public boolean showElementIcon() {
		return getCustomStyle().showElementIcon();
	}

	@Override
	public int getQualifiedNameDepth() {
		return getCustomStyle().getQualifiedNameDepth();
	}

	@Override
	public boolean showShadow() {
		return getCustomStyle().showShadow();
	}

}
