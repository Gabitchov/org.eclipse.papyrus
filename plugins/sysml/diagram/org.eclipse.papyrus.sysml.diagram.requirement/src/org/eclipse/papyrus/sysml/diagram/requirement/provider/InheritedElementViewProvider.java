/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

import static org.eclipse.papyrus.infra.core.Activator.log;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.requirement.Messages;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNameEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.uml2.uml.NamedElement;

/**
 * SysML Requirement diagram inherited elements view providers from UML Class diagram view providers
 * 
 */
public class InheritedElementViewProvider extends UMLViewProvider {


	@Override
	protected boolean provides(CreateViewForKindOperation op) {

		// This provider is registered for Requirement Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!RequirementDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
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
		if(!RequirementDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if(elementType == RequirementDiagramElementTypes.ABSTRACTION) {
			return true;
		}

		if((elementType == RequirementDiagramElementTypes.CONTAINMENT_ADDED_LINK) || (elementType == RequirementDiagramElementTypes.CONTAINMENT_LINK)) {
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

		// This provider is registered for Requirement Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!RequirementDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// This provider is registered for Imported Elements from Class Diagram only
		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);

		if((elementType == RequirementDiagramElementTypes.PACKAGE) || (elementType == RequirementDiagramElementTypes.PACKAGE_CN)) {
			return true;
		}

		if((elementType == RequirementDiagramElementTypes.CLASS) || (elementType == RequirementDiagramElementTypes.CLASS_CN)) {
			return true;
		}

		if((elementType == RequirementDiagramElementTypes.NAMED_ELEMENT)) {
			return true;
		}

		if(elementType == RequirementDiagramElementTypes.CONTAINMENT_CIRCLE) {
			return true;
		}

		// SemanticHint may be null (especially when drop from ModelExplorer)
		EObject eobject = (EObject)op.getSemanticAdapter().getAdapter(EObject.class);
		if(eobject instanceof NamedElement) {
			return true;
		}

		// else : unknown element
		return false;

	}

	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {

		if(semanticHint != null) {
			return super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		}

		// SemanticHint may be null when the element is created indirectly by
		// DND (Drag And Drop) from model explorer
		EObject eobject = (EObject)semanticAdapter.getAdapter(EObject.class);
		if(eobject instanceof org.eclipse.uml2.uml.Package) {
			if(containerView instanceof Diagram) {
				return super.createNode(semanticAdapter, containerView, RequirementDiagramElementTypes.PACKAGE.getSemanticHint(), index, persisted, preferencesHint);
			} else {
				return super.createNode(semanticAdapter, containerView, RequirementDiagramElementTypes.PACKAGE_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		} else if(eobject instanceof org.eclipse.uml2.uml.Class) {
			if(containerView instanceof Diagram) {
				return super.createNode(semanticAdapter, containerView, RequirementDiagramElementTypes.CLASS.getSemanticHint(), index, persisted, preferencesHint);
			} else {
				return super.createNode(semanticAdapter, containerView, RequirementDiagramElementTypes.CLASS_CN.getSemanticHint(), index, persisted, preferencesHint);
			}

		} else if(eobject instanceof NamedElement) {
			if(containerView instanceof Diagram) {
				return super.createNode(semanticAdapter, containerView, RequirementDiagramElementTypes.NAMED_ELEMENT.getSemanticHint(), index, persisted, preferencesHint);
			}
		}

		log.error(new Exception(Messages.No_View_Can_Be_Created));
		return null;

	}

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge createdEdge = super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);

		if(createdEdge == null) {
			log.error(new Exception(Messages.No_View_Can_Be_Created));
		}

		return createdEdge;
	}

	@Override
	protected void stampShortcut(View containerView, Node target) {
		if(!RequirementDiagramEditPart.DIAGRAM_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", RequirementDiagramEditPart.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}

	@Override
	public Node createClass_2008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {

		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(SysMLGraphicalTypes.SHAPE_SYSML_REQUIREMENT_AS_CLASSIFER_ID);
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initForegroundFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Class");
		PreferenceInitializerForElementHelper.initBackgroundFromPrefs(node, prefStore, "Class");
		createLabel(node, UMLVisualIDRegistry.getType(ClassNameEditPart.VISUAL_ID));
		createCompartment(node, UMLVisualIDRegistry.getType(ClassAttributeCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassOperationCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPart.VISUAL_ID), true, true, true, true);

		/*
		 * Addition of the information compartment, and the labels it contains.
		 */
		Node compartment = createCompartment(node, SysMLGraphicalTypes.COMPARTMENT_SYSML_REQUIREMENT_IDINFO_AS_LIST_ID, true, true, true, true);
		createLabel(compartment, SysMLGraphicalTypes.LABEL_SYSML_REQUIREMENT_ID_ID);
		createLabel(compartment, SysMLGraphicalTypes.LABEL_SYSML_REQUIREMENT_TEXT_ID);

		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Class");
		return node;

	}
}
