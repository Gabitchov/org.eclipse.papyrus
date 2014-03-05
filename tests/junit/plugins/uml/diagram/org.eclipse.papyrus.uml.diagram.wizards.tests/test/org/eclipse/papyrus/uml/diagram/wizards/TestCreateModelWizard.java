package org.eclipse.papyrus.uml.diagram.wizards;

import org.eclipse.papyrus.uml.diagram.profile.CreateProfileModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.junit.Test;


public class TestCreateModelWizard extends TestNewModelWizardBase {

	@Override
	protected IWorkbenchWizard createWizard() {
		return new InitModelWizard() {

			@Override
			public boolean isCreateFromExistingDomainModel() {
				return false;
			}

		};
	}

	@Test
	public void testOrderOfPages() {
		Class<?>[] expectedPages = new Class[]{ NewModelFilePage.class, SelectDiagramCategoryPage.class, SelectDiagramKindPage.class, };

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}

	@Test
	public void testDiagramFileExtentionLabel() {
		final String expectedExtension = "test.xxx";
		IWorkbenchWizard wizard = new InitModelWizard() {

			@Override
			public boolean isCreateFromExistingDomainModel() {
				return false;
			}

			@Override
			public String getDiagramFileExtension(String categoryId, String defaultExtension) {
				return expectedExtension;
			}

		};

		initWizardDialog(wizard);
		NewModelFilePage page = (NewModelFilePage)wizard.getPages()[0];
		//assertEquals(expectedExtension, page.getFileExtension());
	}

	@Test
	public void testDiagramFileExtenstionForProfile() {
		final String expectedExtension = "profile.di";
		InitModelWizard wizard = new InitModelWizard() {

			@Override
			public boolean isCreateFromExistingDomainModel() {
				return false;
			}

			@Override
			protected String[] getDiagramCategoryIds() {
				return new String[]{ CreateProfileModelCommand.COMMAND_ID };
			}

		};

		initWizardDialog(wizard);
		//		String actual = wizard.getDiagramFileExtension();
		//		assertEquals(expectedExtension, actual);
	}

	@Test
	public void testDiagramFileExtenstionForUML() {
		final String expectedExtension = "di";
		InitModelWizard wizard = new InitModelWizard() {

			@Override
			public boolean isCreateFromExistingDomainModel() {
				return false;
			}

			@Override
			protected String[] getDiagramCategoryIds() {
				return new String[]{ "uml" };
			}

		};

		initWizardDialog(wizard);
		//		String actual = wizard.getDiagramFileExtension();
		//		assertEquals(expectedExtension, actual);
	}

}
