package org.eclipse.papyrus.infra.core.sasheditor.editor;

import java.util.List;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.ui.IEditorPart;

public interface ISashWindowsContainer {

	/**
	 * Get the currently active editor, or null if none is active.
	 * 
	 * @return
	 */
	public abstract IEditorPart getActiveEditor();

	/**
	 * Get the currently active SashWindows Page.
	 * This is s
	 * 
	 * @return An {@link IPage} allowing to access current page data.
	 */
	public abstract IPage getActiveSashWindowsPage();

	/**
	 * Get the {@link ITabFolderModel} of the currently selected folder.
	 * 
	 * @return
	 */
	public ITabFolderModel getSelectedTabFolderModel();

	/**
	 * Get the list of visible IPages. The visible IPages are the one that have there diagram area 
	 * visible.
	 * 
	 * @return
	 */
	public List<IPage> getVisiblePages();

	/**
	 * Get the list of visible IEditorPart obtain from the pages of type IEditorPage. 
	 * The visible IPages are the one that have there diagram area 
	 * visible.
	 * 
	 * @return
	 */
	public List<IEditorPart> getVisibleIEditorParts();
	
	/**
	 * The <code>AbstractMultiPageSashEditor</code> implementation of this <code>IWorkbenchPart</code> method sets focus on the active nested
	 * editor, if there is one.
	 * <p>
	 * Subclasses may extend or reimplement.
	 * </p>
	 */
	public abstract void setFocus();

	/**
	 * Refresh the SashWindows.
	 * Synchronize the internal structure with the {@link ISashWindowsContentProvider}.
	 */
	public abstract void refreshTabs();

	/**
	 * Add a PageChangedListener to the list of listeners.
	 * 
	 * @param pageEventsManager
	 */
	public abstract void addPageChangedListener(IPageChangedListener pageChangedListener);

	/**
	 * Remove the PageChangedListener from the list of listeners.
	 * 
	 * @param pageEventsManager
	 */
	public abstract void removePageChangedListener(IPageChangedListener pageChangedListener);

	/**
	 * Add a listener on Page LifeCycle events.
	 * This implementation delegates to the internal PageTracker.
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer#addPageChangedListener(org.eclipse.papyrus.infra.core.sasheditor.editor.IPageChangedListener)
	 * @param listener
	 * 
	 */
	public void addPageLifeCycleListener(IPageLifeCycleEventsListener listener);

	/**
	 * Remove a listener on Page LifeCycle events.
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer#removePageChangedListener(org.eclipse.papyrus.infra.core.sasheditor.editor.IPageChangedListener)
	 * @param listener
	 * 
	 */
	public void removePageLifeCycleListener(IPageLifeCycleEventsListener listener);
	/**
	 * Set a {@link MenuManager} used to manage a contextual menu that is shown on the tabs area of the folders.
	 * @param menuManager The {@link MenuManager} used to create the menu on the tab area.
	 */
	public abstract void setFolderTabMenuManager( MenuManager menuManager );

	public abstract IPage lookupIPageByIEditorPart(IEditorPart editor);

	public abstract IPage lookupModelPage(Object rawModel);

	public abstract void selectPage(IPage page);

	public abstract void visit(IPageVisitor pageVisitor);
}
