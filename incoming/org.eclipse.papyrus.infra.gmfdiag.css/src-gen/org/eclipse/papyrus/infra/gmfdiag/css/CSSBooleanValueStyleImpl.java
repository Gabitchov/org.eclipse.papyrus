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
import org.eclipse.gmf.runtime.notation.impl.BooleanValueStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSBooleanValueStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSBooleanValueStyleDelegate;

public class CSSBooleanValueStyleImpl extends BooleanValueStyleImpl implements CSSBooleanValueStyle {

	protected ExtendedCSSEngine engine;

	private CSSBooleanValueStyle booleanValueStyle;

	protected CSSBooleanValueStyle getBooleanValueStyle() {
		if(booleanValueStyle == null) {
			booleanValueStyle = new  CSSBooleanValueStyleDelegate(this, getEngine());
		}
		return booleanValueStyle;
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
			return getBooleanValueStyle().getCSSName();
		}
	}

	public boolean isCSSBooleanValue(){
		boolean value = super.isBooleanValue();

		if (ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getBooleanValueStyle_BooleanValue(), value)){
			return value;
		} else {
			return getBooleanValueStyle().isCSSBooleanValue();
		}
	}


	@Override
	public java.lang.String getName(){
		//return super.getName();
		return getCSSName();
	}

	@Override
	public boolean isBooleanValue(){
		//return super.isBooleanValue();
		return isCSSBooleanValue();
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

	@Override
	public void setBooleanValue(boolean value){
		super.setBooleanValue(value);
	
		EStructuralFeature feature = NotationPackage.eINSTANCE.getBooleanValueStyle_BooleanValue();
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
