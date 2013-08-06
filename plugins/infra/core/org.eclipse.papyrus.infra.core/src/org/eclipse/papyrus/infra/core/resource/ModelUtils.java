/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.xmi.IllegalValueException;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

/**
 * Set of utility methods to get the current {@link ModelSet}.
 * 
 * @author cedric dumoulin
 * 
 */
public class ModelUtils {

	/**
	 * Gets the {@link ModelSet} for the currently selected editor. <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not
	 * designed to be call from Editors. This method can return null.
	 * 
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 * 
	 * 
	 * @return The {@link TraceModel} of the current editor, or null if not
	 *         found.
	 * @deprecated Use ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 */
	@Deprecated
	public static ModelSet getModelSet() {
		try {
			return ServiceUtilsForActionHandlers.getInstance().getModelSet();
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the {@link ModelSet} for the currently selected editor. <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not
	 * designed to be call from Editors. This method can return null if called
	 * during the MultiEditor initialization.
	 * 
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet() Warning:
	 * 
	 * 
	 * @return The {@link TraceModel} of the current editor.
	 * @throws ServiceException
	 *         If an error occurs while getting or starting the service.
	 * @deprecated Use ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 */
	@Deprecated
	public static ModelSet getModelSetChecked() throws ServiceException {
		return ServiceUtilsForActionHandlers.getInstance().getModelSet();
	}

	/**
	 * Gets the ModelSet from the {@link ServicesRegistry}.
	 * 
	 * @return ServicesRegistry The service registry under which the ModelSet is
	 *         registered.
	 */
	public static ModelSet getModelSet(ServicesRegistry servicesRegistry) {
		try {
			return servicesRegistry.getService(ModelSet.class);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the ModelSet from the {@link ServicesRegistry}.
	 * 
	 * @return ServicesRegistry The service registry under which the ModelSet is
	 *         registered.
	 * @throws ServiceException
	 *         If the service can't be returned.
	 */
	public static ModelSet getModelSetChecked(ServicesRegistry servicesRegistry) throws ServiceException {
		return servicesRegistry.getService(ModelSet.class);
	}

	/**
	 * Determine if a throwable can be managed in degraded mode
	 * 
	 * @param t
	 */
	public static boolean isDegradedModeAllowed(Throwable t) {
		return t instanceof org.eclipse.emf.ecore.xmi.ClassNotFoundException || t instanceof IllegalValueException;
	}

	public static boolean resourceFailedOnLoad(Resource r) {
		if(r.getErrors() != null) {
			for(Diagnostic d : r.getErrors()) {
				if(d instanceof WrappedException) {
					WrappedException wrapped = (WrappedException)d;
					if(wrapped.getCause() instanceof ResourceException && r.getContents().isEmpty()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Returns the models to be loaded, in order according to their dependencies
	 * 
	 * @return the models to be loaded, in order according to their dependencies
	 */
	protected static List<IModel> getOrderedModelsForLoading(final Map<String, IModel> models) {
		//		L <= Empty list that will contain the sorted nodes
		//		while there are unmarked nodes do
		//		    select an unmarked node n
		//		    visit(n) 
		//		function visit(node n)
		//		    if n has a temporary mark then stop (not a DAG)
		//		    if n is not marked (i.e. has not been visited yet) then
		//		        mark n temporarily
		//		        for each node m with an edge from n to m do
		//		            visit(m)
		//		        mark n permanently
		//		        add n to head of L
		List<IModel> modelsToLoad = new ArrayList<IModel>(models.values());
		List<IModel> orderedModels = new ArrayList<IModel>();
		do {
			List<IModel> skippedModels = new ArrayList<IModel>();
			for(IModel model : modelsToLoad) {
				
				List<String> dependencies = model.getAfterLoadModelIdentifiers();
				// no dependency => start
				if(dependencies == null) {
					orderedModels.add(model);
				} else {
					// model has dependencies. Check if the dependencies are already inserted in the ordered list
					Collection<IModel> startedModels = Collections2.transform(dependencies, new Function<String, IModel>() {

						public IModel apply(String arg0) {
							return models.get(arg0);
						}
					});
					if(orderedModels.containsAll(startedModels)) {
						orderedModels.add(model);
					} else {
						skippedModels.add(model);
					}
				}
			}
			
			//  implement here a safeguard in case no models has been added to orderedModels
			if(!skippedModels.isEmpty() && skippedModels.size() == modelsToLoad.size()) {
				Activator.log.error("Impossible to load models. Cycles in dependency graph for the following set of models: "+modelsToLoad, null);
				break;
			} else {
				modelsToLoad = skippedModels;
			}
		} while(!modelsToLoad.isEmpty()); 
		
		return orderedModels;
	}
	
	/**
	 * Returns the resource from the model set. If the resource is not yet in the resource set, it will create it. Once it is created, if asked, it will load it. If it is already present, it will not load it.
	 * @param modelSet model set in which the resource should be
	 * @param loadAfterCreation <code>true</code> if the resource should be load if it has been created
	 * @param resourceURI the uri of the resource
	 * @param contentType the content type identifier of the resource if it has to be created.
	 * @return the resource found or created
	 */
	public static Resource getOrCreateResource(ModelSet modelSet, boolean loadAfterCreation, URI resourceURI, String contentType) {
		Resource resource = modelSet.getResource(resourceURI, false);
		if(resource == null) {
			resource = modelSet.createResource(resourceURI, contentType);
			if(loadAfterCreation) {
				try {
					resource.load(modelSet.getLoadOptions());
				} catch(IOException e) {
					// physical resource does not exists, but EMF resource itself is build.  
					Activator.log.debug(e.getMessage());
				} 
			}
		}
		return resource;
	}
}
