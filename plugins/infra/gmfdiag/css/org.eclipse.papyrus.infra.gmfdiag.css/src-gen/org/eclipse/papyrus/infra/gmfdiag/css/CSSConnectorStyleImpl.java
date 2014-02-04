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
import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ConnectorStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSConnectorStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSConnectorStyleDelegate;

public class CSSConnectorStyleImpl extends ConnectorStyleImpl implements CSSConnectorStyle {

	protected ExtendedCSSEngine engine;

	private CSSConnectorStyle connectorStyle;

	protected CSSConnectorStyle getConnectorStyle() {
		if(connectorStyle == null) {
			connectorStyle = new CSSConnectorStyleDelegate(this, getEngine());
		}
		return connectorStyle;
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


	public int getCSSRoundedBendpointsRadius() {
		int value = super.getRoundedBendpointsRadius();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSRoundedBendpointsRadius();
		}
	}

	public Routing getCSSRouting() {
		Routing value = super.getRouting();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSRouting();
		}
	}

	public Smoothness getCSSSmoothness() {
		Smoothness value = super.getSmoothness();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getRoutingStyle_Smoothness(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSSmoothness();
		}
	}

	public boolean isCSSAvoidObstructions() {
		boolean value = super.isAvoidObstructions();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions(), value)) {
			return value;
		} else {
			return getConnectorStyle().isCSSAvoidObstructions();
		}
	}

	public boolean isCSSClosestDistance() {
		boolean value = super.isClosestDistance();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance(), value)) {
			return value;
		} else {
			return getConnectorStyle().isCSSClosestDistance();
		}
	}

	public JumpLinkStatus getCSSJumpLinkStatus() {
		JumpLinkStatus value = super.getJumpLinkStatus();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSJumpLinkStatus();
		}
	}

	public JumpLinkType getCSSJumpLinkType() {
		JumpLinkType value = super.getJumpLinkType();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSJumpLinkType();
		}
	}

	public boolean isCSSJumpLinksReverse() {
		boolean value = super.isJumpLinksReverse();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse(), value)) {
			return value;
		} else {
			return getConnectorStyle().isCSSJumpLinksReverse();
		}
	}

	public int getCSSLineColor() {
		int value = super.getLineColor();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getLineStyle_LineColor(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSLineColor();
		}
	}

	public int getCSSLineWidth() {
		int value = super.getLineWidth();

		if(ForceValueHelper.isSet(findView(), this, NotationPackage.eINSTANCE.getLineStyle_LineWidth(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSLineWidth();
		}
	}


	@Override
	public int getRoundedBendpointsRadius() {
		//return super.getRoundedBendpointsRadius();
		return getCSSRoundedBendpointsRadius();
	}

	@Override
	public Routing getRouting() {
		//return super.getRouting();
		return getCSSRouting();
	}

	@Override
	public Smoothness getSmoothness() {
		//return super.getSmoothness();
		return getCSSSmoothness();
	}

	@Override
	public boolean isAvoidObstructions() {
		//return super.isAvoidObstructions();
		return isCSSAvoidObstructions();
	}

	@Override
	public boolean isClosestDistance() {
		//return super.isClosestDistance();
		return isCSSClosestDistance();
	}

	@Override
	public JumpLinkStatus getJumpLinkStatus() {
		//return super.getJumpLinkStatus();
		return getCSSJumpLinkStatus();
	}

	@Override
	public JumpLinkType getJumpLinkType() {
		//return super.getJumpLinkType();
		return getCSSJumpLinkType();
	}

	@Override
	public boolean isJumpLinksReverse() {
		//return super.isJumpLinksReverse();
		return isCSSJumpLinksReverse();
	}

	@Override
	public int getLineColor() {
		//return super.getLineColor();
		return getCSSLineColor();
	}

	@Override
	public int getLineWidth() {
		//return super.getLineWidth();
		return getCSSLineWidth();
	}



	////////////////////////////////////////////////
	//	Implements a setter for each CSS property //
	////////////////////////////////////////////////	

	@Override
	public void setRoundedBendpointsRadius(int value) {
		super.setRoundedBendpointsRadius(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setRouting(Routing value) {
		super.setRouting(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_Routing();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setSmoothness(Smoothness value) {
		super.setSmoothness(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_Smoothness();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setAvoidObstructions(boolean value) {
		super.setAvoidObstructions(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setClosestDistance(boolean value) {
		super.setClosestDistance(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setJumpLinkStatus(JumpLinkStatus value) {
		super.setJumpLinkStatus(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setJumpLinkType(JumpLinkType value) {
		super.setJumpLinkType(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setJumpLinksReverse(boolean value) {
		super.setJumpLinksReverse(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setLineColor(int value) {
		super.setLineColor(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getLineStyle_LineColor();
		ForceValueHelper.setValue(findView(), feature, value);
	}

	@Override
	public void setLineWidth(int value) {
		super.setLineWidth(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getLineStyle_LineWidth();
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
