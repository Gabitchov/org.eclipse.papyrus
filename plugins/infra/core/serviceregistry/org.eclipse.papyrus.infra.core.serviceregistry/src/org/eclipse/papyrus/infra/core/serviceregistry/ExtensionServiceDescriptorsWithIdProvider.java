/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.serviceregistry;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.core.serviceregistry.internal.BadDeclarationException;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidFactory;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind;


/**
 * A declared service provider reading declaration from eclipse extensions (plugin.xml).
 * 
 * @author cedric dumoulin
 *
 */
public class ExtensionServiceDescriptorsWithIdProvider implements IServiceDescriptorsWithIdProvider {

	/** Namespace where to look for the extension points. */
	public static String extensionPointNamespace = "org.eclipse.papyrus.infra.core.serviceregistry";

	/** ID of the extension (schema filename) */
	public static final String SERVICE_EXTENSION_ID = "service";

	/** Extension point name inside the extension description **/
	public final static String REGISTRY_ELEMENT_NAME = "registry";
	
	/** Extension point name inside the extension description **/
	public final static String REGISTRY_EXTENDS_ELEMENT = "extendedRegistry";

	/** Extension point name inside the extension description **/
	public final static String REGISTRY_PARENT_ELEMENT = "parentRegistry";

	/** Extension point name inside the extension description **/
	public final static String REGISTRY_SERVICE_SETS_ELEMENT = "serviceSets";

	/** Extension point name inside the extension description **/
	public final static String SERVICE_ELEMENT_NAME = "service";

	/** servicesSet name **/
	public final static String SERVICE_SET_ELEMENT_NAME = "servicesSet";

	/** ServiceFactory Extension point **/
	public final static String SERVICE_FACTORY_ELEMENT_NAME = "serviceFactory";

	/** ServiceFactory Extension point **/
	public final static String ALIAS_ELEMENT_NAME = "alias";

	/** ServiceFactory Extension point **/
	public final static String ALIASED_SERVICE_ID_ATTRIBUTE = "aliasedServiceId";

	/** id attribute	 */
	private static final String ID_ATTRIBUTE = "id";

	/** constant for the attribute factoryClass **/
	public final static String CONTEXTCLASS_ATTRIBUTE = "contextClass";

	/** extension point propertyname */
	private final static String STARTKIND_PROPERTY = "startKind";

	/** name of the dependsOn element */
	private static final String DEPENDSON_ELEMENT_NAME = "dependsOn";

	/** */
	private static final String SERVICE_ID_ATTRIBUTE_NAME = "serviceId";

	/** */
	private static final String SERVICE_SET_EXTENDS_ELEMENT = "extendedServiceSet";

	/**	 */
	private static final String DESCRIPTION_ATTRIBUTE = "description";

	/**	 */
	private static final String IS_UNIQUE_ATTRIBUTE = "isUnique";
	
	/**	 */
	private static final String REGISTRY_ID_ATTRIBUTE = "registryId";

	/**	 */
	private static final String SERVICE_SET_ID_ATTRIBUTE = "serviceSetId";

	/**
	 * Get the descriptor for the specified registry.
	 * Return null if not found.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.IServiceDescriptorsWithIdProvider#getRegistryDescriptor(java.lang.String)
	 *
	 * @param registryName
	 * @return The specified descriptor, or null if not found
	 * @throws DeclarationException If there is more than one registry declared under the name.
	 * 
	 */
	public RegistryIdDesc getRegistryDescriptor(String registryName) throws DeclarationException {
		
		// Reading data from plugins
		IConfigurationElement[] configElements = getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, SERVICE_EXTENSION_ID);

		RegistryIdDesc registryIdDesc = null;
		boolean isRegistryFound = false;
		List<Throwable> warnings = new ArrayList<Throwable>();
		
		for( IConfigurationElement ele : configElements) {
			
			// SEarch for "registry"
			if(REGISTRY_ELEMENT_NAME.equals(ele.getName()) && registryName.equals(ele.getAttribute(ID_ATTRIBUTE))) {
				if(isRegistryFound) {
					// Already found: exception
					throw new DeclarationException("More than one registry declared under name '" + registryName + "'. "
							+ " Declaration from '" + ele.getContributor().getName() + "' is disguarded.");
				}
				isRegistryFound = true;
				// read the set
				registryIdDesc = parseRegistryDescriptor( ele, warnings);
			} 
			
		}
		
		if( warnings.size()>0) {
			throw new DeclarationMultiException("Problems encountered during extensions processing.", warnings);
		}
		return registryIdDesc;
	}
	
	/**
	 * Parse the RegistryDescriptor from the provided {@link IConfigurationElement}.
	 * 
	 * @param ele The {@link IConfigurationElement} representing a RegistryDescriptor.
	 * @param warnings A list used to record encountered warnings.
	 * @return A registry descriptor.
	 */
	private RegistryIdDesc parseRegistryDescriptor(IConfigurationElement ele, List<Throwable> warnings) {
		RegistryIdDesc registryIdDesc = ServicedescriptorswithidFactory.eINSTANCE.createRegistryIdDesc();
		
		registryIdDesc.setName(ele.getAttribute(ID_ATTRIBUTE));
		registryIdDesc.setDescription(ele.getAttribute(DESCRIPTION_ATTRIBUTE));
		registryIdDesc.setIsUnique(Boolean.parseBoolean(ele.getAttribute(IS_UNIQUE_ATTRIBUTE)));
		parseRegistryExtends(ele, registryIdDesc, warnings);
		parseRegistryParent(ele, registryIdDesc, warnings);
		parseRegistryServiceSetId(ele, registryIdDesc, warnings);
		
		return registryIdDesc;
	}
		
	/**
	 * Parse the declared sets of a Registry.
	 * 
	 * @param ele
	 * @param registryIdDesc
	 * @param warnings
	 */
	private void parseRegistryServiceSetId(IConfigurationElement parentElement, RegistryIdDesc registryIdDesc, List<Throwable> warnings) {
		// Get all extends declarations
		IConfigurationElement[] extendDeclarations = parentElement.getChildren(REGISTRY_SERVICE_SETS_ELEMENT);

		// Process extends
		for(IConfigurationElement ele : extendDeclarations) {
			
			String extendedRegistry = ele.getAttribute(SERVICE_SET_ID_ATTRIBUTE);
			if(extendedRegistry == null || extendedRegistry.length() == 0) { 
				warnings.add( new BadDeclarationException( ele.getName() + "/" + SERVICE_SET_ID_ATTRIBUTE + " should be set.") );
			}
			else {
			registryIdDesc.getSets().add(extendedRegistry);
			}
		}
	}

	/**
	 * Parse the parent declaration of a Registry.
	 * @param ele
	 * @param registryIdDesc
	 * @param warnings
	 */
	private void parseRegistryParent(IConfigurationElement parentElement, RegistryIdDesc registryIdDesc, List<Throwable> warnings) {
		// Get all extends declarations
		IConfigurationElement[] extendDeclarations = parentElement.getChildren(REGISTRY_PARENT_ELEMENT);

		// Process extends
		for(IConfigurationElement ele : extendDeclarations) {
			
			String extendedRegistry = ele.getAttribute(REGISTRY_ID_ATTRIBUTE);
			if(extendedRegistry == null || extendedRegistry.length() == 0) { 
				warnings.add( new BadDeclarationException( ele.getName() + "/" + REGISTRY_ID_ATTRIBUTE + " should be set.") );
			}
			else {
			registryIdDesc.getParents().add(extendedRegistry);
			}
		}
	}

	/**
	 * Parse the extends declaration of a Registry.
	 * @param parentElement The element to parse. This element must represent a Registry.
	 * @param registryIdDesc The registry into which the result is stored
	 * @param warnings A list used to record encountered warnings.
	 */
	private void parseRegistryExtends(IConfigurationElement parentElement, RegistryIdDesc registryIdDesc, List<Throwable> warnings) {
		// Get all extends declarations
		IConfigurationElement[] extendDeclarations = parentElement.getChildren(REGISTRY_EXTENDS_ELEMENT);

		// Process extends
		for(IConfigurationElement ele : extendDeclarations) {
			
			String extendedRegistry = ele.getAttribute(REGISTRY_ID_ATTRIBUTE);
			if(extendedRegistry == null || extendedRegistry.length() == 0) { 
				warnings.add( new BadDeclarationException( ele.getName() + "/" + REGISTRY_ID_ATTRIBUTE + " should be set.") );
			}
			else {
			registryIdDesc.getExtends().add(extendedRegistry);
			}
		}
	}

	/**
	 * Get all fragments contributing to the declaration of the specified ServiceSetIdDesc.
	 * 
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.IServiceDescriptorsWithIdProvider#getServiceSetFragments(java.lang.String)
	 *
	 * @param serviceSetName
	 * @return
	 * @throws DeclarationMultiException 
	 */
	public List<ServiceSetIdDesc> getServiceSetFragments(String serviceSetName) throws DeclarationException {
		// Reading data from plugins
		IConfigurationElement[] configElements = getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, SERVICE_EXTENSION_ID);

		List<ServiceSetIdDesc> fragments = new ArrayList<ServiceSetIdDesc>();
		List<Throwable> warnings = new ArrayList<Throwable>();
		
		for( IConfigurationElement ele : configElements) {
			
			// SEarch for "registry"
			if(SERVICE_SET_ELEMENT_NAME.equals(ele.getName()) && serviceSetName.equals(ele.getAttribute(ID_ATTRIBUTE))) {
				ServiceSetIdDesc serviceSet = parseServiceSetDescriptor( ele, warnings);
				fragments.add(serviceSet);
			} 
			
		}
		
		if( warnings.size()>0) {
			throw new DeclarationMultiException("Problems encountered during extensions processing.", warnings);
		}
		return fragments;
	}

	/**
	 * Get the requested ServiceSetIdDesc. If several fragmants are used to declare the ServiceSetIdDesc, 
	 * this fragments are concatenated in one ServiceSetIdDesc.
	 * 
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.IServiceDescriptorsWithIdProvider#getServiceSetFragments(java.lang.String)
	 *
	 * @param serviceSetName
	 * @return 
	 * @throws DeclarationMultiException 
	 */
	public ServiceSetIdDesc getServiceSet(String serviceSetName) throws DeclarationException {
		// Reading data from plugins
		IConfigurationElement[] configElements = getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, SERVICE_EXTENSION_ID);

		ServiceSetIdDesc serviceSet = ServicedescriptorswithidFactory.eINSTANCE.createServiceSetIdDesc();
		List<Throwable> warnings = new ArrayList<Throwable>();
		
		for( IConfigurationElement ele : configElements) {
			
			// SEarch for "registry"
			if(SERVICE_SET_ELEMENT_NAME.equals(ele.getName()) && serviceSetName.equals(ele.getAttribute(ID_ATTRIBUTE))) {
				parseServiceSetDescriptor( ele, serviceSet, warnings);
			} 
			
		}
		
		if( warnings.size()>0) {
			throw new DeclarationMultiException("Problems encountered during extensions processing.", warnings);
		}
		return serviceSet;
	}


	/**
	 * Add the ServiceSetIdDesc declarations found in the provided {@link IConfigurationElement}, and add
	 * it to the provided {@link ServiceSetIdDesc}.
	 * @param ele
	 * @param warnings
	 */
	private void parseServiceSetDescriptor(IConfigurationElement ele, ServiceSetIdDesc serviceSet, List<Throwable> warnings) {

		serviceSet.setName(ele.getAttribute(ID_ATTRIBUTE));
//		serviceSet.setDescription(ele.getAttribute(DESCRIPTION_ATTRIBUTE));
		parseServiceSetExtends(ele, serviceSet, warnings);
		parseServiceSetServices(ele, serviceSet.getServiceDescriptors(), warnings);
	}

	/**
	 * Parse a {@link ServiceSetIdDesc}
	 * @param ele
	 * @param warnings
	 * @return A newly created ServiceSetIdDesc initialized with the declaration found in ele.
	 */
	private ServiceSetIdDesc parseServiceSetDescriptor(IConfigurationElement ele, List<Throwable> warnings) {

		ServiceSetIdDesc serviceSet = ServicedescriptorswithidFactory.eINSTANCE.createServiceSetIdDesc();

		parseServiceSetDescriptor(ele, serviceSet, warnings);		
		return serviceSet;
	}

	/**
	 * Parse the extended attribute of a ServiceSetIdDesc declaration.
	 * @param parentElement
	 * @param serviceSet
	 * @param warnings
	 */
	private void parseServiceSetExtends(IConfigurationElement parentElement, ServiceSetIdDesc serviceSet, List<Throwable> warnings) {
		// Get all extends declarations
		IConfigurationElement[] extendDeclarations = parentElement.getChildren(SERVICE_SET_EXTENDS_ELEMENT);

		// Process extends
		for(IConfigurationElement ele : extendDeclarations) {
			
			String extendedServiceSet = ele.getAttribute(SERVICE_SET_ID_ATTRIBUTE);
			if(extendedServiceSet == null || extendedServiceSet.length() == 0) { 
				warnings.add( new BadDeclarationException( ele.getName() + "/" + SERVICE_SET_ID_ATTRIBUTE + " should be set.") );
			}
			else {
				serviceSet.getExtends().add(extendedServiceSet);
			}
		}
	}

	/**
	 * Read services descriptors from the specified element configuration.
	 * The element configuration should contains service elements declarations.
	 * IdDescriptors are added to the specified list
	 * 
	 * @param descriptors The list into which descriptors are added
	 * @param parentElement The configuration element containing some service declarations.
	 * @param serviceSet 
	 * @param exceptions List used to add encountered exceptions.
	 */
	private void parseServiceSetServices( IConfigurationElement parentElement, List<AbstractServiceIdDesc> descriptors, List<Throwable> exceptions)  {
	
		// Get all children
		IConfigurationElement[] configElements = parentElement.getChildren();
	
		// Process services
		for(IConfigurationElement ele : configElements) {
			AbstractServiceIdDesc desc;
			if(SERVICE_ELEMENT_NAME.equals(ele.getName())) {
				// Read a Service
				try {
					desc = parseServiceDescriptor(ele);
					// Add created desc
					descriptors.add(desc);
				} catch (DeclarationException e) {
					// record exceptions
					exceptions.add(e);
				}
			} else if(SERVICE_FACTORY_ELEMENT_NAME.equals(ele.getName())) {
				// Read a Service Factory
				try {
					desc = parseServiceDescriptor(ele);
					// Add created desc
					descriptors.add(desc);
				} catch (DeclarationException e) {
					// record exceptions
					exceptions.add(e);
				}
			} else if(ALIAS_ELEMENT_NAME.equals(ele.getName())) {
				try {
					desc = parseAliasDescriptor(ele);
					// Add created desc
					descriptors.add(desc);
				} catch (DeclarationException e) {
					// record exceptions
					exceptions.add(e);
				}
	
			}
			
		}
		
	}

	/**
	 * Read an alias descriptor.
	 * @param ele
	 * @return
	 */
	private AliasIdDesc parseAliasDescriptor(IConfigurationElement ele) throws DeclarationException {
	
		AliasIdDesc aliasIdDesc = ServicedescriptorswithidFactory.eINSTANCE.createAliasIdDesc();
		
		// key
		String key = ele.getAttribute(ID_ATTRIBUTE);
		if(key == null || key.length() == 0) {
			throw new BadDeclarationException( ele.getName() + "/" + ID_ATTRIBUTE + " should be set for an alias.");
		}
		aliasIdDesc.setName(key);
		
		// key
		String aliasedService = ele.getAttribute(ALIASED_SERVICE_ID_ATTRIBUTE);
		if(key == null || key.length() == 0) {
			throw new BadDeclarationException( ele.getName() + "/" + ALIASED_SERVICE_ID_ATTRIBUTE + " should be set for an alias.");
		}
		aliasIdDesc.setAliasedService(aliasedService);
	
		aliasIdDesc.setPriority(parsePriorityAttribute(ele));
	
		aliasIdDesc.setBundleID(ele.getContributor().getName());
		aliasIdDesc.setDescription(ele.getAttribute(DESCRIPTION_ATTRIBUTE));
		parseServiceDependsOn( ele, aliasIdDesc.getDependsOn());
	
	
		return aliasIdDesc;
	}

	/**
	 * Read descriptor values from provided element.
	 * 
	 * @param ele
	 * @return
	 * @throws ServiceException
	 */
	private ServiceIdDesc parseServiceDescriptor(IConfigurationElement ele) throws DeclarationException {
	
		ServiceIdDesc serviceIdDesc = ServicedescriptorswithidFactory.eINSTANCE.createServiceIdDesc();
		
		// classname
		String serviceClassname = ele.getAttribute("classname");
		serviceIdDesc.setClassname(serviceClassname);
	
		// key
		String key = ele.getAttribute(ID_ATTRIBUTE);
		if(key == null || key.length() == 0) {
			key = serviceClassname;
		}
		serviceIdDesc.setName(key);
		
		serviceIdDesc.setStartKind(parseStartKindAttribute(ele));	
		serviceIdDesc.setPriority(parsePriorityAttribute(ele));
		serviceIdDesc.setBundleID(ele.getContributor().getName());
		parseServiceDependsOn( ele, serviceIdDesc.getDependsOn());
	
		return serviceIdDesc;
	}

	/**
	 * Parse the StartupKind attribute.
	 * @param ele
	 * @return
	 * @throws DeclarationException
	 */
	private StartupKind parseStartKindAttribute(IConfigurationElement ele) throws DeclarationException {
		// Service start kind
		StartupKind serviceStartKind = StartupKind.LAZY;
		String serviceStartKindStr = ele.getAttribute(STARTKIND_PROPERTY);
		if(serviceStartKindStr != null && serviceStartKindStr.length() > 0) {
			try {
				serviceStartKind = StartupKind.valueOf(serviceStartKindStr.toUpperCase());
			} catch (IllegalArgumentException e) {
				// Can't convert property
				throw new DeclarationException("Can't convert property " + STARTKIND_PROPERTY + "(plugin=" + ele.getContributor() + "declaringExtension=" + ele.getDeclaringExtension() + ")", e);
			}
		}
		return serviceStartKind;
	}

	/**
	 * @param ele
	 * @return
	 */
	private int parsePriorityAttribute(IConfigurationElement ele) {
		// priority
		int priority = 1;
		String priorityStr = ele.getAttribute("priority");
		if(priorityStr != null && priorityStr.length() > 0) {
			try {
				priority = Integer.parseInt(priorityStr);
			} catch (NumberFormatException e) {
			}
		}
		return priority;
	}

	/**
	 * Parse the dependsOn attribute of a service.
	 * @param parentElement The {@link IConfigurationElement} containing a dependsOn attribute.
	 * @param dependsOnServices Parsed value are added in this list.
	 */
	private void parseServiceDependsOn(IConfigurationElement parentElement, List<String> dependsOnServices) {
		// Get children
		IConfigurationElement[] configElements = parentElement.getChildren(DEPENDSON_ELEMENT_NAME);

		for(IConfigurationElement ele : configElements) {
			String key = ele.getAttribute(SERVICE_ID_ATTRIBUTE_NAME);
			if(key != null && key.length() > 0) {
				dependsOnServices.add(key.trim());
			}
		}
	}

	/**
	 * Get the Eclipse extensionRegistry.
	 * This method can be overloaded by subclasses. This is useful for tests.
	 * 
	 * @return
	 */
	protected IExtensionRegistry getExtensionRegistry() {
		return Platform.getExtensionRegistry();
	}


}
