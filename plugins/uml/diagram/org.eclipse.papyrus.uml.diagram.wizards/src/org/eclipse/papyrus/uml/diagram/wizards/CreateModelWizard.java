/*******************************************************************************
 * Copyright (c) 2008 Obeo, CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Tatiana Fesenko(CEA) - [313179] Refactor CreateModelWizard
 *     Saadia Dhouib (CEA LIST) - Implementation of loading diagrams from template files  (.uml, .di , .notation)
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards;

import static org.eclipse.papyrus.uml.diagram.wizards.Activator.log;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryRegistry;
import org.eclipse.papyrus.uml.diagram.wizards.category.NewPapyrusModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage.CategoryProvider;
import org.eclipse.papyrus.uml.diagram.wizards.template.InitFromTemplateCommand;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

/**
 * Create new model file and initialize a selected diagram. This wizard create
 * several files : <li>*.di : the DI file to store Di diagrams and references all external diagrams like GMF diagrams.</li> <li>*.notation : the file
 * to store pure GMF diagrams</li> <li>*.uml : the standard UML file to store UML semantics elements. (Model, Package, Class,...)</li>
 * 
 * Those files can be used with the PapyrusEditor (see plugin.xml).
 */
public class CreateModelWizard extends Wizard implements INewWizard {

	/** The Constant WIZARD_ID. */
	public static final String WIZARD_ID = "org.eclipse.papyrus.uml.diagram.wizards.createmodel"; //$NON-NLS-1$

	/** The Constant NEW_MODEL_SETTINGS. */
	public static final String NEW_MODEL_SETTINGS = "NewModelWizard"; //$NON-NLS-1$

	/** New model file page for the file. */
	private NewModelFilePage newModelFilePage;

	/** Select kind of new diagram the wizard must create. */
	private SelectDiagramKindPage selectDiagramKindPage;

	/** The select diagram category page. */
	private SelectDiagramCategoryPage selectDiagramCategoryPage;

	/** Current workbench. */
	private IWorkbench workbench;

	/**
	 * Instantiates a new creates the model wizard.
	 */
	public CreateModelWizard() {
		super();
		setWindowTitle(Messages.CreateModelWizard_new_papyrus_model_title);
	}


	/**
	 * Adds the pages.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPageIfNotNull(newModelFilePage);
		addPageIfNotNull(selectDiagramCategoryPage);
		addPageIfNotNull(selectDiagramKindPage);
	}

	/**
	 * Adds the page if not null.
	 * 
	 * @param page
	 *        the page
	 */
	protected final void addPageIfNotNull(IWizardPage page) {
		if(page != null) {
			addPage(page);
		}
	}

	/**
	 * Inits the.
	 * 
	 * @param workbench
	 *        the workbench
	 * @param selection
	 *        the selection {@inheritDoc}
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;

		IDialogSettings workbenchSettings = Activator.getDefault().getDialogSettings();
		IDialogSettings section = workbenchSettings.getSection(NEW_MODEL_SETTINGS);
		if(section == null) {
			section = workbenchSettings.addNewSection(NEW_MODEL_SETTINGS);
		}
		setDialogSettings(section);

		newModelFilePage = createNewModelFilePage(selection);
		selectDiagramCategoryPage = createSelectDiagramCategoryPage();
		selectDiagramKindPage = createSelectDiagramKindPage();
	}

	/**
	 * Perform finish.
	 * 
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		ModelSet modelSet = new DiResourceSetExt();
		String[] diagramCategoryIds = getDiagramCategoryIds();
		if(diagramCategoryIds.length == 0) {
			return false;
		}
		String diagramCategoryId = diagramCategoryIds[0];

		final IFile newFile = createNewModelFile(diagramCategoryId);
		createAndOpenPapyrusModel(modelSet, newFile, diagramCategoryId);

		saveDiagramCategorySettings();
		saveDiagramKindSettings();
		return true;
	}

	/**
	 * Creates the and open papyrus model.
	 * 
	 * @param modelSet
	 *        the di resource set
	 * @param newFile
	 *        the new file
	 * @param diagramCategoryId
	 *        the diagram category id
	 * @return true, if successful
	 */
	protected boolean createAndOpenPapyrusModel(ModelSet modelSet, IFile newFile, String diagramCategoryId) {
		if(newFile == null) {
			return false;
		}
		createPapyrusModels(modelSet, newFile);

		initDomainModel(modelSet, newFile, diagramCategoryId);

		initDiagramModel(modelSet, diagramCategoryId);

		openDiagram(newFile);

		return true;
	}

	/**
	 * Gets the diagram category ids.
	 * 
	 * @return the diagram category ids
	 */
	protected String[] getDiagramCategoryIds() {
		if(selectDiagramCategoryPage != null) {
			return selectDiagramCategoryPage.getDiagramCategories();
		}
		return null;
	}

	/**
	 * Gets the diagram file extension.
	 * 
	 * @param diagramCategoryId
	 *        the diagram category id
	 * @return the diagram file extension
	 */
	protected String getDiagramFileExtension(String diagramCategoryId) {
		return getDiagramFileExtension(diagramCategoryId, NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION);
	}

	/**
	 * Gets the diagram file extension.
	 * 
	 * @param categoryId
	 *        the category id
	 * @param defaultExtension
	 *        the default extension
	 * @return the diagram file extension
	 */
	protected String getDiagramFileExtension(String categoryId, String defaultExtension) {
		DiagramCategoryDescriptor diagramCategory = getDiagramCategoryMap().get(categoryId);
		String extensionPrefix = diagramCategory != null ? diagramCategory.getExtensionPrefix() : null;
		return (extensionPrefix != null) ? extensionPrefix + "." + defaultExtension : defaultExtension; //$NON-NLS-1$
	}

	/**
	 * Creates the new model file page.
	 * 
	 * @param selection
	 *        the selection
	 * @return the new model file page
	 */
	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection) {
		return new NewModelFilePage(selection);
	}

	/**
	 * Creates the select diagram category page.
	 * 
	 * @return the select diagram category page
	 */
	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		return new SelectDiagramCategoryPage();
	}

	/**
	 * Creates the select diagram kind page.
	 * 
	 * @return the select diagram kind page
	 */
	protected SelectDiagramKindPage createSelectDiagramKindPage() {
		return new SelectDiagramKindPage(new CategoryProvider() {

			public String[] getCurrentCategories() {
				return getDiagramCategoryIds();
			}

		});
	}

	/**
	 * Creates the new model file.
	 * 
	 * @param categoryId
	 *        the category id
	 * @return the i file
	 */
	protected IFile createNewModelFile(String categoryId) {
		return newModelFilePage.createNewFile();
	}

	/**
	 * Inits the domain model.
	 * 
	 * @param modelSet
	 *        the di resource set
	 * @param newFile
	 *        the new file
	 * @param diagramCategoryId
	 *        the diagram category id
	 */
	protected void initDomainModel(ModelSet modelSet, final IFile newFile, String diagramCategoryId) {
		boolean isToInitFromTemplate = selectDiagramKindPage.getTemplatePath() != null;
		if(isToInitFromTemplate) {
			initDomainModelFromTemplate(modelSet);
		} else {
			createEmptyDomainModel(modelSet, diagramCategoryId);
		}
	}

	/**
	 * Inits the domain model from template.
	 * 
	 * @param modelSet
	 *        the di resource set
	 */
	protected void initDomainModelFromTemplate(ModelSet modelSet) {
		//getCommandStack(modelSet).execute(new InitFromTemplateCommand(modelSet.getTransactionalEditingDomain(), modelSet.getModelResource(), modelSet.getDiResource(), modelSet.getNotationResource(), selectDiagramKindPage.getTemplatePluginId(), selectDiagramKindPage.getTemplatePath(),selectDiagramKindPage.getNotationTemplatePath(),selectDiagramKindPage.getDiTemplatePath()));
		getCommandStack(modelSet).execute(new InitFromTemplateCommand(modelSet.getTransactionalEditingDomain(), modelSet, selectDiagramKindPage.getTemplatePluginId(), selectDiagramKindPage.getTemplatePath(), selectDiagramKindPage.getNotationTemplatePath(), selectDiagramKindPage.getDiTemplatePath()));
	}

	/**
	 * Creates the empty domain model.
	 * 
	 * @param modelSet
	 *        the di resource set
	 * @param diagramCategoryId
	 *        the diagram category id
	 */
	protected void createEmptyDomainModel(ModelSet modelSet, String diagramCategoryId) {
		try {
			IModelCreationCommand creationCommand = getDiagramCategoryMap().get(diagramCategoryId).getCommand();
			creationCommand.createModel(modelSet);
		} catch (BackboneException e) {
			log.error(e);
		}
	}

	/**
	 * Creates the papyrus models.
	 * 
	 * @param modelSet
	 *        the di resource set
	 * @param newFile
	 *        the new file
	 */
	protected void createPapyrusModels(ModelSet modelSet, IFile newFile) {
		RecordingCommand command = new NewPapyrusModelCommand(modelSet, newFile);
		getCommandStack(modelSet).execute(command);
	}

	/**
	 * Save diagram category settings.
	 */
	protected void saveDiagramCategorySettings() {
		IDialogSettings settings = getDialogSettings();
		if(settings != null) {
			SettingsHelper settingsHelper = new SettingsHelper(settings);
			settingsHelper.saveDefaultDiagramCategory(getDiagramCategoryIds());
		}
	}

	/**
	 * Save diagram kind settings.
	 */
	protected void saveDiagramKindSettings() {
		IDialogSettings settings = getDialogSettings();
		if(settings == null) {
			return;
		}
		SettingsHelper settingsHelper = new SettingsHelper(settings);
		for(String category : getDiagramCategoryIds()) {
			if(selectDiagramKindPage.isRememberCurrentSelection()) {
				saveDefaultDiagramKinds(settingsHelper, category);
				saveDefaultTemplates(settingsHelper, category);
			} else {
				settingsHelper.saveDefaultDiagramKinds(category, Collections.<String> emptyList());
				settingsHelper.saveDefaultTemplates(category, Collections.<String> emptyList());
			}
		}
		settingsHelper.saveRememberCurrentSelection(selectDiagramKindPage.isRememberCurrentSelection());
	}

	/**
	 * Save default diagram kinds.
	 * 
	 * @param settingsHelper
	 *        the settings helper
	 * @param category
	 *        the category
	 */
	private void saveDefaultDiagramKinds(SettingsHelper settingsHelper, String category) {
		String[] selected = selectDiagramKindPage.getSelectedDiagramKinds(category);
		settingsHelper.saveDefaultDiagramKinds(category, Arrays.asList(selected));
	}

	/**
	 * Save default templates.
	 * 
	 * @param settingsHelper
	 *        the settings helper
	 * @param category
	 *        the category
	 */
	private void saveDefaultTemplates(SettingsHelper settingsHelper, String category) {
		if(!selectDiagramKindPage.templatesEnabled()) {
			return;
		}
		String path = selectDiagramKindPage.getTemplatePath();
		settingsHelper.saveDefaultTemplates(category, Collections.singletonList(path));
	}

	/**
	 * Open diagram.
	 * 
	 * @param newFile
	 *        the new file
	 */
	protected void openDiagram(final IFile newFile) {
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
		if(page != null) {
			try {
				IDE.openEditor(page, newFile, true);
			} catch (PartInitException e) {
				log.error(e);
			}
		}
	}


	/**
	 * Inits the diagram model.
	 * 
	 * @param modelSet
	 *        the di resource set
	 * @param categoryId
	 *        the category id
	 */
	protected void initDiagramModel(ModelSet modelSet, String categoryId) {
		initDiagrams(modelSet, categoryId);
		saveDiagram(modelSet);
	}

	/**
	 * Save diagram.
	 * 
	 * @param modelSet
	 *        the di resource set
	 */
	private void saveDiagram(ModelSet modelSet) {
		try {
			modelSet.save(new NullProgressMonitor());
		} catch (IOException e) {
			log.error(e);
			//			return false;
		}
	}

	/**
	 * Inits the diagrams.
	 * 
	 * @param modelSet
	 *        the di resource set
	 * @param categoryId
	 *        the category id
	 */
	protected void initDiagrams(ModelSet modelSet, String categoryId) {
		initDiagrams(modelSet, null, categoryId);
	}

	/**
	 * Inits the diagrams.
	 * 
	 * @param resourceSet
	 *        the resource set
	 * @param root
	 *        the root
	 * @param categoryId
	 *        the category id
	 */
	protected void initDiagrams(ModelSet resourceSet, EObject root, String categoryId) {
		List<ICreationCommand> creationCommands = getDiagramKindsFor(categoryId);
		String diagramName = selectDiagramKindPage.getDiagramName();
		if(creationCommands.isEmpty()) {
			createEmptyDiagramEditor(resourceSet);
		} else {
			for(int i = 0; i < creationCommands.size(); i++) {
				creationCommands.get(i).createDiagram(resourceSet, root, diagramName);
			}
		}
	}

	/**
	 * Gets the diagram kinds for.
	 * 
	 * @param categoryId
	 *        the category id
	 * @return the diagram kinds for
	 */
	protected List<ICreationCommand> getDiagramKindsFor(String categoryId) {
		return selectDiagramKindPage.getCreationCommands(categoryId);
	}


	/**
	 * Creates the empty diagram editor.
	 * 
	 * @param modelSet
	 *        the model set
	 */
	private void createEmptyDiagramEditor(ModelSet modelSet) {
		// Create an empty editor (no diagrams opened)
		// Geting an IPageMngr is enough to initialize the
		// SashSystem.
		EditorUtils.getTransactionalIPageMngr(DiModelUtils.getDiResource(modelSet), modelSet.getTransactionalEditingDomain());
	}

	/**
	 * Gets the command stack.
	 * 
	 * @param modelSet
	 *        the model set
	 * @return the command stack
	 */
	protected final CommandStack getCommandStack(ModelSet modelSet) {
		return modelSet.getTransactionalEditingDomain().getCommandStack();
	}

	/**
	 * Gets the diagram category map.
	 * 
	 * @return the diagram category map
	 */
	protected Map<String, DiagramCategoryDescriptor> getDiagramCategoryMap() {
		return DiagramCategoryRegistry.getInstance().getDiagramCategoryMap();
	}

	/**
	 * Diagram category changed.
	 * 
	 * @param newCategories
	 *        the new categories
	 * @return the i status
	 */
	public IStatus diagramCategoryChanged(String... newCategories) {
		if(newModelFilePage != null) {
			String firstCategory = newCategories.length > 0 ? newCategories[0] : null;
			if(newCategories.length > 0) {
				//316943 -  [Wizard] Wrong suffix for file name when creating a profile model
				return newModelFilePage.diagramExtensionChanged(getDiagramFileExtension(firstCategory));
			}
		}
		return Status.OK_STATUS;
	}

	// Bug 339504 - [Wizard] NPE when init diagram from an existing model
	/**
	 * The Class DiResourceSetExt.
	 */
	public static class DiResourceSetExt extends DiResourceSet {

		// open access to protected method to be set in PapyrusModelFromExistingDomainModelCommand
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.papyrus.resource.ModelSet#setFilenameWithoutExtension(org.eclipse.core.runtime.IPath)
		 */
		@Override
		public void setFilenameWithoutExtension(IPath filenameWithoutExtension) {
			super.setFilenameWithoutExtension(filenameWithoutExtension);
		}
	}

}
