/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.policy;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;


public class CustomizableDropEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;

		try {
			ServicesRegistry registry = ServiceUtilsForEditPart.getInstance().getServiceRegistry(epOperation.getEditPart());
			return registry != null;
		} catch (ServiceException e) {
			return false;
		}
	}

	public void createEditPolicies(EditPart editPart) {
		EditPolicy defaultDropEditPolicy = editPart.getEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE);
		EditPolicy defaultCreationEditPolicy = editPart.getEditPolicy(EditPolicyRoles.CREATION_ROLE);

		CustomizableDropEditPolicy dropEditPolicy = new CustomizableDropEditPolicy(defaultDropEditPolicy, defaultCreationEditPolicy);

		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, null);
		editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, dropEditPolicy);
	}

}