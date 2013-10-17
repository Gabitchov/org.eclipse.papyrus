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
 *   Christian W. Damus (CEA LIST) - Extracted some of the ScopeCollector implementation.
 *   
 *****************************************************************************/
package org.eclipse.papyrus.views.search.scope;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.views.search.Activator;
import org.eclipse.papyrus.views.search.Messages;
import org.eclipse.papyrus.views.search.utils.ModelUtils;


/**
 * The most basic scope-provider implementation, getting scopes for workspace resources.
 */
public class WorkspaceScopeProvider implements IScopeProvider {

	public WorkspaceScopeProvider() {
		super();
	}

	public Collection<URI> getScope() {
		//Go through the workspace root
		IResource root = ResourcesPlugin.getWorkspace().getRoot();

		return findPapyrusModels(root);
	}

	public Collection<URI> getScope(Object object) {
		Collection<URI> results;

		if(object instanceof IPapyrusFile) {
			results = findPapyrusModels(((IPapyrusFile)object).getMainFile());
		} else if(object instanceof IResource) {
			results = findPapyrusModels((IResource)object);
		} else {
			Object element = BusinessModelResolver.getInstance().getBusinessModel(object);
			if(element instanceof EObject) {
				// CDO resource *are* EObjects
				Resource eResource = (element instanceof Resource) ? (Resource) element : ((EObject)element).eResource();
				if(eResource != null) {
					ModelSet modelSet = null;
					
					try {
						modelSet = ModelUtils.openResource(eResource.getURI());
						SashModel sashModel = (SashModel)modelSet.getModelChecked(SashModel.MODEL_ID);
						Resource diResource = sashModel.getResource();
						if (diResource != null) {
							results = Collections.singletonList(diResource.getURI());
						} else {
							results = Collections.emptyList();
						}
					} catch (ModelMultiException e) {
						results = Collections.emptyList();
					} catch (NotFoundException e) {
						results = Collections.emptyList();
					} finally {
						if (modelSet != null) {
							try {
								modelSet.unload();
							} catch (Exception e) {
								Activator.log.error(e);
							}
						}
					}
					
				} else {
					results = Collections.emptyList();
				}

			} else {
				results = Collections.emptyList();
			}

		}
		
		return results;
	}

	/**
	 * Find all Papyrus models from a specific root
	 * 
	 * @param res
	 *        the root
	 * @return
	 *         the found Papyrus models
	 */
	static Collection<URI> findPapyrusModels(IResource res) {
		ResourceVisitor visitor = new ResourceVisitor();
		try {
			res.accept(visitor, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			Activator.log.warn(Messages.ScopeCollector_0 + res);
		}

		return visitor.getParticipantURIs();
	}

}
