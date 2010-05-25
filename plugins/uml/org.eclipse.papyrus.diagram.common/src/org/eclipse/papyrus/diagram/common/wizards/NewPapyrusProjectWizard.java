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
package org.eclipse.papyrus.diagram.common.wizards;

import static org.eclipse.papyrus.diagram.common.Activator.log;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.wizards.NewModelFilePage;
import org.eclipse.papyrus.wizards.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Wizard creates a Papyrus Project and a Papyrus Model inside it.
 */
public class NewPapyrusProjectWizard extends BasicNewProjectResourceWizard {

	/** The new project page. */
	private WizardNewProjectCreationPage myNewProjectPage;

	/** The diagram kind page. */
	private SelectDiagramKindPage myDiagramKindPage;

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

		myDiagramKindPage = new SelectDiagramKindPage("Select kind of diagram") {

			protected boolean validatePage() {
				return true;
			};
		};
		addPage(myDiagramKindPage);
	}

	/**
	 * Creates the file.
	 * 
	 * @return the file
	 */
	private IFile createFile() {
		IPath newFilePath = myNewProjectPage.getProjectHandle().getFullPath().append(NewModelFilePage.DEFAULT_NAME + "." + NewModelFilePage.DIAGRAM_EXTENSION);
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
		// if the user wants to create a diagram
		if(myDiagramKindPage.getCreationCommand() != null) {
			return createPapyrusModel();
		}
		return true;
	}

	/**
	 * Creates the papyrus model.
	 * 
	 * @return true, if successful
	 */
	private boolean createPapyrusModel() {
		final DiResourceSet diResourceSet = new DiResourceSet();
		try {
			// create a new file, result != null if successful
			final IFile newFile = createFile();

			RecordingCommand command = new RecordingCommand(diResourceSet.getTransactionalEditingDomain()) {

				@Override
				protected void doExecute() {
					// Create Model Resource, Notation Resource, DI Resource
					diResourceSet.createModelResources(newFile, getModelContentType(), getModelFileExtension());
					Resource modelResource = diResourceSet.getModelResource();
					if(modelResource != null) {
						IPath path = new Path(newFile.getName());
						initializeModelResource(modelResource, path.removeFileExtension().toString());
					}
				}
			};
			diResourceSet.getTransactionalEditingDomain().getCommandStack().execute(command);

			IWorkbenchPage page = getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if((newFile != null) && (page != null)) {

				String diagramName = myDiagramKindPage.getDiagramName();
				ICreationCommand creationCommand = myDiagramKindPage.getCreationCommand();

				if(creationCommand == null) {
					// Create an empty editor (no diagrams opened)
					// Geting an IPageMngr is enough to initialize the
					// SashSystem.
					EditorUtils.getTransactionalIPageMngr(diResourceSet.getDiResource(), diResourceSet.getTransactionalEditingDomain());
				} else {
					creationCommand.createDiagram(diResourceSet, null, diagramName);
				}
				try {
					diResourceSet.save(new NullProgressMonitor());
				} catch (IOException e) {
					log.error(e);
					return false;
				}

				try {
					IDE.openEditor(page, newFile, true);
				} catch (PartInitException e) {
					log.error(e);
					return false;
				}
			}
		} catch (Exception e) {
			log.error(e);
			return false;
		}
		return true;
	}

	/**
	 * Initialize model resource.
	 * 
	 * @param resource
	 *        the domain model resource
	 * @param rootElementName
	 *        the root element name
	 */
	private void initializeModelResource(Resource resource, String rootElementName) {
		//		// fjcano #293135 :: support model templates
		//		if(!isInitializeFromTemplate()) {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(rootElementName);
		resource.getContents().add(model);
		//		} else {
		//			super.initializeModelResource(resource, rootElementName);
		//		}
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

	/**
	 * Gets the model content type.
	 * 
	 * @return the model content type
	 */
	protected String getModelContentType() {
		return UMLPackage.eCONTENT_TYPE;
	}

	/**
	 * Gets the model file extension.
	 * 
	 * @return the model file extension
	 */
	protected String getModelFileExtension() {
		return "uml";
	}


}
