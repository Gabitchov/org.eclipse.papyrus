/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.composite.providers.UMLEditPartProvider;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;

public class InheritedElementEditPartProvider extends UMLEditPartProvider {

	@Override
	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is an InternalBlock Diagram
			if(!InternalBlockDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Test supported inherited types
			EObject eobject = view.getElement();

			/** Nodes *********** */
			if((eobject instanceof org.eclipse.uml2.uml.Class) || (eobject instanceof Property)) {
				return true;
			}

			/** Edges *********** */
			if(eobject instanceof Connector) {
				return true;
			}

			// String hint = view.getType();
			// /** Nodes *********** */
			//
			// /** Class */
			// if
			// (InternalBlockDiagramElementTypes.CLASS.getSemanticHint().equals(hint)
			// ||
			// InternalBlockDiagramElementTypes.CLASS_NAME_LABEL_HINT.equals(hint)
			// ||
			// InternalBlockDiagramElementTypes.CLASS_COMPARTMENT_HINT.equals(hint))
			// {
			// return true;
			// }
			//
			// if
			// (InternalBlockDiagramElementTypes.CLASS_CN.getSemanticHint().equals(hint)
			// ||
			// InternalBlockDiagramElementTypes.CLASS_CN_NAME_LABEL_HINT.equals(hint)
			// ||
			// InternalBlockDiagramElementTypes.CLASS_CN_COMPARTMENT_HINT.equals(hint))
			// {
			// return true;
			// }
			//
			// /** Property */
			// if
			// (InternalBlockDiagramElementTypes.PROPERTY_CN.getSemanticHint().equals(hint)
			// ||
			// InternalBlockDiagramElementTypes.PROPERTY_CN_NAME_LABEL_HINT.equals(hint)
			// ||
			// InternalBlockDiagramElementTypes.PROPERTY_CN_COMPARTMENT_HINT.equals(hint))
			// {
			// return true;
			// }
			//
			// /** Port */
			// if
			// (InternalBlockDiagramElementTypes.PORT_CN.getSemanticHint().equals(hint)
			// ||
			// InternalBlockDiagramElementTypes.PORT_CN_NAME_LABEL_HINT.equals(hint)
			// ||
			// InternalBlockDiagramElementTypes.PORT_CN_STEREOTYPE_LABEL_HINT.equals(hint))
			// {
			// return true;
			// }
			//
			// /** Edges *********** */
			//
			// /** Connector */
			// if
			// (InternalBlockDiagramElementTypes.CONNECTOR.getSemanticHint().equals(hint)
			// ||
			// InternalBlockDiagramElementTypes.CONNECTOR_STEREOTYPE_LABEL_HINT.equals(hint))
			// {
			// return true;
			// }
		}
		return false;
	}
}
