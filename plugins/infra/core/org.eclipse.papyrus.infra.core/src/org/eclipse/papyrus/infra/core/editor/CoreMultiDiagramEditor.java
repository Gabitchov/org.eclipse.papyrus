/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.editor;

import static org.eclipse.papyrus.infra.core.Activator.log;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
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
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.TransactionalDiSashModelMngr;
import org.eclipse.papyrus.infra.core.sasheditor.editor.AbstractMultiPageSashEditor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sasheditor.editor.gef.MultiDiagramEditorGefDelegate;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.BusinessModelResolver;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
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
 * Multi diagram editor allowing to plug various kind of editors. Editors are registered with the help of the Eclipse extension mechanism. This
 * implementation allows to register editors and context
 * separately. An editor should specify which context it need to run. This multi diagram editor allows to show editor side by side in one or more sash
 * windows.
 * 
 * The real implementation for the generic type T of SashMultiPageEditorPart is actually di2.Diagram
 * 
 * @author cedric dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a> Refactoring.
 * 
 *         TODO : remove GMF dependency !
 */
public class CoreMultiDiagramEditor extends AbstractMultiPageSashEditor implements IMultiDiagramEditor, ITabbedPropertySheetPageContributor, IDiagramWorkbenchPart, IGotoMarker {

	/** Gef adapter */
	private MultiDiagramEditorGefDelegate gefAdaptorDelegate;

	/** ContentOutline registry */
	private ContentOutlineRegistry contentOutlineRegistry;

	/** Services registry. Used to get registered services */
	private ServicesRegistry servicesRegistry;

	/**
	 * ActionBarContributor Registry. Allows to get an ActionBar by its Id. The registry is initialized from the Eclipse extension mechanism.
	 */
	private ActionBarContributorRegistry actionBarContributorRegistry;

	/** SashModelMngr to add pages */
	protected DiSashModelMngr sashModelMngr;

	/**
	 * Service used to maintain the dirty state and to perform save and saveAs.
	 */
	protected ISaveAndDirtyService saveAndDirtyService;

	/**
	 * Listener on {@link ISaveAndDirtyService#addInputChangedListener(IEditorInputChangedListener)}
	 */
	protected IEditorInputChangedListener editorInputChangedListener = new IEditorInputChangedListener() {

		/**
		 * This method is called when the editor input is changed from the ISaveAndDirtyService.
		 * 
		 * @see org.eclipse.papyrus.infra.core.lifecycleevents.IEditorInputChangedListener#editorInputChanged(org.eclipse.ui.part.FileEditorInput)
		 * 
		 * @param fileEditorInput
		 */
		public void editorInputChanged(FileEditorInput fileEditorInput) {
			// Change the editor input.
			setInputWithNotify(fileEditorInput);
			setPartName(fileEditorInput.getName());
		}

		/**
		 * The isDirty flag has changed, reflect its new value
		 * 
		 * @see org.eclipse.papyrus.infra.core.lifecycleevents.IEditorInputChangedListener#isDirtyChanged()
		 * 
		 */
		public void isDirtyChanged() {

			// Run it in async way.
			getSite().getShell().getDisplay().asyncExec(new Runnable() {

				public void run() {
					firePropertyChange(IEditorPart.PROP_DIRTY);
				}
			});
		}
	};

	private TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * Object managing models lifeCycle.
	 */
	protected ModelSet resourceSet;

	/**
	 * Cached event that can be reused.
	 */
	protected DoSaveEvent lifeCycleEvent;

	/**
	 * 
	 */
	private TabbedPropertySheetPage tabbedPropertySheetPage = null;

	/**
	 * My editing domain provider.
	 */
	private IEditingDomainProvider domainProvider = new IEditingDomainProvider() {

		public EditingDomain getEditingDomain() {
			return transactionalEditingDomain;
		}
	};

	/**
	 * A listener on model change events.
	 */
	private IContentChangedListener contentChangedListener = new IContentChangedListener() {

		/**
		 * Called when the content is changed. RefreshTabs.
		 */
		public void contentChanged(ContentEvent event) {
			refreshTabs();
		}
	};

	/**
	 * Undo context used to have the same undo context in all Papyrus related views and editors.
	 * TODO : move away, use a version independent of GMF, add a listener that will add
	 * the context to all commands modifying attached Resources (==> linked to ModelSet ?)
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
			//			servicesRegistry.startRegistry();
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
	 * @param pageFactory
	 * @param diResource
	 *        Resource used to load/save the SashModel.
	 */
	protected ISashWindowsContentProvider createPageProvider(IPageModelFactory pageFactory, Resource diResource, TransactionalEditingDomain editingDomain) {

		sashModelMngr = new TransactionalDiSashModelMngr(pageFactory, diResource, editingDomain);

		ISashWindowsContentProvider pageProvider = sashModelMngr.getISashWindowsContentProvider();

		return pageProvider;
	}

	/**
	 * Get The {@link IPageMngr} used to add, open, remove or close a diagram in the
	 * SashWindow.
	 * This method is available as soon as the {@link CoreMultiDiagramEditor#init(IEditorSite, IEditorInput)} method is called.
	 * 
	 * @return
	 */
	protected IPageMngr getIPageMngr() throws IllegalStateException {
		try {
			return sashModelMngr.getIPageMngr();
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
		// The ActionBarContributorRegistry is initialized by the Contributor.
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

		if(IPageMngr.class == adapter) {
			return getIPageMngr();
		}

		if(IPropertySheetPage.class == adapter) {
			// Do not test if tabbedPropertySheetPage is null before calling new
			// this is managed by Eclipse which only call current method when necessary
			return getPropertySheetPage();
		}

		// Add a viewer
		if(IContentOutlinePage.class == adapter) {
			try {
				IContentOutlinePage contentOutline = getContentOutlineRegistry().getContentOutline();
				if(contentOutline != null) {
					return contentOutline;
				}
			} catch (BackboneException e) {
				// TODO change next exception to more appropriate one
				throw new RuntimeException(e);
			}
		}

		if(EditingDomain.class == adapter) {
			return transactionalEditingDomain;
		}

		/*
		 * Return context used for undo/redo.
		 * All papyrus views should use this context.
		 * The prefer way to get this is to use
		 * undoContext = servicesRegistry.getService(IUndoContext.class);
		 */
		if(IUndoContext.class == adapter) {
			return undoContext;
		}

		// EMF requirements
		if(IEditingDomainProvider.class == adapter) {

			// return (IEditingDomainProvider) defaultContext.getTransactionalEditingDomain().getResourceSet();
			return domainProvider;
		}

		// GEF diagram requirements
		if(adapter == ActionRegistry.class) {
			return gefAdaptorDelegate.getActionRegistry();
		}

		// // GEF diagram requirements
		// if (adapter == SelectionSynchronizer.class) {
		// return gefAdaptorDelegate.getSelectionSynchronizer();
		// }

		// TODO : following code is GMF dependent. It should be moved to adapter
		// Do we really need it? Who use it ?
		// -> It seems to be needed, see bug 354050
		if(adapter == IDiagramGraphicalViewer.class) {
			IEditorPart activeEditor = getActiveEditor();
			if(activeEditor instanceof DiagramEditor) {
				return ((DiagramEditor)activeEditor).getDiagramGraphicalViewer();
			}
			return null;
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

		// Used to get the appropriate domain object from a graphical object (EditPart, ...)
		BusinessModelResolver.getInstance();

		// Load resources
		//		resourceSet = new DiResourceSet();
		//		IFile file = ((IFileEditorInput)input).getFile();
		//		resourceSet.loadResources(file);

		// Create the 2 edit domains
		//		transactionalEditingDomain = resourceSet.getTransactionalEditingDomain();

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
		AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		/** label provider for EMF objects */
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(factory) {

			/**
			 * This implements {@link ILabelProvider}.getText by forwarding it to an object that implements {@link IItemLabelProvider#getText
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

		// Start servicesRegistry
		IFile file = ((IFileEditorInput)input).getFile();
		try {
			// Start the ModelSet first, and load if from the specified File
			List<Class<?>> servicesToStart = new ArrayList<Class<?>>(1);
			servicesToStart.add(ModelSet.class);

			servicesRegistry.startServicesByClassKeys(servicesToStart);
			resourceSet = servicesRegistry.getService(ModelSet.class);
			resourceSet.loadModels(file);

			// start remaining services
			servicesRegistry.startRegistry();
		} catch (ModelMultiException e) {
			try {
				// with the ModelMultiException it is still possible to open the editors that's why the service registry is still started 
				servicesRegistry.startRegistry();
				warnUser(e);
			} catch (ServiceException e1) {
				log.error(e);
				throw new PartInitException("could not initialize services", e); //$NON-NLS-1$
			}
		} catch (ServiceException e) {
			log.error(e);
			throw new PartInitException("could not initialize services", e);
		}


		// Get required services
		ISashWindowsContentProvider contentProvider = null;
		try {
			transactionalEditingDomain = servicesRegistry.getService(TransactionalEditingDomain.class);
			sashModelMngr = servicesRegistry.getService(DiSashModelMngr.class);
			contentProvider = servicesRegistry.getService(ISashWindowsContentProvider.class);
			saveAndDirtyService = servicesRegistry.getService(ISaveAndDirtyService.class);
			undoContext = servicesRegistry.getService(IUndoContext.class);
		} catch (ServiceException e) {
			log.error("A required service is missing.", e);
			// if one of the services above fail to start, the editor can't run => stop
			throw new PartInitException("could not initialize services", e);
		}

		// Set the content provider providing editors.
		setContentProvider(contentProvider);

		// Set editor name
		setPartName(file.getName());

		// Listen on contentProvider changes
		sashModelMngr.getSashModelContentChangedProvider().addListener(contentChangedListener);

		// Listen on input changed from the ISaveAndDirtyService
		saveAndDirtyService.addInputChangedListener(editorInputChangedListener);
	}

	protected void warnUser(ModelMultiException e) {
		MessageDialog.openError(getSite().getShell(), "Error", String.format("Your model is corrupted, invalid links have been found :\n"
			+ "%s"
			+ "It is recommended to fix it before editing it", e.getMessage()));
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
		} catch (ServiceException e) {
			log.error(e);
		}
	}


	/**
	 * Init the contextual menu shown in the folder tabs.
	 * This popup menu is contributed by the help of Eclipse extensions, using the Commands framework.
	 * I.e, to add a menu item, create a menu, a command and an handler in the extension.
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
		if(this.tabbedPropertySheetPage == null) {
			this.tabbedPropertySheetPage = new TabbedPropertySheetPage(this);
		}
		return tabbedPropertySheetPage;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.AbstractMultiPageSashEditor#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		if(sashModelMngr != null) {
			sashModelMngr.getSashModelContentChangedProvider().removeListener(contentChangedListener);
		}

		// Avoid memory leak
		// This call is done from the ServicesRegistry when it is disposed.
		// Don't need to do it there.
		//		if(resourceSet != null) {
		//			resourceSet.unload();
		//		}

		// dispose available service
		if(servicesRegistry != null) {
			try {
				servicesRegistry.disposeRegistry();
			} catch (ServiceMultiException e) {
				log.error(e);
			}
		}

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
	public org.eclipse.gmf.runtime.notation.Diagram getDiagram() {
		IEditorPart activeEditor = getActiveEditor();
		if(activeEditor instanceof DiagramEditor) {
			return ((DiagramEditor)activeEditor).getDiagram();
		} else {
			return null;
		}
	}

	/**
	 * This method is called from a GMF diagram. It should only be called from GMF diagram code. Normally, the Diagram under the Mouse is a GMF
	 * Diagram. The active Diagram can be another Diagram, not
	 * under the mouse. This is a GMF issue.
	 */
	public DiagramEditPart getDiagramEditPart() {

		// Get the editor under the mouse
		// IEditorPart activeEditor = rootContainer.getEditorUnderMouse();
		IEditorPart activeEditor = getActiveEditor();
		if(activeEditor == null) {
			return null;
		}
		// IEditorPart activeEditor = getActiveEditor();
		if(activeEditor instanceof DiagramEditor) {
			return ((DiagramEditor)activeEditor).getDiagramEditPart();
		} else {
			// This case should never happen.
			// Return null, as the GMF runtime now support it (since 093009)
			return null;
		}
	}

	/**
	 * Overrides getDiagramGraphicalViewer.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart#getDiagramGraphicalViewer()
	 */
	public IDiagramGraphicalViewer getDiagramGraphicalViewer() {
		IEditorPart activeEditor = getActiveEditor();
		if(activeEditor instanceof DiagramEditor) {
			return ((DiagramEditor)activeEditor).getDiagramGraphicalViewer();
		} else {
			return null;
		}
	}

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
	public DiagramEditDomain getDiagramEditDomain() {
		throw new UnsupportedOperationException("Not implemented. Should not be called.");
	}


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

	@Deprecated
	public void setEditorInput(IEditorInput newInput) {
		setInputWithNotify(newInput);
		setPartName(newInput.getName());
	}

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
}
