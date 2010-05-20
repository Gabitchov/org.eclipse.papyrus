/**
 * 
 */
package org.eclipse.papyrus.resource;

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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;



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

	/**
	 * The associated IModels
	 */
	private Map<Object, IModel> models = new HashMap<Object, IModel>();
	
	private ModelSetSnippetList snippets = new ModelSetSnippetList();
	
	/**
	 * The associated EditingDomain.
	 */
	private TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * 
	 * Constructor.
	 *
	 */
	public ModelSet() {
		
	}
	
	/**
	 * Register the specified model under its associated key.
	 * The key is defined in the model itself. It is ussually the model type from
	 * (ModelPackage.eCONTENT_TYPE).
	 * 
	 * @param model
	 */
	public void registerModel( IModel model) {
		models.put(model.getIdentifier(), model);
		model.init(this);
	}
	
	/**
	 * Get a model by its key.
	 * TODO throw an exception if not found.
	 * @param key
	 * @return
	 */
	public IModel getModel(Object key) {
		return models.get(key);
	}
	
	/**
	 * Create the transactional editing domain
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
	 * @param path
	 * @throws IOException
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
	 * A list of {@link IModelSetSnippet}.
	 * 
	 * Used by Models to maintain their list of Snippets.
	 * 
	 * @author cedric dumoulin
	 *
	 */
	public class ModelSetSnippetList extends ArrayList<IModelSetSnippet> {

		/**
		 * 
		 */
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
