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
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTPROPERTY_AS_LABEL_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPROPERTY_AS_LABEL_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID);
		knownNodes.add(SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_ENUMERATIONLITERAL_AS_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_RECEPTION_AS_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID);
		// Decorations
		knownNodes.add(SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID);
		knownNodes.add(SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID);
		knownNodes.add(SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPORT_AS_LIST_ID);
		knownNodes.add(SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPROPERTY_AS_LIST_ID);
		knownNodes.add(SysMLGraphicalTypes.COMPARTMENT_SYSML_PARAMETER_AS_LIST_ID);
		knownNodes.add(SysMLGraphicalTypes.COMPARTMENT_SYSML_PART_AS_LIST_ID);
		knownNodes.add(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID);
		knownNodes.add(SysMLGraphicalTypes.COMPARTMENT_SYSML_REFERENCE_AS_LIST_ID);
		knownNodes.add(SysMLGraphicalTypes.COMPARTMENT_SYSML_VALUE_AS_LIST_ID);
		knownNodes.add(SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID);
		knownNodes.add(SysMLGraphicalTypes.LABEL_SYSML_CONSTRAINTBLOCK_NAME_ID);
		knownNodes.add(SysMLGraphicalTypes.LABEL_SYSML_DIMENSION_NAME_ID);
		knownNodes.add(SysMLGraphicalTypes.LABEL_SYSML_FLOWSPECIFICATION_NAME_ID);
		knownNodes.add(SysMLGraphicalTypes.LABEL_SYSML_UNIT_NAME_ID);
		knownNodes.add(SysMLGraphicalTypes.LABEL_SYSML_VALUETYPE_NAME_ID);
		knownNodes.add(UMLGraphicalTypes.AFFIXEDLABEL_UML_APPLIEDSTEREOTYPE_ID);
		knownNodes.add(UMLGraphicalTypes.AFFIXEDLABEL_UML_NAMEDELEMENT_NAME_ID);
		knownNodes.add(UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID);
		knownNodes.add(UMLGraphicalTypes.COMPARTMENT_UML_ENUMERATIONLITERAL_AS_LIST_ID);
		knownNodes.add(UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID);
		knownNodes.add(UMLGraphicalTypes.COMPARTMENT_UML_PORT_AS_LIST_ID);
		knownNodes.add(UMLGraphicalTypes.COMPARTMENT_UML_PROPERTY_AS_LIST_ID);
		knownNodes.add(UMLGraphicalTypes.LABEL_UML_NAMEDELEMENT_NAME_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_APPLIEDSTEREOTYPE_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_SOURCE_MULTIPLICITY_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_SOURCE_ROLE_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_TARGET_MULTIPLICITY_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_TARGET_ROLE_ID);
		knownNodes.add(UMLGraphicalTypes.LINKLABEL_UML_NAMEDELEMENT_NAME_ID);

		// Edges
		knownEdges.add(SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID);
		knownEdges.add(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID);
		knownEdges.add(UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID);
		knownEdges.add(UMLGraphicalTypes.LINK_UML_INTERFACEREALIZATION_ID);
		knownEdges.add(UMLGraphicalTypes.LINK_UML_USAGE_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNodeGraphicalType(EObject domainElement, String containerType) {
		// Start of user code getNodeGraphicalType(EObject domainElement, String containerType)

		// For legacy reuse of Class Diagram Constraint in BDD (DnD especially)
		if(UMLElementTypes.CONSTRAINT.getEClass().isInstance(domainElement)) {

			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return super.getNodeGraphicalType(domainElement, containerType);
			}

			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType) || ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return super.getNodeGraphicalType(domainElement, containerType);
			}

			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType) || ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return super.getNodeGraphicalType(domainElement, containerType);
			}

			// else : managed below...
		}

		// End of user code

		if(UMLElementTypes.CONSTRAINT.getEClass().isInstance(domainElement)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.ENUMERATION_LITERAL.getEClass().isInstance(domainElement)) {
			if(UMLGraphicalTypes.COMPARTMENT_UML_ENUMERATIONLITERAL_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATIONLITERAL_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.OPERATION.getEClass().isInstance(domainElement)) {
			if(UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.FLOW_PORT).getMatcher().matches(domainElement)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPORT_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.PORT.getEClass().isInstance(domainElement)) {
			if(UMLGraphicalTypes.COMPARTMENT_UML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID;
			}
			if(UMLGraphicalTypes.COMPARTMENT_UML_PORT_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.CONSTRAINT_PROPERTY).getMatcher().matches(domainElement)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTPROPERTY_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.FLOW_PROPERTY).getMatcher().matches(domainElement)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPROPERTY_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPROPERTY_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.PART_PROPERTY).getMatcher().matches(domainElement)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PART_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.REFERENCE_PROPERTY).getMatcher().matches(domainElement)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_REFERENCE_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.VALUE_PROPERTY).getMatcher().matches(domainElement)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_VALUE_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.ACTOR_PART_PROPERTY).getMatcher().matches(domainElement)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.PROPERTY.getEClass().isInstance(domainElement)) {
			if(UMLGraphicalTypes.COMPARTMENT_UML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PARAMETER_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.RECEPTION.getEClass().isInstance(domainElement)) {
			if(UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_RECEPTION_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.ACTOR.getEClass().isInstance(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.ENUMERATION.getEClass().isInstance(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.PRIMITIVE_TYPE.getEClass().isInstance(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.VALUE_TYPE).getMatcher().matches(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.DATA_TYPE.getEClass().isInstance(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.FLOW_SPECIFICATION).getMatcher().matches(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.INTERFACE.getEClass().isInstance(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.SIGNAL.getEClass().isInstance(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.DIMENSION).getMatcher().matches(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(((ISpecializationType)SysMLElementTypes.UNIT).getMatcher().matches(domainElement)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID;
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
		// End of user code

		if(UMLElementTypes.CONSTRAINT.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.ENUMERATION_LITERAL.getSemanticHint().equals(proposedType)) {
			if(UMLGraphicalTypes.COMPARTMENT_UML_ENUMERATIONLITERAL_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATIONLITERAL_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.OPERATION.getSemanticHint().equals(proposedType)) {
			if(UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_OPERATION_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.FLOW_PORT.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPORT_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.PORT.getSemanticHint().equals(proposedType)) {
			if(UMLGraphicalTypes.COMPARTMENT_UML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID;
			}
			if(UMLGraphicalTypes.COMPARTMENT_UML_PORT_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.CONSTRAINT_PROPERTY.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_CONSTRAINT_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTPROPERTY_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.FLOW_PROPERTY.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPROPERTY_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWPROPERTY_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.PART_PROPERTY.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PART_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_PART_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.REFERENCE_PROPERTY.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_REFERENCE_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_REFERENCE_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.VALUE_PROPERTY.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_VALUE_AS_LIST_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUE_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.ACTOR_PART_PROPERTY.getSemanticHint().equals(proposedType)) {
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.PROPERTY.getSemanticHint().equals(proposedType)) {
			if(UMLGraphicalTypes.COMPARTMENT_UML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PARAMETER_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID;
			}
			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_PROPERTY_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.RECEPTION.getSemanticHint().equals(proposedType)) {
			if(UMLGraphicalTypes.COMPARTMENT_UML_OPERATION_AS_LIST_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_RECEPTION_AS_LABEL_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.ACTOR.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ACTOR_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.ENUMERATION.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_ENUMERATION_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.PRIMITIVE_TYPE.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_PRIMITIVETYPE_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.VALUE_TYPE.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_VALUETYPE_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.DATA_TYPE.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_DATATYPE_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.FLOW_SPECIFICATION.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_FLOWSPECIFICATION_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.INTERFACE.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(UMLElementTypes.SIGNAL.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return UMLGraphicalTypes.SHAPE_UML_SIGNAL_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.CONSTRAINT_BLOCK.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCK_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.BLOCK.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.DIMENSION.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_DIMENSION_AS_CLASSIFIER_ID;
			}
			return UNDEFINED_TYPE;
		}
		if(SysMLElementTypes.UNIT.getSemanticHint().equals(proposedType)) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) {
				return SysMLGraphicalTypes.SHAPE_SYSML_UNIT_AS_CLASSIFIER_ID;
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

		if(((ISpecializationType)SysMLElementTypes.ASSOCIATION).getMatcher().matches(domainElement)) {
			return SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID;
		}
		if(UMLElementTypes.USAGE.getEClass().isInstance(domainElement)) {
			return UMLGraphicalTypes.LINK_UML_USAGE_ID;
		}
		if(UMLElementTypes.INTERFACE_REALIZATION.getEClass().isInstance(domainElement)) {
			return UMLGraphicalTypes.LINK_UML_INTERFACEREALIZATION_ID;
		}
		if(UMLElementTypes.DEPENDENCY.getEClass().isInstance(domainElement)) {
			return UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID;
		}
		if(UMLElementTypes.GENERALIZATION.getEClass().isInstance(domainElement)) {
			return UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID;
		}
		return super.getEdgeGraphicalType(domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEdgeGraphicalType(String proposedType) {
		// Start of user code getEdgeGraphicalType(String proposedType)
		if(SysMLElementTypes.ASSOCIATION_NONE.getSemanticHint().equals(proposedType)) {
			return SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID;
		}
		if(SysMLElementTypes.ASSOCIATION_NONE_DIRECTED.getSemanticHint().equals(proposedType)) {
			return SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID;
		}
		if(SysMLElementTypes.ASSOCIATION_COMPOSITE.getSemanticHint().equals(proposedType)) {
			return SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID;
		}
		if(SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED.getSemanticHint().equals(proposedType)) {
			return SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID;
		}
		if(SysMLElementTypes.ASSOCIATION_SHARED.getSemanticHint().equals(proposedType)) {
			return SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID;
		}
		if(SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED.getSemanticHint().equals(proposedType)) {
			return SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID;
		}
		// End of user code

		if(SysMLElementTypes.ASSOCIATION.getSemanticHint().equals(proposedType)) {
			return SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID;
		}
		if(UMLElementTypes.USAGE.getSemanticHint().equals(proposedType)) {
			return UMLGraphicalTypes.LINK_UML_USAGE_ID;
		}
		if(UMLElementTypes.INTERFACE_REALIZATION.getSemanticHint().equals(proposedType)) {
			return UMLGraphicalTypes.LINK_UML_INTERFACEREALIZATION_ID;
		}
		if(UMLElementTypes.DEPENDENCY.getSemanticHint().equals(proposedType)) {
			return UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID;
		}
		if(UMLElementTypes.GENERALIZATION.getSemanticHint().equals(proposedType)) {
			return UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID;
		}
		return super.getEdgeGraphicalType(proposedType);
	}
}
