/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;

/**
 * This XY layout edit policy consults children parts for chosing a minimum size.
 * 
 * @see XYLayoutEditPolicy
 * 
 */
public class CompartmentXYLayoutEditPolicy extends XYLayoutEditPolicy {

	/**
	 * Get the minimum size from child edit part rather than imposing a constant one.
	 * 
	 * @see org.eclipse.gef.editpolicies.XYLayoutEditPolicy#getMinimumSizeFor(org.eclipse.gef.GraphicalEditPart)
	 * @param child
	 *        the child
	 * @return the minumum size
	 */
	@Override
	protected Dimension getMinimumSizeFor(GraphicalEditPart child) {
		if(child.getFigure() != null) {
			return child.getFigure().getMinimumSize();
		} else {
			return super.getMinimumSizeFor(child);
		}
	}
}
