/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.providers.CUMLEditPartProvider;
import org.eclipse.papyrus.diagram.clazz.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;

/**
 * SysML Requirement Diagram inherited elements providers from UML Class Diagram providers
 * 
 */
public class InheritedElementEditPartProvider extends CUMLEditPartProvider {

	/**
	 * Constructor.
	 * 
	 */
	public InheritedElementEditPartProvider() {
		setFactory(new UMLEditPartFactory());
		setAllowCaching(true);
	}

	@Override
	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is an InternalBlock Diagram
			if(!RequirementDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Test for supported inherited types for related accepted nodes and edges
			EObject eobject = view.getElement();
			if((eobject instanceof org.eclipse.uml2.uml.Class) || (eobject instanceof org.eclipse.uml2.uml.Package) || (eobject instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart)) {
				return true;
			}
			if((eobject instanceof org.eclipse.uml2.uml.Association) || (eobject instanceof org.eclipse.uml2.uml.Abstraction) || (eobject instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentLinkEditPart) || (eobject instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart) || (eobject instanceof org.eclipse.papyrus.diagram.clazz.edit.parts.AbstractionEditPart)) {
				return true;
			}

		}
		return false;
	}
}
