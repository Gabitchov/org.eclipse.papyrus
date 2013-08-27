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

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;

import com.google.common.collect.Sets;

/**
 * This is the DependencyAdapter type. Enjoy.
 */
public class DependencyAdapter extends AdapterImpl {

	private final Set<Resource> dependencies = Sets.newLinkedHashSet();

	private final Set<Resource> dependents = Sets.newLinkedHashSet();

	private DependencyAdapter() {
		super();
	}

	public static DependencyAdapter getInstance(Resource resource) {
		DependencyAdapter result = getExistingInstance(resource);

		if(result == null) {
			result = new DependencyAdapter();
			resource.eAdapters().add(Math.min(1, resource.eAdapters().size()), result);

			result.analyze(resource);
		}

		return result;
	}

	static DependencyAdapter getExistingInstance(Resource resource) {
		DependencyAdapter result = null;

		for(Object next : resource.eAdapters()) {
			if(next instanceof DependencyAdapter) {
				result = (DependencyAdapter)next;
				break;
			}
		}

		return result;
	}

	public Set<Resource> getDependencies() {
		return dependencies;
	}

	public static Set<Resource> getDependencies(Resource resource) {
		return getInstance(resource).getDependencies();
	}

	public Set<Resource> getDependents() {
		return dependents;
	}

	public static Set<Resource> getDependents(Resource resource) {
		return getInstance(resource).getDependents();
	}

	private void analyze(Resource resource) {
		for(Iterator<EObject> iter = EcoreUtil.getAllProperContents(resource, false); iter.hasNext();) {
			for(EObject xref : iter.next().eCrossReferences()) {
				Resource xrefRes = xref.eResource();
				if((xrefRes != null) && (isUserModelResource(xrefRes.getURI()))) {
					addDependency(xrefRes);
				}
			}
		}
	}

	private Resource getResource() {
		return (Resource)getTarget();
	}

	void addDependency(Resource resource) {
		Resource self = getResource();

		if((resource != self) && dependencies.add(resource)) {
			getInstance(resource).addDependent(self);
		}
	}

	private void addDependent(Resource resource) {
		if(resource != getResource()) {
			dependents.add(resource);
		}
	}

	boolean isUserModelResource(URI uri) {
		ModelSet modelSet = getModelSet();
		boolean result = (modelSet != null) ? modelSet.isUserModelResource(uri) :
		// config.hasResource(uri) &&
		uri.isPlatformResource() || uri.isFile() || CDOUtils.isCDOURI(uri);

		return result && !uri.isArchive();
	}

	private ModelSet getModelSet() {
		return CDOUtils.adapt(getResource().getResourceSet(), ModelSet.class);
	}

	public static boolean isDIResource(Resource resource) {
		boolean result = false;

		for(EObject next : resource.getContents()) {
			if(next instanceof SashWindowsMngr) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static Resource getDIResource(Resource resource) {
		Resource result = null;

		if(isDIResource(resource)) {
			result = resource;
		} else {
			// find the the DI resource
			ResourceSet rset = resource.getResourceSet();
			URI uri = resource.getURI().trimFileExtension().appendFileExtension(DiModel.DI_FILE_EXTENSION);
			if(rset.getURIConverter().exists(uri, null)) {
				Resource di = rset.getResource(uri, true);

				if((di != null) && isDIResource(di)) {
					result = di;
				}
			}
		}

		return result;
	}
}
