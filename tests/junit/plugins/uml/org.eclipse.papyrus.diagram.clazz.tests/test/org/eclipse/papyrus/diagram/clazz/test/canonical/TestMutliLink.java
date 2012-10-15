package org.eclipse.papyrus.diagram.clazz.test.canonical;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.AbstractTestMultiLink;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.junit.Test;

public class TestMutliLink extends AbstractTestMultiLink {
	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		// TODO Auto-generated method stub
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.Class_2008, getDiagramEditPart().getDiagramPreferencesHint());
	}
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
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateClassDiagramCommand();
	}
}
