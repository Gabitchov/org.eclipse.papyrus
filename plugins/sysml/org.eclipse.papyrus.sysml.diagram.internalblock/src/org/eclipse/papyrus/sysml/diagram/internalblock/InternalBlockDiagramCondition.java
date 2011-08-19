/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.extension.commands.PerspectiveContextDependence;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;

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
				if(ElementUtil.getStereotypeApplication(clazz, Block.class) != null) {
					return true;
				}
			}
		}
		return false;
	}
}
