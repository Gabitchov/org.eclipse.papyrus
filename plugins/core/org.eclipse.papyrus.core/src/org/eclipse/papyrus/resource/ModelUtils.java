/**
 * 
 */
package org.eclipse.papyrus.resource;


import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;


/**
 * Set of utility methods to get the current {@link ModelSet}.
 * @author cedric dumoulin
 *
 */
public class ModelUtils {

	
	/**
	 * Gets the {@link ModelSet} for the currently selected editor.
	 * <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not designed to 
	 * be call from Editors. This method can return null.
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 *
	 * 
	 * @return The {@link TraceModel} of the current editor, or null if not found.
	 * @deprecated Use ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 */
	public static ModelSet getModelSet() {

		try {
			return ServiceUtilsForActionHandlers.getInstance().getModelSet();
		} catch (ServiceException e) {
			return null;
		}
	}
	
	/**
	 * Gets the {@link ModelSet} for the currently selected editor.
	 * <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not designed to 
	 * be call from Editors. This method can return null if called during the MultiEditor initialization.
	 * 
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 * Warning: 
	 *
	 * 
	 * @return The {@link TraceModel} of the current editor.
	 * @throws ServiceException If an error occurs while getting or starting the service.
     * @deprecated Use ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 */
	public static ModelSet getModelSetChecked() throws ServiceException {

			return ServiceUtilsForActionHandlers.getInstance().getModelSet();
	}
	
	/**
	 * Gets the ModelSet from the {@link ServicesRegistry}.
	 * 
	 * @return ServicesRegistry The service registry under which the ModelSet is registered.
	 */
	public static ModelSet getModelSet(ServicesRegistry servicesRegistry) {

		try {
			return servicesRegistry.getService(ModelSet.class);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the ModelSet from the {@link ServicesRegistry}.
	 * 
	 * @return ServicesRegistry The service registry under which the ModelSet is registered.
	 * @throws ServiceException If the service can't be returned.
	 */
	public static ModelSet getModelSetChecked(ServicesRegistry servicesRegistry) throws ServiceException {
			return servicesRegistry.getService(ModelSet.class);
	}

	
}
