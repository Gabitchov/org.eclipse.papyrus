/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import java.util.List;

import org.eclipse.gef.requests.CreateRequest;

/**
 * Request to apply stereotype on elements
 */
public class ApplyStereotypeRequest extends CreateRequest {

	/** type of the Apply stereotype request */
	public static String APPLY_STEREOTYPE_REQUEST = "applyStereotype";

	/** key for the new edit part name base extended metadata */
	public static String NEW_EDIT_PART_NAME = "editPartNameBase";

	/** stereotypes to apply */
	final protected List<String> stereotypes;

	/**
	 * Creates a new ApplyStereotypeRequest
	 * 
	 * @param objects
	 *        the list of stereotypes to apply, identified by their
	 *        qualified names
	 */
	public ApplyStereotypeRequest(List<String> stereotypes) {
		super();
		this.stereotypes = stereotypes;
		// initialize the type of this request
		setType(APPLY_STEREOTYPE_REQUEST);
	}

	/**
	 * Returns the list of stereotypes to apply, identified by their qualified
	 * names
	 * 
	 * @return the list of stereotypes to apply, identified by their qualified
	 *         names, or an empty list
	 */
	public List<String> getStereotypesToApply() {
		return stereotypes;
	}
}
