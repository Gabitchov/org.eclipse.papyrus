/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.ApplyStereotypeEditPolicy;
import org.eclipse.papyrus.diagram.common.service.ApplyStereotypeRequest;


/**
 * This edit part manages the application and unapplication of stereotypes on creation.
 */
public class UMLCompartmentEditPart extends CompartmentEditPart {

	/**
	 * Creates a new UMLCompartmentEditPart.
	 * 
	 * @param model
	 *        the view managed by this edit part
	 */
	public UMLCompartmentEditPart(EObject model) {
		super(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// adds the stereotype application edit policy
		installEditPolicy(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST, new ApplyStereotypeEditPolicy());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST.equals(request.getType())) {
			return this;
		}
		return super.getTargetEditPart(request);
	}
}
