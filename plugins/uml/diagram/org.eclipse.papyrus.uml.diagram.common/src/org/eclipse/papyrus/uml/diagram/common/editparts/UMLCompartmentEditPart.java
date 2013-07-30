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
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ApplyStereotypeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.service.ApplyStereotypeRequest;

/**
 * This edit part manages the application and unapplication of stereotypes on
 * creation.
 */
public class UMLCompartmentEditPart extends PapyrusCompartmentEditPart {

	/**
	 * Creates a new UMLCompartmentEditPart.
	 * 
	 * @param model
	 *        the view managed by this edit part
	 */
	public UMLCompartmentEditPart(EObject model) {
		super(model);
	}

	@Override
	public boolean isSelectable() {
		// See bug 351433 : https://bugs.eclipse.org/bugs/show_bug.cgi?id=351433
		// This fix changes the behavior of selecting a Class : until now, we
		// had
		// to select a class before being able to select one of its operations
		// or
		// attributes. With this fix, we can select directly the operations or
		// attributes, which means it is now harder to select the class
		// (For Drag&Drop or resizing)
		return getFigure().isShowing(); // FIXME : This is a temporary fix
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
