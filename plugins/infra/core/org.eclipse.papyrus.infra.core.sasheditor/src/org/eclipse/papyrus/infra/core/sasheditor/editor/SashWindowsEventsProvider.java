/**
 * 
 */
package org.eclipse.papyrus.infra.core.sasheditor.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This class allows to listen on events coming from all the active main Editors containing
 * a  {@link SashWindowsContainer}. It send events when the active editor change and it contains 
 * a {@link SashWindowsContainer}, and when the active page of one of the container has changed.
 *  
 * <br>
 * This class allow to listen on following events:
 * <ul>
 * <li>pageChanged - a page has changed in the current container</li>
 * <li>containerChanged - the active editor has changed, and so the currently active container.</li>
 * </ul>
 * 
 * This class require the current Eclipse page in order to listen on active editor changed.
 * This class connect itself to the Workbench editor changed event. Then, it ask the current editor for a ISashWindowsContainer (using getAdaptor() ).
 * If the editor return a ISashWindowsContainer,
 * this class listen to the pageChanged events. This class takes care to connect itself to the new ISashWindowsContainer when the editor changes.
 * 
 * @TODO rename as SashWindowsEventsNotifier
 * @author cedric dumoulin
 * 
 */
public class SashWindowsEventsProvider {

	/**
	 * List of listeners that will be notified when the current Sash Page has changed.
	 */
	private PageChangedListeners pageEventsManager = new PageChangedListeners();

	/**
	 * List of listeners that will be notified when the SashWindowsContainer has changed.
	 */
	private SashWindowsContainerChangedListeners containerEventsManager = new SashWindowsContainerChangedListeners();

	/**
	 * Workbench page to which this mngr listen for {@link IEditorPart} changes.
	 */
	private IWorkbenchPage workbenchPage;

	/**
	 * The last active editor read by a call to workbenchPage.getActiveEditor();
	 */
	private IEditorPart lastActiveEditor = null;

	/**
	 * Currently active SashContainer, or null if none is active.
	 */
	private ISashWindowsContainer currentContainer = null;

	/** Currently active page, or null if no container is active */
	private IPage activePage = null;


	private IPartListener workbenchPartListener = new IPartListener() {

		public void partOpened(IWorkbenchPart part) {
			//			System.out.println("partOpened("+ part +")");

		}

		public void partDeactivated(IWorkbenchPart part) {
			//			System.out.println("partDeactivated("+ part +")");
		}

		public void partClosed(IWorkbenchPart part) {
			//			System.out.println("("+ part +")");
		}

		public void partBroughtToTop(IWorkbenchPart part) {
			//			System.out.println("partClosed("+ part +")");
		}

		public void partActivated(IWorkbenchPart part) {
			//			System.out.println("partActivated(" + part + ") - activeEditor: " + workbenchPage.getActiveEditor());
			checkActiveEditorChange();
		}
	};

	/**
	 * Permanent listener on sash pageChanged event.
	 */
	private IPageChangedListener sashPageChangedListener = new IPageChangedListener() {

		public void pageChanged(IPage newPage) {
			firePageChanged(newPage);
		}
	};

	/**
	 * 
	 * Constructor.
	 * Page can be acquired with : <code>IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();</code>
	 */
	public SashWindowsEventsProvider(IWorkbenchPage page) {

		// Initialize activePave and current Sash Container.
		init(page);
		// Register changed event listeners
		registerEditorChangedListener();
		checkActiveEditorChange();
	}

	/**
	 * Initialize the first values.
	 * 
	 * @param page
	 */
	private void init(IWorkbenchPage page) {
		if(page == null)
			throw new IllegalArgumentException("page should not be null.");

		workbenchPage = page;

		// Get the currently active container, if any.
//		ISashWindowsContainer newContainer = null;
//		IEditorPart editorPart = page.getActiveEditor();
//		if(editorPart != null) {
//			newContainer = (ISashWindowsContainer)editorPart.getAdapter(ISashWindowsContainer.class);
//		}

		//		// Set SashContainer and ActivePage
		//		currentContainer = newContainer;
		//		if( currentContainer != null)
		//		{
		//			activePage = newContainer.getActiveSashWindowsPage();
		//			System.err.println("activePage=" + activePage.getPageTitle()
		//					+ ", tab index=" + currentContainer.);
		//		}
	}

	/**
	 * Return the currently active ISashWindowsContainer or null if none is actif.
	 * 
	 * @return
	 */
	public ISashWindowsContainer activeSashWindowsContainer() {
		return currentContainer;
	}

	/**
	 * Return the currently active {@link IEditorPart} owning the currently active ISashWindowsContaineror.
	 * Return null if no container is actif.
	 * 
	 * @return
	 */
	public IEditorPart activeSashWindowsContainerOwner() {
		if(currentContainer == null)
			return null;
		return workbenchPage.getActiveEditor();
	}

	/**
	 * Return the currently active page associated to the currently active Container.
	 * Return null if no container is actif.
	 * 
	 * @return
	 */
	public IPage activeSashWindowsPage() {
		return activePage;
	}

	/**
	 * Check if the active editor has changed. If true, send appropriate event.
	 */
	private void checkActiveEditorChange() {
		// If the currently active editor has changed, send an event.
		IEditorPart editor = workbenchPage.getActiveEditor();
		if(editor != lastActiveEditor) {
			lastActiveEditor = editor;
			activeEditorChanged(editor);
		}
		lastActiveEditor = editor;
	}

	/**
	 * Dispose this manager. Cleanup listeners.
	 */
	public void dispose() {
		workbenchPage.removePartListener(workbenchPartListener);
	}

	/**
	 * Register a listener listeneing on editor change.
	 * Page can be acuired with :
	 * IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	 */
	private void registerEditorChangedListener() {

		workbenchPage.addPartListener(workbenchPartListener);
	}

	/**
	 * This method is called when the active editor has change.
	 * The method checks the new editor and send appropriate events.
	 * The editor can be null.
	 * 
	 * @param newEditor
	 *        The new editor of null if none is set.
	 */
	private void activeEditorChanged(IEditorPart newEditor) {

		// Editor has changed. It can be null.
		// Compute new container.
		ISashWindowsContainer newContainer = null;
		if(newEditor != null) {
			newContainer = (ISashWindowsContainer)newEditor.getAdapter(ISashWindowsContainer.class);
		}

		// Throw event if necessary
		if(newContainer != currentContainer)
			activeContainerChanged(newContainer);
	}

	/**
	 * This method is called when the active container has changed.
	 * The pageChangedListener is removed from the oldContainer, and attached to the newContainer.
	 * 
	 * @param newContainer
	 */
	private void activeContainerChanged(ISashWindowsContainer newContainer) {
		// Detach listener from the old container
		if(currentContainer != null)
			currentContainer.removePageChangedListener(sashPageChangedListener);

		// record new container
		currentContainer = newContainer;

		// attach listener to new container
		if(currentContainer != null) {
			currentContainer.addPageChangedListener(sashPageChangedListener);
			firePageChanged(newContainer.getActiveSashWindowsPage());
		}

		// Fire events.
		fireContainerChanged(newContainer);
		IPage newPage = (newContainer != null ? newContainer.getActiveSashWindowsPage() : null);
		firePageChanged(newPage);
	}

	/**
	 * Send an event indicating a containerChanged.
	 * Propagate the event to all the listeners.
	 * 
	 * @param activeEditor
	 */
	private void fireContainerChanged(ISashWindowsContainer newContainer) {
		// Propagate to all the listeners
		containerEventsManager.fireEvent(newContainer);
	}

	/**
	 * Send an event indicating a pageChanged.
	 * Propagate the event to all the listeners.
	 * 
	 * @param activeEditor
	 */
	private void firePageChanged(IPage newPage) {

		activePage = newPage;
		// Propagate to all the listeners
		pageEventsManager.fireEvent(newPage);
	}

	/**
	 * Add a listener on pageChanged event.
	 * 
	 * @param listener
	 */
	public void addPageChangedListener(IPageChangedListener listener) {
		pageEventsManager.addListener(listener);
	}

	/**
	 * Remove listener on pageChanged event.
	 * 
	 * @param listener
	 */
	public void removePageChangedListener(IPageChangedListener listener) {
		pageEventsManager.removeListener(listener);
	}

	/**
	 * Add a listener on pageChanged event.
	 * 
	 * @param listener
	 */
	public void addSashWindowsContainerChangedListener(ISashWindowsContainerChangedListener listener) {
		containerEventsManager.addListener(listener);
	}

	/**
	 * Remove listener on pageChanged event.
	 * 
	 * @param listener
	 */
	public void removeSashWindowsContainerChangedListener(ISashWindowsContainerChangedListener listener) {
		containerEventsManager.removeListener(listener);
	}

	/**
	 * 
	 * @author dumoulin
	 * 
	 */
	private abstract class ListenersList<Listener, Event> {

		List<Listener> listeners;

		/**
		 * Add specified listener.
		 * 
		 * @param listener
		 */
		public void addListener(Listener listener) {
			// Lazy creation
			if(listeners == null)
				listeners = new ArrayList<Listener>();

			// do not add if already present.
			if(listeners.contains(listener))
				return;

			listeners.add(listener);
		}

		/**
		 * Remove specified listener.
		 * 
		 * @param listener
		 */
		public void removeListener(Listener listener) {
			// Lazy creation
			if(listeners == null)
				return;

			listeners.remove(listener);
		}

		/**
		 * Fire the event on each listener
		 * 
		 * @param event
		 */
		public void fireEvent(Event event) {
			// Lazy creation
			if(listeners == null)
				return;

			for(Listener listener : listeners) {
				propertyChanged(listener, event);
			}
		}

		/**
		 * Call the listener appropriate property.
		 * 
		 * @param listener
		 * @param event
		 */
		public abstract void propertyChanged(Listener listener, Event event);
	}

	/**
	 * A list of {@link IPageChangedListener}.
	 * 
	 * @author dumoulin
	 * 
	 */
	public class PageChangedListeners extends ListenersList<IPageChangedListener, IPage> {

		/**
		 * Call the appropriate method on the listener.
		 * 
		 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.SashWindowsEventsProvider.ListenersList#propertyChanged(java.lang.Object, java.lang.Object)
		 * @param listener
		 * @param newPage
		 * 
		 */
		@Override
		public void propertyChanged(IPageChangedListener listener, IPage newPage) {

			try {
				listener.pageChanged(newPage);
			} catch (Exception e) {
				// catch error in case a listener send an exception.
				// Still show the exception for debug purpose
				e.printStackTrace();
			}

		}

	}

	/**
	 * A list of {@link ISashWindowsContainerChangedListener} listening on container changed event.
	 * 
	 * @author dumoulin
	 * 
	 */
	public class SashWindowsContainerChangedListeners extends ListenersList<ISashWindowsContainerChangedListener, ISashWindowsContainer> {

		/**
		 * Call the appropriate method on the listener.
		 * 
		 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.SashWindowsEventsProvider.ListenersList#propertyChanged(java.lang.Object, java.lang.Object)
		 * @param listener
		 * @param newPage
		 * 
		 */
		@Override
		public void propertyChanged(ISashWindowsContainerChangedListener listener, ISashWindowsContainer newContainer) {
			listener.sashWindowsContainerChanged(newContainer);

		}

	}

}
