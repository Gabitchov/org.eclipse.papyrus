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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public abstract class AbstractServiceDescriptorsWithIdProviderTest {

	static final String PLUGIN_XML = "resources/plugin.xml";
	
	/**
	 * Load a RegistryDesc from the specified declaration file.
	 * @param extensionFileName The name of the resource containing declarations
	 * @param registryName The name of the registry to load.
	 * @return The descriptor for the registry.
	 * 
	 * @throws IOException
	 * @throws ServiceException
	 * @throws DeclarationException
	 */
	abstract public RegistryIdDesc getRegistryDesc(String extensionFileName, String registryName ) throws IOException, ServiceException, DeclarationException;
	
	/**
	 * Load a ServiceSetDesc from the specified declaration file.
	 * 
	 * @param extensionFileName  The name of the resource containing declarations
	 * @param serviceSetName The name of the serviceSet to load.
	 * @return The descriptor for the ServiceSet
	 * @throws IOException
	 * @throws ServiceException
	 * @throws DeclarationException
	 */
	abstract public ServiceSetIdDesc getServiceSetDesc(String extensionFileName, String serviceSetName ) throws IOException, ServiceException, DeclarationException;
 
	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ExtensionServiceDescriptorsWithIdProvider#getRegistryDescriptor(java.lang.String)}.
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testGetRegistryDescriptor() throws IOException, ServiceException, DeclarationException {
		
		String readFromFile = "resources/plugin.xml";
		RegistryIdDesc registryIdDesc = getRegistryDesc(readFromFile, "registryA");
		assertNotNull("Get registered registry", registryIdDesc);
		
		assertTrue( "extends found", registryIdDesc.getExtends().size()>0);
		assertTrue( "extends found", registryIdDesc.getExtends().contains("registryB") );

		assertTrue( "extends found", registryIdDesc.getParents().size()>0);
		assertTrue( "extends found", registryIdDesc.getParents().contains("registryC") );

		assertTrue( "extends found", registryIdDesc.getSets().size()>0);
		assertTrue( "extends found", registryIdDesc.getSets().contains("servicesSetA") );

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ExtensionServiceDescriptorsWithIdProvider#getServiceSet(java.lang.String)}.
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testGetServiceSet() throws IOException, ServiceException, DeclarationException {
		// create provider, reading description from specified file.
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		
		ExtensionServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);

		// Tests
		assertNotNull("provider created", declarationsProvider);
		ServiceSetIdDesc serviceSet = declarationsProvider.getServiceSet("fragmentA");
		
		assertNotNull("Fragment exist", serviceSet);
		
		assertTrue("extends set", serviceSet.getExtends().size()>0);
		assertTrue("extends set", serviceSet.getExtends().contains("fragmentB" ) );
		
	}

	/**
	 * Test correctness of set parsing
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testSetParsing() throws IOException, ServiceException, DeclarationException {
		String serviceSetName = "extendingSet";
		ServiceSetIdDesc serviceSet = getServiceSetDesc(PLUGIN_XML, serviceSetName);
		
		// Tests
		assertNotNull("service found", serviceSet);
		
		assertTrue("extends set", serviceSet.getExtends().size()>0);
		assertTrue("extends set", serviceSet.getExtends().contains("setWithC" ) );
		
		String serviceAId = FakeServiceA.class.getName();
		String serviceBId = FakeServiceB.class.getName();
		assertTrue("service added", serviceSet.getServiceDescriptors().size()>0);
		assertNotNull("service added", serviceSet.getService(serviceAId) );
		assertNotNull("service added", serviceSet.getService(serviceBId) );
		
	}

	/**
	 * Test correctness of service parsing
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testServiceParsing() throws IOException, ServiceException, DeclarationException {
        // Indirectly read a specified service: first the set, second the service
		String serviceSetName = "dependantServices";
		String serviceAId = FakeServiceA.class.getName();
		String serviceBId = FakeServiceB.class.getName();
		String serviceCId = FakeServiceC.class.getName();
		
		ServiceSetIdDesc serviceSet = getServiceSetDesc(PLUGIN_XML, serviceSetName);
		
		AbstractServiceIdDesc serviceADesc = serviceSet.getService(serviceAId);
		AbstractServiceIdDesc serviceBDesc = serviceSet.getService(serviceBId);
		AbstractServiceIdDesc serviceCDesc = serviceSet.getService(serviceCId);
		
		// Tests
		assertNotNull("service found", serviceADesc);
		assertNotNull("service found", serviceBDesc);
		assertNotNull("service found", serviceCDesc);
		// Check dependsOn
		assertTrue( "dependsOn set", serviceADesc.getDependsOn().contains(serviceBId) );
		assertTrue( "dependsOn set", serviceBDesc.getDependsOn().contains(serviceCId) );
	}

	/**
	 * Check if a serviceSet declared in several fragments with the same name is correctly loaded.
	 * 
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 * @throws ServiceException 
	 */
	@Test
	public void testLoadAlias() throws IOException, DeclarationException, ServiceException {
		
		// Check if specified service are in the registry
		String serviceSetName = "setWithAlias";
		ServiceSetIdDesc serviceSet = getServiceSetDesc(PLUGIN_XML, serviceSetName);
		
		String serviceAId = FakeServiceA.class.getName();
		String aliasServiceId = "AnAlias";
		AbstractServiceIdDesc serviceADesc = serviceSet.getService(serviceAId);
		AbstractServiceIdDesc abstractAliasDesc = serviceSet.getService(aliasServiceId);

		assertNotNull( "service found", serviceADesc );
		assertNotNull( "service found", abstractAliasDesc );
		assertTrue("right type", abstractAliasDesc instanceof AliasIdDesc) ;
		
		AliasIdDesc aliasIdDesc = (AliasIdDesc)abstractAliasDesc;
		assertEquals("alias set", serviceAId, aliasIdDesc.getAliasedService() );
//		assertTrue("alaised service added in dependencies", aliasDesc.getDependsOn().contains(serviceAId));
	}


}
