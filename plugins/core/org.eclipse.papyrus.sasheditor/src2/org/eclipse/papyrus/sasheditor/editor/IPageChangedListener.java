/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor;



/**
 * @author cedric dumoulin
 *
 */
public interface IPageChangedListener {

	/**
	 * Method called when the page is changed
	 * @param newPage The new page, or null if there is no container.
	 */
	public void pageChanged( IPage newPage );

}
