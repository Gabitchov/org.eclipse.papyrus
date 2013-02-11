/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.editpolicies;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper;


/**
 * An edit policy provider for MarkerEvenListenerEditPolicy
 *
 */
public class MarkerEventListenerEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		EditPart editPart = epOperation.getEditPart();
		if(!(editPart instanceof GraphicalEditPart)) {
			return false;
		}

		EditingDomain domain = EMFHelper.resolveEditingDomain(editPart);
		if(domain == null) {
			return false;
		}

		ResourceSet resourceSet = domain.getResourceSet();
		return CSSHelper.isCSSSupported(resourceSet);
	}

	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(MarkerEventListenerEditPolicy.ROLE, new MarkerEventListenerEditPolicy());
	}

}
