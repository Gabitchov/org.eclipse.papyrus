/*******************************************************************************
 * Copyright (c) 2008, 2013 Obeo, CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Tatiana Fesenko(CEA) - [313179] Refactor CreateModelWizard
 *     Saadia Dhouib (CEA LIST) - Implementation of loading diagrams from template files  (.uml, .di , .notation)
 *     Christian W. Damus (CEA) - create models by URI, not IFile (CDO)
 *     Christian W. Damus (CEA) - Support creating models in repositories (CDO)
 *     
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards;

import static org.eclipse.papyrus.uml.diagram.wizards.Activator.log;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryRegistry;
import org.eclipse.papyrus.uml.diagram.wizards.category.NewPapyrusModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage.CategoryProvider;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectStorageProviderPage;
import org.eclipse.papyrus.uml.diagram.wizards.template.InitFromTemplateCommand;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.services.IEvaluationService;

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

	private SelectStorageProviderPage selectStorageProviderPage;
	
	/** Select kind of new diagram the wizard must create. */
	private SelectDiagramKindPage selectDiagramKindPage;

	/** The select diagram category page. */
	private SelectDiagramCategoryPage selectDiagramCategoryPage;

	/** Current workbench. */
	private IWorkbench workbench;

	private NewModelStorageProviderRegistry storageProviderRegistry;
	private INewModelStorageProvider selectedStorageProvider;
	
	private Map<INewModelStorageProvider, List<IWizardPage>> providerPages = new java.util.HashMap<INewModelStorageProvider, List<IWizardPage>>();
	private Map<IWizardPage, INewModelStorageProvider> providersByPage = new java.util.HashMap<IWizardPage, INewModelStorageProvider>();
	private int startProviderPageIndex; // index of last page before provider pages
	private int endProviderPageIndex; // index of first page after provider pages
	
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
		addPageIfNotNull(selectStorageProviderPage);
		
		startProviderPageIndex = getPageCount() - 1;
		for (INewModelStorageProvider next : getStorageProviders()) {
			List<IWizardPage> pageList = new java.util.ArrayList<IWizardPage>(3);
			for (IWizardPage page : next.createPages()) {
				if (page != null)  {
					pageList.add(page);
					providersByPage.put(page, next);
					addPage(page);
				}
			}
			providerPages.put(next, pageList);
		}
		endProviderPageIndex = getPageCount();
		
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

	public boolean isInitModelWizard() {
		return false;
	}
	
	public boolean isCreateProjectWizard() {
		return false;
	}
	
	public boolean isCreateMultipleModelsWizard() {
		return false;
	}
	
	/**
	 * Inits the.
	 * 
	 * @param workbench
	 *            the workbench
	 * @param selection
	 *            the selection {@inheritDoc}
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;

		initStorageProvider(workbench, selection);
		
		IDialogSettings workbenchSettings = Activator.getDefault()
			.getDialogSettings();
		IDialogSettings section = workbenchSettings
			.getSection(NEW_MODEL_SETTINGS);
		if (section == null) {
			section = workbenchSettings.addNewSection(NEW_MODEL_SETTINGS);
		}
		setDialogSettings(section);

		selectStorageProviderPage = createSelectStorageProviderPage();
		
		for (INewModelStorageProvider next : getStorageProviders()) {
			next.init(this, selection);
		}
		
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
		String[] diagramCategoryIds = getDiagramCategoryIds();
		if (diagramCategoryIds.length == 0) {
			return false;
		}
		String diagramCategoryId = diagramCategoryIds[0];
		final URI newURI = createNewModelURI(diagramCategoryId);

		createAndOpenPapyrusModel(newURI, diagramCategoryId);

		saveDiagramCategorySettings();
		saveDiagramKindSettings();

		return true;
	}

	protected URI createNewModelURI(String diagramCategoryID) {
		return getSelectedStorageProvider().createNewModelURI(diagramCategoryID);
	}
	
	/**
	 * Creates the and open papyrus model.
	 * 
	 * @param modelSet
	 *            the di resource set
	 * @param newURI
	 *            the URI of the new model's principal resource
	 * @param diagramCategoryId
	 *            the diagram category id
	 * @return true, if successful
	 */
	protected boolean createAndOpenPapyrusModel(URI newURI, String diagramCategoryId) {
		
		if (newURI == null) {
			return false;
		}
		
		ServicesRegistry registry = createServicesRegistry();
		if (registry == null) {
			return false;
		}

		try {
			// have to create the model set and populate it with the DI model
			// before initializing other services that actually need the DI
			// model, such as the SashModel Manager service
			ModelSet modelSet = registry.getService(ModelSet.class);
			
			createPapyrusModels(modelSet, newURI);
	
			initServicesRegistry(registry);
			
			initDomainModel(modelSet, newURI, diagramCategoryId);
	
			initDiagramModel(modelSet, diagramCategoryId);
	
			openDiagram(newURI);
		} catch (ServiceException e) {
			Activator.log.error(e);
			return false;
		} finally {
			try {
				registry.disposeRegistry();
			} catch (ServiceException ex) {
				// Ignore
			}
		}
		
		return true;
	}

	protected ServicesRegistry createServicesRegistry() {
		ServicesRegistry result = null;
		
		try {
			result = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
		} catch (ServiceException e) {
			// couldn't create the registry? Fatal problem
			Activator.log.error(e);
		}
		
		try {
			// have to create the model set and populate it with the DI model
			// before initializing other services that actually need the DI
			// model, such as the SashModel Manager service
			result.startServicesByClassKeys(ModelSet.class);
		} catch (ServiceException ex) {
			// Ignore this exception: some services may not have been loaded,
			// which is probably normal at this point
		}
		
		return result;
	}
	
	protected void initServicesRegistry(ServicesRegistry registry)
			throws ServiceException {
		try {
			registry.startRegistry();
		} catch (ServiceException ex) {
			// Ignore this exception: some services may not have been loaded,
			// which is probably normal at this point
		}

		registry.getService(IPageManager.class);
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
	public String getDiagramFileExtension(String diagramCategoryId) {
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
	public String getDiagramFileExtension(String categoryId, String defaultExtension) {
		DiagramCategoryDescriptor diagramCategory = getDiagramCategoryMap().get(categoryId);
		String extensionPrefix = diagramCategory != null ? diagramCategory.getExtensionPrefix() : null;
		return (extensionPrefix != null) ? extensionPrefix + "." + defaultExtension : defaultExtension; //$NON-NLS-1$
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
	 * Inits the domain model.
	 * 
	 * @param modelSet
	 *            the di resource set
	 * @param newURI
	 *            the URI of the new model's principal resource
	 * @param diagramCategoryId
	 *            the diagram category id
	 */
	protected void initDomainModel(ModelSet modelSet, final URI newURI,
			String diagramCategoryId) {
		
		boolean isToInitFromTemplate = selectDiagramKindPage.getTemplatePath() != null;
		if (isToInitFromTemplate) {
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
	 *            the di resource set
	 * @param newURI
	 *            the URI of the new model's principal resource
	 */
	protected void createPapyrusModels(ModelSet modelSet, URI newURI) {
		RecordingCommand command = new NewPapyrusModelCommand(modelSet, newURI);
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
	 * @param newURI
	 *            the URI of the new model's principal resource
	 */
	protected void openDiagram(final URI newURI) {
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
			.getActivePage();
		if (page != null) {
			try {
				IEditorInput editorInput = createEditorInput(newURI);
				IDE.openEditor(page, editorInput,
					getPreferredEditorID(editorInput), true);
			} catch (PartInitException e) {
				log.error(e);
			}
		}
	}

	protected IEditorInput createEditorInput(URI uri) {
		return getSelectedStorageProvider().createEditorInput(uri);
	}

	protected String getPreferredEditorID(IEditorInput input)
			throws PartInitException {
		IEditorDescriptor desc;

		if (input instanceof IFileEditorInput) {
			desc = IDE
				.getEditorDescriptor(((IFileEditorInput) input).getFile());
		} else {
			// try to get a URI
			URI uri = null;
			if (input instanceof IURIEditorInput) {
				uri = URI.createURI(((IURIEditorInput) input).getURI()
					.toString(), true);
			} else if (input instanceof URIEditorInput) {
				uri = ((URIEditorInput) input).getURI();
			}

			if (uri != null) {
				desc = IDE.getEditorDescriptor(uri.lastSegment());
			} else {
				// hope that the input name is the file name
				desc = IDE.getEditorDescriptor(input.getName());
			}
		}

		return (desc == null)
			? "org.eclipse.papyrus.infra.core.papyrusEditor"
			: desc.getId();
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
		return getSelectedStorageProvider().validateDiagramCategories(
			newCategories);
	}
	
	protected void initStorageProvider(IWorkbench workbench,
			IStructuredSelection selection) {
		
		NewModelStorageProviderRegistry registry = new NewModelStorageProviderRegistry(
			(IEvaluationService) workbench.getService(IEvaluationService.class));
		
		// if we are creating a project, then it is in the workspace
		if (isCreateProjectWizard()) {
			this.selectedStorageProvider = new WorkspaceNewModelStorageProvider();
		} else {
			// look for a pre-determined selection
			INewModelStorageProvider firstProvider = null;
			for (INewModelStorageProvider next : registry) {
				if (firstProvider == null) {
					firstProvider = next;
				}

				// don't match on empty selections because there is
				// then no context to match against
				if (!selection.isEmpty() && next.canHandle(selection)) {
					this.selectedStorageProvider = next;
					break;
				}
			}

			// if the choice is pre-determined, don't show the selection page
			if (this.selectedStorageProvider == null) {
				this.selectedStorageProvider = firstProvider;

				// don't need the selection page if only one choice
				if (registry.size() > 1) {
					this.storageProviderRegistry = registry;
				}
			}
		}
	}
	
	protected SelectStorageProviderPage createSelectStorageProviderPage() {
		SelectStorageProviderPage result = (storageProviderRegistry == null)
			? null
			: new SelectStorageProviderPage(storageProviderRegistry);
		
		if (result != null) {
			result.addSelectionChangedListener(new ISelectionChangedListener() {
				
				public void selectionChanged(SelectionChangedEvent event) {
					INewModelStorageProvider provider = (INewModelStorageProvider) ((IStructuredSelection) event
						.getSelection()).getFirstElement();
					setSelectedStorageProvider(provider);
				}
			});
		}
		
		return result;
	}
	
	protected Iterable<? extends INewModelStorageProvider> getStorageProviders() {
		Iterable<? extends INewModelStorageProvider> result;
		
		if (storageProviderRegistry != null) {
			result = storageProviderRegistry;
		} else if (selectedStorageProvider != null) {
			result = Collections.singletonList(selectedStorageProvider);
		} else {
			result = Collections.emptyList();
		}
		
		return result;
	}
	
	protected INewModelStorageProvider getSelectedStorageProvider() {
		return selectedStorageProvider;
	}
	
	private void setSelectedStorageProvider(INewModelStorageProvider provider) {
		this.selectedStorageProvider = provider;
		
		// recompute next/previous buttons
		getContainer().updateButtons();
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		final List<IWizardPage> allPages = Arrays.asList(getPages());
		IWizardPage result = null;

		INewModelStorageProvider provider = providersByPage.get(page);
		if (provider != null) {
			// it's contributed by a provider. Get the next in the list
			List<IWizardPage> pages = providerPages.get(provider);
			int index = pages.indexOf(page);
			if ((index >= 0) && (index < (pages.size() - 1))) {
				result = pages.get(index + 1);
			} else {
				// get the first page after the provider pages
				if (endProviderPageIndex < allPages.size()) {
					result = allPages.get(endProviderPageIndex);
				}
			}
		} else if (allPages.indexOf(page) == startProviderPageIndex) {
			// get the first page of the selected provider
			List<IWizardPage> pages = providerPages.get(getSelectedStorageProvider());
			if (!pages.isEmpty()) {
				result = pages.get(0);
			} else {
				// get the first page after the provider pages
				if (endProviderPageIndex < allPages.size()) {
					result = allPages.get(endProviderPageIndex);
				}
			}
		} else {
			// somewhere away from the boundary of the provider pages
			result = super.getNextPage(page);
		}
		
		return result;
	}
	
	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		final List<IWizardPage> allPages = Arrays.asList(getPages());
		IWizardPage result = null;

		INewModelStorageProvider provider = providersByPage.get(page);
		if (provider != null) {
			// it's contributed by a provider. Get the previous in the list
			List<IWizardPage> pages = providerPages.get(provider);
			int index = pages.indexOf(page);
			if (index > 0) {
				result = pages.get(index - 1);
			} else {
				// get the last page before the provider pages
				if (startProviderPageIndex >= 0) {
					result = allPages.get(startProviderPageIndex);
				}
			}
		} else if (allPages.indexOf(page) == endProviderPageIndex) {
			// get the last page of the selected provider
			List<IWizardPage> pages = providerPages.get(getSelectedStorageProvider());
			if (!pages.isEmpty()) {
				result = pages.get(pages.size() - 1);
			} else {
				// get the last page before the provider pages
				if (startProviderPageIndex >= 0) {
					result = allPages.get(startProviderPageIndex);
				}
			}
		} else {
			// somewhere away from the boundary of the provider pages
			result = super.getPreviousPage(page);
		}
		
		return result;
	}
	
	@Override
	public boolean canFinish() {
		boolean result = true;
		final IWizardPage[] allPages = getPages();

		// only look at the universal pages and those contributed by the current
		// storage provider

		for (int i = 0; result && (i <= startProviderPageIndex); i++) {
			result = allPages[i].isPageComplete();
		}
		
		if (result) {
			for (IWizardPage next : providerPages.get(selectedStorageProvider)) {
				if (!next.isPageComplete()) {
					result = false;
					break;
				}
			}
		}
		
		for (int i = endProviderPageIndex; result && (i < allPages.length); i++) {
			result = allPages[i].isPageComplete();
		}

		return result;
	}

	/**
	 * Queries the user-presentable (translatable) name of the kind of model
	 * that I create. For example, "Papyrus UML" or "Papyrus SysML".
	 * 
	 * @return my model kind name
	 */
	public String getModelKindName() {
		return "Papyrus";
	}

}
