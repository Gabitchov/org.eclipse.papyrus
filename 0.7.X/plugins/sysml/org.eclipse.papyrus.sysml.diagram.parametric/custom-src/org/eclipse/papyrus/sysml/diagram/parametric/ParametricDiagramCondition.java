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
import org.eclipse.papyrus.core.extension.commands.PerspectiveContextDependence;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * ParametricDiagramCondition to set conditions for the diagram creation
 */
public class ParametricDiagramCondition extends PerspectiveContextDependence {

	/**
	 * {@inheritDoc}
	 */
	public boolean create(EObject selectedElement) {
		if(super.create(selectedElement)) {
			if(selectedElement instanceof Element) {
				Element element = (Element)selectedElement;
				Package pack = element.getNearestPackage();
				if((pack.getAppliedProfile(SysmlResource.BLOCKS_ID, true) != null) && (pack.getAppliedProfile(SysmlResource.CONSTRAINTS_ID, true) != null)) {
					if((element.getAppliedStereotype(SysmlResource.CONSTRAINT_BLOCK_ID) != null) || (element.getAppliedStereotype(SysmlResource.BLOCK_ID) != null)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
