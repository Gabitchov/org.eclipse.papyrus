/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector.encapsulated;

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.BeforeClass;

/**
 * JUnit abstract tests for Connector re-orient.
 */
public class AbstractLinkReorientTargetConnectorTest extends org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.connector.AbstractLinkReorientTargetConnectorTest {
	
	@BeforeClass
	public static void setPartBlockEncapsulated() throws Exception {
		TestPrepareUtils.setBlockIsEncapsulated((Element) (partContainer1.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type())), true);
	}
	
}
