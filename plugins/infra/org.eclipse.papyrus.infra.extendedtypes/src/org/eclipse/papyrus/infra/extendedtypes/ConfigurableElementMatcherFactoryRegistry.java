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
package org.eclipse.papyrus.infra.extendedtypes;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.osgi.framework.Bundle;

/**
 * Registry for all element matcher factories for element matcher based on {@link MatcherConfiguration}.
 */
public class ConfigurableElementMatcherFactoryRegistry {

	/** private singleton instance */
	private static ConfigurableElementMatcherFactoryRegistry registry;

	protected Map<String, IConfigurableElementMatcherFactory<MatcherConfiguration>> configurationTypeToMatcherFactory = null;
	
	protected List<String> configurationTypeFactoryExceptions = null;
	
	/**
	 * returns the singleton instance of this registry
	 * 
	 * @return the singleton instance of this registry
	 */
	public static synchronized ConfigurableElementMatcherFactoryRegistry getInstance() {
		if(registry == null) {
			registry = new ConfigurableElementMatcherFactoryRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		configurationTypeToMatcherFactory = new HashMap<String, IConfigurableElementMatcherFactory<MatcherConfiguration>>();
		
	}

	/**
	 * Creates the {@link IElementMatcher} specific to the given rule configuration
	 * 
	 * @param ruleConfiguration
	 *        the rule configuration that will configure the created matcher
	 * @return the {@link IElementMatcher} created or <code>null</code> if none could be created
	 */
	public IConfigurableElementMatcher<MatcherConfiguration> createElementMatcher(MatcherConfiguration matcherConfiguration) {
		String configurationType = matcherConfiguration.eClass().getInstanceTypeName();
		IConfigurableElementMatcherFactory<MatcherConfiguration> factory = configurationTypeToMatcherFactory.get(configurationType);
		// check factory is not on the exception table
		if(factory == null && isNotInFactoryExceptionList(configurationType)) {
			Class<IConfigurableElementMatcherFactory<MatcherConfiguration>> factoryClass = retrieveFactoryClassFromExtensionPoint(configurationType);
			if(factoryClass != null) {
				try {
					factory = factoryClass.newInstance();
				} catch (InstantiationException e) {
					if(configurationTypeFactoryExceptions == null) {
						configurationTypeFactoryExceptions = new ArrayList<String>();
					}
					configurationTypeFactoryExceptions.add(configurationType);
				} catch (IllegalAccessException e) {
					if(configurationTypeFactoryExceptions == null) {
						configurationTypeFactoryExceptions = new ArrayList<String>();
					}
					configurationTypeFactoryExceptions.add(configurationType);
				}
				configurationTypeToMatcherFactory.put(configurationType, factory);
			}
		}
		if(factory != null) {
			IConfigurableElementMatcher<MatcherConfiguration> elementMatcher = factory.createElementMatcher(matcherConfiguration);
			if(elementMatcher !=null) {
				//elementMatcher.init(matcherConfiguration);
				return elementMatcher;
			}
		}
		return null;		
	}
	
	/**
	 * check this configuration type has not already caused issues du
	 * 
	 * @param configurationType
	 * @return
	 */
	protected boolean isNotInFactoryExceptionList(String configurationType) {
		if(configurationTypeFactoryExceptions == null) {
			return true;
		}
		// this is not null, check the configuration type is not in the list
		return !configurationTypeFactoryExceptions.contains(configurationType);
	}

	/**
	 * Returns the {@link IExtendedElementTypeFactory} class used to instantiate element type for the given configuration
	 * 
	 * @return the {@link IExtendedElementTypeFactory} found or <code>null</code> if none was found
	 */
	@SuppressWarnings("unchecked")
	protected Class<IConfigurableElementMatcherFactory<MatcherConfiguration>> retrieveFactoryClassFromExtensionPoint(String configurationType) {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IElementMatcherExtensionPoint.EXTENSION_POINT_ID);
		for(IConfigurationElement configurationElement : elements) {
			String eCoreClassName = configurationElement.getAttribute(IElementMatcherExtensionPoint.MATCHER_CONFIGURATION_CLASS);
			if(configurationType.equals(eCoreClassName)) {
				// retrieve factory to load
				String factoryClassName = configurationElement.getAttribute(IElementMatcherExtensionPoint.MATCHER_FACTORY_CLASS);
				return (Class<IConfigurableElementMatcherFactory<MatcherConfiguration>>)loadClass(factoryClassName, configurationElement.getContributor().getName());
			}
		}
		return null;
	}
	
	///////////////////////////////////////////////////////////////////////////
	// loading resource
	///////////////////////////////////////////////////////////////////////////
	/** A map of classes that have been successfully loaded, keyed on the class name optionally prepended by the plugin ID, if specified. */
	private static Map<String, WeakReference<Class<?>>> successLookupTable = new HashMap<String, WeakReference<Class<?>>>();

	/** A map of classes that could not be loaded, keyed on the class name, optionally prepended by the plugin ID if specified. */
	private static Set<String> failureLookupTable = new HashSet<String>();

	/** A map to hold the bundle to exception list */
	private static Map<Bundle, Set<String>> bundleToExceptionsSetMap = new HashMap<Bundle, Set<String>>();

	/**
	 * A utility method to load a class using its name and a given class loader.
	 * 
	 * @param className
	 *        The class name
	 * @param bundle
	 *        The class loader
	 * @return The loaded class or <code>null</code> if could not be loaded
	 */
	protected static Class<?> loadClass(String className, String pluginId) {
		StringBuffer keyStringBuf = new StringBuffer(className.length() + pluginId.length() + 2); // 2 is for . and extra.
		keyStringBuf.append(pluginId);
		keyStringBuf.append('.');
		keyStringBuf.append(className);
		String keyString = keyStringBuf.toString();
		WeakReference<Class<?>> ref = successLookupTable.get(keyString);
		Class<?> found = (ref != null) ? ref.get() : null;
		if(found == null) {
			if(ref != null)
				successLookupTable.remove(keyString);
			if(!failureLookupTable.contains(keyString)) {
				try {
					Bundle bundle = basicGetPluginBundle(pluginId);
					if(bundle != null) {
						// never load the class if the bundle is not active other wise
						// we will cause the plugin to load
						// unless the class is in the exception list
						int state = bundle.getState();
						if(state == org.osgi.framework.Bundle.ACTIVE || isInExceptionList(bundle, className)) {
							found = bundle.loadClass(className);
							successLookupTable.put(keyString, new WeakReference<Class<?>>(found));
							if(state == org.osgi.framework.Bundle.ACTIVE) {
								bundleToExceptionsSetMap.remove(bundle);
							}
						}
					} else {
						failureLookupTable.add(keyString);
					}
				} catch (ClassNotFoundException e) {
					failureLookupTable.add(keyString);
				}
			}
		}
		return found;
	}

	/**
	 * Given a bundle id, it checks if the bundle is found and activated. If it
	 * is, the method returns the bundle, otherwise it returns <code>null</code>.
	 * 
	 * @param pluginId
	 *        the bundle ID
	 * @return the bundle, if found
	 */
	protected static Bundle getPluginBundle(String pluginId) {
		Bundle bundle = basicGetPluginBundle(pluginId);
		if(null != bundle && bundle.getState() == org.osgi.framework.Bundle.ACTIVE)
			return bundle;
		return null;
	}

	private static Bundle basicGetPluginBundle(String pluginId) {
		return Platform.getBundle(pluginId);
	}

	private static boolean isInExceptionList(Bundle bundle, String className) {
		String packageName = className.substring(0, className.lastIndexOf('.'));
		Set<String> exceptionSet = bundleToExceptionsSetMap.get(bundle);
		if(exceptionSet == null) {
			Dictionary<String, String> dict = bundle.getHeaders();
			String value = dict.get("Eclipse-LazyStart"); //$NON-NLS-1$
			if(value != null) {
				int index = value.indexOf("exceptions"); //$NON-NLS-1$
				if(index != -1) {
					try {
						int start = value.indexOf('"', index + 1);
						int end = value.indexOf('"', start + 1);
						String exceptions = value.substring(start + 1, end);
						exceptionSet = new HashSet<String>(2);
						StringTokenizer tokenizer = new StringTokenizer(exceptions, ","); //$NON-NLS-1$
						while(tokenizer.hasMoreTokens()) {
							exceptionSet.add(tokenizer.nextToken().trim());
						}
					} catch (IndexOutOfBoundsException exception) {
						// this means the MF did not follow the documented format for the exceptions list  so i'll consider it empty
						exceptionSet = Collections.emptySet();
					}
				} else {
					exceptionSet = Collections.emptySet();
				}
			} else {
				exceptionSet = Collections.emptySet();
			}
			bundleToExceptionsSetMap.put(bundle, exceptionSet);
		}
		return exceptionSet.contains(packageName);
	}
}
