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
package org.eclipse.papyrus.sysml.diagram.blockdefinition;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.extension.commands.PerspectiveContextDependence;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * BlockDefinitionDiagramCondition to set conditions for the diagram creation
 */
public class BlockDefinitionDiagramCondition extends PerspectiveContextDependence {

	/**
	 * {@inheritDoc}
	 */
	public boolean create(EObject selectedElement) {
		if(super.create(selectedElement)) {
			if(selectedElement instanceof org.eclipse.uml2.uml.Package) {
				org.eclipse.uml2.uml.Package pack = (org.eclipse.uml2.uml.Package)selectedElement;
				if(pack.getAllAppliedProfiles().contains(UMLUtil.getProfile(BlocksPackage.eINSTANCE, pack))
					&& pack.getAllAppliedProfiles().contains(UMLUtil.getProfile(PortandflowsPackage.eINSTANCE, pack))) {
					return true;
				}
			}
		}
		return false;
	}
}
