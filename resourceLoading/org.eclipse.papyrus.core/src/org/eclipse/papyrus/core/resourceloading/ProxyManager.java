/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.core.utils.DiResourceSet;


/**
 * The Class ProxyManager that manages the proxy resolving according a specific strategy.
 */
public class ProxyManager {
	
	// === Manage strategies

	/** extension point ID for loading strategy */
	private static final String LOADING_STRATEGY_EXTENSION_POINT_ID = "org.eclipse.papyrus.core.loadingStrategy";

	/** element ID for the loading strategy element */
	private static final String LOADING_STRATEGY_ELEMENT_ID = "loadingStrategy";

	/** attribute ID for identification of the strategy */
	private static final String LOADING_STRATEGY_ID = "id";

	/** attribute ID for the description of the strategy */
	private static final String LOADING_STRATEGY_DESCRIPTION_ID = "description";

	/** attribute ID for the implementation of the strategy */
	private static final String STRATEGY_ID = "strategy";
	
	// ==== Manage strategy extensions (for UML profile)
	
	/** extension point ID for strategy extensions */
	private static final String STRATEGY_EXTENDER_EXTENSION_POINT_ID = "org.eclipse.papyrus.core.loadingStrategyExtender";

	/** element ID for the loading strategy extension element */
	private static final String STRATEGY_EXTENDER_ELEMENT_ID = "strategyExtender";

	/** attribute ID for the description of the strategy extension */
	private static final String STRATEGY_EXTENDER_DESCRIPTION_ID = "description";

	/** attribute ID for the implementation of the strategy extension */
	private static final String STRATEGY_EXTENSION_ID = "strategyExtension";
	
	private DiResourceSet diResourceSet;

	/** custom commands from extensions */
	private static Map<Integer, ILoadingStrategy> availableStrategies = getLoadingStrategies();
	
	/** custom commands from strategy extensions */
	private static Set<ILoadingStrategyExtension> strategyExtensions = getLoadingStrategyExtensions();

	/** The strategies id and descriptions for preferences */
	private static Map<Integer, String> strategiesAndDescriptions = new HashMap<Integer, String>();
	
	/** The current strategy, default strategy id = 0 */
	private static int currentStrategy = 0; 

	public ProxyManager(DiResourceSet resourceSet) {
		super();
		diResourceSet = resourceSet;
		// TODO load currentStrategy in preference
		currentStrategy = 0;
	}

	private boolean loadResource(URI uri) {
		boolean result = availableStrategies.get(currentStrategy).loadResource(uri) ;
		Iterator<ILoadingStrategyExtension> iterator = strategyExtensions.iterator();
		while (!result && iterator.hasNext())
		{
			ILoadingStrategyExtension extension = (ILoadingStrategyExtension)iterator.next();
			result = extension.loadResource(diResourceSet, uri);
		}
		return result ;
	}
	
	public EObject getEObjectFromStrategy(URI uri) {
		// ask the strategy if the resource of the uri must be loaded
		boolean loadOnDemand = loadResource(uri);
		if(loadOnDemand) {
			Resource resource = diResourceSet.getResource(uri, loadOnDemand);
			if(resource != null) {
				EObject object = resource.getEObject(uri.fragment());
				if(object != null) {
					// object find in the resource
					return object;
				}
				// explore routes in historic
				// RouteManager should be used for that
				else {
					String fileExtension = uri.fileExtension();
					Resource diResource = null;
					if(DiResourceSet.DI_FILE_EXTENSION.equals(fileExtension)) {
						// proxy is in DI resource
						diResource = diResourceSet.getResource(uri, loadOnDemand);
					} else {
						// retrieve the DI resource from the uri to get the historic
						// TODO check if it needs to add the dot
						URI newURI = uri.trimFragment().trimFileExtension().appendFileExtension(DiResourceSet.DI_FILE_EXTENSION);
						diResource = diResourceSet.getResource(newURI, loadOnDemand);
					}

					// get the historic from the Di resource
					if(diResource != null) {
						// TODO resource.getHistoric();	
						// call the RouteManager to get the EObject
						// TODO algo de parcours à définir: largeur ou profondeur
						// c'est le routeurManager qui trouve l'object
						// return RouteManager.getEObject(uri, context);
						return null;

					} else {
						// resource di not found -> Error managed in proxyManager
						// warn the user, ask him to select the resource
						// return Popup.getChoice();
						return null;
					}
				}
			} else {
				// resource not found -> Error managed in proxyManager
				// warn the user, ask him to select a resource to search in
				// or ask to search in the entire resource set
				// or use a proxy
				// return Popup.getChoice();
				// strategy used for the specified resource only 
				return null;
			}
		} else {
			// we just want to manage a proxy for this object
			return null;
		}
	}
	
	/**
	 * Sets the current strategy.
	 *
	 * @param id the new current strategy id
	 */
	public static void setCurrentStrategy (int id)
	{
		currentStrategy = id ;
	}
	
	/**
	 * Gets the all strategies.
	 *
	 * @return the all strategies
	 */
	public static Map<Integer, String> getAllStrategies() {
		return strategiesAndDescriptions;
	}
	
	/**
	 * Gets the available strategies from extensions
	 * 
	 * @return the strategies
	 */
	private static Map<Integer, ILoadingStrategy> getLoadingStrategies() {
		Map<Integer, ILoadingStrategy> strategies = new HashMap<Integer, ILoadingStrategy>();
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(LOADING_STRATEGY_EXTENSION_POINT_ID);
		for(IConfigurationElement element : extensions) {
			if(LOADING_STRATEGY_ELEMENT_ID.equals(element.getName())) {
				try {
					// use description in extension to define preferences from the extensions
					int id = Integer.valueOf(element.getAttribute(LOADING_STRATEGY_ID));
					String description = element.getAttribute(LOADING_STRATEGY_DESCRIPTION_ID);
					ILoadingStrategy strategy = (ILoadingStrategy)element.createExecutableExtension(STRATEGY_ID);
					strategies.put(id, strategy);
					strategiesAndDescriptions.put(id, description);
				} catch (CoreException e1) {
					Activator.log.error(e1.getMessage(), e1);
					e1.printStackTrace();
				} catch (NumberFormatException e2) {
					Activator.log.error(e2.getMessage(), e2);
					e2.printStackTrace();
				}
			}
		}
		return strategies;
	}
	
	/**
	 * Gets the strategy extensions
	 * 
	 * @return the strategy extensions
	 */
	private static Set<ILoadingStrategyExtension> getLoadingStrategyExtensions() {
		Set<ILoadingStrategyExtension> strategies = new HashSet<ILoadingStrategyExtension>();
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(STRATEGY_EXTENDER_EXTENSION_POINT_ID);
		for(IConfigurationElement element : extensions) {
			if(STRATEGY_EXTENDER_ELEMENT_ID.equals(element.getName())) {
				try {
					String description = element.getAttribute(STRATEGY_EXTENDER_DESCRIPTION_ID);
					ILoadingStrategyExtension strategyExtension = (ILoadingStrategyExtension)element.createExecutableExtension(STRATEGY_EXTENSION_ID);
					strategies.add(strategyExtension);
				} catch (CoreException e) {
					Activator.log.error(e.getMessage(), e);
					e.printStackTrace();
				}
			}
		}
		return strategies;
	}

}
