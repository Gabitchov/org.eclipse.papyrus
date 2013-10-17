/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.uml.search.internal.ui.scope;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.views.search.scope.IScopeProvider;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.google.common.collect.Lists;


/**
 * A scope provider for CDO model repositories.
 */
public class CDOScopeProvider implements IScopeProvider {

	public CDOScopeProvider() {
		super();
	}

	/**
	 * Gets the URIs of the root resource (implying the repository in its entirety) of all repositories that are currently connected.
	 */
	@Override
	public Collection<URI> getScope() {
		Collection<URI> result;

		final Collection<? extends IInternalPapyrusRepository> repos = PapyrusRepositoryManager.INSTANCE.getRepositories();
		if(repos.isEmpty()) {
			result = Collections.emptyList();
		} else {
			result = Lists.newArrayListWithCapacity(repos.size());
			for(IInternalPapyrusRepository next : repos) {
				if(next.isConnected()) {
					CDOView view = next.getMasterView();
					if(view != null) {
						result.add(view.getRootResource().getURI());
					}
				}
			}
		}

		return result;
	}

	@Override
	public Collection<URI> getScope(Object selected) {
		Collection<URI> result;

		// try to get the contextual resource node
		CDOResourceNode node = CDOUtils.adapt(selected, CDOResourceNode.class);
		if(node == null) {
			EObject obj = CDOUtils.adapt(selected, EObject.class);
			if(obj != null) {
				node = CDOUtils.adapt(obj.eResource(), CDOResource.class);
			}
		}

		if(node == null) {
			result = Collections.emptyList();
		} else {
			URI uri = node.getURI();
			if(!node.isRoot() && (node instanceof CDOResource)) {
				// ensure that we search the UML resource, not the notation or di
				uri = uri.trimFileExtension().appendFileExtension(UMLResource.FILE_EXTENSION);

				if(!uri.equals(node.getURI())) {
					// does the UML resource exist?  If not, don't try to search it
					String path = CDOURIUtil.extractResourcePath(uri);
					if(!node.cdoView().hasResource(path)) {
						uri = null;
					}
				}
			} else if((node instanceof CDOResourceFolder) && !uri.hasTrailingPathSeparator()) {
				uri = uri.appendSegment(""); //$NON-NLS-1$
			}

			result = (uri == null) ? Collections.<URI> emptyList() : Collections.singletonList(uri);
		}

		return result;
	}
}
