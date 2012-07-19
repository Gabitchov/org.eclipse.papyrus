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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

public class CustomGraphicalTypeRegistry extends GraphicalTypeRegistry {

	/** Default constructor */
	public CustomGraphicalTypeRegistry() {

		super();

		// Nodes
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID);
		// Decorations
		knownNodes.add(SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID);
		knownNodes.add(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		knownNodes.add(SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
		knownNodes.add(SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID);
		knownNodes.add(UMLGraphicalTypes.AFFIXEDLABEL_UML_APPLIEDSTEREOTYPE_ID);
		knownNodes.add(UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.LABEL_UML_PROPERTY_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_APPLIEDSTEREOTYPE_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_SOURCE_MULTIPLICITY_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_TARGET_MULTIPLICITY_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_NAMEDELEMENT_NAME_ID);

		// Edges
		knownEdges.add(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID);
		knownEdges.add(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNodeGraphicalType(EObject domainElement, String containerType) {
		// Start of user code getNodeGraphicalType(EObject domainElement, String containerType)	
		if(((ISpecializationType)SysMLElementTypes.PART_PROPERTY).getMatcher().matches(domainElement)
			|| ((ISpecializationType)SysMLElementTypes.REFERENCE_PROPERTY).getMatcher().matches(domainElement)
			|| ((ISpecializationType)SysMLElementTypes.ACTOR_PART_PROPERTY).getMatcher().matches(domainElement)
			|| ((ISpecializationType)SysMLElementTypes.VALUE_PROPERTY).getMatcher().matches(domainElement)
			|| ((domainElement instanceof org.eclipse.uml2.uml.Property) && !(domainElement instanceof org.eclipse.uml2.uml.Port))) {

			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			
			return UNDEFINED_TYPE;
		}

		if(((ISpecializationType)SysMLElementTypes.FLOW_PORT).getMatcher().matches(domainElement)
			|| ((ISpecializationType)SysMLElementTypes.FLOW_PORT_IN).getMatcher().matches(domainElement)
			|| ((ISpecializationType)SysMLElementTypes.FLOW_PORT_OUT).getMatcher().matches(domainElement)
			|| ((ISpecializationType)SysMLElementTypes.FLOW_PORT_IN_OUT).getMatcher().matches(domainElement)
			|| ((ISpecializationType)SysMLElementTypes.FLOW_PORT_NA).getMatcher().matches(domainElement)) {

			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}
			/*
			if(SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}
			*/
			return UNDEFINED_TYPE;
		}
		// End of user code

		if(((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.PART_PROPERTY).getMatcher().matches(domainElement)) {
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			/*
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			*/
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.FLOW_PORT).getMatcher().matches(domainElement)) {
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.PORT.getEClass().isInstance(domainElement)) {
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID;
			}
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID;
			}
			return UNDEFINED_TYPE;
		}
		return super.getNodeGraphicalType(domainElement, containerType);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNodeGraphicalType(String proposedType, String containerType) {
		// Start of user code getNodeGraphicalType(String proposedType, String containerType)
		if(SysMLElementTypes.PART_PROPERTY.getSemanticHint().equals(proposedType)
			|| SysMLElementTypes.REFERENCE_PROPERTY.getSemanticHint().equals(proposedType)
			|| SysMLElementTypes.ACTOR_PART_PROPERTY.getSemanticHint().equals(proposedType)
			|| SysMLElementTypes.VALUE_PROPERTY.getSemanticHint().equals(proposedType)
			|| UMLElementTypes.PROPERTY.getSemanticHint().equals(proposedType)) {

			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}

			return UNDEFINED_TYPE;
		}

		if(SysMLElementTypes.FLOW_PORT.getSemanticHint().equals(proposedType)
			|| SysMLElementTypes.FLOW_PORT_IN.getSemanticHint().equals(proposedType)
			|| SysMLElementTypes.FLOW_PORT_OUT.getSemanticHint().equals(proposedType)
			|| SysMLElementTypes.FLOW_PORT_IN_OUT.getSemanticHint().matches(proposedType)
			|| SysMLElementTypes.FLOW_PORT_NA.getSemanticHint().matches(proposedType)) {

			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}

			return UNDEFINED_TYPE;
		}

		// End of user code

		if(SysMLElementTypes.BLOCK.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.PART_PROPERTY.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			/*
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID;
			}
			*/
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.FLOW_PORT.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.PORT.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID;
			}
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID;
			}
			return UNDEFINED_TYPE;
		}
		return super.getNodeGraphicalType(proposedType, containerType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEdgeGraphicalType(EObject domainElement) {
		// Start of user code getEdgeGraphicalType(EObject domainElement)	
		// End of user code

		if(UMLElementTypes.CONNECTOR.getEClass().isInstance(domainElement)) {
			return UMLGraphicalTypes.LINK_UML_CONNECTOR_ID;
		}
		if(UMLElementTypes.DEPENDENCY.getEClass().isInstance(domainElement)) {
			return UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID;
		}
		return super.getEdgeGraphicalType(domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEdgeGraphicalType(String proposedType) {
		// Start of user code getEdgeGraphicalType(String proposedType)
		// End of user code

		if(UMLElementTypes.CONNECTOR.getSemanticHint().equals(proposedType)) {
			return UMLGraphicalTypes.LINK_UML_CONNECTOR_ID;
		}
		if(UMLElementTypes.DEPENDENCY.getSemanticHint().equals(proposedType)) {
			return UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID;
		}
		return super.getEdgeGraphicalType(proposedType);
	}
}
