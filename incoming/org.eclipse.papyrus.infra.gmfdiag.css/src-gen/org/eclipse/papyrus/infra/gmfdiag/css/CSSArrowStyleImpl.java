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
import org.eclipse.gmf.runtime.notation.ArrowType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ArrowStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSArrowStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSArrowStyleDelegate;

public class CSSArrowStyleImpl extends ArrowStyleImpl implements CSSArrowStyle {

	protected ExtendedCSSEngine engine;

	private CSSArrowStyle arrowStyle;

	protected CSSArrowStyle getArrowStyle() {
		if(arrowStyle == null) {
			arrowStyle = new  CSSArrowStyleDelegate(this, getEngine());
		}
		return arrowStyle;
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


	public ArrowType getCSSArrowSource(){
		ArrowType value = super.getArrowSource();

		if (ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getArrowStyle_ArrowSource(), value)){
			return value;
		} else {
			return getArrowStyle().getCSSArrowSource();
		}
	}

	public ArrowType getCSSArrowTarget(){
		ArrowType value = super.getArrowTarget();

		if (ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getArrowStyle_ArrowTarget(), value)){
			return value;
		} else {
			return getArrowStyle().getCSSArrowTarget();
		}
	}


	@Override
	public ArrowType getArrowSource(){
		//return super.getArrowSource();
		return getCSSArrowSource();
	}

	@Override
	public ArrowType getArrowTarget(){
		//return super.getArrowTarget();
		return getCSSArrowTarget();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setArrowSource(ArrowType value){
		super.setArrowSource(value);
	
		EStructuralFeature feature = NotationPackage.eINSTANCE.getArrowStyle_ArrowSource();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setArrowTarget(ArrowType value){
		super.setArrowTarget(value);
	
		EStructuralFeature feature = NotationPackage.eINSTANCE.getArrowStyle_ArrowTarget();
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
