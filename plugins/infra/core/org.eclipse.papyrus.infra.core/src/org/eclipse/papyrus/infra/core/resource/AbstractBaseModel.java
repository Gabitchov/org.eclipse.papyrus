/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.PlatformSchemeAware;
import org.eclipse.papyrus.infra.core.Activator;

/**
 * An abstract implmeentation of model. This class should be subclassed to fit
 * the required model.
 * 
 * @author cedric dumoulin
 * 
 */
public abstract class AbstractBaseModel implements IVersionableModel {

	public static final String ENCODING = "UTF-8"; //$NON-NLS-1$

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
		configureResource(resource);
	}

	protected void configureResource(Resource resource) {
		if(resource instanceof XMIResource) {
			((XMIResource)resource).getDefaultSaveOptions().putAll(getSaveOptions());
			((XMIResource)resource).setEncoding(ENCODING);
		}
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
		RuntimeException error = null;
		resourceURI = getPlatformURI(fullPathWithoutExtension.addFileExtension(getModelFileExtension()));

		// Create Resource of appropriate type
		try {
			resource = modelSet.getResource(resourceURI, true);
		} catch (WrappedException e) {
			if(ModelUtils.isDegradedModeAllowed(e.getCause())) {
				// only this case is managed in degraded mode
				resource = modelSet.getResource(resourceURI, false);
			}
			error = e;
		}

		configureResource(resource);
		// call registered snippets
		snippets.performStart(this);
		if(error != null) {
			throw error;
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
		if(!getModelManager().getTransactionalEditingDomain().isReadOnly(resource) && !ModelUtils.resourceFailedOnLoad(resource)) {
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

	protected Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = new HashMap<Object, Object>();

		// default save options.
		saveOptions.put(XMIResource.OPTION_DECLARE_XML, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_PROCESS_DANGLING_HREF, XMIResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SKIP_ESCAPE_URI, Boolean.FALSE);
		saveOptions.put(XMIResource.OPTION_ENCODING, "UTF-8");

		//see bug 397987: [Core][Save] The referenced plugin models are saved using relative path
		saveOptions.put(XMIResource.OPTION_URI_HANDLER, new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.PlatformSchemeAware());

		return saveOptions;
	}


	public void saveCopy(IPath targetPathWithoutExtension, Map<Object, Object> targetMap) {
		//		OutputStream targetStream = getOutputStream(targetPath);
		Map<Object, Object> saveOptions = new HashMap<Object, Object>();

		URI targetURI = getTargetURI(targetPathWithoutExtension);

		saveOptions.put(XMIResource.OPTION_URI_HANDLER, new SaveCopyURIHandlerImp(targetMap, targetURI));
		try {
			OutputStream outputStream = modelSet.getURIConverter().createOutputStream(targetURI);
			resource.save(outputStream, saveOptions);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
		//	resource.save(targetStream, options);
	}

	public void fillTargetMap(IPath targetPathWithoutExtension, Map<Object, Object> targetMap) {
		targetMap.put(getResourceURI(), getTargetURI(targetPathWithoutExtension));
	}

	protected URI getTargetURI(IPath targetPathWithoutExtension) {
		String resourceSegment = resourceURI.lastSegment();
		int index = resourceSegment.lastIndexOf(".");
		if(index > -1) {
			String extension = resourceSegment.substring(index + 1);
			IPath targetPath = targetPathWithoutExtension.addFileExtension(extension);

			URI targetURI;
			if(targetPath.getDevice() == null) {
				targetURI = URI.createPlatformResourceURI(targetPath.toOSString(), true);
			} else {
				targetURI = URI.createFileURI(targetPath.toString());
			}
			return targetURI;
		}

		return null;
	}

	public URI getURI() {
		return resource.getURI();
	}

	protected class SaveCopyURIHandlerImp extends PlatformSchemeAware {

		private Map<Object, Object> targetMap;

		private URI targetURI;

		public SaveCopyURIHandlerImp(Map<Object, Object> targetMap, URI targetURI) {
			this.targetMap = targetMap;
			this.targetURI = targetURI;
		}

		@Override
		public void setBaseURI(URI baseURI) {
			//We're saving to a different target URI. Ignore the call to setBaseURI.
			super.setBaseURI(targetURI);
		}

		@Override
		public URI deresolve(URI uri) {
			URI resourceURI = uri.trimFragment();

			//Do not map our own URI
			if(!AbstractBaseModel.this.resourceURI.equals(resourceURI)) {
				if(targetMap.containsKey(resourceURI)) {
					Object target = targetMap.get(resourceURI);
					if(target instanceof URI) {
						URI targetURI = (URI)target;
						if(uri.fragment() != null) {
							targetURI = targetURI.appendFragment(uri.fragment());
						}
						return targetURI;
					}
				}
			}

			return super.deresolve(uri);
		}

	}

}
