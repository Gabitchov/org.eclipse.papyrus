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

package org.eclipse.papyrus.robotml.diagram.interfacedef.provider;

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
import org.eclipse.papyrus.robotml.diagram.interfacedef.Activator;
import org.eclipse.papyrus.robotml.diagram.interfacedef.edit.part.InterfaceDefEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;

public class InheritedClassDiagramViewProvider extends UMLViewProvider {

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		// No need to override here, assuming provides is correctly implemented.
		Edge createdEdge = super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);

		if(createdEdge == null) {
			Activator.log.error(new Exception("Could not create Edge."));
		}

		return createdEdge;
	}

	protected boolean provides(CreateViewForKindOperation op) {

		// This provider is registered for Internal Block Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!InterfaceDefEditPart.DIAGRAM_ID.equals(diagramType)) {
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

		// This provider is registered for InterfaceDef Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!InterfaceDefEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(elementType == InterfaceDefElementTypes.PACKAGE_IMPORT) {
			return true;
		}
		if(elementType == InterfaceDefElementTypes.COMMENT_ANNOTATED_ELEMENT) {
			return true;
		}
		if(elementType == InterfaceDefElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT) {
			return true;
		}
		if(elementType == InterfaceDefElementTypes.PACKAGE_MERGE) {
			return true;
		}
		if(elementType == InterfaceDefElementTypes.GENERALIZATION) {
			return true;
		}
		if(elementType == InterfaceDefElementTypes.INTERFACE_REALIZATION) {
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

		// This provider is registered for InterfaceDef Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!InterfaceDefEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the ElementType and its expected container.
		// /////////////////////////////////////////////////////////////////////


		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if(elementType == InterfaceDefElementTypes.PACKAGE) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == InterfaceDefElementTypes.COMMENT) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == InterfaceDefElementTypes.CONSTRAINT) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == InterfaceDefElementTypes.PACKAGE_CN) {
			if(InterfaceDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(InterfaceDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == InterfaceDefElementTypes.INTERFACE_CN) {
			if(InterfaceDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(InterfaceDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == InterfaceDefElementTypes.INTERFACE) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == InterfaceDefElementTypes.SHORT_CUT_DIAGRAM) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == InterfaceDefElementTypes.INTERFACE_PROPERTY_CLN) {
			if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == InterfaceDefElementTypes.INTERFACE_OPERATION_CLN) {
			if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == InterfaceDefElementTypes.INTERFACE_CLASS_CLN) {
			if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
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
				if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Package TopNode
					return true;
				}
				if(InterfaceDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
					return true;
				}
				if(InterfaceDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
				if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Comment TopNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
				if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Constraint TopNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Interface) {
				if(InterfaceDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Interface ChildNode
					return true;
				}
				if(InterfaceDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Interface ChildNode
					return true;
				}
				if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Interface TopNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Diagram TopNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Property) {

				if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
					return true;
				}
				if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
					return true;
				}
			}
			if(domainElement instanceof org.eclipse.uml2.uml.Operation) {

				if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) { // Operation ChildLabelNode
					return true;
				}
				if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) { // Operation ChildLabelNode
					return true;
				}
			}
			if(domainElement instanceof org.eclipse.uml2.uml.Class) {

				if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) { // Class ChildLabelNode
					return true;
				}
				if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) { // Class ChildLabelNode
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
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Package TopNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.PACKAGE.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(InterfaceDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.PACKAGE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(InterfaceDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.PACKAGE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Comment TopNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.COMMENT.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Constraint TopNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.CONSTRAINT.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Interface) {
			if(InterfaceDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Interface ChildNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.INTERFACE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(InterfaceDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Interface ChildNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.INTERFACE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Interface TopNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.INTERFACE.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Diagram TopNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.SHORT_CUT_DIAGRAM.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Property) {

			if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.INTERFACE_PROPERTY_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) { // Property ChildLabelNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.INTERFACE_PROPERTY_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
		}
		if(domainElement instanceof org.eclipse.uml2.uml.Operation) {

			if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) { // Operation ChildLabelNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.INTERFACE_OPERATION_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) { // Operation ChildLabelNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.INTERFACE_OPERATION_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
		}
		if(domainElement instanceof org.eclipse.uml2.uml.Class) {

			if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) { // Class ChildLabelNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.INTERFACE_CLASS_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) { // Class ChildLabelNode
				return super.createNode(semanticAdapter, containerView, InterfaceDefElementTypes.INTERFACE_CLASS_CLN.getSemanticHint(), index, persisted, preferencesHint);
			}
		}

		Activator.log.error(new Exception("Could not create Node."));
		return null;
	}

	@Override
	protected void stampShortcut(View containerView, Node target) {
		if(!InterfaceDefEditPart.DIAGRAM_ID.equals(containerView.getDiagram().getType())) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", InterfaceDefEditPart.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
