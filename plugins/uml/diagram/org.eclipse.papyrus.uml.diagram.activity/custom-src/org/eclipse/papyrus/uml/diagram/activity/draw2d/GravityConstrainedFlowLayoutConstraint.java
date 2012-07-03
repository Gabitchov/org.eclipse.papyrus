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
package org.eclipse.papyrus.uml.diagram.activity.draw2d;

import org.eclipse.gmf.runtime.draw2d.ui.figures.GravityConstrainedFlowLayout;

/**
 * This class is used to pass a Constraint to a {@link GravityConstrainedFlowLayout}. This is a workaround to allow this
 * constraint in a generate way
 * 
 * @author adaussy
 * 
 */
public class GravityConstrainedFlowLayoutConstraint {

	/**
	 * Constraint use by {@link GravityConstrainedFlowLayout}
	 */
	private Integer align = new Integer(GravityConstrainedFlowLayout.ALIGN_TOPLEFT);

	public int getAlign() {
		return align;
	}

	public void setAlign(int align) {
		this.align = align;
	}
}
