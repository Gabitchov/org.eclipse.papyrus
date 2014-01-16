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
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.osgi.framework.Bundle;

/**
 * Registry for all matcher factories.
 */
public class RuleConfigurationFactoryRegistry {

	/** private singleton instance */
	private static RuleConfigurationFactoryRegistry registry;

	/** map configuration type to matcher descriptor */
	protected Map<String, ConfigurableClassDescriptor> configurationTypeToClassDescriptor = null;

	/**
	 * returns the singleton instance of this registry
	 * 
	 * @return the singleton instance of this registry
	 */
	public static synchronized RuleConfigurationFactoryRegistry getInstance() {
		if(registry == null) {
			registry = new RuleConfigurationFactoryRegistry();
			registry.init();
		}
		return registry;
	}

	/**
	 * Inits the registry.
	 */
	protected void init() {
		configurationTypeToClassDescriptor = new  HashMap<String, RuleConfigurationFactoryRegistry.ConfigurableClassDescriptor>();
		//read invariant rule configuration etension point
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IInvariantRuleExtensionPoint.EXTENSION_POINT_ID);
		// for each element, parses and retrieve the model file. then loads it and returns the root element 
		for(IConfigurationElement configurationElement : elements) {
			// contributor will always be the same, but implementation could be different.  
			String contributorName = configurationElement.getContributor().getName();

			String configurationClass = configurationElement.getAttribute(IInvariantRuleExtensionPoint.RULE_CONFIGURATION_CLASS);
			
			String matcherClassName = configurationElement.getAttribute(IInvariantRuleExtensionPoint.ELEMENT_MATCHER_CLASS);
			String editHelperAdviceClassName = configurationElement.getAttribute(IInvariantRuleExtensionPoint.EDIT_HELPER_ADVICE_CLASS);
			String containerDescriptorClassName = configurationElement.getAttribute(IInvariantRuleExtensionPoint.CONTAINER_DESCRIPTOR_CLASS);
			String creationElementValidatorClassName = configurationElement.getAttribute(IInvariantRuleExtensionPoint.CREATION_ELEMENT_VALIDATOR_CLASS);
			
			ConfigurableClassDescriptor configurableClassDescriptor = new ConfigurableClassDescriptor(contributorName, matcherClassName, contributorName, editHelperAdviceClassName, contributorName, containerDescriptorClassName, contributorName, creationElementValidatorClassName);
			configurationTypeToClassDescriptor.put(configurationClass, configurableClassDescriptor);
		}

	}

	/**
	 * Creates the {@link IElementMatcher} specific to the given rule configuration
	 * 
	 * @param ruleConfiguration
	 *        the rule configuration that will configure the created matcher
	 * @return the {@link IElementMatcher} created or <code>null</code> if none could be created
	 */
	public IInvariantElementMatcher<InvariantRuleConfiguration> createMatcher(InvariantRuleConfiguration ruleConfiguration) {
		// creates the matcher from the extension points
		Class<IInvariantElementMatcher<InvariantRuleConfiguration>> elementMatcherClass = getMatcherClass(ruleConfiguration);
		if(elementMatcherClass == null) {
			return null;
		}
		try {
			IInvariantElementMatcher<InvariantRuleConfiguration> matcher = elementMatcherClass.newInstance();
			if(matcher != null) {
				matcher.init(ruleConfiguration);
			}
			return matcher;
		} catch (InstantiationException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * @param ruleConfiguration
	 * @return
	 */
	public IInvariantContainerDescriptor<InvariantRuleConfiguration> createContainerDescriptor(InvariantRuleConfiguration ruleConfiguration) {
		Class<IInvariantContainerDescriptor<InvariantRuleConfiguration>> containerDescriptorClass = getContainerDescriptorClass(ruleConfiguration);
		if(containerDescriptorClass == null) {
			return null;
		}
		try {
			IInvariantContainerDescriptor<InvariantRuleConfiguration> containerDescriptor = containerDescriptorClass.newInstance();
			if(containerDescriptor != null) {
				containerDescriptor.init(ruleConfiguration);
			}
			return containerDescriptor;
		} catch (InstantiationException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * @param ruleConfiguration
	 * @return
	 */
	public IInvariantEditHelperAdvice<InvariantRuleConfiguration> createEditHelperAdvice(InvariantRuleConfiguration ruleConfiguration) {
		Class<IInvariantEditHelperAdvice<InvariantRuleConfiguration>> editHelperAdviceClass = getEditHelperAdviceClass(ruleConfiguration);
		if(editHelperAdviceClass == null) {
			Activator.log.error("impossible to find the edit helper advice implementation for configuration type : " + ((ruleConfiguration!=null) ? ruleConfiguration.eClass().getName() : "null"), null);
			return null;
		}
		try {
			IInvariantEditHelperAdvice<InvariantRuleConfiguration> editHelperAdvice = editHelperAdviceClass.newInstance();
			if(editHelperAdvice != null) {
				editHelperAdvice.init(ruleConfiguration);
			}
			return editHelperAdvice;
		} catch (InstantiationException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		}
		return null;
	}
	
	/**
	 * @param ruleConfiguration
	 * @return
	 */
	public IInvariantCreationElementValidator<InvariantRuleConfiguration> createCreationElementValidator(InvariantRuleConfiguration ruleConfiguration) {
		Class<IInvariantCreationElementValidator<InvariantRuleConfiguration>> creationElementValidatorClass = getCreationElementValidatorClass(ruleConfiguration);
		if(creationElementValidatorClass == null) {
			// Activator.log.error("impossible to find the Creation Element Validator for configuration type : " + ((ruleConfiguration!=null) ? ruleConfiguration.eClass().getName() : "null"), null);
			return null;
		}
		try {
			IInvariantCreationElementValidator<InvariantRuleConfiguration> creationElementValidator = creationElementValidatorClass.newInstance();
			if(creationElementValidator != null) {
				creationElementValidator.init(ruleConfiguration);
			}
			return creationElementValidator;
		} catch (InstantiationException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		}
		return null;
	}
	
	
	/**
	 * @param ruleConfiguration
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<IInvariantCreationElementValidator<InvariantRuleConfiguration>> getCreationElementValidatorClass(InvariantRuleConfiguration configuration) {
		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getCreationElementValidatorClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getCreationElementValidatorContributorName();
		
		// look in the list of registered matcher for the right one
		if(className ==null) {
			 //Activator.log.error("There should be an implementation class for the configuration "+configurationType+ " from contributor "+contributorName, null);
		} else if(contributorName !=null) {
			return (Class<IInvariantCreationElementValidator<InvariantRuleConfiguration>>)loadClass(className, contributorName);
		} 
		return null;
	}

	/**
	 * @param configurationType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<IInvariantElementMatcher<InvariantRuleConfiguration>> getMatcherClass(InvariantRuleConfiguration configuration) {
		
		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getElementMatcherClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getElementMatcherContributorName();
		
		// look in the list of registered matcher for the right one
		if(className !=null && contributorName !=null) {
			return (Class<IInvariantElementMatcher<InvariantRuleConfiguration>>)loadClass(className, contributorName);
		}
		return null;
	}
	
	/**
	 * @param configurationType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<IInvariantEditHelperAdvice<InvariantRuleConfiguration>> getEditHelperAdviceClass(InvariantRuleConfiguration configuration) {
		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getEditHelperAdviceClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getEditHelperAdviceContributorName();
		
		// look in the list of registered edit helper advices for the right one
		return (Class<IInvariantEditHelperAdvice<InvariantRuleConfiguration>>)loadClass(className, contributorName);
	}

	/**
	 * @param configurationType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<IInvariantContainerDescriptor<InvariantRuleConfiguration>> getContainerDescriptorClass(InvariantRuleConfiguration configuration) {
		String configurationType = configuration.eClass().getInstanceClassName();
		String className = configurationTypeToClassDescriptor.get(configurationType).getContainerDescriptorClassName();
		String contributorName = configurationTypeToClassDescriptor.get(configurationType).getContainerDescriptorContributorName();
		
		
		// look in the list of registered edit helper advices for the right one
		if(className !=null && contributorName !=null) {
			return (Class<IInvariantContainerDescriptor<InvariantRuleConfiguration>>)loadClass(className, contributorName);
		}
		return null;
	}

	protected static class ConfigurableClassDescriptor {
		
		/**
		 * @param elementMatcherContributorName
		 * @param elementMatcherClassName
		 * @param editHelperAdviceContributorName
		 * @param editHelperAdviceClassName
		 * @param containerDescriptorContributorName
		 * @param containerDescriptorClassName
		 */
		public ConfigurableClassDescriptor(String elementMatcherContributorName, String elementMatcherClassName, String editHelperAdviceContributorName, String editHelperAdviceClassName, String containerDescriptorContributorName, String containerDescriptorClassName, String creationElementValidatorContributorName, String creationElementValidatorClassName) {
			this.elementMatcherContributorName = elementMatcherContributorName;
			this.elementMatcherClassName = elementMatcherClassName;
			this.editHelperAdviceContributorName = editHelperAdviceContributorName;
			this.editHelperAdviceClassName = editHelperAdviceClassName;
			this.containerDescriptorContributorName = containerDescriptorContributorName;
			this.containerDescriptorClassName = containerDescriptorClassName;
			this.creationElementValidatorContributorName = creationElementValidatorContributorName;
			this.creationElementValidatorClassName = creationElementValidatorClassName;
		}

		private final String elementMatcherContributorName;
		
		private final String elementMatcherClassName;
		
		private final String editHelperAdviceContributorName;
		
		private final String editHelperAdviceClassName;
		
		private final String containerDescriptorContributorName;
		
		private final String containerDescriptorClassName;

		private final String creationElementValidatorContributorName;

		private final String creationElementValidatorClassName;

		/**
		 * @return
		 */
		public String getCreationElementValidatorContributorName() {
			return creationElementValidatorContributorName;
		}

		/**
		 * @return
		 */
		public String getCreationElementValidatorClassName() {
			return creationElementValidatorClassName;
		}
		
		/**
		 * @return the elementMatcherContributorName
		 */
		public String getElementMatcherContributorName() {
			return elementMatcherContributorName;
		}

		
		/**
		 * @return the elementMatcherClassName
		 */
		public String getElementMatcherClassName() {
			return elementMatcherClassName;
		}

		
		/**
		 * @return the editHelperAdviceContributorName
		 */
		public String getEditHelperAdviceContributorName() {
			return editHelperAdviceContributorName;
		}

		
		/**
		 * @return the editHelperAdviceClassName
		 */
		public String getEditHelperAdviceClassName() {
			return editHelperAdviceClassName;
		}

		
		/**
		 * @return the containerDescriptorContributorName
		 */
		public String getContainerDescriptorContributorName() {
			return containerDescriptorContributorName;
		}

		
		/**
		 * @return the containerDescriptorClassName
		 */
		public String getContainerDescriptorClassName() {
			return containerDescriptorClassName;
		}
		
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
