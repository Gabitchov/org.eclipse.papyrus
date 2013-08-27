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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/**
 * This is the ModelTransferNode type. Enjoy.
 */
public class ModelTransferNode implements IModelTransferNode {

	private final ModelTransferConfiguration config;

	private Resource resource;

	private String name;

	private Set<Resource> components = Sets.newLinkedHashSet();

	private Set<IModelTransferNode> dependencies = Sets.newLinkedHashSet();

	private Set<IModelTransferNode> dependents = Sets.newLinkedHashSet();

	public ModelTransferNode(ModelTransferConfiguration config, Resource resource) {
		super();

		this.config = config;
		this.resource = resource;
	}

	void initialize(IModelTransferOperation.Context context) {

		context.run(new IModelTransferOperation() {

			public Diagnostic run(IProgressMonitor monitor) {
				SubMonitor sub = SubMonitor.convert(monitor, Messages.ModelTransferNode_0, 2);

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
		if(name == null) {
			URI uri = getPrimaryResourceURI();

			String path = uri.path();
			if(uri.isPlatformResource()) {
				// trim the project segment
				path = path.substring(("/" + uri.segment(0)).length()); //$NON-NLS-1$
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

		for(Resource next : components) {
			result.add(next.getURI());
		}

		return result.build();
	}

	public Collection<IModelTransferNode> getDependencies() {
		return Collections.unmodifiableSet(dependencies);
	}

	public Collection<IModelTransferNode> getDependents() {
		return Collections.unmodifiableSet(dependents);
	}

	void addDependent(IModelTransferNode node) {
		dependents.add(node);
	}

	@Override
	public int hashCode() {
		return getPrimaryResourceURI().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof IModelTransferNode) && getPrimaryResourceURI().equals(((IModelTransferNode)obj).getPrimaryResourceURI());
	}

	@Override
	public String toString() {
		return String.format("ModelTransferNode(%s)", getName()); //$NON-NLS-1$
	}

	void scanForComponents() {
		Resource self = getPrimaryResource();
		for(Resource next : DependencyAdapter.getDependencies(self)) {
			if(DependencyAdapter.getDIResource(next) == self) {
				components.add(next);
			}
		}
	}

	void scanForDependencies() {
		// for each component resource, find the external resources that it
		// references and, for any that seems to have a primary resource, get
		// its node

		URIConverter converter = resource.getResourceSet().getURIConverter();

		for(Resource component : components) {
			for(Resource xref : DependencyAdapter.getDependencies(component)) {
				URI primary = findPrimaryResource(xref.getURI(), converter);
				if((primary != null) && converter.exists(primary, null)) {
					IModelTransferNode node = config.getNode(primary);
					if((node != null) && !node.equals(this)) {
						dependencies.add(node);
					}
				}
			}
		}
	}

	private URI findPrimaryResource(URI componentURI, URIConverter converter) {
		URI result = null;

		URI candidate = componentURI.trimFileExtension().appendFileExtension(DiModel.DI_FILE_EXTENSION);
		if(converter.exists(candidate, null)) {
			result = candidate;
		}

		return result;
	}

	public boolean isModelParentUnit(IModelTransferNode other) {
		boolean result = false;

		out: for(URI childURI : getResourceURIs()) {
			Resource child = config.getResourceSet().getResource(childURI, false);
			if(child != null) {
				for(EObject root : child.getContents()) {
					EObject container = root.eContainer();
					if(container != null) {
						URI uri = EcoreUtil.getURI(container).trimFragment();
						if(other.getResourceURIs().contains(uri)) {
							// found the parent unit
							result = true;
							break out;
						}
					}
				}
			}
		}

		return result;
	}

	public boolean isModelSubUnit(IModelTransferNode other) {
		boolean result = false;

		out: for(URI uri : other.getResourceURIs()) {
			Resource possibleChild = config.getResourceSet().getResource(uri, false);
			if(possibleChild != null) {
				for(EObject root : possibleChild.getContents()) {
					EObject container = root.eContainer();
					if(container != null) {
						URI parentURI = EcoreUtil.getURI(container).trimFragment();
						if(getResourceURIs().contains(parentURI)) {
							// found a child unit
							result = true;
							break out;
						}
					}
				}
			}
		}

		return result;
	}
}
