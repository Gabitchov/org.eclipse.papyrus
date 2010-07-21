/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.composite.custom.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.InternalBlockDiagramElementTypes;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

/** Customization of the DND edit policy for the Internal Block Diagram */
public class CustomDragDropEditPolicy extends CustomDiagramDragDropEditPolicy {

	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		String semanticHint = "-1";

		containerView.eClass();

		// Fill the semantic hint during the drop
		if(containerView instanceof Diagram) { // Top Nodes
			if(domainElement instanceof org.eclipse.uml2.uml.Class) {
				semanticHint = InternalBlockDiagramElementTypes.CLASS.getSemanticHint();
			}

		} else { // Child Nodes
			if(domainElement instanceof Port) {
				semanticHint = InternalBlockDiagramElementTypes.PORT_CN.getSemanticHint();
			} else if(domainElement instanceof Property) {
				semanticHint = InternalBlockDiagramElementTypes.PROPERTY_CN.getSemanticHint();
			} else if(domainElement instanceof org.eclipse.uml2.uml.Class) {
				semanticHint = InternalBlockDiagramElementTypes.CLASS_CN.getSemanticHint();
			}
		}

		return new Integer(semanticHint);
	}

	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		String semanticHint = "-1";
		if(domainElement instanceof Connector) {
			semanticHint = InternalBlockDiagramElementTypes.CONNECTOR.getSemanticHint();
		}

		return new Integer(semanticHint);
	}
}
