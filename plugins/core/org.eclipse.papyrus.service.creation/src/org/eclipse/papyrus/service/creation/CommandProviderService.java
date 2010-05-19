/**
 * 
 */
package org.eclipse.papyrus.service.creation;

import org.eclipse.papyrus.core.services.ComposedService;

/**
 * Main service providing Creation Commands.
 * This service delegate to sub-services.
 * Each sub-service register itself to this main service. 
 * This service is registered under its classname.
 * 
 * @author cedric dumoulin
 *
 */
public class CommandProviderService extends ComposedService<ICommandProvider>  {

	
	/**
	 * An example of method to get a command.
	 * TODO: provide real methods !
	 * @param param
	 * @return
	 */
	public Object getCommands(Object param) {
		
		// Walk each provider to find one providing the command.
		for( ICommandProvider provider : getRegisteredServices() )
		{
			Object res = provider.getCommands(param);
			if(res != null)
				return res;
			
		}
		
		return null;
	}

}
