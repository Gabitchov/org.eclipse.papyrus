/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * An abstract implmeentation of model. This class should be subclassed to fit
 * the required model.
 * 
 * @author cedric dumoulin
 * 
 */
public abstract class AbstractBaseModel implements IModel {

	/**
	 * The associated ModelManager.
	 */
	private ModelSet modelSet;

	/**
	 * List of attached snippets.
	 */
	protected ModelSnippetList snippets = new ModelSnippetList();

	/**
	 * The associated resource.
	 */
	protected Resource resource;

	/**
	 * The resource URI.
	 */
	protected URI resourceURI;

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.IModel#init(org.eclipse.papyrus.infra.core.resource.ModelSet)
	 * 
	 * @param modelManager
	 */
	public void init(ModelSet modelManager) {
		this.modelSet = modelManager;

	}

	/**
	 * @return the modelManager
	 */
	protected ModelSet getModelManager() {
		return modelSet;
	}

	/**
	 * Get the associated ResourceSet containing the resources of this model.
	 * 
	 * @return
	 */
	protected ResourceSet getResourceSet() {
		return modelSet;
	}

	/**
	 * @return the resource
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * @return the resourceURI
	 */
	public URI getResourceURI() {
		return resourceURI;
	}

	/**
	 * Get the model identifier.
	 * 
	 * @return
	 */
	abstract public String getIdentifier();

	/**
	 * Get the file extension used by the resource.
	 * 
	 * @return
	 */
	abstract protected String getModelFileExtension();

	/**
	 * Return true if the resource is set, false otherwise. When the resource is
	 * set, this mean that the model is loaded or created.
	 * 
	 * @return
	 */
	protected boolean resourceIsSet() {
		return resource != null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.IModel#createModel(org.eclipse.core.runtime.IPath)
	 * 
	 * @param fullPath
	 */
	public void createModel(IPath fullPath) {

		// Compute model URI
		resourceURI = getPlatformURI(fullPath.addFileExtension(getModelFileExtension()));

		// Create Resource of appropriate type
		resource = getModelManager().createResource(resourceURI);
	}

	/**
	 * Get a platform resource URI of the given path
	 * 
	 * @param path
	 *        the path
	 * @return the uri
	 */
	protected URI getPlatformURI(IPath path) {
		return URI.createPlatformResourceURI(path.toString(), true);
	}

	/**
	 * Load the model repository. The URI is calculated by removing the
	 * extension and replacing it by the model extension.
	 * 
	 * @param file
	 *        The file selected by user requesting load. Should be used as a
	 *        bases to guess the model IPath.
	 */
	public void loadModel(IFile file) {
		// Get the full path and call the load method with it.
		loadModel(file.getFullPath().removeFileExtension());
	}

	/**
	 * Load the model by using the provided fullpath as a hint for the resource
	 * URI. In this implementation, simply add the model extension.
	 * 
	 * @param fullPathWithoutExtension
	 */
	public void loadModel(IPath fullPathWithoutExtension) {

		// Compute model URI
		RuntimeException error = null ;
		resourceURI = getPlatformURI(fullPathWithoutExtension.addFileExtension(getModelFileExtension()));

		// Create Resource of appropriate type
		try{
			resource = modelSet.getResource(resourceURI, true);
		}
		catch (WrappedException e){
			if (ModelUtils.isDegradedModeAllowed(e.getCause())){
				// only this case is managed in degraded mode
				resource = modelSet.getResource(resourceURI, false);
			}
			error = e ;
		}
		//see bug 397987: [Core][Save] The referenced plugin models are saved using relative path
		if(resource instanceof XMIResource){
			((XMIResource) resource).getDefaultSaveOptions().put(XMIResource.OPTION_URI_HANDLER, new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.PlatformSchemeAware());
		}
		// call registered snippets
		snippets.performStart(this);
		if (error != null){
			throw error ;
		}
	}

	/**
	 * Import the model by using the provided fullpath as a hint for the
	 * resource URI. In this implementation, simply call {@link #loadModel(IPath)}
	 * 
	 * @param fullPathWithoutExtension
	 */
	public void importModel(IPath fullPathWithoutExtension) {

		loadModel(fullPathWithoutExtension);
	}

	/**
	 * @throws IOException
	 * @see org.eclipse.papyrus.infra.core.resource.IModel#saveModel()
	 * 
	 */
	public void saveModel() throws IOException {
		if (!getModelManager().getTransactionalEditingDomain().isReadOnly(resource)
				&& !ModelUtils.resourceFailedOnLoad(resource)) {
			resource.save(null);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.IModel#changeModelPath(org.eclipse.core.runtime.IPath)
	 * 
	 * @param nameWithoutExt
	 */
	public void changeModelPath(IPath fullPath) {
		// Compute model URI
		resourceURI = getPlatformURI(fullPath.addFileExtension(getModelFileExtension()));

		resource.setURI(resourceURI);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.IModel#dispose()
	 * 
	 */
	public void unload() {
		// call registered snippets
		snippets.performDispose(this);

		// Do unloading
		if(resource != null) {
			resource.unload();
			resource = null;
		}
	}

	/**
	 * Add a snippet to this model. The snippet is called just after model is
	 * initialized, and before it is disposed or unloaded. Snippet can be shared
	 * among models.
	 * 
	 * @param snippet
	 *        The snippet to add.
	 */
	public void addModelSnippet(IModelSnippet snippet) {
		snippets.add(snippet);
	}

}
