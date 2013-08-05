/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.externalresource.helper;

import java.util.HashMap;
import java.util.Map;


/**
 *	 Registry for all {@link IStereotypeApplicationLocationStrategy}.
 */
public class StrategyRegistry {
	
	/** singleton instance */
	private static StrategyRegistry instance;
	
	/** map identifier - strategies */
	private Map<String, IStereotypeApplicationLocationStrategy> registry;

	/**
	 * Returns the singleton instance for this strategy
	 * 
	 * @return the singleton instance for this strategy
	 */
	public static StrategyRegistry getInstance() {
		if(instance == null) {
			instance = new StrategyRegistry();
			instance.init();
		}
		return instance;
	}

	/**
	 * Initialize the strategy registry, reading extension points.
	 */
	protected void init() {
		// TODO: read extension points.
		registry = new HashMap<String, IStereotypeApplicationLocationStrategy>();
		registry.put(StandardApplicationLocationStrategy.ID, StandardApplicationLocationStrategy.getInstance());
		registry.put(OneResourceOnlyStrategy.ID, OneResourceOnlyStrategy.getInstance());
		registry.put(ResourcePerProfileStrategy.ID, ResourcePerProfileStrategy.getInstance());
	}

	/**
	 * Returns the strategy for the given identifier
	 * @param identifier identifier of the strategy
	 * @return the strategy found or <code>null</code> if none was found
	 */
	public IStereotypeApplicationLocationStrategy getStrategy(String identifier) {
		return registry.get(identifier);
	}
}
