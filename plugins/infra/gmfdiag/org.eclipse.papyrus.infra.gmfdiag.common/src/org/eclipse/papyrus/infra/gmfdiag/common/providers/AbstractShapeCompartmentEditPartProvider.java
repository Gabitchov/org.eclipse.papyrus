/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IShapeCompartmentEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ShapeDisplayCompartmentEditPart;

/**
 * provides editpart to display shapes in compartment. 
 */
public abstract class AbstractShapeCompartmentEditPartProvider extends AbstractEditPartProvider {

	/** Map containing node view types supported by this provider */
	protected Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();

	/** Map containing edge view types supported by this provider */
	protected Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();

	/** Default constructor */
	public AbstractShapeCompartmentEditPartProvider() {
		super();
		nodeMap.put(IShapeCompartmentEditPart.VIEW_TYPE, ShapeDisplayCompartmentEditPart.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof IEditPartOperation) {
			View newView = ((IEditPartOperation)operation).getView();
			if(newView == null) {
				return false;
			}

			String graphicalType = newView.getType();

			if((newView instanceof Node) && (!nodeMap.containsKey(graphicalType))) {
				return false;
			}

			if((newView instanceof Edge) && (!edgeMap.containsKey(graphicalType))) {
				return false;
			}
		}

		return super.provides(operation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getNodeEditPartClass(View view) {
		return nodeMap.get(view.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getEdgeEditPartClass(View view) {
		return edgeMap.get(view.getType());
	}
}
