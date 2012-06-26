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
package org.eclipse.papyrus.sysml.diagram.internalblock;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.extension.commands.PerspectiveContextDependence;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * InternalBlockDiagramCondition to set conditions for the diagram creation
 */
public class InternalBlockDiagramCondition extends PerspectiveContextDependence {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(EObject selectedElement) {
		if(super.create(selectedElement)) {
			if(selectedElement instanceof org.eclipse.uml2.uml.Class) {
				org.eclipse.uml2.uml.Class clazz = (org.eclipse.uml2.uml.Class)selectedElement;
				if(UMLUtil.getStereotypeApplication(clazz, Block.class) != null) {
					return true;
				}
			}
		}
		return false;
	}
}
