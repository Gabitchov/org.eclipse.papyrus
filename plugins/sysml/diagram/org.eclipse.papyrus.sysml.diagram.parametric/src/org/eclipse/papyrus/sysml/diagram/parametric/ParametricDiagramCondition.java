/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		chevrel.regis@gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.extension.commands.PerspectiveContextDependence;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * ParametricDiagramCondition to set conditions for the diagram creation
 */
public class ParametricDiagramCondition extends PerspectiveContextDependence {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(EObject selectedElement) {
		if(super.create(selectedElement)) {
			// Could create a Parametric Diagram on a Block
			if(selectedElement instanceof org.eclipse.uml2.uml.Class) {
				org.eclipse.uml2.uml.Class clazz = (org.eclipse.uml2.uml.Class)selectedElement;
				if(UMLUtil.getStereotypeApplication(clazz, Block.class) != null) {
					return true;
				}
			}
			// Could create a Parametric Diagram on a Package, an intermediate Block will be created
			else if(selectedElement instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
		}
		return false;
	}
}
