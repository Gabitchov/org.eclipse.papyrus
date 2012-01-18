package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl;

import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.*;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public class CSSConnectorStyleImpl implements CSSConnectorStyle{
	
	private ConnectorStyle connectorStyle;

	public CSSConnectorStyleImpl(ConnectorStyle connectorStyle){
		this.connectorStyle = connectorStyle; 
	}

	////////////////////////////////////////////////
	//	Implements a getter for each CSS property //
	////////////////////////////////////////////////

	public int getCSSRoundedBendpointsRadius(){
		return connectorStyle.getRoundedBendpointsRadius();
	}

	public Routing getCSSRouting(){
		return connectorStyle.getRouting();
	}

	public Smoothness getCSSSmoothness(){
		return connectorStyle.getSmoothness();
	}

	public boolean isCSSAvoidObstructions(){
		return connectorStyle.isAvoidObstructions();
	}

	public boolean isCSSClosestDistance(){
		return connectorStyle.isClosestDistance();
	}

	public JumpLinkStatus getCSSJumpLinkStatus(){
		return connectorStyle.getJumpLinkStatus();
	}

	public JumpLinkType getCSSJumpLinkType(){
		return connectorStyle.getJumpLinkType();
	}

	public boolean isCSSJumpLinksReverse(){
		return connectorStyle.isJumpLinksReverse();
	}

	public int getCSSLineColor(){
		return connectorStyle.getLineColor();
	}

	public int getCSSLineWidth(){
		return connectorStyle.getLineWidth();
	}
}
