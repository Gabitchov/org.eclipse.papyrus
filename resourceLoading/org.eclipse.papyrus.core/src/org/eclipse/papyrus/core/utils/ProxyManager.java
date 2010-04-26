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
package org.eclipse.papyrus.core.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.core.Activator;


/**
 * The Class ProxyManager that manages the proxy resolving according a specific strategy.
 */
public class ProxyManager {

	/** extension point ID for loading strategy */
	private static final String LOADING_STRATEGY_EXTENSION_POINT_ID = "org.eclipse.papyrus.core.loadingStrategy";

	/** element ID for the loading strategy element */
	private static final String LOADING_STRATEGY_ELEMENT_ID = "loadingStrategy";

	/** attribute ID for identification of the strategy */
	private static final String ID = "id";

	/** attribute ID for the description of the strategy */
	private static final String DESCRIPTION_ID = "description";

	/** attribute ID for the implementation of the strategy */
	private static final String STRATEGY_ID = "strategy";

	/** custom commands from extensions */
	private static Map<Integer, ILoadingStrategy> availableStrategies = getLoadingStrategyExtensions();

	/** The strategies id and descriptions for preferences */
	private static Map<Integer, String> strategiesAndDescriptions = new HashMap<Integer, String>();
	
	/** The current strategy, default strategy id = 0 */
	private static int currentStrategy = 0; 

	public ProxyManager() {
		super();
		// TODO load currentStrategy in preference
		currentStrategy = 0;
	}

	public boolean loadResource(URI uri) {
		boolean result = availableStrategies.get(currentStrategy).loadResource(uri) ;
		Iterator i = null ; // extended strategy
		while (!result && i.hasNext())
		{
			//result = i.loadResource ;
		}
		return result ;
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
	private static Map<Integer, ILoadingStrategy> getLoadingStrategyExtensions() {
		Map<Integer, ILoadingStrategy> strategies = new HashMap<Integer, ILoadingStrategy>();
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(LOADING_STRATEGY_EXTENSION_POINT_ID);
		for(IConfigurationElement element : extensions) {
			if(LOADING_STRATEGY_ELEMENT_ID.equals(element.getName())) {
				try {
					// use description in extension to define preferences from the extensions
					int id = Integer.valueOf(element.getAttribute(ID));
					String description = element.getAttribute(DESCRIPTION_ID);
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

}
