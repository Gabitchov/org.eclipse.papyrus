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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class ExtensionServiceDescriptorsWithIdProviderTest extends AbstractServiceDescriptorsWithIdProviderTest{

	static final String PLUGIN_XML = "resources/plugin.xml";
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

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
	public RegistryIdDesc getRegistryDesc(String extensionFileName, String registryName ) throws IOException, ServiceException, DeclarationException {
		// create provider, reading description from specified file.
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry(extensionFileName);
		
		ExtensionServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		assertNotNull("provider created", declarationsProvider);
		
		RegistryIdDesc registryIdDesc = declarationsProvider.getRegistryDescriptor(registryName);
		
		return registryIdDesc;
	}
	
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
	public ServiceSetIdDesc getServiceSetDesc(String extensionFileName, String serviceSetName ) throws IOException, ServiceException, DeclarationException {
		// create provider, reading description from specified file.
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry(extensionFileName);
		
		ExtensionServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		assertNotNull("provider created", declarationsProvider);
		
		ServiceSetIdDesc serviceSetIdDesc = declarationsProvider.getServiceSet(serviceSetName);
		
		return serviceSetIdDesc;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ExtensionServiceDescriptorsWithIdProvider#getServiceSetFragments(java.lang.String)}.
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testGetServiceSetFragments() throws IOException, ServiceException, DeclarationException {
		// create provider, reading description from specified file.
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		
		ExtensionServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);

		// Tests
		assertNotNull("provider created", declarationsProvider);
		List<ServiceSetIdDesc> fragments = declarationsProvider.getServiceSetFragments("fragmentA");
		assertNotNull("Get fragments", fragments);
		
		assertTrue( "fragments found", fragments.size()>0);
		// Get the first fragment and test it
		ServiceSetIdDesc serviceSet = fragments.get(0);
		assertNotNull("Fragment exist", serviceSet);
		
		assertTrue("extends set", serviceSet.getExtends().size()>0);
		assertTrue("extends set", serviceSet.getExtends().contains("fragmentB" ) );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ExtensionServiceDescriptorsWithIdProvider#getServiceSetFragments(java.lang.String)}.
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testGetServiceSetFragmentsWithMultiFragments() throws IOException, ServiceException, DeclarationException {
		// create provider, reading description from specified file.
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		
		ExtensionServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);

		// Tests
		assertNotNull("provider created", declarationsProvider);
		List<ServiceSetIdDesc> fragments = declarationsProvider.getServiceSetFragments("multiFragmentA");
		assertNotNull("Get fragments", fragments);
		
		assertTrue( "fragments found", fragments.size()>0);
		assertTrue( "fragments found", fragments.size()>1);
	}


	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.serviceregistry.ExtensionServiceDescriptorsWithIdProvider#getServiceSet(java.lang.String)}.
	 * @throws IOException 
	 * @throws ServiceException 
	 * @throws DeclarationException 
	 */
	@Test
	public void testGetServiceSetFromMultiFragment() throws IOException, ServiceException, DeclarationException {
		// create provider, reading description from specified file.
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry("resources/plugin.xml");
		
		ExtensionServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);

		// Tests
		assertNotNull("provider created", declarationsProvider);
		ServiceSetIdDesc serviceSet = declarationsProvider.getServiceSet("multiFragmentA");
		
		assertNotNull("Fragment exist", serviceSet);
		
		assertTrue("extends set", serviceSet.getExtends().size()>0);
		assertTrue("extends set", serviceSet.getExtends().contains("fragmentB" ) );
		
	}




}
