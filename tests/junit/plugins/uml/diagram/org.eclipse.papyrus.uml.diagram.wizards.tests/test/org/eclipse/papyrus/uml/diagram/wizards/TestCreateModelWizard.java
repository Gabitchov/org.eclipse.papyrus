/*****************************************************************************
 * Copyright (c) 2013, 2014 LIFL, CEA LIST, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  LIFL - Initial API and implementation
 *  CEA LIST - Update tests and re-integrate into automation suite
 *  
 *****************************************************************************/
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
		final String expectedExtension = "di"; // the extension is always *.di
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
		NewModelFilePage page = getPage(wizard, NewModelFilePage.class);
		assertEquals(expectedExtension, page.getFileExtension());
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

		// ensure that the dialog would create a profile
		settings.saveDefaultDiagramCategory(new String[] {"profile"});
		
		initWizardDialog(wizard);
		NewModelFilePage page = getPage(wizard, NewModelFilePage.class);
		assertEquals(expectedExtension, page.getFileExtension());
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
		NewModelFilePage page = getPage(wizard, NewModelFilePage.class);
		assertEquals(expectedExtension, page.getFileExtension());
	}

}
