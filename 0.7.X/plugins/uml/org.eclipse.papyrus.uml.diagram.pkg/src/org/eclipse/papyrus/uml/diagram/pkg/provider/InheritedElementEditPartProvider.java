/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.pkg.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.providers.UMLEditPartProvider;
import org.eclipse.papyrus.uml.diagram.pkg.edit.part.PackageDiagramEditPart;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;

public class InheritedElementEditPartProvider extends UMLEditPartProvider {

	@Override
	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is a Package Diagram
			if(!PackageDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Test supported inherited types
			EObject eobject = view.getElement();

			/** Nodes *********** */
			if(eobject instanceof Package) {
				return true;
			}

			/** Edges *********** */
			if((eobject instanceof Dependency) || (eobject instanceof PackageImport)) {
				return true;
			}

			//			// Test supported inherited types
			//			String hint = view.getType();
			//			if(InheritedElementTypes.PACKAGE.getSemanticHint().equals(hint) || InheritedElementTypes.PACKAGE_NAME_LABEL_HINT.equals(hint) || InheritedElementTypes.PACKAGE_COMPARTMENT_HINT.equals(hint)) {
			//				return true;
			//			}
			//
			//			if(InheritedElementTypes.PACKAGE_CN.getSemanticHint().equals(hint) || InheritedElementTypes.PACKAGE_CN_NAME_LABEL_HINT.equals(hint) || InheritedElementTypes.PACKAGE_CN_COMPARTMENT_HINT.equals(hint)) {
			//				return true;
			//			}
			//
			//			if(InheritedElementTypes.DEPENDENCY.getSemanticHint().equals(hint) || InheritedElementTypes.DEPENDENCY_NAME_LABEL_HINT.equals(hint) || InheritedElementTypes.DEPENDENCY_STEREOTYPE_LABEL_HINT.equals(hint)) {
			//				return true;
			//			}
			//
			//			if(InheritedElementTypes.PACKAGE_IMPORT.getSemanticHint().equals(hint) || InheritedElementTypes.PACKAGE_IMPORT_STEREOTYPE_LABEL_HINT.equals(hint)) {
			//				return true;
			//			}
		}
		return false;
	}
}
