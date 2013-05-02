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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@1b2c55c7
			// (visualID: 3005, editPartClassName: ActivityFinalNodeEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityFinalNodeItemSemanticEditPolicy,
			// notationViewFactoryClassName: ActivityFinalNodeViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityFinalNodeCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// ActivityFinalNodeGraphicalNodeEditPolicy, createCommandClassName:
			// ActivityFinalNodeCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@533dc18
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@2c768384
			// (visualID: 3008, editPartClassName: CallBehaviorActionEditPart,
			// itemSemanticEditPolicyClassName:
			// CallBehaviorActionItemSemanticEditPolicy,
			// notationViewFactoryClassName: CallBehaviorActionViewFactory)
			// (canonicalEditPolicyClassName:
			// CallBehaviorActionCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// CallBehaviorActionGraphicalNodeEditPolicy,
			// createCommandClassName: CallBehaviorActionCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@fb6ae53
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@6b8ef251
			// (visualID: 3080, editPartClassName: CommentEditPartCN,
			// itemSemanticEditPolicyClassName: CommentItemSemanticEditPolicy,
			// notationViewFactoryClassName: CommentViewFactory)
			// (canonicalEditPolicyClassName: CommentCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName: CommentGraphicalNodeEditPolicy,
			// createCommandClassName: CommentCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@226ed334
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@52545b0f
			// (visualID: 3069, editPartClassName: ConditionalNodeEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeItemSemanticEditPolicy,
			// notationViewFactoryClassName: ConditionalNodeViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// ConditionalNodeGraphicalNodeEditPolicy, createCommandClassName:
			// ConditionalNodeCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@19ec0c95
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@637950d4
			// (visualID: 3038, editPartClassName: DecisionNodeEditPart,
			// itemSemanticEditPolicyClassName:
			// DecisionNodeItemSemanticEditPolicy, notationViewFactoryClassName:
			// DecisionNodeViewFactory) (canonicalEditPolicyClassName:
			// DecisionNodeCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// DecisionNodeGraphicalNodeEditPolicy, createCommandClassName:
			// DecisionNodeCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@582e177e
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@5d34de68
			// (visualID: 3006, editPartClassName: FlowFinalNodeEditPart,
			// itemSemanticEditPolicyClassName:
			// FlowFinalNodeItemSemanticEditPolicy,
			// notationViewFactoryClassName: FlowFinalNodeViewFactory)
			// (canonicalEditPolicyClassName: FlowFinalNodeCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// FlowFinalNodeGraphicalNodeEditPolicy, createCommandClassName:
			// FlowFinalNodeCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@3a087e6c
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@4a03cc69
			// (visualID: 3040, editPartClassName: ForkNodeEditPart,
			// itemSemanticEditPolicyClassName: ForkNodeItemSemanticEditPolicy,
			// notationViewFactoryClassName: ForkNodeViewFactory)
			// (canonicalEditPolicyClassName: ForkNodeCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// ForkNodeGraphicalNodeEditPolicy, createCommandClassName:
			// ForkNodeCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@3a40238
			// (name: ) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@7894a07a
			// (visualID: 3004, editPartClassName: InitialNodeEditPart,
			// itemSemanticEditPolicyClassName:
			// InitialNodeItemSemanticEditPolicy, notationViewFactoryClassName:
			// InitialNodeViewFactory) (canonicalEditPolicyClassName:
			// InitialNodeCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// InitialNodeGraphicalNodeEditPolicy, createCommandClassName:
			// InitialNodeCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@48dac66
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@61f1aec
			// (visualID: 3041, editPartClassName: JoinNodeEditPart,
			// itemSemanticEditPolicyClassName: JoinNodeItemSemanticEditPolicy,
			// notationViewFactoryClassName: JoinNodeViewFactory)
			// (canonicalEditPolicyClassName: JoinNodeCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// JoinNodeGraphicalNodeEditPolicy, createCommandClassName:
			// JoinNodeCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@71315edf
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@59c87ef9
			// (visualID: 3071, editPartClassName: LoopNodeEditPart,
			// itemSemanticEditPolicyClassName: LoopNodeItemSemanticEditPolicy,
			// notationViewFactoryClassName: LoopNodeViewFactory)
			// (canonicalEditPolicyClassName: LoopNodeCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// LoopNodeGraphicalNodeEditPolicy, createCommandClassName:
			// LoopNodeCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@604bbc87
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@3819222f
			// (visualID: 3039, editPartClassName: MergeNodeEditPart,
			// itemSemanticEditPolicyClassName: MergeNodeItemSemanticEditPolicy,
			// notationViewFactoryClassName: MergeNodeViewFactory)
			// (canonicalEditPolicyClassName: MergeNodeCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// MergeNodeGraphicalNodeEditPolicy, createCommandClassName:
			// MergeNodeCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@c467475
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@c12dc5f
			// (visualID: 3085, editPartClassName: ShapeNamedElementEditPart,
			// itemSemanticEditPolicyClassName:
			// ShapeNamedElementItemSemanticEditPolicy,
			// notationViewFactoryClassName: null)
			// (canonicalEditPolicyClassName:
			// ShapeNamedElementCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// ShapeNamedElementGraphicalNodeEditPolicy, createCommandClassName:
			// ShapeNamedElementCreateCommand)
			// containers:
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@6587b39e
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
		}
		if(elementType == ElementTypes.ACTIVITY) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.SEQUENCE_NODE_CN) {
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@37a34401
			// (visualID: 3073, editPartClassName: SequenceNodeEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeItemSemanticEditPolicy, notationViewFactoryClassName:
			// SequenceNodeViewFactory) (canonicalEditPolicyClassName:
			// SequenceNodeCanonicalEditPolicy)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// SequenceNodeGraphicalNodeEditPolicy, createCommandClassName:
			// SequenceNodeCreateCommand)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@68bbc547
			// (visualID: 7013, editPartClassName:
			// ActivityCNContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityCNContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityCNContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@66e0c7d2
			// (name: null) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
			// node:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@1d69a67
			// (visualID: 3112, editPartClassName: ConstraintEditPartCN,
			// itemSemanticEditPolicyClassName:
			// ConstraintItemSemanticEditPolicyCN, notationViewFactoryClassName:
			// null) (canonicalEditPolicyClassName:
			// ConstraintCanonicalEditPolicyCN)
			// (primaryDragEditPolicyQualifiedClassName: null,
			// graphicalNodeEditPolicyClassName:
			// ConstraintGraphicalNodeEditPolicyCN, createCommandClassName:
			// ConstraintCreateCommandCN)
			// containers:
			// org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@db986d8
			// (visualID: 7004, editPartClassName:
			// ActivityActivityContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityActivityContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityActivityContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityActivityContentCompartmentCanonicalEditPolicy) (title:
			// ActivityFigureContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@20266003
			// (visualID: 7008, editPartClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ConditionalNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7f94ee08
			// (visualID: 7009, editPartClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ExpansionRegionStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@7a083b7b
			// (visualID: 7010, editPartClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// LoopNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3fc5ba30
			// (visualID: 7012, editPartClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// SequenceNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@a9790a8
			// (visualID: 7005, editPartClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// StructuredActivityNodeStructuredActivityNodeContentCompartmentCanonicalEditPolicy)
			// (title: StructuredActivityNodeContentCompartment, canCollapse:
			// false, hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@649a0b06
			// (visualID: 7006, editPartClassName:
			// ActivityPartitionActivityPartitionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// ActivityPartitionActivityPartitionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// ActivityPartitionActivityPartitionContentCompartmentCanonicalEditPolicy)
			// (title: ActivityPartitionContentCompartment, canCollapse: false,
			// hideIfEmpty: true, needsTitle: false, listLayout:
			// false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@3d49ea83
			// (visualID: 7007, editPartClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart,
			// itemSemanticEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy,
			// notationViewFactoryClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentViewFactory)
			// (canonicalEditPolicyClassName:
			// InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentCanonicalEditPolicy)
			// (title: InterruptibleActivityRegionContentCompartment,
			// canCollapse: false, hideIfEmpty: true, needsTitle: false,
			// listLayout: false)
			// nodeRef:
			// org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@2f5ee0c2
			// (name: ) (customPreferencePage: null, generatePreferencePage:
			// true, generateTool: true)
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
