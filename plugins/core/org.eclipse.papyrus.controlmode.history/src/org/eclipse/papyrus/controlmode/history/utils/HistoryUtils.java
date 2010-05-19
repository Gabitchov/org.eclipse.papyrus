/**
 * 
 */
package org.eclipse.papyrus.controlmode.history.utils;

import org.eclipse.papyrus.controlmode.history.HistoryModel;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.resource.ModelUtils;


/**
 * Set of utility methods linked to Trace for ControlMode
 * @author cedric dumoulin
 *
 */
public class HistoryUtils {

	
	/**
	 * Gets the HistoryModel for the currently selected editor.
	 * <br>
	 * Warning: this method can return null if called during the MultiEditor initialization.
	 *
	 * 
	 * @return The {@link HistoryModel} of the current editor, or null if not found.
	 */
	public static HistoryModel getHistoryModel() {

		try {
			return (HistoryModel)ModelUtils.getModelsManagerChecked().getModel(HistoryModel.MODEL_ID);
		} catch (ServiceException e) {
			return null;
		}
	}
	
	/**
	 * Gets the HistoryModel for the currently selected editor.
	 * <br>
	 * Warning: this method can return null if called during the MultiEditor initialization.
	 *
	 * 
	 * @return The {@link HistoryModel} of the current editor, or null if not found.
	 * @throws ServiceException If an error occurs while getting or starting the service.
	 */
	public static HistoryModel getHistoryModelChecked() throws ServiceException {

		return (HistoryModel)ModelUtils.getModelsManagerChecked().getModel(HistoryModel.MODEL_ID);
	}
	
}
