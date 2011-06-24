/**
 * 
 */
package org.eclipse.papyrus.resource;

import java.util.ArrayList;


/**
 * A list of {@link IModelSnippet}.
 * 
 * Used by Models to maintain their list of Snippets.
 * 
 * @author cedric dumoulin
 *
 */
public class ModelSnippetList extends ArrayList<IModelSnippet> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Call the start method on all registered snippets.
	 * 
	 * @param model The model that is starting
	 */
	public void performStart(IModel model) {
		for( IModelSnippet snippet : this)
		{
			snippet.start(model);
		}
	}
	
	/**
	 * Call the start method on all registered snippets.
	 * @param model The model that is stopping
	 */
	public void performDispose(IModel model) {
		for( IModelSnippet snippet : this)
		{
			snippet.dispose(model);
		}
		
	}
}
