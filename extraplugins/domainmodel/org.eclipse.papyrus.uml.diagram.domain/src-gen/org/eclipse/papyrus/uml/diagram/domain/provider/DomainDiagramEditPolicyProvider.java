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
package org.eclipse.papyrus.uml.diagram.domain.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.uml.diagram.domain.policies.CustomDragDropEditPolicy;

public class DomainDiagramEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(IOperation operation) {

		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart)) {
			return false;
		}
		GraphicalEditPart gep = (GraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassOperationCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassOperationCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeAttributeCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeOperationCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeAttributeCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeOperationCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEnumerationLiteralCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeAttributeCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeOperationCompartmentEditPartCN) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeAttributeCompartmentEditPart) {
			return true;
		}
		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeOperationCompartmentEditPart) {
			return true;
		}

		return false;
	}

	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDragDropEditPolicy());
	}

}
