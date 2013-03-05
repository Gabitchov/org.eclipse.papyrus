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

import static org.eclipse.papyrus.uml.diagram.wizards.utils.WizardsHelper.getSelectedResourceURI;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
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

	@Override
	public boolean isInitModelWizard() {
		return true;
	}
	
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
		URI uri = getSelectedResourceURI(selection);
		isInitFromExistingDomainModel = isSupportedDomainModelResource(uri);
		super.init(workbench, selection);
		selectRootElementPage = createSelectRootElementPage(selection);
		if(isCreateFromExistingDomainModel()) {
			// Init Model not Create a new one
			setWindowTitle(Messages.InitModelWizard_init_papyrus_diagram);
		}
	}

	/**
	 * Creates the select root element page.
	 * 
	 * @param selection
	 *        the initial workbench selection
	 * @return the select root element page
	 */
	protected SelectRootElementPage createSelectRootElementPage(IStructuredSelection selection) {
		if(!isCreateFromExistingDomainModel()) {
			// create model - nothing to choose from
			return null;
		}
		return new SelectRootElementPage(selection);
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
		return file != null
			&& isSupportedDomainModelResource(URI.createPlatformResourceURI(
				file.getFullPath().toString(), true));
	}

	/**
	 * Returns true if the resource can be served as a model model for the diagram.
	 * 
	 * @param uri
	 *        the resource's URI
	 * @return true, if is supported domain model resource
	 */
	public static boolean isSupportedDomainModelResource(URI uri) {
		return (uri != null)
			&& UmlModel.UML_FILE_EXTENSION.equals(uri.fileExtension());
	}

	/**
	 * Checks if is supported domain model file.
	 * 
	 * @param sselection
	 *        the sselection
	 * @return true, if is supported domain model file
	 */
	public static boolean isSupportedDomainModelFile(IStructuredSelection sselection) {
		URI uri = getSelectedResourceURI(sselection);
		return isSupportedDomainModelResource(uri);
	}

	/**
	 * Creates the papyrus models.
	 * 
	 * @param diResourceSet
	 *        the di resource set
	 * @param newURI
	 *        the URI of the new model's principal resource
	 */
	@Override
	protected void createPapyrusModels(ModelSet modelSet, URI newURI) {
		if(isCreateFromExistingDomainModel()) {
			RecordingCommand command = new PapyrusModelFromExistingDomainModelCommand(
				modelSet, newURI, getRoot());
			getCommandStack(modelSet).execute(command);
		} else {
			super.createPapyrusModels(modelSet, newURI);
		}
	}

	/**
	 * Inits the domain model.
	 * 
	 * @param diResourceSet
	 *        the di resource set
	 * @param newURI
	 *        the URI of the new model's principal resource
	 * @param diagramCategoryId
	 *        the diagram category id {@inheritDoc}
	 */
	@Override
	protected void initDomainModel(ModelSet modelSet, final URI newURI, String diagramCategoryId) {
		if(isCreateFromExistingDomainModel()) {
			// do nothing
		} else {
			super.initDomainModel(modelSet, newURI, diagramCategoryId);
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
	public boolean isCreateFromExistingDomainModel() {
		return isInitFromExistingDomainModel;
	}

	@Override
	public String getDiagramFileExtension(String diagramCategoryId) {
		if(isCreateFromExistingDomainModel()) {
			return NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION;
		}
		return super.getDiagramFileExtension(diagramCategoryId);
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
	protected static class NewDiagramForExistingModelPage extends NewModelFilePage {

		/** The my diagram file name. */
		private String myDiagramFileName;

		/**
		 * Instantiates a new new diagram for existing model page.
		 * 
		 * @param selection
		 *            the selection
		 * @param defaultFileName
		 *            the default file name
		 * @param modelKindName
		 *            the user-presentable (translatable) name of the kind of
		 *            model to create
		 * @param diagramExtension
		 *            the diagram extension
		 */
		public NewDiagramForExistingModelPage(IStructuredSelection selection,
				String modelKindName, String defaultFileName,
				String diagramExtension) {
			
			super(selection, modelKindName);
			
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
