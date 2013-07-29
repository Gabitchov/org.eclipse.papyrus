package org.eclipse.papyrus.sysml.diagram.parametric.provider; 

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.factory.AffixedLabelViewFactory;
import org.eclipse.papyrus.gmf.diagram.common.factory.CompartmentShapeViewFactory;
import org.eclipse.papyrus.gmf.diagram.common.factory.ConnectorLabelViewFactory;
import org.eclipse.papyrus.gmf.diagram.common.factory.InnerLabelViewFactory;
import org.eclipse.papyrus.gmf.diagram.common.provider.CustomAbstractViewProvider;
import org.eclipse.papyrus.sysml.diagram.common.factory.BlockCompositeClassifierViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.factory.BlockPropertyCompositeClassifierViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.factory.ConstraintBlockPropertyCompositeClassifierViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.factory.FlowPortAffixedNodeViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.factory.ConnectorLinkViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.ConstraintPropertyAffixedNodeViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.DependencyLinkViewFactory;
import org.eclipse.papyrus.uml.diagram.common.factory.PortAffixedNodeViewFactory;
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
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID, BlockCompositeClassifierViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, BlockPropertyCompositeClassifierViewFactory.class);
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCKPROPERTY_AS_COMPOSITE_ID, ConstraintBlockPropertyCompositeClassifierViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID, ConstraintPropertyAffixedNodeViewFactory.class);
		// Custom affixed nodes
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, FlowPortAffixedNodeViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, PortAffixedNodeViewFactory.class);
		// Custom child node labels
		// Custom inner labels
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID, InnerLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.LABEL_UML_PROPERTY_LABEL_ID, InnerLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID, InnerLabelViewFactory.class);
		// Custom compartments
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID, CompartmentShapeViewFactory.class);		
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID, CompartmentShapeViewFactory.class);
		// Custom affixed labels
		nodeMap.put(SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID, AffixedLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_APPLIEDSTEREOTYPE_ID, AffixedLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID, AffixedLabelViewFactory.class);
		
		// Custom edges
		edgeMap.put(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID, ConnectorLinkViewFactory.class);
		edgeMap.put(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID, DependencyLinkViewFactory.class);

		// Custom edge labels
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_APPLIEDSTEREOTYPE_ID, ConnectorLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_LABEL_ID, ConnectorLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_SOURCE_MULTIPLICITY_ID, ConnectorLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_TARGET_MULTIPLICITY_ID, ConnectorLabelViewFactory.class);
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_NAMEDELEMENT_NAME_ID, ConnectorLabelViewFactory.class);
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
