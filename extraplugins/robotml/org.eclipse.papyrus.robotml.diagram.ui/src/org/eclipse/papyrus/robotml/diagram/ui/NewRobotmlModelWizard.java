/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.robotml.diagram.common.commands.CreateRobotmlModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.CreateModelWizard;

import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.ui.IWorkbench;

public class NewRobotmlModelWizard extends CreateModelWizard {

	/**
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 * 
	 * @param workbench
	 * @param selection
	 */

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New RobotML Model");
	}

	/**
	 * Instantiates a new new Proteus model wizard.
	 */
	public NewRobotmlModelWizard() {
		super();

	}



	@Override
	public String getModelKindName() {
		// TODO Auto-generated method stub

		return "RobotML Model";
	}

	@Override
	protected String[] getDiagramCategoryIds() {
		return new String[]{ CreateRobotmlModelCommand.COMMAND_ID };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		// here RobotML is the only available category
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveDiagramCategorySettings() {
		// here RobotML is the only available category
	}

}
