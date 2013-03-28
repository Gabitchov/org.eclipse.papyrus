/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.xmi.IllegalValueException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;

/**
 * Set of utility methods to get the current {@link ModelSet}.
 * 
 * @author cedric dumoulin
 * 
 */
public class ModelUtils {

	/**
	 * Gets the {@link ModelSet} for the currently selected editor. <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not
	 * designed to be call from Editors. This method can return null.
	 * 
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 * 
	 * 
	 * @return The {@link TraceModel} of the current editor, or null if not
	 *         found.
	 * @deprecated Use ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 */
	@Deprecated
	public static ModelSet getModelSet() {

		try {
			return ServiceUtilsForActionHandlers.getInstance().getModelSet();
		} catch (ServiceException e) {
			return null;
		}
	}

	/**
	 * Gets the {@link ModelSet} for the currently selected editor. <br>
	 * Warning: This method is designed to be call from ui.handlers. It is not
	 * designed to be call from Editors. This method can return null if called
	 * during the MultiEditor initialization.
	 * 
	 * @see ServiceUtilsForActionHandlers.getInstance().getModelSet() Warning:
	 * 
	 * 
	 * @return The {@link TraceModel} of the current editor.
	 * @throws ServiceException
	 *         If an error occurs while getting or starting the service.
	 * @deprecated Use ServiceUtilsForActionHandlers.getInstance().getModelSet()
	 */
	@Deprecated
	public static ModelSet getModelSetChecked() throws ServiceException {

		return ServiceUtilsForActionHandlers.getInstance().getModelSet();
	}

	/**
	 * Gets the ModelSet from the {@link ServicesRegistry}.
	 * 
	 * @return ServicesRegistry The service registry under which the ModelSet is
	 *         registered.
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
	 * @return ServicesRegistry The service registry under which the ModelSet is
	 *         registered.
	 * @throws ServiceException
	 *         If the service can't be returned.
	 */
	public static ModelSet getModelSetChecked(ServicesRegistry servicesRegistry) throws ServiceException {
		return servicesRegistry.getService(ModelSet.class);
	}

	/**
	 * Determine if a throwable can be managed in degraded mode
	 * 
	 * @param t
	 */
	public static boolean isDegradedModeAllowed(Throwable t) {
		return t instanceof org.eclipse.emf.ecore.xmi.ClassNotFoundException || t instanceof IllegalValueException;
	}

	public static boolean resourceFailedOnLoad(Resource r) {
		if(r.getErrors() != null) {
			for(Diagnostic d : r.getErrors()) {
				if(d instanceof WrappedException) {
					WrappedException wrapped = (WrappedException)d;
					if(wrapped.getCause() instanceof ResourceException && r.getContents().isEmpty()) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
