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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
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
import org.eclipse.papyrus.core.editor.BackboneException;
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
		DiResourceSet diResourceSet = new DiResourceSet();
		String[] diagramCategoryIds = getDiagramCategoryIds();
		if(diagramCategoryIds.length == 0) {
			return false;
		}
		String diagramCategoryId = diagramCategoryIds[0];

		final IFile newFile = createNewModelFile(diagramCategoryId);
		createAndOpenPapyrusModel(diResourceSet, newFile, diagramCategoryId);

		saveDiagramCategorySettings();
		saveDiagramKindSettings();
		return true;
	}

	protected boolean createAndOpenPapyrusModel(DiResourceSet diResourceSet, IFile newFile, String diagramCategoryId) {
		if(newFile == null) {
			return false;
		}
		createPapyrusModels(diResourceSet, newFile);

		initDomainModel(diResourceSet, newFile, diagramCategoryId);

		initDiagramModel(diResourceSet, diagramCategoryId);

		openDiagram(newFile);

		return true;
	}

	protected String[] getDiagramCategoryIds() {
		if(selectDiagramCategoryPage != null) {
			return selectDiagramCategoryPage.getDiagramCategories();
		}
		return null;
	}

	protected String getDiagramFileExtension(String diagramCategoryId) {
		return getDiagramFileExtension(diagramCategoryId, NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION);
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

			public String[] getCurrentCategories() {
				return getDiagramCategoryIds();
			}

		});
	}

	protected IFile createNewModelFile(String categoryId) {
		return newModelFilePage.createNewFile();
	}

	protected void initDomainModel(DiResourceSet diResourceSet, final IFile newFile, String diagramCategoryId) {
		boolean isToInitFromTemplate = selectDiagramKindPage.getTemplatePath() != null;
		if(isToInitFromTemplate) {
			initDomainModelFromTemplate(diResourceSet);
		} else {
			createEmptyDomainModel(diResourceSet, diagramCategoryId);
		}
	}

	protected void initDomainModelFromTemplate(DiResourceSet diResourceSet) {
		getCommandStack(diResourceSet).execute(new InitFromTemplateCommand(diResourceSet.getTransactionalEditingDomain(), diResourceSet.getModelResource(), selectDiagramKindPage.getTemplatePluginId(), selectDiagramKindPage.getTemplatePath()));
	}

	protected void createEmptyDomainModel(DiResourceSet diResourceSet, String diagramCategoryId) {
		try {
			IModelCreationCommand creationCommand = getDiagramCategoryMap().get(diagramCategoryId).getCommand();
			creationCommand.createModel(diResourceSet);
		} catch (BackboneException e) {
			log.error(e);
		}
	}

	protected void createPapyrusModels(DiResourceSet diResourceSet, IFile newFile) {
		RecordingCommand command = new NewPapyrusModelCommand(diResourceSet, newFile);
		getCommandStack(diResourceSet).execute(command);
	}

	protected void saveDiagramCategorySettings() {
		IDialogSettings settings = getDialogSettings();
		if(settings != null) {
			SettingsHelper settingsHelper = new SettingsHelper(settings);
			settingsHelper.saveDefaultDiagramCategory(getDiagramCategoryIds());
		}
	}

	protected void saveDiagramKindSettings() {
		IDialogSettings settings = getDialogSettings();
		if(settings == null) {
			return;
		}
		SettingsHelper settingsHelper = new SettingsHelper(settings);
		for (String category: getDiagramCategoryIds()) {
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

	private void saveDefaultDiagramKinds(SettingsHelper settingsHelper, String category) {
		String[] selected = selectDiagramKindPage.getSelectedDiagramKinds(category);
		settingsHelper.saveDefaultDiagramKinds(category, Arrays.asList(selected));
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


	protected void initDiagramModel(DiResourceSet diResourceSet, String categoryId) {
		initDiagrams(diResourceSet, categoryId);
		saveDiagram(diResourceSet);
	}

	private void saveDiagram(DiResourceSet diResourceSet) {
		try {
			diResourceSet.save(new NullProgressMonitor());
		} catch (IOException e) {
			log.error(e);
			//			return false;
		}
	}

	protected void initDiagrams(DiResourceSet diResourceSet, String categoryId) {
		initDiagrams(diResourceSet, null, categoryId);
	}

	protected void initDiagrams(DiResourceSet resourceSet, EObject root, String categoryId) {
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

	protected List<ICreationCommand> getDiagramKindsFor(String categoryId) {
		return selectDiagramKindPage.getCreationCommands(categoryId);
	}


	private void createEmptyDiagramEditor(DiResourceSet diResourceSet) {
		// Create an empty editor (no diagrams opened)
		// Geting an IPageMngr is enough to initialize the
		// SashSystem.
		EditorUtils.getTransactionalIPageMngr(diResourceSet.getDiResource(), diResourceSet.getTransactionalEditingDomain());
	}

	protected final CommandStack getCommandStack(DiResourceSet diResourceSet) {
		return diResourceSet.getTransactionalEditingDomain().getCommandStack();
	}

	protected final Map<String, DiagramCategoryDescriptor> getDiagramCategoryMap() {
		return DiagramCategoryRegistry.getInstance().getDiagramCategoryMap();
	}

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

}
