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
package org.eclipse.papyrus.gmf.diagram.common.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This abstract view provider retrieve the view type from the graphical type
 * registry and use it in edge and node view creation.
 */
public abstract class CustomAbstractViewProvider extends AbstractViewProvider {

	/** Local graphical type registry */
	protected IGraphicalTypeRegistry registry;

	/** The provides only provides for this diagram type */
	protected String diagramType;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		String graphicalType = getEdgeGraphicalType(semanticAdapter, containerView, semanticHint);
		return super.createEdge(semanticAdapter, containerView, graphicalType, index, persisted, preferencesHint);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		String graphicalType = getNodeGraphicalType(semanticAdapter, containerView, semanticHint);
		return super.createNode(semanticAdapter, containerView, graphicalType, index, persisted, preferencesHint);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean provides(CreateViewForKindOperation op) {
		
		// This method should generally not be called (https://bugs.eclipse.org/bugs/show_bug.cgi?id=346739).

		if((diagramType == null) || (!diagramType.equals(op.getContainerView().getDiagram().getType()))) {
			return false;
		}

//		if(op.getViewKind() == Node.class) {
//			String graphicalType = getNodeGraphicalType(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint());
//			return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), graphicalType) != null;
//		}
//
//		if(op.getViewKind() == Edge.class) {
//			String graphicalType = getEdgeGraphicalType(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint());
//			return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), graphicalType) != null;
//		}

		throw new UnsupportedOperationException("Should never be called by the "+diagramType+" diagram.");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean provides(CreateEdgeViewOperation operation) {

		if((diagramType == null) || (!diagramType.equals(operation.getContainerView().getDiagram().getType()))) {
			return false;
		}

		String graphicalType = getEdgeGraphicalType(operation.getSemanticAdapter(), operation.getContainerView(), operation.getSemanticHint());
		return (getEdgeViewClass(operation.getSemanticAdapter(), operation.getContainerView(), graphicalType) != null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean provides(CreateNodeViewOperation operation) {

		if((diagramType == null) || (!diagramType.equals(operation.getContainerView().getDiagram().getType()))) {
			return false;
		}

		String graphicalType = getNodeGraphicalType(operation.getSemanticAdapter(), operation.getContainerView(), operation.getSemanticHint());
		return (getNodeViewClass(operation.getSemanticAdapter(), operation.getContainerView(), graphicalType) != null);
	}

	private String getNodeGraphicalType(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		String graphicalType = null;
		
		// Some ViewDescriptor constructors initialize unspecified semanticHint with ""
		if((semanticHint != null) && (! "".equals(semanticHint))) {
			graphicalType = registry.getNodeGraphicalType(semanticHint, containerView.getType());

		} else {

			EObject domainElement = (EObject)semanticAdapter.getAdapter(EObject.class);
			if(domainElement != null) {
				graphicalType = registry.getNodeGraphicalType(domainElement, containerView.getType());
			}

			IElementType elementType = (IElementType)semanticAdapter.getAdapter(IElementType.class);
			if(elementType != null) {
				graphicalType = registry.getNodeGraphicalType(elementType, containerView.getType());

			}
		}
		return graphicalType;
	}

	private String getEdgeGraphicalType(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		String graphicalType = null;
		// Some ViewDescriptor constructors initialize unspecified semanticHint with ""
		if((semanticHint != null) && (! "".equals(semanticHint))) {
			graphicalType = registry.getEdgeGraphicalType(semanticHint);

		} else {

			EObject domainElement = (EObject)semanticAdapter.getAdapter(EObject.class);
			if(domainElement != null) {
				graphicalType = registry.getEdgeGraphicalType(domainElement);
			}

			IElementType elementType = (IElementType)semanticAdapter.getAdapter(IElementType.class);
			if(elementType != null) {
				graphicalType = registry.getEdgeGraphicalType(elementType);

			}
		}
		return graphicalType;
	}
}
