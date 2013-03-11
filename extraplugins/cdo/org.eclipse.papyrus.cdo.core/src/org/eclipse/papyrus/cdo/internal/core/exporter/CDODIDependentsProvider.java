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
package org.eclipse.papyrus.cdo.internal.core.exporter;

import static org.eclipse.papyrus.cdo.internal.core.importer.DependencyAdapter.getDIResource;
import static org.eclipse.papyrus.cdo.internal.core.importer.DependencyAdapter.isDIResource;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.cdo.core.importer.IModelDependentsProvider;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.importer.DependencyAdapter;

import com.google.common.collect.Sets;

/**
 * This is the WorkspaceDIDependentsProvider type. Enjoy.
 */
public class CDODIDependentsProvider implements IModelDependentsProvider {

	private boolean completedScan;

	public CDODIDependentsProvider() {
		super();
	}

	public Collection<URI> getDependents(Resource resource, IProgressMonitor monitor) {
		if(!completedScan) {
			// TODO Find a more efficient way to determine cross-references than walking the repository.  Don't walk, for now
			//scanRepository(resource.getResourceSet());
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

	@SuppressWarnings("unused")
	private void scanRepository(final ResourceSet resourceSet) {
		completedScan = true;

		TreeIterator<?> repositoryIterator = CDOUtils.getView(resourceSet).getRootResource().eAllContents();
		while(repositoryIterator.hasNext()) {
			CDOResourceNode next = (CDOResourceNode)repositoryIterator.next();
			if(next instanceof CDOResource) {
				CDOResource resource = (CDOResource)next;
				if(isDIResource(resource)) {
					// it's a Papyrus model. Initialize the dependencies
					DependencyAdapter.getInstance(resource);
				}
				repositoryIterator.prune();
			} else if(!(next instanceof CDOResourceFolder)) {
				repositoryIterator.prune();
			}
		}
	}
}
