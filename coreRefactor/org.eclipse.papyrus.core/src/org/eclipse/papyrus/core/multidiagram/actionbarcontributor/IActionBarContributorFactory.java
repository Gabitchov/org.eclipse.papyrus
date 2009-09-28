/**
 * 
 */
package org.eclipse.papyrus.core.multidiagram.actionbarcontributor;

import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.ui.part.EditorActionBarContributor;


/**
 * Interface used to get an ActionBarContributor from its ID.
 * @author dumoulin
 *
 */
public interface IActionBarContributorFactory {

	/**
	 * Get an ActionBarContributor by its key.
	 * If an ActionBarContributor already exists for this key, return it.
	 * @param key
	 * @return
	 */
	public EditorActionBarContributor getActionBarContributor(Object key) throws BackboneException;
}
