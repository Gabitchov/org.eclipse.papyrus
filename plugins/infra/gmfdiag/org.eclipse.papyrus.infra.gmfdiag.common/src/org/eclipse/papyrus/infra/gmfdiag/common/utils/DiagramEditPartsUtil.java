/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Different utility methods to manage and manipulate edit parts in diagrams.
 */
public class DiagramEditPartsUtil {

	/**
	 * Returns the edit part that controls the given view.
	 * 
	 * @param view
	 *        the view for which the edit part should be found. This should not be <code>null</code>
	 * @param anyEditPart
	 *        any edit part from which to get the edit part registry
	 * 
	 * @return the edit part that controls the given view or <code>null</code> if none was found
	 */
	public static EditPart getEditPartFromView(View view, EditPart anyEditPart) {
		if(view != null && anyEditPart !=null) {
			return (EditPart)anyEditPart.getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

}
