/**
 * 
 */
package org.eclipse.papyrus.resource;


/**
 * A model snippet can be used to add code that should do some stuff on a model.
 * A ModelSnippet is attached to a model, and is called after model starting and 
 * when model is disposed.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public interface IModelSnippet {

	/**
	 * Called right after the model is started.
	 * @param startingModel The model that is starting
	 */
	public void start(IModel startingModel);
	
	/**
	 * Called just before the model is disposed or  unloaded.
	 * @param stoppingModel The model that is starting
	 */
	public void dispose(IModel stoppingModel);
}
