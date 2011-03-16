/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.test.canonical;

import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.junit.Test;


public class TestClassDiagramContainment extends TestContainmentLink{
	/**
	 * Test to manage containmentLink.
	 */
	@Test
	public void testToManageContainment() {
		testToManageLink(UMLElementTypes.Class_2008,UMLElementTypes.Class_2008,UMLElementTypes.Link_4023,UMLElementTypes.Package_2007);
	}

}
