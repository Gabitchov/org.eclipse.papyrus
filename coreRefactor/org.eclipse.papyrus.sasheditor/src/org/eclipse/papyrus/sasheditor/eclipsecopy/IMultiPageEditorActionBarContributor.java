/**
 * 
 */
package org.eclipse.papyrus.sasheditor.eclipsecopy;

import org.eclipse.ui.IEditorPart;

/**
 * Interface implemented by ActionBarContributor dedicated to MultiEditor.
 * 
 * @author dumoulin
 *
 */
public interface IMultiPageEditorActionBarContributor {

	/**
	 * Sets the active page of the the multi-page editor to be the given editor. Redirect actions to the given editor if actions are not already being sent to it.
	 * <p>
	 * This method is called whenever the page changes. Subclasses must implement this method to redirect actions to the given editor (if not already directed to it).
	 * </p>
	 * 
	 * @param activeEditor
	 *            the new active editor, or <code>null</code> if there is no active page, or if the active page does not have a corresponding editor
	 */
	public abstract void setActivePage(IEditorPart activeEditor);

}