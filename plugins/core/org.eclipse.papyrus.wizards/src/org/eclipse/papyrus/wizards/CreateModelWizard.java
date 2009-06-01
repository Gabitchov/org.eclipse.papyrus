/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.wizards;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.core.IPapyrusUIConstants;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

/**
 * Create new model file and initialize a selected diagram. This wizard create several files : *.di : the DI file to store Di diagrams and references all external diagrams like GMF diagrams.
 * *.notation : the file to store pure GMF diagrams *.uml : the standard UML file to store UML semantics elements. (Model, Package, Class,...)
 * 
 * Those files can be used with the PapyrusEditor (see plugin.xml).
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreateModelWizard extends Wizard implements INewWizard {

	/** ID of this wizard */
	public static final String WIZARD_ID = IPapyrusUIConstants.WIZARD_ID + ".createmodel";

	/** New model file page for the file */
	private NewModelFilePage newModelFilePage;

	/** Select kinf of new diagram the wizard must create */
	private SelectDiagramKindPage selectDiagramKindPage;

	/** Select the root element containing the new diagram */
	private SelectRootElementPage selectRootElementPage;

	/** Current workbench */
	private IWorkbench workbench;

	/**
	 * The URI of the selected domain model. Do not create a new uml model, but use the selected
	 */
	private URI domainModelURI;

	/**
	 * ResourceSet used to link all Resource (Model and DI)
	 */
	DiResourceSet diResourceSet;

	public CreateModelWizard() {
	}

	public CreateModelWizard(URI domainModelURI) {
		super();
		this.domainModelURI = domainModelURI;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPage(newModelFilePage);
		addPage(selectDiagramKindPage);
		if (domainModelURI != null) {
			addPage(selectRootElementPage);
		}
	}

	/**
	 * Initializes this creation wizard using the passed workbench and object selection.
	 * <p>
	 * This method is called after the no argument constructor and before other methods are called.
	 * </p>
	 * 
	 * @param workbench
	 *            the current workbench
	 * @param selection
	 *            the current object selection
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.diResourceSet = new DiResourceSet(/* (AdapterFactory) null */);
		// set the di file name with the selected domain model
		if (selection != null && !selection.isEmpty()) {
			if (selection.getFirstElement() instanceof IFile) {
				IFile file = (IFile) selection.getFirstElement();
				String extension = file.getFileExtension();
				if ("uml".equals(extension)) {
					this.domainModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

					this.newModelFilePage = new NewModelFilePage("Create a new Papyrus model", "Create a new Papyrus model from an existing semantic model", selection, true);
					String diModelFileName = (file.getLocation().removeFileExtension().lastSegment());
					diModelFileName += "." + IPapyrusUIConstants.MODEL_EXTENSION;
					this.newModelFilePage.setFileName(diModelFileName);

					diResourceSet.loadUMLResource(domainModelURI);
					Resource resource = diResourceSet.getUMLModelResource();
					EObject diagramRoot = resource.getContents().get(0);
					this.selectRootElementPage = new SelectRootElementPage("Select the root element", diagramRoot);
				}
			}
		}
		if (domainModelURI == null) {
			this.newModelFilePage = new NewModelFilePage("Create a new Papyrus model", "Create a new empty Papyrus model", selection, false);
		}
		selectDiagramKindPage = new SelectDiagramKindPage("Select kind of diagram", newModelFilePage);
	}

	/**
	 * This method will be invoked, when the "Finish" button is pressed.
	 * 
	 * @return <code>true</code> if everything runs without problems, <code>false</code> if an exception must be caught.
	 * 
	 */
	@Override
	public boolean performFinish() {
		// create a new file, result != null if successful
		IFile newFile = newModelFilePage.createNewFile();
		NewModelFilePage.fileCount++;

		// open newly created file in the editor
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
		if ((newFile != null) && (page != null)) {
			// Create needed object
			diResourceSet.transactionalCreateModelResources(newFile);

			String diagramName = selectDiagramKindPage.getDiagramName();
			ICreationCommand creationCommand = selectDiagramKindPage.getCreationCommand();

			if( creationCommand == null)
			{
				// Create an empty editor (no diagrams opened)
				// Geting an IPageMngr is enough to initialize the SashSystem.
				EditorUtils.getTransactionalIPageMngr(diResourceSet.getDiResource(), diResourceSet.getTransactionalEditingDomain());
			}
			else
			{
				// Create requested diagram.
				if (domainModelURI != null) {
					creationCommand.createDiagram(diResourceSet, selectRootElementPage.getModelElement(), diagramName);
				} else {
					creationCommand.createDiagram(diResourceSet, null, diagramName);
				}
			}
			
			
			try {
				diResourceSet.saveResources();
			} catch (IOException e) {
				PapyrusTrace.log(e);
				return false;
			}

			try {
				IDE.openEditor(page, newFile, true);
			} catch (PartInitException e) {
				PapyrusTrace.log(e);
				return false;
			}
		}
		return true;
	}

}
