package org.eclipse.papyrus.sysml.diagram.requirement.test.canonical;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestTopNode;
import org.eclipse.papyrus.sysml.diagram.requirement.RequirementDiagramCreateCommand;
import org.eclipse.papyrus.sysml.diagram.requirement.provider.ElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


/**
 * The Class TestClassDiagramTopNode.
 */
public class TestRequirementDiagramTopNode extends TestTopNode {
	
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new RequirementDiagramCreateCommand();
	}

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(ElementTypes.PACKAGE, getDiagramEditPart().getDiagramPreferencesHint());
	}
	
	/**
	 * Test to manage i package.
	 */
	@Test
	public void testToManageIPackage() {
		testToManageNode(ElementTypes.PACKAGE, UMLPackage.eINSTANCE.getPackage(), ElementTypes.PACKAGE, true);
	}
	
	/**
	 * Test to manage Requirement (inherite class).
	 */
	@Test
	public void testToManageRequirement() {
		testToManageNode(ElementTypes.CLASS , UMLPackage.eINSTANCE.getClass_(), ElementTypes.PACKAGE, true);
	}
	
}
