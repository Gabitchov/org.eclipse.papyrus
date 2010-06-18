/**
 * 
 */
package org.eclipse.papyrus.resource.sasheditor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.ModelUtils;
import org.eclipse.papyrus.resource.uml.UmlUtils;


/**
 * Set of utility methods linked to Trace for ControlMode
 * 
 * @author cedric dumoulin
 * 
 */
public class SashModelUtils {


	/**
	 * Gets the SashModel for the currently selected editor. <br>
	 * Warning: this method can return null if called during the MultiEditor initialization.
	 * 
	 * 
	 * @return The {@link SashModel} of the current editor, or null if not found.
	 */
	public static SashModel getSashModel() {

		try {
			return (SashModel)ModelUtils.getModelSetChecked().getModel(SashModel.MODEL_ID);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the SashModel for the currently selected editor. <br>
	 * Warning: this method can return null if called during the MultiEditor initialization.
	 * 
	 * 
	 * @return The {@link SashModel} of the current editor, or null if not found.
	 * @throws ServiceException
	 *         If an error occurs while getting or starting the service.
	 */
	public static SashModel getSashModelChecked() throws ServiceException {

		return (SashModel)ModelUtils.getModelSetChecked().getModel(SashModel.MODEL_ID);
	}

	/**
	 * Gets the SashModel from the {@link ModelSet}. <br>
	 * 
	 * @param modelsManager
	 *        The modelManager containing the requested model.
	 * 
	 * @return The {@link SashModel} registered in modelManager, or null if not found.
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
	 * @return The {@link SashModel} registered in modelManager, or null if not found.
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
	 * @return The {@link SashModel} registered in modelManager, or null if not found.
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
	 *         FIXME improve how to get the initial model opened
	 */
	public static URI getInitialURI(ModelSet modelSet) {
		return UmlUtils.getUmlModel(modelSet).getResourceURI().trimFileExtension().appendFileExtension(SashModel.MODEL_FILE_EXTENSION);
	}

}
