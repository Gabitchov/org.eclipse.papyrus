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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.dragtracker.NoScrollDragEditPartsTrackerEx;

/**
 * this class was used to remove scrollbar
 * Now it is not used (but can be when this fucntionality will operational)
 *
 */
public abstract class ConstrainedShapeNodeEditPart extends ShapeNodeEditPart {

	public ConstrainedShapeNodeEditPart(View view) {
		super(view);
	}
	/**
	 * the drag tracker has been specialized in order to constraint mvt inside its container without 
	 * scroll bar
	 * {@inheritDoc}
	 */
	@Override
	public DragTracker getDragTracker(Request request) {
		return new NoScrollDragEditPartsTrackerEx(this);
	}
}
