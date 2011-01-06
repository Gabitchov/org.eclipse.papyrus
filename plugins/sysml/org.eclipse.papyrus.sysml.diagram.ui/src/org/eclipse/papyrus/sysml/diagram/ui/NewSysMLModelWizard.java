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
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateSysMLModelCommand;
import org.eclipse.papyrus.wizards.CreateModelWizard;
import org.eclipse.papyrus.wizards.NewModelFilePage;
import org.eclipse.papyrus.wizards.SelectDiagramCategoryPage;
import org.eclipse.ui.IWorkbench;


/**
 * The Class NewSysMLModelWizard.
 */
public class NewSysMLModelWizard extends CreateModelWizard {

	/**
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 * 
	 * @param workbench
	 * @param selection
	 */

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New SysML Model");
	}

	/**
	 * Instantiates a new new sys ml model wizard.
	 */
	public NewSysMLModelWizard() {
		super();
	}

	@Override
	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection) {
		NewModelFilePage page = super.createNewModelFilePage(selection);
		if (page != null) {
			page.setTitle("Papyrus SysML Model");
			page.setDescription("Create a New Papyrus SysML Model");
		}
		return page;
	}
	
	@Override
	protected String getDiagramCategoryId() {
		return CreateSysMLModelCommand.COMMAND_ID;
	}

	@Override
	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		//here SysML is the only available category
		return null;
	}
	
	@Override
	protected void saveDiagramCategorySettings() {
		//here SysML is the only available category
	}

}
