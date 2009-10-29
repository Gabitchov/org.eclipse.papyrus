package org.eclipse.papyrus.sasheditor.editor;

import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.ui.IEditorPart;

public interface ISashWindowsContainer {

	/**
	 * Get the currently active editor, or null if none is active.
	 * 
	 * @return
	 */
	public abstract IEditorPart getActiveEditor();

	/**
	 * Get the currently active SashWindows Page. This is s
	 * 
	 * @return An {@link IPage} allowing to access current page data.
	 */
	public abstract IPage getActiveSashWindowsPage();

	/**
	 * The <code>AbstractMultiPageSashEditor</code> implementation of this
	 * <code>IWorkbenchPart</code> method sets focus on the active nested editor, if there is one.
	 * <p>
	 * Subclasses may extend or reimplement.
	 * </p>
	 */
	public abstract void setFocus();

	/**
	 * Refresh the SashWindows. Synchronize the internal structure with the
	 * {@link ISashWindowsContentProvider}.
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

}