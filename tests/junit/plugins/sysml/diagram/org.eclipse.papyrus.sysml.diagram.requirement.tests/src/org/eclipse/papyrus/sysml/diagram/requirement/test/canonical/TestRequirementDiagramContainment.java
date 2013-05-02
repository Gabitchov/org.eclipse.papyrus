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
package org.eclipse.papyrus.sysml.diagram.requirement.test.canonical;

import org.eclipse.papyrus.sysml.diagram.requirement.provider.ElementTypes;
import org.junit.Test;

public class TestRequirementDiagramContainment extends TestContainmentLink {

	/**
	 * Test to manage containmentLink.
	 */
	@Test
	public void testToManageContainment() {
		testToManageLink(ElementTypes.CLASS, ElementTypes.CLASS, ElementTypes.CONTAINMENT_LINK, ElementTypes.PACKAGE);
	}

}
