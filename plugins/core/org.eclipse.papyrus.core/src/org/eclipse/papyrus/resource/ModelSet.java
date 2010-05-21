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
package org.eclipse.papyrus.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.core.resourceloading.ProxyManager;
import org.eclipse.papyrus.resource.notation.NotationUtils;
import org.eclipse.papyrus.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.resource.uml.UmlUtils;



/**
 * This class is used to manage a set of {@link IModel}.
 * 
 * <h2>>Usage</h2>
 * <ul>
 *   <li>First, register associated model. A loader can be used.</li>
 *   <li>Second, call load() or create()</li>
 *   <li>Then, it is possible to get associated models</li>
 *   <li>Finally, call save()</li>
 * </ul>
 * 
 * @author cedric dumoulin
 *
 */
public class ModelSet extends ResourceSetImpl {

	/** The associated IModels. */
	private Map<Object, IModel> models = new HashMap<Object, IModel>();
	
	/** The snippets. */
	private ModelSetSnippetList snippets = new ModelSetSnippetList();
	
	/**
	 * The associated EditingDomain.
	 */
	private TransactionalEditingDomain transactionalEditingDomain;
	
	/** Set that enables to always load the uri with any strategy. */
	private Set<URI> uriLoading = new HashSet<URI>();
	
	/** 
	 * The proxy manager that loads the model according to a specific strategy. 
	 */
	private ProxyManager proxyManager;

	
	/**
	 * 
	 * Constructor.
	 *
	 */
	public ModelSet() {
		proxyManager = new ProxyManager(this);
	}
	
	/**
	 * Register the specified model under its associated key.
	 * The key is defined in the model itself. It is ussually the model type from
	 * (ModelPackage.eCONTENT_TYPE).
	 *
	 * @param model the model
	 */
	public void registerModel( IModel model) {
		models.put(model.getIdentifier(), model);
		model.init(this);
	}
	
	/**
	 * Get a model by its key.
	 * TODO throw an exception if not found.
	 *
	 * @param key the key
	 * @return the model
	 */
	public IModel getModel(Object key) {
		return models.get(key);
	}
	
	/**
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceSetImpl#getEObject(org.eclipse.emf.common.util.URI, boolean)
	 */
	@Override
	public EObject getEObject(URI uri, boolean loadOnDemand) {
		//return super.getEObject(uri, loadOnDemand);
		
		URI resourceURI = uri.trimFragment();
		// for performance reasons, we check the three initial resources first
		if(resourceURI.equals(UmlUtils.getUmlModel(this).getResourceURI()) || resourceURI.equals(NotationUtils.getNotationModel(this).getResourceURI()) 
			|| resourceURI.equals(SashModelUtils.getSashModel(this).getResourceURI()) || uriLoading.contains(resourceURI)) {
			// do not manage eObject of the current resources
			return super.getEObject(uri, loadOnDemand);
		} else if(loadOnDemand) {
			return proxyManager.getEObjectFromStrategy(uri);
		} else {
			return null;
		}			
	}
	
	/**
	 * Create the transactional editing domain.
	 *
	 * @return the transactional editing domain
	 */
	public TransactionalEditingDomain getTransactionalEditingDomain() {
		transactionalEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(this);
		if(transactionalEditingDomain == null) {
			transactionalEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(this);
			// What for?
			transactionalEditingDomain.setID("SharedEditingDomain"); //$NON-NLS-1$
		}
		return transactionalEditingDomain;
	}

	/**
	 * Create all the associated models.
	 * This creates the models, regardless if they already exist.
	 * 
	 * @param newFile
	 *        The file from which path is extracted to create the new resources
	 */
	public void createsModels(IFile newFile) {
		
		// Get the file name, without extension.
		IPath filenameWithoutExtension = newFile.getFullPath().removeFileExtension();
		
		// Walk all registered models
		for( IModel model : models.values())
		{
			model.createModel( filenameWithoutExtension );
		}
		
		// call snippets to allow them to do their stuff
		snippets.performStart(this);
	}
	
	/**
	 * Create all the associated models that are not already created.
	 * This creates only missing models.
	 * <br>
	 * Usage:
	 * <ul>
	 *   <li>mngr = new ModelManager()</li>
	 *   <li>mngr.addModel( UmlModel )</li>
	 *   <li>mngr.createModels(File)</li>
	 *   <li>mngr.addModel(NotationModel)</li>
	 *   <li>mngr.createMissingModels(File)</li>
	 * </ul>
	 * 
	 * @param newFile
	 *        The file from which path is extracted to create the new resources
	 */
	public void createsMissingModels(IFile newFile) {
		
		// Get the file name, without extension.
		IPath filenameWithoutExtension = newFile.getFullPath().removeFileExtension();
		
		// Walk all registered models
		for( IModel model : models.values())
		{
//			if(model.)
			model.createModel( filenameWithoutExtension );
		}
		
		// call snippets to allow them to do their stuff
		snippets.performStart(this);
	}
	
	/**
	 * Load only the specified model. ManagerSnippets are not called.
	 *
	 * @param modelIdentifier the model identifier
	 * @param file the file
	 * @return the i model
	 * @returns The loaded model.
	 */
	public IModel loadModel(Object modelIdentifier, IFile file) {
		
		IModel model = getModel(modelIdentifier);
		model.loadModel(file);
		
		return model;
	}

	/**
	 * Load all the associated models from an handle on one of the associated file.
	 * 
	 * @param file
	 *        The file to load (no matter the extension)
	 */
	public void loadModels(IFile file) {
				
		// Walk all registered models
		for( IModel model : models.values())
		{
			model.loadModel( file );
		}
		
		// call snippets to allow them to do their stuff
		snippets.performStart(this);
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
		monitor.beginTask("Saving resources", modelList.size() );

		try {
			// Walk all registered models
			for( IModel model : modelList)
			{
				model.saveModel( );
				monitor.worked(1);
			}
		} finally {
			monitor.done();
		}
	}
	
	/**
	 * The resources are already loaded, but we want to save them under another name.
	 *
	 * @param path the path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveAs(IPath path) throws IOException {


		// Get the file name, without extension.
		IPath nameWithoutExt = path.removeFileExtension();

		// Walk all registered models
		for( IModel model : models.values())
		{
			model.changeModelPath( nameWithoutExt );
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

		// Walk all registered models
		for( IModel model : models.values())
		{
			model.unload( );
		}
				
		// Unload remaining resources 
		for(Iterator<Resource> iter = getResources().iterator(); iter.hasNext();) {
			iter.next().unload();
			iter.remove();
		}
	}
	
	/**
	 * Add a {@link IModelSetSnippet}. A snippet allows to add code that will perform
	 * additional operations on the ModelSet.
	 * 
	 * @param snippet The snippet to add.
	 */
	public void addModelSetSnippet(IModelSetSnippet snippet) {
		snippets.add(snippet);
	}
	
	/**
	 * Enables to add an URI that will be always loaded.
	 * It is not listening at the current loading strategy and always load the specified URI if needed.
	 *
	 * @param alwaysLoadedUri the always loaded uri
	 */
	public void forceUriLoading(URI alwaysLoadedUri) {
		uriLoading.add(alwaysLoadedUri);
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
		 * @param modelsManager The model that is starting
		 */
		public void performStart(ModelSet modelsManager) {
			for( IModelSetSnippet snippet : this)
			{
				snippet.start(modelsManager);
			}
		}
		
		/**
		 * Call the start method on all registered snippets.
		 * @param modelsManager The model that is stopping
		 */
		public void performDispose(ModelSet modelsManager) {
			for( IModelSetSnippet snippet : this)
			{
				snippet.dispose(modelsManager);
			}
			
		}
	}
}
