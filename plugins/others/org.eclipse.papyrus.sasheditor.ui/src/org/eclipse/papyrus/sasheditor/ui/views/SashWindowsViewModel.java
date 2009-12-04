/**
 * 
 */
package org.eclipse.papyrus.sasheditor.ui.views;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.sasheditor.editor.IPage;
import org.eclipse.papyrus.sasheditor.editor.IPageChangedListener;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainerChangedListener;
import org.eclipse.papyrus.sasheditor.editor.SashWindowsEventsProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;


/**
 * The model (from MVC) storing data to be shown by the ui.
 * Data owned :
 * <ul>
 * <li>selected element</li>
 * <li>current page (tabfolder)</li>
 * <li>current folder</li>
 * <li>current eclipse editor</li>
 * </ul>
 * 
 * A faire:
 * - ecouter les evenements sash
 * - ecouter les evenements Eclipse selectionChanged
 * - envoyer evenement qd une valeur a change
 * - creer la classe ModelEvent indiquant le type d'evenement ?
 * - creer l'interface IModelEventListener permettant d'ecouter les events du model.
 * Q: une methode par event, ou alors un type dans l'event ?
 * - Completer la classe View avec la UI
 * - Completer ViewPart pour mettre le model et la UI en relation.
 * 
 * Regarder les exemples dans SashWindowsViewOrig
 * 
 * @author cedric dumoulin
 * 
 */
public class SashWindowsViewModel {



	/**
	 * Interface implemented by classes wishing to be called when a change happen in the model.
	 * 
	 * @author cedric dumoulin
	 * 
	 */
	public interface IModelChangedListener {

		/**
		 * This method is called when a value has changed in the model.
		 * 
		 * @param changedModel
		 *        The model that has changed.
		 */
		public void modelChanged(SashWindowsViewModel changedModel);

	}

	/**
	 * List of listeners on model changed events.
	 */
	private ListenersManager listenersManager = new ListenersManager();


	/** Object providing events on SashWindows life cycle. */
	private SashWindowsEventsProvider sashWindowEventsManager;

	/** Current editor shown by the view, or null */
	private IEditorPart currentEditor = null;

	/** The last selected element, or null */
	private Object selectedElement = null;

	/**
	 * Listener on Eclipse selection changed.
	 */
	private ISelectionChangedListener selectionChangedListener = new ISelectionChangedListener() {

		public void selectionChanged(SelectionChangedEvent event) {
			System.out.println(SashWindowsViewModel.this.getClass().getSimpleName() + ".selectionChanged(" + event + ")");

			SashWindowsViewModel.this.selectionChanged(event.getSelection());
		}
	};

	/**
	 * Listener listening on pageChanged event.
	 */
	private IPageChangedListener pageChangedListener = new IPageChangedListener() {

		public void pageChanged(IPage newPage) {
			System.out.println(SashWindowsViewModel.this.getClass().getSimpleName() + ".pageChanged(" + newPage + ")");
			selectionChanged();
		}
	};

	/**
	 * Listener listening on containerChanged event.
	 */
	private ISashWindowsContainerChangedListener containerChangedListener = new ISashWindowsContainerChangedListener() {

		public void sashWindowsContainerChanged(ISashWindowsContainer newContainer)
			{
			// Get the active editor, which should be the one owning the new page
			// Set it to null if the container is null.
			System.out.println(SashWindowsViewModel.this.getClass().getSimpleName() + ".sashWindowsContainerChanged(" + newContainer + ")");

			reconnectSelectionListener();
		}
	};



	/**
	 * 
	 * Constructor.
	 * 
	 * @param workbenchPage
	 */
	public SashWindowsViewModel(IWorkbenchPage workbenchPage) {
		sashWindowEventsManager = new SashWindowsEventsProvider(workbenchPage);

		activateIncomingEventListeners();
	}

	/**
	 * Dispose this model.
	 * All resources are cleaned. The model should not be used again.
	 */
	public void dispose() {
		deactivateIncomingEventListeners();
		sashWindowEventsManager.dispose();
		listenersManager.clear();
	}


	/**
	 * Get the listener manager allowing to register / remove listeners.
	 * 
	 * @return the listenersManager
	 */
	public ListenersManager getListenersManager() {
		return listenersManager;
	}

	/**
	 * Activate listeners on incoming events.
	 */
	private void activateIncomingEventListeners() {
		sashWindowEventsManager.addPageChangedListener(pageChangedListener);
		sashWindowEventsManager.addSashWindowsContainerChangedListener(containerChangedListener);
		reconnectSelectionListener();
	}

	/**
	 * Activate listeners on incoming events.
	 */
	private void deactivateIncomingEventListeners() {
		disconnectSelectionListener();
		sashWindowEventsManager.removePageChangedListener(pageChangedListener);
		sashWindowEventsManager.removeSashWindowsContainerChangedListener(containerChangedListener);
	}

	/**
	 * Connect the selection listener to the current IEditor (Eclipse editor).
	 * Remove the listener from the previous editor if it is attached.
	 */
	private void reconnectSelectionListener() {
		// Remove listening on all editor
		if(currentEditor != null) {
			currentEditor.getSite().getSelectionProvider().removeSelectionChangedListener(selectionChangedListener);
		}

		currentEditor = sashWindowEventsManager.activeSashWindowsContainerOwner();
		if(currentEditor != null) {
			currentEditor.getSite().getSelectionProvider().addSelectionChangedListener(selectionChangedListener);
		}
	}

	/**
	 * Remove the listener from the previous editor if it is attached.
	 */
	private void disconnectSelectionListener() {
		// Remove listening on all editor
		if(currentEditor != null) {
			currentEditor.getSite().getSelectionProvider().removeSelectionChangedListener(selectionChangedListener);
		}
	}

	/**
	 * Trigger the event to registered listeners
	 */
	private void fireChangedEvent() {
		listenersManager.fireChangedEvent(this);
	}

	/**
	 * This method is called when the selection has changed.
	 * This method lookup the selection.
	 * TODO Hook this to Container changed instead of selection changed.
	 */
	private void selectionChanged() {
		IEditorPart activeEditor = sashWindowEventsManager.activeSashWindowsContainerOwner();
		// Check if there is an active editor.
		if(activeEditor == null) {
			selectionChanged(null);
			return;
		}

		// Set the active selection
		ISelection selection = activeEditor.getSite().getSelectionProvider().getSelection();
		selectionChanged(selection);
	}

	/**
	 * The selection has changed.
	 * 
	 * @param selection
	 */
	protected void selectionChanged(ISelection selection) {

		if(selection instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			selectedElement = structuredSelection.getFirstElement();
		} else {
			selectedElement = selection;
		}

		// Fire changed event.
		fireChangedEvent();
	}


	/**
	 * Get the currently first selected element.
	 * 
	 * @return The currently first selected element, or null if none is selected.
	 */
	public Object getSelectedElement() {
		return selectedElement;
	}

	/**
	 * Get the currently selected SashWindows Page
	 * 
	 * @return The currently selected SashWindows Page, or null if none is selected.
	 */
	public IPage getSelectedSashWindowsPage() {
		return sashWindowEventsManager.activeSashWindowsPage();
	}

	//	/**
	//	 * Get the currently selected SashWindows Folder 
	//	 * @return The currently selected SashWindows Page, or null if none is selected.
	//	 */
	//	public IFolder getSelectedSashWindowsFolder() 
	//	{
	//		return sashWindowEventsManager.SashWindowsFolder();		
	//	}

	/**
	 * Get the currently selected SashWindows Page (IE.
	 * 
	 * @return The currently selected SashWindows Page, or null if none is selected.
	 */
	public IEditorPart getSelectedIEditorPart() {
		return sashWindowEventsManager.activeSashWindowsContainerOwner();

	}

	/**
	 * Class used to register Listener and to send events to these listeners.
	 * 
	 * @author cedric dumoulin
	 * 
	 */
	public class ListenersManager extends ArrayList<IModelChangedListener> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Add a listener that will be notified when the fireChangedEvent() method is called.
		 * 
		 * @param listener
		 */
		public void addModelChangedListener(IModelChangedListener listener) {
			add(listener);
		}

		/**
		 * Remove a listener.
		 * 
		 * @param listener
		 */
		public void removeModelChangedListener(IModelChangedListener listener) {
			remove(listener);
		}

		/**
		 * Fire the event to all registered listeners.
		 */
		public void fireChangedEvent(SashWindowsViewModel changedModel) {
			for(IModelChangedListener listener : this) {
				listener.modelChanged(changedModel);
			}
		}
	}
}
