package org.eclipse.papyrus.core.wizard;

import org.eclipse.papyrus.wizards.NewPapyrusProjectWizard;
import org.eclipse.papyrus.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;


public class TestNewProjectWizard extends TestNewModelWizardBase {
	
	
	protected IWorkbenchWizard createWizard() {
		return new NewPapyrusProjectWizard();
	}

	public void testOrderOfPages() {
		Class[] expectedPages = new Class[]{
			WizardNewProjectCreationPage.class,
			SelectDiagramCategoryPage.class,
			SelectDiagramKindPage.class,
		};
		testOrderOfPages(expectedPages);
	}

	public void testProfileExtension() {
	}


}
