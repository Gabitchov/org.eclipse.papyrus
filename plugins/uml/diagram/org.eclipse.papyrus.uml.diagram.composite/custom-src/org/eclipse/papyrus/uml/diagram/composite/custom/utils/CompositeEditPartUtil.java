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
package org.eclipse.papyrus.uml.diagram.composite.custom.utils;

import java.util.Iterator;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;

public class CompositeEditPartUtil {

	/**
	 * Retrieve the composite compartment edit part (should be the first ShapeCompartmentEditPart)
	 * 
	 * @param initialTarget
	 *        The original target
	 * @return the real expected target edit part (can return null)
	 */
	public static IGraphicalEditPart getCompositeCompartmentEditPart(IGraphicalEditPart parent) {
		IGraphicalEditPart compositeCompartmentEditPart = null;

		if(!(parent instanceof ShapeCompartmentEditPart)) {
			Iterator<?> it = parent.getChildren().iterator();
			while((it.hasNext()) && (compositeCompartmentEditPart == null)) {
				Object tmp = it.next();

				if(tmp instanceof ShapeCompartmentEditPart) {
					// Compartment found
					compositeCompartmentEditPart = (ShapeCompartmentEditPart)tmp;
				}
			}
		}

		return compositeCompartmentEditPart;
	}
}
