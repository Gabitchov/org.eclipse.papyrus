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
package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ResizableCompartmentViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IShapeCompartmentEditPart;

public abstract class AbstractShapeCompartmentViewProvider extends CustomAbstractViewProvider {

	/** Map containing node view types supported by this provider */
	protected Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();

	/** Map containing edge view types supported by this provider */
	protected Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();

	/** Default constructor */
	public AbstractShapeCompartmentViewProvider() {
		super();
		initDiagramType();
		initGraphicalTypeRegistry();

		nodeMap.put(IShapeCompartmentEditPart.VIEW_TYPE, ResizableCompartmentViewFactory.class);
	}

	/**
	 * Initialize the graphical type registry. This should be set in the constructor, and not called again after that.
	 */
	protected abstract void initGraphicalTypeRegistry();

	/**
	 * Initialize the diagram type. This should be set in the constructor, and not called again after that.
	 */
	protected abstract void initDiagramType() ;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getNodeViewClass(IAdaptable semanticAdapter, View containerView, String graphicalType) {
		return nodeMap.get(graphicalType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String graphicalType) {
		return edgeMap.get(graphicalType);
	}
	
}
