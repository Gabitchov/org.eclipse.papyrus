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

import static org.eclipse.papyrus.core.Activator.log;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.sysml.diagram.requirement.Messages;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;
import org.eclipse.uml2.uml.NamedElement;

/**
 * SysML Requirement diagram inherited elements view providers from UML Class diagram view providers
 * 
 */
public class InheritedElementViewProvider extends UMLViewProvider {

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
}
