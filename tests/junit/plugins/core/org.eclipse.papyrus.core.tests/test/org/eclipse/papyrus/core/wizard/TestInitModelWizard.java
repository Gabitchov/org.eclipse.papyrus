package org.eclipse.papyrus.core.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.diagram.profile.CreateProfileModelCommand;
import org.eclipse.papyrus.wizards.InitModelWizard;
import org.eclipse.papyrus.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramKindPage;
import org.eclipse.papyrus.wizards.pages.SelectRootElementPage;
import org.eclipse.ui.IWorkbenchWizard;


public class TestInitModelWizard extends TestNewModelWizardBase {
	
	private final boolean isCreateFromExistingModel = true;

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
	
	public void testDiagramFileExtentionLabel() {
		final String expectedExtension = "test.xxx";
		IWorkbenchWizard wizard = new InitModelWizard() {
			@Override
			protected boolean isCreateFromExistingDomainModel() {
				return isCreateFromExistingModel;
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
	
	public void testDiagramFileExtenstionForUML() {
		final String expectedExtension = "profile.di";
		InitModelWizard wizard = new InitModelWizard() {
			@Override
			protected boolean isCreateFromExistingDomainModel() {
				return isCreateFromExistingModel;
			}
			
			@Override
			protected String getDiagramCategoryId() {
				return CreateProfileModelCommand.COMMAND_ID;
			}
			
		};
 
		initWizardDialog(wizard);
		String actual = wizard.getDiagramFileExtension();
		assertEquals(expectedExtension, actual);
	}

	
}
