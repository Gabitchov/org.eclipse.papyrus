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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ApplyStereotypeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.NavigationEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseDiagramEditPart;

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
		editPart.installEditPolicy(NavigationEditPolicy.NAVIGATION_POLICY, new NavigationEditPolicy());
		editPart.installEditPolicy(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST, new ApplyStereotypeEditPolicy());
	
		if(editPart instanceof NamedElementEditPart ){
			editPart.installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeCompartmentEditPolicy());
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart)) {
			return false;
		}
		GraphicalEditPart gep = (GraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if(UseCaseDiagramEditPart.MODEL_ID.equals(diagramType)) {
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
