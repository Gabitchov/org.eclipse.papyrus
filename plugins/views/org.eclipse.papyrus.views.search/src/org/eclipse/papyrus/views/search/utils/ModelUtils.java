/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;

public class ModelUtils {

	public final static ModelSet openFile(IResource object) throws ModelMultiException {

		if(object instanceof IFile) {
			ModelSet modelSet = new ModelSet();
			ModelsReader reader = new ModelsReader();
			reader.readModel(modelSet);
			modelSet.loadModels((IFile)object);
			return modelSet;
		} else {
			return null;
		}
	}

	public final static IFile getIFile(Resource eResource) {
		URI eUri = eResource.getURI();
		if(eUri.isPlatformResource()) {
			String platformString = eUri.toPlatformString(true);
			IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if(resource instanceof IFile) {
				return (IFile)resource;
			}
		}
		return null;
	}
}
