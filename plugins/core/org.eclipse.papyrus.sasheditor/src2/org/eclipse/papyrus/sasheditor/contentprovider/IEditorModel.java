/**
 * 
 */
package org.eclipse.papyrus.sasheditor.contentprovider;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * This model indicate that an Editor should be drawn in the sash window folder.
 * @author dumoulin
 *
 */
public interface IEditorModel extends IPageModel {

	/**
	 * Create the IEditor that should be shown.
	 * Editor life cycle methods are not called.
	 * @return A new instance of the IEditor.
	 */
	public IEditorPart createIEditorPart() throws PartInitException;

	/**
	 * Get the EditorActionBarContributor that should be associated with the editor .
	 * 
	 * @return
	 */
	public EditorActionBarContributor getActionBarContributor();

}
