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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.sysml.diagram.requirement.Messages;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;

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

		// This provider is registered for Requirement Diagram for Abstraction usage (Satisfy, Verify, Copy links)
		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if(elementType == RequirementDiagramElementTypes.Abstraction_4006) {
			return true;
		}

		// This provider is registered for Requirement Diagram for any Named Element usage in the diagram
		if(elementType == RequirementDiagramElementTypes.NamedElement_2097) {
			return true;
		}

		// This provider is registered for Requirement Diagram for Abstraction usage (Satisfy, Verify, Copy links)
		if(elementType == RequirementDiagramElementTypes.Link_4023) {
			return true;
		}

		// else : unknown element
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

		if(elementType == RequirementDiagramElementTypes.PACKAGE_2007) {
			return true;
		}

		if(elementType == RequirementDiagramElementTypes.CLASS_2008) {
			return true;
		}
		if(elementType == RequirementDiagramElementTypes.CLASS_3010_CN) {
			return true;
		}
		if(elementType == RequirementDiagramElementTypes.Port_3032) {
			return true;
		}

		// SemanticHint may be null (especially when drop from ModelExplorer)
		EObject eobject = (EObject)op.getSemanticAdapter().getAdapter(EObject.class);
		if((eobject instanceof org.eclipse.uml2.uml.Class) || (eobject instanceof org.eclipse.uml2.uml.Package)) {
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
		// DND from model explorer
		EObject eobject = (EObject)semanticAdapter.getAdapter(EObject.class);
		if(eobject instanceof org.eclipse.uml2.uml.Package) {
			return super.createNode(semanticAdapter, containerView, RequirementDiagramElementTypes.PACKAGE_2007.getSemanticHint(), index, persisted, preferencesHint);
		} else if(eobject instanceof org.eclipse.uml2.uml.Class) {
			return super.createNode(semanticAdapter, containerView, RequirementDiagramElementTypes.CLASS_2008.getSemanticHint(), index, persisted, preferencesHint);
		}


		// Log a warning here
		System.err.println(Messages.Unable_To_Create_View_For_Hint + semanticHint);
		return null;

	}

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		return super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
	}

	protected void stampShortcut(View containerView, Node target) {
		if(!RequirementDiagramEditPart.DIAGRAM_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource(Messages.Short_Cut); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put(Messages.Model_ID, RequirementDiagramEditPart.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
