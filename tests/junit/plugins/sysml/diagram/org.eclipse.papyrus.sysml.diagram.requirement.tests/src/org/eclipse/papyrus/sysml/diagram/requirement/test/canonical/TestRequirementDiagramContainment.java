
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
