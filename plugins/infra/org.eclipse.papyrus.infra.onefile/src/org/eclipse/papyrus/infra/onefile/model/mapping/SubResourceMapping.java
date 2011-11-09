/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.model.mapping;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.resources.mapping.ResourceMappingContext;
import org.eclipse.core.resources.mapping.ResourceTraversal;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.infra.onefile.model.ISubResourceFile;
import org.eclipse.papyrus.infra.onefile.providers.OneFileModelProvider;

public class SubResourceMapping extends ResourceMapping {
	private final ISubResourceFile file;

	public SubResourceMapping(ISubResourceFile adaptableObject) {
		this.file = adaptableObject;
	}

	@Override
	public Object getModelObject() {
		return file;
	}

	@Override
	public String getModelProviderId() {
		return OneFileModelProvider.MODEL_PROVIDER_ID;
	}

	@Override
	public IProject[] getProjects() {
		return new IProject[] { file.getProject() };
	}

	@Override
	public ResourceTraversal[] getTraversals(ResourceMappingContext context,
			IProgressMonitor monitor) throws CoreException {
		// if (ResourceMappingContext.LOCAL_CONTEXT == context)
		// {
		// return new ResourceTraversal[]{new ResourceTraversal(new
		// IResource[]{papyrusFile.get()}, IResource.DEPTH_ONE,
		// IResource.NONE)};
		// }
		// else
		// {
		return new ResourceTraversal[] { new ResourceTraversal(
				new IResource[] { file.getFile() }, IResource.DEPTH_INFINITE,
				IResource.NONE) };
		// }

	}

	@Override
	public void accept(ResourceMappingContext context,
			IResourceVisitor visitor, IProgressMonitor monitor)
			throws CoreException {
		super.accept(context, visitor, monitor);
	}
}
