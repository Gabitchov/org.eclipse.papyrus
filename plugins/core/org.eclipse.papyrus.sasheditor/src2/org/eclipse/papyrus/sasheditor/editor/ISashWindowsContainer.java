package org.eclipse.papyrus.sasheditor.editor;

import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.ui.IEditorPart;

public interface ISashWindowsContainer {

	/**
	 * Get the currently active editor, or null if none is active.
	 * 
	 * @return The active editor.
	 */
	IEditorPart getActiveEditor();

	/**
	 * Get the currently active SashWindows Page. This is s
	 * 
	 * @return An {@link IPage} allowing to access current page data.
	 */
	IPage getActiveSashWindowsPage();

	/**
	 * The <code>AbstractMultiPageSashEditor</code> implementation of this
	 * <code>IWorkbenchPart</code> method sets focus on the active nested editor, if there is one.
	 * <p>
	 * Subclasses may extend or reimplement.
	 * </p>
	 */
	void setFocus();

	/**
	 * Refresh the SashWindows. Synchronize the internal structure with the
	 * {@link ISashWindowsContentProvider}.
	 */
	void refreshTabs();

	/**
	 * Add a PageChangedListener to the list of listeners.
	 * 
	 * @param pageEventsManager
	 */
	void addPageChangedListener(IPageChangedListener pageChangedListener);

	/**
	 * Remove the PageChangedListener from the list of listeners.
	 * 
	 * @param pageEventsManager
	 */
	void removePageChangedListener(IPageChangedListener pageChangedListener);

	/**
	 * Check all the opened editors to know if at least one of them is dirty.
	 * 
	 * @return True if at least one editor is dirty, false otherwise.
	 */
	boolean isDirty();

	/**
	 * Notify all the opened editor that they have been saved.
	 */
	void markSaveLocation();
}