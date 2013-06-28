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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.IGraphicalTypeRegistry;

/**
 * <pre>
 * This class provides graphical type id (used as View type) for
 * domain element according to their actual or expected graphical
 * container type.
 * </pre>
 */
public class GraphicalTypeRegistry implements IGraphicalTypeRegistry {

	/** A Set containing all known node graphical types */
	protected Set<String> knownNodes = new HashSet<String>();

	/** A Set containing all known edge graphical types */
	protected Set<String> knownEdges = new HashSet<String>();

	/** Default constructor */
	public GraphicalTypeRegistry() {

		// Fill known edges set
		knownEdges.add(ElementTypes.GENERALIZATION.getSemanticHint());
		knownEdges.add(ElementTypes.INSTANCE_SPECIFICATION_LINK.getSemanticHint());
		knownEdges.add(ElementTypes.ASSOCIATION.getSemanticHint());
		knownEdges.add(ElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint());
		knownEdges.add(ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT.getSemanticHint());

		// Fill known nodes set (primary nodes)
		knownNodes.add(ElementTypes.PACKAGE.getSemanticHint());
		knownNodes.add(ElementTypes.PACKAGE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.COMMENT.getSemanticHint());
		knownNodes.add(ElementTypes.COMMENT_CN.getSemanticHint());
		knownNodes.add(ElementTypes.CONSTRAINT.getSemanticHint());
		knownNodes.add(ElementTypes.CONSTRAINT_CN.getSemanticHint());
		knownNodes.add(ElementTypes.INSTANCE_SPECIFICATION.getSemanticHint());
		knownNodes.add(ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS_CN.getSemanticHint());
		knownNodes.add(ElementTypes.DATA_TYPE.getSemanticHint());
		knownNodes.add(ElementTypes.DATA_TYPE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.ENUMERATION.getSemanticHint());
		knownNodes.add(ElementTypes.ENUMERATION_CN.getSemanticHint());
		knownNodes.add(ElementTypes.PRIMITIVE_TYPE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.PRIMITIVE_TYPE.getSemanticHint());

		// Fill known nodes set (child label nodes)
		knownNodes.add(ElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS_PROPERTY_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS_RECEPTION_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS_OPERATION_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS_CLASS_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS_INTERFACE_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS_ENUMERATION_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS_PRIMITIVE_TYPE_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS_DATA_TYPE_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.CLASS_SIGNAL_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.DATA_TYPE_PROPERTY_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.DATA_TYPE_OPERATION_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.PRIMITIVE_TYPE_PROPERTY_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.PRIMITIVE_TYPE_OPERATION_CLN.getSemanticHint());
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEdgeGraphicalType(EObject domainElement) {

		String graphicalType = UNDEFINED_TYPE;
		if(domainElement == null) {
			return UNDEFINED_TYPE;
		}
		if(domainElement instanceof org.eclipse.uml2.uml.Generalization) {
			graphicalType = ElementTypes.GENERALIZATION.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.InstanceSpecification) {
			graphicalType = ElementTypes.INSTANCE_SPECIFICATION.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.Association) {
			graphicalType = ElementTypes.ASSOCIATION.getSemanticHint();
		}
		return graphicalType;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEdgeGraphicalType(IElementType elementType) {
		if(elementType instanceof IHintedType) {
			String semanticHint = ((IHintedType)elementType).getSemanticHint();
			return getEdgeGraphicalType(semanticHint);
		}

		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEdgeGraphicalType(String proposedType) {
		if(isKnownEdgeType(proposedType)) {
			return proposedType;
		}

		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNodeGraphicalType(EObject domainElement, String containerType) {

		String graphicalType = UNDEFINED_TYPE;
		if((containerType == null) || (domainElement == null)) {
			return UNDEFINED_TYPE;
		}

		if(domainElement instanceof org.eclipse.uml2.uml.Package) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Package TopNode
				graphicalType = ElementTypes.PACKAGE.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Package ChildNode
				graphicalType = ElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Package ChildNode
				graphicalType = ElementTypes.PACKAGE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Comment TopNode
				graphicalType = ElementTypes.COMMENT.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Comment ChildNode
				graphicalType = ElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Comment ChildNode
				graphicalType = ElementTypes.COMMENT_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Constraint TopNode
				graphicalType = ElementTypes.CONSTRAINT.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				graphicalType = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				graphicalType = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.InstanceSpecification) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // InstanceSpecification TopNode
				graphicalType = ElementTypes.INSTANCE_SPECIFICATION.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // InstanceSpecification ChildNode
				graphicalType = ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // InstanceSpecification ChildNode
				graphicalType = ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.Class) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Class TopNode
				graphicalType = ElementTypes.CLASS.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Class ChildNode
				graphicalType = ElementTypes.CLASS_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Class ChildNode
				graphicalType = ElementTypes.CLASS_CN.getSemanticHint();
			}

			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // Class ChildLabelNode
				graphicalType = ElementTypes.CLASS_CLASS_CLN.getSemanticHint();
			}
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // Class ChildLabelNode
				graphicalType = ElementTypes.CLASS_CLASS_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.DataType) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // DataType TopNode
				graphicalType = ElementTypes.DATA_TYPE.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // DataType ChildNode
				graphicalType = ElementTypes.DATA_TYPE_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // DataType ChildNode
				graphicalType = ElementTypes.DATA_TYPE_CN.getSemanticHint();
			}

			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // DataType ChildLabelNode
				graphicalType = ElementTypes.CLASS_DATA_TYPE_CLN.getSemanticHint();
			}
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // DataType ChildLabelNode
				graphicalType = ElementTypes.CLASS_DATA_TYPE_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.Enumeration) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Enumeration TopNode
				graphicalType = ElementTypes.ENUMERATION.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Enumeration ChildNode
				graphicalType = ElementTypes.ENUMERATION_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Enumeration ChildNode
				graphicalType = ElementTypes.ENUMERATION_CN.getSemanticHint();
			}

			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // Enumeration ChildLabelNode
				graphicalType = ElementTypes.CLASS_ENUMERATION_CLN.getSemanticHint();
			}
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // Enumeration ChildLabelNode
				graphicalType = ElementTypes.CLASS_ENUMERATION_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.PrimitiveType) {
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // PrimitiveType ChildNode
				graphicalType = ElementTypes.PRIMITIVE_TYPE_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // PrimitiveType ChildNode
				graphicalType = ElementTypes.PRIMITIVE_TYPE_CN.getSemanticHint();
			}
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // PrimitiveType TopNode
				graphicalType = ElementTypes.PRIMITIVE_TYPE.getSemanticHint();
			}

			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // PrimitiveType ChildLabelNode
				graphicalType = ElementTypes.CLASS_PRIMITIVE_TYPE_CLN.getSemanticHint();
			}
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // PrimitiveType ChildLabelNode
				graphicalType = ElementTypes.CLASS_PRIMITIVE_TYPE_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.Slot) {

			if(ElementTypes.INSTANCE_SPECIFICATION_COMPARTMENT_SLOT_HINT.equals(containerType)) { // Slot ChildLabelNode
				graphicalType = ElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN.getSemanticHint();
			}
			if(ElementTypes.INSTANCE_SPECIFICATION_CN_COMPARTMENT_SLOT_HINT.equals(containerType)) { // Slot ChildLabelNode
				graphicalType = ElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.Property) {

			if(ElementTypes.CLASS_COMPARTMENT_ATTRIBUTE_HINT.equals(containerType)) { // Property ChildLabelNode
				graphicalType = ElementTypes.CLASS_PROPERTY_CLN.getSemanticHint();
			}
			if(ElementTypes.CLASS_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerType)) { // Property ChildLabelNode
				graphicalType = ElementTypes.CLASS_PROPERTY_CLN.getSemanticHint();
			}
			if(ElementTypes.DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerType)) { // Property ChildLabelNode
				graphicalType = ElementTypes.DATA_TYPE_PROPERTY_CLN.getSemanticHint();
			}
			if(ElementTypes.DATA_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerType)) { // Property ChildLabelNode
				graphicalType = ElementTypes.DATA_TYPE_PROPERTY_CLN.getSemanticHint();
			}
			if(ElementTypes.PRIMITIVE_TYPE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerType)) { // Property ChildLabelNode
				graphicalType = ElementTypes.PRIMITIVE_TYPE_PROPERTY_CLN.getSemanticHint();
			}
			if(ElementTypes.PRIMITIVE_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerType)) { // Property ChildLabelNode
				graphicalType = ElementTypes.PRIMITIVE_TYPE_PROPERTY_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.Reception) {

			if(ElementTypes.CLASS_COMPARTMENT_OPERATION_HINT.equals(containerType)) { // Reception ChildLabelNode
				graphicalType = ElementTypes.CLASS_RECEPTION_CLN.getSemanticHint();
			}
			if(ElementTypes.CLASS_CN_COMPARTMENT_OPERATION_HINT.equals(containerType)) { // Reception ChildLabelNode
				graphicalType = ElementTypes.CLASS_RECEPTION_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.Operation) {

			if(ElementTypes.CLASS_COMPARTMENT_OPERATION_HINT.equals(containerType)) { // Operation ChildLabelNode
				graphicalType = ElementTypes.CLASS_OPERATION_CLN.getSemanticHint();
			}
			if(ElementTypes.CLASS_CN_COMPARTMENT_OPERATION_HINT.equals(containerType)) { // Operation ChildLabelNode
				graphicalType = ElementTypes.CLASS_OPERATION_CLN.getSemanticHint();
			}
			if(ElementTypes.DATA_TYPE_CN_COMPARTMENT_OPERATION_HINT.equals(containerType)) { // Operation ChildLabelNode
				graphicalType = ElementTypes.DATA_TYPE_OPERATION_CLN.getSemanticHint();
			}
			if(ElementTypes.DATA_TYPE_COMPARTMENT_OPERATION_HINT.equals(containerType)) { // Operation ChildLabelNode
				graphicalType = ElementTypes.DATA_TYPE_OPERATION_CLN.getSemanticHint();
			}
			if(ElementTypes.PRIMITIVE_TYPE_COMPARTMENT_OPERATION_HINT.equals(containerType)) { // Operation ChildLabelNode
				graphicalType = ElementTypes.PRIMITIVE_TYPE_OPERATION_CLN.getSemanticHint();
			}
			if(ElementTypes.PRIMITIVE_TYPE_CN_COMPARTMENT_OPERATION_HINT.equals(containerType)) { // Operation ChildLabelNode
				graphicalType = ElementTypes.PRIMITIVE_TYPE_OPERATION_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.Interface) {

			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // Interface ChildLabelNode
				graphicalType = ElementTypes.CLASS_INTERFACE_CLN.getSemanticHint();
			}
			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // Interface ChildLabelNode
				graphicalType = ElementTypes.CLASS_INTERFACE_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.Signal) {

			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // Signal ChildLabelNode
				graphicalType = ElementTypes.CLASS_SIGNAL_CLN.getSemanticHint();
			}
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerType)) { // Signal ChildLabelNode
				graphicalType = ElementTypes.CLASS_SIGNAL_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.EnumerationLiteral) {

			if(ElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerType)) { // EnumerationLiteral ChildLabelNode
				graphicalType = ElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint();
			}
			if(ElementTypes.ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerType)) { // EnumerationLiteral ChildLabelNode
				graphicalType = ElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint();
			}
		}

		return graphicalType;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNodeGraphicalType(IElementType elementType, String containerType) {
		if(elementType instanceof IHintedType) {
			String semanticHint = ((IHintedType)elementType).getSemanticHint();
			return getNodeGraphicalType(semanticHint, containerType);
		}

		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNodeGraphicalType(String proposedType, String containerType) {
		if(isKnownNodeType(proposedType)) {
			return proposedType;
		}

		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isKnownEdgeType(String type) {
		return knownEdges.contains(type);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isKnownNodeType(String type) {
		return knownNodes.contains(type);
	}
}
