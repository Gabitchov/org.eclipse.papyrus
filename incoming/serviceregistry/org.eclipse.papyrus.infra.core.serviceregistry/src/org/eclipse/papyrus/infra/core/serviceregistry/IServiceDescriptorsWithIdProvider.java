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

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;


/**
 * A declared descriptor provider is used to read declared descriptor.
 * Real implementation can read declared descriptor from various sources (Eclipse extension, model, ...).
 * 
 * @author cedric dumoulin
 *
 */
public interface IServiceDescriptorsWithIdProvider {

	/**
	 * Get the requested descriptor.
	 * If the registry is found more than one, throw an exception.
	 * If the registry is not found, return null.
	 * @param registryName
	 * @return The {@link RegistryIdDesc} or null if not found.
	 * 
	 */
	public RegistryIdDesc getRegistryDescriptor( String registryName ) throws DeclarationException;
	
	/**
	 * Get all the declared fragments for the specified serviceSet.
	 * 
	 * @param serviceSetName The name of the set for which fragments are required.
	 * 
	 * @return A list of fragment. The list can be empty if no fragment is found.
	 * @throws DeclarationException 
	 */
	public List<ServiceSetIdDesc> getServiceSetFragments(String serviceSetName ) throws DeclarationException;

	/**
	 * Get a complete ServiceSet from its name.
	 * @param serviceSetName
	 * @return
	 * @throws DeclarationException
	 */
	public ServiceSetIdDesc getServiceSet(String serviceSetName) throws DeclarationException;
}
