package org.eclipse.papyrus.diagram.clazz.test.canonical;

import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.junit.Test;

public class TestMutliLink extends AbstractTestMultiLink {
	/**
	 * Test to manage dependency.
	 */
	@Test
	public void testToManageMultiDependency() {
		testToManageMultiLink(UMLElementTypes.Dependency_4008, UMLElementTypes.Dependency_4018, true);
	}
	
	/**
	 * Test to manage multiassociation.
	 */
	@Test
	public void testToManageMultiAssociation() {
		testToManageMultiLink(UMLElementTypes.Association_4001, UMLElementTypes.Association_4019, false);
	}
}
