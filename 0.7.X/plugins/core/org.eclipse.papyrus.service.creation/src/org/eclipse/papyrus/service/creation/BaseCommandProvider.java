/**
 * 
 */
package org.eclipse.papyrus.service.creation;

import org.eclipse.papyrus.core.services.ComposedServicePart;


/**
 * Base class for CommandProviders.
 * CommandProviders can subclass this base class. This will register them automatically to the main 
 * service. 
 * CommandProviders should also register themselves to the ServiceRegistry.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public abstract class BaseCommandProvider extends ComposedServicePart<CommandProviderService> implements ICommandProvider {
	
	
	/**
	 * 
	 * Constructor.
	 *
	 */
	public BaseCommandProvider() {
		// create the parent by providing the key of the main service.
		super(CommandProviderService.class);
	}

}
