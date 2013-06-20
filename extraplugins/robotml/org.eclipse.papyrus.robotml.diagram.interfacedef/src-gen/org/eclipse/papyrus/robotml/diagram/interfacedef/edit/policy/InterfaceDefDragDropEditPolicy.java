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
package org.eclipse.papyrus.robotml.diagram.interfacedef.edit.policy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.robotml.diagram.interfacedef.edit.part.InterfaceDefEditPart;
import org.eclipse.papyrus.robotml.diagram.interfacedef.provider.InterfaceDefElementTypes;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.ClassDiagramDragDropEditPolicy;

/** Customization of the DND edit policy for the InterfaceDef Diagram */
public class InterfaceDefDragDropEditPolicy extends ClassDiagramDragDropEditPolicy {

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
		// Elements inherited from ClassDiagram
		// Dropping Package
		if(domainElement instanceof org.eclipse.uml2.uml.Package) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.PACKAGE.getSemanticHint();
			}
			if(InterfaceDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(InterfaceDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.PACKAGE_CN.getSemanticHint();
			}

		} else
		// Dropping Comment
		if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.COMMENT.getSemanticHint();
			}

		} else
		// Dropping Constraint
		if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.CONSTRAINT.getSemanticHint();
			}

		} else
		// Dropping Interface
		if(domainElement instanceof org.eclipse.uml2.uml.Interface) {
			if(InterfaceDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.INTERFACE_CN.getSemanticHint();
			}
			if(InterfaceDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.INTERFACE_CN.getSemanticHint();
			}
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.INTERFACE.getSemanticHint();
			}

		} else
		// Dropping Diagram
		if(domainElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {
			if(InterfaceDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.SHORT_CUT_DIAGRAM.getSemanticHint();
			}

		} else
		// Dropping Property
		if(domainElement instanceof org.eclipse.uml2.uml.Property) {

			if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.INTERFACE_PROPERTY_CLN.getSemanticHint();
			}
			if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.INTERFACE_PROPERTY_CLN.getSemanticHint();
			}
		} else
		// Dropping Operation
		if(domainElement instanceof org.eclipse.uml2.uml.Operation) {

			if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.INTERFACE_OPERATION_CLN.getSemanticHint();
			}
			if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.INTERFACE_OPERATION_CLN.getSemanticHint();
			}
		} else
		// Dropping Class
		if(domainElement instanceof org.eclipse.uml2.uml.Class) {

			if(InterfaceDefElementTypes.INTERFACE_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.INTERFACE_CLASS_CLN.getSemanticHint();
			}
			if(InterfaceDefElementTypes.INTERFACE_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerGraphicalHint)) {
				return InterfaceDefElementTypes.INTERFACE_CLASS_CLN.getSemanticHint();
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

		if(domainElement instanceof org.eclipse.uml2.uml.PackageImport) {
			return InterfaceDefElementTypes.PACKAGE_IMPORT.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.PackageMerge) {
			return InterfaceDefElementTypes.PACKAGE_MERGE.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.Generalization) {
			return InterfaceDefElementTypes.GENERALIZATION.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.InterfaceRealization) {
			return InterfaceDefElementTypes.INTERFACE_REALIZATION.getSemanticHint();
		}

		return UNDEFINED;
	}
}
