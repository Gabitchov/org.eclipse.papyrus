/**
 * 
 */
package org.eclipse.papyrus.resource;

import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;


/**
 * Set of utility methods to get the current {@link ModelSet}.
 * @author cedric dumoulin
 *
 */
public class ModelUtils {

	
	/**
	 * Gets the TraceModel for the currently selected editor.
	 * <br>
	 * Warning: this method can return null if called during the MultiEditor initialization.
	 *
	 * 
	 * @return The {@link TraceModel} of the current editor, or null if not found.
	 */
	public static ModelSet getModelSet() {

		try {
			return EditorUtils.getServiceRegistryChecked().getService(ModelSet.class);
		} catch (ServiceException e) {
			return null;
		}
	}
	
	/**
	 * Gets the TraceModel for the currently selected editor.
	 * <br>
	 * Warning: this method can return null if called during the MultiEditor initialization.
	 *
	 * 
	 * @return The {@link TraceModel} of the current editor.
	 * @throws ServiceException If an error occurs while getting or starting the service.
	 */
	public static ModelSet getModelSetChecked() throws ServiceException {

			return EditorUtils.getServiceRegistryChecked().getService(ModelSet.class);
	}
	

}
