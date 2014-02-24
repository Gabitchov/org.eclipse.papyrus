/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.ExternalReferenceEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;

/**
 * The EditPolicyProvider for {@link ExternalReferenceEditPolicy} It provides an {@link ExternalReferenceEditPolicy} for Papyrus edit parts, when the
 * ServicesRegistry is available
 * This edit policy in only installed on Shapes (Graphical Edges are typically owned by the Diagram, which makes it difficult
 * to determine whether they are imported or not)
 *
 * @author Camille Letavernier
 */
public class ExternalReferenceEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation createOperation = (CreateEditPoliciesOperation)operation;
			try {
				if(ServiceUtilsForEditPart.getInstance().getServiceRegistry(createOperation.getEditPart()) != null) {
					return createOperation.getEditPart().getModel() instanceof Shape;
				}
			} catch (ServiceException ex) {
				//Do nothing: the services registry is not available.
			}
		}

		return false;
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(ExternalReferenceEditPolicy.EDIT_POLICY_ROLE, new ExternalReferenceEditPolicy());
	}

}
