/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource.sasheditor;

import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;

/**
 * @author dumoulin
 * 
 */
public class DiModel extends AbstractBaseModel implements IModel {

	/**
	 * File extension used for notation.
	 */
	public static final String MODEL_FILE_EXTENSION = "di"; //$NON-NLS-1$

	/**
	 * File extension used for notation.
	 */
	public static final String DI_FILE_EXTENSION = MODEL_FILE_EXTENSION;

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel"; //$NON-NLS-1$

	/**
	 * Get the file extension used for this model.
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getModelFileExtension()
	 * 
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		return MODEL_FILE_EXTENSION;
	}

	/**
	 * Get the identifier used to register this model.
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getIdentifier()
	 * 
	 * @return
	 */
	@Override
	public String getIdentifier() {
		return MODEL_FILE_EXTENSION;
	}

	@Override
	protected Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = super.getSaveOptions();

		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.FALSE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.FALSE);

		return saveOptions;
	}

}
