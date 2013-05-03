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
package org.eclipse.papyrus.uml.diagram.pkg.provider;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

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
		knownEdges.add(ElementTypes.DEPENDENCY.getSemanticHint());
		knownEdges.add(ElementTypes.PACKAGE_IMPORT.getSemanticHint());
		knownEdges.add(ElementTypes.ABSTRACTION.getSemanticHint());
		knownEdges.add(ElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint());
		knownEdges.add(ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT.getSemanticHint());

		// Fill known nodes set (primary nodes)
		knownNodes.add(ElementTypes.PACKAGE.getSemanticHint());
		knownNodes.add(ElementTypes.PACKAGE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.COMMENT.getSemanticHint());
		knownNodes.add(ElementTypes.COMMENT_CN.getSemanticHint());
		knownNodes.add(ElementTypes.CONSTRAINT.getSemanticHint());
		knownNodes.add(ElementTypes.CONSTRAINT_CN.getSemanticHint());
		knownNodes.add(ElementTypes.MODEL.getSemanticHint());
		knownNodes.add(ElementTypes.MODEL_CN.getSemanticHint());

		// Fill known nodes set (child label nodes)
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEdgeGraphicalType(EObject domainElement) {

		String graphicalType = UNDEFINED_TYPE;
		if(domainElement == null) {
			return UNDEFINED_TYPE;
		}
		if(domainElement instanceof org.eclipse.uml2.uml.Dependency) {
			graphicalType = ElementTypes.DEPENDENCY.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.PackageImport) {
			graphicalType = ElementTypes.PACKAGE_IMPORT.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.Abstraction) {
			graphicalType = ElementTypes.ABSTRACTION.getSemanticHint();
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
