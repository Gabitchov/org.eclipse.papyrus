/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor;

import java.util.logging.Logger;

import org.eclipse.papyrus.sasheditor.internal.SashContainerEventsListener;
import org.eclipse.papyrus.sasheditor.internal.SashWindowsContainer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;


/**
 * This class take care to refresh a Sash Tab (name and icon) when its model change.
 * The class listen to IEditor property change, and refresh the corresponding tab 
 * accordingly.
 * The class also listen on {@link SashWindowsContainer} page's life cycle in order to 
 * attach/remove the listener on pages. 
 * 
 * The class can be extended. 
 * 
 * @author cedric dumoulin
 *
 */
public class SashTabDecorationSynchronizer {

	/**
	 * Logger for debug purpose.
	 */
	Logger log = Logger.getLogger(this.getClass().getName() );
	
	/**
	 * The container to synchronize.
	 */
	private SashWindowsContainer container;
	
	/**
	 * Listener on Container'pages life cycle.
	 */
	SashContainerEventsListener pageLifeCycleListener = new SashContainerEventsListener() {
		
		public void pageChanged(IPage newPage) {
		}
		
		public void pageOpened(IPage page) {
			attachPage(page);
			
		}
		
		public void pageDeactivated(IPage page) {
		}
		
		public void pageClosed(IPage page) {
			detachPage(page);
			
		}
		
		public void pageActivated(IPage page) {
		}
		
		public void pageAboutToBeOpened(IPage page) {
		}
		
		public void pageAboutToBeClosed(IPage page) {
		}
	};

	/**
	 * Listener on changes of an {@link IEditorPart}
	 */
	private IPropertyListener editorPartPropertyListener = new IPropertyListener() {
		
		public void propertyChanged(Object source, int propId) {
			if(propId == IWorkbenchPart.PROP_TITLE && source instanceof IEditorPart )
			{
				refreshContainerTabForPage((IEditorPart)source);
			}
			
		}
	};

	/**
	 * 
	 * Constructor.
	 * @param container The container to synchronize.
	 * 
	 */
	public SashTabDecorationSynchronizer( SashWindowsContainer container) {
		this.container = container;
		attachContainerPages();
		attachListeners();
	}
	
	/**
	 * Detach any listeners.
	 */
	public void dispose() {
		detachListeners();
		detachContainerPages();
	}
	
	/**
	 * Attach listeners requested by the class.
	 */
	protected void attachListeners() {
		container.addLifeCycleListener(pageLifeCycleListener);
	}
	
	/**
	 * Detach listeners requested by the class.
	 */
	protected void detachListeners() {
		container.removeLifeCycleListener(pageLifeCycleListener);
	}
	
	/**
	 * Start listening on change for the specified page.
	 * @param page
	 */
	protected void attachPage(IPage page) {
		if( page instanceof IEditorPage )
		{
			log.fine("attachPage( " + page + " )");
			IEditorPage editorPage = (IEditorPage)page;
			editorPage.getIEditorPart().addPropertyListener(editorPartPropertyListener);
		}
		
	}

	/**
	 * Stop listening onchange for the specified page.
	 * @param page
	 */
	protected void detachPage(IPage page) {
		if( page instanceof IEditorPage )
		{
			log.fine("attachPage( " + page + " )");
			IEditorPage editorPage = (IEditorPage)page;
			editorPage.getIEditorPart().removePropertyListener(editorPartPropertyListener);
		}
	}

	protected void refreshContainerTabForPage(IEditorPart source) {
		// lookup page
		IPage page = container.lookupIPageByIEditorPart(source);
		refreshContainerTabForPage(page);
		
	}

	/**
	 * Refresh the tab for the specified page
	 * @param page
	 */
	protected void refreshContainerTabForPage( IPage page ) {
		container.refreshPageTab(page);
	}
	
	/**
	 * Iterate on pages owned by the container, and call detachPage for each.
	 */
	private void detachContainerPages() {
		// Visit all pages of the container.
		container.visit(new DetachVisitor());
		
	}

	/**
	 * Iterate on pages owned by the container, and call detachPage for each.
	 */
	private void attachContainerPages() {
		// Visit all pages of the container.
		container.visit(new AttachVisitor());
		
	}

	/**
	 * Visitor to visit all pages of the container and attach the page.
	 * @author dumoulin
	 *
	 */
   private class AttachVisitor implements IPageVisitor {

	public void accept(IComponentPage page) {
	}

	public void accept(IEditorPage page) {
		attachPage(page);
		
	}
	   
   }
   
	/**
	 * Visitor to visit all pages of the container and attach the page.
	 * @author dumoulin
	 *
	 */
  private class DetachVisitor implements IPageVisitor {

	public void accept(IComponentPage page) {
	}

	public void accept(IEditorPage page) {
		detachPage(page);
		
	}
	   
  }
}
