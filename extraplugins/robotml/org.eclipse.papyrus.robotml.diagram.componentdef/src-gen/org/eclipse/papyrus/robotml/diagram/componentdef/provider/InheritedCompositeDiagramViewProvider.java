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

package org.eclipse.papyrus.robotml.diagram.componentdef.provider;

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
import org.eclipse.papyrus.robotml.diagram.componentdef.Activator;
import org.eclipse.papyrus.robotml.diagram.componentdef.edit.part.ComponentdefDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLViewProvider;

public class InheritedCompositeDiagramViewProvider extends UMLViewProvider {

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
		if(!ComponentdefDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
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

		// This provider is registered for Componentdef Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!ComponentdefDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(elementType == ComponentdefDiagramElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT) {
			return true;
		}
		if(elementType == ComponentdefDiagramElementTypes.COMMENT_ANNOTATED_ELEMENT) {
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

		// This provider is registered for Componentdef Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!ComponentdefDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the ElementType and its expected container.
		// /////////////////////////////////////////////////////////////////////


		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if(elementType == ComponentdefDiagramElementTypes.CLASS) {
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ComponentdefDiagramElementTypes.PORT_CN) {
			if(ComponentdefDiagramElementTypes.CLASS.getSemanticHint().equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN.getSemanticHint().equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN.getSemanticHint().equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ComponentdefDiagramElementTypes.COMMENT) {
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ComponentdefDiagramElementTypes.CONSTRAINT) {
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ComponentdefDiagramElementTypes.PROPERTY_CN) {
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ComponentdefDiagramElementTypes.PACKAGE_CN) {
			if(ComponentdefDiagramElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ComponentdefDiagramElementTypes.PACKAGE) {
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ComponentdefDiagramElementTypes.COMMENT_CN) {
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ComponentdefDiagramElementTypes.CLASS_CN) {
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ComponentdefDiagramElementTypes.CONSTRAINT_CN) {
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
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
			if(domainElement instanceof org.eclipse.uml2.uml.Class) {
				if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Class TopNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Class ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Class ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Port) {
				if(ComponentdefDiagramElementTypes.CLASS.getSemanticHint().equals(containerGraphicalType)) { // Port ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.CLASS_CN.getSemanticHint().equals(containerGraphicalType)) { // Port ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.PROPERTY_CN.getSemanticHint().equals(containerGraphicalType)) { // Port ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Port ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Port ChildNode
					return false;
				}
				if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) { // Port ChildNode
					return false;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
				if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Comment TopNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Comment ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Comment ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) { // Comment ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
				if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Constraint TopNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Constraint ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Constraint ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Property) {
				if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Property ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Property ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) { // Property ChildNode
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Package) {
				if(ComponentdefDiagramElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
					return true;
				}
				if(ComponentdefDiagramElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
					return true;
				}
				if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Package TopNode
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

		if(domainElement instanceof org.eclipse.uml2.uml.Class) {
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Class TopNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.CLASS.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Class ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.CLASS_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Class ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.CLASS_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Port) {
			if(ComponentdefDiagramElementTypes.CLASS.getSemanticHint().equals(containerGraphicalType)) { // Port ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN.getSemanticHint().equals(containerGraphicalType)) { // Port ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN.getSemanticHint().equals(containerGraphicalType)) { // Port ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Port ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Port ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) { // Port ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Comment TopNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.COMMENT.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Comment ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.COMMENT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Comment ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.COMMENT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) { // Comment ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.COMMENT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Constraint TopNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.CONSTRAINT.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Constraint ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.CONSTRAINT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Constraint ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.CONSTRAINT_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Property) {
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Property ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PROPERTY_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) { // Property ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PROPERTY_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) { // Property ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PROPERTY_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		}
		if(domainElement instanceof org.eclipse.uml2.uml.Package) {
			if(ComponentdefDiagramElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PACKAGE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) { // Package ChildNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PACKAGE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) { // Package TopNode
				return super.createNode(semanticAdapter, containerView, ComponentdefDiagramElementTypes.PACKAGE.getSemanticHint(), index, persisted, preferencesHint);
			}

		}

		Activator.log.error(new Exception("Could not create Node."));
		return null;
	}

	@Override
	protected void stampShortcut(View containerView, Node target) {
		if(!ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerView.getDiagram().getType())) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", ComponentdefDiagramEditPart.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
