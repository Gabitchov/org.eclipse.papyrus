/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;


/**
 * Interface for Edit Parts that are responsible of the display of a shape. 
 * <p>
 * This is currently only a marker interface, no method are planned to be added yet.
 * </p>
 */
public interface IShapeCompartmentEditPart {

	/** type given to the view model of this edit part */
	public static final String VIEW_TYPE = "compartment_shape_display";
}
