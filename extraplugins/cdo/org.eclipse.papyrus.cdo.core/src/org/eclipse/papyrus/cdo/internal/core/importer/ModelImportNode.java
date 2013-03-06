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

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.papyrus.cdo.core.importer.IModelImportNode;
import org.eclipse.papyrus.cdo.core.importer.IModelImportOperation;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/**
 * This is the ModelImportNode type. Enjoy.
 */
public class ModelImportNode
		implements IModelImportNode {

	private final ModelImportConfiguration config;

	private Resource resource;

	private String name;

	private Set<Resource> components = Sets.newLinkedHashSet();

	private Set<IModelImportNode> dependencies = Sets.newLinkedHashSet();

	private Set<IModelImportNode> dependents = Sets.newLinkedHashSet();

	public ModelImportNode(ModelImportConfiguration config, Resource resource) {
		super();

		this.config = config;
		this.resource = resource;
	}

	void initialize(IModelImportOperation.Context context) {

		context.run(new IModelImportOperation() {

			public Diagnostic run(IProgressMonitor monitor) {

				SubMonitor sub = SubMonitor.convert(monitor,
					"Calculating model dependencies ...", 2);

				components.add(resource);
				scanForComponents();
				sub.worked(1);

				scanForDependencies();
				sub.worked(1);

				sub.done();

				return Diagnostic.OK_INSTANCE;
			}
		});
	}

	public String getName() {
		if (name == null) {
			URI uri = getPrimaryResourceURI();

			String path = uri.path();
			if (uri.isPlatformResource()) {
				// trim the project segment
				path = path.substring(("/" + uri.segment(0)).length());
			} // else a file: URI's path does not include the device, so it's OK

			this.name = path;
		}

		return name;
	}

	Resource getPrimaryResource() {
		return resource;
	}

	public URI getPrimaryResourceURI() {
		return resource.getURI();
	}

	public Collection<URI> getResourceURIs() {
		ImmutableSet.Builder<URI> result = ImmutableSet.builder();

		for (Resource next : components) {
			result.add(next.getURI());
		}

		return result.build();
	}

	public Collection<IModelImportNode> getDependencies() {
		return Collections.unmodifiableSet(dependencies);
	}

	public Collection<IModelImportNode> getDependents() {
		return Collections.unmodifiableSet(dependents);
	}

	void addDependent(IModelImportNode node) {
		dependents.add(node);
	}

	@Override
	public int hashCode() {
		return getPrimaryResourceURI().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof IModelImportNode)
			&& getPrimaryResourceURI().equals(
				((IModelImportNode) obj).getPrimaryResourceURI());
	}

	@Override
	public String toString() {
		return String.format("ModelImportNode(%s)", getName());
	}

	private void scanForComponents() {
		Resource self = getPrimaryResource();
		for (Resource next : DependencyAdapter.getDependencies(self)) {
			if (DependencyAdapter.getDIResource(next) == self) {
				components.add(next);
			}
		}
	}

	private void scanForDependencies() {
		// for each component resource, find the external resources that it
		// references and, for any that seems to have a primary resource, get
		// its node

		URIConverter converter = resource.getResourceSet().getURIConverter();

		for (Resource component : components) {
			for (Resource xref : DependencyAdapter.getDependencies(component)) {
				URI primary = findPrimaryResource(xref.getURI(), converter);
				if ((primary != null) && converter.exists(primary, null)) {
					IModelImportNode node = config.getNode(primary);
					if ((node != null) && !node.equals(this)) {
						dependencies.add(node);
					}
				}
			}
		}
	}

	private URI findPrimaryResource(URI componentURI, URIConverter converter) {
		URI result = null;

		URI candidate = componentURI.trimFileExtension().appendFileExtension(
			DiModel.DI_FILE_EXTENSION);
		if (converter.exists(candidate, null)) {
			result = candidate;
		}

		return result;
	}
}
