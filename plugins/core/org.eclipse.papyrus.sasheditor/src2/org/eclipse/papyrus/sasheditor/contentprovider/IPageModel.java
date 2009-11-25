/**
 * 
 */
package org.eclipse.papyrus.sasheditor.contentprovider;

import org.eclipse.swt.graphics.Image;

/**
 * This interface is the root of the hierarchy of models representing Pages.
 * This represent the final element shown in the sashes window.
 * It can be an Editor or a simple control.
 * This interface is used by the sashes window to interact with the model describing the element to be
 * shown in the TabItem.
 * 
 * @author dumoulin
 * 
 */
public abstract interface IPageModel {

	/**
	 * Get the title to be shown in the tab
	 * 
	 * @return
	 */
	public String getTabTitle();

	/**
	 * Get the icon to be shown in the tab
	 * 
	 * @return
	 */
	public Image getTabIcon();

	/**
	 * Get the raw model corresponding to this node.
	 * This is the object provided to {@link ITabFolderModel.getChildren()}
	 * 
	 * @return
	 */
	public Object getRawModel();

}
