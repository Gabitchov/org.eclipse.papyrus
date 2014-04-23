/*****************************************************************************
 * Copyright (c) 2008, 2014 LIFL, CEA LIST, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - manage models by URI, not IFile (CDO)
 *  Christian W. Damus (CEA) - bug 410346
 *  Christian W. Damus (CEA) - bug 431953 (pre-requisite refactoring of ModelSet service start-up)
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.editor;

import static org.eclipse.papyrus.infra.core.Activator.log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.contentoutline.ContentOutlineRegistry;
import org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.infra.core.lifecycleevents.IEditorInputChangedListener;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.infra.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.infra.core.multidiagram.actionbarcontributor.CoreComposedActionBarContributor;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedListener;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelManager;
import org.eclipse.papyrus.infra.core.sasheditor.editor.AbstractMultiPageSashEditor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sasheditor.editor.gef.MultiDiagramEditorGefDelegate;
import org.eclipse.papyrus.infra.core.services.EditorLifecycleManager;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceStartKind;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.services.internal.EditorLifecycleManagerImpl;
import org.eclipse.papyrus.infra.core.services.internal.InternalEditorLifecycleManager;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Multi diagram editor allowing to plug various kind of editors. Editors are
 * registered with the help of the Eclipse extension mechanism. This
 * implementation allows to register editors and context separately. An editor
 * should specify which context it need to run. This multi diagram editor allows
 * to show editor side by side in one or more sash windows.
 *
 * The real implementation for the generic type T of SashMultiPageEditorPart is
 * actually di2.Diagram
 *
 * @author cedric dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 *         Refactoring.
 *
 *         TODO : remove GMF dependency !
 */
public class CoreMultiDiagramEditor extends AbstractMultiPageSashEditor implements IMultiDiagramEditor, ITabbedPropertySheetPageContributor, IGotoMarker {

	/** Gef adapter */
	private MultiDiagramEditorGefDelegate gefAdaptorDelegate;

	/** ContentOutline registry */
	private ContentOutlineRegistry contentOutlineRegistry;

	/** Services registry. Used to get registered services */
	private ServicesRegistry servicesRegistry;

	/**
	 * ActionBarContributor Registry. Allows to get an ActionBar by its Id. The
	 * registry is initialized from the Eclipse extension mechanism.
	 */
	private ActionBarContributorRegistry actionBarContributorRegistry;

	/** SashModelMngr to add pages */
	protected DiSashModelManager sashModelMngr;

	/**
	 * Service used to maintain the dirty state and to perform save and saveAs.
	 */
	protected ISaveAndDirtyService saveAndDirtyService;

	private final List<IPropertySheetPage> propertiesPages = new LinkedList<IPropertySheetPage>();

	/**
	 * Listener on {@link ISaveAndDirtyService#addInputChangedListener(IEditorInputChangedListener)}
	 */
	private static class EditorInputChangedListener implements IEditorInputChangedListener {

		private CoreMultiDiagramEditor editor;

		public EditorInputChangedListener(CoreMultiDiagramEditor editor) {
			this.editor = editor;
		}

		/**
		 * This method is called when the editor input is changed from the
		 * ISaveAndDirtyService.
		 *
		 * @see org.eclipse.papyrus.infra.core.lifecycleevents.IEditorInputChangedListener#editorInputChanged(org.eclipse.ui.part.FileEditorInput)
		 *
		 * @param fileEditorInput
		 */
		@Override
		public void editorInputChanged(FileEditorInput fileEditorInput) {
			// Change the editor input.
			editor.setInputWithNotify(fileEditorInput);
			editor.setPartName(fileEditorInput.getName());
		}

		/**
		 * The isDirty flag has changed, reflect its new value
		 *
		 * @see org.eclipse.papyrus.infra.core.lifecycleevents.IEditorInputChangedListener#isDirtyChanged()
		 *
		 */
		@Override
		public void isDirtyChanged() {

			// Run it in async way.
			editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					// editor can be null if this object has been finalized, but
					// still queued in the asyncExec queue.
					// This can happen if the editor is disposed, but some run still in
					// the exec queue.
					// When the method is executed asynchronously, the object is already finalized, and so
					// editor is null.
					if(editor == null) {
						return;
					}
					editor.firePropertyChange(IEditorPart.PROP_DIRTY);
				}
			});
		}

		public void dispose() {
			this.editor = null;
		}
	}

	protected EditorInputChangedListener editorInputChangedListener = new EditorInputChangedListener(this);

	private TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * Object managing models lifeCycle.
	 */
	protected ModelSet resourceSet;

	/**
	 * Cached event that can be reused.
	 */
	protected DoSaveEvent lifeCycleEvent;

	private static class EditingDomainProvider implements IEditingDomainProvider {

		private CoreMultiDiagramEditor editor;

		public EditingDomainProvider(CoreMultiDiagramEditor editor) {
			this.editor = editor;
		}

		@Override
		public EditingDomain getEditingDomain() {
			return editor.transactionalEditingDomain;
		}

		public void dispose() {
			this.editor = null;
		}
	}

	/**
	 * My editing domain provider.
	 */
	private EditingDomainProvider domainProvider = new EditingDomainProvider(this);

	private class ContentChangedListener implements IContentChangedListener {

		/**
		 * Called when the content is changed. RefreshTabs.
		 */
		@Override
		public void contentChanged(ContentEvent event) {
			scheduleRefresh();
		}
	}

	/**
	 * A listener on model change events.
	 */
	private ContentChangedListener contentChangedListener = new ContentChangedListener();

	/**
	 * Undo context used to have the same undo context in all Papyrus related
	 * views and editors. TODO : move away, use a version independent of GMF,
	 * add a listener that will add the context to all commands modifying
	 * attached Resources (==> linked to ModelSet ?)
	 */
	private IUndoContext undoContext;

	/**
	 * Get the contentOutlineRegistry. Create it if needed.
	 *
	 * @return the contentOutlineRegistry
	 */
	protected ContentOutlineRegistry getContentOutlineRegistry() {
		if(contentOutlineRegistry == null) {
			createContentOutlineRegistry();
		}

		return contentOutlineRegistry;
	}

	/**
	 * Create the contentOutlineRegistry.
	 */
	private void createContentOutlineRegistry() {
		contentOutlineRegistry = new ContentOutlineRegistry(this, Activator.PLUGIN_ID);
	}

	/**
	 * Returns the service registry associated to the editor.
	 *
	 * @return the servicesRegistry The registry.
	 */
	@Override
	public ServicesRegistry getServicesRegistry() {
		if(servicesRegistry == null) {
			servicesRegistry = createServicesRegistry();
		}
		return servicesRegistry;
	}

	/**
	 * Create the ServicesRegistry.
	 *
	 * @return
	 */
	private ServicesRegistry createServicesRegistry() {
		// Create Services Registry
		try {
			ServicesRegistry servicesRegistry = new ExtensionServicesRegistry(Activator.PLUGIN_ID);
			// servicesRegistry.startRegistry();
			return servicesRegistry;
		} catch (ServiceException e) {
			// Show log and error
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Do nothing as we create the provider before any calls to this method.
	 * Should not be called by subclasses.
	 *
	 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.AbstractMultiPageSashEditor#createPageProvider()
	 */
	@Override
	protected ISashWindowsContentProvider createPageProvider() {
		throw new UnsupportedOperationException("Not implemented. Should not be called as the ContentProvider is already initialized.");
	}

	/**
	 * Create the pageContentProvider.
	 *
	 * Removed since 0.10.0
	 *
	 * @param pageFactory
	 * @param diResource
	 *        Resource used to load/save the SashModel.
	 *
	 *
	 */
	//	protected ISashWindowsContentProvider createPageProvider(IPageModelFactory pageFactory, Resource diResource, TransactionalEditingDomain editingDomain) {
	//
	//		sashModelMngr = new TransactionalDiSashModelMngr(pageFactory, diResource, editingDomain);
	//
	//		ISashWindowsContentProvider pageProvider = sashModelMngr.getISashWindowsContentProvider();
	//
	//		return pageProvider;
	//	}

	/**
	 * Get The {@link IPageMngr} used to add, open, remove or close a diagram in
	 * the SashWindow. This method is available as soon as the {@link CoreMultiDiagramEditor#init(IEditorSite, IEditorInput)} method is
	 * called.
	 *
	 * @return
	 */
	protected IPageManager getIPageManager() throws IllegalStateException {
		try {
			return sashModelMngr.getIPageManager();
		} catch (Exception e) {
			throw new IllegalStateException("Method should be called after CoreMultiDiagramEditor#init(IEditorSite, IEditorInput) is called");
		}
	}

	/**
	 * Get the ActionBarContributorRegistry. Creates it if necessary.
	 *
	 * @return
	 */
	protected ActionBarContributorRegistry getActionBarContributorRegistry() {
		if(actionBarContributorRegistry != null) {
			return actionBarContributorRegistry;
		}

		// Try to got it from CoreComposedActionBarContributor
		// Get it from the contributor.
		IEditorActionBarContributor contributor = getEditorSite().getActionBarContributor();
		if(contributor instanceof CoreComposedActionBarContributor) {
			log.debug(getClass().getSimpleName() + " - ActionBarContributorRegistry loaded from CoreComposedActionBarContributor.");
			return ((CoreComposedActionBarContributor)contributor).getActionBarContributorRegistry();
		} else {
			// Create a registry.
			log.debug(getClass().getSimpleName() + " - create an ActionBarContributorRegistry.");
			return createActionBarContributorRegistry();
		}

	}

	/**
	 * Create the ActionBarContributorRegistry.
	 *
	 * @return
	 */
	private ActionBarContributorRegistry createActionBarContributorRegistry() {
		return new ActionBarContributorRegistry(Activator.PLUGIN_ID);
	}

	/**
	 *
	 *
	 * @param adapter
	 *
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {

		if(ServicesRegistry.class == adapter) {
			return getServicesRegistry();
		}

		if(IPageMngr.class == adapter || IPageManager.class == adapter) {
			return getIPageManager();
		}

		if(IPropertySheetPage.class == adapter) {
			// Do not test if tabbedPropertySheetPage is null before calling new
			// this is managed by Eclipse which only call current method when
			// necessary
			return getPropertySheetPage();
		}

		// Add a viewer
		if(IContentOutlinePage.class == adapter) {
			try {
				ContentOutlineRegistry outlineRegistry = getContentOutlineRegistry();
				if(outlineRegistry == null) {
					return null;
				}
				IContentOutlinePage contentOutline = outlineRegistry.getContentOutline();
				if(contentOutline != null) {
					return contentOutline;
				}
			} catch (BackboneException e) {
				//Ignore: There is not registered outline.
			}
		}

		if(EditingDomain.class == adapter || TransactionalEditingDomain.class == adapter) {
			return transactionalEditingDomain;
		}

		/*
		 * Return context used for undo/redo. All papyrus views should use this
		 * context. The prefer way to get this is to use undoContext =
		 * servicesRegistry.getService(IUndoContext.class);
		 */
		if(IUndoContext.class == adapter) {
			return undoContext;
		}

		// EMF requirements
		if(IEditingDomainProvider.class == adapter) {
			return domainProvider;
		}

		// GEF diagram requirements
		if(adapter == ActionRegistry.class) {
			return gefAdaptorDelegate.getActionRegistry();
		}

		if(adapter == ISelection.class) {
			return getSite().getSelectionProvider().getSelection();
		}

		return super.getAdapter(adapter);
	}

	/**
	 * Init the editor.
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// Init super
		super.init(site, input);

		// Set editor name
		setPartName(input.getName());

		loadModelAndServices();
		loadNestedEditors();
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		//Fire the PostDisplay event asynchronously, to leave time to the Eclipse
		//framework to actually display the contents of the editor
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				//Because we are asynchronous, the editor may already have been disposed
				//(Especially in the case of tests running in the UI Thread)
				if(servicesRegistry == null) {
					return;
				}
				getLifecycleManager().firePostDisplay(CoreMultiDiagramEditor.this);
			}
		});

	}

	protected void loadModelAndServices() throws PartInitException {
		// Create Gef adaptor
		gefAdaptorDelegate = new MultiDiagramEditorGefDelegate();

		// Create ServicesRegistry and register services
		servicesRegistry = createServicesRegistry();

		// Add itself as a service
		servicesRegistry.add(IMultiDiagramEditor.class, 1, this);

		// Create lifeCycle event provider and the event that is used when the editor fire a save event.
		//		lifeCycleEventsProvider = new LifeCycleEventsProvider();
		//		lifeCycleEvent = new DoSaveEvent(servicesRegistry, this);
		//		servicesRegistry.add(ILifeCycleEventsProvider.class, 1, lifeCycleEventsProvider);

		// register services
		servicesRegistry.add(ActionBarContributorRegistry.class, 1, getActionBarContributorRegistry());
		//		servicesRegistry.add(TransactionalEditingDomain.class, 1, transactionalEditingDomain);
		//		servicesRegistry.add(DiResourceSet.class, 1, resourceSet);

		// Create and initalize editor icons service
		//		PageIconsRegistry pageIconsRegistry = new PageIconsRegistry();
		//		PluggableEditorFactoryReader editorReader = new PluggableEditorFactoryReader(Activator.PLUGIN_ID);
		//		editorReader.populate(pageIconsRegistry);
		//		servicesRegistry.add(IPageIconsRegistry.class, 1, pageIconsRegistry);


		// Create PageModelRegistry requested by content provider.
		// Also populate it from extensions.
		//		PageModelFactoryRegistry pageModelRegistry = new PageModelFactoryRegistry();
		//		editorReader.populate(pageModelRegistry, servicesRegistry);

		// TODO : create appropriate Resource for the contentProvider, and pass it here.
		// This will allow to remove the old sash stuff.
		//		setContentProvider(createPageProvider(pageModelRegistry, resourceSet.getDiResource(), transactionalEditingDomain));
		//		servicesRegistry.add(ISashWindowsContentProvider.class, 1, getContentProvider());
		//		servicesRegistry.add(IPageMngr.class, 1, getIPageMngr());

		// register a basic label provider
		// adapter factory used by EMF objects
		AdapterFactory factory = null;
		try {
			EditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(servicesRegistry);
			if(domain instanceof AdapterFactoryEditingDomain) {
				// Use the adapter factory already provided by this editing domain
				factory = ((AdapterFactoryEditingDomain)domain).getAdapterFactory();
			}
		} catch (ServiceException e) {
			// OK, there's no editing domain. That's fine
		}

		if(factory == null) {
			// Must create a new adapter factory
			factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		
		/** label provider for EMF objects */
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(factory) {

			/**
			 * This implements {@link ILabelProvider}.getText by forwarding it
			 * to an object that implements {@link IItemLabelProvider#getText
			 * IItemLabelProvider.getText}
			 */
			@Override
			public String getText(Object object) {
				// Get the adapter from the factory.
				//
				IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(object, IItemLabelProvider.class);
				if(object instanceof EObject) {
					if(((EObject)object).eIsProxy()) {
						return "Proxy - " + object;
					}
				}
				return itemLabelProvider != null ? itemLabelProvider.getText(object) : object == null ? "" : object.toString();
			}
		};
		servicesRegistry.add(ILabelProvider.class, 1, labelProvider);

		EditorLifecycleManager lifecycleManager = new EditorLifecycleManagerImpl();
		servicesRegistry.add(EditorLifecycleManager.class, 1, lifecycleManager, ServiceStartKind.LAZY);

		// Start servicesRegistry
		URI uri;
		IEditorInput input = getEditorInput();
		if(input instanceof IFileEditorInput) {
			uri = URI.createPlatformResourceURI(((IFileEditorInput)input).getFile().getFullPath().toString(), true);
		} else if(input instanceof URIEditorInput) {
			uri = ((URIEditorInput)input).getURI();
		} else {
			uri = URI.createURI(((IURIEditorInput)input).getURI().toString());
		}

		try {
			// Start the ModelSet first, and load if from the specified File.
			// Also start me so that I may be retrieved from the registry by other services
			List<Class<?>> servicesToStart = new ArrayList<Class<?>>(1);
			servicesToStart.add(ModelSet.class);
			servicesToStart.add(IMultiDiagramEditor.class);

			servicesRegistry.startServicesByClassKeys(servicesToStart);

			resourceSet = servicesRegistry.getService(ModelSet.class);
			resourceSet.loadModels(uri);

			// start remaining services
			servicesRegistry.startRegistry();
		} catch (ModelMultiException e) {
			try {
				// with the ModelMultiException it is still possible to open the
				// editors that's why the service registry is still started
				servicesRegistry.startRegistry();
				warnUser(e);
			} catch (ServiceException e1) {
				log.error(e);
				//throw new PartInitException("could not initialize services", e); //$NON-NLS-1$
			}
		} catch (ServiceException e) {
			log.error(e);
			//throw new PartInitException("could not initialize services", e);
		}


		// Get required services

		try {
			transactionalEditingDomain = servicesRegistry.getService(TransactionalEditingDomain.class);
			sashModelMngr = servicesRegistry.getService(DiSashModelManager.class);

			saveAndDirtyService = servicesRegistry.getService(ISaveAndDirtyService.class);
			undoContext = servicesRegistry.getService(IUndoContext.class);
		} catch (ServiceException e) {
			log.error("A required service is missing.", e);
			// if one of the services above fail to start, the editor can't run
			// => stop
			throw new PartInitException("could not initialize services", e);
		}


		// Listen on input changed from the ISaveAndDirtyService
		saveAndDirtyService.addInputChangedListener(editorInputChangedListener);
		getLifecycleManager().firePostInit(this);
	}

	private InternalEditorLifecycleManager getLifecycleManager() {
		//I've been disposed
		if(servicesRegistry == null) {
			return null;
		}
		try {
			return (InternalEditorLifecycleManager)servicesRegistry.getService(EditorLifecycleManager.class);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
		return null;
	}

	protected void loadNestedEditors() throws PartInitException {
		ISashWindowsContentProvider contentProvider = null;
		try {
			contentProvider = servicesRegistry.getService(ISashWindowsContentProvider.class);
		} catch (ServiceException ex) {
			log.error("A required service is missing.", ex);
			// if one of the services above fail to start, the editor can't run
			// => stop
			throw new PartInitException("could not initialize services", ex);
		}

		// Set the content provider providing editors.
		setContentProvider(contentProvider);

		// Listen on contentProvider changes
		sashModelMngr.getSashModelContentChangedProvider().addListener(contentChangedListener);

		IEditorInput input = getEditorInput();

		if(input instanceof IPapyrusPageInput) {
			IPapyrusPageInput papyrusPageInput = (IPapyrusPageInput)input;
			final IPageManager pageManager = getIPageManager();

			if(papyrusPageInput.closeOtherPages()) {
				pageManager.closeAllOpenedPages();
			}

			for(URI pageIdentifierURI : papyrusPageInput.getPages()) {
				final EObject pageIdentifier = resourceSet.getEObject(pageIdentifierURI, true);
				if(!pageManager.allPages().contains(pageIdentifier)) {
					Activator.log.warn("The object " + pageIdentifier + " does not reference an existing page");
					continue;
				}

				if(pageManager.isOpen(pageIdentifier)) {
					pageManager.selectPage(pageIdentifier);
				} else {
					pageManager.openPage(pageIdentifier);
				}
			}
		}
	}

	protected void warnUser(ModelMultiException e) {
		Activator.log.error(e);
		MessageDialog.openError(getSite().getShell(), "Error", String.format("Your model is corrupted, invalid links have been found :\n" + "%s" + "It is recommended to fix it before editing it", e.getMessage()));
	}

	/**
	 * Activate this editor. Called after the SWT.control is created.
	 */
	@Override
	protected void activate() {
		// TODO Auto-generated method stub
		super.activate();
		initFolderTabMenus();

		try {
			// Register ISashWindowsContainer as service
			// Should be done only once the container is ready.
			getServicesRegistry().add(ISashWindowsContainer.class, 1, getISashWindowsContainer());
			getServicesRegistry().startServicesByClassKeys(ISashWindowsContainer.class);
			// Let the IPageMngr use the ISashWindowsContainer to discover current folder
			// This should be done after SashWindowContainer initialization.
			//			DiSashModelManager sashModelManager = getServicesRegistry().getService(DiSashModelManager.class);
			sashModelMngr.setCurrentFolderAndPageMngr(getISashWindowsContainer());

		} catch (ServiceException e) {
			log.error(e);
		}

	}

	/**
	 * Init the contextual menu shown in the folder tabs. This popup menu is
	 * contributed by the help of Eclipse extensions, using the Commands
	 * framework. I.e, to add a menu item, create a menu, a command and an
	 * handler in the extension.
	 */
	protected void initFolderTabMenus() {
		ISashWindowsContainer container = getISashWindowsContainer();

		// TODO : use a constant
		MenuManager menuManager = new MenuManager("tabmenu");
		menuManager.add(new Separator("tabcommands"));
		menuManager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		container.setFolderTabMenuManager(menuManager);

		// TODO : use a constant
		getSite().registerContextMenu("org.eclipse.papyrus.infra.core.editor.ui.tabmenu", menuManager, getSite().getSelectionProvider());

	}

	/**
	 * Overrides getPropertySheetPage.
	 *
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor#getPropertySheetPage()
	 */
	public IPropertySheetPage getPropertySheetPage() {
		IPropertySheetPage propertiesPage = new TabbedPropertySheetPage(this);
		propertiesPages.add(propertiesPage);
		return propertiesPage;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.AbstractMultiPageSashEditor#dispose()
	 *
	 */
	@Override
	public void dispose() {
		getLifecycleManager().fireBeforeClose(this);
		if(sashModelMngr != null) {
			sashModelMngr.getSashModelContentChangedProvider().removeListener(contentChangedListener);
		}

		// Avoid memory leak
		// This call is done from the ServicesRegistry when it is disposed.
		// Don't need to do it there.
		// if(resourceSet != null) {
		// resourceSet.unload();
		// }

		// dispose available service
		if(servicesRegistry != null) {
			try {
				servicesRegistry.disposeRegistry();
				servicesRegistry = null;
			} catch (ServiceMultiException e) {
				log.error(e);
			}
		}

		if(domainProvider != null) {
			this.domainProvider.dispose();
			this.domainProvider = null;
		}

		if(contentChangedListener != null) {
			this.contentChangedListener = null;
		}

		if(editorInputChangedListener != null) {
			this.editorInputChangedListener.dispose();
			this.editorInputChangedListener = null;
		}

		if(gefAdaptorDelegate != null) {
			gefAdaptorDelegate.dispose();
			gefAdaptorDelegate = null;
		}

		contentOutlineRegistry = null;
		transactionalEditingDomain = null;
		resourceSet = null;
		undoContext = null;
		saveAndDirtyService = null;
		sashModelMngr = null;

		for(IPropertySheetPage propertiesPage : this.propertiesPages) {
			propertiesPage.dispose();
		}
		propertiesPages.clear();

		super.dispose();
	}

	/**
	 * Overrides doSave.
	 *
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {

		saveAndDirtyService.doSave(monitor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		//May happen if the editor has not yet been initialized. In this case, the editor cannot be dirty, so we simply return false.
		//Bug 410286: The isDirty() method can also be called /after/ the editor has been disposed. Most likely an Eclipse bug?
		if(saveAndDirtyService == null) {
			return false;
		}
		return saveAndDirtyService.isDirty();
	}

	/**
	 * Overrides doSaveAs.
	 *
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {

		saveAndDirtyService.doSaveAs();
	}

	/**
	 * Overrides isSaveAsAllowed.
	 *
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * Overrides getContributorId.
	 *
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor#getContributorId()
	 */
	@Override
	public String getContributorId() {
		// return Activator.PLUGIN_ID;
		return "TreeOutlinePage";

	}

	// implements IDiagramWorkbenchPart to restore GMF standard behavior
	// and delegate to the activeEditor

	/**
	 * Overrides getDiagram.
	 *
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart#getDiagram()
	 */
	//	public org.eclipse.gmf.runtime.notation.Diagram getDiagram() {
	//		IEditorPart activeEditor = getActiveEditor();
	//		if(activeEditor instanceof DiagramEditor) {
	//			return ((DiagramEditor)activeEditor).getDiagram();
	//		} else {
	//			return null;
	//		}
	//	}

	/**
	 * This method is called from a GMF diagram. It should only be called from GMF diagram code. Normally, the Diagram under the Mouse is a GMF
	 * Diagram. The active Diagram can be another Diagram, not
	 * under the mouse. This is a GMF issue.
	 */
	//	public DiagramEditPart getDiagramEditPart() {
	//
	//		// Get the editor under the mouse
	//		// IEditorPart activeEditor = rootContainer.getEditorUnderMouse();
	//		IEditorPart activeEditor = getActiveEditor();
	//		if(activeEditor == null) {
	//			return null;
	//		}
	//		// IEditorPart activeEditor = getActiveEditor();
	//		if(activeEditor instanceof DiagramEditor) {
	//			return ((DiagramEditor)activeEditor).getDiagramEditPart();
	//		} else {
	//			// This case should never happen.
	//			// Return null, as the GMF runtime now support it (since 093009)
	//			return null;
	//		}
	//	}

	/**
	 * Overrides getDiagramGraphicalViewer.
	 *
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart#getDiagramGraphicalViewer()
	 */
	//	public IDiagramGraphicalViewer getDiagramGraphicalViewer() {
	//		IEditorPart activeEditor = getActiveEditor();
	//		if(activeEditor instanceof DiagramEditor) {
	//			return ((DiagramEditor)activeEditor).getDiagramGraphicalViewer();
	//		} else {
	//			return null;
	//		}
	//	}

	/**
	 * Overrides getEditingDomain.
	 *
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
	 */
	public EditingDomain getEditingDomain() {
		return transactionalEditingDomain;
	}

	/**
	 * Throws an UnsupportedOperationException.
	 *
	 * @see org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor#getDiagramEditDomain()
	 */
	//	public DiagramEditDomain getDiagramEditDomain() {
	//		throw new UnsupportedOperationException("Not implemented. Should not be called.");
	//	}


	/**
	 * Change the editor input.<BR>
	 * <U>Note</U>: that method should be called within the UI-Thread.
	 *
	 * @see org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor#setEditorInput(org.eclipse.ui.IEditorInput)
	 *
	 * @param newInput
	 *        The new input
	 * @deprecated Not used anymore
	 */

	@Override
	@Deprecated
	public void setEditorInput(IEditorInput newInput) {
		setInputWithNotify(newInput);
		setPartName(newInput.getName());
	}

	@Override
	@Deprecated
	public void gotoMarker(IMarker marker) {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
		boolean first = true;
		for(IViewReference view : page.getViewReferences()) {
			// no longer restrict to model explorer (see bug 387578)
			IWorkbenchPart part = view.getPart(false);
			if(part instanceof IGotoMarker) {
				// activate first view implementing the IGotoMarker interface
				if(first) {
					page.activate(view.getPart(false));
					first = false;
				}
				((IGotoMarker)part).gotoMarker(marker);
			}
		}
	}

	private boolean needsRefresh;

	protected void scheduleRefresh() {
		needsRefresh = true;
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				refreshTabs();
			}
		});
	}

	@Override
	protected void refreshTabs() {
		if(!needsRefresh) {
			return;
		}
		needsRefresh = false;
		super.refreshTabs();
	}

	@Override
	public synchronized IEditorPart getActiveEditor() {
		refreshTabs();
		return super.getActiveEditor();
	}
}
