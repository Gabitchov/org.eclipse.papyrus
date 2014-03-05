/*****************************************************************************
 * Copyright (c) 2009-2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Rewrite the sash model - store in the plugin's PreferenceStore (Bug 429239)
 *  Christian W. Damus (CEA) - bug 429242
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource.sasheditor;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.EMFLogicalModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;

import com.google.common.base.Objects;

/**
 * Model for the sash system.
 *
 * It may be stored in the *.di file (Legacy mode) or in a *.sash file in the user
 * preference space (~workspace/.metadata/.plugins/org.eclipse.papyrus.infra.core/)
 * 
 * @author Cedric Dumoulin
 * @author Camille Letavernier
 * 
 */
public class SashModel extends EMFLogicalModel implements IModel {

	private SashModelProviderManager providerManager;

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
		if(isLegacy(resourceURI)) {
			return MODEL_FILE_EXTENSION;
		} else {
			return SASH_MODEL_FILE_EXTENSION;
		}
	}

	@Override
	public void init(ModelSet modelSet) {
		super.init(modelSet);

		this.providerManager = new SashModelProviderManager(modelSet);
	}

	@Override
	public void unload() {
		if(providerManager != null) {
			providerManager.dispose();
			providerManager = null;
		}

		super.unload();
	}

	@Override
	protected boolean isRelatedResource(Resource resource) {
		if(resource == null) {
			return false;
		}
		String fileExtension = resource.getURI().fileExtension();
		return MODEL_FILE_EXTENSION.equals(fileExtension) || SASH_MODEL_FILE_EXTENSION.equals(fileExtension);
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

		this.resourceURI = sashModelURI;

		try {
			super.loadModel(sashModelURI.trimFileExtension());
		} catch (Exception ex) {
			createModel(sashModelURI.trimFileExtension());
		}

		if(resource == null) {
			createModel(sashModelURI.trimFileExtension());
		}
	}

	@Override
	public void createModel(URI uriWithoutExtension) {
		if(isLegacy(uriWithoutExtension)) {
			super.createModel(getSashModelStoreURI(uriWithoutExtension).trimFileExtension());
		} else {
			super.createModel(uriWithoutExtension);
		}
	}

	@Override
	public void setModelURI(URI uriWithoutExtension) {
		URI newURI;
		if(resourceURI != null && isLegacy(resourceURI)) {
			newURI = getLegacyURI(uriWithoutExtension);
		} else {
			newURI = getSashModelStoreURI(uriWithoutExtension);
		}

		super.setModelURI(newURI.trimFileExtension());
	}

	protected boolean isLegacy(URI uri) {
		if(uri == null) {
			return false;
		}
		return Objects.equal(uri.trimFileExtension(), getModelManager().getURIWithoutExtension());
	}

	/**
	 * Returns the sash model URI (With file extension)
	 *
	 * It may be either the Legacy URI (platform:/resource/model/model.di)
	 * or the 1.0.0 URI (file:/~workspace/.metadata/.plugins/org.eclipse.papyrus.infra.core/model/model.sash)
	 *
	 * @param uriWithoutExtension
	 * @return
	 * 
	 */
	protected URI getSashModelURI(URI uriWithoutExtension) {
		URIConverter converter = getModelManager().getURIConverter();
		URI legacyURI = getLegacyURI(uriWithoutExtension);

		//If the DI file exists and contains a SashWindowsMngr, this is a legacy model
		if(converter.exists(legacyURI, Collections.emptyMap())) {
			try {
				Resource diResource = getModelManager().getResource(legacyURI, true);
				if(DiUtils.lookupSashWindowsMngr(diResource) != null) {
					return legacyURI;
				}
			} catch (Exception ex) {
				//Temporary workaround: the DI file may exist and be empty
				//(DiModel is currently disabled and doesn't properly init the di file)
				//Log the error and continue
				Activator.log.error(ex);
			}
		}

		URI preferenceStoreURI = getSashModelStoreURI(uriWithoutExtension);

		return preferenceStoreURI;
	}

	protected URI getLegacyURI(URI uriWithoutExtension) {
		return uriWithoutExtension.appendFileExtension(MODEL_FILE_EXTENSION);
	}

	protected URI getSashModelStoreURI(URI uriWithoutExtension) {
		return providerManager.getSashModelProvider(uriWithoutExtension).getSashModelURI(uriWithoutExtension);
	}

	@Override
	protected Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = super.getSaveOptions();

		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.FALSE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.FALSE);

		return saveOptions;
	}

}
