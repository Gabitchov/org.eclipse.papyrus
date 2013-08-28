/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Replace workspace IResource dependency with URI for CDO compatibility
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.scope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.views.search.Activator;
import org.eclipse.papyrus.views.search.Messages;
import org.eclipse.papyrus.views.search.utils.ModelUtils;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.ui.IWorkingSet;

public class ScopeCollector implements IScopeCollector {

	private static final ScopeCollector instance = new ScopeCollector();

	private ScopeCollector() {
		super();
	}

	public final static ScopeCollector getInstance() {
		return ScopeCollector.instance;
	}

	/**
	 * @see org.eclipse.papyrus.views.search.scope.IScopeCollector#computeSearchScope(org.eclipse.search.ui.ISearchPageContainer)
	 * 
	 * @param container
	 * @return
	 */
	public Collection<URI> computeSearchScope(ISearchPageContainer container) {

		Set<URI> results = new HashSet<URI>();

		if(container == null) {
			results.addAll(createWorkspaceScope());

		} else {
			switch(container.getSelectedScope()) {
			case ISearchPageContainer.WORKSPACE_SCOPE:
			{
				results.addAll(createWorkspaceScope());
				break;
			}
			case ISearchPageContainer.SELECTION_SCOPE:
			{
				ISelection selection = container.getSelection();

				if(!selection.isEmpty()) {
					if(selection instanceof IStructuredSelection) {
						results.addAll(createSelectionScope((IStructuredSelection)selection));
					} else {
						//Do a workspace search instead
						results.addAll(createWorkspaceScope());
					}
				} else {
					//Do a workspace search instead
					results.addAll(createWorkspaceScope());
				}
				break;
			}
			case ISearchPageContainer.SELECTED_PROJECTS_SCOPE:
			{
				String[] projects = container.getSelectedProjectNames();
				results.addAll(createProjectsScope(projects));
				break;
			}
			case ISearchPageContainer.WORKING_SET_SCOPE:
			{
				IWorkingSet[] workingSets = container.getSelectedWorkingSets();
				results.addAll(createWorkingSetsScope(workingSets));
				break;
			}
			default:
			{
				break;
			}
			}
		}

		return results;

	}

	/**
	 * Create a scope when the container is ISearchPageContainer.SELECTION_SCOPE
	 * 
	 * @param selection
	 *        the selection of the container
	 * @return
	 *         the scope
	 */
	protected List<URI> createSelectionScope(IStructuredSelection selection) {
		List<URI> results = new ArrayList<URI>();

		Iterator<?> it = selection.iterator();
		while(it.hasNext()) {
			Object object = (Object)it.next();

			if(object instanceof IPapyrusFile) {
				results.addAll(findPapyrusModels(((IPapyrusFile)object).getMainFile()));
			} else if(object instanceof IResource) {
				results.addAll(findPapyrusModels((IResource)object));
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
								results.add(diResource.getURI());
							}
						} catch (ModelMultiException e) {
							//Do a workspace search instead
							results.addAll(createWorkspaceScope());
						} catch (NotFoundException e) {
							//Do a workspace search instead
							results.addAll(createWorkspaceScope());
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
						//Do a workspace search instead
						results.addAll(createWorkspaceScope());
					}

				} else {
					//Do a workspace search instead
					results.addAll(createWorkspaceScope());
				}

			}
		}
		return results;
	}

	/**
	 * Create a scope when the container is ISearchPageContainer.SELECTED_PROJECTS_SCOPE
	 * 
	 * @param projects
	 *        the selected scope
	 * @return
	 *         the scope
	 */
	protected List<URI> createProjectsScope(String[] projects) {
		List<URI> results = new ArrayList<URI>();

		for(String projectName : projects) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if(project.isOpen()) {
				results.addAll(findPapyrusModels(project));
			}
		}
		return results;
	}

	/**
	 * Create a scope when the container is ISearchPageContainer.WORKING_SET_SCOPE
	 * 
	 * @param workingSets
	 *        the selected workingSets
	 * @return
	 *         the scope
	 */
	protected List<URI> createWorkingSetsScope(IWorkingSet[] workingSets) {
		List<URI> results = new ArrayList<URI>();

		if(workingSets != null && workingSets.length > 0) {
			for(IWorkingSet iWorkingSet : workingSets) {
				for(IAdaptable element : iWorkingSet.getElements()) {
					Object resource = element.getAdapter(IResource.class);
					if(resource instanceof IResource) {
						results.addAll(findPapyrusModels((IResource)resource));
					}
				}
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
	protected Collection<URI> findPapyrusModels(IResource res) {
		ResourceVisitor visitor = new ResourceVisitor();
		try {
			res.accept(visitor, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			Activator.log.warn(Messages.ScopeCollector_0 + res);
		}

		return visitor.getParticipantURIs();
	}

	/**
	 * Create a scope when the container is ISearchPageContainer.WORKSPACE_SCOPE
	 * 
	 * @return
	 *         the scope
	 */
	protected Collection<URI> createWorkspaceScope() {

		//Go through the workspace root
		IResource root = ResourcesPlugin.getWorkspace().getRoot();

		return findPapyrusModels(root);
	}

}
