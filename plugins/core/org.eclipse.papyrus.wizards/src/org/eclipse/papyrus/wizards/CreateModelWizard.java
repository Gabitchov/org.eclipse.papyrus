/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Tatiana Fesenko(CEA) - [313179] Refactor CreateModelWizard
 *******************************************************************************/
package org.eclipse.papyrus.wizards;

import static org.eclipse.papyrus.wizards.Activator.log;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

/**
 * Create new model file and initialize a selected diagram. This wizard create
 * several files : *.di : the DI file to store Di diagrams and references all
 * external diagrams like GMF diagrams. *.notation : the file to store pure GMF
 * diagrams *.uml : the standard UML file to store UML semantics elements.
 * (Model, Package, Class,...)
 * 
 * Those files can be used with the PapyrusEditor (see plugin.xml).
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreateModelWizard extends Wizard implements INewWizard {

	/** New model file page for the file */
	protected NewModelFilePage newModelFilePage;

	/** Select kind of new diagram the wizard must create */
	private SelectDiagramKindPage selectDiagramKindPage;

	/** The select diagram category page. */
	protected SelectDiagramCategoryPage selectDiagramCategoryPage;


	/** Current workbench */
	private IWorkbench workbench;
	
	/** The Constant WIZARD_ID. */
	public static final String WIZARD_ID = "org.eclipse.papyrus.wizards.createmodel";
	
	/** The Constant NEW_MODEL_SETTINGS. */
	public static final String NEW_MODEL_SETTINGS = "NewModelWizard";


	/**
	 * Instantiates a new creates the model wizard.
	 */
	public CreateModelWizard() {
		super();
		setWindowTitle("New Papyrus Model");
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPage(newModelFilePage);
		addPage(selectDiagramCategoryPage);
		addPage(selectDiagramKindPage);
	}

	/**
	 * Initializes this creation wizard using the passed workbench and object
	 * selection.
	 * <p>
	 * This method is called after the no argument constructor and before other methods are called.
	 * </p>
	 * 
	 * @param workbench
	 *        the current workbench
	 * @param selection
	 *        the current object selection
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		
		IDialogSettings workbenchSettings = Activator.getDefault().getDialogSettings();
        IDialogSettings section = workbenchSettings
                .getSection(NEW_MODEL_SETTINGS);
        if (section == null) {
			section = workbenchSettings.addNewSection(NEW_MODEL_SETTINGS);
		}
        setDialogSettings(section);

		newModelFilePage = new NewModelFilePage(selection);
		selectDiagramCategoryPage = new SelectDiagramCategoryPage();
		selectDiagramKindPage = getSelectDiagramKindPage();
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
	 * This method will be invoked, when the "Finish" button is pressed.
	 * 
	 * @return <code>true</code> if everything runs without problems, <code>false</code> if an exception must be caught.
	 * 
	 */
	@Override
	public boolean performFinish() {
		DiResourceSet diResourceSet = new DiResourceSet();
		// create a new file, result != null if successful
		EObject root = getRoot();
		final IFile newFile = newModelFilePage.createNewFile();
		selectDiagramCategoryPage.initDomainModel(diResourceSet, newFile, root);
		if(newFile == null) {
			return false;
		}

		selectDiagramKindPage.initDiagramModel(diResourceSet, root);

		IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
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
			selectDiagramKindPage.saveSettings();
		}

		return true;
	}
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	protected EObject getRoot() {
		return null;
	}


}
