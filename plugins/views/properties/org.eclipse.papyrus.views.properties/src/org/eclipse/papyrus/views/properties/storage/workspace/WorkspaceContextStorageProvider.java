/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.storage.workspace;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.storage.AbstractContextStorageProvider;


/**
 * This is the WorkspaceContextStorageProvider type. Enjoy.
 */
public class WorkspaceContextStorageProvider extends AbstractContextStorageProvider {

	private ResourceSet resourceSet;

	public WorkspaceContextStorageProvider() {
		super();
	}

	public void initialize(ResourceSet resourceSet) throws CoreException {
		this.resourceSet = resourceSet;
	}

	public boolean providesFor(Context context) {
		Resource resource = context.eResource();
		return (resource != null) && resource.getURI().isPlatformResource() || resource.getURI().isFile();
	}

	public Collection<? extends Context> loadContexts() throws CoreException {
		List<Context> result = new java.util.ArrayList<Context>();

		IPath path = Activator.getDefault().getPreferencesPath();
		File preferencesDirectory = path.toFile();
		for(File contextDirectory : preferencesDirectory.listFiles()) {
			try {
				if(contextDirectory.isDirectory()) {
					Context context = loadCustomContext(contextDirectory);
					if(context != null) {
						result.add(context);
					}
				}
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}

		return result;
	}

	private Context loadCustomContext(File contextDirectory) throws IOException {
		Context result = null;

		String contextPath = contextDirectory.getPath() + "/" + contextDirectory.getName() + ".ctx"; //$NON-NLS-1$ //$NON-NLS-2$
		URI contextURI = URI.createFileURI(contextPath);

		EObject model = EMFHelper.loadEMFModel(resourceSet, contextURI);

		if(model instanceof Context) {
			result = (Context)model;
		}

		return result;
	}

}
