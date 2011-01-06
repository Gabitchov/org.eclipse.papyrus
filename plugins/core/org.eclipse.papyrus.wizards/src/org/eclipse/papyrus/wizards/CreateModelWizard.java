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
 *******************************************************************************/
package org.eclipse.papyrus.wizards;

import static org.eclipse.papyrus.wizards.Activator.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.wizards.category.DiagramCategoryRegistry;
import org.eclipse.papyrus.wizards.category.NewPapyrusModelCommand;
import org.eclipse.papyrus.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramKindPage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramKindPage.CategoryProvider;
import org.eclipse.papyrus.wizards.template.InitFromTemplateCommand;
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
 */
public class CreateModelWizard extends Wizard implements INewWizard {

	/** The Constant WIZARD_ID. */
	public static final String WIZARD_ID = "org.eclipse.papyrus.wizards.createmodel";

	/** The Constant NEW_MODEL_SETTINGS. */
	public static final String NEW_MODEL_SETTINGS = "NewModelWizard";

	/** New model file page for the file */
	private NewModelFilePage newModelFilePage;

	/** Select kind of new diagram the wizard must create */
	private SelectDiagramKindPage selectDiagramKindPage;

	/** The select diagram category page. */
	private SelectDiagramCategoryPage selectDiagramCategoryPage;

	/** Current workbench */
	private IWorkbench workbench;

	private DiResourceSet diResourceSet;

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
		addPageIfNotNull(newModelFilePage);
		addPageIfNotNull(selectDiagramCategoryPage);
		addPageIfNotNull(selectDiagramKindPage);
	}

	protected final void addPageIfNotNull(IWizardPage page) {
		if(page != null) {
			addPage(page);
		}
	}

	/**
	 * {@inheritDoc}
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
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		diResourceSet = new DiResourceSet();
		final IFile newFile = createNewModelFile();
		if(newFile == null) {
			return false;
		}
		createPapyrusModels(newFile);

		initDomainModel(newFile);

		initDiagramModel();

		openDiagram(newFile);

		saveDiagramCategorySettings();
		saveDiagramKindSettings();
		return true;
	}


	protected String getDiagramCategoryId() {
		if(selectDiagramCategoryPage != null) {
			return selectDiagramCategoryPage.getDiagramCategory();
		}
		return null;
	}

	public String getDiagramFileExtension() {
		return getDiagramFileExtension(getDiagramCategoryId(), NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION);
	}

	protected String getDiagramFileExtension(String categoryId, String defaultExtension) {
		DiagramCategoryDescriptor diagramCategory = getDiagramCategoryMap().get(categoryId);
		String extensionPrefix = diagramCategory != null ? diagramCategory.getExtensionPrefix() : null;
		return (extensionPrefix != null) ? extensionPrefix + "." + defaultExtension : defaultExtension;
	}

	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection) {
		return new NewModelFilePage(selection);
	}

	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		return new SelectDiagramCategoryPage();
	}

	protected SelectDiagramKindPage createSelectDiagramKindPage() {
		return new SelectDiagramKindPage(new CategoryProvider() {

			public String getCurrentCategory() {
				return getDiagramCategoryId();
			}
			
		});
	}

	protected IFile createNewModelFile() {
		return newModelFilePage.createNewFile();
	}

	protected void initDomainModel(final IFile newFile) {
		boolean isToInitFromTemplate = selectDiagramKindPage.getTemplatePath() != null;
		if(isToInitFromTemplate) {
			initDomainModelFromTemplate();
		} else {
			createEmptyDomainModel();
		}
	}

	protected void initDomainModelFromTemplate() {
		getCommandStack().execute(new InitFromTemplateCommand(getResourseSet().getTransactionalEditingDomain(), getResourseSet().getModelResource(), selectDiagramKindPage.getTemplatePluginId(), selectDiagramKindPage.getTemplatePath()));
	}

	protected void createEmptyDomainModel() {
		try {
			IModelCreationCommand creationCommand = getDiagramCategoryMap().get(getDiagramCategoryId()).getCommand();
			creationCommand.createModel(getResourseSet());
		} catch (BackboneException e) {
			log.error(e);
		}
	}

	protected void createPapyrusModels(IFile newFile) {
		RecordingCommand command = new NewPapyrusModelCommand(getResourseSet(), newFile);
		getCommandStack().execute(command);
	}

	protected void saveDiagramCategorySettings() {
		IDialogSettings settings = getDialogSettings();
		if(settings != null) {
			SettingsHelper settingsHelper = new SettingsHelper(settings);
			settingsHelper.saveDefaultDiagramCategory(getDiagramCategoryId());
		}
	}

	protected void saveDiagramKindSettings() {
		IDialogSettings settings = getDialogSettings();
		if(settings == null) {
			return;
		}
		SettingsHelper settingsHelper = new SettingsHelper(settings);
		String category = getDiagramCategoryId();
		if(selectDiagramKindPage.isRememberCurrentSelection()) {
			saveDefaultDiagramKinds(settingsHelper, category);
			saveDefaultTemplates(settingsHelper, category);
		} else {
			settingsHelper.saveDefaultDiagramKinds(category, Collections.<String> emptyList());
			settingsHelper.saveDefaultTemplates(category, Collections.<String> emptyList());
		}
		settingsHelper.saveRememberCurrentSelection(selectDiagramKindPage.isRememberCurrentSelection());
	}
	
	private void saveDefaultDiagramKinds(SettingsHelper settingsHelper, String category) {
		List<String> kinds = new ArrayList<String>();
		for(CreationCommandDescriptor selected : selectDiagramKindPage.getSelectedDiagramKinds()) {
			kinds.add(selected.getCommandId());
		}
		settingsHelper.saveDefaultDiagramKinds(category, kinds);
	}

	private void saveDefaultTemplates(SettingsHelper settingsHelper, String category) {
		if(!selectDiagramKindPage.templatesEnabled()) {
			return;
		}
		String path = selectDiagramKindPage.getTemplatePath();
		settingsHelper.saveDefaultTemplates(category, Collections.singletonList(path));
	}



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


	protected void initDiagramModel() {
		initDiagrams();
		saveDiagram();
	}

	private void saveDiagram() {
		try {
			getResourseSet().save(new NullProgressMonitor());
		} catch (IOException e) {
			log.error(e);
			//			return false;
		}
	}

	protected void initDiagrams() {
		initDiagrams(null);
	}

	protected void initDiagrams(EObject root) {
		String diagramName = selectDiagramKindPage.getDiagramName();
		List<ICreationCommand> creationCommands = selectDiagramKindPage.getCreationCommands();
		DiResourceSet resourceSet = getResourseSet();
		if(!creationCommands.isEmpty()) {
			for(int i = 0; i < creationCommands.size(); i++) {
				creationCommands.get(i).createDiagram(resourceSet, root, diagramName);
			}
		} else {
			createEmptyDiagramEditor();
		}
	}
	
	private void createEmptyDiagramEditor() {
		// Create an empty editor (no diagrams opened)
		// Geting an IPageMngr is enough to initialize the
		// SashSystem.
		EditorUtils.getTransactionalIPageMngr(getResourseSet().getDiResource(), getResourseSet().getTransactionalEditingDomain());
	}

	protected final DiResourceSet getResourseSet() {
		return diResourceSet;
	}

	protected final CommandStack getCommandStack() {
		return getResourseSet().getTransactionalEditingDomain().getCommandStack();
	}
	
	protected final Map<String, DiagramCategoryDescriptor> getDiagramCategoryMap() {
		return DiagramCategoryRegistry.getInstance().getDiagramCategoryMap();
	}
	
}
