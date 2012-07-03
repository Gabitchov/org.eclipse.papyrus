/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy Bug 366026 - [ActivityDiagram] Refactoring in order to try respect Generation Gap Pattern 
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.interfaces.InterruptibleEdge;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ControlFlowInterruptibleIconEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;

/**
 * Customization to implement InterruptibleEdge
 * 
 * @author arthur daussy
 * 
 */
public class CustomControlFlowEditPart extends ControlFlowEditPart implements InterruptibleEdge {

	public CustomControlFlowEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc InterruptibleEdge}
	 */
	public int getInterruptibleEdgeIconVisualID() {
		return ControlFlowInterruptibleIconEditPart.VISUAL_ID;
	}

	/**
	 * {@inheritDoc InterruptibleEdge}
	 */
	public Node getInterrutibleEgdeIcon() {
		Object view = getModel();
		if(view instanceof View) {
			View node = ViewUtil.getChildBySemanticHint((View)view, UMLVisualIDRegistry.getType(ControlFlowInterruptibleIconEditPart.VISUAL_ID));
			if(node instanceof Node) {
				return (Node)node;
			}
		}
		return null;
	}
}
