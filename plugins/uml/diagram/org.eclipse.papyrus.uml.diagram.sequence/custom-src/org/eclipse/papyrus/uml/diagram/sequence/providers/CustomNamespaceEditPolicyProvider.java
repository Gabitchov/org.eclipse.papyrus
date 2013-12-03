/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Boutheina Bannour (boutheina.bannour@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomInteractionContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomInteractionOperandContextLinkSemanticEditPolicy;
import org.eclipse.uml2.uml.Namespace;

/**
 * An edit policy provider to install
 * 
 * @author Boutheina Bannour
 * 
 */
public class CustomNamespaceEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		EditPart editPart = epOperation.getEditPart();
		if(editPart == null) {
			return false;
		}
		EObject eElement = EMFHelper.getEObject(editPart);
		if(!(eElement instanceof Namespace)) {
			return false;
		}
		try {
			// check whether the element is a papyrus element.
			ServicesRegistry registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(eElement);
			if(registry == null) {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
		// primary edit part is the toplevel (main) editpart
		return (editPart instanceof IPrimaryEditPart);
	}

	public void createEditPolicies(EditPart editPart) {
		// install policy for InteractionEditPart
		if(editPart instanceof InteractionEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInteractionContextLinkSemanticEditPolicy());
		}
		// install policy for InteractionOperandEditPart
		if(editPart instanceof InteractionOperandEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInteractionOperandContextLinkSemanticEditPolicy());
		}
	}
}
