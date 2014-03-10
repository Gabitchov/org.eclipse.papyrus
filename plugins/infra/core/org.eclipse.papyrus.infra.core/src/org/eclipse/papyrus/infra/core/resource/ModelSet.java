/*****************************************************************************
 * Copyright (c) 2008, 2013 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Emilien Perico emilien.perico@atosorigin.com - manage loading strategies
 *  Christian W. Damus (CEA) - manage models by URI, not IFile (CDO)
 *  Christian W. Damus (CEA) - Support read-only state at object level (CDO)
 *  Christian W. Damus (CEA) - Refactoring of Create Model Wizard (CDO)
 *  Christian W. Damus (CEA LIST) - Controlled resources in CDO repositories
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.EditingDomainManager;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.additional.AdditionalResourcesModel;
import org.eclipse.papyrus.infra.tools.util.PlatformHelper;

import com.google.common.base.Optional;

/**
 * This class is used to manage a set of {@link IModel}.
 * 
 * <h2>>Usage</h2>
 * <ul>
 * <li>First, register associated model. A loader can be used.</li>
 * <li>Second, call load() or create()</li>
 * <li>Then, it is possible to get associated models</li>
 * <li>Finally, call save()</li>
 * </ul>
 * 
 * Please note that indirectly referenced models are loaded on demand. If a
 * model contains a cross reference towards another model (e.g. an import in
 * case of UML) the referenced resource does not appear initially in the set.
 * However, it is added once the referenced model is resolved.
 * 
 * TODO Modify ModelSetSnippet in order to inform them of model addition.
 * 
 * @author cedric dumoulin
 * 
 */
public class ModelSet extends ResourceSetImpl {

	/**
	 * Id use to register the EditinDomain into the registry
	 */
	public static final String PAPYRUS_EDITING_DOMAIN_ID = "org.eclipse.papyrus.SharedEditingDomainID";

	/** The associated IModels. */
	protected Map<String, IModel> models = new HashMap<String, IModel>();

	/** The snippets. */
	protected ModelSetSnippetList snippets = new ModelSetSnippetList();

	protected AdditionalResourcesModel additional = new AdditionalResourcesModel();

	/**
	 * The associated EditingDomain.
	 */
	protected TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * The URI, without extension, used for action on models.
	 */
	protected URI uriWithoutExtension;

	protected Adapter modificationTrackingAdapter;

	protected IReadOnlyHandler roHandler;

	/**
	 * URI pointing to resource on which back end should be deleted on save
	 * One example of use is empty uncontrolled resources
	 */
	protected Set<URI> toDeleteOnSave = new HashSet<URI>();

	/** list of listeners of resources to know if the resource are loaded or not */
	protected ArrayList<IResourceLoadStateListener> resourceLoadStateListeners;

	/** map of resource loaded in the resource set, with resource as the key and a boolean indicating if the resource is loaded or not has the valuer */
	protected Map<Resource, Boolean> resourcesToLoadState = new HashMap<Resource, Boolean>();



	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ModelSet() {
		registerModel(additional);
		setTrackingModification(true);

		getLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
		getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		getLoadOptions().put(XMIResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
		getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		getLoadOptions().put(XMLResource.OPTION_USE_PACKAGE_NS_URI_AS_LOCATION, Boolean.FALSE);

		this.eAdapters.add(new ResourceAddRemoveTracker());
	}

	/**
	 * Register the specified model under its associated key. The key is defined
	 * in the model itself. It is usually the model type from
	 * (ModelPackage.eCONTENT_TYPE).
	 * 
	 * @param model
	 *        the model
	 */
	public void registerModel(IModel model) {
		IModel existing = models.get(model.getIdentifier());
		if((existing == null) || existing.getClass().isAssignableFrom(model.getClass().getSuperclass())) {
			// only add this model if it is the first instance for its identifier
			// or it's an instance of a subclass
			doRegisterModel(model);
		}
	}

	protected void doRegisterModel(IModel model) {
		models.put(model.getIdentifier(), model);
		model.init(this);
	}

	/**
	 * Get a model by its key. TODO throw an exception if not found.
	 * 
	 * @param key
	 *        the key
	 * @return the model
	 */
	public IModel getModel(String key) {
		return models.get(key);
	}

	/**
	 * Get a model by its key. TODO throw an exception if not found.
	 * 
	 * @param key
	 *        the key
	 * @return the model
	 * @throws NotFoundException
	 *         If no model is registered under the key.
	 */
	public IModel getModelChecked(String key) throws NotFoundException {
		IModel model = models.get(key);
		if(model == null) {
			throw new NotFoundException("Can't find model for identifier '" + key + "'.");
		}

		return model;
	}

	@Override
	public Resource createResource(URI uri, String contentType) {
		return setResourceOptions(super.createResource(uri, contentType));
	}

	@Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		Resource r = null;
		try {
			r = super.getResource(uri, loadOnDemand);
		} catch (WrappedException e) {
			// Activator.log.error(e);
			if(ModelUtils.isDegradedModeAllowed(e.getCause())) {
				r = super.getResource(uri, false);
				if(r == null) {
					throw e;
				}
			} else {
				// don't log, but throw error again, bug 405047 - [core] FileNotFoundException during MARTE profile loads
				throw e;
			}
		}

		return r != null && r.isLoaded() ? r : setResourceOptions(r);
	}

	@Override
	protected void handleDemandLoadException(Resource resource, IOException exception) throws RuntimeException {
		super.handleDemandLoadException(resource, exception);
	}

	public void setTrackingModification(boolean isTrackingModification) {
		boolean oldIsTrackingModification = modificationTrackingAdapter != null;

		if(oldIsTrackingModification != isTrackingModification) {
			if(isTrackingModification) {
				modificationTrackingAdapter = createModificationTrackingAdapter();
				this.eAdapters().add(modificationTrackingAdapter);
			} else {
				Adapter oldModificationTrackingAdapter = modificationTrackingAdapter;
				modificationTrackingAdapter = null;
				this.eAdapters().remove(oldModificationTrackingAdapter);
			}
		}
	}

	protected Adapter createModificationTrackingAdapter() {
		return new ProxyModificationTrackingAdapter();
	}

	public boolean isTrackingModification() {
		return modificationTrackingAdapter != null;
	}

	/**
	 * @deprecated please use {@link #getAssociatedResource(EObject, String, boolean)} instead
	 * 
	 * @param modelElement
	 * @param associatedResourceExtension
	 * @return
	 */
	@Deprecated
	public Resource getAssociatedResource(EObject modelElement, String associatedResourceExtension) {
		return getAssociatedResource(modelElement, associatedResourceExtension, true);
	}

	/**
	 * @deprecated please use {@link #getAssociatedResource(Resource, String, boolean)} instead
	 * 
	 * @param modelResource
	 * @param associatedResourceExtension
	 * @return
	 */
	@Deprecated
	public Resource getAssociatedResource(Resource modelResource, String associatedResourceExtension) {
		return getAssociatedResource(modelResource, associatedResourceExtension, true);
	}

	/**
	 * Retrieve and load the associated resource which have the given extension.
	 * 
	 * @param modelElement
	 * @param associatedResourceExtension
	 * @param loadOnDemand
	 *        same as for getResource
	 * @return
	 */
	public Resource getAssociatedResource(EObject modelElement, String associatedResourceExtension, boolean loadOnDemand) {
		if(modelElement != null) {
			return getAssociatedResource(modelElement.eResource(), associatedResourceExtension, loadOnDemand);
		}
		return null;
	}

	/**
	 * Retrieve and load the associated resource which have the given extension.
	 * 
	 * @param modelResource
	 * @param associatedResourceExtension
	 * @param loadOnDemand
	 *        same as for getResource
	 * @return
	 */
	public Resource getAssociatedResource(Resource modelResource, String associatedResourceExtension, boolean loadOnDemand) {
		Resource r = null;
		if(modelResource != null) {
			URI trimmedModelURI = modelResource.getURI().trimFileExtension();
			r = getResource(trimmedModelURI.appendFileExtension(associatedResourceExtension), loadOnDemand);
		}
		return r;
	}

	/**
	 * This method is called by getResource, createResource and demandLoad before returning
	 * the resource to the caller so we can set options on the resource.
	 * 
	 * @param r
	 *        , can be null
	 * @return the same resource for convenience
	 */
	protected Resource setResourceOptions(Resource r) {

		for(IModel model : models.values()) {
			if(model instanceof IEMFModel) {
				((IEMFModel)model).handle(r);
			}
		}

		if(r != null && isTrackingModification() && !r.isTrackingModification()) {
			r.setTrackingModification(true);
		}
		return r;
	}

	@Override
	protected void demandLoad(Resource resource) throws IOException {
		// perf optimization : call setResourceOptions before the loading of the resource to avoid
		// going through the whole objects tree when setting the tracking modification
		super.demandLoad(setResourceOptions(resource));
	}

	/**
	 * Create the transactional editing domain.
	 * 
	 * @return the transactional editing domain
	 */
	public synchronized TransactionalEditingDomain getTransactionalEditingDomain() {
		transactionalEditingDomain = TransactionalEditingDomainManager.getTransactionalEditingDomain(this);

		if(transactionalEditingDomain == null) {
			transactionalEditingDomain = TransactionalEditingDomainManager.createTransactionalEditingDomain(this);
			// register the id for lifecyle events the id is set by the registry
			EditingDomainManager.getInstance().configureListeners(PAPYRUS_EDITING_DOMAIN_ID, transactionalEditingDomain);
		}
		return transactionalEditingDomain;
	}

	/**
	 * @return the filenameWithoutExtension
	 * 
	 * @deprecated Use the {@link #getURIWithoutExtension()} API, instead.
	 */
	@Deprecated
	public IPath getFilenameWithoutExtension() {
		IPath result = null;

		if(uriWithoutExtension != null) {
			if(uriWithoutExtension.isPlatformResource()) {
				result = new Path(uriWithoutExtension.toPlatformString(true));
			} else {
				throw new IllegalStateException("URI is not a platform:/resource URI");
			}
		}

		return result;
	}

	public URI getURIWithoutExtension() {
		return uriWithoutExtension;
	}

	/**
	 * @return the filenameWithoutExtension
	 * @throws BadStateException
	 */
	protected URI getURIWithoutExtensionChecked() throws BadStateException {
		if(uriWithoutExtension == null) {
			throw new BadStateException("Path should be set prior calling any operations.");
		}

		return uriWithoutExtension;
	}

	/**
	 * @param filenameWithoutExtension
	 *        the filenameWithoutExtension to set
	 */
	protected void setURIWithoutExtension(URI uriWithoutExtension) {
		this.uriWithoutExtension = uriWithoutExtension;
	}

	/**
	 * Create all the associated models. This creates the models, regardless if
	 * they already exist.
	 * 
	 * @param newFile
	 *        The file from which path is extracted to create the new
	 *        resources
	 * 
	 * @deprecated Use the {@link #createModels(URI)} API, instead.
	 */
	@Deprecated
	public void createsModels(IFile newFile) {
		createModels(createURI(newFile));
	}

	/**
	 * Create all the associated models. This creates the models, regardless if
	 * they already exist.
	 * 
	 * @param newFile
	 *        The file from which path is extracted to create the new
	 *        resources
	 */
	public void createModels(URI newURI) {

		// Set the URI, without extension.
		setURIWithoutExtension(newURI.trimFileExtension());

		// Walk all registered models
		for(IModel model : models.values()) {
			model.createModel(uriWithoutExtension);
		}

		// call snippets to allow them to do their stuff
		snippets.performStart(this);
	}

	/**
	 * Create the model specified by the identifiers. Other models are
	 * untouched, unless they are sharing something with specified models.
	 * 
	 * This creates the models, regardless if they already exist.
	 * 
	 * @param newFile
	 *        The file from which path is extracted to create the new
	 *        resources
	 */
	public void createsModels(ModelIdentifiers modelIdentifiers) {

		// Walk all registered models
		for(String modelId : modelIdentifiers) {
			IModel model = getModel(modelId);

			// Load models using the default path
			model.createModel(uriWithoutExtension);
		}

		// call snippets to allow them to do their stuff
		// snippets.modelsAdded(modelIdentifiers);
	}

	/**
	 * Load only the specified model. ModelSetSnippets are not called. Model is
	 * loaded using the ModelSet Path.
	 * 
	 * @param modelIdentifier
	 *        the model identifier
	 * @param file
	 *        the file
	 * @return the i model
	 * @throws BadStateException
	 *         If the global path is not specified.
	 * @returns The loaded model.
	 */
	public IModel loadModel(String modelIdentifier) throws BadStateException {

		IModel model = getModel(modelIdentifier);
		model.loadModel(getURIWithoutExtensionChecked());

		return model;
	}

	/**
	 * Import only the specified model. ModelSetSnippets are not called.
	 * 
	 * @param modelIdentifier
	 *        the model identifier
	 * @param file
	 *        the file
	 * @return the i model
	 * @throws ModelException
	 * @returns The loaded model.
	 * @deprecated Use {@link #importModel(ModelIdentifier, IFile)}
	 */
	@Deprecated
	public IModel loadModel(String modelIdentifier, IFile file) throws ModelException {

		importModels(new ModelIdentifiers(modelIdentifier), file);

		return getModel(modelIdentifier);
	}

	/**
	 * Load all the associated models from a handle on one of the associated
	 * file.
	 * 
	 * @param file
	 *        The file to load (no matter the extension)
	 * @deprecated Use the {@link #loadModels(URI)} API, instead.
	 */
	@Deprecated
	public void loadModels(IFile file) throws ModelMultiException {
		loadModels(createURI(file));
	}

	protected URI createURI(IFile file) {
		return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
	}

	/**
	 * Load all the associated models from a URI identifying one of the associated
	 * files.
	 * 
	 * @param uri
	 *        The URI to load (no matter the extension)
	 */
	public void loadModels(URI uri) throws ModelMultiException {

		// Get the file name, without extension.
		uriWithoutExtension = uri.trimFileExtension();

		ModelMultiException exceptions = null;
		List<IModel> orderedModelsForLoading = getOrderedModelsForLoading();

		// Walk all registered models
		for(IModel model : orderedModelsForLoading) {
			// Try to load each model. Catch exceptions in order to load other
			// models.
			try {
				model.loadModel(uriWithoutExtension);
			} catch (Exception e) {
				// Record the exception
				if(exceptions == null) {

					exceptions = new ModelMultiException("Problems encountered while loading one of the models.");
				}
				exceptions.addException(model.getIdentifier(), e);
			}
		}

		// call snippets to allow them to do their stuff
		snippets.performStart(this);

		// Report exceptions if any
		if(exceptions != null) {
			throw exceptions;
		}
	}

	/**
	 * Returns the models to be loaded, in order according to their dependencies
	 * 
	 * @return the models to be loaded, in order according to their dependencies
	 */
	protected List<IModel> getOrderedModelsForLoading() {
		return ModelUtils.getOrderedModelsForLoading(models);
	}

	/**
	 * Import specified models into the ModelSet. The models are imported using
	 * the specified IFile. After import, the models are associated with the
	 * ModelSet Path.
	 * 
	 * @param modelIdentifiers
	 *        The model to import from the specified IFile.
	 * @param file
	 *        The IFile used to import the model.
	 * @throws ModelException
	 *         If an error occur during import.
	 * 
	 * @deprecated Use the {@link #importModels(ModelIdentifiers, URI)} API, instead
	 */
	@Deprecated
	public void importModels(ModelIdentifiers modelIdentifiers, IFile file) throws ModelException {

		importModels(modelIdentifiers, createURI(file));
	}

	/**
	 * Import specified models into the ModelSet. The models are imported using
	 * the specified IFile. After import, the models are associated with the
	 * ModelSet Path.
	 * 
	 * @param modelIdentifiers
	 *        The model to import from the specified IFile.
	 * @param file
	 *        The IFile used to import the model.
	 * @throws ModelException
	 *         If an error occur during import.
	 */
	public void importModels(ModelIdentifiers modelIdentifiers, URI uri) throws ModelException {

		URI toImport = uri.trimFileExtension();
		// Walk all registered models
		for(String modelId : modelIdentifiers) {
			IModel model = getModel(modelId);

			// Load models using the default path
			model.importModel(toImport);
			if(uri != null) {
				model.setModelURI(uriWithoutExtension);
			}
		}
	}

	/**
	 * Import only the specified model. ModelSetSnippets are not called. An
	 * import can be performed after model are loaded. Normally, it should not
	 * be done before a model is loaded.
	 * 
	 * @param modelIdentifier
	 *        the model identifier
	 * @param file
	 *        the file
	 * @throws ModelException
	 * @returns The loaded model.
	 * 
	 * @deprecated Use the {@link #importModel(String, URI)} API, instead.
	 */
	@Deprecated
	public IModel importModel(String modelIdentifier, IFile file) throws ModelException {

		return importModel(modelIdentifier, createURI(file));
	}

	/**
	 * Import only the specified model. ModelSetSnippets are not called. An
	 * import can be performed after model are loaded. Normally, it should not
	 * be done before a model is loaded.
	 * 
	 * @param modelIdentifier
	 *        the model identifier
	 * @param file
	 *        the file
	 * @throws ModelException
	 * @returns The loaded model.
	 */
	public IModel importModel(String modelIdentifier, URI uri) throws ModelException {

		importModels(new ModelIdentifiers(modelIdentifier), uri);

		return getModel(modelIdentifier);
	}

	/**
	 * Create models that are not already created or loaded.
	 */
	public void createMissingModels() throws ModelException {
		throw new UnsupportedOperationException("Not yet implemented");

	}

	/**
	 * Load models that are not already created or loaded.
	 */
	public void loadMissingModels() throws ModelException {
		throw new UnsupportedOperationException("Not yet implemented");

	}

	/**
	 * Save the resources.
	 * 
	 * @param monitor
	 *        The monitor.
	 * @throws IOException
	 *         IO Error.
	 */
	public void save(IProgressMonitor monitor) throws IOException {

		// Initialize monitor with the number of models
		Collection<IModel> modelList = models.values();
		monitor.beginTask("Saving resources", modelList.size());

		if(isTrackingModification() && getReadOnlyHandler() != null) {
			Set<URI> roUris = new HashSet<URI>();
			for(IModel model : modelList) {
				Set<URI> uris = model.getModifiedURIs();
				for(URI u : uris) {
					Optional<Boolean> res = getReadOnlyHandler().anyReadOnly(new URI[]{ u });
					if(res.isPresent() && res.get()) {
						roUris.add(u);
					}
				}
			}

			for(URI u : getResourcesToDeleteOnSave()) {
				Optional<Boolean> res = getReadOnlyHandler().anyReadOnly(new URI[]{ u });
				if(res.isPresent() && res.get()) {
					roUris.add(u);
				}
			}

			if(!roUris.isEmpty()) {
				Optional<Boolean> authorizeSave = getReadOnlyHandler().makeWritable(roUris.toArray(new URI[roUris.size()]));

				if(authorizeSave.isPresent() && !authorizeSave.get()) {
					monitor.done();
					//FIXME: In Kepler M6, it seems that it is sometimes possible to modify the readOnly StandardL3 profile.
					//This doesn't have any consequence, but prevents the save action. We'd better not throw an exception here.
					//throw new IOException("Some modified resources are read-only : the model can't be saved");
				}
			}
		}

		try {
			// Walk all registered models
			for(IModel model : modelList) {
				try {
					if(!(model instanceof AdditionalResourcesModel)) {
						model.saveModel();
						monitor.worked(1);
					}
				} catch (Exception ex) {
					//If an exception occurs, we should not prevent other models from being saved.
					//This would probably make things even worse. Catch and log.
					Activator.log.error(ex);
				}
			}
			try {
				additional.saveModel();
			} catch (Exception ex) {
				Activator.log.error(ex);
			}

			//Delete resource back end to delete on save
			handleResourcesToDelete();
		} finally {
			monitor.done();
		}
	}

	/**
	 * @return {@link ModelSet#toDeleteOnSave}
	 */
	public Set<URI> getResourcesToDeleteOnSave() {
		return toDeleteOnSave;
	}

	/**
	 * Delete resources pointed by {@link ModelSet#toDeleteOnSave}set.
	 */
	protected void handleResourcesToDelete() {
		Iterator<URI> uriIterator = getResourcesToDeleteOnSave().iterator();
		while(uriIterator.hasNext()) {
			URI uri = uriIterator.next();

			if(validateDeleteResource(uri)) {
				if(deleteResource(uri)) {
					uriIterator.remove();
				}
			}
		}
	}

	protected boolean validateDeleteResource(URI uri) {
		boolean result = true;

		Resource resource = getResource(uri, false);
		if(resource != null) {
			String warMessage = "The resource " + resource.getURI().lastSegment() + " was about to deleted but was still contained in the resource set. The will not be deleted";
			Activator.log.warn(warMessage);

			result = false;
		}

		return result;
	}

	protected boolean deleteResource(URI uri) {
		boolean result = false;

		try {
			getURIConverter().delete(uri, null);
			result = true;
		} catch (IOException e) {
			Activator.log.error(e);

			// hope it's a file that we can delete from the workspace!
			IFile file = getFile(uri);
			if(file != null && file.exists()) {
				try {
					file.delete(true, new NullProgressMonitor());
					result = true;
				} catch (CoreException e2) {
					Activator.log.error(e2);
				}
			}
		}

		return result;
	}

	/**
	 * Finds the file corresponding to the specified URI, using a URI converter
	 * if necessary (and provided) to normalize it.
	 * 
	 * @param uri
	 *        a URI
	 * @param converter
	 *        an optional URI converter (may be <code>null</code>)
	 * 
	 * @return the file, if available in the workspace
	 */
	protected IFile getFile(URI uri) {
		IFile result = null;
		if(uri.isPlatformPlugin()) {
			/* resource with platform plug-in URI could not be in the workspace */
			return result;
		} else if(uri.isPlatformResource()) {
			IPath path = new Path(uri.toPlatformString(true));
			result = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		} else if(uri.isFile() && !uri.isRelative()) {
			result = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(uri.toFileString()));
		} else {
			// normalize, to see whether may we can resolve it this time
			if(uriConverter != null) {
				URI normalized = uriConverter.normalize(uri);
				if(!uri.equals(normalized)) {
					// recurse on the new URI
					result = getFile(normalized);
				}
			}
		}
		if((result == null) && !uri.isRelative()) {
			try {
				java.net.URI location = new java.net.URI(uri.toString());
				if(hasRegisteredEFS(location)) {
					IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(new java.net.URI(uri.toString()));
					if(files.length > 0) {
						// set the result to be the first file found
						result = files[0];
					}
				}
			} catch (URISyntaxException e) {
				// won't get this because EMF provides a well-formed URI
			}
		}
		return result;
	}

	protected boolean hasRegisteredEFS(java.net.URI location) {
		try {
			if(EFS.getStore(location) != null) {
				return true;
			}
		} catch (CoreException ex) {
			return false;
		}
		return false;
	}

	/**
	 * The resources are already loaded, but we want to save them under another
	 * name.
	 * 
	 * @param path
	 *        the path
	 * @throws IOException
	 *         Signals that an I/O exception has occurred.
	 * 
	 * @deprecated Use the {@link #saveAs(URI)} API, instead.
	 */
	@Deprecated
	public void saveAs(IPath path) throws IOException {
		saveAs(URI.createPlatformResourceURI(path.toString(), true));
	}

	/**
	 * The resources are already loaded, but we want to save them under another
	 * name.
	 * 
	 * @param path
	 *        the path
	 * @throws IOException
	 *         Signals that an I/O exception has occurred.
	 */
	public void saveAs(URI uri) throws IOException {

		EcoreUtil.resolveAll(this); //Save will not be consistent if we don't load all related resources first

		// Get the file name, without extension.
		URI newUriWithoutExtension = uri.trimFileExtension();

		// Walk all registered models
		for(IModel model : models.values()) {
			model.setModelURI(newUriWithoutExtension);
		}

		this.uriWithoutExtension = newUriWithoutExtension;

		// Save with new paths
		save(new NullProgressMonitor());
	}

	/**
	 * Unload all the resources. Do not disguard associated models.
	 */
	public void unload() {
		// call snippets to allow them to do their stuff
		snippets.performDispose(this);
		snippets.clear();


		// FIXME RS: handle the unload ordering as indicated in the model extension point
		// Walk all registered models
		for(IModel model : models.values()) {
			if(!(model instanceof AdditionalResourcesModel)) {
				model.unload();
			}
		}
		additional.unload();

		// Unload remaining resources
		for(Iterator<Resource> iter = getResources().iterator(); iter.hasNext();) {
			iter.next().unload();
			iter.remove();
		}

		// Dispose Editing Domain
		if(transactionalEditingDomain != null) {
			transactionalEditingDomain.dispose();
			transactionalEditingDomain = null;
		}
		// Detach associated factories
		if(adapterFactories != null) {
			adapterFactories.clear();
		}
		EList<Adapter> adapters = eAdapters();
		if(adapters != null) {
			adapters.clear();
		}
	}

	public IReadOnlyHandler getReadOnlyHandler() {
		if(roHandler == null) {
			EditingDomain editingDomain = getTransactionalEditingDomain();
			Object handler = PlatformHelper.getAdapter(editingDomain, IReadOnlyHandler.class);
			if(handler instanceof IReadOnlyHandler) {
				roHandler = (IReadOnlyHandler)handler;
			}
		}
		return roHandler;
	}

	/**
	 * Obtains my internal API adapter.
	 * 
	 * @return my internal API adapter
	 */
	public Internal getInternal() {
		return new Internal() {

			@Override
			public void setPrimaryModelResourceURI(URI uri) {
				setURIWithoutExtension(uri.trimFileExtension());
			}

			@Override
			public void registerModel(IModel model, boolean force) {
				if(force) {
					doRegisterModel(model);
				} else {
					ModelSet.this.registerModel(model);
				}
			}
		};
	}

	/**
	 * Add a {@link IModelSetSnippet}. A snippet allows to add code that will
	 * perform additional operations on the ModelSet.
	 * 
	 * @param snippet
	 *        The snippet to add.
	 */
	public void addModelSetSnippet(IModelSetSnippet snippet) {
		snippets.add(snippet);
	}

	/**
	 * A list of {@link IModelSetSnippet}.
	 * 
	 * Used by Models to maintain their list of Snippets.
	 * 
	 * @author cedric dumoulin
	 * 
	 */
	public class ModelSetSnippetList extends ArrayList<IModelSetSnippet> {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/**
		 * Call the start method on all registered snippets.
		 * 
		 * @param modelsManager
		 *        The model that is starting
		 */
		public void performStart(ModelSet modelsManager) {
			for(IModelSetSnippet snippet : this) {
				snippet.start(modelsManager);
			}
		}

		/**
		 * Call the start method on all registered snippets.
		 * 
		 * @param modelsManager
		 *        The model that is stopping
		 */
		public void performDispose(ModelSet modelsManager) {
			for(IModelSetSnippet snippet : this) {
				snippet.dispose(modelsManager);
			}

		}
	}

	/**
	 * Internal API for manipulation of {@link ModelSet}s.
	 */
	public static interface Internal {

		/**
		 * Sets the {@link ModelSet}'s primary resource URI.
		 * 
		 * @param uri
		 *        the URI
		 * 
		 * @see ModelSet#createModels(URI)
		 * @see ModelSet#saveAs(URI)
		 */
		void setPrimaryModelResourceURI(URI uri);

		/**
		 * Register a model with the option to force it (in case a more specific
		 * implementation of the model is already registered).
		 * 
		 * @param model
		 *        a model to register
		 * @param force
		 *        whether to force the registration
		 */
		void registerModel(IModel model, boolean force);
	}

	/**
	 * 
	 * @param target
	 */
	public void saveCopy(IPath targetPathWithoutExtension) {
		List<IVersionableModel> versionableModels = new LinkedList<IVersionableModel>();

		Map<Object, Object> targetMap = new HashMap<Object, Object>();

		for(IModel model : models.values()) {
			if(model instanceof IVersionableModel) {
				IVersionableModel versionable = (IVersionableModel)model;
				versionable.fillTargetMap(targetPathWithoutExtension, targetMap);
				versionableModels.add(versionable);
			}
		}

		for(IVersionableModel model : versionableModels) {
			model.saveCopy(targetPathWithoutExtension, targetMap);
		}
	}

	public boolean addResourceLoadStateListener(IResourceLoadStateListener listener) {
		return resourceLoadStateListeners.add(listener);
	}

	public boolean removeResourceLoadStateListener(IResourceLoadStateListener listener) {
		return resourceLoadStateListeners.remove(listener);
	}

	public void notifyResourceLoadState(Resource resource, boolean newState) {
		if(resourceLoadStateListeners != null) {
			for(IResourceLoadStateListener listener : resourceLoadStateListeners) {
				try {
					listener.notifyLoadStateChanged(resource, newState);
				} catch (Throwable e) {
					Activator.log.error(e);
				}
			}
		}
	}

	public boolean isUserModelResource(URI uri) {
		return uri.isPlatformResource() || uri.isFile();
	}

	public class ResourceAddRemoveTracker implements Adapter {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void notifyChanged(Notification notification) {
			// if notification = add, add many or remove/remove many resource(s) to list of resources, process..
			if(RESOURCE_SET__RESOURCES == notification.getFeatureID(ResourceSet.class)) {
				switch(notification.getEventType()) {
				case Notification.ADD:
					Object object = notification.getNewValue();
					if(object instanceof Resource) {
						resourcesToLoadState.put(((Resource)object), ((Resource)object).isLoaded());
					}
					break;
				case Notification.REMOVE:
					object = notification.getNewValue();
					if(object instanceof Resource) {
						resourcesToLoadState.remove((object));
					}
					break;
				case Notification.ADD_MANY:

					break;

				case Notification.REMOVE_MANY:

					break;

				default:
					// nothing to do
					break;
				}

			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Notifier getTarget() {
			return ModelSet.this;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void setTarget(Notifier newTarget) {
			// nothing here
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isAdapterForType(Object type) {
			return false;
		}

	}

	/**
	 * Returns the IModel which handles the specified element, if any
	 * 
	 * @param container
	 * @return
	 */
	public IModel getModelFor(Object element) {
		for(IModel model : models.values()) {
			if(model.isModelFor(element)) {
				return model;
			}
		}
		return null;
	}
}
