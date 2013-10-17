/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.edit.policy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.provider.IGraphicalTypeRegistry;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.GraphicalTypeRegistry;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies.CustomDiagramDragDropEditPolicy;

/** Customization of the DND edit policy for the Parametric Diagram */
public class ParametricDiagramDragDropEditPolicy extends CustomDiagramDragDropEditPolicy {

	/** Local graphical type registry */
	protected IGraphicalTypeRegistry registry = new GraphicalTypeRegistry();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		String domainType = registry.getNodeGraphicalType(domainElement, containerView.getType());
		if (IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(domainType)) {
			return -1; // undefined
		}
		return new Integer(domainType);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		String domainType = registry.getEdgeGraphicalType(domainElement);
		if (IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(domainType)) {
			return -1; // undefined
		}
		return new Integer(domainType);
	}
}
