/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Registry for the Aspect action factories.
 * <p>
 * This could be initialized and handled using extension points, instead of statically registered factories
 * </p>
 */
public class AspectActionFactoryRegistry {

	/** singleton instance of this factory */
	public static AspectActionFactoryRegistry instance;

	/** Factories */
	protected Map<String, IAspectActionProvider> factories;

	/**
	 * Constructor.
	 */
	protected AspectActionFactoryRegistry() {
		instance = this;
		factories = new HashMap<String, IAspectActionProvider>();
		init(); // this should be replaced by extension point mechanism

	}

	/**
	 * Initialize the factory
	 */
	protected void init() {
		// factories.put(StereotypeAspectActionProvider.FACTORY_ID, new
		// StereotypeAspectActionProvider());
		// factories.put(SemanticAspectActionProvider.FACTORY_ID, new
		// SemanticAspectActionProvider());
		// factories.put(GraphicalAspectActionFactory.GraphicalAspectActionProvider,
		// new GraphicalAspectActionProvider());
		// factories.put(DisplayAppliedStereotypeAspectActionProvider.FACTORY_ID,
		// new DisplayAppliedStereotypeAspectActionProvider());
		// factories.put(ChangeStereotypeDisplayAspectActionProvider.FACTORY_ID,
		// new ChangeStereotypeDisplayAspectActionProvider());
		// factories.put(AssociationEndAspectActionProvider.FACTORY_ID, new
		// AssociationEndAspectActionProvider());
	}

	/**
	 * Returns the singleton instance of this registry
	 * 
	 * @return the singleton instance of this class
	 */
	public static AspectActionFactoryRegistry getInstance() {
		if(instance == null) {
			instance = new AspectActionFactoryRegistry();
		}
		return instance;
	}

	public IAspectActionProvider getFactory(String id) {
		return factories.get(id);
	}

	/**
	 * Returns the list of registered aspect actions
	 * 
	 * @return the list of registered aspect actions
	 */
	public Collection<IAspectActionProvider> getAspectActionFactories() {
		return factories.values();
	}

}
