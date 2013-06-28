/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.domain.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLEditPartProvider;

public class InheritedClassDiagramEditPartProvider extends UMLEditPartProvider {

	@Override
	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is a Domain Diagram
			if(!ElementTypes.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Test supported inherited types
			EObject eobject = view.getElement();

			/** Nodes (and ChildLabelNodes) *********** */
			if(eobject instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Comment) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Constraint) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.InstanceSpecification) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Class) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.DataType) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Enumeration) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.PrimitiveType) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Slot) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Property) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Reception) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Operation) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Interface) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Signal) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.EnumerationLiteral) {
				return true;
			}

			/** Edges *********** */
			if(eobject instanceof org.eclipse.uml2.uml.Generalization) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.InstanceSpecification) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Association) {
				return true;
			}

			// Additional test needed here to decide whether to support Feature type links.
			// As feature type link are not related to a MetaClass from the domain model
			// they are not already handled by previous tests.
			// Also concerns NotationType.
			String hint = view.getType();

			/** Edges (Feature) : COMMENT_ANNOTATED_ELEMENT *********** */
			if(ElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint().equals(hint)) {
				return true;
			}
			/** Edges (Feature) : CONSTRAINT_CONSTRAINED_ELEMENT *********** */
			if(ElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT.getSemanticHint().equals(hint)) {
				return true;
			}



		}
		return false;
	}
}
