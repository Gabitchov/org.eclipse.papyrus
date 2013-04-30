package org.eclipse.papyrus.sysml.diagram.requirement.test.canonical;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.sysml.diagram.requirement.RequirementDiagramCreateCommand;
import org.eclipse.papyrus.sysml.diagram.requirement.provider.ElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


/**
 * The Class TestClassDiagramChildNode.
 */
public class TestRequirementDiagramChildNode extends TestChildNode {
	
	
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
		testToManageNode(ElementTypes.PACKAGE_CN, UMLPackage.eINSTANCE.getPackage(), ElementTypes.PACKAGE_CN, true);
		//testToManageNode(ElementTypes.PACKAGE_CN, UMLPackage.eINSTANCE.getClass_(), ElementTypes.PACKAGE_CN, true);
	}
	
	/**
	 * Test to manage <<Requirement>> (stereotype class).
	 */
	@Test
	public void testToManageRequirement() {
		testToManageNode(ElementTypes.CLASS_CN, UMLPackage.eINSTANCE.getClass_(), ElementTypes.PACKAGE_CN, true);
		//testToManageNode(ElementTypes.CLASS_CN, UMLPackage.eINSTANCE.getClass_(), ElementTypes.PACKAGE_CN, true);
	}
	
}
