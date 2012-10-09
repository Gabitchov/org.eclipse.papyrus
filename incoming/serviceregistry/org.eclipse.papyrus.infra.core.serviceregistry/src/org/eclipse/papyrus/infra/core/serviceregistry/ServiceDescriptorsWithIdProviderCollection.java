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

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidFactory;


/**
 * A collection of DescriptorsProviders.
 * This provide nearly the same method as DescriptorsProviders, but the search is done over
 * a collection of DescriptorsProviders.
 * 
 * @author cedric dumoulin
 *
 *	 TODO : complete
 */
public class ServiceDescriptorsWithIdProviderCollection /*implements IServiceDescriptorsWithIdProvider*/ {

	protected List<IServiceDescriptorsWithIdProvider> descriptorsProviders;

	
	
	/**
	 * 
	 * Constructor.
	 *
	 */
	public ServiceDescriptorsWithIdProviderCollection() {
		descriptorsProviders = new ArrayList<IServiceDescriptorsWithIdProvider>();
	}
	
	/**
	 * Add all the provided {@link IServiceDescriptorsWithIdProvider} to the list of providers to use.
	 * @param declaredDescriptorProviders
	 */
	public void addAll(IServiceDescriptorsWithIdProvider ... declaredDescriptorProviders) {

		for( IServiceDescriptorsWithIdProvider provider : declaredDescriptorProviders) {
			descriptorsProviders.add(provider);
		}
		
	}

	/**
	 * Get the descriptor for the specified registry.
	 * If the registry is found more than one, throw an exception.
	 * If the registry is not found, throws an exception.
	 * 
	 * @param registryName The name of the registry for which the descriptor is required.
	 * 
	 * @return The registry descriptor
	 * @throws DeclarationException If an error occur while reading declarations.
	 * 
	 */
	public RegistryIdDesc getRegistryIdDesc(String registryName) throws DeclarationException {
		
		RegistryIdDesc found = null;
		for( IServiceDescriptorsWithIdProvider provider : descriptorsProviders) {
			
			RegistryIdDesc res = provider.getRegistryDescriptor(registryName);
			if( found != null && res != null) {
				throw new DeclarationException("Registry '" +  registryName + "' is declared more than once in declarations.");
			}
			found = res;
		}
		
		if( found == null ) {
			throw new DeclarationNotFoundException("Can't find registry named '" +  registryName + "'.");
		}

		return found;
	}

	/**
	 * Get the descriptor for the specified registry, with all inheritance resolved. This mean that 
	 * the returned descriptor has no inheritance, but the found inheritance are added in the inner properties
	 * (sets, parents).
	 * 
	 * @param registryName
	 * @return
	 * @throws DeclarationException
	 */
	public RegistryIdDesc getResolvedRegistryIdDesc(String registryName) throws DeclarationException {
		
		// Get the original registry desc
		RegistryIdDesc registryIdDesc = getRegistryIdDesc(registryName);
		
		// Is there some inheritance ?
		if( registryIdDesc.getExtends().size() == 0) {
			// Remove doubles
			removeDoubleName( registryIdDesc.getParents() );
			removeDoubleName( registryIdDesc.getSets() );
			return registryIdDesc;
		}
		
		// There is some inheritance
		// Create a new desc, and set single values
		RegistryIdDesc resolvedDesc = ServicedescriptorswithidFactory.eINSTANCE.createRegistryIdDesc();
		resolvedDesc.setName(registryName);
		resolvedDesc.setDescription(registryIdDesc.getDescription());
		resolvedDesc.setIsUnique(registryIdDesc.isUnique());
		resolvedDesc.getSets().addAll( registryIdDesc.getSets());
		resolvedDesc.getParents().addAll( registryIdDesc.getParents());
		
		// Remove doubles from the list of directly inherited registry
		removeDoubleName( registryIdDesc.getExtends() );
		
		// Concat sets and parents from inherited descs
		for( String inheritedRegName : registryIdDesc.getExtends()) {
			// Get the inherited desc
			RegistryIdDesc inheritedReg = getResolvedRegistryIdDesc(inheritedRegName);
			// Concat sets and parents
			resolvedDesc.getSets().addAll( inheritedReg.getSets());
			resolvedDesc.getParents().addAll( inheritedReg.getParents());
			
		}
		
		// Remove doubles
		removeDoubleName( registryIdDesc.getParents() );
		removeDoubleName( registryIdDesc.getSets() );

		return resolvedDesc;
	}

	/**
	 * Get the descriptor for the specified ServiceSetIdDesc, with all inheritance resolved. This mean that 
	 * the returned {@link ServiceSetIdDesc} has no inheritance. All services found from inherited sets are added in the set, 
	 * according to the following rules:
	 * <ul>
	 * <li>Names found in children hides names in parent (overloading)</li>
	 * <li></li>
	 * <li></li>
	 * </ul>
	 * @param setName
	 * @return
	 * @throws DeclarationException 
	 * @throws DeclarationNotFoundException If the set is not found
	 */
	public ServiceSetIdDesc getResolvedServiceSetIdDesc(String setName) throws DeclarationException {
		
		
		ServiceSetIdDesc serviceSetIdDesc = getServiceSet(setName);
		// if no parent, return it directly
		if( serviceSetIdDesc.getExtends().size() == 0) {
			return serviceSetIdDesc;
		}
		
		// Create ServiceSetIdDesc
		ServiceSetIdDesc res = ServicedescriptorswithidFactory.eINSTANCE.createServiceSetIdDesc();
		
		res.setName(serviceSetIdDesc.getName());
		res.setDescription(serviceSetIdDesc.getDescription());
		res.getServiceDescriptors().addAll(serviceSetIdDesc.getServiceDescriptors());
		
		// Collect all parent's services
		for( String extendsName : serviceSetIdDesc.getExtends() ) {
			collectMissingServices( res, getResolvedServiceSetIdDesc(extendsName) );
		}
		
		return res;
	}

	/**
	 * Collect the services that are set in the parent, but not found in the collect.
	 * @param res
	 * @param resolvedServiceSet
	 */
	private void collectMissingServices(ServiceSetIdDesc collect, ServiceSetIdDesc parent) {
		
		for( AbstractServiceIdDesc desc : parent.getServiceDescriptors()) {
			if( ! collect.containsService(desc) ) {
				collect.getServiceDescriptors().add(desc);
			}
		}
		
	}

	/**
	 * Get the {@link ServiceSetIdDesc} concatenating all fragments declaring a part of the ServiceSetIdDesc.
	 * 
	 * 
	 * @param setName
	 * @return
	 * @throws DeclarationNotFoundException 
	 */
	public ServiceSetIdDesc getServiceSet(String serviceSetName) throws DeclarationException {
		ServiceSetIdDesc result = null;
		
		
		for( IServiceDescriptorsWithIdProvider provider : descriptorsProviders) {
			
			List<ServiceSetIdDesc> fragments = provider.getServiceSetFragments(serviceSetName);
			for( ServiceSetIdDesc fragment : fragments) {
				// Create the result ServiceSetIdDesc if needed
				if( result == null) {
					result = ServicedescriptorswithidFactory.eINSTANCE.createServiceSetIdDesc();
					result.setName(serviceSetName);
				}
				result.getExtends().addAll(fragment.getExtends());
				result.getServiceDescriptors().addAll(fragment.getServiceDescriptors());
				
			}
		}
		
		if( result == null ) {
			throw new DeclarationNotFoundException("Can't find ServiceSetIdDesc named '" +  serviceSetName + "'.");
		}
		// Remove doubles
		removeDoubleName(result.getExtends());
		
		return result;
	}

	/**
	 * Remove double names from the provided list.
	 * @param list
	 */
	private void removeDoubleName(List<String> list) {
		
		for( int i=0; i<list.size(); i++) {
			String ref = list.get(i);
			
			for( int j = i+1; j<list.size(); ) {
				// If we found the same name, remove the second one, and then check the same index
				// If the string are different, check the next index.
				if( ref.equals( list.get(j))) {
					// Remove it
					list.remove(j);
				}
				else {
					j++;
				}
			} // end j
		} // end i
		
	}


}
