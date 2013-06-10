/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.provider;

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
import org.eclipse.papyrus.uml.diagram.activity.providers.CustomUMLViewProvider;
import org.eclipse.papyrus.uml.diagram.interactionoverview.Activator;

public class InheritedActivityDiagramViewProvider extends CustomUMLViewProvider {

	/** Local graphical type registry */
	protected IGraphicalTypeRegistry registry = new GraphicalTypeRegistry();

	@Override
	public Edge createEdge(final IAdaptable semanticAdapter, final View containerView, final String semanticHint, final int index, final boolean persisted, final PreferencesHint preferencesHint) {
		Edge createdEdge = null;

		final IElementType elementType = (IElementType)semanticAdapter.getAdapter(IElementType.class);
		if(elementType != null) {
			createdEdge = super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		} else {

			final EObject domainElement = (EObject)semanticAdapter.getAdapter(EObject.class);

			String domainElementGraphicalType = semanticHint;
			if(domainElementGraphicalType == null) {
				domainElementGraphicalType = registry.getEdgeGraphicalType(domainElement);
			}

			if((!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(domainElementGraphicalType)) && (registry.isKnownEdgeType(domainElementGraphicalType))) {
				// Cannot use createEdge from super class as it never take the
				// graphical type (semanticHint) into account.
				// createdEdge = super.createEdge(semanticAdapter,
				// containerView, domainElementGraphicalType, index, persisted,
				// preferencesHint);

				if(ElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createCommentAnnotatedElement_4006(containerView, index, persisted, preferencesHint);
				}
				if(ElementTypes.CONTROL_FLOW.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createControlFlow_4004(domainElement, containerView, index, persisted, preferencesHint);
				}
			}
		}

		if(createdEdge == null) {
			Activator.log.error(new Exception("Could not create Edge."));
		}

		return createdEdge;
	}

	@Override
	protected boolean provides(final CreateViewForKindOperation op) {

		// This provider is registered for InteractionOverviewDiagram Diagram
		// only
		final String diagramType = op.getContainerView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		return true;
	}

	@Override
	protected boolean provides(final CreateEdgeViewOperation op) {

		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for InteractionOverviewDiagram Diagram
		// only
		final String diagramType = op.getContainerView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		final IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(elementType == ElementTypes.COMMENT_ANNOTATED_ELEMENT) {
			return true;
		}
		if(elementType == ElementTypes.CONTROL_FLOW) {
			return true;
		}

		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the semantic nature and
		// its expected container.
		// /////////////////////////////////////////////////////////////////////

		// IElementType may be null (especially when drop from ModelExplorer).
		// In such a case, test the semantic EObject instead.
		if(elementType == null) {
			final EObject domainElement = (EObject)op.getSemanticAdapter().getAdapter(EObject.class);
			String domainElementGraphicalType = op.getSemanticHint();
			if(domainElementGraphicalType == null) {
				domainElementGraphicalType = registry.getEdgeGraphicalType(domainElement);
			}

			if((!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(domainElementGraphicalType)) && (registry.isKnownEdgeType(domainElementGraphicalType))) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected boolean provides(final CreateNodeViewOperation op) {
		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}
		// Get the type of the container
		final String containerGraphicalType = op.getContainerView().getType();

		// This provider is registered for InteractionOverviewDiagram Diagram
		// only
		final String diagramType = op.getContainerView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the ElementType and its
		// expected container.
		// /////////////////////////////////////////////////////////////////////

		final IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if(elementType == ElementTypes.ACTIVITY_FINAL_NODE_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CALL_BEHAVIOR_ACTION_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.COMMENT_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CONDITIONAL_NODE_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.DECISION_NODE_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.FLOW_FINAL_NODE_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.FORK_NODE_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.INITIAL_NODE_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.JOIN_NODE_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.LOOP_NODE_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.MERGE_NODE_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.SHAPE_NAMED_ELEMENT_CN) {
			
		}
		if(elementType == ElementTypes.ACTIVITY) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.SEQUENCE_NODE_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CONSTRAINT_CN) {
			
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.ACTIVITY_PARAMETER_CLN) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_PARAMETER_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.ACTIVITY_CONSTRAINT_CLN) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_PRECONDITION_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.ACTIVITY_CONSTRAINT_CLN) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_POST_CONDTION_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}

		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the semantic nature and
		// its expected container.
		// /////////////////////////////////////////////////////////////////////

		// IElementType may be null (especially when drop from ModelExplorer).
		// In such a case, test the semantic EObject instead.
		if(elementType == null) {
			final EObject domainElement = (EObject)op.getSemanticAdapter().getAdapter(EObject.class);
			String domainElementGraphicalType = op.getSemanticHint();
			if(domainElementGraphicalType == null) {
				domainElementGraphicalType = registry.getNodeGraphicalType(domainElement, containerGraphicalType);
			} else {
				domainElementGraphicalType = registry.getNodeGraphicalType(domainElementGraphicalType, containerGraphicalType);
			}

			if((!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(domainElementGraphicalType)) && (registry.isKnownNodeType(domainElementGraphicalType))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Node createNode(final IAdaptable semanticAdapter, final View containerView, final String semanticHint, final int index, final boolean persisted, final PreferencesHint preferencesHint) {

		if(semanticHint != null) {
			return super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		}

		// Use the GraphicalTypeRegistry to find the expected type for a domain
		// element
		// Get the type of the container
		final String containerGraphicalType = containerView.getType();
		// Get the type of the domain element
		final EObject domainElement = (EObject)semanticAdapter.getAdapter(EObject.class);
		final String domainElementGraphicalType = registry.getNodeGraphicalType(domainElement, containerGraphicalType);

		// Create the expected node
		if(!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(domainElementGraphicalType)) {
			return super.createNode(semanticAdapter, containerView, domainElementGraphicalType, index, persisted, preferencesHint);
		}

		Activator.log.error(new Exception("Could not create Node."));
		return null;
	}

	@Override
	protected void stampShortcut(final View containerView, final Node target) {
		if(!ElementTypes.DIAGRAM_ID.equals(containerView.getDiagram().getType())) {
			final EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", ElementTypes.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
