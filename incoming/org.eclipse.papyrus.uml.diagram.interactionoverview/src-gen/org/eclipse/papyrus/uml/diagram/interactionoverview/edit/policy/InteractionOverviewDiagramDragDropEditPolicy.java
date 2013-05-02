/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.provider.GraphicalTypeRegistry;
import org.eclipse.papyrus.uml.diagram.interactionoverview.provider.IGraphicalTypeRegistry;

/**
 * Customization of the DND edit policy for the InteractionOverviewDiagram
 * Diagram
 */
public class InteractionOverviewDiagramDragDropEditPolicy extends CustomDiagramDragDropEditPolicy {

	/** Local graphical type registry */
	protected IGraphicalTypeRegistry registry = new GraphicalTypeRegistry();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(final View containerView, final EObject domainElement) {
		final String domainType = registry.getNodeGraphicalType(domainElement, containerView.getType());
		if(IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(domainType)) {
			return -1; // undefined
		}
		return new Integer(domainType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(final EObject domainElement) {
		final String domainType = registry.getEdgeGraphicalType(domainElement);
		if(IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(domainType)) {
			return -1; // undefined
		}
		return new Integer(domainType);
	}
}
