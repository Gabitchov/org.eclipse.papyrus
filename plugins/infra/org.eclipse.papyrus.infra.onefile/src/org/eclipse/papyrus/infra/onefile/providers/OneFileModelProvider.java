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
package org.eclipse.papyrus.infra.onefile.providers;

import org.eclipse.core.internal.resources.mapping.SimpleResourceMapping;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.ModelProvider;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.resources.mapping.ResourceMappingContext;
import org.eclipse.core.resources.mapping.ResourceTraversal;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.infra.onefile.model.mapping.PapyrusResourceMapping;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;

@SuppressWarnings("restriction")
public class OneFileModelProvider extends ModelProvider {

	public static String MODEL_PROVIDER_ID = "org.eclipse.papyrus.infra.onefile.modelProvider";

	public OneFileModelProvider() {
	}

	@Override
	public ResourceMapping[] getMappings(IResource resource, ResourceMappingContext context, IProgressMonitor monitor) {
		if(OneFileUtils.isDi(resource)) {
			return new ResourceMapping[]{ new PapyrusResourceMapping((IFile)resource) };
		}
		return new ResourceMapping[]{ new SimpleResourceMapping(resource) };
	}

	@Override
	public ResourceMapping[] getMappings(IResource[] resources, ResourceMappingContext context, IProgressMonitor monitor) throws CoreException {
		return super.getMappings(resources, context, monitor);
	}

	@Override
	public ResourceTraversal[] getTraversals(ResourceMapping[] mappings, ResourceMappingContext context, IProgressMonitor monitor) throws CoreException {
		return super.getTraversals(mappings, context, monitor);
	}

	@Override
	public ResourceMapping[] getMappings(ResourceTraversal[] traversals, ResourceMappingContext context, IProgressMonitor monitor) throws CoreException {
		return super.getMappings(traversals, context, monitor);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		return super.getAdapter(adapter);
	}

}
