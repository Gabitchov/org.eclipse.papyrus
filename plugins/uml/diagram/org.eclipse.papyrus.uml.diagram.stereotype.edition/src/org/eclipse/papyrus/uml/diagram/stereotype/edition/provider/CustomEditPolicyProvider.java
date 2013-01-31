/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.stereotype.edition.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypeMultilinePropertyEditPart;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies.AppliedStereotypeCommentCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies.AppliedStereotypeCompartmentEditPolicy;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;

/**
 * this is an editpolicy provider in charge to install a policy to create a AssociationClass
 * 
 * @author Patrick Tessier
 */
public class CustomEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {


	/**
	 * 
	 * {@inheritDoc}
	 */
	public void createEditPolicies(EditPart editPart) {
		if(editPart instanceof IPapyrusEditPart){
		if(!(editPart instanceof AppliedStereotypeMultilinePropertyEditPart)) {

			if(editPart instanceof IPrimaryEditPart) {
				if(UMLUtil.resolveUMLElement(editPart) != null) {
					editPart.installEditPolicy(AppliedStereotypeCommentCreationEditPolicy.APPLIED_STEREOTYPE_COMMENT, new AppliedStereotypeCommentCreationEditPolicy());
				}

			}
			if(editPart instanceof NamedElementEditPart) {
				editPart.installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeCompartmentEditPolicy());
			}
		}
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart) && !(epOperation.getEditPart() instanceof ConnectionEditPart)) {
			return false;
		}

		EditPart gep = epOperation.getEditPart();
		if(!(gep instanceof AppliedStereotypeMultilinePropertyEditPart)) {

			if(gep instanceof IPrimaryEditPart) {
				if(UMLUtil.resolveUMLElement(gep) != null) {
					return true;
				}

			}
			if(gep instanceof NamedElementEditPart) {
				return true;
			}
		}

		return false;
	}


}
