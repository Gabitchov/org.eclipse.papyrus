/**
 * 
 */
package org.eclipse.papyrus.infra.core.sasheditor.internal;

import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageChangedListener;
import org.eclipse.papyrus.infra.core.sasheditor.editor.SashWindowsContainer;

/**
 * Interface to be implemented by listeners on {@link SashWindowsContainer} life
 * cycle events.
 * 
 * @author cedric dumoulin
 * 
 */
public interface SashContainerEventsListener extends IPageChangedListener {

	/**
	 * 
	 * @param page
	 *        The page firing the event.
	 */
	public void pageOpened(IPage page);

	/**
	 * 
	 * @param page
	 *        The page firing the event.
	 */
	public void pageClosed(IPage page);

	/**
	 * The specify page is activated. It become the current active page.
	 * 
	 * @param page
	 *        The page firing the event.
	 */
	public void pageActivated(IPage page);

	/**
	 * The specify page is deactivated.
	 * 
	 * @param page
	 *        The page firing the event.
	 */
	public void pageDeactivated(IPage page);

	/**
	 * 
	 * @param page
	 *        The page firing the event.
	 */
	public void pageAboutToBeOpened(IPage page);

	/**
	 * 
	 * @param page
	 *        The page firing the event.
	 */
	public void pageAboutToBeClosed(IPage page);
}
