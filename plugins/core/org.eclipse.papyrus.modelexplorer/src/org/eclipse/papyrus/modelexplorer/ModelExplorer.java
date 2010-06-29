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

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Papyrus Model Explorer.
 * 
 * This model explorer is linked to Papyrus editors.
 * @deprecated Use {@link ModelExplorerView} instead.
 */
public class ModelExplorer extends CommonNavigator /* implements IEditingDomainProvider */{

	private IMultiDiagramEditor editorPart;

	private TransactionalEditingDomain editingDomain;

	private IWorkbenchPage page = null;


	/**
	 * Listener on parts lifecycle.
	 * This listener is called whenever an event happens
	 */
	private IPartListener2 partListener = new IPartListener2() {

		public void partActivated(IWorkbenchPartReference partRef) {
			handlePartActivated(partRef);
		}

		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}

		public void partClosed(IWorkbenchPartReference partRef) {
			handlePartDeactivated(partRef);
		}

		public void partDeactivated(IWorkbenchPartReference partRef) {
			//			handlePartDeactivated(partRef);
		}

		public void partHidden(IWorkbenchPartReference partRef) {
		}

		public void partInputChanged(IWorkbenchPartReference partRef) {
			handlePartActivated(partRef);
		}

		public void partOpened(IWorkbenchPartReference partRef) {
			handlePartActivated(partRef);
		}

		public void partVisible(IWorkbenchPartReference partRef) {
			handlePartActivated(partRef);
		}

	};;

	/**
	 * The {@link IPropertySheetPage} this model explorer will use.
	 */
	private IPropertySheetPage propertySheetPage = null;

	public void selectReveal(ISelection selection) {
		if(getCommonViewer() != null) {
			getCommonViewer().setSelection(selection, true);
		}
	}

	public ModelExplorer() {
	}

	@Override
	public void init(IViewSite site, IMemento aMemento)
			throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site, aMemento);
		page = site.getPage();


		// Hook undo/redo action
		//		hookGlobalHistoryHandler(site);

		page.addPartListener(partListener);
		activate();

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

	// a revoir eviter de rafrachier le root
	private void handleResourceSetChanged(ResourceSetChangeEvent event) {
		getCommonViewer().refresh();
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

		IMultiDiagramEditor part = EditorUtils.getMultiDiagramEditor();
		if(part != null) {
			return part.getServicesRegistry();
		} else {
			return super.getInitialInput();
		}

	}

	/**
	 * Activate the Model Explorer.
	 * Lookup for the associated {@link IMultiDiagramEditor}
	 */
	private void activate() {

		IMultiDiagramEditor part = EditorUtils.getMultiDiagramEditor();
		if(part != null)
			activate(part);
	}

	/**
	 * Activate specified Part.
	 */
	private void activate(IMultiDiagramEditor part) {

		System.out.println("activate " + part.getTitle());
		// Skip if there is no change.
		if(part == editorPart)
			return;

		this.editorPart = part;

		if(part != null) {
			this.editingDomain = EditorUtils.getTransactionalEditingDomain(part.getServicesRegistry());


			if(editingDomain != null) {

				// Set Viewer input if it already exist
				if(getCommonViewer() != null) {
					getCommonViewer().setInput(part.getServicesRegistry());
				}
				editingDomain.addResourceSetListener(resourceSetListener);
			}

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
			this.getCommonViewer().refresh();
		}

	}

	/**
	 * Deactivate the Model Explorer.
	 */
	private void deactivate() {


		// deactivate global handler
		if(editorPart != null) {
			System.out.println("deactivate " + editorPart.getTitle());
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

	/**
	 * An {@link IWorkbenchPart} has been deactivated, refresh.
	 * 
	 * @param partRef
	 */
	private void handlePartDeactivated(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		if(editorPart != null && editorPart.equals(part)) {
			deactivate();
		}
	}

	/**
	 * A new {@link IWorkbenchPart} has been activated, refresh.
	 * 
	 * @param partRef
	 */
	private void handlePartActivated(IWorkbenchPartReference partRef) {
		final IWorkbenchPart part = partRef.getPart(false);




		if(part instanceof IMultiDiagramEditor) {
			activate((IMultiDiagramEditor)part);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		deactivate();
		page.removePartListener(partListener);

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
}
