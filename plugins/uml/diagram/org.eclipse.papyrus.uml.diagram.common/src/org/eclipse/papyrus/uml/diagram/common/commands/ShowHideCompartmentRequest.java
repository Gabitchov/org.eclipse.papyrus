/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * This request is used to show/hide a compartment.
 * 
 */
public class ShowHideCompartmentRequest extends ChangePropertyValueRequest {

	/** value to hide the compartment */
	public static final boolean HIDE = false;

	/** value to show the compartment */
	public static final boolean SHOW = true;

	/** type of this request */
	public static final String SHOW_HIDE_COMPARTMENT = "Show/Hide Compartment"; //$NON-NLS-1$

	/** thethe view to show */
	protected View compartmentType;

	/** the property ID */
	private static final String propertyID = "notation.View.visible"; //$NON-NLS-1$

	/** the property name */
	private static final String propertyName = "Visibility"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param value
	 *        This parameter can be :
	 *        <ul>
	 *        <li> {@link ShowHideCompartmentRequest#SHOW}</li>
	 *        <li> {@link ShowHideCompartmentRequest#HIDE}</li>
	 *        </ul>
	 * @param semanticHint
	 *        the semanticHint for the compartment
	 */
	public ShowHideCompartmentRequest(Object value, View compartmentView) {
		super(propertyName, propertyID, value);
		this.compartmentType = compartmentView;
	}

	/**
	 * Return {@link #compartmentType}
	 * 
	 * @return {@link #compartmentType}
	 */
	public View  getCompartment() {
		return this.compartmentType;
	}

}
