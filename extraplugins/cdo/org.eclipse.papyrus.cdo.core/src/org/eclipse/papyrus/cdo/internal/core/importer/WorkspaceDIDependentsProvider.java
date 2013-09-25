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
package org.eclipse.papyrus.cdo.internal.core.importer;

import static com.google.common.collect.Iterables.filter;
import static org.eclipse.papyrus.cdo.internal.core.importer.DependencyAdapter.getDIResource;
import static org.eclipse.papyrus.cdo.internal.core.importer.DependencyAdapter.isDIResource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.cdo.core.importer.IModelDependentsProvider;
import org.eclipse.papyrus.cdo.internal.core.Activator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

/**
 * This is the WorkspaceDIDependentsProvider type. Enjoy.
 */
public class WorkspaceDIDependentsProvider implements IModelDependentsProvider {

	private boolean completedScan;

	public WorkspaceDIDependentsProvider() {
		super();
	}

	public Collection<URI> getDependents(Resource resource, IProgressMonitor monitor) {

		if(!completedScan) {
			scanWorkspace(resource.getResourceSet());
		}

		Set<URI> result = Sets.newHashSet();

		// if it's a DI resource, get its dependencies' dependents and find
		// their dependents that are unique DIs
		Resource di = getDIResource(resource);
		if(di != null) {
			// the DI's dependencies are the model components
			for(Resource component : DependencyAdapter.getDependencies(di)) {
				// the components' dependents in other models are what we are
				// interested in
				for(Resource next : DependencyAdapter.getDependents(component)) {
					Resource dependentDI = getDIResource(next);
					if((dependentDI != null) && (dependentDI != di)) {
						result.add(dependentDI.getURI());
					}
				}
			}
		}

		return result;
	}

	public Collection<URI> getComponents(Resource diResource, IProgressMonitor monitor) {
		Collection<URI> result;

		if(!diResource.getURI().isPlatformResource()) {
			result = Collections.emptyList();
		} else {
			ImmutableList.Builder<URI> uris = ImmutableList.builder();

			final URI baseURI = diResource.getURI().trimSegments(1);
			final String baseName = diResource.getURI().trimFileExtension().lastSegment();
			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(diResource.getURI().toPlatformString(true)));
			final IContainer container = file.getParent();

			try {
				for(IFile next : filter(Arrays.asList(container.members()), IFile.class)) {
					if(!next.equals(file) && baseName.equals(next.getFullPath().removeFileExtension().lastSegment())) {
						uris.add(baseURI.appendSegment(next.getName()));
					}
				}
			} catch (CoreException e) {
				Activator.log.error("Could not determine components of model " + diResource.getURI(), e); //$NON-NLS-1$
			}

			result = uris.build();
		}

		return result;
	}

	private void scanWorkspace(final ResourceSet resourceSet) {
		completedScan = true;

		IResourceProxyVisitor visitor = new IResourceProxyVisitor() {

			public boolean visit(IResourceProxy proxy) throws CoreException {

				if((proxy.getType() == IResource.FILE) && proxy.getName().endsWith(".di")) { //$NON-NLS-1$

					String path = proxy.requestFullPath().toString();

					try {
						Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(path, true), true);

						if((resource != null) && isDIResource(resource)) {
							// it's a Papyrus model. Initialize the
							// dependencies
							DependencyAdapter.getInstance(resource);
						}
					} catch (Exception e) {
						// not a valid model resource. That's OK.
						Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(path, true), false);
						if(resource != null) {
							resource.unload();
							resourceSet.getResources().remove(resource);
							resource.eAdapters().clear();
						}
					}
				}

				return true;
			}
		};

		try {
			ResourcesPlugin.getWorkspace().getRoot().accept(visitor, 0);
		} catch (CoreException e) {
			// TODO: report to user?
			Activator.log.error(e);
		}
	}
}
