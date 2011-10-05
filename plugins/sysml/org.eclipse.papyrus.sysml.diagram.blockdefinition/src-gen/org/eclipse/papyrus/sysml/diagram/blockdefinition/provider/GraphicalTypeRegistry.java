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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.gmf.diagram.common.provider.IGraphicalTypeRegistry;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

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
		knownEdges.add(ElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint());
		knownEdges.add(ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT.getSemanticHint());

		// Fill known nodes set (primary nodes)
		knownNodes.add(UMLElementTypes.MODEL.getSemanticHint());
		knownNodes.add(UMLElementTypes.PACKAGE.getSemanticHint());
		knownNodes.add(UMLElementTypes.INSTANCE_SPECIFICATION.getSemanticHint());
		knownNodes.add(UMLElementTypes.CONSTRAINT.getSemanticHint());
		knownNodes.add(UMLElementTypes.COMMENT.getSemanticHint());
		
		knownNodes.add(ElementTypes.MODEL.getSemanticHint());
		knownNodes.add(ElementTypes.MODEL_CN.getSemanticHint());
		knownNodes.add(ElementTypes.PACKAGE.getSemanticHint());
		knownNodes.add(ElementTypes.PACKAGE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.INSTANCE_SPECIFICATION.getSemanticHint());
		knownNodes.add(ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint());
		knownNodes.add(ElementTypes.CONSTRAINT.getSemanticHint());
		knownNodes.add(ElementTypes.CONSTRAINT_CN.getSemanticHint());
		knownNodes.add(ElementTypes.COMMENT.getSemanticHint());
		knownNodes.add(ElementTypes.COMMENT_CN.getSemanticHint());

		// Fill known nodes set (child label nodes)
		knownNodes.add(UMLElementTypes.SLOT.getSemanticHint());
		knownNodes.add(ElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN.getSemanticHint());
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEdgeGraphicalType(EObject domainElement) {

		String graphicalType = UNDEFINED_TYPE;
		if(domainElement == null) {
			return UNDEFINED_TYPE;
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

		if(domainElement instanceof org.eclipse.uml2.uml.Model) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Model TopNode
				graphicalType = ElementTypes.MODEL.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Model ChildNode
				graphicalType = ElementTypes.MODEL_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Model ChildNode
				graphicalType = ElementTypes.MODEL_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Model ChildNode
				graphicalType = ElementTypes.MODEL_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Model ChildNode
				graphicalType = ElementTypes.MODEL_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.Package) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Package TopNode
				graphicalType = ElementTypes.PACKAGE.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Package ChildNode
				graphicalType = ElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Package ChildNode
				graphicalType = ElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Package ChildNode
				graphicalType = ElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Package ChildNode
				graphicalType = ElementTypes.PACKAGE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.InstanceSpecification) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // InstanceSpecification TopNode
				graphicalType = ElementTypes.INSTANCE_SPECIFICATION.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // InstanceSpecification ChildNode
				graphicalType = ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // InstanceSpecification ChildNode
				graphicalType = ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // InstanceSpecification ChildNode
				graphicalType = ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // InstanceSpecification ChildNode
				graphicalType = ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Constraint TopNode
				graphicalType = ElementTypes.CONSTRAINT.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				graphicalType = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				graphicalType = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				graphicalType = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				graphicalType = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Comment TopNode
				graphicalType = ElementTypes.COMMENT.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Comment ChildNode
				graphicalType = ElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Comment ChildNode
				graphicalType = ElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Comment ChildNode
				graphicalType = ElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Comment ChildNode
				graphicalType = ElementTypes.COMMENT_CN.getSemanticHint();
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

		// Explicitly forbid Comment or Constraint creation using ElementType defined in Class Diagram
		// A better implementation should be provided, this one is not subtle but should have minimal side effect
		// (see bug #348550)

		if(UMLElementTypes.MODEL.getSemanticHint().equals(proposedType)) {

			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Constraint TopNode
				return ElementTypes.MODEL.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.MODEL_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.MODEL_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.MODEL_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.MODEL_CN.getSemanticHint();
			}

			return UNDEFINED_TYPE;
		}
		
		if(UMLElementTypes.PACKAGE.getSemanticHint().equals(proposedType)) {

			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Constraint TopNode
				return ElementTypes.PACKAGE.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.PACKAGE_CN.getSemanticHint();
			}

			return UNDEFINED_TYPE;
		}
		
		if((UMLElementTypes.COMMENT.getSemanticHint().equals(proposedType))) {

			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Constraint TopNode
				return ElementTypes.COMMENT.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.COMMENT_CN.getSemanticHint();
			}

			return UNDEFINED_TYPE;
		}

		if(UMLElementTypes.CONSTRAINT.getSemanticHint().equals(proposedType)) {

			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Constraint TopNode
				return ElementTypes.CONSTRAINT.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}

			return UNDEFINED_TYPE;
		}

		if(UMLElementTypes.INSTANCE_SPECIFICATION.getSemanticHint().equals(proposedType)) {

			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Constraint TopNode
				return ElementTypes.INSTANCE_SPECIFICATION.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint();
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint();
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.INSTANCE_SPECIFICATION_CN.getSemanticHint();
			}

			return UNDEFINED_TYPE;
		}
		
		if(UMLElementTypes.SLOT.getSemanticHint().equals(proposedType)) {

			if(ElementTypes.INSTANCE_SPECIFICATION_CN_COMPARTMENT_SLOT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN.getSemanticHint();
			}
			if(ElementTypes.INSTANCE_SPECIFICATION_COMPARTMENT_SLOT_HINT.equals(containerType)) { // Constraint ChildNode
				return ElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN.getSemanticHint();
			}

			return UNDEFINED_TYPE;
		}
		// Initial implementation (to be improved - see : getNodeGraphicalType(EObject domainElement, String containerType))
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
