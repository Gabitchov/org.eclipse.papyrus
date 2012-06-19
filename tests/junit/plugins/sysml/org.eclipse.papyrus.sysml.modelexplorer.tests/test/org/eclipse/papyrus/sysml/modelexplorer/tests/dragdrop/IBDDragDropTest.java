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
package org.eclipse.papyrus.sysml.modelexplorer.tests.dragdrop;

import org.junit.Test;

/**
 * Test for the drag and drop of IBd inside the model explorer
 */
public class IBDDragDropTest extends AbstractDragDropTest {

	/**
	 * Test on itself. Should do nothing
	 */
	@Test
	public void testDragDropIBDonItself() throws Exception {
		testUnexecutableDropOfDiagram(iBD_B1_Diagram, iBD_B1_Diagram);
		
	}
	
	/**
	 * Test on itself. Should do nothing
	 */
	@Test
	public void testDragDropIBDonOtherBlock() throws Exception {
		testUnexecutableDropOfDiagram(iBD_B1_Diagram, b1P1_P1_EObject);
		
	}
	
	/**
	 * Test on itself. Should do nothing
	 */
	@Test
	public void testDragDropIBDonSameBlock() throws Exception {
		testUnexecutableDropOfDiagram(iBD_B1_Diagram, b1_EObject);
	}
	
	/**
	 * Test on itself. Should do nothing
	 */
	@Test
	public void testDragDropIBDonPackage() throws Exception {
		testUnexecutableDropOfDiagram(iBD_B1_Diagram, p1_EObject);
	}
	
	/**
	 * Test on itself. Should do nothing
	 */
	@Test
	public void testDragDropBDDonSubPackage() throws Exception {
		testExecutableDropOfDiagram(bDD_Main_Diagram, p1_EObject);
	}
	
	/**
	 * Test on itself. Should do nothing
	 */
	@Test
	public void testDragDropBDDonBlock() throws Exception {
		testUnexecutableDropOfDiagram(bDD_Main_Diagram, b1_EObject);
	}
	
}
