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
package org.eclipse.papyrus.sysml.diagram.parametric;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.extension.commands.ICreationCondition;
import org.eclipse.papyrus.diagramprofile.utils.StereotypeUtils;
import org.eclipse.uml2.uml.Element;

/**
 * ParametricDiagramCondition to set conditions for the diagram creation
 */
public class ParametricDiagramCondition implements ICreationCondition {

	/**
	 * {@inheritDoc}
	 */
	public boolean create(EObject selectedElement) {
		if (selectedElement instanceof Element) {
			Element element = (Element) selectedElement;
			boolean isProfileApplied = StereotypeUtils.isProfileApplied("SysML::Blocks", element);
			if (isProfileApplied) {
				return StereotypeUtils.isStereotypeApplied("SysML::Blocks::Block", element)
						|| StereotypeUtils.isStereotypeApplied("SysML::Blocks::ConstraintBlock", element);
			}
		}
		return false;
	}

}
