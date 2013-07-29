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
package org.eclipse.papyrus.uml.diagram.common.figure.layout;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.CResizableCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ManualCompartmentLayoutManager;

/**
 * this is a tool kit to manage Manual layout.
 */

public class ManualCompartmentToolBox implements ILayoutToolBox {

	/** The MANUA l_ layout. */
	protected final String MANUAL_LAYOUT = "Manual_Layout";

	/**
	 * {@inheritDoc}
	 */
	public EditPolicy getEditPolicy() {
		return new CResizableCompartmentEditPolicy();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLayout() {
		return MANUAL_LAYOUT;
	}

	/**
	 * {@inheritDoc}
	 */
	public AbstractLayout getFigureLayout() {
		return new ManualCompartmentLayoutManager();
	}

}
