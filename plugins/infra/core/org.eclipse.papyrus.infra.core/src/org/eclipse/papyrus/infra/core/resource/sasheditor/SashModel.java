/**
 *
 */
package org.eclipse.papyrus.infra.core.resource.sasheditor;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource.ModelKind;
import org.eclipse.papyrus.infra.core.resource.EMFLogicalModel;
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
public class SashModel extends EMFLogicalModel implements IModel {

	/**
	 * File extension.
	 *
	 * @deprecated Use {@link DiModel#MODEL_FILE_EXTENSION} instead. The SashModel has been moved to a separate file
	 */
	@Deprecated
	public static final String MODEL_FILE_EXTENSION = "di"; //$NON-NLS-1$

	/**
	 * File extension for the Sash model
	 */
	public static final String SASH_MODEL_FILE_EXTENSION = "sash"; //$NON-NLS-1$

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
		return SASH_MODEL_FILE_EXTENSION;
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
	public void loadModel(URI uriWithoutExtension) {

		URI sashModelURI = getSashModelURI(uriWithoutExtension);

		try {
			super.loadModel(sashModelURI);
		} catch (Exception ex) {
			createModel(sashModelURI);
		}
		if(resource == null) {
			createModel(sashModelURI);
		}
	}

	@Override
	public void setModelURI(URI uriWithoutExtension) {
		URI newURIWithoutExtension;
		if(resourceURI != null && isLegacy(resourceURI)) {
			newURIWithoutExtension = getLegacyURI(uriWithoutExtension);
		} else {
			newURIWithoutExtension = getPreferenceStoreURI(uriWithoutExtension);
		}

		super.setModelURI(newURIWithoutExtension);
	}

	protected boolean isLegacy(URI uri) {
		return Objects.equals(uri.trimFileExtension(), getModelManager().getURIWithoutExtension());
	}

	protected URI getSashModelURI(URI uriWithoutExtension) {
		URIConverter converter = getModelManager().getURIConverter();
		URI legacyURI = getLegacyURI(uriWithoutExtension);

		if(converter.exists(legacyURI, Collections.emptyMap())) {
			return legacyURI;
		}

		URI preferenceStoreURI = getPreferenceStoreURI(uriWithoutExtension);

		return preferenceStoreURI;
	}

	protected URI getLegacyURI(URI uriWithoutExtension) {
		URI legacyURI = uriWithoutExtension.appendFileExtension(MODEL_FILE_EXTENSION);
		return legacyURI;
	}

	protected URI getPreferenceStoreURI(URI uriWithoutExtension) {
		IPath stateLocation = Activator.getDefault().getStateLocation();

		if(uriWithoutExtension.isPlatform()) {
			stateLocation = stateLocation.append(uriWithoutExtension.toPlatformString(true));
		} else {
			stateLocation = stateLocation.append(URI.decode(uriWithoutExtension.toString())); //TODO properly support and test non-platform URIs
		}

		URI workspaceFileURI = URI.createFileURI(stateLocation.toString());

		return workspaceFileURI;
	}

	@Override
	protected Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = super.getSaveOptions();

		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.FALSE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.FALSE);

		return saveOptions;
	}

}
