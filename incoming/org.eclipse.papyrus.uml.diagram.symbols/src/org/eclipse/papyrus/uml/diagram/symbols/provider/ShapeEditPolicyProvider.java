/*****************************************************************************
 * Copyright (c) 2010-2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *		Arthur Daussy - arthur.daussy@atos.net - 395920: [Block Diagram Definition] All element contained by a block should be able to be linked to constraint or comment
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.symbols.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.ShapeCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;

/**
 * Edit policy provider for the shape compartement
 */
public class ShapeEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof IGraphicalEditPart)) {
			return false;
		}

		// Make sure this concern Block Definition Diagram only
		IGraphicalEditPart gep = (IGraphicalEditPart)epOperation.getEditPart();
		// Provides for edit parts that represent nodes in Block Definition diagram
		if(gep instanceof NamedElementEditPart) {
			return true;
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createEditPolicies(EditPart editPart) {
		// add behavior for the shapes display
		if(editPart instanceof NamedElementEditPart) { // add to Block Property Composite and Block Composite 
			editPart.installEditPolicy(ShapeCompartmentEditPolicy.SHAPE_COMPARTMENT_EDIT_POLICY, new ShapeCompartmentEditPolicy());
		}
	}
}
