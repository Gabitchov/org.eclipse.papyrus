/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.internalblock.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultCreationEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultGraphicalNodeEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultXYLayoutEditPolicy;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockPropertyCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockPropertyStructureCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedNodeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.StructureCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.policy.CustomDuplicatePasteEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomBlockCompositeSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomBlockPropertyCompositeDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomBlockPropertyCompositeSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomBlockPropertyStructureCompartmentEditPartDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomDefaultSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomDiagramDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.CustomDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.EncapsulatedClassifierDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.StructureClassifierDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy.TypedElementDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementBorderEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementLinkEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConnectorEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConstraintEditPartCN;

/**
 * Custom edit policy provider.
 */
public class CustomEditPolicyProvider extends InternalBlockDiagramEditPolicyProvider {

	@Override
	public boolean provides(IOperation operation) {

		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof IGraphicalEditPart)) {
			return false;
		}

		// Make sure this concern Internal Block Diagram only
		IGraphicalEditPart gep = (IGraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// provides for the main diagram edit part
		if(gep instanceof InternalBlockDiagramEditPart) {
			return true;
		}

		// Provides for edit parts that represent nodes in Internal Block diagram
		if(gep instanceof AbstractElementEditPart) {
			return true;
		}
		if(gep instanceof AbstractElementBorderEditPart) {
			return true;
		}

		// Provides for edit parts that represent edges in Internal Block diagram
		if(gep instanceof AbstractElementLinkEditPart) {
			return true;
		}

		if(gep instanceof ResizableCompartmentEditPart) {
			return true;
		}

		return super.provides(operation);
	}

	@Override
	public void createEditPolicies(EditPart editPart) {
		super.createEditPolicies(editPart);

		if(editPart instanceof InternalBlockDiagramEditPart) {
			editPart.installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new CustomDuplicatePasteEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDropEditPolicy());
			// no installation of other policies. 
			return;
		}

		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDragDropEditPolicy());

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

		if(editPart instanceof FlowPortAffixedNodeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new TypedElementDropEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}

		if(editPart instanceof PortAffixedNodeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new TypedElementDropEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}

		if(editPart instanceof BlockPropertyCompositeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomBlockPropertyCompositeDropEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomBlockPropertyCompositeSemanticEditPolicy());
		}

		/*
		 * if(editPart instanceof NestedBlockPropertyCompositeEditPart) {
		 * editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomBlockPropertyCompositeDropEditPolicy());
		 * editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomNestedBlockPropertyCompositeSemanticEditPolicy());
		 * }
		 */

		if(editPart instanceof BlockPropertyStructureCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomBlockPropertyStructureCompartmentEditPartDropEditPolicy());
			editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE, new DefaultXYLayoutEditPolicy());
		}

		if(editPart instanceof BlockCompositeEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new EncapsulatedClassifierDropEditPolicy());
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomBlockCompositeSemanticEditPolicy());
		}

		if(editPart instanceof StructureCompartmentEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new StructureClassifierDropEditPolicy());
			editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE, new DefaultXYLayoutEditPolicy());
		}

		if(editPart instanceof DependencyEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}

		if(editPart instanceof ConnectorEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDefaultSemanticEditPolicy());
		}
		if(editPart instanceof NamedElementEditPart) {
			editPart.installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeCompartmentEditPolicy());
		}

	}

}
