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
package org.eclipse.papyrus.robotml.diagram.datatypedef.edit.policy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.ClassDiagramDragDropEditPolicy;
import org.eclipse.papyrus.robotml.diagram.datatypedef.edit.part.DatatypeDefEditPart;
import org.eclipse.papyrus.robotml.diagram.datatypedef.provider.DatatypeDefElementTypes;

/** Customization of the DND edit policy for the DatatypeDef Diagram */
public class DatatypeDefDragDropEditPolicy extends ClassDiagramDragDropEditPolicy {

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
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.PACKAGE.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.PACKAGE_CN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.PACKAGE_CN.getSemanticHint();
			}

		} else
		// Dropping Enumeration
		if(domainElement instanceof org.eclipse.uml2.uml.Enumeration) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.ENUMERATION.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.ENUMERATION_CN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.ENUMERATION_CN.getSemanticHint();
			}

		} else
		// Dropping Comment
		if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.COMMENT.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.COMMENT_CN.getSemanticHint();
			}

		} else
		// Dropping Constraint
		if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.CONSTRAINT.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.CONSTRAINT_CN.getSemanticHint();
			}

		} else
		// Dropping DataType

		// Dropping PrimitiveType
		if(domainElement instanceof org.eclipse.uml2.uml.PrimitiveType) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.PRIMITIVE_TYPE.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.PRIMITIVE_TYPE_CN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.PRIMITIVE_TYPE_CN.getSemanticHint();
			}

		} else if(domainElement instanceof org.eclipse.uml2.uml.DataType) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.DATA_TYPE.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.DATA_TYPE_CN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.DATA_TYPE_CN.getSemanticHint();
			}

		} else
		// Dropping Signal
		if(domainElement instanceof org.eclipse.uml2.uml.Signal) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.SIGNAL.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.SIGNAL_CN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.SIGNAL_CN.getSemanticHint();
			}

		} else
		// Dropping EnumerationLiteral
		if(domainElement instanceof org.eclipse.uml2.uml.EnumerationLiteral) {
			if(DatatypeDefElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint();
			}

			if(DatatypeDefElementTypes.ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.ENUMERATION_ENUMERATION_LITERAL_CLN.getSemanticHint();
			}
		} else
		// Dropping Diagram
		if(domainElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {
			if(DatatypeDefEditPart.DIAGRAM_ID.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.SHORT_CUT_DIAGRAM.getSemanticHint();
			}

		} else
		// Dropping Property
		if(domainElement instanceof org.eclipse.uml2.uml.Property) {

			if(DatatypeDefElementTypes.SIGNAL_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.SIGNAL_PROPERTY_CLN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.SIGNAL_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.SIGNAL_PROPERTY_CLN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.DATA_TYPE_PROPERTY_CLN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.DATA_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.DATA_TYPE_PROPERTY_CLN.getSemanticHint();
			}
		} else
		// Dropping Operation
		if(domainElement instanceof org.eclipse.uml2.uml.Operation) {

			if(DatatypeDefElementTypes.DATA_TYPE_CN_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.DATA_TYPE_OPERATION_CLN.getSemanticHint();
			}
			if(DatatypeDefElementTypes.DATA_TYPE_COMPARTMENT_OPERATION_HINT.equals(containerGraphicalHint)) {
				return DatatypeDefElementTypes.DATA_TYPE_OPERATION_CLN.getSemanticHint();
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

		if(domainElement instanceof org.eclipse.uml2.uml.Dependency) {
			return DatatypeDefElementTypes.DEPENDENCY.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.PackageImport) {
			return DatatypeDefElementTypes.PACKAGE_IMPORT.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.PackageMerge) {
			return DatatypeDefElementTypes.PACKAGE_MERGE.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.ElementImport) {
			return DatatypeDefElementTypes.ELEMENT_IMPORT.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.Association) {
			return DatatypeDefElementTypes.ASSOCIATION.getSemanticHint();
		}
		if(domainElement instanceof org.eclipse.uml2.uml.Generalization) {
			return DatatypeDefElementTypes.GENERALIZATION.getSemanticHint();
		}

		return UNDEFINED;
	}
}
