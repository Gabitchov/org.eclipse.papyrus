/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.sasheditor.internal.SashWindowsContainer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This class allows to listen on events from the {@link SashWindowsContainer}:
 * <ul>
 * <li>pageChanged - a page has changed in the current container</li>
 * <li>- containerChanged - the active editor has changed, and so the currently active container.</li>
 * </ul>
 * 
 * This class require the current page in order to listen on active editor changed.
 * This class connect itself to the Workbench editor changed event. Then, it ask the current editor for a ISashWindowsContainer (using getAdaptor() ). If the editor return a ISashWindowsContainer,
 * this class listen to the pageChanged events. This class takes care to connect itself to the new ISashWindowsContainer when the editor changes.
 * 
 * @author cedric dumoulin
 * 
 */
public class SashWindowsEventsProvider {

	private PageChangedListeners pageEventsManager = new PageChangedListeners();
	private SashWindowsContainerChangedListeners containerEventsManager = new SashWindowsContainerChangedListeners();

	/**
	 * Workbench page to which this mngr listen for editor changes.
	 */
	private IWorkbenchPage workbenchPage;
	
	/**
	 * The last active editor read by a call to workbenchPage.getActiveEditor();
	 */
	private IEditorPart lastActiveEditor = null;
	private ISashWindowsContainer currentContainer = null;

	
	private IPartListener workbenchPartListener = new IPartListener(){
	
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
			System.out.println("partActivated("+ part +") - activeEditor: " + workbenchPage.getActiveEditor());
			checkActiveEditorChange();
		}
	};
	
	/**
	 * Permanent listener on sash pageChanged event.
	 */
	private IPageChangedListener sashPageChangedListener = new IPageChangedListener(){
	
		public void pageChanged(IPage newPage) {
			firePageChanged(newPage);
		}
	};
	/**
	 * 
	 * Constructor.
	 * Page can be acquired with : 
	 * <code>IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();</code>
	 */
	public SashWindowsEventsProvider(IWorkbenchPage page) {
		
		registerEditorChangedListener(page);
		checkActiveEditorChange();
	}
	
	/**
	 * Check if the active editor has changed. If true, send appropriate event.
	 */
	private void checkActiveEditorChange() {
		// If the currently active editor has changed, send an event.
		IEditorPart editor = workbenchPage.getActiveEditor();
		if( editor != lastActiveEditor)
		{
		  lastActiveEditor = editor;
		  activeEditorChanged(editor);
		}
		lastActiveEditor = editor;
	}

	/**
	 * Dispose this manager. Cleanup listeners.
	 */
	public void dispose()
	{
		workbenchPage.removePartListener(workbenchPartListener);
	}
	
	/**
	 * Register a listener listeneing on editor change.
	 * Page can be acuired with : 
	 * IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	 */
	private void registerEditorChangedListener(IWorkbenchPage page) {
		
		if(page == null)
			throw new IllegalArgumentException("page should not be null.");
		
		workbenchPage = page;
		page.addPartListener( workbenchPartListener);
	}

	/**
	 * This method is called when the active editor has change.
	 * The method check the new editor and send appropriate events.
	 */
	private void activeEditorChanged(IEditorPart newEditor) {
		
		System.out.println("activeEditorChanged(" + newEditor + ")");
		ISashWindowsContainer newContainer = (ISashWindowsContainer)newEditor.getAdapter(ISashWindowsContainer.class);
		
		if( newContainer != currentContainer)
			activeContainerChanged(newContainer);
	}
	
	/**
	 * This method is called when the active container has changed.
	 * The pageChangedListener is removed from the oldContainer, and attached to the newContainer.
	 * @param newContainer
	 */
	private void activeContainerChanged( ISashWindowsContainer newContainer)
	{
		// Detach listener from the old container
		if(currentContainer!=null)
		  currentContainer.removePageChangedListener(sashPageChangedListener);
		
		// record new container
		currentContainer = newContainer;
		
		// attach listener to new container
		if(currentContainer!=null)
		{
		  currentContainer.addPageChangedListener(sashPageChangedListener);
		  firePageChanged(newContainer.getActiveSashWindowsPage());
		}
		
		// Fire events.
		fireContainerChanged(newContainer);
		IPage newPage = (newContainer!=null?newContainer.getActiveSashWindowsPage():null);
		firePageChanged(newPage);
	}
	
	/**
	 * Send an event indicating a containerChanged.
	 * Propagate the event to all the listeners.
	 * @param activeEditor
	 */
	private void fireContainerChanged(ISashWindowsContainer newContainer) {
		System.out.println("fireContainerChanged("+ newContainer +")");
		// Propagate to all the listeners
		containerEventsManager.fireEvent(newContainer);
	}

	/**
	 * Send an event indicating a pageChanged.
	 * Propagate the event to all the listeners.
	 * @param activeEditor
	 */
	private void firePageChanged(IPage newPage) {
		
		System.out.println("event mngr firePageChanged("+ newPage +")");		
		// Propagate to all the listeners
		pageEventsManager.fireEvent(newPage);
	}

	/**
	 * Add a listener on pageChanged event.
	 * @param listener
	 */
	public void addPageChangedListener(IPageChangedListener listener)
	{
		pageEventsManager.addListener(listener);
	}
	
	/**
	 * Remove listener on pageChanged event.
	 * @param listener
	 */
	public void removePageChangedListener(IPageChangedListener listener)
	{
		pageEventsManager.removeListener(listener);
	}
	
	/**
	 * Add a listener on pageChanged event.
	 * @param listener
	 */
	public void addSashWindowsContainerChangedListener(ISashWindowsContainerChangedListener listener)
	{
		containerEventsManager.addListener(listener);
	}
	
	/**
	 * Remove listener on pageChanged event.
	 * @param listener
	 */
	public void removeSashWindowsContainerChangedListener(ISashWindowsContainerChangedListener listener)
	{
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
		 * @param listener
		 */
		public void addListener( Listener listener)
		{
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
		 * @param listener
		 */
		public void removeListener(Listener listener)
		{
			// Lazy creation
			if(listeners == null)
				return;
			
			listeners.remove(listener);
		}
		
		/**
		 * Fire the event on each listener
		 * @param event
		 */
		public void fireEvent(Event event)
		{
			// Lazy creation
			if(listeners == null)
				return;
			
			for( Listener listener : listeners)
			{
				propertyChanged(listener, event);
			}
		}
		
		/**
		 * Call the listener appropriate property.
		 * @param listener
		 * @param event
		 */
		public abstract void propertyChanged( Listener listener, Event event);
	}
	
	/**
	 * A list of {@link IPageChangedListener}. 
	 * @author dumoulin
	 *
	 */
	public class PageChangedListeners extends ListenersList<IPageChangedListener, IPage> 
	{

		/**
		 * Call the appropriate methid on the listener.
		 * @see org.eclipse.papyrus.sasheditor.editor.SashWindowsEventsProvider.ListenersList#propertyChanged(java.lang.Object, java.lang.Object)
		 * @param listener
		 * @param newPage
		 *
		 */
		@Override
		public void propertyChanged(IPageChangedListener listener, IPage newPage) {
			listener.pageChanged(newPage);
			
		}
		
	}
	
	/**
	 * A list of {@link ISashWindowsContainerChangedListener} listening on container changed event.
	 * @author dumoulin
	 *
	 */
	public class SashWindowsContainerChangedListeners extends ListenersList<ISashWindowsContainerChangedListener, ISashWindowsContainer> 
	{

		/**
		 * Call the appropriate method on the listener.
		 * @see org.eclipse.papyrus.sasheditor.editor.SashWindowsEventsProvider.ListenersList#propertyChanged(java.lang.Object, java.lang.Object)
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
