/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment.test.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.deployment.CreateDeploymentDiagramCommand;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;
import org.junit.Test;

/**
 * The Class TestComponentDiagramLink.
 */
public class TestDeploymentDiagramManifestationLink extends TestManifestationLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateDeploymentDiagramCommand();
	}

	/**
	 * Test to manage Manifestation
	 */

	@Test
	public void testToManageManifestation() {
		testToManageLink(UMLElementTypes.Artifact_2006, UMLElementTypes.Node_2008, UMLElementTypes.Manifestation_4002, UMLElementTypes.Package_2009, true);
	}

}
