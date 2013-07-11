package org.eclipse.papyrus.infra.core.serviceregistry;

import java.util.List;

/**
 * Service Descriptor used to create a named FakeService.
 */
public class FakeServiceDescriptor extends ServiceDescriptor {

	/**
	 * 
	 * Constructor.
	 * Create a descriptor for a FakeService with a specified name.
	 *
	 * @param key
	 * @param startKind
	 */
	public FakeServiceDescriptor( String key, ServiceStartKind startKind) {
		super(key, FakeService.class.getName(), startKind, 1 );
	}
	
	/**
	 * 
	 * Constructor.
	 * Create a descriptor for a FakeService with a specified name.
	 *
	 * @param key
	 * @param startKind
	 * @param requiredService
	 */
	public FakeServiceDescriptor( String key, ServiceStartKind startKind, List<String> requiredService) {
		super(key, FakeService.class.getName(), startKind, 1, requiredService );
	}
	
	/**
	 * Get the type of the created service.
	 * @return
	 */
	static public Class<?> getServiceType() {
		return FakeService.class;
	}
}

