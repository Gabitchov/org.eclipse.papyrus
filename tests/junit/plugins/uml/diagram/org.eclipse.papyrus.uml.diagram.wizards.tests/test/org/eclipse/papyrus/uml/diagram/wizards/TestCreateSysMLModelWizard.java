package org.eclipse.papyrus.uml.diagram.wizards;

import org.eclipse.papyrus.sysml.diagram.common.commands.CreateSysMLModelCommand;
import org.eclipse.papyrus.sysml.diagram.ui.NewSysMLModelWizard;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbenchWizard;


public class TestCreateSysMLModelWizard extends TestNewModelWizardBase {

	@Override
	protected IWorkbenchWizard createWizard() {
		return new NewSysMLModelWizard() {
			
		};
	}

	public void testOrderOfPages() {
		Class[] expectedPages = new Class[]{
			NewModelFilePage.class,
			SelectDiagramKindPage.class,
		};

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}
	
	public void testDiagramCategory() {
		class NewSysMLModelWizardWithPublicAccess extends NewSysMLModelWizard {
			// open access to protected method
			@Override
			public String[] getDiagramCategoryIds() {
				return super.getDiagramCategoryIds();
			}
		}
		
		NewSysMLModelWizardWithPublicAccess wizard = new NewSysMLModelWizardWithPublicAccess();
		initWizardDialog(wizard);
		String actualCategory = wizard.getDiagramCategoryIds()[0];
		assertEquals(CreateSysMLModelCommand.COMMAND_ID, actualCategory);
	}

	public void testDiagramFileExtenstion() {
		final String expectedExtension = "di";
		NewSysMLModelWizard wizard = new NewSysMLModelWizard() {
			@Override
			protected String[] getDiagramCategoryIds() {
				return new String[]{CreateSysMLModelCommand.COMMAND_ID};
			}
			
		};
 
		initWizardDialog(wizard);
//		String actual = wizard.getDiagramFileExtension();
//		assertEquals(expectedExtension, actual);
	}
	
}
