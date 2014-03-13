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
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.eclipse.gef.tools.ResizeTracker;
import org.eclipse.papyrus.uml.diagram.common.dragtracker.NoScrollDragEditPartsTrackerEx;
import org.eclipse.papyrus.uml.diagram.common.dragtracker.NoScrollResizeTracker;
/**
 * this editppolicy is used to constraint the move of one figure into its container without scroll bars 
 *
 * this class was used to remove scrollbar
 * Now it is not used (but can be when this functionality will be operational)
 */
public class NoScrollClassifierResizableShapeEditPolicy extends EncapsulatedClassifierResizableShapeEditPolicy {

	/**
	 * this code has been overloaded in order to constraint the resize into its container without scroll bars
	 *{@inheritDoc} 
	 */
	
	@Override
	protected ResizeTracker getResizeTracker(int direction) {
		return new NoScrollResizeTracker((GraphicalEditPart) getHost(), direction);
	}
	
	/**
	 * this code has been overloaded in order to constraint the move into its container without scroll bars
	 *{@inheritDoc} 
	 */
	@Override
	protected DragEditPartsTracker getDragTracker() {
		return new NoScrollDragEditPartsTrackerEx(getHost());
	}
}
