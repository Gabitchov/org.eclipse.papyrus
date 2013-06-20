/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.robotml.diagram.datatypedef.provider;

import static org.eclipse.papyrus.infra.core.Activator.log;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.robotml.diagram.datatypedef.edit.part.DatatypeDefEditPart;

public class InheritedClassDiagramViewProvider extends UMLViewProvider {

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		// No need to override here, assuming provides is correctly implemented.
		Edge createdEdge = super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);

		if(createdEdge == null) {
			log.error(new Exception("Could not create Edge."));
		}

		return createdEdge;
	}

	protected boolean provides(CreateViewForKindOperation op) {

		// This provider is registered for Internal Block Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!DatatypeDefEditPart.DIAGRAM_ID.equals(diagramType)) {

			return false;
		}


		return true;
	}

	@Override
	protected boolean provides(CreateEdgeViewOperation op) {

		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for DatatypeDef Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!DatatypeDefEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(elementType == DatatypeDefElementTypes.DEPENDENCY) {
			return true;
		}
		if(elementType == DatatypeDefElementTypes.PACKAGE_IMPORT) {
			return true;
		}
		if(elementType == DatatypeDefElementTypes.COMMENT_ANNOTATED_ELEMENT) {
			return true;
		}
		if(elementType == DatatypeDefElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT) {
			return true;
		}
		if(elementType == DatatypeDefElementTypes.PACKAGE_MERGE) {
			return true;
		}
		if(elementType == DatatypeDefElementTypes.ELEMENT_IMPORT) {
			return true;
		}
		if(elementType == DatatypeDefElementTypes.ASSOCIATION) {
			return true;
		}
		if(elementType == DatatypeDefElementTypes.GENERALIZATION) {
			return true;
		}

		return false;
	}

	@Override
	protected boolean provides(CreateNodeViewOperation op) {
		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}
		// Get the type of the container
		String containerGraphicalType = op.getContainerView().getType();

		// This provider is registered for DatatypeDef Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!DatatypeDefEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the ElementType and its expected container.
		// /////////////////////////////////////////////////////////////////////


		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if(elementType == DatatypeDefElementTypes.PACKAGE) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.ENUMERATION) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.COMMENT) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.CONSTRAINT) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.DATA_TYPE) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.PRIMITIVE_TYPE) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.SIGNAL) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.PACKAGE_CN) {
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.DATA_TYPE_CN) {
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.ENUMERATION_CN) {
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.PRIMITIVE_TYPE_CN) {
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN) {
			if(DatatypeDefElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.SIGNAL_CN) {
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.COMMENT_CN) {
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.CONSTRAINT_CN) {
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.SHORT_CUT_DIAGRAM) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN) {
			if(DatatypeDefElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.DATA_TYPE_PROPERTY_CLN) {
			if(DatatypeDefElementTypes.DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.DATA_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.DATA_TYPE_OPERATION_CLN) {
			if(DatatypeDefElementTypes.DATA_TYPE_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.DATA_TYPE_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == DatatypeDefElementTypes.SIGNAL_PROPERTY_CLN) {
			if(DatatypeDefElementTypes.SIGNAL_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(DatatypeDefElementTypes.SIGNAL_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}


		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the semantic nature and its expected container.
		// /////////////////////////////////////////////////////////////////////


		// IElementType may be null (especially when drop from ModelExplorer).
		// In such a case, test the semantic EObject instead.
		if(elementType == null) {

			EObject domainElement = (EObject)op.getSemanticAdapter().getAdapter(EObject.class);
			if(domainElement instanceof org.eclipse.uml2.uml.Package) {
				if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Package TopNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Enumeration) {
				if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Enumeration TopNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Enumeration ChildNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Enumeration ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
				if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Comment TopNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Comment ChildNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Comment ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
				if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Constraint TopNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Constraint ChildNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Constraint ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.DataType) {
				if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // DataType TopNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // DataType ChildNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // DataType ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.PrimitiveType) {
				if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // PrimitiveType TopNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // PrimitiveType ChildNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // PrimitiveType ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Signal) {
				if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Signal TopNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Signal ChildNode
					return true;
				}
				if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Signal ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.EnumerationLiteral) {
				if(DatatypeDefElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) { // EnumerationLiteral ChildNode
					return true;
				}
				if(DatatypeDefElementTypes.ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) { // EnumerationLiteral ChildNode
					return true;
				}

				if(DatatypeDefElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) { // EnumerationLiteral ChildLabelNode
					return true;
				}
				if(DatatypeDefElementTypes.ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) { // EnumerationLiteral ChildLabelNode
					return true;
				}
			}
			if(domainElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Diagram TopNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Property) {

				if(DatatypeDefElementTypes.SIGNAL_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
					return true;
				}
				if(DatatypeDefElementTypes.SIGNAL_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
					return true;
				}
				if(DatatypeDefElementTypes.DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
					return true;
				}
				if(DatatypeDefElementTypes.DATA_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
					return true;
				}
			}
			if(domainElement instanceof org.eclipse.uml2.uml.Operation) {

				if(DatatypeDefElementTypes.DATA_TYPE_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) { // Operation ChildLabelNode
					return true;
				}
				if(DatatypeDefElementTypes.DATA_TYPE_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) { // Operation ChildLabelNode
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {


		if(semanticHint != null) {
			return super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		}

		// SemanticHint may be null when the element is created indirectly by
		// DND from model explorer
		// ex: Drag and drop a Connector may require to show ConnectorEnd first.
		EObject domainElement = (EObject)semanticAdapter.getAdapter(EObject.class);

		// Get the type of the container
		String containerGraphicalType = containerView.getType();

		if(domainElement instanceof org.eclipse.uml2.uml.Package) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Package TopNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.PACKAGE.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.PACKAGE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.PACKAGE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Enumeration) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Enumeration TopNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.ENUMERATION.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Enumeration ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.ENUMERATION_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Enumeration ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.ENUMERATION_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Comment TopNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.COMMENT.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Comment ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.COMMENT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Comment ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.COMMENT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Constraint TopNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.CONSTRAINT.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Constraint ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.CONSTRAINT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Constraint ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.CONSTRAINT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.DataType) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // DataType TopNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.DATA_TYPE.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // DataType ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.DATA_TYPE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // DataType ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.DATA_TYPE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.PrimitiveType) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // PrimitiveType TopNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.PRIMITIVE_TYPE.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // PrimitiveType ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.PRIMITIVE_TYPE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // PrimitiveType ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.PRIMITIVE_TYPE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Signal) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Signal TopNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.SIGNAL.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Signal ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.SIGNAL_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Signal ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.SIGNAL_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.EnumerationLiteral) {
			if(DatatypeDefElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) { // EnumerationLiteral ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) { // EnumerationLiteral ChildNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}

			if(DatatypeDefElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) { // EnumerationLiteral ChildLabelNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) { // EnumerationLiteral ChildLabelNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
		}
		if(domainElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Diagram TopNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.SHORT_CUT_DIAGRAM.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Property) {

			if(DatatypeDefElementTypes.SIGNAL_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.SIGNAL_PROPERTY_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.SIGNAL_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.SIGNAL_PROPERTY_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.DATA_TYPE_PROPERTY_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.DATA_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.DATA_TYPE_PROPERTY_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
		}
		if(domainElement instanceof org.eclipse.uml2.uml.Operation) {

			if(DatatypeDefElementTypes.DATA_TYPE_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) { // Operation ChildLabelNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.DATA_TYPE_OPERATION_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(DatatypeDefElementTypes.DATA_TYPE_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) { // Operation ChildLabelNode
				return super.createNode(semanticAdapter, containerView, DatatypeDefElementTypes.DATA_TYPE_OPERATION_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
		}

		log.error(new Exception("Could not create Node."));
		return null;
	}

	@Override
	protected void stampShortcut(View containerView, Node target) {
		if(!DatatypeDefEditPart.DIAGRAM_ID.equals(containerView.getDiagram().getType())) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", DatatypeDefEditPart.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
