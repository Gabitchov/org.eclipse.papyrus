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
package org.eclipse.papyrus.robotml.diagram.componentdef.edit.policy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.robotml.diagram.componentdef.edit.part.ComponentdefDiagramEditPart;
import org.eclipse.papyrus.robotml.diagram.componentdef.provider.ComponentdefDiagramElementTypes;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies.CustomDiagramDragDropEditPolicy;

/** Customization of the DND edit policy for the Componentdef Diagram */
public class ComponentdefDiagramDragDropEditPolicy extends CustomDiagramDragDropEditPolicy {

	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return new Integer(getNodeGraphicalHint(containerView, domainElement));
	}

	protected String getNodeGraphicalHint(View containerView, EObject domainElement) {
		String UNDEFINED = "-1";

		String containerGraphicalHint = containerView.getType();
		if(containerGraphicalHint == null) {
			// Cannot guess domain element graphical hint.
			return UNDEFINED;
		}

		// Fill the semantic hint during the drop
		// Elements inherited from CompositeDiagram
		// Dropping Class
		if(domainElement instanceof org.eclipse.uml2.uml.Class) {
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.CLASS.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.CLASS_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.CLASS_CN.getSemanticHint();
			}

		}
		// Dropping Port
		if(domainElement instanceof org.eclipse.uml2.uml.Port) {
			if(ComponentdefDiagramElementTypes.CLASS.getSemanticHint().equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN.getSemanticHint().equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN.getSemanticHint().equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PORT_CN.getSemanticHint();
			}

		}
		// Dropping Comment
		if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.COMMENT.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.COMMENT_CN.getSemanticHint();
			}

		}
		// Dropping Constraint
		if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.CONSTRAINT.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.CONSTRAINT_CN.getSemanticHint();
			}

		}
		// Dropping Property
		if(domainElement instanceof org.eclipse.uml2.uml.Property) {
			if(ComponentdefDiagramElementTypes.CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PROPERTY_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PROPERTY_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PROPERTY_CN.getSemanticHint();
			}

		}
		// Dropping Package
		if(domainElement instanceof org.eclipse.uml2.uml.Package) {
			if(ComponentdefDiagramElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(ComponentdefDiagramElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(ComponentdefDiagramEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return ComponentdefDiagramElementTypes.PACKAGE.getSemanticHint();
			}

		}

		return UNDEFINED;
	}

	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return new Integer(getLinkGraphicalHint(domainElement));
	}

	protected String getLinkGraphicalHint(EObject domainElement) {
		String UNDEFINED = "-1";


		return UNDEFINED;
	}
}
