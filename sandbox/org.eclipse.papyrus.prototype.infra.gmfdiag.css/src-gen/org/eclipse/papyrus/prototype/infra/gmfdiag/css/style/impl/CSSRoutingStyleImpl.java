package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSRoutingStyleImpl implements CSSRoutingStyle{
	
	private RoutingStyle routingStyle;

	public CSSRoutingStyleImpl(RoutingStyle routingStyle){
		this.routingStyle = routingStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSRoundedBendpointsRadius(){
		return routingStyle.getRoundedBendpointsRadius();
	}

	public Routing getCSSRouting(){
		return routingStyle.getRouting();
	}

	public Smoothness getCSSSmoothness(){
		return routingStyle.getSmoothness();
	}

	public boolean isCSSAvoidObstructions(){
		return routingStyle.isAvoidObstructions();
	}

	public boolean isCSSClosestDistance(){
		return routingStyle.isClosestDistance();
	}

	public JumpLinkStatus getCSSJumpLinkStatus(){
		return routingStyle.getJumpLinkStatus();
	}

	public JumpLinkType getCSSJumpLinkType(){
		return routingStyle.getJumpLinkType();
	}

	public boolean isCSSJumpLinksReverse(){
		return routingStyle.isJumpLinksReverse();
	}
}
