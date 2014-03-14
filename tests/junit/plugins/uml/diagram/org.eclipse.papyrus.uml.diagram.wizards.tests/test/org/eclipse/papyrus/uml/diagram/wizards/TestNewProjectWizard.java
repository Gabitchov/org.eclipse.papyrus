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

import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.junit.Test;


public class TestNewProjectWizard extends TestNewModelWizardBase {


	@Override
	protected IWorkbenchWizard createWizard() {
		return new NewPapyrusProjectWizard();
	}

	@Test
	public void testOrderOfPages() {

		Class<?>[] expectedPages = new Class[]{ WizardNewProjectCreationPage.class, SelectDiagramCategoryPage.class, SelectDiagramKindPage.class, };

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}

	public void testProfileExtension() {
	}


}
