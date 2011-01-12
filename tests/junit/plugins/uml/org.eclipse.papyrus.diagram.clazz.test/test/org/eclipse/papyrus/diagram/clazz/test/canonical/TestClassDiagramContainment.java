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
