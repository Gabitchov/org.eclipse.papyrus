/*****************************************************************************
 * Copyright (c) 2010, 2014 LIFL, CEA LIST, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  LIFL - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 429242
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.history;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource;
import org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource;


/**
 * The trace model entry point that can be registered to
 * Trace model is used for the ControlMode.
 * This model is located in the same {@link Resource} than the {@link SashModel}. The SashModel is master
 * while this model is slave: it doesn't perform the save.
 * 
 * @author cedric dumoulin
 * 
 */
public class HistoryModel extends AbstractModelWithSharedResource<ControledResource> {

	/**
	 * File extension used for notation.
	 */
	public static final String MODEL_FILE_EXTENSION = "di"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.services.controlmode.history.HistoryModel"; //$NON-NLS-1$

	/**
	 * Identifier used to retrieve the model from the ModelManager
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getIdentifier()
	 * 
	 * @return
	 */
	@Override
	public String getIdentifier() {
		return MODEL_ID;
	}

	/**
	 * Get the extension used for TraceModel resources
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
	 * Return true if the provided object is a root of the model, false otherwise.
	 * This method should be implemented by subclasses.
	 * 
	 * @param object
	 * @return
	 */
	@Override
	protected boolean isModelRoot(EObject object) {
		return object instanceof ControledResource;
	}

	@Override
	public void loadModel(URI uriWithoutExtension) {
		// It is a common use case that this resource does not (and will not) exist
		if(exists(uriWithoutExtension)) {
			super.loadModel(uriWithoutExtension);
		}
	}

}
