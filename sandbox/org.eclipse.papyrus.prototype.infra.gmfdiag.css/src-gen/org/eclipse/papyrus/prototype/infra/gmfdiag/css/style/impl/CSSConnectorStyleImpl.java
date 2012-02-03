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
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.converters.ColorToGMFConverter;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.CSSConnectorStyle;
import org.w3c.dom.css.CSSValue;

@SuppressWarnings("restriction")
public class CSSConnectorStyleImpl implements CSSConnectorStyle {

	private ConnectorStyle connectorStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSConnectorStyleImpl(ConnectorStyle connectorStyle, CSSStylableElement element, CSSEngine engine) {
		this.connectorStyle = connectorStyle;
		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSRoundedBendpointsRadius() {
		String cssValue = engine.retrieveCSSProperty(element, "roundedBendpointsRadius", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius().getDefaultValue();
			return (Integer)defaultValue;
		}
		return Integer.parseInt(cssValue);
	}

	public Routing getCSSRouting() {
		String cssValue = engine.retrieveCSSProperty(element, "routing", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_Routing().getDefaultValue();
			return (Routing)defaultValue;
		}
		return Routing.get(cssValue);
	}

	public Smoothness getCSSSmoothness() {
		String cssValue = engine.retrieveCSSProperty(element, "smoothness", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_Smoothness().getDefaultValue();
			return (Smoothness)defaultValue;
		}
		return Smoothness.get(cssValue);
	}

	public boolean isCSSAvoidObstructions() {
		String cssValue = engine.retrieveCSSProperty(element, "avoidObstructions", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return Boolean.parseBoolean(cssValue);
	}

	public boolean isCSSClosestDistance() {
		String cssValue = engine.retrieveCSSProperty(element, "closestDistance", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return Boolean.parseBoolean(cssValue);
	}

	public JumpLinkStatus getCSSJumpLinkStatus() {
		String cssValue = engine.retrieveCSSProperty(element, "jumpLinkStatus", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus().getDefaultValue();
			return (JumpLinkStatus)defaultValue;
		}
		return JumpLinkStatus.get(cssValue);
	}

	public JumpLinkType getCSSJumpLinkType() {
		String cssValue = engine.retrieveCSSProperty(element, "jumpLinkType", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType().getDefaultValue();
			return (JumpLinkType)defaultValue;
		}
		return JumpLinkType.get(cssValue);
	}

	public boolean isCSSJumpLinksReverse() {
		String cssValue = engine.retrieveCSSProperty(element, "jumpLinksReverse", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse().getDefaultValue();
			return (Boolean)defaultValue;
		}
		return Boolean.parseBoolean(cssValue);
	}

	public int getCSSLineColor() {
		String cssValue = engine.retrieveCSSProperty(element, "lineColor", "");

		try {
			CSSValue value = engine.parsePropertyValue(cssValue);
			return (Integer)engine.convert(value, ColorToGMFConverter.GMFColor, null);
		} catch (Exception ex) {
			Activator.log.error(ex);
		}

		return (Integer)NotationPackage.eINSTANCE.getLineStyle_LineColor().getDefaultValue();
	}

	public int getCSSLineWidth() {
		String cssValue = engine.retrieveCSSProperty(element, "lineWidth", "");
		if(cssValue == null) {
			Object defaultValue = NotationPackage.eINSTANCE.getLineStyle_LineWidth().getDefaultValue();
			return (Integer)defaultValue;
		}
		return Integer.parseInt(cssValue);
	}
}
