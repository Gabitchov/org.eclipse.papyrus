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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLEditPartProvider;
import org.eclipse.papyrus.uml.diagram.common.edit.part.SlotChildLabelEditPart;

public class InheritedClassDiagramEditPartProvider extends UMLEditPartProvider {

	@Override
	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is a BlockDefinition Diagram
			if(!ElementTypes.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Test supported inherited types
			EObject eobject = view.getElement();

			/** Nodes (and ChildLabelNodes) *********** */
			if(eobject instanceof org.eclipse.uml2.uml.Model) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.InstanceSpecification) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Constraint) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Comment) {
				return true;
			}
			if(eobject instanceof org.eclipse.uml2.uml.Slot) {
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

	/**
	 * EditPart replacement for ChildLabelNodes from inherited diagram.
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=351433
	 */
	protected IGraphicalEditPart createEditPart(View view) {
		if(ElementTypes.INSTANCE_SPECIFICATION_SLOT_CLN.getSemanticHint().equals(view.getType())) {
			return new SlotChildLabelEditPart(view);
		}
		return super.createEditPart(view);
	}
}
