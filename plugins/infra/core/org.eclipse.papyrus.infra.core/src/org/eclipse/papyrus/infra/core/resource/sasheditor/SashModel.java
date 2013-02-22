/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource.sasheditor;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.core.resource.IModel;

/**
 * Model for the sash system. <br>
 * This model can share its resource with other model. This model is declared as {@link ModelKind#master}. Other model whishing to share the resource
 * should
 * subclass {@link AbstractModelWithSharedResource}, be declared as {@link ModelKind#slave} (which is the default.), and set
 * {@link #getModelFileExtension()} to return the same file extension as this
 * model ({@link #MODEL_FILE_EXTENSION}).
 * 
 * @author cedric dumoulin
 * 
 */
public class SashModel extends AbstractModelWithSharedResource<org.eclipse.papyrus.infra.core.sashwindows.di.SashModel> implements IModel {

	/**
	 * File extension used for notation.
	 */
	public static final String MODEL_FILE_EXTENSION = "di"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public SashModel() {
		super(ModelKind.master);
	}

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
		return MODEL_ID;
	}

	@Override
	protected boolean isModelRoot(EObject object) {
		return object instanceof org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
	}

	@Override
	protected Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = super.getSaveOptions();

		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.FALSE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.FALSE);

		return saveOptions;
	}

}
