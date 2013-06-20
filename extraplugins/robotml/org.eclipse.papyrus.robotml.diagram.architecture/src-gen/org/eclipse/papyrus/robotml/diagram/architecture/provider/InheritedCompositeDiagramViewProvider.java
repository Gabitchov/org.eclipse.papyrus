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
package org.eclipse.papyrus.robotml.diagram.architecture.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.robotml.diagram.architecture.Activator;
import org.eclipse.papyrus.robotml.diagram.architecture.edit.part.ArchitectureDiagramEditPart;
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

	@Override
	protected boolean provides(CreateViewForKindOperation op) {

		// This provider is registered for Internal Block Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!ArchitectureDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
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

		// This provider is registered for Architecture Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!ArchitectureDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(elementType == ArchitectureDiagramElementTypes.CONNECTOR) {
			return true;
		}

		if(elementType == ArchitectureDiagramElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT) {
			return true;
		}
		if(elementType == ArchitectureDiagramElementTypes.COMMENT_ANNOTATED_ELEMENT) {
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

		// This provider is registered for Architecture Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!ArchitectureDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the ElementType and its expected container.
		// /////////////////////////////////////////////////////////////////////


		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if(elementType == ArchitectureDiagramElementTypes.CLASS) {

			if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				//System.err.println("class");
				return true;
			}
		}

		if(elementType == ArchitectureDiagramElementTypes.PORT_CN) {
			//System.err.println("provides port view == true");
			return true;
		}
		if(elementType == ArchitectureDiagramElementTypes.PROPERTY_CN) {
			if(ArchitectureDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ArchitectureDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ArchitectureDiagramElementTypes.COMMENT) {
			if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ArchitectureDiagramElementTypes.CONSTRAINT) {
			if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
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
				if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Port) {
				if(ArchitectureDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
					return false;
				}
				if(ArchitectureDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) {
					return false;
				}
				if(ArchitectureDiagramElementTypes.PROPERTY_CN.equals(containerGraphicalType)) {
					return true;
				}
				if(ArchitectureDiagramElementTypes.CLASS.equals(containerGraphicalType)) {
					return true;
				}

				if(ArchitectureDiagramElementTypes.CLASS_CN.equals(containerGraphicalType)) {
					return true;
				}
				if(ArchitectureDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
					return true;
				}
				return true;



			}
			if(domainElement instanceof org.eclipse.uml2.uml.Property) {
				if(ArchitectureDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalType)) {
					return true;
				}
				if(ArchitectureDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalType)) {
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
				if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
					return true;
				}

			}
			if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
				if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalType)) {
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
		EObject eobject = (EObject)semanticAdapter.getAdapter(EObject.class);

		if((eobject instanceof org.eclipse.uml2.uml.Class) && (containerView instanceof Diagram)) { // Class TopNode
			return super.createNode(semanticAdapter, containerView, ArchitectureDiagramElementTypes.CLASS.getSemanticHint(), index, persisted, preferencesHint);
		}
		if((eobject instanceof org.eclipse.uml2.uml.Port) && !(containerView instanceof Diagram)) { // Port ChildNode
			//System.err.println("creates port view");
			return super.createNode(semanticAdapter, containerView, ArchitectureDiagramElementTypes.PORT_CN.getSemanticHint(), index, persisted, preferencesHint);
		}
		if((eobject instanceof org.eclipse.uml2.uml.Property) && !(containerView instanceof Diagram)) { // Property ChildNode
			return super.createNode(semanticAdapter, containerView, ArchitectureDiagramElementTypes.PROPERTY_CN.getSemanticHint(), index, persisted, preferencesHint);
		}
		if((eobject instanceof org.eclipse.uml2.uml.Comment) && (containerView instanceof Diagram)) { // Comment TopNode
			return super.createNode(semanticAdapter, containerView, ArchitectureDiagramElementTypes.COMMENT.getSemanticHint(), index, persisted, preferencesHint);
		}
		if((eobject instanceof org.eclipse.uml2.uml.Constraint) && (containerView instanceof Diagram)) { // Constraint TopNode
			return super.createNode(semanticAdapter, containerView, ArchitectureDiagramElementTypes.CONSTRAINT.getSemanticHint(), index, persisted, preferencesHint);
		}


		Activator.log.error(new Exception("Could not create Node."));
		return null;
	}

	@Override
	protected void stampShortcut(View containerView, Node target) {
		if(!ArchitectureDiagramEditPart.DIAGRAM_ID.equals(containerView.getDiagram().getType())) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", ArchitectureDiagramEditPart.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
