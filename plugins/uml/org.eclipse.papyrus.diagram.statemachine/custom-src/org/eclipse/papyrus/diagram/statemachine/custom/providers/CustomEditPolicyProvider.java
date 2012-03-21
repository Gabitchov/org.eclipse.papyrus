/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.custom.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.diagram.common.editpolicies.ApplyStereotypeEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.NavigationEditPolicy;
import org.eclipse.papyrus.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.uml2.uml.Region;

/**
 * this is an editpolicy provider in charge to install a policy to navigate between diagrams and elements
 * 
 */
public class CustomEditPolicyProvider implements IEditPolicyProvider {

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void addProviderChangeListener(IProviderChangeListener listener) {

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.OPEN_ROLE, new NavigationEditPolicy());
		editPart.installEditPolicy(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST, new ApplyStereotypeEditPolicy());
		if(editPart instanceof IPrimaryEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new HyperLinkPopupBarEditPolicy());
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof IGraphicalEditPart)) {
			return false;
		}
		IGraphicalEditPart gep = (IGraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		// don't register on region : there are IPrimaryEditPart but
		// we don't really want this kind of behavior because they haven't
		// a real shape, it looks like a compartment
		if (gep.resolveSemanticElement() instanceof Region) {
			return false;
		}
		if(PackageEditPart.MODEL_ID.equals(diagramType)) {
			return true;
		}


		return false;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void removeProviderChangeListener(IProviderChangeListener listener) {

	}

}
