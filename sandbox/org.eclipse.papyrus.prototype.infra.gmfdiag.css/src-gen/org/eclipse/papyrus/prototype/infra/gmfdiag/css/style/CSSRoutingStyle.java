package org.eclipse.papyrus.prototype.infra.gmfdiag.css.style;

import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.emf.common.util.EList;

public interface CSSRoutingStyle extends CSSRoundedCornersStyle{
	
	public Routing getCSSRouting();


	public Smoothness getCSSSmoothness();


	public boolean isCSSAvoidObstructions();


	public boolean isCSSClosestDistance();


	public JumpLinkStatus getCSSJumpLinkStatus();


	public JumpLinkType getCSSJumpLinkType();


	public boolean isCSSJumpLinksReverse();

}
