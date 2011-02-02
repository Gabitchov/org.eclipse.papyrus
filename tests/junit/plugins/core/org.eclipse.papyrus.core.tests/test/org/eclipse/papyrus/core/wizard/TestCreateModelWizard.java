package org.eclipse.papyrus.core.wizard;

import org.eclipse.papyrus.diagram.profile.CreateProfileModelCommand;
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
		Class[] expectedPages = new Class[]{ NewModelFilePage.class, SelectDiagramCategoryPage.class, SelectDiagramKindPage.class, };

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}

	public void testDiagramFileExtentionLabel() {
		// final String expectedExtension = "test.xxx";
		final String expectedExtension = "di";
		IWorkbenchWizard wizard = new InitModelWizard() {

			@Override
			protected boolean isCreateFromExistingDomainModel() {
				return false;
			}

			@Override
			protected String getDiagramFileExtension(String categoryId, String defaultExtension) {
				return expectedExtension;
			}

		};

		initWizardDialog(wizard);
		NewModelFilePage page = (NewModelFilePage)wizard.getPages()[0];
		assertEquals(expectedExtension, page.getFileExtension());
	}


	public void testDiagramFileExtenstionForProfile() {
		final String expectedExtension = "profile.di";
		InitModelWizard wizard = new InitModelWizard() {

			@Override
			protected boolean isCreateFromExistingDomainModel() {
				return false;
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

	public void testDiagramFileExtenstionForUML() {
		final String expectedExtension = "di";
		InitModelWizard wizard = new InitModelWizard() {

			@Override
			protected boolean isCreateFromExistingDomainModel() {
				return false;
			}

			@Override
			protected String getDiagramCategoryId() {
				return "uml";
			}

		};

		initWizardDialog(wizard);
		String actual = wizard.getDiagramFileExtension();
		assertEquals(expectedExtension, actual);
	}

}
