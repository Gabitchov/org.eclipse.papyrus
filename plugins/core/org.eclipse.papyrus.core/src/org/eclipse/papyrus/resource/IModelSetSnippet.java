/**
 * 
 */
package org.eclipse.papyrus.resource;


/**
 * A model snippet can be used to add code that should do some stuff on a modelsManager.
 * A ModelSnippet is attached to a modelsManager, and is called after modelsManager is started and 
 * just before it is disposed.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public interface IModelSetSnippet {

	/**
	 * Called right after the model is started.
	 * @param modelsManager The modelsManager that is starting
	 */
	public void start(ModelSet modelsManager);
	
	/**
	 * Called just before the model is disposed or  unloaded.
	 * @param modelsManager The modelsManager that is starting
	 */
	public void dispose(ModelSet modelsManager);
}
