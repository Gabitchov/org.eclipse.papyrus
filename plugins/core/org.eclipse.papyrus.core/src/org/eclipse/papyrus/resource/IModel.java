/**
 * 
 */
package org.eclipse.papyrus.resource;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;


/**
 * A Model is a set of elements defined by a metamodel (preferably an EMF metamodel).
 * A root of a model is an element which have no parent (i.e. is not contained by another 
 * element of the model).
 * A model has usually only one root.
 * Elements of a model can be contained in one or several resources.
 * A model is identified by an id, usually the id from the metamodel package (ModelPackage.eCONTENT_TYPE).
 * 
 * @author cedric dumoulin
 *
 */
public interface IModel {

	/**
	 * Initialize the model and set its associated model manager.
	 * @param modelManager The associated model manager.
	 */
	public void init(ModelSet modelManager);

	/**
	 * Get the identifier identifying this model (aka: uml, notation, ...)
	 * @return
	 */
	public Object getIdentifier();

	/**
	 * Create the model repository.
	 * 
	 * @param fullPath The full path, without extension where the model should be saved.
	 */
	public void createModel(IPath fullPath);

	/**
	 * Load the model repository.
	 * 
	 * @param file The file selected by user requesting load. Should be used as a bases to guess the model IPath.
	 */
	public void loadModel(IFile file);

	/**
	 * Save the model in its repository.
	 * @throws IOException 
	 * 
	 */
	public void saveModel() throws IOException;

	/**
	 * Change the path under which the model should be save.
	 * Do not save it now !
	 * 
	 */
	public void changeModelPath(IPath fullPath);

	/**
	 * Dispose the model.
	 */
	public void unload();
	
	/**
	 * Add a snippet to this model.
	 * The snippet is called just after model is initialized, 
	 * and before it is disposed or unloaded.
	 * Snippet can be shared among models.
	 * @param snippet The snippet to add.
	 */
	public void addModelSnippet(IModelSnippet snippet);

}
