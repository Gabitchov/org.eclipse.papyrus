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
package org.eclipse.papyrus.diagram.common.commands;

import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;

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

	/** the visualID of the compartment to show */
	protected String compartmentType;

	/** the property ID */
	private static final String propertyID = "notation.View.visible"; //$NON-NLS-1$

	/** the property name */
	private static final String propertyName = "Visibility"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param value
	 * @param semanticHint
	 */
	public ShowHideCompartmentRequest(Object value, String compartmentType) {
		super(propertyName, propertyID, value);
		this.compartmentType = compartmentType;
	}

	/**
	 * Return {@link #compartmentType}
	 * 
	 * @return
	 *         {@link #compartmentType}
	 */
	public String getCompartmentType() {
		return this.compartmentType;
	}




}
