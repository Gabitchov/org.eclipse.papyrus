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

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;

/**
 * This abstract edit part provider restricts its contribution to view that are owned by
 * a given type of diagram.
 */
public abstract class CustomAbstractEditPartProvider extends AbstractEditPartProvider {

	/** The provides only provides for this diagram type */
	protected String diagramType;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			String currentDiagramType = ((IEditPartOperation)operation).getView().getDiagram().getType();

			if((diagramType == null) || (!diagramType.equals(currentDiagramType))) {
				return false;
			}
		}

		return super.provides(operation);
	}




}
