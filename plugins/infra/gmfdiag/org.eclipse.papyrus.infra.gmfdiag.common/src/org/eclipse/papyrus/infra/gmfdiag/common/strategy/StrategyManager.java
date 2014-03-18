/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.strategy;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
//import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Singleton instance. This class is used to read and manage the various
 * DropStrategies: activation, order (priority)
 * 
 */
public class StrategyManager implements IStrategyManager {


	/**
	 * The priority property suffix (For preferences)
	 */
	public static final String PRIORITY_KEY = "priority"; //$NON-NLS-1$

	/**
	 * The isActive property suffix (For preferences)
	 */
	public static final String IS_ACTIVE_KEY = "isActive"; //$NON-NLS-1$

	/**
	 * The default strategy property suffix (For preferences)
	 */
	public static final String DEFAULT_STRATEGY_KEY = "defaultStrategy"; //$NON-NLS-1$

	
	/**
	 * The drop strategy extension point
	 */
	protected /*static final*/ String EXTENSION_ID = ""; //Activator.ID + ".dropStrIStrategy";
		
	
	/**
	 * All DropStrategies, defined through an extension point
	 * The values are grouped by priority.
	 * 
	 * (Including the DefaultDropStrategy)
	 */
	protected /*final*/ SortedMap<Integer, List<IStrategy>> allAvailableStrategies;

	/**
	 * A map to indicate whether each IStrategy is active
	 */
	protected /*final*/ Map<IStrategy, Boolean> activeStrategies;

	/**
	 * The map of default strategies for each known conflicting case
	 */
	protected /*final*/ Map<Set<IStrategy>, IStrategy> defaultStrategies;

	/**
	 * Stores a map of String/Integer (Strategy id / priority)
	 * and String/Boolean (Strategy id / boolean)
	 * 
	 * The ids are suffixed by the property name, e.g. :
	 * 
	 * oep.myStrategy.isActive=true
	 * oep.myStrategy.priority=12
	 */
	protected /*final*/ IPreferenceStore preferences;

	protected StrategyManager(String extensionId ) {
		EXTENSION_ID = extensionId;
		allAvailableStrategies = new TreeMap<Integer, List<IStrategy>>();
		activeStrategies = new HashMap<IStrategy, Boolean>();
		defaultStrategies = new HashMap<Set<IStrategy>, IStrategy>();
		preferences = Activator.getInstance().getPreferenceStore();
		init();
	}
	
	protected StrategyManager() {
		allAvailableStrategies = new TreeMap<Integer, List<IStrategy>>();
		activeStrategies = new HashMap<IStrategy, Boolean>();
		defaultStrategies = new HashMap<Set<IStrategy>, IStrategy>();
		preferences = Activator.getInstance().getPreferenceStore();
		init();
	}

	protected void init() {
		initStrategies(); //Init all available strategies, reads the priorities
		initActiveStrategies(); //Reads whether each available strategy is active 
		initDefaultPreferences(); //Inits the preference store's default values (priority + isActive)
		initDefaultDropStrategies(); //Inits the default drop strategies
	}

	protected void initStrategies() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		//Loads all strategies from the extension point.
		for(IConfigurationElement e : config) {
			try {
				if("strategy".equals(e.getName())) {
					IStrategy strategy = (IStrategy)e.createExecutableExtension("strategy"); //$NON-NLS-1$
					int priority = findPriority(strategy);
					getStrategies(priority).add(strategy);
				}
			} catch (Exception ex) {
				Activator.log.error("The plugin " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID, ex); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	private void initActiveStrategies() {
		for(List<IStrategy> strategies : allAvailableStrategies.values()) {
			for(IStrategy strategy : strategies) {
				activeStrategies.put(strategy, isActive(strategy));
			}
		}
	}

	private void initDefaultPreferences() {
		for(Collection<IStrategy> strategies : allAvailableStrategies.values()) {
			for(IStrategy strategy : strategies) {
				preferences.setDefault(getPriorityKey(strategy), strategy.getPriority());
				preferences.setDefault(getIsActiveKey(strategy), true);
			}
		}
	}

	private void initDefaultDropStrategies() {
		try {
			for(String key : InstanceScope.INSTANCE.getNode(Activator.ID).keys()) {
				if(key.endsWith(DEFAULT_STRATEGY_KEY)) {
					parseDefaultDropStrategy(key);
				}
			}
		} catch (BackingStoreException ex) {
			Activator.log.error("Could not initialize the default Drag & Drop strategy choices", ex);
		}
	}

	public IStrategy findStrategy(String id) {
		for(IStrategy strategy : getAllStrategies()) {
			if(strategy.getID().equals(id)) {
				return strategy;
			}
		}
		return null;
	}

	private void parseDefaultDropStrategy(String key) {
		String[] strategyIds = key.substring(0, key.lastIndexOf(":")).split(":");

		Set<IStrategy> strategies = new HashSet<IStrategy>();
		for(String strategyId : strategyIds) {
			IStrategy strategy = findStrategy(strategyId);
			if(strategy == null) {
				return; //Invalid preference ; skip
			}
			strategies.add(strategy);
		}

		if(strategies.size() > 1) {
			defaultStrategies.put(strategies, findStrategy(preferences.getString(key)));
		}
	}

	/**
	 * Returns a collection of all DropStrategy with the given priority.
	 * Never returns null
	 * 
	 * @param priority
	 * @return
	 */
	private List<IStrategy> getStrategies(int priority) {
		if(!allAvailableStrategies.containsKey(priority)) {
			allAvailableStrategies.put(priority, new LinkedList<IStrategy>());
		}
		return allAvailableStrategies.get(priority);
	}

	/**
	 * Returns a list of all active IStrategy, ordered by priority. Never returns null.
	 * 
	 * @return
	 */
	public List<IStrategy> getActiveStrategies() {
		List<IStrategy> orderedActiveStrategies = new LinkedList<IStrategy>();
		for(List<IStrategy> strategies : allAvailableStrategies.values()) {
			for(IStrategy strategy : strategies) {
				if(isActive(strategy)) {
					orderedActiveStrategies.add(strategy);
				}
			}
		}
		return orderedActiveStrategies;
	}

	/**
	 * The values are grouped by priority.
	 * 
	 * (Including the DefaultIStrategy)
	 */
	@Deprecated // remove all ref to priority
	public Map<Integer, List<IStrategy>> getAllAvailableStrategies() {
		return allAvailableStrategies;
	}

	public static String getPriorityKey(IStrategy strategy) {
		return strategy.getID() + "." + PRIORITY_KEY;
	}

	public static String getIsActiveKey(IStrategy strategy) {
		return strategy.getID() + "." + IS_ACTIVE_KEY;
	}

	public static String getDefaultStrategyKey(Collection<IStrategy> conflict) {
		List<IStrategy> orderedStrategies = new LinkedList<IStrategy>(conflict);

		Collections.sort(orderedStrategies, new Comparator<IStrategy>() {

			public int compare(IStrategy strategy1, IStrategy strategy2) {
				return Collator.getInstance().compare(strategy1.getID(), strategy2.getID());
			}

		});

		String key = ""; //$NON-NLS-1$
		for(IStrategy strategy : conflict) {
			key += strategy.getID() + ":";
		}
		key += DEFAULT_STRATEGY_KEY;

		return key;
	}

	public int findPriority(IStrategy strategy) {
		String preferenceKey = getPriorityKey(strategy);
		if(preferences.contains(preferenceKey)) {
			return preferences.getInt(preferenceKey);
		}

		return strategy.getPriority(); //Default
	}

	public boolean isActive(IStrategy strategy) {
		String preferenceKey = getIsActiveKey(strategy);
		if(preferences.contains(preferenceKey)) {
			return preferences.getBoolean(preferenceKey);
		}

		return true; //Default
	}

	public void setActive(IStrategy strategy, boolean active) {
		preferences.setValue(getIsActiveKey(strategy), active);
		activeStrategies.put(strategy, active);
	}

	public void setPriority(IStrategy strategy, int priority) {
		//Remove the IStrategy from its previous priority
		getStrategies(findPriority(strategy)).remove(strategy);

		//Add it again at the right priority
		preferences.setValue(getPriorityKey(strategy), priority);
		getStrategies(priority).add(strategy);
	}

	// TODO make private
	public static final StrategyManager instance = new StrategyManager();

	/**
	 * Returns a flat list of all available strategies.
	 * 
	 * The strategies are ordered by priority
	 * 
	 * @return
	 */
	public List<IStrategy> getAllStrategies() {
		List<IStrategy> result = new LinkedList<IStrategy>();
		for(List<IStrategy> strategies : allAvailableStrategies.values()) {
			result.addAll(strategies);
		}
		return result;
	}

	/**
	 * Restores the default preferences
	 */
	public void restoreDefaults() {
		try {
			IEclipsePreferences preferenceStore = InstanceScope.INSTANCE.getNode(Activator.ID);
			preferenceStore.clear();
			preferenceStore.flush();
		} catch (BackingStoreException ex) {
			Activator.log.error(ex);
		}
		activeStrategies.clear();
		allAvailableStrategies.clear();
		defaultStrategies.clear();
		initStrategies();
		initActiveStrategies();
		initDefaultDropStrategies();
	}

	/**
	 * Returns the default drop strategy among the given list, or null if there is
	 * no default.
	 * 
	 * @param strategies
	 * @return
	 */
	// TODO : Rename
	public IStrategy getDefaultDropStrategy(Collection<IStrategy> strategies) {
		if(strategies.isEmpty()) {
			return null;
		}

		IStrategy defaultStrategy;

		if(strategies.size() == 1) {
			defaultStrategy = strategies.iterator().next();
		} else {
			Set<IStrategy> conflictingStrategies = new HashSet<IStrategy>(strategies);
			defaultStrategy = defaultStrategies.get(conflictingStrategies);
		}

		if(defaultStrategy == null) {
			return null;
		}

		return isActive(defaultStrategy) ? defaultStrategy : null;
	}

	/**
	 * Sets the default drop strategy for a set of conflicting strategies
	 * 
	 * @param conflictingStrategies
	 * @param defaultStrategy
	 */
	public void setDefaultDropStrategy(Collection<IStrategy> conflictingStrategies, IStrategy defaultStrategy) {
		if(conflictingStrategies.size() < 2) {
			return;
		}

		Set<IStrategy> conflict = new HashSet<IStrategy>(conflictingStrategies);
		defaultStrategies.put(conflict, defaultStrategy);
		preferences.putValue(getDefaultStrategyKey(conflict), defaultStrategy.getID());

		//Save the preferences
		IEclipsePreferences preferenceStore = InstanceScope.INSTANCE.getNode(Activator.ID);
		try {
			preferenceStore.flush();
		} catch (BackingStoreException ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * Return all active strategies
	 */
	@Override
	public List<IStrategy> getAllActiveStrategies() {
		List<IStrategy> res = new ArrayList<IStrategy>();	
		List<IStrategy> allStrategies = getAllStrategies();
		for (IStrategy iStrategy : allStrategies) {
			if (isActive(iStrategy)){
				res.add(iStrategy);
			}
		}
		return res;
	}


}
