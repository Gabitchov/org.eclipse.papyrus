/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.util;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;


public class NotationUtil {

	/**
	 * Retrieve the IGraphicalEditPart from the given Object
	 * 
	 * @param source
	 *        The object to resolve
	 * @return
	 *         The IGraphicalEditPart, or null if it couldn't be resolved
	 */
	public static IGraphicalEditPart resolveEditPart(Object source) {
		if(source instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart)source;
		}

		if(source instanceof IAdaptable) {
			return (IGraphicalEditPart)((IAdaptable)source).getAdapter(IGraphicalEditPart.class);
		}

		return null;
	}
}
