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
 *   Arthur Daussy - Bug 367894 - [activity diagram] pins can not be deleted or hidden directly from selection in diagram
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ObjectFlow;

/**
 * Used to create pin when creating Object Flow
 * 
 * @author arthur daussy
 * 
 */
public class OpaqueActionObjectFlowWithPinsCreationEditPolicy extends ObjectFlowWithPinsCreationEditPolicy {

	@Override
	protected View getObjectFlowExtremityView(boolean isStartEnd) {
		Object objectFlowView = getViewAdapter().getAdapter(Connector.class);
		if(objectFlowView instanceof Connector) {
			EObject objectFlow = ((Connector)objectFlowView).getElement();
			if(objectFlow instanceof ObjectFlow) {
				ActivityNode actNode = null;
				if(isStartEnd) {
					actNode = ((ObjectFlow)objectFlow).getSource();
				} else {
					actNode = ((ObjectFlow)objectFlow).getTarget();
				}
				if(actNode != null) {
					if(getHost().getModel() instanceof View) {
						View view = (View)getHost().getModel();
						if(actNode.equals(view.getElement())) {
							return view;
						}
						//if there is no existing view we create it
						Node node = ViewService.createNode(view, actNode, UMLVisualIDRegistry.getType(UMLVisualIDRegistry.getNodeVisualID(view, actNode)), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
						if(node != null) {
							return node;
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		if(connectionFeedback != null) {
			removeFeedback(connectionFeedback);
			feedbackHelper = null;
			connectionFeedback = null;
		}
	}
}
