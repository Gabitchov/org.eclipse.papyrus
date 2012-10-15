/**
 * 
 */
package org.eclipse.papyrus.uml.tools.model;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.uml.tools.Activator;

/**
 * Set of utility methods linked to Trace for ControlMode
 * 
 * @author cedric dumoulin
 * 
 */
public class UmlUtils {

	/**
	 * Gets the UmlModel for the currently selected editor. <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not
	 * designed to be call from Editors. This method can return null if called
	 * during the MultiEditor initialization.
	 * 
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 * 
	 * 
	 * @return The {@link UmlModel} of the current editor, or null if not found.
	 */
	public static UmlModel getUmlModel() {

		try {
			return (UmlModel)ServiceUtilsForActionHandlers.getInstance().getModelSet().getModel(UmlModel.MODEL_ID);
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the UmlModel for the currently selected editor. <br>
	 * Warning: this method can return null if called during the MultiEditor
	 * initialization.
	 * 
	 * 
	 * @return The {@link UmlModel} of the current editor, or null if not found.
	 * @throws ServiceException
	 *         If an error occurs while getting or starting the service.
	 */
	public static UmlModel getUmlModelChecked() throws ServiceException {

		return (UmlModel)ServiceUtilsForActionHandlers.getInstance().getModelSet().getModel(UmlModel.MODEL_ID);
	}

	/**
	 * Gets the UmlModel from the {@link ModelSet}. <br>
	 * 
	 * @param modelSet
	 *        The modelManager containing the requested model.
	 * 
	 * @return The {@link SashModel} registered in modelManager, or null if not
	 *         found.
	 */
	public static UmlModel getUmlModel(ModelSet modelSet) {

		return (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
	}

	/**
	 * Gets the UmlModel from the {@link ServiceRegistry}.
	 * 
	 * @return ServicesRegistry The service registry under which the ModelSet is
	 *         registered.
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
	 * @return ServicesRegistry The service registry under which the ModelSet is
	 *         registered.
	 * @throws ServiceException
	 *         If the service can't be returned.
	 */
	public static UmlModel getUmlModelChecked(ServicesRegistry servicesRegistry) throws ServiceException {
		return (UmlModel)ModelUtils.getModelSetChecked(servicesRegistry).getModel(UmlModel.MODEL_ID);
	}

	/**
	 * Return the UML Resource associated to the Services Registry. May be null.
	 * 
	 * @param modelSet
	 * @return
	 */
	public static Resource getUmlResource(ServicesRegistry registry) {
		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(registry);
			return getUmlResource(modelSet);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}

	/**
	 * Return the UML Resource associated to the ModelSet. May be null.
	 * 
	 * @param modelSet
	 * @return
	 */
	public static Resource getUmlResource(ModelSet modelSet) {
		UmlModel umlModel = getUmlModel(modelSet);
		if(umlModel != null) {
			return umlModel.getResource();
		}
		return null;
	}

}
