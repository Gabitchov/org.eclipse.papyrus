/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.EditingDomainManager;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.additional.AdditionalResourcesModel;

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
	private Map<String, IModel> models = new HashMap<String, IModel>();

	/** The snippets. */
	private ModelSetSnippetList snippets = new ModelSetSnippetList();

	private AdditionalResourcesModel additional = new AdditionalResourcesModel();

	/**
	 * The associated EditingDomain.
	 */
	private TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * The filename path, without extension, used for action on models.
	 */
	private IPath filenameWithoutExtension;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ModelSet() {
		registerModel(additional);
		this.setURIResourceMap(new HashMap<URI, Resource>());
	}

	@Override
	public Map<Object, Object> getLoadOptions() {
		Map<Object, Object> loadOptions = super.getLoadOptions();
		loadOptions.put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		loadOptions.put(XMIResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
		return loadOptions;
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
		Resource resource = null;
		resource = super.getResource(uri, loadOnDemand);
		return setResourceOptions(resource);
	}

	/**
	 * Retrieve and load the associated resource which have the given extension.
	 * 
	 * @param modelElement
	 * @param associatedResourceExtension
	 * @return
	 */
	public Resource getAssociatedResource(EObject modelElement, String associatedResourceExtension) {
		if(modelElement != null) {
			return getAssociatedResource(modelElement.eResource(), associatedResourceExtension);
		}
		return null;
	}

	/**
	 * Retrieve and load the associated resource which have the given extension.
	 * 
	 * @param modelResource
	 * @param associatedResourceExtension
	 * @return
	 */
	public Resource getAssociatedResource(Resource modelResource, String associatedResourceExtension) {
		Resource r = null;
		if(modelResource != null) {
			URI trimmedModelURI = modelResource.getURI().trimFileExtension();
			try {
				r = getResource(trimmedModelURI.appendFileExtension(associatedResourceExtension), true);
			} catch (WrappedException e) {
				if(ModelUtils.isDegradedModeAllowed(e.getCause())) {
					r = getResource(trimmedModelURI.appendFileExtension(associatedResourceExtension), false);
					if(r == null) {
						throw e;
					}
				}
			} catch (Exception e) {
			}
		}
		return setResourceOptions(r);
	}

	/**
	 * This method is called by getResource and createResource before returning
	 * the resource to the caller so we can set options on the resource.
	 * 
	 * @param r
	 *        , can be null
	 * @return the same resource for convenience
	 */
	protected Resource setResourceOptions(Resource r) {
		if(r instanceof ResourceImpl) {
			ResourceImpl impl = (ResourceImpl)r;
			if(impl.getIntrinsicIDToEObjectMap() == null) {
				impl.setIntrinsicIDToEObjectMap(new HashMap<String, EObject>());
			}
		}
		return r;
	}

	/**
	 * Create the transactional editing domain.
	 * 
	 * @return the transactional editing domain
	 */
	public TransactionalEditingDomain getTransactionalEditingDomain() {
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
	 */
	public IPath getFilenameWithoutExtension() {
		return filenameWithoutExtension;
	}

	/**
	 * @return the filenameWithoutExtension
	 * @throws BadStateException
	 */
	protected IPath getFilenameWithoutExtensionChecked() throws BadStateException {
		if(filenameWithoutExtension == null) {
			throw new BadStateException("Path should be set prior calling any operations.");
		}

		return filenameWithoutExtension;
	}

	/**
	 * @param filenameWithoutExtension
	 *        the filenameWithoutExtension to set
	 */
	protected void setFilenameWithoutExtension(IPath filenameWithoutExtension) {
		this.filenameWithoutExtension = filenameWithoutExtension;
	}

	/**
	 * Create all the associated models. This creates the models, regardless if
	 * they already exist.
	 * 
	 * @param newFile
	 *        The file from which path is extracted to create the new
	 *        resources
	 */
	public void createsModels(IFile newFile) {

		// Get the file name, without extension.
		filenameWithoutExtension = newFile.getFullPath().removeFileExtension();

		// Walk all registered models
		for(IModel model : models.values()) {
			model.createModel(filenameWithoutExtension);
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
			model.createModel(filenameWithoutExtension);
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
		model.loadModel(getFilenameWithoutExtensionChecked());

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
	 */
	public void loadModels(IFile file) throws ModelMultiException {

		// Get the file name, without extension.
		filenameWithoutExtension = file.getFullPath().removeFileExtension();

		ModelMultiException exceptions = null;

		// Walk all registered models
		for(IModel model : models.values()) {
			// Try to load each model. Catch exceptions in order to load other
			// models.
			try {
				model.loadModel(filenameWithoutExtension);
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
	public void importModels(ModelIdentifiers modelIdentifiers, IFile file) throws ModelException {

		IPath path = file.getFullPath().removeFileExtension();
		// Walk all registered models
		for(String modelId : modelIdentifiers) {
			IModel model = getModel(modelId);

			// Load models using the default path
			model.importModel(path);
			if(filenameWithoutExtension != null) {
				model.changeModelPath(filenameWithoutExtension);
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
	 */
	public IModel importModel(String modelIdentifier, IFile file) throws ModelException {

		importModels(new ModelIdentifiers(modelIdentifier), file);

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

		try {
			// Walk all registered models
			for(IModel model : modelList) {
				try {
					if(!(model instanceof AdditionalResourcesModel)) {
						model.saveModel();
						monitor.worked(1);
					}
				} catch (Exception ex) {
					//TODO: What happens when a save fails? Most of the time, it can be ignored (dangling href, ...)
					Activator.log.error(ex);
				}
			}
			additional.saveModel();
		} finally {
			monitor.done();
		}
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
	public void saveAs(IPath path) throws IOException {

		// Get the file name, without extension.
		filenameWithoutExtension = path.removeFileExtension();

		// Walk all registered models
		for(IModel model : models.values()) {
			model.changeModelPath(filenameWithoutExtension);
		}

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

}
