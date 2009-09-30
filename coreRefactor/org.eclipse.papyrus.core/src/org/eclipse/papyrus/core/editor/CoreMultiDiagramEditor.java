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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.EventObject;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.CommandStackListener;
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
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactoryRegistry;
import org.eclipse.papyrus.core.extension.editorcontext.EditorContextRegistry;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
import org.eclipse.papyrus.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.core.multidiagram.actionbarcontributor.CoreComposedActionBarContributor;
import org.eclipse.papyrus.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IContentChangedListener;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.di.DiSashModelMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory;
import org.eclipse.papyrus.sasheditor.contentprovider.di.TransactionalDiSashModelMngr;
import org.eclipse.papyrus.sasheditor.editor.AbstractMultiPageSashEditor;
import org.eclipse.papyrus.sasheditor.gef.EditorNotFoundException;
import org.eclipse.papyrus.sasheditor.gef.MultiDiagramEditorGefDelegate;
import org.eclipse.papyrus.sasheditor.gef.MultiDiagramException;
import org.eclipse.papyrus.sasheditor.gef.SelectionSynchronizer;
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
 * Multi diagram editor allowing to plug various kind of editors. Editors are registered with the help of the Eclipse extension mechanism. This implementation allows to register editors and context
 * separately. An editor should specify which context it need to run. This multi diagram editor allows to show editor side by side in one or more sash windows.
 * 
 * The real implementation for the generic type T of SashMultiPageEditorPart is actually di2.Diagram
 * 
 * @author dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * 
 *         TODO : remove GMF dependency !
 */
public class CoreMultiDiagramEditor extends /* MultiPageEditor */ AbstractMultiPageSashEditor implements IMultiDiagramEditor, ITabbedPropertySheetPageContributor, IDiagramWorkbenchPart {
//public class CoreMultiDiagramEditor extends MultiPageEditor  /*AbstractMultiPageSashEditor */ implements IMultiDiagramEditor, ITabbedPropertySheetPageContributor, IDiagramWorkbenchPart {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** Gef adapter */
	private MultiDiagramEditorGefDelegate gefAdaptorDelegate;

	/** Registry to store editor factories */
	private IEditorFactoryRegistry editorRegistry;

	/** Registry for editor contexts */
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
	private BackboneContext defaultContext;


	/**
	 * 
	 */
	private TabbedPropertySheetPage tabbedPropertySheetPage = null;

	/** Flag reflecting the editor state. The flag is set by listeners on model changes */
	private boolean toSave = false;

	/** gef editing domain shared among all editors in this multi diagram editor */
	private DiagramEditDomain diagramEditDomain;

	/**
	 * My editing domain provider.
	 */
	private IEditingDomainProvider domainProvider = new IEditingDomainProvider() {

		public EditingDomain getEditingDomain() {
			return CoreMultiDiagramEditor.this.defaultContext.getTransactionalEditingDomain();
		}
	};

	/**
	 * Listening on diagram changes. Only listen on diagram add/delete
	 */
	private PropertyChangeListener diagramChangeListener = new PropertyChangeListener() {

		public void propertyChange(PropertyChangeEvent evt) {
			// refresh tabs.
			refreshTabs();
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
			System.out.println("contentChanged()");
			refreshTabs();
		}
	};
	

	/**
	 * Listen on change on commandStack. Mark editor as dirty if needed.
	 */
	private CommandStackListener commandStackListener = new CommandStackListener() {

		public void commandStackChanged(EventObject event) {
			firePropertyChange(IEditorPart.PROP_DIRTY);
			markDirty();
		}

	};

	/**
	 * Constructor.
	 */
	public CoreMultiDiagramEditor() {
		super();
		setDiagramEditDomain(new DiagramEditDomain(this));
	}

	/**
	 * Create a PageEditor for the specified model. Default implementation delegates to pageEditorFactory.createPageEditorFor(model); Not intended for external use.
	 * 
	 * @param model
	 *            the diagram to be displayed
	 * @return the Graphical Editor that displays the specified diagram
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	public IEditorPart createPageEditor(Object model) throws MultiDiagramException {
		IEditorPart part = getEditorRegistry().createEditorFor(getContextRegistry(), model);
		return part;
	}

	/**
	 * Get the EditorActionBarContributor that should be associated with the editor of the specified model.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.IMultiEditorNestedPartManager#getActionBarContributor(java.lang.Object)
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
	 * @return
	 */
	public IEditorContextRegistry getContextRegistry() {
		return editorContextRegistry;
	}

	/**
	 * Create the IEditorContextRegistry containing registered contexts. Subclass should implements this method in order to return the registry associated to the extension point namespace.
	 * 
	 * @param defaultContext
	 * @param input
	 * @param site
	 * @param input
	 * @param site
	 * @return the IEditorContextRegistry for nested editor descriptors
	 */
	protected IEditorContextRegistry createEditorContextRegistry() {
		IEditorContextRegistry registry = new EditorContextRegistry(this, Activator.PLUGIN_ID);
		return registry;
	}

	/**
	 * Get the contentOutlineRegistry. Create it if needed.
	 * 
	 * @return the contentOutlineRegistry
	 */
	protected ContentOutlineRegistry getContentOutlineRegistry() {
		if (contentOutlineRegistry == null)
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
	 * Get the EditorRegistry used to create editor instances. This default implementation return the singleton eINSTANCE. This method can be subclassed to return another registry.
	 * 
	 * @return the singleton eINSTANCE of editor registry
	 */
	protected IEditorFactoryRegistry getEditorRegistry() {
		if (editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		return editorRegistry;
	}

	
	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should implements this method in order to return the registry associated to the extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 */
	protected IEditorFactoryRegistry createEditorRegistry() {
		return new EditorFactoryRegistry(Activator.PLUGIN_ID);
	}

	/**
	 * @return the servicesRegistry
	 */
	protected ServicesRegistry getServicesRegistry() {
		if (servicesRegistry == null) {
			servicesRegistry = createServicesRegistry();
		}
		return servicesRegistry;
	}

	/**
	 * Create the ServicesRegistry.
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
	 * Should not be called by subclasses
	 * {@inheritDoc}
	 * @see org.eclipse.papyrus.sasheditor.editor.AbstractMultiPageSashEditor#createPageProvider()
	 */
	@Override
	protected ISashWindowsContentProvider createPageProvider() {
		throw new UnsupportedOperationException("Not implemented. Should not be called as the ContentProvider is already initialized." );
	}

	/**
	 * Create the pageContentProvider.
	 * @param pageFactory
	 * @param diResource Resource used to load/save the SashModel.
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
	 * This method is available as soon as the {@link CoreMultiDiagramEditor#init(IEditorSite, IEditorInput)} 
	 * method is called.
	 * @return
	 */
	protected IPageMngr getIPageMngr() throws IllegalStateException
	{
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
		if (actionBarContributorRegistry != null)
			return actionBarContributorRegistry;

		// Try to got it from CoreComposedActionBarContributor
		// The ActionBarContributorRegistry is initialized by the Contributor.
		// Get it from the contributor.
		IEditorActionBarContributor contributor = getEditorSite().getActionBarContributor();
		if (contributor instanceof CoreComposedActionBarContributor) {
			log.info(getClass().getSimpleName() + " - ActionBarContributorRegistry loaded from CoreComposedActionBarContributor.");
			return ((CoreComposedActionBarContributor) contributor).getActionBarContributorRegistry();
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
		
		if(ServicesRegistry.class == adapter)
		{
			return getServicesRegistry();
		}
		
		if(IPageMngr.class == adapter)
		{
			return getIPageMngr();
		}
		
		if (IPropertySheetPage.class == adapter) {
			// Do not test if tabbedPropertySheetPage is null before calling new
			// this is managed by Eclipse which only call current method when necessary
			return getPropertySheetPage();
		}

		// Add a viewer
		if (IContentOutlinePage.class == adapter) {
			try {
				IContentOutlinePage contentOutline = getContentOutlineRegistry().getContentOutline();
				if (contentOutline != null)
					return contentOutline;
			} catch (BackboneException e) {
				// TODO change next exception to more appropriate one
				throw new RuntimeException(e);
			}
		}

		if (BackboneContext.class == adapter) {
			return defaultContext;
		}

		if (EditingDomain.class == adapter) {
			return defaultContext.getTransactionalEditingDomain();
		}

		// EMF requirements
		if (IEditingDomainProvider.class == adapter) {

			// return (IEditingDomainProvider) defaultContext.getTransactionalEditingDomain().getResourceSet();
			return domainProvider;
		}

		// GEF diagram requirements
		if (adapter == ActionRegistry.class) {
			return gefAdaptorDelegate.getActionRegistry();
		}

		// GEF diagram requirements
		if (adapter == SelectionSynchronizer.class) {
			return gefAdaptorDelegate.getSelectionSynchronizer();
		}

		// TODO : following code is GMF dependant. It should be moved to adapter
		// Do we really need it? Who use it ?
		if (adapter == IDiagramGraphicalViewer.class) {
			IEditorPart activeEditor = getActiveEditor();
			if (activeEditor instanceof DiagramEditor) {
				return ((DiagramEditor) activeEditor).getDiagramGraphicalViewer();
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

		// Init this class
		try {
			defaultContext = createDefaultContext(site, input);
		} catch (BackboneException e) {
			throw new PartInitException("Can't create default context.", e);
		}

		// configureDiagramEditDomain();
		EditingDomainService editingDomainService = new EditingDomainService(defaultContext);
		editingDomainService.addCommandStackListener(commandStackListener);

		// Load resources
		IFile file = ((IFileEditorInput) input).getFile();
		defaultContext.getResourceSet().loadResources(file);

		// Create Gef adaptor
		gefAdaptorDelegate = new MultiDiagramEditorGefDelegate();

		// Create registries
		// editorContextRegistry should be created after site, input and defaultContext are created.
		editorContextRegistry = createEditorContextRegistry();
		editorContextRegistry.registerContext("defaultContext", defaultContext);
		editorRegistry = createEditorRegistry();

		// Create ServicesRegistry and register services
		servicesRegistry = createServicesRegistry();
		servicesRegistry.add(ActionBarContributorRegistry.class, 1, getActionBarContributorRegistry());
		servicesRegistry.add(IEditorContextRegistry.class, 1, editorContextRegistry);
		
		// Create ContentProvider
		PageModelFactory pageModelRegistry = new PageModelFactory(editorRegistry, servicesRegistry);
		setContentProvider( createPageProvider(pageModelRegistry, defaultContext.getResourceSet().getDiResource(), defaultContext.getTransactionalEditingDomain()));
		servicesRegistry.add(ISashWindowsContentProvider.class, 1, getContentProvider());
		servicesRegistry.add(IPageMngr.class, 1, getIPageMngr());
		
		// Set editor name
		setPartName(file.getName());
		
		

	}

	/**
	 * 
	 */
	@Override
	protected void activate() {
		super.activate();

		// Show the model Explorer View
		// TODO Use the extension mechanism ?
//		try {
//			if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) {
//				if (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null) {
//					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(IPapyrusUIConstants.MODEL_EXPLORER_VIEW_ID, null, IWorkbenchPage.VIEW_ACTIVATE);
//				}
//			}
//		} catch (PartInitException e) {
//			String message = "Error while  showing the Model Explorer view." + e.getMessage();
//			IStatus status = new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), IStatus.ERROR, message, e);
//			Activator.getDefault().getLog().log(status);
////			throw new RuntimeException("Error while  showing the Model Explorer view.", e);
//		}

	}

	@Override
	protected void deactivate() {
		super.deactivate();
	}

	/**
	 * {@inheritDoc}
	 */
	public IPropertySheetPage getPropertySheetPage() {
		if (this.tabbedPropertySheetPage == null) {
			this.tabbedPropertySheetPage = new TabbedPropertySheetPage(this);
		}
		return tabbedPropertySheetPage;
	}

	/**
	 * Create the default context used to control models life cycles.
	 * 
	 * @param site
	 * @param input
	 * @throws BackboneException
	 */
	private BackboneContext createDefaultContext(IEditorSite site, IEditorInput input) throws BackboneException {
		BackboneContext defaultContext = new BackboneContext();
		defaultContext.init(this);

		return defaultContext;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			// Save each associated resource
			defaultContext.save(monitor);
			markSaveLocation();
		} catch (IOException ioe) {
		}

	}

	/**
	 * Mark the command stack of all sub-editors. Default implementation do nothing.
	 */
	protected void markSaveLocation() {
		toSave = false;
		getDiagramEditDomain().getCommandStack().markSaveLocation();
		firePropertyChange(PROP_DIRTY);
	}

	/**
	 * Mark the editor as dirty, and fire appropriate event.
	 */
	protected void markDirty() {
		toSave = true;
		firePropertyChange(PROP_DIRTY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		return toSave;
		// return getDiagramEditDomain().getDiagramCommandStack().isDirty();
	}

	@Override
	public void doSaveAs() {
		// Show a SaveAs dialog
		toSave = false;
		super.firePropertyChange(PROP_DIRTY);
		Shell shell = getEditorSite().getWorkbenchWindow().getShell();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
		dialog.open();
		final IPath path = dialog.getResult();
		if (path != null) {
			// try to save the editor's contents under a different file name
			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			try {
				new ProgressMonitorDialog(shell).run(false, // don't fork
						false, // not cancelable
						new WorkspaceModifyOperation() { // run this operation

							@Override
							public void execute(final IProgressMonitor monitor) {
								try {
									defaultContext.saveAs(path);
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

	@Override
	public boolean isSaveAsAllowed() {
		return defaultContext.isSaveAsAllowed();
	}

	/**
	 * @see org.eclipse.papyrus.core.editor.IMultiDiagramEditor#getDefaultContext()
	 */
	public BackboneContext getDefaultContext() {
		return defaultContext;
	}

	public String getContributorId() {
		// return Activator.PLUGIN_ID;
		return "TreeOutlinePage";

	}

	// FIXME: Pour C�dric modif
	public IEditorPart getActiveEditor() {
		return super.getActiveEditor();
	}

	/**
	 * Sets the default edit domain, shared among all editors
	 * 
	 * @param diagramEditDomain
	 *            the diagramEditDomain to set
	 */
	public void setDiagramEditDomain(DiagramEditDomain diagramEditDomain) {
		this.diagramEditDomain = diagramEditDomain;
	}

	/**
	 * {@inheritDoc}
	 */
	public DiagramEditDomain getDiagramEditDomain() {
		return diagramEditDomain;
	}

	// implements IDiagramWorkbenchPart to restore GMF standard behavior
	// and delegate to the activeEditor
	/**
	 * {@inheritDoc}
	 */
	public org.eclipse.gmf.runtime.notation.Diagram getDiagram() {
		IEditorPart activeEditor = getActiveEditor();
		if (activeEditor instanceof DiagramEditor) {
			return ((DiagramEditor) activeEditor).getDiagram();
		} else {
			return null;
		}
	}

	/**
	 * This method is called from a GMF diagram. It should only be called from GMF diagram code. Normally, the Diagram under the Mouse is a GMF Diagram. The active Diagram can be another Diagram, not
	 * under the mouse. This is a GMF issue.
	 */
	public DiagramEditPart getDiagramEditPart() {

		// Get the editor under the mouse
//		IEditorPart activeEditor = rootContainer.getEditorUnderMouse();
		IEditorPart activeEditor = getActiveEditor();
		if(activeEditor == null)
			return null;
		// IEditorPart activeEditor = getActiveEditor();
		if (activeEditor instanceof DiagramEditor) {
			return ((DiagramEditor) activeEditor).getDiagramEditPart();
		} else {
			// This case should never happen.
			throw new UnsupportedOperationException("Method should only be called from GMF code when the mouse is over a GMF diagram. it is called from " + activeEditor.getTitle() + ", "
					+ activeEditor);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public IDiagramGraphicalViewer getDiagramGraphicalViewer() {
		IEditorPart activeEditor = getActiveEditor();
		if (activeEditor instanceof DiagramEditor) {
			return ((DiagramEditor) activeEditor).getDiagramGraphicalViewer();
		} else {
			return null;
		}
	}

	public EditingDomain getEditingDomain() {
		return defaultContext.getTransactionalEditingDomain();
	}


}
