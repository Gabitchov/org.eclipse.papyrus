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
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.core.contentoutline.ContentOutlineRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.EditorFactoryRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactoryRegistry;
import org.eclipse.papyrus.core.extension.editorcontext.EditorContextRegistry;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.papyrus.sasheditor.gef.EditorNotFoundException;
import org.eclipse.papyrus.sasheditor.gef.GefMultiPageEditorPart;
import org.eclipse.papyrus.sasheditor.gef.MultiDiagramException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Multi diagram editor allowing to plug various kind of editors. Editors are registered with the help of the Eclipse extension mechanism. This implementation allows to register editors and context
 * separately. An editor should specify which context it need to run.
 * 
 * @author dumoulin
 * @author Remi Schnekenburger
 * @deprecated This class will be replaced by SashMultiDiagramEditor. Do not use methods from this class. Instead , define services accessible from the appropriate Context. If the service should
 *             belong to core, make it accessible from this class. It will be moved to SashMultiDiagramEditor.
 * 
 */
public class MultiDiagramEditor extends GefMultiPageEditorPart implements IMultiDiagramEditor, ITabbedPropertySheetPageContributor {

	public static final String ID = "org.eclipse.papyrus.core.papyrusEditor"; //$NON-NLS-1$

	/** Registry to store editor factories */
	private IEditorFactoryRegistry editorRegistry;

	/** Registry for editor contexts */
	private IEditorContextRegistry editorContextRegistry;

	/** ContentOutline registry */
	private ContentOutlineRegistry contentOutlineRegistry;

	/**
	 * Context associated to this backbone editor.
	 */
	private BackboneContext defaultContext;

	/**
	 * Diagram notifier notifying diagram CRUD events.
	 */
	private DiagramNotifier diagramNotifier;

	/** gef editing domain shared among all editors in this multi diagram editor */
	private DiagramEditDomain diagramEditDomain;

	/**
	 * sheet page associated to this editor
	 */
	private TabbedPropertySheetPage tabbedPropertySheetPage = null;

	/** Flag reflecting the editor state. The flag is set by listeners on model changes */
	private boolean toSave = false;

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
	public MultiDiagramEditor() {
		super();

		// create and stores a GMF editing domain that will be used by all editors.
		// this edit domain is the GMF one, as it inherits from DefaultEditDomain from GEF used by old Papyrus diagram editors
		// warning: there could be ClassCastException, as the default implementation cast the editor as a IDiagramWorkbenchPart
		setDiagramEditDomain(new DiagramEditDomain(this));
		// getDiagramEditDomain().setActionManager(createActionManager());
	}

	/**
	 * Create a PageEditor for the specified model. Default implementation delegates to pageEditorFactory.createPageEditorFor(model);
	 * 
	 * @param model
	 *            the diagram to be displayed
	 * @return the Graphical Editor that displays the specified diagram
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	protected IEditorPart createPageEditor(Object model) throws MultiDiagramException {
		IEditorPart part = getEditorRegistry().createEditorFor(getContextRegistry(), model);
		return part;
	}

	/**
	 * Get the contextRegistry
	 * 
	 * @return the associated context registry
	 */
	public IEditorContextRegistry getContextRegistry() {
		return editorContextRegistry;
	}

	/**
	 * Create the IEditorContextRegistry containing registered contexts. Subclass should implements this method in order to return the registry associated to the extension point namespace.
	 * 
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
	 * {@inheritDoc}
	 */
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class) {
			// Do not test if tabbedPropertySheetPage is null before calling new
			// this is managed by Eclipse which only call current method when necessary
			tabbedPropertySheetPage = new TabbedPropertySheetPage(this);

			return tabbedPropertySheetPage;
		}

		// Add a viewer
		if (adapter == IContentOutlinePage.class) {
			try {

				IContentOutlinePage contentOutline = getContentOutlineRegistry().getContentOutline();
				if (contentOutline != null)
					return contentOutline;
			} catch (BackboneException e) {
				throw new RuntimeException(e);
			}
		}

		// Add a viewer
		// if (adapter == IOverviewPage.class) {
		// if (overviewPage == null) {
		// overviewPage = new GEFOverviewPage((ScalableFreeformRootEditPart) ((GraphicalEditor) getActiveEditor()).getAdapter(EditPart.class));
		// }
		// return overviewPage;
		// }
		if (adapter == BackboneContext.class) {
			return defaultContext;
		}

		if (adapter == EditingDomain.class) {
			return defaultContext.getTransactionalEditingDomain();
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
	 * Creates actions for this editor. Subclasses should override this method to create and register actions with the {@link ActionRegistry}.
	 */
	protected void createActions() {
		ActionRegistry registry = getActionRegistry();
		IAction action;

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
		diagramNotifier = defaultContext.createDiagramNotifier();

		// Create registries
		// editorContextRegistry should be created after site, input and defaultContext are created.
		editorContextRegistry = createEditorContextRegistry();
		editorContextRegistry.registerContext("defaultContext", defaultContext);
		editorRegistry = createEditorRegistry();

		// Set editor name
		setPartName(file.getName());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void activate() {
		super.activate();
		// Start listening on diagram CRUD
		diagramNotifier.addListener(diagramChangeListener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void deactivate() {
		// Stop listening on diagrams CRUD
		diagramNotifier.removeListener(diagramChangeListener);
		super.deactivate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IEditorInput input) {
		// Create global actions from the nested editors.
		createActions();
		super.setInput(input);
	}

	/**
	 * Creates the default context used to control models life cycles.
	 * 
	 * @param site
	 *            the editor site in which multi diagram editor is created
	 * @param input
	 *            the editor input
	 * @throws BackboneException
	 *             the backbone context could not be created correctly
	 */
	private BackboneContext createDefaultContext(IEditorSite site, IEditorInput input) throws BackboneException {
		BackboneContext defaultContext = new BackboneContext();
		defaultContext.init(this);
		return defaultContext;
	}

	/**
	 * Get the root elements. This elements are used to create corresponding diagram.
	 */
	@Override
	public List<?> getModels() {
		return defaultContext.getModels();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			// Save each associated resource
			defaultContext.save(monitor);
			markSaveLocation();
		} catch (IOException ioe) {
			PapyrusTrace.log(ioe);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSaveAs() {
		// Show a SaveAs dialog
		toSave = false;
		super.firePropertyChange(PROP_DIRTY);
		Shell shell = getSite().getWorkbenchWindow().getShell();
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
									PapyrusTrace.log(ioe);
								}
							}
						});
				// set input to the new file
				setInput(new FileEditorInput(file));
				markSaveLocation();
			} catch (InterruptedException ie) {
				// should not happen, since the monitor dialog is not cancelable
				PapyrusTrace.log(ie);
			} catch (InvocationTargetException ite) {
				PapyrusTrace.log(ite);
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isSaveAsAllowed() {
		return defaultContext.isSaveAsAllowed();
	}

	/**
	 * {@inheritDoc}
	 */
	public BackboneContext getDefaultContext() {
		return defaultContext;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getContributorId() {
		// return Activator.PLUGIN_ID;
		return "TreeOutlinePage";

	}

	// FIXME: Pour Cédric modif
	/**
	 * {@inheritDoc}
	 */
	@Override
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

	@Override
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);

		// The current page of the MultiPageEditor is changing - Update contents of the overview page
		// if (overviewPage != null && overviewPage instanceof GEFOverviewPage) {
		// ((GEFOverviewPage) overviewPage).updateContents((ScalableFreeformRootEditPart) ((GraphicalEditor) getActiveEditor()).getAdapter(EditPart.class));
		// }
	}

}
