/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;

public class InheritedElementViewProvider extends UMLViewProvider {

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		// No need to override here, assuming provides is correctly implemented.
		return super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
	}

	@Override
	protected boolean provides(CreateEdgeViewOperation op) {

		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for Block Definition Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		return false;
	}

	@Override
	protected boolean provides(CreateNodeViewOperation op) {

		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for Block Definition Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// This hack avoids to repeat the inherited elements from the parent diagram
		String oldValue = ModelEditPart.MODEL_ID;
		ModelEditPart.MODEL_ID = BlockDefinitionDiagramEditPart.DIAGRAM_ID;
		boolean result =  super.provides(op);
		ModelEditPart.MODEL_ID = oldValue;
		
		return result;
	}

	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {

		if(semanticHint != null) {
			String oldValue = ModelEditPart.MODEL_ID;
			ModelEditPart.MODEL_ID = BlockDefinitionDiagramEditPart.DIAGRAM_ID;
			Node result = super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
			ModelEditPart.MODEL_ID = oldValue;
			
			return result;
		}

		// Log a warning here
		System.err.println("Unable to create view for : (hint) " + semanticHint);
		return null;
	}
}
