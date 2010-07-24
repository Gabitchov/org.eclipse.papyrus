/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateSysMLModelCommand;
import org.eclipse.papyrus.wizards.NewPapyrusProjectWizard;
import org.eclipse.papyrus.wizards.SelectDiagramCategoryPage;
import org.eclipse.papyrus.wizards.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbench;


/**
 * The Class NewSysMLProjectWizard.
 */
public class NewSysMLProjectWizard extends NewPapyrusProjectWizard {

	/**
	 * @see org.eclipse.papyrus.wizards.NewPapyrusProjectWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 * 
	 * @param workbench
	 * @param selection
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New SysML Project");
	}

	/**
	 * @see org.eclipse.jface.wizard.Wizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
	 * 
	 * @param page
	 * @return
	 */
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage next = super.getNextPage(page);
		if(next != null && SelectDiagramCategoryPage.PAGE_ID.equals(next.getName())) {
			return super.getNextPage(next);
		}
		return next;
	}

	/**
	 * @see org.eclipse.papyrus.wizards.NewPapyrusProjectWizard#addPages()
	 * 
	 */
	@Override
	public void addPages() {
		super.addPages();
		if(myNewProjectPage != null) {
			myNewProjectPage.setTitle("Papyrus SysML Project");
			myNewProjectPage.setDescription("Create a New Papyrus SysML Project");
		}
	}

	/**
	 * @see org.eclipse.papyrus.wizards.NewPapyrusProjectWizard#getSelectDiagramKindPage()
	 * 
	 * @return
	 */

	@Override
	protected SelectDiagramKindPage getSelectDiagramKindPage() {
		return new SelectDiagramKindPage() {

			@Override
			protected String getDiagramCategory() {
				return CreateSysMLModelCommand.COMMAND_ID;
			}
		};
	}
}
