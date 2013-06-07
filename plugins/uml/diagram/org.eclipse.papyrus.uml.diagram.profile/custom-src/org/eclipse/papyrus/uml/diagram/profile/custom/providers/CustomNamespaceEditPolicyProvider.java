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
package org.eclipse.papyrus.uml.diagram.profile.custom.providers;

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
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomAssociationBranchContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomAssociationContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomAssociationNodeContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomConstraintCNContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomConstraintContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomDataTypeCNContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomDataTypeContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomEnumerationCNContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomEnumerationContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomExtensionContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomModelCNContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomModelContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomPackageCNContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomPackageContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomPrimitiveTypeCNContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomPrimitiveTypeContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomProfileCNContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomProfileContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomStereotypeCNContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomStereotypeContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeEditPartCN;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Namespace;

/**
 * Edit Policy provider to manage custom creation command for Context links
 * 
 */
public class CustomNamespaceEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		EditPart editPart = epOperation.getEditPart();
		if(editPart == null) {
			return false;
		}
		EObject eElement = EMFHelper.getEObject(editPart);
		if(!(eElement instanceof Namespace) && !(eElement instanceof Constraint)) {
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

	/**
	 * {@inheritDoc}
	 */
	public void createEditPolicies(EditPart editPart) {
		// install policy for Packages
		if(editPart instanceof PackageEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomPackageContextLinkSemanticEditPolicy());
			return;
		}
		if(editPart instanceof PackageEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomPackageCNContextLinkSemanticEditPolicy());
			return;
		}
		// install policy for Packages
		if(editPart instanceof ModelEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomModelCNContextLinkSemanticEditPolicy());
			return;
		}
		if(editPart instanceof ModelEditPartTN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomModelContextLinkSemanticEditPolicy());
			return;
		}
		// install policy for Profile Edit Parts
		if(editPart instanceof ProfileEditPartTN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomProfileContextLinkSemanticEditPolicy());
			return;
		}
		if(editPart instanceof ProfileEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomProfileCNContextLinkSemanticEditPolicy());
			return;
		}
		// stereotype
		if(editPart instanceof StereotypeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomStereotypeContextLinkSemanticEditPolicy());
			return;
		}
		if(editPart instanceof StereotypeEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomStereotypeCNContextLinkSemanticEditPolicy());
			return;
		}
		// install policy for Association Edit Parts
		if(editPart instanceof AssociationBranchEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomAssociationBranchContextLinkSemanticEditPolicy());
			return;
		}
		if(editPart instanceof AssociationEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomAssociationContextLinkSemanticEditPolicy());
			return;
		}
		if(editPart instanceof AssociationNodeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomAssociationNodeContextLinkSemanticEditPolicy());
			return;
		}
		// datatype
		if(editPart instanceof DataTypeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDataTypeContextLinkSemanticEditPolicy());
			return;
		}
		if(editPart instanceof DataTypeEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDataTypeCNContextLinkSemanticEditPolicy());
			return;
		}
		// datatype
		if(editPart instanceof PrimitiveTypeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomPrimitiveTypeContextLinkSemanticEditPolicy());
			return;
		}
		if(editPart instanceof PrimitiveTypeEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomPrimitiveTypeCNContextLinkSemanticEditPolicy());
			return;
		}
		// Enumeration
		if(editPart instanceof EnumerationEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomEnumerationContextLinkSemanticEditPolicy());
			return;
		}
		if(editPart instanceof EnumerationEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomEnumerationCNContextLinkSemanticEditPolicy());
			return;
		}
		// Extension
		if(editPart instanceof ExtensionEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomExtensionContextLinkSemanticEditPolicy());
			return;
		}
		// Constraint (to allow creation of the link on a constraint that already has a context )
		if(editPart instanceof ConstraintEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomConstraintContextLinkSemanticEditPolicy());
			return;
		}
		if(editPart instanceof ConstraintEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomConstraintCNContextLinkSemanticEditPolicy());
			return;
		}
	}
}
