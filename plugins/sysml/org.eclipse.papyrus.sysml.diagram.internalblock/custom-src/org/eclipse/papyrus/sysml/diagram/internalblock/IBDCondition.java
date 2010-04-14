/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.extension.commands.PerspectiveContextDependence;
import org.eclipse.papyrus.diagramprofile.utils.StereotypeUtils;
import org.eclipse.uml2.uml.Element;

public class IBDCondition extends PerspectiveContextDependence {

	public boolean create(EObject selectedElement) {
		if(super.create(selectedElement)) {
			if (selectedElement instanceof Element) {
				Element element = (Element) selectedElement;
				boolean isProfileApplied = StereotypeUtils.isProfileApplied("SysML::Blocks", element)
						&& StereotypeUtils.isProfileApplied("SysML::PortAndFlows", element);
				if (isProfileApplied) {
					return StereotypeUtils.isStereotypeApplied("SysML::Blocks::Block", element)
							|| StereotypeUtils.isStereotypeApplied("SysML::Blocks::ConstraintBlock", element);
				}
			}
		}
		return false;
	}

}
