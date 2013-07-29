/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (patrick.tessier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;


/**
 * this edit part is used to not display scrollbar in the compartment.
 *
 */
public class NoScrollBarShapeCompartmentEditPart extends
		ShapeCompartmentEditPart {

	public NoScrollBarShapeCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		((ResizableCompartmentFigure)getFigure()).getScrollPane().setScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
	}
}
