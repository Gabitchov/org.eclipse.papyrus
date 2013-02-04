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
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.infra.gmfdiag.hyperlink.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.hyperlink.editpolicies.NavigationEditPolicy;

/**
 * An EditPolicyProvider for Navigation and Hyperlinks
 * 
 * @author Camille Letavernier
 * 
 */
public class HyperlinkEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * This provider can handle GraphicalEditParts
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
			return epOperation.getEditPart() instanceof IGraphicalEditPart;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Installs the Hyperlink and Navigation edit policies
	 */
	public void createEditPolicies(EditPart editPart) {
		if(editPart instanceof IPrimaryEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new HyperLinkPopupBarEditPolicy());
		}
		editPart.installEditPolicy(NavigationEditPolicy.NAVIGATION_POLICY, new NavigationEditPolicy());

	}

}
