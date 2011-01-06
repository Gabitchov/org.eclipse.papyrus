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

import java.io.IOException;
import java.util.List;

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
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.wizards.category.DiagramCategoryRegistry;
import org.eclipse.papyrus.wizards.category.NewPapyrusModelCommand;
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
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
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

	protected void addPageIfNotNull(IWizardPage page) {
		if(page != null) {
			addPage(page);
		}
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
	 * This method will be invoked, when the "Finish" button is pressed.
	 * 
	 * @return <code>true</code> if everything runs without problems, <code>false</code> if an exception must be caught.
	 * 
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
	
	protected final CommandStack getCommandStack() {
		return diResourceSet.getTransactionalEditingDomain().getCommandStack();	
	}
	
	protected final DiResourceSet getResourseSet() {
		return diResourceSet;
	}

	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection) {
		return new NewModelFilePage(selection);
	}

	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		return new SelectDiagramCategoryPage();
	}

	protected SelectDiagramKindPage createSelectDiagramKindPage() {
		return new SelectDiagramKindPage();
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


	protected void createEmptyDomainModel() {
		try {
			IModelCreationCommand creationCommand = DiagramCategoryRegistry.getInstance().getDiagramCategoryMap().get(getDiagramCategoryId()).getCommand();
			creationCommand.createModel(getResourseSet());
		} catch (BackboneException e) {
			log.error(e);
		}
	}

	protected void createPapyrusModels(IFile newFile) {
		RecordingCommand command = getCreatePapyrusModelCommand(newFile);
		getCommandStack().execute(command);
	}

	protected RecordingCommand getCreatePapyrusModelCommand(final IFile newFile) {
		return new NewPapyrusModelCommand(getResourseSet(), newFile);
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
		if(settings != null) {
			selectDiagramKindPage.saveSettings();
		}
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

	/**
	 * Save diagram.
	 * 
	 */
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
			// Create an empty editor (no diagrams opened)
			// Geting an IPageMngr is enough to initialize the
			// SashSystem.
			EditorUtils.getTransactionalIPageMngr(resourceSet.getDiResource(), resourceSet.getTransactionalEditingDomain());
		}
	}

	protected void initDomainModelFromTemplate() {
		getCommandStack().execute(new InitFromTemplateCommand(getResourseSet(), selectDiagramKindPage.getTemplatePluginId(), selectDiagramKindPage.getTemplatePath()));
	}

	protected String getDiagramCategoryId() {
		if(selectDiagramCategoryPage != null) {
			return selectDiagramCategoryPage.getDiagramCategory();
		}
		return null;
	}

	protected String getDiagramFileExtension() {
		return getDiagramFileExtension(NewModelFilePage.DEFAULT_DIAGRAM_EXTENSION);
	}

	protected String getDiagramFileExtension(String defaultExtension) {
		String сategoryId = getDiagramCategoryId();
		DiagramCategoryDescriptor diagramCategory = DiagramCategoryRegistry.getInstance().getDiagramCategoryMap().get(сategoryId);
		String extensionPrefix = diagramCategory != null ? diagramCategory.getExtensionPrefix() : null;
		return (extensionPrefix != null) ? extensionPrefix + "." + defaultExtension : defaultExtension;
	}

}
