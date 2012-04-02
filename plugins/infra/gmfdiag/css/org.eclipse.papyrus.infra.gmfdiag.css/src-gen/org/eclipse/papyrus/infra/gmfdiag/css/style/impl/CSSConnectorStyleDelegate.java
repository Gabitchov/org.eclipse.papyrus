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
package org.eclipse.papyrus.infra.gmfdiag.css.style.impl;

import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSConnectorStyle;
import org.w3c.dom.css.CSSValue;

public class CSSConnectorStyleDelegate implements CSSConnectorStyle {

	private ConnectorStyle connectorStyle;

	private ExtendedCSSEngine engine;

	public CSSConnectorStyleDelegate(ConnectorStyle connectorStyle, ExtendedCSSEngine engine) {
		this.connectorStyle = connectorStyle;
		this.engine = engine;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSRoundedBendpointsRadius() {
		CSSValue cssValue = engine.retrievePropertyValue(connectorStyle, "roundedBendpointsRadius");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}

	public Routing getCSSRouting() {
		CSSValue cssValue = engine.retrievePropertyValue(connectorStyle, "routing");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_Routing().getDefaultValue();
			return (Routing)defaultValue;
		}
		return Routing.get(cssValue.getCssText());
	}

	public Smoothness getCSSSmoothness() {
		CSSValue cssValue = engine.retrievePropertyValue(connectorStyle, "smoothness");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_Smoothness().getDefaultValue();
			return (Smoothness)defaultValue;
		}
		return Smoothness.get(cssValue.getCssText());
	}

	public boolean isCSSAvoidObstructions() {
		CSSValue cssValue = engine.retrievePropertyValue(connectorStyle, "avoidObstructions");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public boolean isCSSClosestDistance() {
		CSSValue cssValue = engine.retrievePropertyValue(connectorStyle, "closestDistance");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public JumpLinkStatus getCSSJumpLinkStatus() {
		CSSValue cssValue = engine.retrievePropertyValue(connectorStyle, "jumpLinkStatus");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus().getDefaultValue();
			return (JumpLinkStatus)defaultValue;
		}
		return JumpLinkStatus.get(cssValue.getCssText());
	}

	public JumpLinkType getCSSJumpLinkType() {
		CSSValue cssValue = engine.retrievePropertyValue(connectorStyle, "jumpLinkType");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType().getDefaultValue();
			return (JumpLinkType)defaultValue;
		}
		return JumpLinkType.get(cssValue.getCssText());
	}

	public boolean isCSSJumpLinksReverse() {
		CSSValue cssValue = engine.retrievePropertyValue(connectorStyle, "jumpLinksReverse");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public int getCSSLineColor() {
		CSSValue cssValue = engine.retrievePropertyValue(connectorStyle, "lineColor");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getLineStyle_LineColor().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, "GMFColor", null);
	}

	public int getCSSLineWidth() {
		CSSValue cssValue = engine.retrievePropertyValue(connectorStyle, "lineWidth");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getLineStyle_LineWidth().getDefaultValue();
			return (Integer)defaultValue;
		}
		return (Integer)engine.convert(cssValue, Integer.class, null);
	}
}
