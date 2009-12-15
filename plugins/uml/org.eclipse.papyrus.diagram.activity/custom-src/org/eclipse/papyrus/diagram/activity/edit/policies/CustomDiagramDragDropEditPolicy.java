/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.helper.ActivityLinkMappingHelper;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.uml2.uml.Element;

/**
 * This class is used to execute the drag and drop from the outline. It can manage the drop of nodes
 * and binary links. To manage specific drop the method
 * CommonDiagramDragDropEditPolicy.getSpecificDropCommand has to be implemented
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** The specific drop node. */
	public int[] secificDropNode = {};

	/**
	 * Instantiates a new custom diagram drag drop edit policy with the right link mapping helper
	 */
	public CustomDiagramDragDropEditPolicy() {
		super(ActivityLinkMappingHelper.getInstance());
		init(secificDropNode);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		switch(linkVISUALID) {
		default:
			return super.getSpecificDropCommand(dropRequest, semanticLink, nodeVISUALID, linkVISUALID);
		}
	}

}
