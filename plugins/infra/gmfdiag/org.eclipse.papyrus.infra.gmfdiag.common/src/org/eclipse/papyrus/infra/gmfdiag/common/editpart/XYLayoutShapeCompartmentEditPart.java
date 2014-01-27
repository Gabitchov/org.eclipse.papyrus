/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.XYLayoutWithConstrainedResizedEditPolicy;

/**
 * 
 * This compartment edit part must be used for CompartmentEditPart with XYlayoutEditPolicy
 * This class replace default editpolicy by ours 424942: [Diagram] Papyrus shall ease resizing of model elements owning children
 * 
 */
public class XYLayoutShapeCompartmentEditPart extends ShapeCompartmentEditPart {


	/**
	 * 
	 * Constructor.
	 * 
	 * @param view
	 */
	public XYLayoutShapeCompartmentEditPart(final View view) {
		super(view);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart#createDefaultEditPolicies()
	 * 
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutWithConstrainedResizedEditPolicy());
	}

}
