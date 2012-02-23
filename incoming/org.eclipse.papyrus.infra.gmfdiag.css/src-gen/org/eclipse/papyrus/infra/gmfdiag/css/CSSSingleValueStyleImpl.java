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
import org.eclipse.gmf.runtime.notation.impl.SingleValueStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSSingleValueStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSSingleValueStyleDelegate;

public class CSSSingleValueStyleImpl extends SingleValueStyleImpl implements CSSSingleValueStyle {

	protected ExtendedCSSEngine engine;

	private CSSSingleValueStyle singleValueStyle;

	protected CSSSingleValueStyle getSingleValueStyle() {
		if(singleValueStyle == null) {
			singleValueStyle = new  CSSSingleValueStyleDelegate(this, getEngine());
		}
		return singleValueStyle;
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
			return getSingleValueStyle().getCSSName();
		}
	}

	public java.lang.String getCSSRawValue(){
		java.lang.String value = super.getRawValue();

		if (ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getSingleValueStyle_RawValue(), value)){
			return value;
		} else {
			return getSingleValueStyle().getCSSRawValue();
		}
	}


	@Override
	public java.lang.String getName(){
		//return super.getName();
		return getCSSName();
	}

	@Override
	public java.lang.String getRawValue(){
		//return super.getRawValue();
		return getCSSRawValue();
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
	public void setRawValue(java.lang.String value){
		super.setRawValue(value);
	
		EStructuralFeature feature = NotationPackage.eINSTANCE.getSingleValueStyle_RawValue();
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
