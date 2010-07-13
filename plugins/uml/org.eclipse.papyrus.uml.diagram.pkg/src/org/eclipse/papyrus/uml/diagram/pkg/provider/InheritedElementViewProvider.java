/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.pkg.provider;

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
import org.eclipse.papyrus.uml.diagram.pkg.edit.part.PackageDiagramEditPart;
import org.eclipse.uml2.uml.Package;

public class InheritedElementViewProvider extends UMLViewProvider {

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		// No need to override here, assuming provides is correctly implemented.
		Edge createdEdge = super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);

		if(createdEdge == null) {
			log.error(new Exception("Could not create Edge."));
		}

		return createdEdge;
	}

	@Override
	protected boolean provides(CreateEdgeViewOperation op) {

		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for Package Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!PackageDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(elementType == InheritedElementTypes.DEPENDENCY) {
			return true;
		}

		if(elementType == InheritedElementTypes.PACKAGE_IMPORT) {
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

		// This provider is registered for Package Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!PackageDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);
		if((elementType == InheritedElementTypes.PACKAGE) || (elementType == InheritedElementTypes.PACKAGE_CN)) {

			return true;
		}

		// SemanticHint may be null (especially when drop from ModelExplorer
		EObject eobject = (EObject)op.getSemanticAdapter().getAdapter(EObject.class);
		if(eobject instanceof Package) {
			return true;
		}

		return false;
	}

	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {

		if(semanticHint != null) {
			return super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		}

		// SemanticHint may be null when the element is created indirectly by
		// DND from model explorer
		// ex: Drag and drop a Connector may require to show ConnectorEnd first.
		EObject eobject = (EObject)semanticAdapter.getAdapter(EObject.class);
		if(eobject instanceof Package) {
			if(containerView instanceof Diagram) {
				return super.createNode(semanticAdapter, containerView, PackageDiagramElementTypes.PACKAGE.getSemanticHint(), index, persisted, preferencesHint);
			} else {
				return super.createNode(semanticAdapter, containerView, PackageDiagramElementTypes.PACKAGE_CN.getSemanticHint(), index, persisted, preferencesHint);

			}
		}

		log.error(new Exception("Could not create Node."));
		return null;
	}

	@Override
	protected void stampShortcut(View containerView, Node target) {
		if(!PackageDiagramEditPart.DIAGRAM_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", PackageDiagramEditPart.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
