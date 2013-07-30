/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This class allows to represent the title of a compartment in a the Show/Hide
 * Compartment Action
 * 
 * 
 * 
 */
public class CompartmentTitleRepresentation {

	/**
	 * the compartment view
	 */
	private View view;

	/**
	 * the editpart which owns the view
	 */
	private EditPart parent;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        the parent editpart
	 * @param view
	 *        the view
	 */
	public CompartmentTitleRepresentation(EditPart parent, View view) {
		this.parent = parent;
		this.view = view;
	}

	/**
	 * 
	 * @return <code>true</code> if the title of the compartment is displayed
	 *         and <code>false</code> if not
	 */
	public boolean isTitleVisible() {
		return CompartmentUtils.isCompartmentTitleVisible(view);
	}

	/**
	 * 
	 * @return the real object represented by this class
	 */
	public Object getRealObject() {
		return view;
	}

	/**
	 * 
	 * @return the parent editpart
	 */
	public EditPart getParent() {
		return this.parent;
	}

}
