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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.provider.CustomAbstractEditPartProvider;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.AssociationEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockConstraintCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockPropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintPropertyChildLabelEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.DimensionEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.DimensionLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedNodeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortChildLabelEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPropertyChildLabelEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowSpecificationEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowSpecificationLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ParameterCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.PartPropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ReferencePropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.UnitEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.UnitLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ValuePropertyCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ValueTypeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ValueTypeLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ActorEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AppliedStereotypeAffixedLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AppliedStereotypeLinkLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelSourceMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelSourceRoleEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelTargetMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelTargetRoleEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.DataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.DefaultChildLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.EnumerationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.EnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.NamedElementAffixedLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.NamedElementLinkLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.NamedElementNodeLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.OperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PropertyCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.SignalEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

public class CustomEditPartProvider extends CustomAbstractEditPartProvider {

	/** Map containing node view types supported by this provider */
	protected Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();

	/** Map containing edge view types supported by this provider */
	protected Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();

	/** Default constructor */
	public CustomEditPartProvider() {
		super();

		diagramType = ElementTypes.DIAGRAM_ID;

		// Nodes
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, BlockEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID, ConstraintBlockEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTPROPERTY_AS_LABEL_ID, ConstraintPropertyChildLabelEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID, DimensionEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, FlowPortAffixedNodeEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID, FlowPortChildLabelEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPROPERTY_AS_LABEL_ID, FlowPropertyChildLabelEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID, FlowSpecificationEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID, DefaultChildLabelEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID, DefaultChildLabelEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID, UnitEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID, ValueTypeEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID, DefaultChildLabelEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID, ActorEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID, DefaultChildLabelEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID, DataTypeEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_ENUMERATIONLITERAL_AS_LABEL_ID, DefaultChildLabelEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID, EnumerationEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID, InterfaceEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID, DefaultChildLabelEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, PortAffixedNodeEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID, DefaultChildLabelEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID, PrimitiveTypeEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID, DefaultChildLabelEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_RECEPTION_AS_LABEL_ID, DefaultChildLabelEditPart.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID, SignalEditPart.class);

		// Decorations
		nodeMap.put(SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID, FlowPortAffixedLabelNameEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID, BlockConstraintCompartmentEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPORT_AS_LIST_ID, FlowPortCompartmentEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPROPERTY_AS_LIST_ID, FlowPropertyCompartmentEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_PARAMETER_AS_LIST_ID, ParameterCompartmentEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_PART_AS_LIST_ID, PartPropertyCompartmentEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID, BlockPropertyCompartmentEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_REFERENCE_AS_LIST_ID, ReferencePropertyCompartmentEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_VALUE_AS_LIST_ID, ValuePropertyCompartmentEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID, BlockLabelNameEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_CONSTRAINTBLOCK_NAME_ID, ConstraintBlockLabelNameEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_DIMENSION_NAME_ID, DimensionLabelNameEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_FLOWSPECIFICATION_NAME_ID, FlowSpecificationLabelNameEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_UNIT_NAME_ID, UnitLabelNameEditPart.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_VALUETYPE_NAME_ID, ValueTypeLabelNameEditPart.class);
		nodeMap.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_APPLIEDSTEREOTYPE_ID, AppliedStereotypeAffixedLabelEditPart.class);
		nodeMap.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_NAMEDELEMENT_NAME_ID, NamedElementAffixedLabelNameEditPart.class);
		nodeMap.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID, PortAffixedLabelNameEditPart.class);
		nodeMap.put(UMLGraphicalTypes.COMPARTMENT_UML_ENUMERATIONLITERAL_AS_LIST_ID, EnumerationLiteralCompartmentEditPart.class);
		nodeMap.put(UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID, OperationCompartmentEditPart.class);
		nodeMap.put(UMLGraphicalTypes.COMPARTMENT_UML_PORT_AS_LIST_ID, PortCompartmentEditPart.class);
		nodeMap.put(UMLGraphicalTypes.COMPARTMENT_UML_PROPERTY_AS_LIST_ID, PropertyCompartmentEditPart.class);
		nodeMap.put(UMLGraphicalTypes.LABEL_UML_NAMEDELEMENT_NAME_ID, NamedElementNodeLabelNameEditPart.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_APPLIEDSTEREOTYPE_ID, AppliedStereotypeLinkLabelEditPart.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_SOURCE_MULTIPLICITY_ID, AssociationLinkLabelSourceMultiplicityEditPart.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_SOURCE_ROLE_ID, AssociationLinkLabelSourceRoleEditPart.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_TARGET_MULTIPLICITY_ID, AssociationLinkLabelTargetMultiplicityEditPart.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_TARGET_ROLE_ID, AssociationLinkLabelTargetRoleEditPart.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_NAMEDELEMENT_NAME_ID, NamedElementLinkLabelNameEditPart.class);

		// Edges
		edgeMap.put(SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID, AssociationEditPart.class);
		edgeMap.put(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID, DependencyEditPart.class);
		edgeMap.put(UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID, GeneralizationEditPart.class);
		edgeMap.put(UMLGraphicalTypes.LINK_UML_INTERFACEREALIZATION_ID, InterfaceRealizationEditPart.class);
		edgeMap.put(UMLGraphicalTypes.LINK_UML_USAGE_ID, UsageEditPart.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View newView = ((IEditPartOperation)operation).getView();
			if(newView == null) {
				return false;
			}

			String graphicalType = newView.getType();

			if((newView instanceof Node) && (!nodeMap.containsKey(graphicalType))) {
				return false;
			}

			if((newView instanceof Edge) && (!edgeMap.containsKey(graphicalType))) {
				return false;
			}
		}

		return super.provides(operation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getNodeEditPartClass(View view) {
		return nodeMap.get(view.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getEdgeEditPartClass(View view) {
		return edgeMap.get(view.getType());
	}
}
