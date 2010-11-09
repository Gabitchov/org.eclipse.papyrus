/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.providers.CUMLEditPartProvider;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;

public class InheritedClassDiagramElementEditPartProvider extends CUMLEditPartProvider {

	@Override
	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is BlockDefinitionDiagram
			if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Test supported inherited types
			String hint = view.getType();

			/** Nodes *********** */

			/** Package */
			if(InheritedElementTypes.PACKAGE.getSemanticHint().equals(hint) || InheritedElementTypes.PACKAGE_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.PACKAGE_CN.getSemanticHint().equals(hint) || InheritedElementTypes.PACKAGE_CN_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.PACKAGE_CN_COMPARTMENT_HINT.equals(hint)) {
				return true;
			}

			/** Model */
			if(InheritedElementTypes.MODEL.getSemanticHint().equals(hint) || InheritedElementTypes.MODEL_LABEL_NAME_TN_HINT.equals(hint) || InheritedElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.MODEL_CN.getSemanticHint().equals(hint) || InheritedElementTypes.MODEL_CN_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.MODEL_CN_COMPARTMENT_HINT.equals(hint)) {
				return true;
			}

			/** Class */
			if(InheritedElementTypes.CLASS.getSemanticHint().equals(hint) || InheritedElementTypes.CLASS_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.CLASS_COMPARTMENT_ATTRIBUTE_HINT.equals(hint) || InheritedElementTypes.CLASS_COMPARTMENT_OPERATION_HINT.equals(hint) || InheritedElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(hint) || InheritedElementTypes.CLASS_PROPERTY_CLN.getSemanticHint().equals(hint) || InheritedElementTypes.CLASS_OPERATION_CLN.getSemanticHint().equals(hint) || InheritedElementTypes.CLASS_RECEPTION_CLN.getSemanticHint().equals(hint) || InheritedElementTypes.CLASS_CLASS_CLN.getSemanticHint().equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.CLASS_CN.getSemanticHint().equals(hint) || InheritedElementTypes.CLASS_CN_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.CLASS_CN_COMPARTMENT_PROP_HINT.equals(hint) || InheritedElementTypes.CLASS_CN_COMPARTMENT_OPER_HINT.equals(hint) || InheritedElementTypes.CLASS_CN_COMPARTMENT_NEST_HINT.equals(hint)) {
				return true;
			}

			/** Interface */
			if(InheritedElementTypes.INTERFACE.getSemanticHint().equals(hint) || InheritedElementTypes.INTERFACE_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.INTERFACE_COMPARTMENT_ATTRIBUTE_HINT.equals(hint) || InheritedElementTypes.INTERFACE_COMPARTMENT_OPERATION_HINT.equals(hint) || InheritedElementTypes.INTERFACE_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(hint) || InheritedElementTypes.INTERFACE_PROPERTY_CLN.getSemanticHint().equals(hint) || InheritedElementTypes.INTERFACE_OPERATION_CLN.getSemanticHint().equals(hint) || InheritedElementTypes.INTERFACE_CLASS_CLN.getSemanticHint().equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.INTERFACE_CN.getSemanticHint().equals(hint) || InheritedElementTypes.INTERFACE_CN_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.INTERFACE_CN_COMPARTMENT_PROP_HINT.equals(hint) || InheritedElementTypes.INTERFACE_CN_COMPARTMENT_OPER_HINT.equals(hint) || InheritedElementTypes.INTERFACE_CN_COMPARTMENT_NEST_HINT.equals(hint)) {
				return true;
			}

			/** AssociationClass */
			if(InheritedElementTypes.ASSOCIATION_CLASS.getSemanticHint().equals(hint) || InheritedElementTypes.ASSOCIATION_CLASS_LABEL_NAME2_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_CLASS_COMPARTMENT_ATTRIBUTE_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_CLASS_COMPARTMENT_OPERATION_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_CLASS_PROPERTY_CLN.getSemanticHint().equals(hint) || InheritedElementTypes.COMPONENT_OPERATION_CLN.getSemanticHint().equals(hint) || InheritedElementTypes.COMPONENT_CLASS_CLN.getSemanticHint().equals(hint)) {
				return true;
			}

			/** DataType */
			if(InheritedElementTypes.DATA_TYPE.getSemanticHint().equals(hint) || InheritedElementTypes.DATA_TYPE_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT.equals(hint) || InheritedElementTypes.DATA_TYPE_COMPARTMENT_OPERATION_HINT.equals(hint) || InheritedElementTypes.DATATYPE_PROPERTY_CLN.getSemanticHint().equals(hint) || InheritedElementTypes.DATATYPE_OPERATION_CLN.getSemanticHint().equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.DATATYPE_CN.getSemanticHint().equals(hint) || InheritedElementTypes.DATATYPE_CN_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.DATATYPE_CN_COMPARTMENT_PROP_HINT.equals(hint) || InheritedElementTypes.DATATYPE_CN_COMPARTMENT_OPER_HINT.equals(hint)) {
				return true;
			}

			/** Enumeration */
			if(InheritedElementTypes.ENUMERATION.getSemanticHint().equals(hint) || InheritedElementTypes.ENUMERATION_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.ENUMERATION_COMPARTMENT_LITERAL_HINT.equals(hint) || InheritedElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint().equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.ENUMERATION_CN.getSemanticHint().equals(hint) || InheritedElementTypes.ENUMERATION_CN_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(hint)) {
				return true;
			}

			/** PrimitiveType */
			if(InheritedElementTypes.PRIMITIVE_TYPE.getSemanticHint().equals(hint) || InheritedElementTypes.PRIMITIVE_TYPE_LABEL_NAME_HINT.equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.PRIMITIVETYPE_CN.getSemanticHint().equals(hint) || InheritedElementTypes.PRIMITIVETYPE_CN_LABEL_NAME_HINT.equals(hint)) {
				return true;
			}

			/** InstanceSpecification */
			if(InheritedElementTypes.INSTANCE_SPECIFICATION.getSemanticHint().equals(hint) || InheritedElementTypes.INSTANCE_SPECIFICATION_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.INSTANCE_SPECIFICATION_COMPARTMENT_SLOT_HINT.equals(hint) || InheritedElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN.getSemanticHint().equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.INSTANCE_SPEC_CN.getSemanticHint().equals(hint) || InheritedElementTypes.INSTANCE_SPEC_CN_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.INSTANCE_SPEC_CN_COMPARTMENT_SLOT_HINT.equals(hint)) {
				return true;
			}

			/** Comment */
			if(InheritedElementTypes.COMMENT.getSemanticHint().equals(hint) || InheritedElementTypes.COMMENT_LABEL_BODY_HINT.equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.COMMENT_CN.getSemanticHint().equals(hint) || InheritedElementTypes.COMMENT_CN_BODY_LABEL_HINT.equals(hint)) {
				return true;
			}

			/** Constraint */
			if(InheritedElementTypes.CONSTRAINT.getSemanticHint().equals(hint) || InheritedElementTypes.CONSTRAINT_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.CONSTRAINT_LABEL_BODY_HINT.equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.CONSTRAINT_CN.getSemanticHint().equals(hint) || InheritedElementTypes.CONSTRAINT_CN_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.CONSTRAINT_CN_SPEC_LABEL_HINT.equals(hint)) {
				return true;
			}

			if(InheritedElementTypes.CONTAINMENT_CIRCLE.getSemanticHint().equals(hint)) {
				return true;
			}

			/** Edges *********** */

			/** Dependency */
			if(InheritedElementTypes.DEPENDENCY.getSemanticHint().equals(hint) || InheritedElementTypes.DEPENDENCY_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.DEPENDENCY_STEREOTYPE_LABEL_HINT.equals(hint)) {
				return true;
			}

			/** Usage */
			if(InheritedElementTypes.USAGE.getSemanticHint().equals(hint) || InheritedElementTypes.USAGE_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.USAGE_STEREOTYPE_LABEL_HINT.equals(hint)) {
				return true;
			}

			/** InterfaceRealization */
			if(InheritedElementTypes.INTERFACE_REALIZATION.getSemanticHint().equals(hint) || InheritedElementTypes.INTERFACE_REALIZATION_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.INTERFACE_REALIZATION_STEREOTYPE_LABEL_HINT.equals(hint)) {
				return true;
			}

			/** Generalization */
			if(InheritedElementTypes.GENERALIZATION.getSemanticHint().equals(hint) || InheritedElementTypes.GENERALIZATION_STEREOTYPE_LABEL_HINT.equals(hint)) {
				return true;
			}

			/** GeneralizationSet */
			if(InheritedElementTypes.GENERALIZATION_SET.getSemanticHint().equals(hint) || InheritedElementTypes.GENERALIZATION_SET_LABEL_HINT.equals(hint)) {
				return true;
			}

			/** Association */
			if(InheritedElementTypes.ASSOCIATION.getSemanticHint().equals(hint) || InheritedElementTypes.ASSOCIATION_LABEL_NAME_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_STEREOTYPE_LABEL_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_ROLE_SOURCE_LABEL_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_ROLE_TARGET_LABEL_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_MULT_SOURCE_LABEL_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_MULT_TARGET_LABEL_HINT.equals(hint)) {
				return true;
			}

			/** AssociationClass */
			if(InheritedElementTypes.ASSOCIATION_CLASS_EDGE.getSemanticHint().equals(hint) || InheritedElementTypes.ASSOCIATION_CLASS_LABEL_NAME2_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_CLASS_EDGE_ROLE_SOURCE_LABEL_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_CLASS_EDGE_ROLE_TARGET_LABEL_HINT.equals(hint) || InheritedElementTypes.ASSOCIATION_CLASS_LINK.getSemanticHint().equals(hint)) {
				return true;
			}

			/** ContainmentLink */
			if((InheritedElementTypes.CONTAINMENT_LINK.getSemanticHint().equals(hint)) || (InheritedElementTypes.CONTAINMENT_ADDED_LINK.getSemanticHint().equals(hint))) {
				return true;
			}

			/** CommentLink - ConstraintLink */
			if((InheritedElementTypes.COMMENT_LINK.getSemanticHint().equals(hint))) {
				return true;
			}

			if(InheritedElementTypes.CONSTRAINT_LINK.getSemanticHint().equals(hint)) {
				return true;
			}
		}
		return false;
	}
}
