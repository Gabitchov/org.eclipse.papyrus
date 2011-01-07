package org.eclipse.papyrus.core.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.wizards.InitModelWizard;
import org.eclipse.papyrus.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramKindPage;
import org.eclipse.papyrus.wizards.pages.SelectRootElementPage;
import org.eclipse.ui.IWorkbenchWizard;


public class TestInitModelWizard extends TestNewModelWizardBase {

	@Override
	protected IWorkbenchWizard createWizard() {
		return new InitModelWizard() {
			@Override
			protected boolean isCreateFromExistingDomainModel() {
				return true;
			}
			
			@Override
			protected String getDiagramFileName(IFile domainModel) {
				return "test.uml";
			}
			
		};
	}
	
	public void testOrderOfPages() {
		Class[] expectedPages = new Class[]{
			NewModelFilePage.class,
			SelectDiagramCategoryPage.class,
			SelectDiagramKindPage.class,
			SelectRootElementPage.class,			
		};

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}
	
}
