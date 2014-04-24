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

import org.eclipse.papyrus.sysml.diagram.common.commands.CreateSysMLModelCommand;
import org.eclipse.papyrus.sysml.diagram.ui.NewSysMLModelWizard;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.junit.Test;


public class TestCreateSysMLModelWizard extends TestNewModelWizardBase {

	@Override
	protected IWorkbenchWizard createWizard() {
		return new NewSysMLModelWizard();
	}

	@Test
	public void testOrderOfPages() {
		Class<?>[] expectedPages = new Class[]{ NewModelFilePage.class, SelectDiagramKindPage.class, };

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}

	@Test
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

	@Test
	public void testDiagramFileExtenstion() {
		final String expectedExtension = "di";
		NewSysMLModelWizard wizard = new NewSysMLModelWizard() {

			@Override
			protected String[] getDiagramCategoryIds() {
				return new String[]{ CreateSysMLModelCommand.COMMAND_ID };
			}

		};

		initWizardDialog(wizard);
		NewModelFilePage page = getPage(wizard, NewModelFilePage.class);
		assertEquals(expectedExtension, page.getFileExtension());
	}

}
