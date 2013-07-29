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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AutomaticCompartmentLayoutManager;

/**
 * The Class AutomaticCompartmentToolBox.
 */
public class AutomaticCompartmentToolBox implements ILayoutToolBox {

	/** The AUTOMATI c_ layout. */
	protected final String AUTOMATIC_LAYOUT = "Automatic_Layout";

	/**
	 * {@inheritDoc}
	 */
	public EditPolicy getEditPolicy() {
		return new ResizableCompartmentEditPolicy();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLayout() {
		return AUTOMATIC_LAYOUT;
	}

	/**
	 * {@inheritDoc}
	 */
	public AbstractLayout getFigureLayout() {
		return new AutomaticCompartmentLayoutManager();
	}

}
