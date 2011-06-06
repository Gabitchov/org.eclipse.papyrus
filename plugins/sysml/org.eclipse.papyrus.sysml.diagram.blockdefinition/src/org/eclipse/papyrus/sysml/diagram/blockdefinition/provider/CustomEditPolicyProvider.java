/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.common.editparts.ResizeableListCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.ConstraintSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.CustomDefaultSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.InstanceSpecificationSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.PackageCompartmentSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.PackageSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.AssociationEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.DimensionEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowSpecificationEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.UnitEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ValueTypeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementLinkEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ActorEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.DataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.EnumerationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.SignalEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.UsageEditPart;

/**
 * Edit policy provider for the Block definition diagram (install or remove policies on edit part creation).
 */
public class CustomEditPolicyProvider extends BlockDefinitionDiagramEditPolicyProvider {

	public boolean provides(IOperation operation) {

		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof IGraphicalEditPart)) {
			return false;
		}
		
		// Make sure this concern Block Definition Diagram only
		IGraphicalEditPart gep = (IGraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// Provides for edit parts that represent nodes in Block Definition diagram
		if(gep instanceof AbstractElementEditPart) {
			return true;
		}
		
		// Provides for edit parts that represent edges in Block Definition diagram
		if(gep instanceof AbstractElementLinkEditPart) {
			return true;
		}
		
		if(gep instanceof ResizeableListCompartmentEditPart) {
			return true;
		}

		return super.provides(operation);
	}

	public void createEditPolicies(EditPart editPart) {
		super.createEditPolicies(editPart);

		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());

		// Navigation policy temporary disabled (work in progress on decorator service).
		if (editPart instanceof IPrimaryEditPart) {
		//	editPart.removeEditPolicy(NavigationEditPolicy.NAVIGATION_POLICY);
		//	editPart.removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		}
		
		// Legacy management of new Nodes / Edges with nodes from Class Diagram
		if((editPart instanceof PackagePackageableElementCompartmentEditPartCN) || (editPart instanceof PackagePackageableElementCompartmentEditPart)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PackageCompartmentSemanticEditPolicy());
		}

		if((editPart instanceof ModelPackageableElementCompartmentEditPartCN) || (editPart instanceof ModelPackageableElementCompartmentEditPartTN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PackageCompartmentSemanticEditPolicy());
		}
		
		if((editPart instanceof PackageEditPart) || (editPart instanceof PackageEditPartCN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PackageSemanticEditPolicy());
		}

		if((editPart instanceof ModelEditPartTN) || (editPart instanceof ModelEditPartCN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PackageSemanticEditPolicy());
		}
		
		if((editPart instanceof InstanceSpecificationEditPart) || (editPart instanceof InstanceSpecificationEditPartCN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InstanceSpecificationSemanticEditPolicy());
		}
		
		if((editPart instanceof ConstraintEditPart) || (editPart instanceof ConstraintEditPartCN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ConstraintSemanticEditPolicy());
		}
		
		// Legacy management of Comment / Constraint links
		if(editPart instanceof ActorEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof EnumerationEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof PrimitiveTypeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof ValueTypeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof DataTypeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof FlowSpecificationEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof InterfaceEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof SignalEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof ConstraintBlockEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof BlockEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof DimensionEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof UnitEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof DependencyEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof GeneralizationEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof UsageEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof AssociationEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		
		if(editPart instanceof InterfaceRealizationEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
	}
}
