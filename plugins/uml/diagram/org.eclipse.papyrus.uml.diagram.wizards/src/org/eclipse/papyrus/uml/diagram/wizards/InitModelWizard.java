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
package org.eclipse.papyrus.uml.diagram.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.diagram.wizards.category.PapyrusModelFromExistingDomainModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage.CategoryProvider;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectRootElementPage;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.ui.IWorkbench;

/**
 * 
 * The New Papyrus Model Wizard.
 * If being invoke on the *.uml file - initializes a new Papyrus diagram for the selected domain model.
 * If is selected is empty or in not uml - creates a new Papyrus Model.
 */
public class InitModelWizard extends CreateModelWizard {

	/** Select the root element containing the new diagram. */
	private SelectRootElementPage selectRootElementPage;

	/** The is init from existing domain model. */
	private boolean isInitFromExistingDomainModel;

	/**
	 * Inits the.
	 * 
	 * @param workbench
	 *        the workbench
	 * @param selection
	 *        the selection {@inheritDoc}
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		IFile file = getSelectedFile(selection);
		isInitFromExistingDomainModel = isSupportedDomainModelFile(file);
		super.init(workbench, selection);
		selectRootElementPage = createSelectRootElementPage(file);
		if(isCreateFromExistingDomainModel()) {
			// Init Model not Create a new one
			setWindowTitle(Messages.InitModelWizard_init_papyrus_diagram);
		}
	}

	/**
	 * Creates the select root element page.
	 * 
	 * @param file
	 *        the file
	 * @return the select root element page
	 */
	protected SelectRootElementPage createSelectRootElementPage(IFile file) {
		if(!isCreateFromExistingDomainModel()) {
			// create model - nothing to choose from
			return null;
		}
		return new SelectRootElementPage(file);
	}

	/**
	 * Creates the select diagram kind page.
	 * 
	 * @return the select diagram kind page {@inheritDoc}
	 */
	@Override
	protected SelectDiagramKindPage createSelectDiagramKindPage() {
		if(isCreateFromExistingDomainModel()) {
			return new SelectDiagramKindPage(false, new CategoryProvider() {

				public String[] getCurrentCategories() {
					return getDiagramCategoryIds();
				}

			}, SelectDiagramKindPage.DEFAULT_CREATION_COMMAND_REGISTRY);
		};
		return super.createSelectDiagramKindPage();
	}

	/**
	 * Creates the new model file page.
	 * 
	 * @param selection
	 *        the selection
	 * @return the new model file page {@inheritDoc}
	 */
	@Override
	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection) {
		if(!isCreateFromExistingDomainModel()) {
			return super.createNewModelFilePage(selection);
		}
		return new NewDiagramForExistingModelPage(selection, getDiagramFileName(getSelectedFile(selection)) + "." + getDiagramFileExtension(null), getDiagramFileExtension(null)); //$NON-NLS-1$
	}


	/**
	 * Adds the pages.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		super.addPages();
		addPageIfNotNull(selectRootElementPage);
	};

	/**
	 * Returns true is the file can be served as a model model for the diagram.
	 * 
	 * @param file
	 *        the file
	 * @return true, if is supported domain model file
	 */
	public static boolean isSupportedDomainModelFile(IFile file) {
		//		if(file != null && UmlModel.UML_FILE_EXTENSION.equals(file.getFileExtension())){System.err.println("is SupportedDomainModelFile");}
		//		else {System.err.println("not SupportedDomainModelFile");}
		return file != null && UmlModel.UML_FILE_EXTENSION.equals(file.getFileExtension());
	}

	/**
	 * Checks if is supported domain model file.
	 * 
	 * @param sselection
	 *        the sselection
	 * @return true, if is supported domain model file
	 */
	public static boolean isSupportedDomainModelFile(IStructuredSelection sselection) {
		IFile file = getSelectedFile(sselection);
		//		if(!isSupportedDomainModelFile(file)){System.err.println("not SupportedDomainModelFile");}
		return isSupportedDomainModelFile(file);
	}

	/**
	 * Creates the papyrus models.
	 * 
	 * @param diResourceSet
	 *        the di resource set
	 * @param newFile
	 *        the new file {@inheritDoc}
	 */
	@Override
	protected void createPapyrusModels(ModelSet modelSet, IFile newFile) {
		if(isCreateFromExistingDomainModel()) {
			RecordingCommand command = new PapyrusModelFromExistingDomainModelCommand(modelSet, newFile, getRoot());
			getCommandStack(modelSet).execute(command);
		} else {
			super.createPapyrusModels(modelSet, newFile);
		}
	}

	/**
	 * Inits the domain model.
	 * 
	 * @param diResourceSet
	 *        the di resource set
	 * @param newFile
	 *        the new file
	 * @param diagramCategoryId
	 *        the diagram category id {@inheritDoc}
	 */
	@Override
	protected void initDomainModel(ModelSet modelSet, final IFile newFile, String diagramCategoryId) {
		if(isCreateFromExistingDomainModel()) {
			// do nothing
		} else {
			super.initDomainModel(modelSet, newFile, diagramCategoryId);
		}
	}

	/**
	 * Inits the diagrams.
	 * 
	 * @param diResourceSet
	 *        the di resource set
	 * @param categoryId
	 *        the category id {@inheritDoc}
	 */
	@Override
	protected void initDiagrams(ModelSet modelSet, String categoryId) {
		initDiagrams(modelSet, getRoot(), categoryId);
	}

	/**
	 * Checks if is creates the from existing domain model.
	 * 
	 * @return true, if is creates the from existing domain model
	 */
	protected boolean isCreateFromExistingDomainModel() {
		return isInitFromExistingDomainModel;
	}

	/**
	 * Suggests a name of diagram file for the domain model file without extension.
	 * 
	 * @param domainModel
	 *        the domain model
	 * @return the diagram file name
	 */
	protected String getDiagramFileName(IFile domainModel) {
		return domainModel.getLocation().removeFileExtension().lastSegment();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.wizards.CreateModelWizard#getDiagramFileExtension(java.lang.String)
	 */
	@Override
	protected String getDiagramFileExtension(String diagramCategoryId) {
		if(isCreateFromExistingDomainModel()) {
			return NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION;
		}
		return super.getDiagramFileExtension(diagramCategoryId);
	}

	/**
	 * Returns the first file from the given selection.
	 * 
	 * @param selection
	 *        the selection
	 * @return the selected file
	 */
	private static IFile getSelectedFile(IStructuredSelection selection) {
		if(selection != null && !selection.isEmpty() && selection.getFirstElement() instanceof IFile) {
			return (IFile)selection.getFirstElement();
		}
		return null;
	}

	/**
	 * Gets the root.
	 * 
	 * @return the root
	 */
	private EObject getRoot() {
		if(selectRootElementPage != null) {
			return selectRootElementPage.getModelElement();
		}
		return null;
	}

	/**
	 * The Class NewDiagramForExistingModelPage.
	 */
	protected class NewDiagramForExistingModelPage extends NewModelFilePage {

		/** The my diagram file name. */
		private String myDiagramFileName;

		/**
		 * Instantiates a new new diagram for existing model page.
		 * 
		 * @param selection
		 *        the selection
		 * @param defaultFileName
		 *        the default file name
		 * @param diagramExtension
		 *        the diagram extension
		 */
		public NewDiagramForExistingModelPage(IStructuredSelection selection, String defaultFileName, String diagramExtension) {
			super(selection);
			myDiagramFileName = defaultFileName;
			setFileName(defaultFileName);
			setFileExtension(diagramExtension);
			setTitle(Messages.InitModelWizard_init_papyrus_model);
			setDescription(Messages.InitModelWizard_init_papyrus_model_desc);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validatePage()
		 */
		@Override
		protected boolean validatePage() {
			if(!super.validatePage()) {
				return false;
			}
			if(!myDiagramFileName.equals(getFileName())) {
				setErrorMessage(Messages.bind(Messages.InitModelWizard_diagram_name_is_different_from_domain_model, myDiagramFileName));
				return false;
			}
			return true;
		};

	}

}
