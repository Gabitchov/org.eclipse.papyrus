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

import java.util.List;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.Descriptors;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.RegistryDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceFactoryDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsFactory;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.StartupKind;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceFactoryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;


/**
 * A cache used to query the {@link IServiceDescriptorsWithIdProvider}. The cache return resolved descriptors,
 * in the form of instance of the ServiceDescriptors model.
 * 
 * @author cedric dumoulin
 * 
 */
public class DescriptorsCache {

	/**
	 * The cache of descriptors.
	 */
	protected Descriptors descriptorsCache;

	/**
	 * The provider used to query declarations.
	 */
	protected ServiceDescriptorsWithIdProviderCollection declaredDescriptorProvider;



	/**
	 * 
	 * Constructor.
	 * 
	 */
	public DescriptorsCache() {
		declaredDescriptorProvider = new ServiceDescriptorsWithIdProviderCollection();
		descriptorsCache = ServicedescriptorsFactory.eINSTANCE.createDescriptors();
	}

	/**
	 * Add all the provided {@link IServiceDescriptorsWithIdProvider} to the list of providers to use.
	 * 
	 * @param declaredDescriptorProviders
	 */
	public void addAll(IServiceDescriptorsWithIdProvider... declaredDescriptorProviders) {

		declaredDescriptorProvider.addAll(declaredDescriptorProviders);
		descriptorsCache = ServicedescriptorsFactory.eINSTANCE.createDescriptors();

	}

	/**
	 * Get the descriptor for the specified registry.
	 * The descriptor is built from the declarations found in {@link #declaredDescriptorProvider}.
	 * The descriptor is cached. This mean that subsequent calls for the same name will return the same
	 * result. <br/>
	 * If the registry is not found, throws an exception.
	 * 
	 * @param registryName
	 *        The name of the registry for which the descriptor is required.
	 * 
	 * @return The registry descriptor
	 * @throws DeclarationException
	 *         If an error occur while reading declarations.
	 * 
	 */
	public RegistryDesc getRegistryDesc(String registryName) throws DeclarationException {

		// Try from cache
		RegistryDesc desc = descriptorsCache.getRegistryDesc(registryName);

		if(desc != null) {
			return desc;
		}

		// Load from providers
		// this can throw exception
		RegistryIdDesc idDesc = declaredDescriptorProvider.getRegistryIdDesc(registryName);

		// Create a RegistryDesc from a RegistryIdDesc, and set minimal data
		desc = ServicedescriptorsFactory.eINSTANCE.createRegistryDesc();
		desc.setName(idDesc.getName());
		desc.setIsUnique(idDesc.isUnique());
		desc.setDescription(idDesc.getDescription());

		// Add it to the cache, so it can be found by other requests
		descriptorsCache.getRegistries().add(desc);

		// Set the references
		// serviceSet
		for(String serviceSetId : idDesc.getSets()) {
			desc.getServiceSets().add(getServiceSetDesc(serviceSetId));
		}

		// extends
		for(String extendsId : idDesc.getExtends()) {
			desc.getExtends().add(getRegistryDesc(extendsId));
		}

		// parents
		for(String extendsId : idDesc.getParents()) {
			desc.getParents().add(getRegistryDesc(extendsId));
		}


		// Resolve inheritances
		// need to compute services available for this registry
		// Available services are those from all sets, and from extends.
		computeRegistryServices(desc);


		return desc;
	}

	/**
	 * Get the {@link ServiceSetDesc} for the specified name.
	 * The descriptor is built from the declarations found in {@link #declaredDescriptorProvider}.
	 * The descriptor is cached. This mean that subsequent calls for the same name will return the same
	 * result. <br/>
	 * If the descriptor is not found, throws an exception.
	 * 
	 * @param serviceSetId
	 * @return
	 * @throws DeclarationException
	 */
	public ServiceSetDesc getServiceSetDesc(String serviceSetId) throws DeclarationException {
		// Try from cache
		ServiceSetDesc desc = descriptorsCache.getServiceSetDesc(serviceSetId);

		if(desc != null) {
			return desc;
		}

		// Load from providers
		// this can throw exception
		ServiceSetIdDesc idDesc = declaredDescriptorProvider.getServiceSet(serviceSetId);

		// Create a RegistryDesc from a RegistryIdDesc, and set minimal data
		desc = ServicedescriptorsFactory.eINSTANCE.createServiceSetDesc();
		desc.setName(idDesc.getName());
		desc.setDescription(idDesc.getDescription());

		// Add it to the cache, so it can be found by other requests
		descriptorsCache.getServiceSets().add(desc);

		// Set the references
		// serviceSet
		for(AbstractServiceIdDesc serviceIdDesc : idDesc.getServiceDescriptors()) {
			desc.getOwnedServices().add(transformAbstractServiceIdDescToRef(serviceIdDesc));
		}

		// extends
		for(String extendsId : idDesc.getExtends()) {
			desc.getExtends().add(getServiceSetDesc(extendsId));
		}

		// Resolve inheritances
		// need to compute services available for this set
		// Available services are those from all extends.
		computeServiceSetServices(desc);

		return desc;
	}

	/**
	 * Transform {@link AncestorEvent} {@link AbstractServiceIdDesc} to an {@link AbstractServiceDesc}.
	 * 
	 * @param serviceIdDesc
	 * @return
	 */
	private AbstractServiceDesc transformAbstractServiceIdDescToRef(AbstractServiceIdDesc serviceIdDesc) {
		if(serviceIdDesc instanceof ServiceFactoryIdDesc) {
			return transformServiceFactoryIdDescToRef((ServiceFactoryIdDesc)serviceIdDesc);
		} else if(serviceIdDesc instanceof ServiceIdDesc) {
			return transformServiceIdDescToRef((ServiceIdDesc)serviceIdDesc);
		} else if(serviceIdDesc instanceof AliasIdDesc) {
			return transformAliasIdDescToRef((AliasIdDesc)serviceIdDesc);
		} else {
			// Should never happen
			throw new UnsupportedOperationException("Don't no how to transform '" + serviceIdDesc + "' to AbstractServiceDesc.");
		}
	}

	/**
	 * 
	 * @param serviceIdDesc
	 * @return
	 */
	private AbstractServiceDesc transformServiceIdDescToRef(ServiceIdDesc serviceIdDesc) {

		ServiceDesc desc = ServicedescriptorsFactory.eINSTANCE.createServiceDesc();
		desc.setBundleID(serviceIdDesc.getBundleID());
		desc.setClassname(serviceIdDesc.getClassname());
		desc.setDescription(serviceIdDesc.getDescription());
		desc.setName(serviceIdDesc.getName());
		desc.setPriority(serviceIdDesc.getPriority());
		desc.setStartKind(transformStartKind(serviceIdDesc.getStartKind()));
		// dependsOn
		desc.getDependsOnIds().addAll(serviceIdDesc.getDependsOn());

		return desc;
	}

	/**
	 * 
	 * @param startKind
	 * @return
	 */
	private StartupKind transformStartKind(org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind startKind) {

		switch(startKind) {
		case STARTUP:
			return StartupKind.STARTUP;
		case LAZY:
			return StartupKind.LAZY;
		default:
			return StartupKind.STARTUP;
		}
	}

	/**
	 * 
	 * @param serviceIdDesc
	 * @return
	 */
	private AbstractServiceDesc transformAliasIdDescToRef(AliasIdDesc serviceIdDesc) {
		AliasDesc desc = ServicedescriptorsFactory.eINSTANCE.createAliasDesc();
		desc.setBundleID(serviceIdDesc.getBundleID());
		desc.setDescription(serviceIdDesc.getDescription());
		desc.setName(serviceIdDesc.getName());
		desc.setPriority(serviceIdDesc.getPriority());
		// dependsOn
		desc.getDependsOnIds().addAll(serviceIdDesc.getDependsOn());

		return desc;

	}

	/**
	 * 
	 * @param serviceIdDesc
	 * @return
	 */
	private AbstractServiceDesc transformServiceFactoryIdDescToRef(ServiceFactoryIdDesc serviceIdDesc) {
		ServiceFactoryDesc desc = ServicedescriptorsFactory.eINSTANCE.createServiceFactoryDesc();
		desc.setBundleID(serviceIdDesc.getBundleID());
		desc.setClassname(serviceIdDesc.getClassname());
		desc.setDescription(serviceIdDesc.getDescription());
		desc.setName(serviceIdDesc.getName());
		desc.setPriority(serviceIdDesc.getPriority());
		desc.setStartKind(transformStartKind(serviceIdDesc.getStartKind()));
		// dependsOn
		desc.getDependsOnIds().addAll(serviceIdDesc.getDependsOn());

		return desc;
	}

	/**
	 * Compute the services available from this registry. This implies
	 * resolving inheritances from extends.
	 * 
	 * @param registryDesc
	 *        The descriptor for which services should be computed.
	 * 
	 * 
	 */
	private void computeRegistryServices(RegistryDesc registryDesc) {

		// Reset the services
		List<AbstractServiceDesc> services = registryDesc.getServices();
		services.clear();

		// do the union of all services from sets
		// Do not check for double names (this is done in the Registry).
		for(ServiceSetDesc setDesc : registryDesc.getServiceSets()) {

			services.addAll(setDesc.getServices());
		}

		// Add services from extends
		// Add a services from a parent only if there is not a service with the same name
		// in the child
		for(RegistryDesc extendsDesc : registryDesc.getExtends()) {

			// Walk each service of the parent
			for(AbstractServiceDesc serviceDesc : extendsDesc.getServices()) {

				// Check if the service is already in the child
				if(!registryDesc.servicesContains(serviceDesc.getName())) {
					services.add(serviceDesc);
				}
			}
		}

	}

	/**
	 * Compute the services available from the specified {@link ServiceSetDesc}. This reset and compute
	 * the {@link ServiceSetDesc#getServices()} property.
	 * 
	 * @param serviceSetDesc
	 */
	private void computeServiceSetServices(ServiceSetDesc serviceSetDesc) {

		// Reset the services
		List<AbstractServiceDesc> services = serviceSetDesc.getServices();
		services.clear();

		// Add its own services
		services.addAll(serviceSetDesc.getOwnedServices());

		// Add services from extends
		// Add a services from an extends only if there is not a service with the same name
		// in the child
		for(ServiceSetDesc extendsDesc : serviceSetDesc.getExtends()) {

			// Walk each service of the parent
			for(AbstractServiceDesc serviceDesc : extendsDesc.getServices()) {

				// Check if the service is already in the child
				if(!serviceSetDesc.servicesContains(serviceDesc.getName())) {
					services.add(serviceDesc);
				}
			}
		}

	}



}
