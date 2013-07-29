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

/**
 * this goal of this kind of class is to provide the good editpolicy and the
 * good layout to attach at the figure.
 */
public interface ILayoutToolBox {

	/**
	 * Gets the figure layout.
	 * 
	 * @return the figure layout
	 */
	public AbstractLayout getFigureLayout();

	/**
	 * Gets the edits the policy.
	 * 
	 * @return the edits the policy
	 */
	public EditPolicy getEditPolicy();

	/**
	 * Gets the layout, this is the constant is is put in the eannotation.
	 * 
	 * @return the layout constant
	 */
	public String getLayout();

}
