package org.eclipse.papyrus.core.wizard;

import org.eclipse.papyrus.wizards.CreateModelWizard;
import org.eclipse.papyrus.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbenchWizard;


public class TestCreateModelWizard extends TestNewModelWizardBase {

	protected IWorkbenchWizard createWizard() {
		return new CreateModelWizard();
	}

	public void testOrderOfPages() {
		Class[] expectedPages = new Class[]{
			NewModelFilePage.class,
			SelectDiagramCategoryPage.class,
			SelectDiagramKindPage.class,
		};
		testOrderOfPages(expectedPages);
	}

}
