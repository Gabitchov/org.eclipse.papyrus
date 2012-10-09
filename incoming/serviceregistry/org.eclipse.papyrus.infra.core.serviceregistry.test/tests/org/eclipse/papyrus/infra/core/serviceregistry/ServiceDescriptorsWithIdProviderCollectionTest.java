package org.eclipse.papyrus.infra.core.serviceregistry;

import static org.junit.Assert.*;

import java.io.IOException;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceSetIdDesc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ServiceDescriptorsWithIdProviderCollectionTest extends AbstractServiceDescriptorsWithIdProviderTest {

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
	@Override
	public RegistryIdDesc getRegistryDesc(String extensionFileName, String registryName) throws IOException, ServiceException, DeclarationException {
		// create provider, reading description from specified file.
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry(extensionFileName);
		
		ExtensionServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		assertNotNull("provider created", declarationsProvider);
		
		// Create the collection
		ServiceDescriptorsWithIdProviderCollection providerCollection = new ServiceDescriptorsWithIdProviderCollection();
		providerCollection.addAll(declarationsProvider);
		
		// Get the registry thru the collection
		RegistryIdDesc registryIdDesc = providerCollection.getRegistryIdDesc(registryName);
		
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
	@Override
	public ServiceSetIdDesc getServiceSetDesc(String extensionFileName, String serviceSetName) throws IOException, ServiceException, DeclarationException {
		// create provider, reading description from specified file.
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry(extensionFileName);
		
		ExtensionServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		assertNotNull("provider created", declarationsProvider);
		
		// Create the collection
		ServiceDescriptorsWithIdProviderCollection providerCollection = new ServiceDescriptorsWithIdProviderCollection();
		providerCollection.addAll(declarationsProvider);
		
		// Get the set thru the collection
		ServiceSetIdDesc serviceSetIdDesc = providerCollection.getServiceSet(serviceSetName);
		return serviceSetIdDesc;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 
	 */
	@Test
	public void testServiceDescriptorsWithIdProviderCollection() {
		ServiceDescriptorsWithIdProviderCollection providerCollection = new ServiceDescriptorsWithIdProviderCollection();
		assertNotNull("collection created", providerCollection);
	}

	/**
	 * @throws IOException 
	 * @throws ServiceException 
	 * 
	 */
	@Test
	public void testAddAll() throws IOException, ServiceException {
		// create provider, reading description from specified file.
		IExtensionRegistry extensionRegistry = EclipseExtensionUtils.instance.createRegistry(PLUGIN_XML);
		
		ExtensionServiceDescriptorsWithIdProvider declarationsProvider = new ExtensionServiceDescriptorsWithIdProviderFromFile(extensionRegistry);
		assertNotNull("provider created", declarationsProvider);
		
		// Create the collection
		ServiceDescriptorsWithIdProviderCollection providerCollection = new ServiceDescriptorsWithIdProviderCollection();
		providerCollection.addAll(declarationsProvider);
		assertNotNull("collection created", providerCollection);
		
	}


}
