package org.eclipse.papyrus.uml.diagram.wizards;

import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.junit.Test;


public class TestNewProjectWizard extends TestNewModelWizardBase {


	@Override
	protected IWorkbenchWizard createWizard() {
		return new NewPapyrusProjectWizard();
	}

	@Test
	public void testOrderOfPages() {

		Class<?>[] expectedPages = new Class[]{ WizardNewProjectCreationPage.class, SelectDiagramCategoryPage.class, SelectDiagramKindPage.class, };

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}

	public void testProfileExtension() {
	}


}
