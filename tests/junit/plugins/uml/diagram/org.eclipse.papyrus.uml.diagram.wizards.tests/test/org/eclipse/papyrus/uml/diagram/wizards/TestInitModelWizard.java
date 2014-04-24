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

import static org.junit.Assert.assertEquals;

import org.eclipse.papyrus.uml.diagram.profile.CreateProfileModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectRootElementPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.junit.Test;


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
				return new String[]{ "uml" };
			}

			@Override
			public String getDiagramFileExtension(String categoryId, String defaultExtension) {
				return "uml";
			}

		};
	}

	@Test
	public void testDiagramFileExtentionLabel() {
		final String expectedExtension = "di"; // the extension is always *.di
		IWorkbenchWizard wizard = new InitModelWizard() {

			@Override
			public boolean isCreateFromExistingDomainModel() {
				return isCreateFromExistingModel;
			}

			@Override
			public String getDiagramFileExtension(String categoryId, String defaultExtension) {
				return "tanya"; // arbitrary extension to avoid NPE
			}

		};

		initWizardDialog(wizard);
		NewModelFilePage page = getPage(wizard, NewModelFilePage.class);
		assertEquals(expectedExtension, page.getFileExtension());
	}

	@Test
	public void testOrderOfPages() {
		Class<?>[] expectedPages = new Class[]{ NewModelFilePage.class, SelectDiagramCategoryPage.class, SelectDiagramKindPage.class, SelectRootElementPage.class, };

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}

	@Test
	public void testDiagramFileExtenstionForUML() {
		// 333849 - [Wizard] Init Diagram: Respect file extension of the UML model
		final String expectedExtension = "di"; // init-from-existing always uses this, even for profiles
		InitModelWizard wizard = new InitModelWizard() {

			@Override
			public boolean isCreateFromExistingDomainModel() {
				return isCreateFromExistingModel;
			}


			@Override
			public String getDiagramFileExtension(String categoryId, String defaultExtension) {
				return "profile.di"; // arbitrary extension to avoid NPE
			}

			@Override
			protected String[] getDiagramCategoryIds() {
				return new String[]{ CreateProfileModelCommand.COMMAND_ID };
			}

		};

		// ensure that the dialog would create a profile
		settings.saveDefaultDiagramCategory(new String[]{ "profile" });

		initWizardDialog(wizard);
		NewModelFilePage page = getPage(wizard, NewModelFilePage.class);
		assertEquals(expectedExtension, page.getFileExtension());
	}


}
