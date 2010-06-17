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

import static org.eclipse.papyrus.wizards.Activator.log;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

/**
 * The Wizard creates a Papyrus Project and a Papyrus Model inside it.
 */
public class NewPapyrusProjectWizard extends BasicNewProjectResourceWizard {

	/** The new project page. */
	protected WizardNewProjectCreationPage myNewProjectPage;

	/** The diagram kind page. */
	private SelectDiagramKindPage myDiagramKindPage;

	/** The select diagram category page. */
	private SelectDiagramCategoryPage selectDiagramCategoryPage;

	/** The initial project name. */
	private String initialProjectName;

	/**
	 * @see org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 * 
	 * @param workbench
	 * @param selection
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New Papyrus Project");
		
		IDialogSettings workbenchSettings = Activator.getDefault().getDialogSettings();
        IDialogSettings section = workbenchSettings
                .getSection(CreateModelWizard.NEW_MODEL_SETTINGS);
        if (section == null) {
			section = workbenchSettings.addNewSection(CreateModelWizard.NEW_MODEL_SETTINGS);
		}
        setDialogSettings(section);

        selectDiagramCategoryPage = new SelectDiagramCategoryPage();
		myDiagramKindPage = getSelectDiagramKindPage();

	}
	
	/**
	 * Gets the select diagram kind page.
	 *
	 * @return the select diagram kind page
	 */
	protected SelectDiagramKindPage getSelectDiagramKindPage() {
		return new SelectDiagramKindPage();
		
	}

	/**
	 * @see org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard#addPages()
	 * 
	 */
	public void addPages() {
		super.addPages();
		myNewProjectPage = (WizardNewProjectCreationPage)getPage("basicNewProjectPage"); //$NON-NLS-1$
		if(myNewProjectPage != null) {
			myNewProjectPage.setInitialProjectName(initialProjectName);
			myNewProjectPage.setTitle("Papyrus Project");
			myNewProjectPage.setDescription("Create a New Papyrus Project");
		}
		
		addPage(selectDiagramCategoryPage);
		addPage(myDiagramKindPage);
		
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
		// 316160 [Wizard] Do not display WizardNewProjectReferencePage in New Papyrus Project Wizard  
		if (next != null && "basicReferenceProjectPage".equals(next.getName())) {
			return super.getNextPage(next);
		}
		return next;
	}
	
	/**
	 * Creates the file.
	 * 
	 * @return the file
	 */
	private IFile createFile() {
		IPath newFilePath = myNewProjectPage.getProjectHandle().getFullPath().append(NewModelFilePage.DEFAULT_NAME + "." + NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION);
		return ResourcesPlugin.getWorkspace().getRoot().getFile(newFilePath);
	}

	/**
	 * @see org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard#performFinish()
	 * 
	 * @return
	 */
	public boolean performFinish() {
		boolean created = super.performFinish();
		if(!created) {
			return false;
		}
		final DiResourceSet diResourceSet = new DiResourceSet();
		// create a new file, result != null if successful
		final IFile newFile = createFile();
		EObject root = null;
		selectDiagramCategoryPage.initDomainModel(diResourceSet, newFile, root);
		if(newFile == null) {
			return false;
		}

		myDiagramKindPage.initDiagramModel(diResourceSet, root);

		IWorkbenchPage page = getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if(page != null) {
			try {
				IDE.openEditor(page, newFile, true);
			} catch (PartInitException e) {
				log.error(e);
				return false;
			}
		}

		IDialogSettings settings = getDialogSettings();
		if (settings != null) {
			selectDiagramCategoryPage.saveSettings(settings);
			myDiagramKindPage.saveSettings();
		}

		return true;
		
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
