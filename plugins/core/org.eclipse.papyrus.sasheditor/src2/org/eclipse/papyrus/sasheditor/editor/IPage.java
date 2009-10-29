/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;

/**
 * Allows to access to properties of a Sash Page. This interface allows to read the data. User
 * should not attent to modifiy or write the data in anyway. This interface is provided as parameter
 * of the {@link IPageChangedListener#pageChanged(IPage)} event.
 * 
 * @author cedric dumoulin
 * 
 */
public interface IPage {

	/**
	 * Get the title to be shown in the tab
	 * 
	 * @return
	 */
	public String getPageTitle();

	/**
	 * Get the icon to be shown in the tab
	 * 
	 * @return
	 */
	public Image getPageIcon();

	/**
	 * Get the raw model corresponding to this node. This is the object provided to {@link
	 * ITabFolderModel.getChildren()}
	 * 
	 * @return
	 */
	public Object getRawModel();

	/**
	 * Get the control associated to this page.
	 * 
	 * @return
	 */
	public Control getControl();
}
