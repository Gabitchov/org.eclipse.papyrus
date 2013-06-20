/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.architecture.edit.policy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.robotml.diagram.architecture.edit.part.ArchitectureDiagramEditPart;
import org.eclipse.papyrus.robotml.diagram.architecture.provider.ArchitectureDiagramElementTypes;

/** Customization of the DND edit policy for the Architecture Diagram */
public class ArchitectureDiagramDragDropEditPolicy extends CustomDiagramDragDropEditPolicy {

	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		String semanticHint = "-1";

		String containerGraphicalHint = containerView.getType();
		if(containerGraphicalHint == null) {
			// Cannot guess domain element graphical hint.
			return -1; // -1 = undefined.
		}

		// Fill the semantic hint during the drop
		// Elements inherited from CompositeDiagram
		// Dropping Class
		if(domainElement instanceof org.eclipse.uml2.uml.Class) {
			if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				semanticHint = ArchitectureDiagramElementTypes.CLASS.getSemanticHint();
			}

		} else
		// Dropping Port
		if(domainElement instanceof org.eclipse.uml2.uml.Port) {
			if(ArchitectureDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				semanticHint = ArchitectureDiagramElementTypes.PORT_CN.getSemanticHint();
			}
			if(ArchitectureDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalHint)) {
				semanticHint = ArchitectureDiagramElementTypes.PORT_CN.getSemanticHint();
			}

		} else
		// Dropping Property
		if(domainElement instanceof org.eclipse.uml2.uml.Property) {
			if(ArchitectureDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				semanticHint = ArchitectureDiagramElementTypes.PROPERTY_CN.getSemanticHint();
			}
			if(ArchitectureDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalHint)) {
				semanticHint = ArchitectureDiagramElementTypes.PROPERTY_CN.getSemanticHint();
			}

		} else
		// Dropping Comment
		if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
			if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				semanticHint = ArchitectureDiagramElementTypes.COMMENT.getSemanticHint();
			}

		} else
		// Dropping Constraint
		if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
			if(ArchitectureDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				semanticHint = ArchitectureDiagramElementTypes.CONSTRAINT.getSemanticHint();
			}

		}

		return new Integer(semanticHint);
	}

	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		String semanticHint = "-1";

		if(domainElement instanceof org.eclipse.uml2.uml.Connector) {
			semanticHint = ArchitectureDiagramElementTypes.CONNECTOR.getSemanticHint();
		}

		return new Integer(semanticHint);
	}
}
