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

package org.eclipse.papyrus.core.editor;

import static org.eclipse.papyrus.core.Activator.log;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.EventObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.core.contentoutline.ContentOutlineRegistry;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.core.editorsfactory.PageModelFactoryRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.PluggableEditorFactoryReader;
import org.eclipse.papyrus.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.core.lifecycleevents.ILifeCycleEventsProvider;
import org.eclipse.papyrus.core.lifecycleevents.LifeCycleEventsProvider;
import org.eclipse.papyrus.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.core.multidiagram.actionbarcontributor.CoreComposedActionBarContributor;
import org.eclipse.papyrus.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.BusinessModelResolver;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.sasheditor.contentprovider.IContentChangedListener;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.di.DiSashModelMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory;
import org.eclipse.papyrus.sasheditor.contentprovider.di.TransactionalDiSashModelMngr;
import org.eclipse.papyrus.sasheditor.editor.AbstractMultiPageSashEditor;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.sasheditor.editor.gef.MultiDiagramEditorGefDelegate;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
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
public class CoreMultiDiagramEditor extends AbstractMultiPageSashEditor implements IMultiDiagramEditor, ITabbedPropertySheetPageContributor, IDiagramWorkbenchPart {

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

	private TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * Object managing models lifeCycle.
	 */
	protected DiResourceSet resourceSet = new DiResourceSet();

	/**
	 * Class used to propagate life cycle events.
	 * This class can be retrieved as a service using {@link ILifeCycleEventsProvider}.class.
	 */
	protected LifeCycleEventsProvider lifeCycleEventsProvider;

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

	private final org.eclipse.emf.common.command.CommandStackListener commandStackListener = new org.eclipse.emf.common.command.CommandStackListener() {

		public void commandStackChanged(EventObject event) {
			getSite().getShell().getDisplay().asyncExec(new Runnable() {

				public void run() {
					firePropertyChange(IEditorPart.PROP_DIRTY);
				}
			});
		}
	};

	private final ResourceSetListener resourceSetListener = new ResourceSetListener() {

		public NotificationFilter getFilter() {
			return null;
		}

		public boolean isAggregatePrecommitListener() {
			return false;
		}

		public boolean isPostcommitOnly() {
			return true;
		}

		public boolean isPrecommitOnly() {
			return false;
		}

		public void resourceSetChanged(ResourceSetChangeEvent event) {
			if(event.getTransaction() != null && event.getTransaction().getStatus().isOK()) {
				getSite().getShell().getDisplay().asyncExec(new Runnable() {

					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);
					}
				});
			}
		}

		public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
			return null;
		}

	};

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
	 * @see org.eclipse.papyrus.sasheditor.editor.AbstractMultiPageSashEditor#createPageProvider()
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
			log.info(getClass().getSimpleName() + " - ActionBarContributorRegistry loaded from CoreComposedActionBarContributor.");
			return ((CoreComposedActionBarContributor)contributor).getActionBarContributorRegistry();
		} else {
			// Create a registry.
			log.info(getClass().getSimpleName() + " - create an ActionBarContributorRegistry.");
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
		IFile file = ((IFileEditorInput)input).getFile();
		resourceSet.loadResources(file);

		// Create the 2 edit domains
		transactionalEditingDomain = resourceSet.getTransactionalEditingDomain();

		// Create Gef adaptor
		gefAdaptorDelegate = new MultiDiagramEditorGefDelegate();


		// Create ServicesRegistry and register services
		servicesRegistry = createServicesRegistry();

		// Create lifeCycle event provider.
		lifeCycleEventsProvider = new LifeCycleEventsProvider();
		lifeCycleEvent = new DoSaveEvent(servicesRegistry, this);
		servicesRegistry.add(ILifeCycleEventsProvider.class, 1, lifeCycleEventsProvider);

		// register services
		servicesRegistry.add(ActionBarContributorRegistry.class, 1, getActionBarContributorRegistry());
		servicesRegistry.add(TransactionalEditingDomain.class, 1, transactionalEditingDomain);
		servicesRegistry.add(DiResourceSet.class, 1, resourceSet);

		// Create and initalize editor icons service
		PageIconsRegistry pageIconsRegistry = new PageIconsRegistry();
		PluggableEditorFactoryReader editorReader = new PluggableEditorFactoryReader(Activator.PLUGIN_ID);
		editorReader.populate(pageIconsRegistry);
		servicesRegistry.add(IPageIconsRegistry.class, 1, pageIconsRegistry);


		// Create PageModelRegistry requested by content provider.
		// Also populate it from extensions.
		PageModelFactoryRegistry pageModelRegistry = new PageModelFactoryRegistry();
		editorReader.populate(pageModelRegistry, servicesRegistry);

		// TODO : create appropriate Resource for the contentProvider, and pass it here.
		// This will allow to remove the old sash stuff.
		setContentProvider(createPageProvider(pageModelRegistry, resourceSet.getDiResource(), transactionalEditingDomain));
		servicesRegistry.add(ISashWindowsContentProvider.class, 1, getContentProvider());
		servicesRegistry.add(IPageMngr.class, 1, getIPageMngr());


		// Start servicesRegistry
		servicesRegistry.startRegistry();

		// Listen to the modifications of the EMF model
		transactionalEditingDomain.getCommandStack().addCommandStackListener(commandStackListener);

		// Let's listen to the resource set change
		transactionalEditingDomain.addResourceSetListener(resourceSetListener);

		// Set editor name
		setPartName(file.getName());

		// Listen on contentProvider changes
		sashModelMngr.getSashModelContentChangedProvider().addContentChangedListener(contentChangedListener);
	}

	/**
	 * Activate this editor.
	 * Called after the SWT.control is created.
	 */
	@Override
	protected void activate() {
		// TODO Auto-generated method stub
		super.activate();
		initFolderTabMenus();
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
		getSite().registerContextMenu("org.eclipse.papyrus.core.editor.ui.tabmenu", menuManager, getSite().getSelectionProvider());

	}

	/**
	 * Overrides getPropertySheetPage.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.core.editor.IMultiDiagramEditor#getPropertySheetPage()
	 */
	public IPropertySheetPage getPropertySheetPage() {
		if(this.tabbedPropertySheetPage == null) {
			this.tabbedPropertySheetPage = new TabbedPropertySheetPage(this);
		}
		return tabbedPropertySheetPage;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.editor.AbstractMultiPageSashEditor#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		if(sashModelMngr != null) {
			sashModelMngr.getSashModelContentChangedProvider().removeContentChangedListener(contentChangedListener);
		}

		if(transactionalEditingDomain != null) {
			transactionalEditingDomain.getCommandStack().removeCommandStackListener(commandStackListener);
			transactionalEditingDomain.removeResourceSetListener(resourceSetListener);
		}

		// Avoid memory leak
		if(resourceSet != null) {
			resourceSet.unload();
		}

		// dispose available service
		if(servicesRegistry != null) {
			servicesRegistry.disposeService();
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

		// Sent pre doSave event
		lifeCycleEventsProvider.fireAboutToDoSaveEvent(lifeCycleEvent);

		// sent doSaveEvent
		lifeCycleEventsProvider.fireDoSaveEvent(lifeCycleEvent);
		// Perform local doSave
		// TODO : put it in a listener ?
		try {
			// Save each associated resource
			resourceSet.save(monitor);
			markSaveLocation();
		} catch (IOException e) {
			log.error("Error during save", e);
		}

		// Sent post Events
		lifeCycleEventsProvider.firePostDoSaveEvent(lifeCycleEvent);

	}

	/**
	 * Mark the command stack of all sub-editors. Default implementation do nothing.
	 */
	@Override
	protected void markSaveLocation() {
		((BasicCommandStack)transactionalEditingDomain.getCommandStack()).saveIsDone();
		super.markSaveLocation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		// First, look if the model part (EMF) is dirty, else look at the Graphical part (GEF/GMF)
		return ((BasicCommandStack)transactionalEditingDomain.getCommandStack()).isSaveNeeded() || super.isDirty();
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

		// Sent pre doSave event
		lifeCycleEventsProvider.fireAboutToDoSaveAsEvent(lifeCycleEvent);

		// sent doSaveEvent
		lifeCycleEventsProvider.fireDoSaveAsEvent(lifeCycleEvent);
		// Perform local doSaveAs


		// Show a SaveAs dialog
		Shell shell = getEditorSite().getWorkbenchWindow().getShell();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		dialog.setOriginalFile(((IFileEditorInput)getEditorInput()).getFile());
		dialog.open();
		final IPath path = dialog.getResult();
		if(path != null) {
			// try to save the editor's contents under a different file name
			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			try {
				new ProgressMonitorDialog(shell).run(false, // don't fork
				false, // not cancelable
				new WorkspaceModifyOperation() { // run this operation

					@Override
					public void execute(final IProgressMonitor monitor) {
						try {
							resourceSet.saveAs(path);
						} catch (IOException e) {
							log.error("Unable to saveAs the resource set", e);
						}
					}
				});
				// set input to the new file
				setInput(new FileEditorInput(file));
				markSaveLocation();
			} catch (InterruptedException e) {
				// should not happen, since the monitor dialog is not cancelable
				log.error(e);
			} catch (InvocationTargetException e) {
				log.error(e);
			}
		}

		// sent doSaveEvent
		lifeCycleEventsProvider.firePostDoSaveAsEvent(lifeCycleEvent);

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
	 * @see org.eclipse.papyrus.core.editor.IMultiDiagramEditor#getDiagramEditDomain()
	 */
	public DiagramEditDomain getDiagramEditDomain() {
		throw new UnsupportedOperationException("Not implemented. Should not be called.");
	}


	/**
	 * Change the editor input.<BR>
	 * <U>Note</U>: that method should be called within the UI-Thread.
	 * 
	 * @see org.eclipse.papyrus.core.editor.IMultiDiagramEditor#setEditorInput(org.eclipse.ui.IEditorInput)
	 * 
	 * @param newInput
	 *        The new input
	 */

	public void setEditorInput(IEditorInput newInput) {
		setInputWithNotify(newInput);
		setPartName(newInput.getName());
		markSaveLocation();
	}
}
