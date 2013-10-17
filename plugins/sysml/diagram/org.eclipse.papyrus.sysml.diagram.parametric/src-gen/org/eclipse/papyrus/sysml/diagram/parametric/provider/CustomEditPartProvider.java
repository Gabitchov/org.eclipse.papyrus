/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.provider; 

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.provider.CustomAbstractEditPartProvider;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockPropertyStructureCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.FlowPortAffixedNodeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.StructureCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomBlockCompositeEditPartTN;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomBlockLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomConstraintBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomConstraintParameterAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AppliedStereotypeAffixedLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AppliedStereotypeLinkLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConnectorEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConnectorLinkLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConnectorLinkLabelSourceMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConnectorLinkLabelTargetMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConstraintNodeLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.NamedElementLinkLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PortAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.PropertyNodeLabelEditPart;
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
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCKPROPERTY_AS_COMPOSITE_ID, CustomConstraintBlockPropertyCompositeEditPart.class);	
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, CustomBlockPropertyCompositeEditPart.class);	
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID, CustomBlockCompositeEditPartTN.class);	
		nodeMap.put(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, FlowPortAffixedNodeEditPart.class);	
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, PortAffixedNodeEditPart.class);	
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID, CustomConstraintParameterAffixedNodeEditPart.class);
		
		// Decorations
		nodeMap.put(SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID, FlowPortAffixedLabelNameEditPart.class);	
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID, BlockPropertyStructureCompartmentEditPart.class);	
		nodeMap.put(SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID, StructureCompartmentEditPart.class);	
		nodeMap.put(SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID, CustomBlockLabelNameEditPart.class); // TODO : change for multi FlowText 
		nodeMap.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_APPLIEDSTEREOTYPE_ID, AppliedStereotypeAffixedLabelEditPart.class);	
		nodeMap.put(UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID, PortAffixedLabelNameEditPart.class);	
		nodeMap.put(UMLGraphicalTypes.LABEL_UML_PROPERTY_LABEL_ID, PropertyNodeLabelEditPart.class);	
		nodeMap.put(UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID, ConstraintNodeLabelEditPart.class);	
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_APPLIEDSTEREOTYPE_ID, AppliedStereotypeLinkLabelEditPart.class);	
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_LABEL_ID, ConnectorLinkLabelEditPart.class);	
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_SOURCE_MULTIPLICITY_ID, ConnectorLinkLabelSourceMultiplicityEditPart.class);	
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_TARGET_MULTIPLICITY_ID, ConnectorLinkLabelTargetMultiplicityEditPart.class);	
		nodeMap.put(UMLGraphicalTypes.LINKLABEL_UML_NAMEDELEMENT_NAME_ID, NamedElementLinkLabelNameEditPart.class);	

		
		// Edges
		edgeMap.put(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID, ConnectorEditPart.class);	
		edgeMap.put(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID, DependencyEditPart.class);	
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View newView = ((IEditPartOperation)operation).getView();
			if (newView == null) {
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
