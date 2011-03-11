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
package org.eclipse.papyrus.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.wizards.pages.SelectDiagramCategoryPage;

/**
 * The Wizard creates a new Project and a several Papyrus Models of different categories inside it.
 */
public class NewPapyrusProjectWithMultiModelsWizard extends NewPapyrusProjectWizard {

	/** The my do not create model for no diagrams. */
	private boolean myDoNotCreateModelForNoDiagrams;
	
	/** The Constant WIZARD_ID. */
	public static final String WIZARD_ID = "org.eclipse.papyrus.wizards.1createproject.several"; //$NON-NLS-1$

	
	/**
	 * Instantiates a new new papyrus project with multi models wizard.
	 */
	public NewPapyrusProjectWithMultiModelsWizard() {
		this(false);
	}

	/**
	 * Instantiates a new new papyrus project with multi models wizard.
	 *
	 * @param doNotCreateModelForNoDiagrams the do not create model for no diagrams
	 */
	public NewPapyrusProjectWithMultiModelsWizard(boolean doNotCreateModelForNoDiagrams) {
		myDoNotCreateModelForNoDiagrams = doNotCreateModelForNoDiagrams;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#createSelectDiagramCategoryPage()
	 */
	@Override
	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		return new SelectDiagramCategoryPage(true);
	}

	/**
	 * Perform finish.
	 *
	 * @return true, if successful
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		IProject newProjectHandle;
		try {
			newProjectHandle = createNewProject();
		} catch (CoreException e) {
			Activator.log.error(Messages.NewPapyrusProjectWithMultiModelsWizard_exception_on_project_opening, e);
			return false;
		}
		if (newProjectHandle == null) {
			return false;
		}
		for (String category: getDiagramCategoryIds()) {
			if (myDoNotCreateModelForNoDiagrams && getDiagramKindsFor(category).isEmpty()){
				// don't create model
				continue;
			}
			final IFile newFile = createNewModelFile(category);
			DiResourceSet diResourceSet = new DiResourceSet();
			createAndOpenPapyrusModel(diResourceSet, newFile, category);
		}

		saveDiagramCategorySettings();
		saveDiagramKindSettings();
		return true;
	}

}
