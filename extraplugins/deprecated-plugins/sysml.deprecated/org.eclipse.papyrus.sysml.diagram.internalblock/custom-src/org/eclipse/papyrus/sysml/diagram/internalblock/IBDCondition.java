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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

public class IBDCondition extends PerspectiveContextDependence {

	public boolean create(EObject selectedElement) {
		if(super.create(selectedElement)) {
			if(selectedElement instanceof Element) {
				Element element = (Element)selectedElement;
				Package pack = element.getNearestPackage();
				if((pack.getAppliedProfile("SysML::Blocks", true) != null) && (pack.getAppliedProfile("SysML::Constraints", true) != null) && (pack.getAppliedProfile("SysML::PortAndFlows", true) != null)) {
					if((element.getAppliedStereotype("SysML::Constraints::ConstraintBlock") != null) || (element.getAppliedStereotype("SysML::Blocks::Block") != null)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
