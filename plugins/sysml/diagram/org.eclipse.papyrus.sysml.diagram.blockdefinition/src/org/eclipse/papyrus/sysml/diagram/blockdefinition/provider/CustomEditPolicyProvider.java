/*****************************************************************************
 * Copyright (c) 2010-2012 CEA LIST.
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
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultCreationEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultGraphicalNodeEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultXYLayoutEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ResizeableListCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.CustomBlockCompositeSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.CustomDefaultSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.AssociationEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.DimensionEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedNodeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortChildLabelEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowSpecificationEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.UnitEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ValueTypeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.policy.CustomDuplicatePasteEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementChildLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementLinkEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ActorEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.DataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.EnumerationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.SignalEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy;

/**
 * Edit policy provider for the Block definition diagram (install or remove policies on edit part creation).
 */
public class CustomEditPolicyProvider extends BlockDefinitionDiagramEditPolicyProvider {

	@Override
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

		if(gep instanceof AbstractElementChildLabelEditPart) {
			return true;
		}

		if(gep instanceof BlockDefinitionDiagramEditPart) {
			return true;
		}

		return super.provides(operation);
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		super.createEditPolicies(editPart);

		if(editPart instanceof BlockDefinitionDiagramEditPart) {
			editPart.installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new CustomDuplicatePasteEditPolicy());
			// no installation of other policies. 
			return;
		}

		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());

		// Legacy management of new Nodes / Edges with nodes from Class Diagram and navigation support (installed by edit policy provider in Class Diagram)
		if((editPart instanceof PackagePackageableElementCompartmentEditPartCN) || (editPart instanceof PackagePackageableElementCompartmentEditPart)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultSemanticEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
			editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE, new DefaultXYLayoutEditPolicy());
			editPart.installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new CustomDuplicatePasteEditPolicy());

		}

		if((editPart instanceof ModelPackageableElementCompartmentEditPartCN) || (editPart instanceof ModelPackageableElementCompartmentEditPartTN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultSemanticEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
			editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE, new DefaultXYLayoutEditPolicy());
			editPart.installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new CustomDuplicatePasteEditPolicy());

		}

		if((editPart instanceof PackageEditPart) || (editPart instanceof PackageEditPartCN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
			editPart.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultGraphicalNodeEditPolicy());
		}

		if((editPart instanceof ModelEditPartTN) || (editPart instanceof ModelEditPartCN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
			editPart.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultGraphicalNodeEditPolicy());
		}

		if((editPart instanceof InstanceSpecificationEditPart) || (editPart instanceof InstanceSpecificationEditPartCN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
			editPart.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultGraphicalNodeEditPolicy());
		}

		if((editPart instanceof InstanceSpecificationSlotCompartmentEditPart) || (editPart instanceof InstanceSpecificationSlotCompartmentEditPartCN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultSemanticEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
		}

		if((editPart instanceof ConstraintEditPart) || (editPart instanceof ConstraintEditPartCN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
			editPart.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultGraphicalNodeEditPolicy());
		}

		if((editPart instanceof CommentEditPart) || (editPart instanceof CommentEditPartCN)) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
			editPart.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultGraphicalNodeEditPolicy());
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
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomBlockCompositeSemanticEditPolicy());
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

		if(editPart instanceof FlowPortChildLabelEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}

		if(editPart instanceof FlowPortAffixedNodeEditPart || editPart instanceof PortAffixedNodeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}

		if(editPart instanceof AbstractElementChildLabelEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}

	

	}
}
