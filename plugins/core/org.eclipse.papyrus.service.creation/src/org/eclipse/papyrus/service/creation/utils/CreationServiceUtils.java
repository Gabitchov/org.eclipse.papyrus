package org.eclipse.papyrus.service.creation.utils;


import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.service.creation.CommandProviderService;

/**
 * Utility class to find the CreationService
 * @author cedric dumoulin
 *
 */
public class CreationServiceUtils {

	
	/**
	 * Get the CommandProviderService associated to the current active editor.
	 * 
	 * @return The CommandProviderService, or null if not found.
	 */
	public static CommandProviderService getCommandProvider() {
		
		ServicesRegistry serviceRegistry = EditorUtils.getServiceRegistry();
		try {
			return serviceRegistry == null ? null : serviceRegistry.getService(CommandProviderService.class);
		} catch (ServiceException e) {
			return null;
		}

	}
	
	/**
	 * Get the CommandProviderService associated to the current active editor.
	 * 
	 * @return The CommandProviderService
	 * @throws ServiceException If an error occurs.
	 */
	public static CommandProviderService getCommandProviderChecked() throws ServiceException {
		
		return  EditorUtils.getServiceRegistryChecked().getService(CommandProviderService.class);
	}
}
