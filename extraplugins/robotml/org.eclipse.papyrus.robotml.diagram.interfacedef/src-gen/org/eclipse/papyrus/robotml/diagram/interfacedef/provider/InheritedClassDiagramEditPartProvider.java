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
package org.eclipse.papyrus.robotml.diagram.interfacedef.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.robotml.diagram.interfacedef.edit.part.InterfaceDefEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLEditPartProvider;

public class InheritedClassDiagramEditPartProvider extends UMLEditPartProvider {

	@Override
	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is a InterfaceDef Diagram
			if(!InterfaceDefEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
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
			if(eobject instanceof org.eclipse.uml2.uml.Interface) {
				return true;
			}
			if(eobject instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Property) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Operation) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Class) {
				return true;
			}

			/** Edges *********** */
			if(eobject instanceof org.eclipse.uml2.uml.PackageImport) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.PackageMerge) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Generalization) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.InterfaceRealization) {
				return true;
			}

			// Additional test needed here to decide whether to support Feature type links.
			// As feature type link are not related to a MetaClass from the domain model
			// they are not already handled by previous tests.
			String hint = view.getType();

			/** Edges (Feature) : COMMENT_ANNOTATED_ELEMENT *********** */
			if(InterfaceDefElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint().equals(hint)) {
				return true;
			}
			/** Edges (Feature) : CONSTRAINT_CONSTRAINED_ELEMENT *********** */
			if(InterfaceDefElementTypes.CONSTRAINT_CONSTRAINED_ELEMENT.getSemanticHint().equals(hint)) {
				return true;
			}
		}
		return false;
	}
}
