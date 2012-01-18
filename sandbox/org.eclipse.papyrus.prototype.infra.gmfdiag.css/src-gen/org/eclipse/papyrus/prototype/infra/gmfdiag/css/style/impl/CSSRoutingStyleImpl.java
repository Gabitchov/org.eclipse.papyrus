package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;

@SuppressWarnings("restriction")
public class CSSRoutingStyleImpl implements CSSRoutingStyle{
	
	private RoutingStyle routingStyle;

	private CSSEngine engine;

	private CSSStylableElement element;

	public CSSRoutingStyleImpl(RoutingStyle routingStyle, CSSStylableElement element, CSSEngine engine){
		this.routingStyle = routingStyle;
 		this.engine = engine;
		this.element = element;
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSRoundedBendpointsRadius(){
		String cssValue = engine.retrieveCSSProperty(element, "roundedBendpointsRadius", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius().getDefaultValue(); 
			return (Integer)defaultValue;
		}
		return (Integer)Integer.parseInt(cssValue);
	}

	public Routing getCSSRouting(){
		String cssValue = engine.retrieveCSSProperty(element, "routing", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_Routing().getDefaultValue(); 
			return (Routing)defaultValue;
		}
		return Routing.get(cssValue);
	}

	public Smoothness getCSSSmoothness(){
		String cssValue = engine.retrieveCSSProperty(element, "smoothness", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_Smoothness().getDefaultValue(); 
			return (Smoothness)defaultValue;
		}
		return Smoothness.get(cssValue);
	}

	public boolean isCSSAvoidObstructions(){
		String cssValue = engine.retrieveCSSProperty(element, "avoidObstructions", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions().getDefaultValue(); 
			return (Boolean)defaultValue;
		}
		return (Boolean)Boolean.parseBoolean(cssValue);
	}

	public boolean isCSSClosestDistance(){
		String cssValue = engine.retrieveCSSProperty(element, "closestDistance", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance().getDefaultValue(); 
			return (Boolean)defaultValue;
		}
		return (Boolean)Boolean.parseBoolean(cssValue);
	}

	public JumpLinkStatus getCSSJumpLinkStatus(){
		String cssValue = engine.retrieveCSSProperty(element, "jumpLinkStatus", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus().getDefaultValue(); 
			return (JumpLinkStatus)defaultValue;
		}
		return JumpLinkStatus.get(cssValue);
	}

	public JumpLinkType getCSSJumpLinkType(){
		String cssValue = engine.retrieveCSSProperty(element, "jumpLinkType", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType().getDefaultValue(); 
			return (JumpLinkType)defaultValue;
		}
		return JumpLinkType.get(cssValue);
	}

	public boolean isCSSJumpLinksReverse(){
		String cssValue = engine.retrieveCSSProperty(element, "jumpLinksReverse", "");
		if (cssValue == null){
			Object defaultValue = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse().getDefaultValue(); 
			return (Boolean)defaultValue;
		}
		return (Boolean)Boolean.parseBoolean(cssValue);
	}
}
