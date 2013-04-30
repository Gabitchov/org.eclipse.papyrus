/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

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
import org.eclipse.papyrus.sysml.diagram.requirement.Activator;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;

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

				if(ElementTypes.ABSTRACTION.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createAbstraction_4006(domainElement, containerView, index, persisted, preferencesHint);
				}
				if(ElementTypes.CONTAINMENT_LINK.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createLink_4023(containerView, index, persisted, preferencesHint);
				}
				if(ElementTypes.CONTAINMENT_SUB_LINK.getSemanticHint().equals(domainElementGraphicalType)) {
					createdEdge = createLink_4022(containerView, index, persisted, preferencesHint);
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

		// This provider is registered for Requirement Diagram only
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

		// This provider is registered for Requirement Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(elementType == ElementTypes.ABSTRACTION) {
			return true;
		}
		if(elementType == ElementTypes.CONTAINMENT_LINK) {
			return true;
		}
		if(elementType == ElementTypes.CONTAINMENT_SUB_LINK) {
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

		// This provider is registered for Requirement Diagram only
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
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@9f2ceb7 (visualID: 3009, editPartClassName: PackageEditPartCN, itemSemanticEditPolicyClassName: PackageItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackageCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: PackageGraphicalNodeEditPolicyCN, createCommandClassName: PackageCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1eb310a4 (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@4c6b8315 (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@266afee5 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@337b87c0 (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@6c24b08 (name: null) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
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
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildNodeImpl@66f6bc68 (visualID: 3010, editPartClassName: ClassEditPartCN, itemSemanticEditPolicyClassName: ClassItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ClassCanonicalEditPolicyCN) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: ClassGraphicalNodeEditPolicyCN, createCommandClassName: ClassCreateCommandCN)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@1eb310a4 (visualID: 7010, editPartClassName: PackagePackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@4c6b8315 (visualID: 7009, editPartClassName: ModelPackageableElementCompartmentEditPartTN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyTN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyTN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@266afee5 (visualID: 7030, editPartClassName: ModelPackageableElementCompartmentEditPartCN, itemSemanticEditPolicyClassName: ModelPackageableElementCompartmentItemSemanticEditPolicyCN, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ModelPackageableElementCompartmentCanonicalEditPolicyCN) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)org.eclipse.gmf.codegen.gmfgen.impl.GenCompartmentImpl@337b87c0 (visualID: 7016, editPartClassName: PackagePackageableElementCompartmentEditPart, itemSemanticEditPolicyClassName: PackagePackageableElementCompartmentItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: PackagePackageableElementCompartmentCanonicalEditPolicy) (title: PackageableElementCompartment, canCollapse: false, hideIfEmpty: true, needsTitle: true, listLayout: false)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@1b7c0bdb (name: null) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
			if(ElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.DEFAULT_NAMED_ELEMENT) {
			if(ElementTypes.DIAGRAM_ID.equals(containerGraphicalType)) {
				return true;
			}
		}
		if(elementType == ElementTypes.CONTAINMENT_CIRCLE_CN) {
			// node: org.eclipse.gmf.codegen.gmfgen.impl.GenChildSideAffixedNodeImpl@3e059e08 (visualID: 3032, editPartClassName: ContainmentCircleEditPart, itemSemanticEditPolicyClassName: ContainmentCircleItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ContainmentCircleCanonicalEditPolicy) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: ContainmentCircleGraphicalNodeEditPolicy, createCommandClassName: ContainmentCircleCreateCommand) (preferredSideName: NORTH)
			// containers: org.eclipse.gmf.codegen.gmfgen.impl.GenTopLevelNodeImpl@257995fb (visualID: 2008, editPartClassName: ClassEditPart, itemSemanticEditPolicyClassName: ClassItemSemanticEditPolicy, notationViewFactoryClassName: null) (canonicalEditPolicyClassName: ClassCanonicalEditPolicy) (primaryDragEditPolicyQualifiedClassName: null, graphicalNodeEditPolicyClassName: ClassGraphicalNodeEditPolicy, createCommandClassName: ClassCreateCommand)
			// nodeRef: org.eclipse.papyrus.generation.diagram.idgen.impl.GenNodeRefImpl@172648b2 (name: ) (customPreferencePage: null, generatePreferencePage: false, generateTool: false)
			if(ElementTypes.CLASS.getSemanticHint().equals(containerGraphicalType)) {
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
