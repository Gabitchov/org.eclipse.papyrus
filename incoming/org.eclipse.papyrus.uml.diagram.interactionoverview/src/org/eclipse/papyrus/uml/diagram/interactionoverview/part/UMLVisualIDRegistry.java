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
package org.eclipse.papyrus.uml.diagram.interactionoverview.part;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.InteractionOverviewDiagramEditPart;

public class UMLVisualIDRegistry extends org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry {

	public UMLVisualIDRegistry() {
		super();
	}

	public static boolean canCreateNode(final View containerView, final int nodeVisualID) {
		final String containerModelID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!InteractionOverviewDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(InteractionOverviewDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = InteractionOverviewDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}

		return false;
	}
}
