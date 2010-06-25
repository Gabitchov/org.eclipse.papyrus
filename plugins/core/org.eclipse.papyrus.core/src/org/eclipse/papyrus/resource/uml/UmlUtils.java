/**
 * 
 */
package org.eclipse.papyrus.resource.uml;

import javax.imageio.spi.ServiceRegistry;

import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.resource.ModelUtils;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.sasheditor.SashModel;


/**
 * Set of utility methods linked to Trace for ControlMode
 * @author cedric dumoulin
 *
 */
public class UmlUtils {

	
	/**
	 * Gets the UmlModel for the currently selected editor.
	 * <br>
	 * Warning: this method can return null if called during the MultiEditor initialization.
	 *
	 * 
	 * @return The {@link UmlModel} of the current editor, or null if not found.
	 */
	public static UmlModel getUmlModel() {

		try {
			return (UmlModel)ModelUtils.getModelSetChecked().getModel(UmlModel.MODEL_ID);
		} catch (ServiceException e) {
			return null;
		}
	}
	
	/**
	 * Gets the UmlModel for the currently selected editor.
	 * <br>
	 * Warning: this method can return null if called during the MultiEditor initialization.
	 *
	 * 
	 * @return The {@link UmlModel} of the current editor, or null if not found.
	 * @throws ServiceException If an error occurs while getting or starting the service.
	 */
	public static UmlModel getUmlModelChecked() throws ServiceException {

		return (UmlModel)ModelUtils.getModelSetChecked().getModel(UmlModel.MODEL_ID);
	}
	
	/**
	 * Gets the UmlModel from the {@link ModelSet}. 
	 * <br>
	 * 
	 * @param modelSet The modelManager containing the requested model.
	 * 
	 * @return The {@link SashModel} registered in modelManager, or null if not found.
	 */
	public static UmlModel getUmlModel(ModelSet modelSet) {

		return (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
	}

	/**
	 * Gets the UmlModel from the {@link ServiceRegistry}.
	 * 
	 * @return ServicesRegistry The service registry under which the ModelSet is registered.
	 */
	public static UmlModel getUmlModel(ServicesRegistry servicesRegistry) {

		try {
			return getUmlModelChecked(servicesRegistry);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the UmlModel from the {@link ServiceRegistry}.
	 * 
	 * @return ServicesRegistry The service registry under which the ModelSet is registered.
	 * @throws ServiceException If the service can't be returned.
	 */
	public static UmlModel getUmlModelChecked(ServicesRegistry servicesRegistry) throws ServiceException {
			return (UmlModel)ModelUtils.getModelSetChecked(servicesRegistry).getModel(UmlModel.MODEL_ID);
	}


}
