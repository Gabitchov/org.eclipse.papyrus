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
package org.eclipse.papyrus.infra.services.resourceloading.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.services.resourceloading.Activator;
import org.eclipse.papyrus.infra.services.resourceloading.HistoryRoutingManager;
import org.eclipse.papyrus.infra.services.resourceloading.ILoadingStrategy;
import org.eclipse.papyrus.infra.services.resourceloading.ILoadingStrategyExtension;
import org.eclipse.papyrus.infra.services.resourceloading.IProxyManager;
import org.eclipse.papyrus.infra.services.resourceloading.IStrategyChooser;

/**
 * The Class ProxyManager that manages the proxy resolving according to a specific strategy.
 */
public class ProxyManager implements IProxyManager {

	// === Manage strategies

	/** extension point ID for loading strategy */
	private static final String LOADING_STRATEGY_EXTENSION_POINT_ID = "org.eclipse.papyrus.infra.services.resourceloading.loadingStrategy";

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
	private static final String STRATEGY_EXTENDER_EXTENSION_POINT_ID = "org.eclipse.papyrus.infra.services.resourceloading.loadingStrategyExtender";

	/** element ID for the loading strategy extension element */
	private static final String STRATEGY_EXTENDER_ELEMENT_ID = "strategyExtender";

	/** attribute ID for the implementation of the strategy extension */
	private static final String STRATEGY_EXTENSION_ID = "strategyExtension";

	// === Manage strategy chooser extension

	/** extension point ID for strategy chooser extension */
	private static final String STRATEGY_CHOOSER_EXTENSION_POINT_ID = "org.eclipse.papyrus.infra.services.resourceloading.currentStrategyChooser";

	/** attribute ID for the implementation of the strategy chooser extension used in preferences */
	private static final String STRATEGY_CHOOSER_CHOOSER_ATTRIBUTE = "chooser";

	private static IStrategyChooser strategyChooser = getStrategyChooser();

	// ===

	/** The strategies id and descriptions for preferences */
	private static Map<Integer, String> strategiesAndDescriptions = new HashMap<Integer, String>();

	/** custom commands from extensions */
	private static Map<Integer, ILoadingStrategy> availableStrategies = getLoadingStrategies();

	/** custom commands from strategy extensions */
	private static Set<ILoadingStrategyExtension> strategyExtensions = getLoadingStrategyExtensions();

	private ModelSet modelSet;

	private HistoryRoutingManager routeManager = new HistoryRoutingManager(this);

	public ProxyManager(ModelSet modelSet) {
		super();
		this.modelSet = modelSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.services.resourceloading.IProxyManager#loadResource(URI)
	 */
	public boolean loadResource(URI uri) {
		boolean result = availableStrategies.get(getCurrentStrategy()).loadResource(modelSet, uri);
		Iterator<ILoadingStrategyExtension> iterator = strategyExtensions.iterator();
		while(!result && iterator.hasNext()) {
			ILoadingStrategyExtension extension = iterator.next();
			result = extension.loadResource(modelSet, uri.trimFragment());
		}
		return result;
	}

	/**
	 * Gets the eobject according to the strategy.
	 * 
	 * @param uri
	 *        the specified uri to load
	 * @return the resolved eobject or the proxy, depending on the loading strategy
	 * @throws MissingResourceException
	 *         the missing resource exception
	 */
	public EObject getEObjectFromStrategy(URI uri) throws MissingResourceException {
		// ask the strategy if the resource of the uri must be loaded
		URI trimFragment = uri.trimFragment();
		boolean loadOnDemand = loadResource(trimFragment);
		// accept to recover object, either if strategy provides it, or if it has already been loaded anyway
		Resource resource = modelSet.getResource(trimFragment, loadOnDemand);
		if(resource != null) {
			String fragment = uri.fragment();
			EObject object = resource.getEObject(fragment);
			if(object != null) {
				// object find in the resource
				return object;
			}
			// use HistoryRoutingManager to explore routes in di resource history
			else {
				String fileExtension = uri.fileExtension();
				Resource diResource = null;
				String resourceName = "";
				if(SashModel.MODEL_FILE_EXTENSION.equals(fileExtension)) {
					// proxy is in DI resource
					diResource = modelSet.getResource(trimFragment, loadOnDemand);
					resourceName = trimFragment.toString();
				} else {
					// retrieve the DI resource from the uri to get the history
					URI newURI = trimFragment.trimFileExtension().appendFileExtension(SashModel.MODEL_FILE_EXTENSION);
					try {
						diResource = modelSet.getResource(newURI.trimFragment(), loadOnDemand);
					}
					catch (WrappedException e) {
						// capture wrapped exception here, see Bug 405047 - [core] FileNotFoundException during MARTE profile load
						throw new MissingResourceException(CommonPlugin.INSTANCE.getString("_UI_StringResourceNotFound_exception", new Object[]{ resourceName }), getClass().getName(), resourceName);
					}
					resourceName = newURI.trimFragment().toString();
				}
				if(diResource != null) {
					// call the HistoryRoutingManager to get the EObject
					// we assume di/notation are at the same level in folder hierarchy
					EObject eobject = routeManager.getEObject(modelSet, uri.lastSegment().toString(), fragment);
					if(eobject == null) {
						throw new MissingResourceException(CommonPlugin.INSTANCE.getString("_UI_StringResourceNotFound_exception", new Object[]{ resourceName }), getClass().getName(), resourceName);
					}
					return eobject;

				} else {
					// resource di not found
					// warn the user, ask him to select the resource
					throw new MissingResourceException(CommonPlugin.INSTANCE.getString("_UI_StringResourceNotFound_exception", new Object[]{ resourceName }), getClass().getName(), resourceName);
				}
			}
		} else if(loadOnDemand) {
			// resource not found
			// warn the user, ask him to select a resource to search in
			// or ask to search in the entire resource set
			// or use a proxy
			// strategy used for the specified resource only
			throw new MissingResourceException(CommonPlugin.INSTANCE.getString("_UI_StringResourceNotFound_exception", new Object[]{ trimFragment.toString() }), getClass().getName(), trimFragment.toString());
		} else {
			// we just want to manage a proxy for this object
			return null;
		}
	}

	/**
	 * Gets the current strategy.
	 * 
	 * @return the current strategy, strategy 0 (load all resources) is loaded by default if null
	 */
	private static int getCurrentStrategy() {
		if(strategyChooser == null) {
			return 0;
		}
		return strategyChooser.getCurrentStrategy();
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

	/**
	 * There is only one Strategy chooser chosen in extension registry.
	 * 
	 * @return
	 */
	public static IStrategyChooser getStrategyChooser() {
		IStrategyChooser result = null;
		IConfigurationElement[] element = Platform.getExtensionRegistry().getConfigurationElementsFor(STRATEGY_CHOOSER_EXTENSION_POINT_ID);
		if(element.length > 0) {
			IConfigurationElement e = element[0];
			try {
				result = (IStrategyChooser)e.createExecutableExtension(STRATEGY_CHOOSER_CHOOSER_ATTRIBUTE);
			} catch (CoreException e1) {
				Activator.log.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}
		return result;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.services.resourceloading.IProxyManager#dispose()
	 */
	public void dispose() {
		routeManager.unload();
	}

}
