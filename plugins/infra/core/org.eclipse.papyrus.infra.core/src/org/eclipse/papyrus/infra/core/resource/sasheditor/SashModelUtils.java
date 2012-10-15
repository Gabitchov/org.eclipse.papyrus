/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource.sasheditor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;

/**
 * Set of utility methods linked to Trace for ControlMode
 * 
 * @author cedric dumoulin
 * 
 */
public class SashModelUtils {

	/**
	 * Gets the SashModel for the currently selected editor. <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not
	 * designed to be call from Editors. This method can return null if called
	 * during the MultiEditor initialization.
	 * 
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 * 
	 * @return The {@link SashModel} of the current editor, or null if not
	 *         found.
	 */
	public static SashModel getSashModel() {

		try {
			return (SashModel)ServiceUtilsForActionHandlers.getInstance().getModelSet().getModel(SashModel.MODEL_ID);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the SashModel for the currently selected editor. <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not
	 * designed to be call from Editors. This method can return null if called
	 * during the MultiEditor initialization.
	 * 
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 * 
	 * @return The {@link SashModel} of the current editor, or null if not
	 *         found.
	 * @throws ServiceException
	 *         If an error occurs while getting or starting the service.
	 */
	public static SashModel getSashModelChecked() throws ServiceException {

		return (SashModel)ServiceUtilsForActionHandlers.getInstance().getModelSet().getModel(SashModel.MODEL_ID);
	}

	/**
	 * Gets the SashModel from the {@link ModelSet}. <br>
	 * 
	 * @param modelsManager
	 *        The modelManager containing the requested model.
	 * 
	 * @return The {@link SashModel} registered in modelManager, or null if not
	 *         found.
	 */
	public static SashModel getSashModel(ModelSet modelsManager) {

		return (SashModel)modelsManager.getModel(SashModel.MODEL_ID);
	}

	/**
	 * Gets the SashModel from the {@link ModelSet}. <br>
	 * 
	 * @param ServicesRegistry
	 *        The servie registry under which the ModelSet is registered.
	 * 
	 * @return The {@link SashModel} registered in modelManager, or null if not
	 *         found.
	 */
	public static SashModel getSashModel(ServicesRegistry servicesRegistry) {

		try {
			return (SashModel)ModelUtils.getModelSetChecked(servicesRegistry).getModel(SashModel.MODEL_ID);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the SashModel from the {@link ModelSet}. <br>
	 * 
	 * @param ServicesRegistry
	 *        The servie registry under which the ModelSet is registered.
	 * 
	 * @return The {@link SashModel} registered in modelManager, or null if not
	 *         found.
	 * @throws ServiceException
	 *         If the service can't be returned.
	 */
	public static SashModel getSashModelChecked(ServicesRegistry servicesRegistry) throws ServiceException {

		return (SashModel)ModelUtils.getModelSetChecked(servicesRegistry).getModel(SashModel.MODEL_ID);
	}

	/**
	 * Retrieve the uri of the initial di opened
	 * 
	 * @param modelSet
	 * @return
	 */
	public static URI getInitialURI(ModelSet modelSet) {
		return SashModelUtils.getSashModel(modelSet).getResourceURI();
	}

}
