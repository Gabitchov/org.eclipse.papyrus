package org.eclipse.papyrus.uml.diagram.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.papyrus.uml.diagram.profile.CreateProfileModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.InitModelWizard;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectRootElementPage;
import org.eclipse.ui.IWorkbenchWizard;


public class TestInitModelWizard extends TestNewModelWizardBase {

	private final boolean isCreateFromExistingModel = true;

	@Override
	protected IWorkbenchWizard createWizard() {
		return new InitModelWizard() {

			@Override
			public boolean isCreateFromExistingDomainModel() {
				return true;
			}

			
			@Override
			protected String[] getDiagramCategoryIds() {
				return new String[]{"uml"};
			}

//			@Override
//			public String getDiagramFileExtension(String categoryId, String defaultExtension) {
//				return "test.uml";
//			}
			
			protected String getDiagramFileName(IFile domainModel) {
				return "test.uml";
			}

		};
	}

	public void testDiagramFileExtentionLabel() {
		final String expectedExtension = "test.xxx";
		IWorkbenchWizard wizard = new InitModelWizard() {

			@Override
			public boolean isCreateFromExistingDomainModel() {
				return isCreateFromExistingModel;
			}
			
			protected String getDiagramFileName(IFile domainModel) {
				return "tanya"; // arbitrary extension to avoid NPE
			}

		};

		initWizardDialog(wizard);
		NewModelFilePage page = (NewModelFilePage)wizard.getPages()[0];
		assertEquals(expectedExtension, page.getFileExtension());
	}


	public void testOrderOfPages() {
		Class[] expectedPages = new Class[]{ NewModelFilePage.class, SelectDiagramCategoryPage.class, SelectDiagramKindPage.class, SelectRootElementPage.class, };

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}

	public void testDiagramFileExtenstionForUML() {
		// 333849 - [Wizard] Init Diagram: Respect file extension of the UML model
		final String expectedExtension = "di";
		InitModelWizard wizard = new InitModelWizard() {

			@Override
			public boolean isCreateFromExistingDomainModel() {
				return isCreateFromExistingModel;
			}

			
			protected String getDiagramFileName(IFile domainModel) {
				return "tanya"; // arbitrary extension to avoid NPE
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


}
