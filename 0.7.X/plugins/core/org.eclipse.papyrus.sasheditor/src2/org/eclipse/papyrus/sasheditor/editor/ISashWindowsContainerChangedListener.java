/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor;



/**
 * @author dumoulin
 * 
 */
public interface ISashWindowsContainerChangedListener {

	/**
	 * Method called when the container changed
	 * 
	 * @param newContainer
	 *        The new container, or null if there is no container.
	 */
	public void sashWindowsContainerChanged(ISashWindowsContainer newContainer);
}
