package org.eclipse.papyrus.core.wizard;

import org.eclipse.papyrus.wizards.InitModelWizard;
import org.eclipse.papyrus.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbenchWizard;


public class TestCreateModelWizard extends TestNewModelWizardBase {

	@Override
	protected IWorkbenchWizard createWizard() {
		return new InitModelWizard() {
			@Override
			protected boolean isCreateFromExistingDomainModel() {
				return false;
			}
			
		};
	}

	public void testOrderOfPages() {
		Class[] expectedPages = new Class[]{
			NewModelFilePage.class,
			SelectDiagramCategoryPage.class,
			SelectDiagramKindPage.class,
		};

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}
	
	public void testDiagramFileExtenstion() {
		final String expectedExtension = "test.xxx";
		IWorkbenchWizard wizard = new InitModelWizard() {
			@Override
			protected boolean isCreateFromExistingDomainModel() {
				return false;
			}
			
			@Override
			public String getDiagramFileExtension() {
				return expectedExtension;
			}
			
		};
 
		initWizardDialog(wizard);
		NewModelFilePage page = (NewModelFilePage)wizard.getPages()[0];
		assertEquals(expectedExtension, page.getFileExtension());
	}

}
