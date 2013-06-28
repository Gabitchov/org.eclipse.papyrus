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
import org.eclipse.papyrus.infra.gmfdiag.common.providers.IGraphicalTypeRegistry;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.uml.diagram.domain.Activator;

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

				if(ElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createCommentAnnotatedElement_4013(containerView, index, persisted, preferencesHint);
				}
				if(ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createConstraintConstrainedElement_4014(containerView, index, persisted, preferencesHint);
				}
				if(ElementTypes.GENERALIZATION.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createGeneralization_4002(domainElement, containerView, index, persisted, preferencesHint);
				}
				if(ElementTypes.INSTANCE_SPECIFICATION_LINK.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createInstanceSpecification_4021(domainElement, containerView, index, persisted, preferencesHint);
				}
				if(ElementTypes.ASSOCIATION.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createAssociation_4001(domainElement, containerView, index, persisted, preferencesHint);
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

		// This provider is registered for Domain Diagram only
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

		// This provider is registered for Domain Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(elementType == ElementTypes.COMMENT_ANNOTATED_ELEMENT) {
			return true;
		}
		if(elementType == ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT) {
			return true;
		}
		if(elementType == ElementTypes.GENERALIZATION) {
			return true;
		}
		if(elementType == ElementTypes.INSTANCE_SPECIFICATION) {
			return true;
		}
		if(elementType == ElementTypes.ASSOCIATION) {
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

		// This provider is registered for Domain Diagram only
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
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@5755829a (visualID: 3009, editPartClassName: PackageEditPartCN, itemSemanticEditPolicyClassName: PackageItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackageCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: PackageGraphicalNodeEditPolicyCN, createCommandClassName: PackageCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@6f4fb27a (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@42bb5c7d (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1ab534c5 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@5f946847 (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@143f35fb (name: null) (customPreferencePage: , generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
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
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@6c08e2a (visualID: 3028, editPartClassName: CommentEditPartCN, itemSemanticEditPolicyClassName: CommentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: CommentCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: CommentGraphicalNodeEditPolicyCN, createCommandClassName: CommentCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@6f4fb27a (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@42bb5c7d (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1ab534c5 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@5f946847 (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@3438790b (name: null) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
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
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@750b223e (visualID: 3029, editPartClassName: ConstraintEditPartCN, itemSemanticEditPolicyClassName: ConstraintItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ConstraintCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: ConstraintGraphicalNodeEditPolicyCN, createCommandClassName: ConstraintCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@6f4fb27a (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@42bb5c7d (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1ab534c5 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@5f946847 (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@5aa6e6f2 (name: null) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.INSTANCE_SPECIFICATION) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.INSTANCE_SPECIFICATION_CN) {
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@1af04081 (visualID: 3020, editPartClassName: InstanceSpecificationEditPartCN, itemSemanticEditPolicyClassName: InstanceSpecificationItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: InstanceSpecificationCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: InstanceSpecificationGraphicalNodeEditPolicyCN, createCommandClassName: InstanceSpecificationCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@6f4fb27a (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@42bb5c7d (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1ab534c5 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@5f946847 (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@61aad378 (name: null) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS_CN) {
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@6b5d9eb1 (visualID: 3010, editPartClassName: ClassEditPartCN, itemSemanticEditPolicyClassName: ClassItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ClassCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: ClassGraphicalNodeEditPolicyCN, createCommandClassName: ClassCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@6f4fb27a (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@42bb5c7d (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1ab534c5 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@5f946847 (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@78e314f9 (name: null) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.DATA_TYPE) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.DATA_TYPE_CN) {
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@2a94e952 (visualID: 3027, editPartClassName: DataTypeEditPartCN, itemSemanticEditPolicyClassName: DataTypeItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: DataTypeCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: DataTypeGraphicalNodeEditPolicyCN, createCommandClassName: DataTypeCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@6f4fb27a (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@42bb5c7d (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1ab534c5 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@5f946847 (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@6893de59 (name: null) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.ENUMERATION) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.ENUMERATION_CN) {
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@3ab2d76 (visualID: 3025, editPartClassName: EnumerationEditPartCN, itemSemanticEditPolicyClassName: EnumerationItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: EnumerationCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: EnumerationGraphicalNodeEditPolicyCN, createCommandClassName: EnumerationCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@6f4fb27a (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@42bb5c7d (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1ab534c5 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@5f946847 (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@6fbbfef3 (name: null) (customPreferencePage: null, generatePreferencePage: true, generateTool: true)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.PRIMITIVE_TYPE_CN) {
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@60c476cd (visualID: 3026, editPartClassName: PrimitiveTypeEditPartCN, itemSemanticEditPolicyClassName: PrimitiveTypeItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PrimitiveTypeCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: PrimitiveTypeGraphicalNodeEditPolicyCN, createCommandClassName: PrimitiveTypeCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@6f4fb27a (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@42bb5c7d (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1ab534c5 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@5f946847 (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@1f5f3cd4 (name: null) (customPreferencePage: null, generatePreferencePage: true, generateTool: true)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.PRIMITIVE_TYPE) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN) {
			if(ElementTypes.INSTANCE_SPECIFICATION_COMPARTMENT_SLOT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.INSTANCE_SPECIFICATION_CN_COMPARTMENT_SLOT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS_PROPERTY_CLN) {
			if(ElementTypes.CLASS_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CLASS_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS_RECEPTION_CLN) {
			if(ElementTypes.CLASS_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CLASS_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS_OPERATION_CLN) {
			if(ElementTypes.CLASS_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CLASS_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS_CLASS_CLN) {
			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS_INTERFACE_CLN) {
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS_ENUMERATION_CLN) {
			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS_PRIMITIVE_TYPE_CLN) {
			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS_DATA_TYPE_CLN) {
			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CLASS_SIGNAL_CLN) {
			if(ElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.DATA_TYPE_PROPERTY_CLN) {
			if(ElementTypes.DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.DATA_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.DATA_TYPE_OPERATION_CLN) {
			if(ElementTypes.DATA_TYPE_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.DATA_TYPE_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN) {
			if(ElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.PRIMITIVE_TYPE_PROPERTY_CLN) {
			if(ElementTypes.PRIMITIVE_TYPE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PRIMITIVE_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.PRIMITIVE_TYPE_OPERATION_CLN) {
			if(ElementTypes.PRIMITIVE_TYPE_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PRIMITIVE_TYPE_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalType)) {
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
