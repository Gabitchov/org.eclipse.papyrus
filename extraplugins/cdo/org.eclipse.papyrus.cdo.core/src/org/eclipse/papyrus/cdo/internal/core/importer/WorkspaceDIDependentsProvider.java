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

import static org.eclipse.papyrus.cdo.internal.core.importer.DependencyAdapter.getDIResource;
import static org.eclipse.papyrus.cdo.internal.core.importer.DependencyAdapter.isDIResource;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.cdo.core.importer.IModelDependentsProvider;
import org.eclipse.papyrus.cdo.internal.core.Activator;

import com.google.common.collect.Sets;

/**
 * This is the WorkspaceDIDependentsProvider type. Enjoy.
 */
public class WorkspaceDIDependentsProvider
		implements IModelDependentsProvider {

	private boolean completedScan;

	public WorkspaceDIDependentsProvider() {
		super();
	}

	public Collection<URI> getDependents(Resource resource,
			IProgressMonitor monitor) {

		if (!completedScan) {
			scanWorkspace(resource.getResourceSet());
		}

		Set<URI> result = Sets.newHashSet();

		// if it's a DI resource, get its dependencies' dependents and find
		// their dependents that are unique DIs
		Resource di = getDIResource(resource);
		if (di != null) {
			// the DI's dependencies are the model components
			for (Resource component : DependencyAdapter.getDependencies(di)) {
				// the components' dependents in other models are what we are
				// interested in
				for (Resource next : DependencyAdapter.getDependents(component)) {
					Resource dependentDI = getDIResource(next);
					if ((dependentDI != null) && (dependentDI != di)) {
						result.add(dependentDI.getURI());
					}
				}
			}
		}

		return result;
	}

	private void scanWorkspace(final ResourceSet resourceSet) {
		completedScan = true;

		IResourceProxyVisitor visitor = new IResourceProxyVisitor() {

			public boolean visit(IResourceProxy proxy)
					throws CoreException {

				if ((proxy.getType() == IResource.FILE)
					&& proxy.getName().endsWith(".di")) {

					String path = proxy.requestFullPath().toString();

					try {
						Resource resource = resourceSet.getResource(
							URI.createPlatformResourceURI(path, true), true);

						if ((resource != null) && isDIResource(resource)) {
							// it's a Papyrus model. Initialize the
							// dependencies
							DependencyAdapter.getInstance(resource);
						}
					} catch (Exception e) {
						// not a valid model resource. That's OK.
						Resource resource = resourceSet.getResource(
							URI.createPlatformResourceURI(path, true), false);
						if (resource != null) {
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
