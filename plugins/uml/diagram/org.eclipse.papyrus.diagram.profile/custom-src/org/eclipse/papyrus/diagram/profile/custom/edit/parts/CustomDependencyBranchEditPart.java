/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.edit.parts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.edge.DashedEdgeFigure;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyNodeEditPart;

/**
 * this branch dependency can change its arrow
 * 
 */

public class CustomDependencyBranchEditPart extends org.eclipse.papyrus.diagram.profile.edit.parts.DependencyBranchEditPart {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomDependencyBranchEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart#refreshVisuals()
	 * 
	 */
	@Override
	protected void refreshVisuals() {
		if(getTarget() instanceof DependencyNodeEditPart) {
			if(getPrimaryShape() instanceof DashedEdgeFigure) {
				(getPrimaryShape()).setArrow(false);
			}
			super.refreshVisuals();
		}
	}
}
