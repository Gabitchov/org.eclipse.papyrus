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
import org.eclipse.papyrus.uml.diagram.pkg.Activator;

public class InheritedClassDiagramViewProvider extends UMLViewProvider {

	/** Local graphical type registry */
	protected IGraphicalTypeRegistry registry = new GraphicalTypeRegistry();

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge createdEdge = null;

		IElementType elementType = (IElementType)semanticAdapter.getAdapter(IElementType.class);
		if(elementType != null) {
			createdEdge = super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		} else {

			EObject domainElement = (EObject)semanticAdapter.getAdapter(EObject.class);

			String domainElementGraphicalType = semanticHint;
			if(domainElementGraphicalType == null) {
				domainElementGraphicalType = registry.getEdgeGraphicalType(domainElement);
			}

			if((!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(domainElementGraphicalType)) && (registry.isKnownEdgeType(domainElementGraphicalType))) {
				// Cannot use createEdge from super class as it never take the graphical type (semanticHint) into account.
				// createdEdge = super.createEdge(semanticAdapter, containerView, domainElementGraphicalType, index, persisted, preferencesHint);

				if(ElementTypes.DEPENDENCY.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createDependency_4008(domainElement, containerView, index, persisted, preferencesHint);
				}
				if(ElementTypes.PACKAGE_IMPORT.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createPackageImport_4010(domainElement, containerView, index, persisted, preferencesHint);
				}
				if(ElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createCommentAnnotatedElement_4013(containerView, index, persisted, preferencesHint);
				}
				if(ElementTypes.ABSTRACTION.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createAbstraction_4006(domainElement, containerView, index, persisted, preferencesHint);
				}
			}
		}

		if(createdEdge == null) {
			Activator.log.error(new Exception("Could not create Edge."));
		}

		return createdEdge;
	}

	@Override
	protected boolean provides(CreateViewForKindOperation op) {

		// This provider is registered for Package Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
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

		// This provider is registered for Package Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(elementType == ElementTypes.DEPENDENCY) {
			return true;
		}
		if(elementType == ElementTypes.PACKAGE_IMPORT) {
			return true;
		}
		if(elementType == ElementTypes.COMMENT_ANNOTATED_ELEMENT) {
			return true;
		}
		if(elementType == ElementTypes.ABSTRACTION) {
			return true;
		}

		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the semantic nature and its expected container.
		// /////////////////////////////////////////////////////////////////////

		// IElementType may be null (especially when drop from ModelExplorer).
		// In such a case, test the semantic EObject instead.	
		if(elementType == null) {
			EObject domainElement = (EObject)op.getSemanticAdapter().getAdapter(EObject.class);
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
	protected boolean provides(CreateNodeViewOperation op) {
		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}
		// Get the type of the container
		String containerGraphicalType = op.getContainerView().getType();

		// This provider is registered for Package Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// /////////////////////////////////////////////////////////////////////
		// Test possibility to provide a view based on the ElementType and its expected container.
		// /////////////////////////////////////////////////////////////////////

		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if(elementType == ElementTypes.PACKAGE) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.PACKAGE_CN) {
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@50b7ae59 (visualID: 3009, editPartClassName: PackageEditPartCN, itemSemanticEditPolicyClassName: PackageItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackageCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: PackageGraphicalNodeEditPolicyCN, createCommandClassName: PackageCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@736f59d6 (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@13e0530f (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1fb23f90 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@67ed45da (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@3abff44d (name: null) (customPreferencePage: org.eclipse.papyrus.uml.diagram.pkg.CustomPackagePreferencePage, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.COMMENT) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.COMMENT_CN) {
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@5dba803e (visualID: 3028, editPartClassName: CommentEditPartCN, itemSemanticEditPolicyClassName: CommentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: CommentCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: CommentGraphicalNodeEditPolicyCN, createCommandClassName: CommentCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@736f59d6 (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@13e0530f (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1fb23f90 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@67ed45da (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@5c26c100 (name: null) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CONSTRAINT) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CONSTRAINT_CN) {
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@202eed62 (visualID: 3029, editPartClassName: ConstraintEditPartCN, itemSemanticEditPolicyClassName: ConstraintItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ConstraintCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: ConstraintGraphicalNodeEditPolicyCN, createCommandClassName: ConstraintCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@736f59d6 (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@13e0530f (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1fb23f90 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@67ed45da (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@6a54c459 (name: null) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.MODEL) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.MODEL_CN) {
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@6a26e5b2 (visualID: 3024, editPartClassName: ModelEditPartCN, itemSemanticEditPolicyClassName: ModelItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: ModelGraphicalNodeEditPolicyCN, createCommandClassName: ModelCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@736f59d6 (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@13e0530f (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1fb23f90 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@67ed45da (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@eab9103 (name: null) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
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
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {

		if(semanticHint != null) {
			return super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		}

		// Use the GraphicalTypeRegistry to find the expected type for a domain element
		// Get the type of the container
		String containerGraphicalType = containerView.getType();
		// Get the type of the domain element
		EObject domainElement = (EObject)semanticAdapter.getAdapter(EObject.class);
		String domainElementGraphicalType = registry.getNodeGraphicalType(domainElement, containerGraphicalType);

		// Create the expected node
		if(!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(domainElementGraphicalType)) {
			return super.createNode(semanticAdapter, containerView, domainElementGraphicalType, index, persisted, preferencesHint);
		}

		Activator.log.error(new Exception("Could not create Node."));
		return null;
	}

	@Override
	protected void stampShortcut(View containerView, Node target) {
		if(!ElementTypes.DIAGRAM_ID.equals(containerView.getDiagram().getType())) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", ElementTypes.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
