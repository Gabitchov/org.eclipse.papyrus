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
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.UMLVisualIDRegistry;

public class CustomInteractionOverviewDiagramDragAndDropEditPolicy extends CustomDiagramDragDropEditPolicy {

	@Override
	public int getNodeVisualID(final View containerView, final EObject domainElement) {
		return UMLVisualIDRegistry.customGetNodeVisualID(containerView, domainElement);
	}
}
