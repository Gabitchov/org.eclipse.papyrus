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
package org.eclipse.papyrus.sysml.diagram.requirement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.extension.commands.PerspectiveContextDependence;
import org.eclipse.papyrus.sysml.util.SysmlResource;

/**
 * RequirementDiagramCondition to set conditions for the diagram creation
 */
public class RequirementDiagramCreationCondition extends PerspectiveContextDependence {

	/**
	 * {@inheritDoc}
	 */
	public boolean create(EObject selectedElement) {
		if(super.create(selectedElement)) {
			if(selectedElement instanceof org.eclipse.uml2.uml.Package) {
				org.eclipse.uml2.uml.Package pack = (org.eclipse.uml2.uml.Package)selectedElement;
				if(pack.getAppliedProfile(SysmlResource.REQUIREMENTS_ID, true) != null) {
					return true;
				}
			}
		}
		return false;
	}
}
