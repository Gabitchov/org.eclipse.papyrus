package org.eclipse.papyrus.diagram.common.tests.wizard;

import junit.framework.TestCase;

import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.papyrus.wizards.SelectDiagramCategoryPage;
import org.junit.Test;


public class WizardTestCase extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testDefaultDiagramCategory() {
		final String categoryId = "uml";
		final IDialogSettings settings = new DialogSettings("") {
			@Override
			public String get(String key) {
				if ("diagramCategory".equals(key)) {
					return categoryId;
				}
				return super.get(key);
			}
			
		};
		SelectDiagramCategoryPage selectDiagramCategoryPage = new SelectDiagramCategoryPage() {
			@Override
			protected IDialogSettings getDialogSettings() {
				return settings;
			}
		};
		// selectDiagramCategory is initialized in setWizard(), as wizard is needed to get DialogSettings
		selectDiagramCategoryPage.setWizard(null);
		assertEquals(categoryId, selectDiagramCategoryPage.getDiagramCategory());
	}

}
