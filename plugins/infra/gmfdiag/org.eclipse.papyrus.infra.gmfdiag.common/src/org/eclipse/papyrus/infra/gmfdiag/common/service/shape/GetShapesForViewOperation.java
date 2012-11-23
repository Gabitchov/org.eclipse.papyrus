/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.service.shape;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;

/**
 * Operation to find a list of shapes, given a view 
 */
public class GetShapesForViewOperation implements IOperation, IShapeProviderOperation {

	/** View from which shape has to be retrieved */
	private final EObject view;

	/**
	 * Creates a new GetShapeProvidersForViewOperation.
	 * 
	 * @param view
	 *        the EObject for which shapes has to be found
	 */
	protected GetShapesForViewOperation(EObject view) {
		assert null != view : "GetShapesForViewOperation constructor received NULL as argument"; //$NON-NLS-1$
		this.view = view;
	}

	/**
	 * @{inheritDoc
	 */
	public List<RenderedImage> execute(IProvider provider) {
		if(!(provider instanceof IShapeProvider)) {
			return null;
		}
		IShapeProvider shapeProvider = (IShapeProvider)provider;
		return shapeProvider.getShapes(getView());
	}

	/**
	 * Returns the view for which this operation is looking for shapes
	 * 
	 * @return the view for which this operation is looking for shapes
	 */
	protected EObject getView() {
		return view;
	}
}
