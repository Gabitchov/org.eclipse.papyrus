/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.pkg.edit.policy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.policies.ClassDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.pkg.provider.PackageDiagramElementTypes;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;

/** Customization of the DND edit policy for the Package Diagram */
public class CustomDragDropEditPolicy extends ClassDiagramDragDropEditPolicy {

	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		String semanticHint = "-1";

		containerView.eClass();

		// Fill the semantic hint during the drop
		if(containerView instanceof Diagram) {
			if(domainElement instanceof Package) {
				semanticHint = PackageDiagramElementTypes.PACKAGE.getSemanticHint();
			}

		} else if(containerView instanceof View) {
			if(domainElement instanceof Package) {
				semanticHint = PackageDiagramElementTypes.PACKAGE_CN.getSemanticHint();
			}
		}

		return new Integer(semanticHint);
	}

	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		String semanticHint = "-1";

		if(domainElement instanceof Dependency) {
			semanticHint = PackageDiagramElementTypes.DEPENDENCY.getSemanticHint();
		}

		if(domainElement instanceof PackageImport) {
			semanticHint = PackageDiagramElementTypes.PACKAGE_IMPORT.getSemanticHint();
		}

		return new Integer(semanticHint);
	}
}
