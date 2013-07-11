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

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.CommonDiagramDragDropEditPolicy;

/**
 * Customization of the DND edit policy for the InteractionOverviewDiagram
 * Diagram
 */
public class InteractionOverviewDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** Default constructor. */
	public InteractionOverviewDiagramDragDropEditPolicy() {
		super(null);
		// registry = new CustomGraphicalTypeRegistry();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<String> getSpecificDropBehaviorTypes() {
		return Collections.emptySet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getUnknownDropCommand(final DropObjectsRequest dropRequest, final EObject droppedEObject) {

		return super.getUnknownDropCommand(dropRequest, droppedEObject);
	}
}
