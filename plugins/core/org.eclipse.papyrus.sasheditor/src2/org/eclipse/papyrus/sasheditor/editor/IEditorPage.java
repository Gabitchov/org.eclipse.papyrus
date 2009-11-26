/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor;

import org.eclipse.ui.IEditorPart;


/**
 * Allows to access to properties of a Sash IEditor Page.
 * This interface allows to read the data. User should not attent to modifiy or write the data in anyway.
 * This interface is provided as parameter of the {@link IPageChangedListener#pageChanged(IPage)} event and
 * in the SashContainer Visitor.
 * 
 * @author cedric dumoulin
 *
 */
public interface IEditorPage extends IPage {

	/**
	 * Returns the active nested editor if there is one.
	 * 
	 * @return the active nested editor, or <code>null</code> if none
	 */
	public IEditorPart getIEditorPart();

}
