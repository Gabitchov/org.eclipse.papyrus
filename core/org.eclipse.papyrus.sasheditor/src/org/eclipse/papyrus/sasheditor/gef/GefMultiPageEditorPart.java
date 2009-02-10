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
package org.eclipse.papyrus.sasheditor.gef;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.sasheditor.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * Base implementation of a multipages editor suitable for GEF editors. Subclasses should
 * <ul>
 * <li>implements getModels(),</li>
 * <li>provides a suitable EditorFactory or overload createPageEditor()</li>
 * <li><EditorFactory can be set in the constructor./li>
 * <li>listen to model changes, and call refreshTabs when a change arise. Listener can be register/deregister in activate()/deactivate()</li>
 * <li>register actions to create new diagrams in the model.</li>
 * <ul>
 * 
 * @author dumoulin
 * 
 */
public abstract class GefMultiPageEditorPart extends MultiPageEditorPart implements ISelectionProvider {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** The registry holding actions associated to the main editor */
	protected ActionRegistry actionRegistry;

	/** Synchronizer object */
	private MultiPageSelectionSynchronizer synchronizer;

	/** List of listeners on SelectionChanged event */
	private List<ISelectionChangedListener> selectionListeners = new ArrayList<ISelectionChangedListener>(1);

	/** Ordered set of currently shown diagrams */
	protected List currentModels = new ArrayList();

	/** State of the editor */
	private boolean isActive;

	/**
	 * Get the models used as root of pageEditors. This method should be implemented by subclasses. Each element will be used to create an editor, if not already created.
	 * 
	 * @return the collection of diagrams to be displayed in different sub-editors
	 */
	abstract public List getModels();

	/**
	 * Create a PageEditor for the specified model.
	 * 
	 * @param model
	 *            the diagram to be displayed
	 * @return the Graphical Editor that displays the specified diagram
	 * @throws InstantiationException
	 *             Error while instanciating the editor.
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	abstract protected IEditorPart createPageEditor(Object model) throws MultiDiagramException, EditorNotFoundException, InstantiationException;

	/**
	 * Refresh the tabs order. This method should be called after the model list is modified.
	 */
	protected void refreshTabs() {
		// get list of diagrams to be displayed
		List newModels = getModels();

		// Check if each model has an open pageEditor. If not, create the editor.
		Iterator<Object> newIter = newModels.iterator();
		while (newIter.hasNext()) {
			Object model = newIter.next();
			if (!editorExistsFor(model)) { // create a new editor for the model
				addEditor(model);
			}
		}

		// If open editor count is the same has models count,
		// all models have an editor. So, end the refresh process.
		if (newModels.size() == getPageCount())
			return;

		// There is some extra editors ! remove them.
		// remove extra editors : for each open editor, check if its model is in
		// the list of required models.
		List toBeRemoved = new ArrayList();
		Iterator<Object> currentIter = currentModels.iterator();
		while (currentIter.hasNext()) {
			Object model = currentIter.next();
			if (!newModels.contains(model)) { // remove editor
				toBeRemoved.add(model);
			}
		}

		// Remove editor from the editors displayed by the multi editor
		Iterator<Object> removeIter = toBeRemoved.iterator();
		while (removeIter.hasNext()) {
			Object model = removeIter.next();
			removeEditor(model);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.MultiPageEditorPart#removePage(int)
	 */
	@Override
	public void removePage(int pageIndex) {
		super.removePage(pageIndex);
		// synchronize the list of currently shown models.
		currentModels.remove(pageIndex);
	}

	/**
	 * Removes the editor associated to the specified model.
	 * 
	 * @param model
	 *            the diagram (model) displayed in the editor
	 */
	private void removeEditor(Object model) {
		int index = currentModels.indexOf(model);
		removePage(index);
	}

	/**
	 * Add a new editor at the end of existing editors. First, create the editor, then add it to the tabs.
	 * 
	 * @param model
	 *            the diagram (model) to be displayed in the editor
	 */
	protected void addEditor(Object model) {
		// Check if an editor already exists
		int index = currentModels.indexOf(model);
		if (index >= 0) {
			if (log.isLoggable(Level.FINE))
				log.fine("Editor already exists for '" + model + "'");
			return;
		}

		try {
			IEditorPart viewer = createPageEditor(model);

			// add page and set its name
			int editorIndex = addPage(viewer, getEditorInput(), model);
			// setPageText(editorIndex, viewer.getPartName());
			setPageText(editorIndex, viewer.getTitle());
			setPageImage(editorIndex, viewer.getTitleImage());

			// set active page
			setActivePage(editorIndex);

			// synchronise list of current models. First check for consistency.
			// assert( editorIndex == currentModels.size() );
			// currentModels.add(model);

		} catch (PartInitException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage()));
		} catch (InstantiationException e) {
			e.printStackTrace();
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage() + " skip."));
		} catch (MultiDiagramException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, e.getLocalizedMessage() + " skip."));
		}
	}

	/**
	 * @see org.eclipse.ui.part.MultiPageEditorPart#addPage(int, org.eclipse.ui.IEditorPart, org.eclipse.ui.IEditorInput)
	 */
	private int addPage(IEditorPart viewer, IEditorInput editorInput, Object model) throws PartInitException {
		int index = getPageCount();
		addPage(index, viewer, editorInput, model);
		return index;
	}

	/**
	 * @param index
	 * @param editor
	 * @param input
	 * @param model
	 * @throws PartInitException
	 */
	public void addPage(int index, IEditorPart editor, IEditorInput input, Object model) throws PartInitException {
		super.addPage(index, editor, input);
		currentModels.add(index, model);
	}

	/**
	 * Check if an editor exists for the specified model.
	 * 
	 * @param model
	 *            the diagram (model) that should be displayed
	 * @return <code>true</code> if the editor exists for this model
	 */
	private boolean editorExistsFor(Object model) {
		return currentModels.contains(model);
	}

	/**
	 * Returns the first editor that displays the specified model
	 * 
	 * @param model
	 *            the model to be shown
	 * @return the first editor that displays this model or <code>null</code> if no editor was already opened for this model
	 */
	public IEditorPart findEditor(Object model) {
		int index = currentModels.indexOf(model);
		if (index > 0) {
			return getEditor(index);
		} else {
			return null;
		}
	}

	/**
	 * Returns the state of this editor.
	 * 
	 * @return <code>true</code> if the editor is active.
	 */
	protected boolean isActive() {
		return isActive;
	}

	/**
	 * Creates the pages of the multi-page editor.
	 */
	protected void createPages() {
		activate();
		refreshTabs();
	}

	/**
	 * Called when the editor should be activated. Subclass should implements this method to register listeners to the model.
	 * 
	 */
	protected void activate() {
		isActive = true;
	}

	/**
	 * Called when the editor is deactivated.
	 */
	protected void deactivate() {
		isActive = false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		selectionListeners.clear();
		if (actionRegistry != null) {
			actionRegistry.dispose();
		}
		currentModels.clear();
		super.dispose();
	}

	/**
	 * Returns the adapter for the specified key.
	 * <P>
	 * <EM>IMPORTANT</EM> certain requests, such as the property sheet, may be made before or after {@link #createPartControl(Composite)} is called. The order is unspecified by the Workbench.
	 * </P>
	 * 
	 * @param type
	 *            the type of element to be adapsted into.
	 * @return the adapted element
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class type) {
		if (type == ActionRegistry.class) {
			return getActionRegistry();
		}
		if (type == SelectionSynchronizer.class) {
			return getSelectionSynchronizer();
		}
		return super.getAdapter(type);
	}

	/**
	 * Lazily creates and returns the action registry.
	 * 
	 * @return the action registry
	 */
	protected ActionRegistry getActionRegistry() {
		if (actionRegistry == null)
			actionRegistry = new ActionRegistry();
		return actionRegistry;
	}

	/**
	 * Notifies this multi-page editor that the page with the given id has been activated. This method is called when the user selects a different tab.
	 * <p>
	 * The <code>MultiPageEditorPart</code> implementation of this method sets focus to the new page, and notifies the action bar contributor (if there is one). This checks whether the action bar
	 * contributor is an eINSTANCE of <code>MultiPageEditorActionBarContributor</code>, and, if so, calls <code>setActivePage</code> with the active nested editor. This also fires a selection change
	 * event if required.
	 * </p>
	 * <p>
	 * Subclasses may extend this method.
	 * </p>
	 * 
	 * @param newPageIndex
	 *            the index of the activated page
	 */
	@Override
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);

		// editor has changed
		IEditorPart activeEditor = getEditor(newPageIndex);
		if (activeEditor != null) {
			// set the current viewer in the synchronizer
			if (synchronizer != null && activeEditor instanceof GefPageEditor) {
				GefPageEditor editor = (GefPageEditor) activeEditor;
				getSelectionSynchronizer().setCurrentViewer(editor.getGraphicalViewer());
			}

			// Notify the new selection.
			fireSelectionChanged();
		}
	}

	/**
	 * Returns the selection synchronizer object. The synchronizer can be used to sync the selection of 2 or more EditPartViewers.
	 * 
	 * @return the syncrhonizer
	 */
	protected MultiPageSelectionSynchronizer getSelectionSynchronizer() {
		if (synchronizer == null) {
			synchronizer = new MultiPageSelectionSynchronizer();
			// Hook this editor.
			synchronizer.addViewer(this);
		}
		return synchronizer;
	}

	/**
	 * Adds a listener for selection changes in this selection provider. Has no effect if an identical listener is already registered.
	 * 
	 * @param listener
	 *            a selection changed listener
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionListeners.add(listener);
	}

	/**
	 * Returns the current selection for this provider as an IEditorPart.
	 * 
	 * @return the current selection
	 */
	public ISelection getSelection() {
		return new StructuredSelection(getActiveEditor());
	}

	/**
	 * Removes the given selection change listener from this selection provider. Has no affect if an identical listener is not registered.
	 * 
	 * @param listener
	 *            the selection changed listener to be removed
	 */
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionListeners.remove(listener);
	}

	/**
	 * Sets the current selection for this selection provider.
	 * 
	 * @param selection
	 *            the new selection
	 */
	public void setSelection(ISelection selection) {
	}

	/**
	 * Fires selection changed to the registered listeners at the time called.
	 */
	protected void fireSelectionChanged() {
		SelectionChangedEvent event = new SelectionChangedEvent(this, getSelection());
		Iterator<ISelectionChangedListener> iter = selectionListeners.iterator();
		while (iter.hasNext()) {
			ISelectionChangedListener listener = iter.next();
			listener.selectionChanged(event);
		}
	}
}
