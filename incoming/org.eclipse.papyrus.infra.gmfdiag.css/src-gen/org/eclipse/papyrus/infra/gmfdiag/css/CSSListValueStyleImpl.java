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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ListValueStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSListValueStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSListValueStyleDelegate;

public class CSSListValueStyleImpl extends ListValueStyleImpl implements CSSListValueStyle {

	protected ExtendedCSSEngine engine;

	private CSSListValueStyle listValueStyle;

	protected CSSListValueStyle getListValueStyle() {
		if(listValueStyle == null) {
			listValueStyle = new  CSSListValueStyleDelegate(this, getEngine());
		}
		return listValueStyle;
	}

	protected ExtendedCSSEngine getEngine(){
		if (engine == null){
			engine = ((CSSDiagramImpl)findView().getDiagram()).getEngine();
		}
		return engine;
	}

	protected View findView(){
		EObject parent = eContainer();
		while (! (parent instanceof View) && parent != null){
			parent = parent.eContainer();
		}

		if (parent != null){
			return (View)parent;
		}

		return null;
	}


	//////////////////////////////////////////
	//	Forwards accesses to CSS properties	//
	//////////////////////////////////////////


	public java.lang.String getCSSName(){
		java.lang.String value = super.getName();

		if (ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getNamedStyle_Name(), value)){
			return value;
		} else {
			return getListValueStyle().getCSSName();
		}
	}

	public EList getCSSRawValuesList(){
		EList value = super.getRawValuesList();

		if (ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getListValueStyle_RawValuesList(), value)){
			return value;
		} else {
			return getListValueStyle().getCSSRawValuesList();
		}
	}


	@Override
	public java.lang.String getName(){
		//return super.getName();
		return getCSSName();
	}

	@Override
	public EList getRawValuesList(){
		//return super.getRawValuesList();
		return getCSSRawValuesList();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setName(java.lang.String value){
		super.setName(value);
	
		EStructuralFeature feature = NotationPackage.eINSTANCE.getNamedStyle_Name();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	//////////////////////////////////
	//	Implements the unset method //
	//////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eDynamicFeature(featureId);
		ForceValueHelper.unsetValue(findView(), feature);
	}


}
