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
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * this is an abstract editpart used to allow double click on XY layout compartment
 *
 */
public abstract class AbstractPackageableElementCompartmentEditPart extends ShapeCompartmentEditPart {

	public AbstractPackageableElementCompartmentEditPart(View view) {
		super(view);
	}
	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart#getDragTracker(org.eclipse.gef.Request)
	 *
	 */
	public DragTracker getDragTracker(Request req) {
		if (!supportsDragSelection())
			return super.getDragTracker(req);
		
		return new DragEditPartsTracker(this);
	}
}
