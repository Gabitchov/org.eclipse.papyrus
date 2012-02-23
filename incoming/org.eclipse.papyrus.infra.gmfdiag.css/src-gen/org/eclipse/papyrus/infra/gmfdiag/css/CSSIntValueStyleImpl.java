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
import org.eclipse.gmf.runtime.notation.impl.IntValueStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSIntValueStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSIntValueStyleDelegate;

public class CSSIntValueStyleImpl extends IntValueStyleImpl implements CSSIntValueStyle {

	protected ExtendedCSSEngine engine;

	private CSSIntValueStyle intValueStyle;

	protected CSSIntValueStyle getIntValueStyle() {
		if(intValueStyle == null) {
			intValueStyle = new  CSSIntValueStyleDelegate(this, getEngine());
		}
		return intValueStyle;
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
			return getIntValueStyle().getCSSName();
		}
	}

	public int getCSSIntValue(){
		int value = super.getIntValue();

		if (ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getIntValueStyle_IntValue(), value)){
			return value;
		} else {
			return getIntValueStyle().getCSSIntValue();
		}
	}


	@Override
	public java.lang.String getName(){
		//return super.getName();
		return getCSSName();
	}

	@Override
	public int getIntValue(){
		//return super.getIntValue();
		return getCSSIntValue();
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
	public void setIntValue(int value){
		super.setIntValue(value);
	
		EStructuralFeature feature = NotationPackage.eINSTANCE.getIntValueStyle_IntValue();
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
