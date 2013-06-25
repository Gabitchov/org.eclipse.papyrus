/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlrt.wizard.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.wizards.CreateModelWizard;
import org.eclipse.ui.IWorkbench;

//Unused yet. The Papyrus wizard is not really useful when the language/profile doesn't provide specific diagrams
public class NewUMLRTModelWizard extends CreateModelWizard {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New UML RealTime Model");
	}

	@Override
	public String getModelKindName() {
		return "Papyrus RealTime";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String[] getDiagramCategoryIds() {
		return new String[]{ CreateUMLRTModelCommand.COMMAND_ID };
	}

	/**
	 * {@inheritDoc}
	 */
	//	@Override
	//	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
	//		//here UML RT is the only available category
	//		return null;
	//	}

	/**
	 * {@inheritDoc}
	 */
	//	@Override
	//	protected void saveDiagramCategorySettings() {
	//		//here UML RT is the only available category
	//	}

}
