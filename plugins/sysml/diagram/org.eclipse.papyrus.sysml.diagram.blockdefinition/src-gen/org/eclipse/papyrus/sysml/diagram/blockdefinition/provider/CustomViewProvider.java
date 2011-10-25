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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.factory.AffixedLabelViewFactory;
import org.eclipse.papyrus.gmf.diagram.common.factory.CompartmentListViewFactory;
import org.eclipse.papyrus.gmf.diagram.common.factory.ConnectorLabelViewFactory;
import org.eclipse.papyrus.gmf.diagram.common.factory.InnerLabelViewFactory;
import org.eclipse.papyrus.gmf.diagram.common.factory.ShapeChildLabelViewFactory;
import org.eclipse.papyrus.gmf.diagram.common.provider.CustomAbstractViewProvider;
import org.eclipse.papyrus.sysml.diagram.common.factory.BlockClassifierViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.factory.ConstraintBlockClassifierViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.factory.DimensionClassifierViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.factory.FlowPortAffixedNodeViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.factory.FlowSpecificationClassifierViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.factory.UnitClassifierViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.factory.ValueTypeClassifierViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.factory.AssociationLinkViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.ClassifierViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.DependencyLinkViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.EnumerationClassifierViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.GeneralizationLinkViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.InterfaceRealizationLinkViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.PortAffixedNodeViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.PrimitiveTypeClassifierViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.UsageLinkViewFactory;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

public class CustomViewProvider extends CustomAbstractViewProvider {

	/** Map containing node view types supported by this provider */
	protected Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();

	/** Map containing edge view types supported by this provider */
	protected Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();

	/** Default constructor */
	public CustomViewProvider() {
		super();
		this.registry = new CustomGraphicalTypeRegistry();

		diagramType = ElementTypes.DIAGRAM_ID;

		// Custom classifier nodes
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID, EnumerationClassifierViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID, PrimitiveTypeClassifierViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID, ValueTypeClassifierViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID, FlowSpecificationClassifierViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID, ConstraintBlockClassifierViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, BlockClassifierViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID, DimensionClassifierViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID, UnitClassifierViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID, ClassifierViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID, ClassifierViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID, ClassifierViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID, ClassifierViewFactory.class);
		// Custom affixed nodes
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, FlowPortAffixedNodeViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, PortAffixedNodeViewFactory.class);
		// Custom child node labels
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_ENUMERATIONLITERAL_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTPROPERTY_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPROPERTY_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_RECEPTION_AS_LABEL_ID, ShapeChildLabelViewFactory.class);
		// Custom inner labels
		nodeMap.put(UMLGraphicalTypes.LABEL_UML_NAMEDELEMENT_NAME_ID, InnerLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID, InnerLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_CONSTRAINTBLOCK_NAME_ID, InnerLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_DIMENSION_NAME_ID, InnerLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_FLOWSPECIFICATION_NAME_ID, InnerLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_UNIT_NAME_ID, InnerLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_VALUETYPE_NAME_ID, InnerLabelViewFactory.class);
		// Custom compartments
		nodeMap.put(UMLGraphicalTypes.COMPARTMENT_UML_ENUMERATIONLITERAL_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.COMPARTMENT_UML_PORT_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.COMPARTMENT_UML_PROPERTY_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPORT_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPROPERTY_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_PARAMETER_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_PART_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_REFERENCE_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_VALUE_AS_LIST_ID, CompartmentListViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID, CompartmentListViewFactory.class);
		// Custom affixed labels
		nodeMap.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_NAMEDELEMENT_NAME_ID, AffixedLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_APPLIEDSTEREOTYPE_ID, AffixedLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID, AffixedLabelViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID, AffixedLabelViewFactory.class);

		// Custom edges
		edgeMap.put(UMLGraphicalTypes.LINK_UML_USAGE_ID, UsageLinkViewFactory.class);
		edgeMap.put(UMLGraphicalTypes.LINK_UML_INTERFACEREALIZATION_ID, InterfaceRealizationLinkViewFactory.class);
		edgeMap.put(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID, DependencyLinkViewFactory.class);
		edgeMap.put(UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID, GeneralizationLinkViewFactory.class);
		edgeMap.put(SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID, AssociationLinkViewFactory.class);

		// Custom edge labels
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_APPLIEDSTEREOTYPE_ID, ConnectorLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_NAMEDELEMENT_NAME_ID, ConnectorLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_SOURCE_MULTIPLICITY_ID, ConnectorLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_SOURCE_ROLE_ID, ConnectorLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_TARGET_MULTIPLICITY_ID, ConnectorLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_TARGET_ROLE_ID, ConnectorLabelViewFactory.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getNodeViewClass(IAdaptable semanticAdapter, View containerView, String graphicalType) {
		return nodeMap.get(graphicalType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String graphicalType) {
		return edgeMap.get(graphicalType);
	}
}
