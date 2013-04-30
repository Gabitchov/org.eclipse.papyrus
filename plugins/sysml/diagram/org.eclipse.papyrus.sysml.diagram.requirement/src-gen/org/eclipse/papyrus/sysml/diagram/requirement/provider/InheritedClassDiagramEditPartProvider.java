/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

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

			// Ensure current diagram is a Requirement Diagram
			if(!ElementTypes.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Test supported inherited types
			EObject eobject = view.getElement();

			/** Nodes (and ChildLabelNodes) *********** */
			if(eobject instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Class) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.NamedElement) {
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
			if(eobject instanceof org.eclipse.uml2.uml.Enumeration) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.PrimitiveType) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.DataType) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Signal) {
				return true;
			}

			/** Edges *********** */
			if(eobject instanceof org.eclipse.uml2.uml.Abstraction) {
				return true;
			}

		}
		return false;
	}
}
