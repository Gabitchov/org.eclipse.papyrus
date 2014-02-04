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
package org.eclipse.papyrus.infra.gmfdiag.css.style;

import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;

public interface CSSRoutingStyle extends CSSRoundedCornersStyle {

	public Routing getCSSRouting();


	public Smoothness getCSSSmoothness();


	public boolean isCSSAvoidObstructions();


	public boolean isCSSClosestDistance();


	public JumpLinkStatus getCSSJumpLinkStatus();


	public JumpLinkType getCSSJumpLinkType();


	public boolean isCSSJumpLinksReverse();

}
