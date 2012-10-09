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
import java.util.Map;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc;


/**
 * @author cedric dumoulin
 *
 */
public class ServiceRegistryFactory {

	/**
	 * Repository of single registries.
	 */
	protected Map<String, ServicesRegistry> singleRegistries;
	
	/**
	 * DescriptorProviders access point.
	 */
	protected DescriptorsCache descriptorProviders;
	
	/**
	 * Constructor.
	 *
	 */
	public ServiceRegistryFactory(DescriptorsCache descriptorProviders) {
		this.descriptorProviders = descriptorProviders;
	}

	/**
	 * Constructor.
	 *
	 * @param declaredDescriptorProviders Array of providers to be used by the {@link ServiceDescriptorsWithIdProviderCollection}.
	 */
	public ServiceRegistryFactory(IServiceDescriptorsWithIdProvider ... declaredDescriptorProviders ) {
		
		descriptorProviders = new DescriptorsCache();
		descriptorProviders.addAll(declaredDescriptorProviders);
	}

	/**
	 * Create a {@link ServicesRegistry} from the specified description.
	 * The description is searched in the associated {@link ServiceDescriptorsWithIdProviderCollection}.
	 * 
	 * @param registryName The name of the description used to initialized the ServicesRegistry.
	 * 
	 * @return The requested {@link ServicesRegistry}
	 * @throws DeclarationException
	 */
	public ServicesRegistry getServicesRegistry( String registryName ) throws DeclarationException {
		
		RegistryDesc registryIdDesc = descriptorProviders.getRegistryDesc( registryName);
		
		return getServicesRegistry(registryIdDesc);
	}
	
	/**
	 * Get a {@link ServicesRegistry} corresponding to the specified descriptor. Also create recursively referenced
	 * registries and services.
	 * 
	 * If the registry is "unique", lookup for an already existing instance, and return it if found.
	 * If the registry is not unique, create a new instance corresponding to the descriptor.
	 * Referenced  descriptions are searched in the associated ConfigurationProvider.
	 * 
	 * @param registryIdDesc The descriptor used to initialized the ServicesRegistry.
	 * 
	 * @return The requested {@link ServicesRegistry}
	 * @throws DeclarationException
	 */
	protected ServicesRegistry getServicesRegistry( RegistryDesc registryIdDesc ) throws DeclarationException {
		
		ServicesRegistry registry;
		
		if(registryIdDesc.isUnique() ) {
			// lookup for an instance
			registry = getSingleRegistry(registryIdDesc);
			if( registry != null )
				return registry;
			// Not found: create it
		}
		
		// create a new Registry
		List<DeclarationException> errors = new ArrayList<DeclarationException>();
		registry = new ServicesRegistry();
		// Initialize it
		// add parents
		for(RegistryDesc parentName:  registryIdDesc.getParents()) {
			try {
				ServicesRegistry parent = getServicesRegistry(parentName);
				registry.addParentRegistry(parent);
			} catch (DeclarationException e) {
				errors.add(e);
			}
		}
		
		// Add services
		for(AbstractServiceDesc serviceDesc:  registryIdDesc.getServices()) {
			
			registry.add(ServiceDescriptorUtils.toServiceDescriptor(serviceDesc) );
		}
				
		// Throw exceptions if pb encountered
		if(errors.size() >0) {
			if(errors.size() == 1) {
				throw errors.get(0);
			}
			else {
				// TODO: throw a multi exception
				throw new DeclarationException("Somme services are not started (first is shown)", errors.get(0));
			}
		}

		return registry;
	}

	/**
	 * Extends the specified registry with all services and parents declared in the specified descriptor.
	 * Only missing services and parents are added.
	 * <br>If both the original registry and the additional registry contain a service with the same name, 
	 * the service from the original registry is conserved.
	 *  
	 * @param registry The registry to extends.
	 * @param extendsWithRegistryName The name of the descriptor used to extends the registry.
	 * @return
	 * @throws DeclarationException
	 */
	public ServicesRegistry extendsServicesRegistry( ServicesRegistry registry, String extendsWithRegistryName ) throws DeclarationException {
		
		RegistryDesc registryDesc = descriptorProviders.getRegistryDesc( extendsWithRegistryName);
		
		return extendsServicesRegistry(registry, registryDesc);
	}
	
	/**
	 * Extends the specified registry with all services and parents declared in the specified descriptor.
	 * Only missing services and parents are added.
	 * <br>If both the original registry and the additional registry contain a service with the same name, 
	 * the service from the original registry is conserved.
	 * 
	 * @param extendRegistryDesc The descriptor used to initialized the ServicesRegistry.
	 * 
	 * @return The requested {@link ServicesRegistry}
	 * @throws DeclarationException
	 */
	protected ServicesRegistry extendsServicesRegistry( ServicesRegistry registry, RegistryDesc extendRegistryDesc ) throws DeclarationException {

		// create a new Registry
		List<Throwable> errors = new ArrayList<Throwable>();

		// add missing parents
		// 
		if( extendRegistryDesc.getParents().size()>0) {
			throw new UnsupportedOperationException("Registry extension with parents not yet implemented.");
		}
//		for(RegistryDesc newExtend:  extendRegistryDesc.getParents()) {
//			try {
//				if( !registry.containsParent(newExtend.getName()) ) {
//					ServicesRegistry parent = getServicesRegistry(newExtend.getName());
//					registry.addParentRegistry(parent);
//				}
//				
//			} catch (DeclarationException e) {
//				errors.add(e);
//			}
//		}
		
		
		// Add missing services
		for( AbstractServiceDesc idDesc : extendRegistryDesc.getServices() ) {
			try {
				if( ! registry.isStarted(idDesc.getName(), false)) {
				  registry.add(ServiceDescriptorUtils.toServiceDescriptor(idDesc) );
				}
			} catch (ServiceNotFoundException e) {
				errors.add(e);
			}
		}
				
		// Throw exceptions if pb encountered
		if(errors.size() >0) {
			if(errors.size() == 1) {
				throw new DeclarationException(errors.get(0));
			}
			else {
				// TODO: throw a multi exception
				throw new DeclarationMultiException("Somme services are not started.", errors);
			}
		}

		return registry;
	}

	/**
	 * Get the specified single registry by its name.
	 * Return null if not found or if the repository do not exist.
	 * 
	 * @param registryIdDesc
	 * @return
	 */
	private ServicesRegistry getSingleRegistry(RegistryDesc registryIdDesc) {
		if( singleRegistries == null) 
			return null;
		return singleRegistries.get( registryIdDesc.getName() );
	}

	
}
