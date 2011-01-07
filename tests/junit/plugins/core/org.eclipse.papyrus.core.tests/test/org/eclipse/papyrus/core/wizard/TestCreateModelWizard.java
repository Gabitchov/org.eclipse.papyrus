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
			
			@Override
			public String getDiagramFileExtension() {
				return "test.xxx";
			}
			
		};
	}

	public void testOrderOfPages() {
		Class[] expectedPages = new Class[]{
			NewModelFilePage.class,
			SelectDiagramCategoryPage.class,
			SelectDiagramKindPage.class,
		};
		testOrderOfPages(expectedPages);
	}
	
	public void testDiagramFileExtenstion() {
		NewModelFilePage page = (NewModelFilePage)getWizard().getPages()[0];
		assertEquals("test.xxx", page.getFileExtension());
	}

}
