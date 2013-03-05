/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *  Christian W. Damus (CEA) - Support creating models in repositories (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

/**
 * The Wizard creates a new Project and a Papyrus Model inside it.
 */
public class NewPapyrusProjectWizard extends CreateModelWizard {

	/** The Constant WIZARD_ID. */
	public static final String WIZARD_ID = "org.eclipse.papyrus.uml.diagram.wizards.1createproject"; //$NON-NLS-1$

	/** The new project page. */
	private WizardNewProjectCreationPage myNewProjectPage;

	/** The initial project name. */
	private String initialProjectName;

	@Override
	public boolean isCreateProjectWizard() {
		return true;
	}
	
	/**
	 * Inits the.
	 *
	 * @param workbench the workbench
	 * @param selection the selection
	 * {@inheritDoc}
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle(Messages.NewPapyrusProjectWizard_new_papyrus_project);
		myNewProjectPage = createNewProjectCreationPage();
	}

	/**
	 * Creates the new project creation page.
	 *
	 * @return the wizard new project creation page
	 */
	protected WizardNewProjectCreationPage createNewProjectCreationPage() {
		WizardNewProjectCreationPage newProjectPage = new WizardNewProjectCreationPage("papyrusNewProjectPage"); //$NON-NLS-1$
		newProjectPage.setInitialProjectName(initialProjectName);
		newProjectPage.setTitle(Messages.NewPapyrusProjectWizard_papyrus_project);
		newProjectPage.setDescription(Messages.NewPapyrusProjectWizard_papyrus_project_desc);
		return newProjectPage;
	}

	/**
	 * Adds the pages.
	 *
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPage(myNewProjectPage);
		super.addPages();
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
			Activator.log.error(Messages.NewPapyrusProjectWizard_exception_on_opening, e);
			return false;
		}
		if (newProjectHandle == null) {
			return false;
		}
		return super.performFinish();
	}

	/**
	 * Creates the new project.
	 *
	 * @return the i project
	 * @throws CoreException the core exception
	 */
	protected IProject createNewProject() throws CoreException {
		// get a project handle
		final IProject project = myNewProjectPage.getProjectHandle();

		// get a project descriptor
		java.net.URI projectLocationURI = null;
		if (!myNewProjectPage.useDefaults()) {
			projectLocationURI = myNewProjectPage.getLocationURI();
		}

        IProjectDescription projectDescription = null;
        NullProgressMonitor progressMonitor = new NullProgressMonitor();
        if (!project.exists())
        {
          projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(project.getName());
          if (projectLocationURI != null)
          {
            projectDescription.setLocationURI(projectLocationURI);
          }
          project.create(projectDescription, new SubProgressMonitor(progressMonitor, 1));
          project.open(new SubProgressMonitor(progressMonitor, 1));
        }
        else 
        {
          projectDescription = project.getDescription();
          project.open(new SubProgressMonitor(progressMonitor, 1));
        }

        return project;
	}
	
	@Override
	protected URI createNewModelURI(String categoryId) {
		IPath newFilePath = myNewProjectPage.getProjectHandle().getFullPath().append(NewModelFilePage.DEFAULT_NAME + "." + getDiagramFileExtension(categoryId)); //$NON-NLS-1$
		return URI.createPlatformResourceURI(newFilePath.toString(), true);
	}

	/**
	 * Sets the initial project name.
	 * 
	 * @param initialProjectName
	 *        the new initial project name
	 */
	public void setInitialProjectName(String initialProjectName) {
		this.initialProjectName = initialProjectName;
	}
}
