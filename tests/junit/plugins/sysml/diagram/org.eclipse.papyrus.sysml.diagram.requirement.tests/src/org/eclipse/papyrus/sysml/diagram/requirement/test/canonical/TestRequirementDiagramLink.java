package org.eclipse.papyrus.sysml.diagram.requirement.test.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestLink;
import org.eclipse.papyrus.sysml.diagram.requirement.RequirementDiagramCreateCommand;
import org.eclipse.papyrus.sysml.diagram.requirement.provider.ElementTypes;
import org.junit.Test;

/**
 * The Class TestClassDiagramLink.
 */
public class TestRequirementDiagramLink extends TestLink {
	
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new RequirementDiagramCreateCommand();
	}
	
	/**
	 * Test to manage Abstraction
	 */
	@Test
	public void testToManageAbstraction() {
		testToManageLink(ElementTypes.CLASS, ElementTypes.CLASS, ElementTypes.ABSTRACTION, ElementTypes.PACKAGE, true);
	}
	
	
	
}
