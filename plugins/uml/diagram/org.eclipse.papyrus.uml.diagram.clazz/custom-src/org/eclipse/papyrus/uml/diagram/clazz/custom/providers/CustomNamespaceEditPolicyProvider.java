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
package org.eclipse.papyrus.uml.diagram.clazz.custom.providers;

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
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomComponentContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomComponentContextLinkSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomDataTypeContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomDataTypeContextLinkSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomEnumerationContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomEnumerationContextLinkSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomInformationItemContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomInterfaceContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomInterfaceContextLinkSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomModelContextLinkSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomModelContextLinkSemanticEditPolicyTN;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomPackageContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomPrimitiveTypeContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomPrimitiveTypeContextLinkSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomSignalContextLinkSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomSignalContextLinkSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InformationItemEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InformationItemEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SignalEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SignalEditPartCN;
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
		// install policy for ComponentEditPart
		if(editPart instanceof ComponentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomComponentContextLinkSemanticEditPolicy());
		}
		if(editPart instanceof ComponentEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomComponentContextLinkSemanticEditPolicyCN());
		}

		// install policy for InterfaceEditPart
		if(editPart instanceof InterfaceEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInterfaceContextLinkSemanticEditPolicy());
		}
		if(editPart instanceof InterfaceEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInterfaceContextLinkSemanticEditPolicyCN());
		}

		// install policy for DataTypeEditPart
		if(editPart instanceof DataTypeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDataTypeContextLinkSemanticEditPolicy());
		}
		if(editPart instanceof DataTypeEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDataTypeContextLinkSemanticEditPolicyCN());
		}

		// install policy for EnumerationEditPart
		if(editPart instanceof EnumerationEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomEnumerationContextLinkSemanticEditPolicy());
		}
		if(editPart instanceof EnumerationEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomEnumerationContextLinkSemanticEditPolicyCN());
		}

		// install policy for InformationItemEditPart
		if(editPart instanceof InformationItemEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInformationItemContextLinkSemanticEditPolicy());
		}
		if(editPart instanceof InformationItemEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInformationItemContextLinkSemanticEditPolicy());
		}

		// install policy for PrimitiveTypeEditPart
		if(editPart instanceof PrimitiveTypeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomPrimitiveTypeContextLinkSemanticEditPolicy());
		}
		if(editPart instanceof PrimitiveTypeEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomPrimitiveTypeContextLinkSemanticEditPolicyCN());
		}

		// install policy for ModelEditPart
		if(editPart instanceof ModelEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomModelContextLinkSemanticEditPolicyCN());
		}
		if(editPart instanceof ModelEditPartTN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomModelContextLinkSemanticEditPolicyTN());
		}

		// install policy for PackageEditPart
		if(editPart instanceof PackageEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomPackageContextLinkSemanticEditPolicy());
		}
		//		if (editPart instanceof PackageEditPartCN){	
		//			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new C);
		//		}

		// install policy for SignalEditPart
		if(editPart instanceof SignalEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomSignalContextLinkSemanticEditPolicy());
		}
		if(editPart instanceof SignalEditPartCN) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomSignalContextLinkSemanticEditPolicyCN());
		}
	}
}
