/**
 * 
 */
package org.eclipse.papyrus.resource.sasheditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.resource.AbstractBaseModel;
import org.eclipse.papyrus.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.resource.IModel;


/**
 * @author cedric dumoulin
 *
 */
public class SashModel extends AbstractModelWithSharedResource<org.eclipse.papyrus.sashwindows.di.SashModel> implements IModel {

	/**
	 * File extension used for notation.
	 */
	public static final String MODEL_FILE_EXTENSION = "di"; //$NON-NLS-1$


	/**
	 *  Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.resource.sasheditor.SashModel"; //$NON-NLS-1$

	/**
	 * Get the file extension used for this model.
	 * @see org.eclipse.papyrus.resource.AbstractBaseModel#getModelFileExtension()
	 *
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		return MODEL_FILE_EXTENSION;
	}

	/**
	 * Get the identifier used to register this model.
	 * @see org.eclipse.papyrus.resource.AbstractBaseModel#getIdentifier()
	 *
	 * @return
	 */
	@Override
	public Object getIdentifier() {
		return MODEL_ID;
	}

	@Override
	protected boolean isModelRoot(EObject object) {
		return object instanceof org.eclipse.papyrus.sashwindows.di.SashModel;
	}

}
