/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.provider;

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
import org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.composite.providers.UMLViewProvider;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

public class InheritedElementViewProvider extends UMLViewProvider {

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
			boolean persisted, PreferencesHint preferencesHint) {
		// No need to override here, assuming provides is correctly implemented.
		return super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
	}

	@Override
	protected boolean provides(CreateEdgeViewOperation op) {

		// Must have a container
		if (op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for Block Definition Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if (!InternalBlockDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if (elementType == InternalBlockDiagramElementTypes.CONNECTOR) {
			return true;
		}

		return false;
	}

	@Override
	protected boolean provides(CreateNodeViewOperation op) {

		// Must have a container
		if (op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for Block Definition Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if (!InternalBlockDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		// SemanticHint may be null (especially when drop from ModelExplorer
		EObject eobject = (EObject) op.getSemanticAdapter().getAdapter(EObject.class);
		if ((eobject instanceof org.eclipse.uml2.uml.Class) || (eobject instanceof org.eclipse.uml2.uml.Property)) {
			// Port is a Property, no need to test both here
			return true;
		}

		// This can probably be simplified as previous test should be sufficient
		// in most cases
		// This is probably required at least for purely graphical element
		IElementType elementType = (IElementType) op.getSemanticAdapter().getAdapter(IElementType.class);
		if ((elementType == InternalBlockDiagramElementTypes.CLASS)
				|| (elementType == InternalBlockDiagramElementTypes.CLASS_CN)
				|| (elementType == InternalBlockDiagramElementTypes.PROPERTY_CN)
				|| (elementType == InternalBlockDiagramElementTypes.PORT_CN)) {
			return true;
		}

		// else : unknown element
		return false;
	}

	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
			boolean persisted, PreferencesHint preferencesHint) {

		if (semanticHint != null) {
			return super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		}

		// SemanticHint may be null when the element is created indirectly by
		// DND from model explorer
		// ex: Drag and drop a Connector may require to show ConnectorEnd first.
		EObject eobject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eobject instanceof Port) {
			return super.createNode(semanticAdapter, containerView,
					InternalBlockDiagramElementTypes.PORT_CN.getSemanticHint(), index, persisted, preferencesHint);
		} else if (eobject instanceof Property) {
			return super.createNode(semanticAdapter, containerView,
					InternalBlockDiagramElementTypes.PROPERTY_CN.getSemanticHint(), index, persisted, preferencesHint);
		}

		return null;
	}

	@Override
	protected void stampShortcut(View containerView, Node target) {
		if (!InternalBlockDiagramEditPart.DIAGRAM_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", InternalBlockDiagramEditPart.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
