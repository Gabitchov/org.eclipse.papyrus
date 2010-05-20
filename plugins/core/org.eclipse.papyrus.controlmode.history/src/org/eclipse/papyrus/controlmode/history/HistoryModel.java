/**
 * 
 */
package org.eclipse.papyrus.controlmode.history;

import org.eclipse.papyrus.resource.AbstractBaseModel;


/**
 * The trace model entry point that can be registered to 
 * Trace model is used for the ControlMode.
 * 
 * @author cedric dumoulin
 *
 */
public class HistoryModel extends AbstractBaseModel {

	/**
	 * File extension used for notation.
	 */
	public static final String MODEL_FILE_EXTENSION = "history"; //$NON-NLS-1$

	/**
	 *  Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.controlmode.history.HistoryModel"; //$NON-NLS-1$

	
	/**
	 * Identifier used to retrieve the model from the ModelManager
	 * @see org.eclipse.papyrus.resource.AbstractBaseModel#getIdentifier()
	 *
	 * @return
	 */
	@Override
	public Object getIdentifier() {
		return MODEL_ID;
	}

	/**
	 * Get the extension used for TraceModel resources
	 * @see org.eclipse.papyrus.resource.AbstractBaseModel#getModelFileExtension()
	 *
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		return MODEL_FILE_EXTENSION;
	}

}
