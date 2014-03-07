/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA) - manage models by URI, not IFile (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
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
public abstract class AbstractBaseModel extends AbstractModel implements IVersionableModel, IEMFModel {

	/**
	 * The associated resource.
	 */
	protected Resource resource;

	/**
	 * The resource URI.
	 */
	protected URI resourceURI;

	/**
	 * @return the resource
	 */
	@Override
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
	@Override
	@Deprecated
	public void createModel(IPath fullPath) {

		createModel(getPlatformURI(fullPath));
	}

	@Override
	public void createModel(URI uri) {
		// Compute model URI
		resourceURI = uri.appendFileExtension(getModelFileExtension());

		// Create Resource of appropriate type
		ModelSet modelSet = getModelManager();
		resource = modelSet.getResource(resourceURI, false);
		if(resource != null) {
			// it already exists? Best effort to make sure it's loaded
			try {
				modelSet.getResource(resourceURI, true);
			} catch (RuntimeException e) {
				// it commonly happens when creating a new model in the
				// workspace that the wizard creates an empty file, first.
				Map<String, ?> attributes = modelSet.getURIConverter().getAttributes(resourceURI, Collections.singletonMap(URIConverter.OPTION_REQUESTED_ATTRIBUTES, Collections.singleton(URIConverter.ATTRIBUTE_LENGTH)));
				Number length = (Number)attributes.get(URIConverter.ATTRIBUTE_LENGTH);
				if((length != null) && (length.longValue() > 0L)) {
					// it has some length but isn't readable; fail
					throw e;
				} // otherwise, it's just empty and we'll fill it
			}
		} else {
			// new resource
			resource = getModelManager().createResource(resourceURI);
		}
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
	@Override
	@Deprecated
	public void loadModel(IPath fullPathWithoutExtension) {
		loadModel(getPlatformURI(fullPathWithoutExtension));
	}

	/**
	 * Load the model by using the provided fullpath as a hint for the resource
	 * URI. In this implementation, simply add the model extension.
	 * 
	 * @param fullPathWithoutExtension
	 */
	@Override
	public void loadModel(URI uriWithoutExtension) {
		// Compute model URI
		resourceURI = uriWithoutExtension.appendFileExtension(getModelFileExtension());

		// Create Resource of appropriate type
		resource = modelSet.getResource(resourceURI, true);

		configureResource(resource);

		// call registered snippets
		snippets.performStart(this);
	}

	/**
	 * Queries whether my resource (based on the given URI) exists in the current model set.
	 * 
	 * @param uriWithoutExtension
	 *        the base resource URI to check
	 * 
	 * @return whether my resource based on this URI exists
	 */
	protected boolean exists(URI uriWithoutExtension) {
		return modelSet.getURIConverter().exists(uriWithoutExtension.appendFileExtension(getModelFileExtension()), null);
	}
	
	/**
	 * Import the model by using the provided fullpath as a hint for the
	 * resource URI. In this implementation, simply call {@link #loadModel(IPath)}
	 * 
	 * @param fullPathWithoutExtension
	 */
	@Override
	@Deprecated
	public void importModel(IPath fullPathWithoutExtension) {

		loadModel(fullPathWithoutExtension);
	}

	@Override
	public void importModel(URI uriWithoutExtension) {
		loadModel(uriWithoutExtension);
	}

	/**
	 * @throws IOException
	 * @see org.eclipse.papyrus.infra.core.resource.IModel#saveModel()
	 * 
	 */
	@Override
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
	@Override
	@Deprecated
	public void changeModelPath(IPath fullPath) {
		setModelURI(getPlatformURI(fullPath));
	}

	@Override
	public void setModelURI(URI uriWithoutExtension) {
		// Compute model URI
		resourceURI = uriWithoutExtension.appendFileExtension(getModelFileExtension());

		resource.setURI(resourceURI);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.IModel#dispose()
	 * 
	 */
	@Override
	public void unload() {
		// call registered snippets
		snippets.performDispose(this);

		// Do unloading
		if(resource != null) {
			resource.unload();
			resource = null;
		}

		super.unload();
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


	@Override
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

	@Override
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

	@Override
	public Set<URI> getModifiedURIs() {
		if(getResource() != null) {
			if(!getResource().isTrackingModification() || getResource().isModified()) {
				return Collections.singleton(getResource().getURI());
			}
		}
		return Collections.emptySet();
	}

	@Override
	public void handle(Resource resource) {
		//Default: do nothing
	}

	@Override
	public boolean isModelFor(Object element) {
		return element != null && element == resource;
	}

	/**
	 * For standard controlled resources, resources have a single root with a non-null eContainer
	 * 
	 * 
	 * @param resource
	 * @return
	 */
	@Override
	public boolean isControlled(Resource resource) {
		if(resource == this.resource || resource == null) {
			return false;
		}

		if(resource.getContents().isEmpty()) {
			return false;
		}

		EObject rootElement = resource.getContents().get(0);

		boolean isControlled = rootElement.eContainer() != null;
		if(isControlled) {
			Resource parentResource = rootElement.eContainer().eResource();
			boolean isChildOfMainResource = parentResource == this.resource || isControlled(parentResource);
			return isChildOfMainResource;
		}

		return false;
	}

}
