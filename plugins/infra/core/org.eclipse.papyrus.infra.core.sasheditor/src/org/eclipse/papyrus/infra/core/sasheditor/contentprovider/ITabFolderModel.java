package org.eclipse.papyrus.infra.core.sasheditor.contentprovider;

import java.util.List;

/**
 * A folder containing tabItem.
 * This interface is used to specify that a TabFolder should be drawn.
 * 
 * @author dumoulin
 * 
 * @param <ChildType>
 *        Type of the children of the folder. This is the type returned by
 *        getChildren().
 */
public interface ITabFolderModel extends IAbstractPanelModel {

	/**
	 * Get the list of children that should be displayed in the folder.
	 * 
	 * @return
	 */
	public List</*Page*/?> getChildren();

	/**
	 * Create the Interface used to access the real model.
	 * This method is called by the sashes window to get the interface.
	 * The method is called only once for a given object.
	 * 
	 * @param child
	 *        A child returned by getChildren().
	 * @return
	 */
	public IPageModel createChildSashModel(/*Page*/Object child);
}
