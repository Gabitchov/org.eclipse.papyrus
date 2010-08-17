/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.lifecycleevents.IEditorInputChangedListener;
import org.eclipse.papyrus.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.core.lifecycleevents.SaveAndDirtyService;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.core.utils.ServiceUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Papyrus Model Explorer associated to one {@link IMultiDiagramEditor}.
 * This ModelExplorer is linked to one single {@link IMultiDiagramEditor}. It doesn't change its
 * source when the current Editor change. To allow to explore different Model, use a {@link ModelExplorerPageBookView}.
 * 
 */
public class ModelExplorerView extends CommonNavigator {

	/**
	 * The associated EditorPart
	 */
	private IMultiDiagramEditor editorPart;

	/**
	 * The save aservice associated to the editor.
	 */
	private ISaveAndDirtyService saveAndDirtyService;

	private TransactionalEditingDomain editingDomain;

	/**
	 * Flag to avoid reentrant call to refresh.
	 */
	private AtomicBoolean isRefreshing = new AtomicBoolean(false);

	/**
	 * Listener on {@link ISaveAndDirtyService#addInputChangedListener(IEditorInputChangedListener)}
	 */
	protected IEditorInputChangedListener editorInputChangedListener = new IEditorInputChangedListener() {
		/**
		 * This method is called when the editor input is changed from the ISaveAndDirtyService.
		 * @see org.eclipse.papyrus.core.lifecycleevents.IEditorInputChangedListener#editorInputChanged(org.eclipse.ui.part.FileEditorInput)
		 *
		 * @param fileEditorInput
		 */
		public void editorInputChanged(FileEditorInput fileEditorInput) {
			// Change the editor input.
			setPartName(fileEditorInput.getName());
		}

		/**
		 * The isDirty flag has changed, reflect its new value
		 * @see org.eclipse.papyrus.core.lifecycleevents.IEditorInputChangedListener#isDirtyChanged()
		 *
		 */
		public void isDirtyChanged() {
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
	};


	/**
	 * Undo action handler
	 */
	UndoActionHandler undoHandler;

	/**
	 * Redo action handler
	 */
	RedoActionHandler redoHandler;


	/**
	 * The {@link IPropertySheetPage} this model explorer will use.
	 */
	private IPropertySheetPage propertySheetPage = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param part
	 *        The part associated to this ModelExplorer
	 */
	public ModelExplorerView(IMultiDiagramEditor part) {
		this.editorPart = part;
		try {
			this.saveAndDirtyService =editorPart.getServicesRegistry().getService(ISaveAndDirtyService.class);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}


	protected CommonViewer createCommonViewerObject(Composite aParent) {
		return new CustomCommonViewer(getViewSite().getId(), aParent,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
	}
	@Override
	public void createPartControl(Composite aParent) {
		// TODO Auto-generated method stub
		super.createPartControl(aParent);
		getCommonViewer().setSorter(null);
		((CustomCommonViewer)getCommonViewer()).getDropAdapter().setFeedbackEnabled(true);
	
	}
	/**
	 * Return the control used to render this View
	 * 
	 * @see org.eclipse.papyrus.core.ui.pagebookview.IPageBookNestableViewPart#getControl()
	 * 
	 * @return
	 */
	public Control getControl() {
		return getCommonViewer().getControl();
	}

	@Override
	public void init(IViewSite site, IMemento aMemento) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site, aMemento);

		// Hook undo/redo action
		//		hookGlobalHistoryHandler(site);

		//		page.addPartListener(partListener);
		activate();

	}

	/**
	 * Hook the global undo/redi actions.
	 */
	private void hookGlobalHistoryHandler(IViewSite site) {
		undoHandler = new UndoActionHandler(site, null);
		redoHandler = new RedoActionHandler(site, null);

		IActionBars actionBars = site.getActionBars();

		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoHandler);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoHandler);
	}

	/**
	 * {@link ResourceSetListener} to listen and react to changes in the
	 * resource set.
	 */
	private final ResourceSetListener resourceSetListener = new ResourceSetListenerImpl() {

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			super.resourceSetChanged(event);
			handleResourceSetChanged(event);
		}
	};

	/**
	 * Run in a UI thread to avoid non UI thread exception.
	 * @param event
	 */
	private void handleResourceSetChanged(ResourceSetChangeEvent event) {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

			/**
			 * {@inheritDoc}
			 */
			public void run() {
				refresh();
			}
		});
	}

	/**
	 * refresh the view.
	 */
	public void refresh() {
		// Skip if control is disposed or not visible
		if(getControl().isDisposed() || !getControl().isVisible())
			return;

		// avoid reentrant call
		// Refresh only of we are not already refreshing.
		if(isRefreshing.compareAndSet(false, true)) {
			if(!getCommonViewer().isBusy())
				getCommonViewer().refresh();

			isRefreshing.set(false);
		}

	}

	/**
	 * Get the initial input of the viewer.
	 * 
	 * @see org.eclipse.ui.navigator.CommonNavigator#getInitialInput()
	 * 
	 * @return
	 */
	@Override
	protected Object getInitialInput() {

		if(editorPart != null) {
			return editorPart.getServicesRegistry();
		} else {
			return super.getInitialInput();
		}

	}

	/**
	 * Activate specified Part.
	 */
	private void activate() {

		if(editorPart != null) {

			try {
				this.editingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(editorPart.getServicesRegistry());
				//			this.editingDomain = EditorUtils.getTransactionalEditingDomain(editorPart.getServicesRegistry());
				// Set Viewer input if it already exist
				if(getCommonViewer() != null) {
					getCommonViewer().setInput(editorPart.getServicesRegistry());
				}
				editingDomain.addResourceSetListener(resourceSetListener);
			} catch (ServiceException e) {
				// Can't get EditingDomain, skip
			}

			// Listen to isDirty flag
			saveAndDirtyService.addInputChangedListener(editorInputChangedListener);

			// Hook 
			//			if(undoHandler != null){
			//				IUndoContext undoContext = getUndoContext(part);
			//				undoHandler.setContext(undoContext);
			//				undoHandler.update();
			//				redoHandler.setContext(undoContext);
			//				redoHandler.update();
			//			}
		}
		if(this.getCommonViewer() != null) {
			refresh();
		}

	}

	/**
	 * Get the undo context associated to the part.
	 * 
	 * @param part
	 * @return
	 */
	private IUndoContext getUndoContext(IMultiDiagramEditor part) {
		return (IUndoContext)part.getAdapter(IUndoContext.class);
	}

	/**
	 * Deactivate the Model Explorer.
	 */
	private void deactivate() {


		// deactivate global handler
		if(editorPart != null) {
			Activator.log.debug("deactivate " + editorPart.getTitle());

			// Stop Listenning to isDirty flag
			saveAndDirtyService.removeInputChangedListener(editorInputChangedListener);

			// unhook 
			//			IUndoContext undoContext = getUndoContext(editorPart);
			//			undoHandler.setContext(undoContext);
			//			undoHandler.update();
			//			redoHandler.setContext(undoContext);
			//			redoHandler.update();

		}

		editorPart = null;
		if(editingDomain != null) {
			editingDomain.removeResourceSetListener(resourceSetListener);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		deactivate();

	}

	/**
	 * Retrieves the {@link IPropertySheetPage} that his Model Explorer uses.
	 * 
	 * @return
	 */
	private IPropertySheetPage getPropertySheetPage() {
		final IMultiDiagramEditor multiDiagramEditor = EditorUtils.getMultiDiagramEditor();

		if(multiDiagramEditor != null) {
			if(propertySheetPage == null) {
				if(multiDiagramEditor instanceof ITabbedPropertySheetPageContributor) {
					ITabbedPropertySheetPageContributor contributor = (ITabbedPropertySheetPageContributor)multiDiagramEditor;
					this.propertySheetPage = new TabbedPropertySheetPage(contributor);
				}
			}
			return propertySheetPage;
		}
		return null;
	}

	/**
	 * in order to see element if the property view
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if(IPropertySheetPage.class.equals(adapter)) {
			return getPropertySheetPage();
		}

		if(IUndoContext.class.equals(adapter)) {
			// Return the IUndoContext of the currently selected editor.
			if(editorPart != null) {
				return editorPart.getAdapter(IUndoContext.class);
			}

			// Let the parent return the adapter.
		}

		if( ISaveablePart.class.equals(adapter)) {

			return saveAndDirtyService;
		}

		return super.getAdapter(adapter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return the EditingDomain used by the properties view
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * 
	 * @see org.eclipse.ui.navigator.CommonNavigator#selectReveal(org.eclipse.jface.viewers.ISelection)
	 * 
	 * @param selection
	 */
	public void selectReveal(ISelection selection) {
		if(getCommonViewer() != null) {
			getCommonViewer().setSelection(selection, true);
		}
	}


}
