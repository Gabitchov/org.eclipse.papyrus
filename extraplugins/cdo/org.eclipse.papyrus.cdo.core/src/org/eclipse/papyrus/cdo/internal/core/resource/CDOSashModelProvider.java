/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.core.resource;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.AbstractSashModelProvider;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;


/**
 * A CDO-specific sash model storage provider.
 */
public class CDOSashModelProvider extends AbstractSashModelProvider {

	private static final IPath SASH_MODEL_STORAGE_ROOT = Activator.getDefault().getStateLocation().append("sashidx"); //$NON-NLS-1$

	private IPath indexFolder;

	public CDOSashModelProvider() {
		super();
	}

	@Override
	public void initialize(ModelSet modelSet) {
		super.initialize(modelSet);

		CDOView view = CDOUtils.getView(modelSet);
		if(view != null) { // Model probably is in the workspace if null
			initialize(view);
		}
	}

	public CDOSashModelProvider initialize(CDOView view) {
		indexFolder = SASH_MODEL_STORAGE_ROOT.append(view.getSession().getRepositoryInfo().getUUID());
		return this;
	}

	@Override
	public URI getSashModelURI(URI userModelURI) {
		final URI uriWithoutExtension = userModelURI.trimFileExtension();

		IPath stateLocation = indexFolder.append(CDOURIUtil.extractResourcePath(uriWithoutExtension));

		return URI.createFileURI(stateLocation.toString()).appendFileExtension(SashModel.SASH_MODEL_FILE_EXTENSION);
	}

}
