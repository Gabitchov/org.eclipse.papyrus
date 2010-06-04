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
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
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

		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if(elementType == RequirementDiagramElementTypes.Abstraction_4006) {
			return true;
		}
		if(elementType == RequirementDiagramElementTypes.Component_2002) {
			return true;
		}
		if(elementType == RequirementDiagramElementTypes.Component_3021) {
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

		if(elementType == RequirementDiagramElementTypes.Package_1000) {
			return true;
		}
		if(elementType == RequirementDiagramElementTypes.Package_2007) {
			return true;
		}
		if(elementType == RequirementDiagramElementTypes.Package_3009) {
			return true;
		}

		if(elementType == RequirementDiagramElementTypes.Class_2008) {
			return true;
		}
		if(elementType == RequirementDiagramElementTypes.Class_3004) {
			return true;
		}
		if(elementType == RequirementDiagramElementTypes.Class_3008) {
			return true;
		}
		if(elementType == RequirementDiagramElementTypes.Class_3010) {
			return true;
		}
		if(elementType == RequirementDiagramElementTypes.Class_3014) {
			return true;
		}

		// else : unknown element
		return false;

	}

	/*
	 * private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
	 * if(semanticAdapter == null) {
	 * return null;
	 * }
	 * return (IElementType)semanticAdapter.getAdapter(IElementType.class);
	 * }
	 */
	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {

		if(semanticHint != null) {
			return super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		}

		// Log a warning here
		System.err.println(Messages.Unable_To_Create_View_For_Hint + semanticHint);
		return null;

	}

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		return super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
	}

}
