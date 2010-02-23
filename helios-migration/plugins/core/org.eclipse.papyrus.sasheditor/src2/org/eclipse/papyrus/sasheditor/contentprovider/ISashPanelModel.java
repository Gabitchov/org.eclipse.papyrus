package org.eclipse.papyrus.sasheditor.contentprovider;

import java.util.List;

/**
 * A sash node contains two children separated by a sash. The sash can be moved, resizing the children.
 * This interface is used to specify that a sash with two children should be drawn.
 * 
 * @author dumoulin
 * 
 */
public interface ISashPanelModel extends IAbstractPanelModel {

	/**
	 * Get the list of children that should be displayed in the folder.
	 * 
	 * @return
	 */
	public List<?> getChildren();

	/**
	 * Create the Interface used to access the real model.
	 * This method is called by the sashes window to get the interface.
	 * The method is called only once for a given object.
	 * 
	 * @param child
	 *        A child returned by getChildren().
	 * @return
	 */
	public IAbstractPanelModel createChildSashModel(Object child);

	/**
	 * Get the sash direction. Can be SWT.VERTICAL or SWT.HORIZONTAL.
	 */
	public int getSashDirection();

}
