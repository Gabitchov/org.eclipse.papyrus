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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.EventObject;
import java.util.logging.Logger;

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
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.core.contentoutline.ContentOutlineRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.EditorFactoryRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.EditorNotFoundException;
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactoryRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.MultiDiagramException;
import org.eclipse.papyrus.core.extension.editorcontext.EditorContextRegistry;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
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
import org.eclipse.papyrus.sasheditor.editor.gef.MultiDiagramEditorGefDelegate;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.EditorActionBarContributor;
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
 * @author dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * 
 *         TODO : remove GMF dependency !
 */
public class CoreMultiDiagramEditor extends AbstractMultiPageSashEditor implements IMultiDiagramEditor, ITabbedPropertySheetPageContributor, IDiagramWorkbenchPart {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** Gef adapter */
	private MultiDiagramEditorGefDelegate gefAdaptorDelegate;

	/** Registry to store editor factories */
	private IEditorFactoryRegistry editorRegistry;

	/** Registry for editor contexts */
	@Deprecated
	private IEditorContextRegistry editorContextRegistry;

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
	 * Context associated to this backbone editor.
	 */
	@Deprecated
	private BackboneContext defaultContext;

	private TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * Object managing models lifeCycle.
	 */
	protected DiResourceSet resourceSet = new DiResourceSet();

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
	 * Create a PageEditor for the specified model. Default implementation delegates to pageEditorFactory.createPageEditorFor(model); Not intended for
	 * external use.
	 * 
	 * @param model
	 *        the diagram to be displayed
	 * @return the Graphical Editor that displays the specified diagram
	 * @throws EditorNotFoundException
	 *         No editor handling the model can be found.
	 */
	public IEditorPart createPageEditor(Object model) throws MultiDiagramException {
		IEditorPart part = getEditorRegistry().createEditorFor(getContextRegistry(), model);
		return part;
	}

	/**
	 * Get the EditorActionBarContributor that should be associated with the editor of the specified model.
	 * 
	 * @param editorModel
	 * @return
	 * @throws MultiDiagramException
	 * 
	 */
	public EditorActionBarContributor getActionBarContributor(Object editorModel) {

		try {
			Object contributorId = getEditorRegistry().getEditorDescriptorFor(editorModel).getActionBarContributorId();
			return getActionBarContributorRegistry().getActionBarContributor(contributorId);
		} catch (BackboneException e) {
			log.warning(e.getMessage());
			// e.printStackTrace();
		} catch (MultiDiagramException e) {
			log.warning(e.getMessage());
			// e.printStackTrace();
		}
		return null;
	}

	/**
	 * Get the contextRegistry
	 * 
	 * @return The context registry
	 */
	@Deprecated
	public IEditorContextRegistry getContextRegistry() {
		return editorContextRegistry;
	}

	/**
	 * Create the IEditorContextRegistry containing registered contexts. Subclass should implements this method in order to return the registry
	 * associated to the extension point namespace.
	 * 
	 * @return the IEditorContextRegistry for nested editor descriptors
	 */
	@Deprecated
	protected IEditorContextRegistry createEditorContextRegistry() {
		return new EditorContextRegistry(this, Activator.PLUGIN_ID);
	}

	/**
	 * Get the contentOutlineRegistry. Create it if needed.
	 * 
	 * @return the contentOutlineRegistry
	 */
	protected ContentOutlineRegistry getContentOutlineRegistry() {
		if(contentOutlineRegistry == null)
			createContentOutlineRegistry();

		return contentOutlineRegistry;
	}

	/**
	 * Create the contentOutlineRegistry.
	 */
	private void createContentOutlineRegistry() {
		contentOutlineRegistry = new ContentOutlineRegistry(this, Activator.PLUGIN_ID);
	}

	/**
	 * Get the EditorRegistry used to create editor instances. This default implementation return the singleton eINSTANCE. This method can be
	 * subclassed to return another registry.
	 * 
	 * @return the singleton eINSTANCE of editor registry
	 */
	protected IEditorFactoryRegistry getEditorRegistry() {
		if(editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		return editorRegistry;
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should implements this method in order to return the registry associated to
	 * the extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 */
	protected IEditorFactoryRegistry createEditorRegistry() {
		return new EditorFactoryRegistry(Activator.PLUGIN_ID);
	}

	/**
	 * Returns the service registry associated to the editor.
	 * 
	 * @return the servicesRegistry The registry.
	 */
	protected ServicesRegistry getServicesRegistry() {
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
			servicesRegistry.startRegistry();
			return servicesRegistry;
		} catch (ServiceException e) {
			// Show log and error
			log.severe(e.getMessage());
			e.printStackTrace();
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

		// Listen on contentProvider changes
		sashModelMngr.getSashModelContentChangedProvider().addContentChangedListener(contentChangedListener);

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
	public ActionBarContributorRegistry getActionBarContributorRegistry() {
		if(actionBarContributorRegistry != null)
			return actionBarContributorRegistry;

		// Try to got it from CoreComposedActionBarContributor
		// The ActionBarContributorRegistry is initialized by the Contributor.
		// Get it from the contributor.
		IEditorActionBarContributor contributor = getEditorSite().getActionBarContributor();
		if(contributor instanceof CoreComposedActionBarContributor) {
			log.info(getClass().getSimpleName() + " - ActionBarContributorRegistry loaded from CoreComposedActionBarContributor.");
			return ((CoreComposedActionBarContributor)contributor).getActionBarContributorRegistry();
		} else {
			// Create a registry.
			log.warning(getClass().getSimpleName() + " - create an ActionBarContributorRegistry.");
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
	@Override
	public Object getAdapter(@SuppressWarnings("unchecked") Class adapter) {

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
				if(contentOutline != null)
					return contentOutline;
			} catch (BackboneException e) {
				// TODO change next exception to more appropriate one
				throw new RuntimeException(e);
			}
		}

		if(BackboneContext.class == adapter) {
			return defaultContext;
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

		// TODO : following code is GMF dependant. It should be moved to adapter
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

		// FIXME What for ?? Was used by the BackbonContext...
		BusinessModelResolver.getInstance();

		// Load resources
		IFile file = ((IFileEditorInput)input).getFile();
		resourceSet.loadResources(file);

		// Create the 2 edit domains
		transactionalEditingDomain = resourceSet.getTransactionalEditingDomain();

		// Create Gef adaptor
		gefAdaptorDelegate = new MultiDiagramEditorGefDelegate();

		// Just for backwards compatibility
		// FIXME Remove the following lines
		// =============
		// Create registries
		// editorContextRegistry should be created after site, input and
		// defaultContext are created.
		editorContextRegistry = createEditorContextRegistry();
		defaultContext = new BackboneContext(this);
		editorContextRegistry.registerContext(BackboneContext.BACKBONE_CONTEXT_ID, defaultContext);
		// =============

		editorRegistry = createEditorRegistry();

		// Create ServicesRegistry and register services
		servicesRegistry = createServicesRegistry();
		servicesRegistry.add(ActionBarContributorRegistry.class, 1, getActionBarContributorRegistry());
		servicesRegistry.add(IEditorContextRegistry.class, 1, editorContextRegistry);
		servicesRegistry.add(TransactionalEditingDomain.class, 1, transactionalEditingDomain);
		servicesRegistry.add(DiResourceSet.class, 1, resourceSet);

		// Create ContentProvider
		PageModelFactory pageModelRegistry = new PageModelFactory(editorRegistry, servicesRegistry);
		// TODO : create appropriate Resource for the contentProvider, and pass it here.
		// This will allow to remove the old sash stuff.
		setContentProvider(createPageProvider(pageModelRegistry, resourceSet.getDiResource(), transactionalEditingDomain));
		servicesRegistry.add(ISashWindowsContentProvider.class, 1, getContentProvider());
		servicesRegistry.add(IPageMngr.class, 1, getIPageMngr());

		// Listen to the modifications of the EMF model
		transactionalEditingDomain.getCommandStack().addCommandStackListener(new org.eclipse.emf.common.command.CommandStackListener() {

			public void commandStackChanged(EventObject event) {
				getSite().getShell().getDisplay().asyncExec(new Runnable() {

					public void run() {
						// System.out.println(getTitle() + " > GEF Stack changed");
						firePropertyChange(IEditorPart.PROP_DIRTY);
					}
				});
			}
		});

		// Let's listen to the resource set change
		transactionalEditingDomain.addResourceSetListener(new ResourceSetListener() {

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

		});

		// Set editor name
		setPartName(file.getName());

		// Listen on contentProvider changes
		sashModelMngr.getSashModelContentChangedProvider().addContentChangedListener(contentChangedListener);
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
	 * Overrides doSave.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			// Save each associated resource
			resourceSet.save(monitor);
			markSaveLocation();
		} catch (IOException ioe) {
			log.warning("Error during save");
		}

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
						} catch (IOException ioe) {
							// Debug.log(ioe);
						}
					}
				});
				// set input to the new file
				setInput(new FileEditorInput(file));
				markSaveLocation();
			} catch (InterruptedException ie) {
				// should not happen, since the monitor dialog is not cancelable
				ie.printStackTrace();
			} catch (InvocationTargetException ite) {
				ite.printStackTrace();
			}
		}

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
	 * @see org.eclipse.papyrus.core.editor.IMultiDiagramEditor#getDefaultContext()
	 */
	@Deprecated
	public BackboneContext getDefaultContext() {
		return defaultContext;
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
		if(activeEditor == null)
			return null;
		// IEditorPart activeEditor = getActiveEditor();
		if(activeEditor instanceof DiagramEditor) {
			return ((DiagramEditor)activeEditor).getDiagramEditPart();
		} else {
			// This case should never happen.
			// throw new UnsupportedOperationException("Method should only be called from GMF code when the mouse is over a GMF diagram. it is called from " + activeEditor.getTitle() + ", "
			// + activeEditor);
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
	 * Returns resourceSet.
	 * 
	 * @return The resourceSet.
	 */
	@Deprecated
	// Removes it when Backbone is deleted
	public DiResourceSet getResourceSet() {
		return resourceSet;
	}
}
