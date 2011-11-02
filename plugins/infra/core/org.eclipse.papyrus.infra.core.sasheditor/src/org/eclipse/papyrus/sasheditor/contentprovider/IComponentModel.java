/**
 * 
 */
package org.eclipse.papyrus.sasheditor.contentprovider;

import org.eclipse.swt.widgets.Composite;

/**
 * This model represent a ui Component to be shown in a sash window folder.
 * 
 * @author dumoulin
 * 
 */
public interface IComponentModel extends IPageModel {

	/**
	 * Create the Control corresponding to this model.
	 * 
	 * @param parent
	 *        The parent of the created container.
	 * @return
	 */
	public Composite createPartControl(Composite parent);

}
